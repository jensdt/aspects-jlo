package aspectsjlo.input;

import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.TokenStream;

import subobjectjava.input.JLoFactory;

public class Parser extends AspectJLoParser {

	public Parser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
		setFactory(new JLoFactory());
	}

	public Parser(TokenStream input) {
		super(input);
		setFactory(new JLoFactory());
	}

}

