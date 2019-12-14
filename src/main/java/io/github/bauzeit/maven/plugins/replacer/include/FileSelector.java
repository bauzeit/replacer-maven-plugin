package io.github.bauzeit.maven.plugins.replacer.include;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.tools.ant.DirectoryScanner;

public class FileSelector {

	public List<String> listIncludes(String basedir, List<String> includes, List<String> excludes) {
		if (includes == null || includes.isEmpty()) {
			return Collections.emptyList();
		}

		DirectoryScanner directoryScanner = new DirectoryScanner();
		directoryScanner.addDefaultExcludes();
		directoryScanner.setBasedir(new File(basedir));
		directoryScanner.setIncludes(includes.toArray(new String[0]));
		directoryScanner.setExcludes(excludes == null ? null : excludes.toArray(new String[0]));

		directoryScanner.scan();
		return Arrays.asList(directoryScanner.getIncludedFiles());
	}

}
