package io.github.bauzeit.maven.plugins.replacer.file;

import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.io.File;
import java.io.IOException;

public class FileUtils {
	public boolean fileNotExists(String filename) {
		return isBlank(filename) || !new File(filename).exists();
	}

	public String readFile(String file, String encoding) throws IOException {
		return org.apache.commons.io.FileUtils.readFileToString(new File(file), encoding);
	}

	public void writeToFile(String outputFile, String content, String encoding) throws IOException {
		File file = new File(outputFile);
		org.apache.commons.io.FileUtils.forceMkdirParent(file);
		org.apache.commons.io.FileUtils.writeStringToFile(file, content, encoding);
	}
	
	public String createFullPath(String... dirsAndFilename) {
		StringBuilder fullPath = new StringBuilder();
		for (int i=0; i < dirsAndFilename.length - 1; i++) {
			if (isNotBlank(dirsAndFilename[i])) {
				fullPath.append(dirsAndFilename[i]);
				fullPath.append(File.separator);
			}
		}
		String last = dirsAndFilename[dirsAndFilename.length - 1];
		if (last != null) {
			fullPath.append(last);
		}
		
		return fullPath.toString();
	}

	public boolean isAbsolutePath(String file) {
		return new File(file).isAbsolute();
	}
}
