package aspectsjlo.model.language;

import aspectsjava.model.language.AspectsJava;
import chameleon.core.language.Language;


public class AspectsJLo extends AspectsJava  {
	public AspectsJLo() {
		this("AspectsJLo");
	}

	protected AspectsJLo(String name) {
		super(name);
	}

	@Override
	protected Language cloneThis() {
		return new AspectsJLo();
	}
}
