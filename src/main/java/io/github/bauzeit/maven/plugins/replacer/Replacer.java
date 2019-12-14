package io.github.bauzeit.maven.plugins.replacer;



public interface Replacer {
	String replace(String content, Replacement replacement, boolean regex, int regexFlags);
}
