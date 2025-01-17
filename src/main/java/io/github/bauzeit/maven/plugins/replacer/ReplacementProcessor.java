package io.github.bauzeit.maven.plugins.replacer;

import static org.apache.commons.lang3.StringUtils.isEmpty;

import java.io.IOException;
import java.util.List;

import io.github.bauzeit.maven.plugins.replacer.file.FileUtils;

public class ReplacementProcessor {
	private final FileUtils fileUtils;
	private final ReplacerFactory replacerFactory;

	public ReplacementProcessor(FileUtils fileUtils, ReplacerFactory replacerFactory) {
		this.fileUtils = fileUtils;
		this.replacerFactory = replacerFactory;
	}
	
	public void replace(List<Replacement> replacements, boolean regex, String file,
			String outputFile, int regexFlags, String encoding) throws IOException {
		String content = fileUtils.readFile(file, encoding);
		for (Replacement replacement : replacements) {
			content = replaceContent(regex, regexFlags, content, replacement);
		}

		fileUtils.writeToFile(outputFile, content, encoding);
	}

	private String replaceContent(boolean regex, int regexFlags, String content, Replacement replacement) {
		if (isEmpty(replacement.getToken())) {
			throw new IllegalArgumentException("Token or token file required");
		}

		Replacer replacer = replacerFactory.create(replacement);
		return replacer.replace(content, replacement, regex, regexFlags);
	}
}
