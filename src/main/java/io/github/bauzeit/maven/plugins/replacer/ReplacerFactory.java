package io.github.bauzeit.maven.plugins.replacer;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;


public class ReplacerFactory {
	public Replacer create(Replacement replacement) {
		TokenReplacer tokenReplacer = new TokenReplacer();
		
		if (isNotEmpty(replacement.getXpath())) {
			return new XPathReplacer(tokenReplacer);
		}
		return tokenReplacer;
	}

}
