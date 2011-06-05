package aspectsjlo.build;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import jnome.output.CompilationUnitWriter;
import subobjectjava.input.JLoFactory;
import subobjectjava.model.language.JLo;
import subobjectjava.output.JLoSyntax;
import aspectsjlo.model.language.AspectsJLo;
import aspectsjlo.translate.IncrementalJavaTranslator;
import chameleon.core.compilationunit.CompilationUnit;
import chameleon.core.language.Language;
import chameleon.exception.ChameleonProgrammerException;
import chameleon.exception.ModelException;
import chameleon.oo.plugin.ObjectOrientedFactory;
import chameleon.plugin.Plugin;
import chameleon.plugin.PluginImpl;
import chameleon.plugin.build.BuildProgressHelper;
import chameleon.plugin.build.Builder;
import chameleon.plugin.output.Syntax;

public class AspectsBuilder extends PluginImpl implements Builder {
	
	public AspectsBuilder(AspectsJLo source, File outputDir) {
		this(outputDir);
		setLanguage(source, Builder.class);
	}
	
	public AspectsBuilder(File outputDir) {
		_writer = new CompilationUnitWriter(outputDir, ".java");
	}
	
	public CompilationUnitWriter writer() {
		return _writer;
	}

	CompilationUnitWriter _writer;
	
	@Override
	public <T extends Plugin> void setLanguage(Language lang, Class<T> pluginInterface) {
		if(! (lang instanceof AspectsJLo)) {
			throw new ChameleonProgrammerException();
		}
		super.setLanguage(lang, pluginInterface);
		
		JLo jlo  = new JLo();
		jlo.setPlugin(Syntax.class, new JLoSyntax());
		jlo.setPlugin(ObjectOrientedFactory.class, new JLoFactory());

		_translator = new IncrementalJavaTranslator((AspectsJLo) lang, jlo);
	}

	private IncrementalJavaTranslator _translator;

	@Override
	public Plugin clone() {
		return new AspectsBuilder(_writer.outputDir());
	}

	@Override
	public void build(List<CompilationUnit> compilationUnits, List<CompilationUnit> allProjectCompilationUnits,	BuildProgressHelper buildProgressHelper) throws ModelException,	IOException {
		System.out.println("GC");
		System.gc();
		System.out.println("GC finished");
		try {
			Collection<CompilationUnit> cus = _translator.build(allProjectCompilationUnits, buildProgressHelper);
			
			for (CompilationUnit translated : cus)
				_writer.write(translated);
			
		} catch(Error e) {
			e.printStackTrace();
			throw e;
		} catch(RuntimeException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int totalAmountOfWork(List<CompilationUnit> compilationUnits, List<CompilationUnit> allProjectCompilationUnits) {
		return allProjectCompilationUnits.size()*2; // Once for the aspect builder, once for the JLo builder
	}
}
