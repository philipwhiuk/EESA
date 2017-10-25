package com.whiuk.philip.eesa.file;
import java.io.File;
import java.io.IOException;


/**
 * Provides a variety of utility functions used in file management.
 * @author Philip Whitehouse
 *
 */
public class FileUtilities {
	/**
	 * Utility class
	 */
	private FileUtilities() {		
	}
    /**
     * Returns the extension of a file.
     * @param f
     * @return 
     */
    public static String getExtension(final File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');
 
        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i + 1).toLowerCase();
        }
        return ext;
    }  
    /**
     * Ensures the file has the correct extension.
     * @param f
     * @return
     * @throws IOException  
     */
    public static File fixFileExtension(final File f, String ext)
    		throws IOException {
        File folder = f.getParentFile();
        String extension = getExtension(f);
        if (extension == null || !extension.equals(ext)) {
            return new File(folder.getCanonicalPath() 
            		+ File.separator + f.getName() 
            		+ "." + ext);
        } else {
            return f;
        }
    }    
}
