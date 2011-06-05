package aspectsjlo.translate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import jnome.core.language.Java;
import jnome.input.JavaFactory;
import jnome.output.JavaCodeWriter;

import org.rejuse.java.collections.Visitor;

import subobjectjava.model.language.JLo;
import aspectsjava.output.AspectsCodeWriter;
import aspectsjlo.model.language.AspectsJLo;
import chameleon.aspects.Aspect;
import chameleon.core.compilationunit.CompilationUnit;
import chameleon.core.element.Element;
import chameleon.core.lookup.LookupException;
import chameleon.exception.ModelException;
import chameleon.oo.plugin.ObjectOrientedFactory;
import chameleon.plugin.build.BuildProgressHelper;
import chameleon.plugin.output.Syntax;
import chameleon.support.translate.IncrementalTranslator;

public class IncrementalJavaTranslator extends IncrementalTranslator<AspectsJLo, JLo> {
	
	public IncrementalJavaTranslator(AspectsJLo source, JLo target) {
		super(source, target);
		
		AspectsJLo internalTarget = new AspectsJLo();
		internalTarget.setPlugin(Syntax.class, new AspectsCodeWriter());
		
		Java java = new Java();
		java.setPlugin(Syntax.class, new JavaCodeWriter());
		java.setPlugin(ObjectOrientedFactory.class, new JavaFactory());
		
		_weaveTranslator = new WeaveTranslator(source, internalTarget);
		_jloTranslator = new subobjectjava.translate.IncrementalJavaTranslator(target, java);
	}
	
	private WeaveTranslator _weaveTranslator;
	private subobjectjava.translate.IncrementalJavaTranslator _jloTranslator;
	
	// Weaving!
	public Map<CompilationUnit, CompilationUnit> weave(List<CompilationUnit> allProjectCompilationUnits, BuildProgressHelper buildProgressHelper) throws LookupException {
		return _weaveTranslator.build(allProjectCompilationUnits, buildProgressHelper);
	}
	
	// TODO: refactor into several methodes

	public Collection<CompilationUnit> build(List<CompilationUnit> allProjectCompilationUnits, BuildProgressHelper buildProgressHelper) throws ModelException {
		List<CompilationUnit> finalResult = new ArrayList<CompilationUnit>();
		
		// Step 1: make sure the default namespaces etc. are available to the JLo builder
		initTargetLanguage(); // Source language is AspectJLo, target language is JLo
		
		// Step 2: Weave the model. To prevent doubles, we have to know the translation between original sources and transformed.
		Map<CompilationUnit, CompilationUnit> wovenCompilationUnits = weave(allProjectCompilationUnits, buildProgressHelper);
		
		// Step 3: convert the woven model to a JLo model
		List<CompilationUnit> JLoCompilationUnits = new ArrayList<CompilationUnit>();
		for (Entry<CompilationUnit, CompilationUnit> wovenCompilationUnit : wovenCompilationUnits.entrySet()) {
			// Don't use 'implementationCompilationUnit', manually transform/store because the source is different
			CompilationUnit source = wovenCompilationUnit.getKey();
			CompilationUnit target = wovenCompilationUnit.getValue();
			
			// Don't let JLo build aspect classes, JLo can't handle them properly at the moment. A bug due to the static methodes? Who knows. Check this <- TODO
			if (source.hasDescendant(Aspect.class)) {
				
				// Remove the aspect itself though 
				new Visitor<Aspect>() {

					@Override
					public void visit(Aspect element) {
						element.disconnect();
					}
					
				}.applyTo(target.descendants(Aspect.class));

				// Do not build it with JLo, just add it directly to the final result
				finalResult.add(target);
				buildProgressHelper.addWorked(1);
			} else {
				CompilationUnit JLoClone = target.cloneTo(targetLanguage());
				store(source, JLoClone);
				
				// Step 4: Reset the 'origins' - this way the JLo builder doesn't 'know' it is working on a cloned model instead of a fresh one
				JLoClone.setOrigin(JLoClone);
				new Visitor<Element>() {
	
					@Override
					public void visit(Element element) {
						element.setOrigin(element);
					}
					
				}.applyTo(JLoClone.descendants());
				
				JLoCompilationUnits.add(JLoClone);
			}
		}
		
		try {
			// Step 5: JLo-rebuild the entire project (all woven CUs)
			int i = 0;
			for (CompilationUnit JLoCompilationUnit : JLoCompilationUnits) {
				buildProgressHelper.checkForCancellation();
				System.out.println("JLo - building: " + ++i);
				finalResult.addAll(_jloTranslator.build(JLoCompilationUnit, JLoCompilationUnits));
				buildProgressHelper.addWorked(1);
			}
			System.out.println("--- Finished!");
		} catch(Error e) {
			e.printStackTrace();
			throw e;
		} catch(RuntimeException e) {
			e.printStackTrace();
		}
		
		return finalResult;
	}
}
