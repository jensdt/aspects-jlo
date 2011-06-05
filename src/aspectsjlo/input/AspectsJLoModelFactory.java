package aspectsjlo.input;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import jnome.input.JavaModelFactory;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;

import subobjectjava.output.JLoSyntax;
import aspectsjlo.model.language.AspectsJLo;
import chameleon.input.ModelFactory;
import chameleon.input.ParseException;
import chameleon.oo.language.ObjectOrientedLanguage;
import chameleon.plugin.output.Syntax;
import chameleon.support.input.ChameleonParser;
import chameleon.support.input.ModelFactoryUsingANTLR;

public class AspectsJLoModelFactory extends JavaModelFactory {
	/**
	 * BE SURE TO CALL INIT() IF YOU USE THIS CONSTRUCTOR.
	 * 
	 * @throws IOException
	 * @throws ParseException
	 */
	public AspectsJLoModelFactory() {
		AspectsJLo lang = new AspectsJLo();
		lang.setPlugin(Syntax.class, new JLoSyntax());
		setLanguage(lang, ModelFactory.class);
	}
	
	/**
	 * BE SURE TO CALL INIT() IF YOU USE THIS CONSTRUCTOR.
	 * 
	 * @throws IOException
	 * @throws ParseException
	 */
	public AspectsJLoModelFactory(AspectsJLo language) throws IOException, ParseException {
		super(language);
	}
	
	
	/**
	 * Initialize a new Java model factory with the given collection of base classes.
	 * All predefined elements of the language will be initialized. 
	 */
	public AspectsJLoModelFactory(Collection<File> base) throws IOException, ParseException {
		this(new AspectsJLo(), base);
	}
	
	//FIXME: Object and String must be parsed.
	public AspectsJLoModelFactory(AspectsJLo language, Collection<File> base) throws IOException, ParseException {
		super(language, base);
	}

	@Override
	  public ChameleonParser getParser(InputStream inputStream, String fileName) throws IOException {
	    ANTLRInputStream input = new ANTLRInputStream(inputStream);
	    AspectJLoLexer lexer = new AspectJLoLexer(input);
	    CommonTokenStream tokens = new CommonTokenStream(lexer);
	    Parser parser = new Parser(tokens);
	    parser.setLanguage((ObjectOrientedLanguage) language());
	    return parser;
	  }
	
  @Override
	public ModelFactoryUsingANTLR clone() {
		try {
			AspectsJLoModelFactory result = new AspectsJLoModelFactory();
			return result;
		} catch (Exception e) {
			throw new RuntimeException("Exception while cloning a JavaModelFactory", e);
		}
	}
}
