package com.whiuk.philip.eesa.file;

import java.io.File;
import java.util.ArrayList;

import org.apache.commons.io.FilenameUtils;


/**
 * Handles the existence of file loaders.
 * @author Philip Whitehouse
 *
 */
public final class FilePluginManager {
	/**
	 * Private default constructor - utility class.
	 */
	private FilePluginManager() {
	}
	/**
	 * 
	 */
	private static ArrayList<FileLoader> fileLoaders;
	
	/**
	 * 
	 * @param l
	 */
	public static void registerFileLoader(final FileLoader l) {
		if (!fileLoaders.contains(l)) {
			fileLoaders.add(l);
		}		
	}

	/**
	 * 
	 * @param l
	 */
	public static void deregisterFileLoader(final FileLoader l) {
		fileLoaders.remove(l);
	}
	
	/**
	 * 
	 * @param file The file to get the loader for
	 * @return matching file loader
	 * @throws UnsupportedFileTypeException Indicates file type was unsupported
	 */
	public static FileLoader getFileLoader(final File file)
			throws UnsupportedFileTypeException {
		String ext = FilenameUtils.getExtension(file.getName());
		for (FileLoader loader : fileLoaders) {
			if (loader.canLoad(ext)) {
				return loader;
			}
		}
		throw new UnsupportedFileTypeException(file, ext);
	}

}
