package eesa.gui.xml.fileFilters;


import eesa.file.FileUtilities;

import java.io.File;

/**
 * The file filter used to limit the display of files to the ESA format.
 * @author Philip
 */
public class ESAFileFilter extends javax.swing.filechooser.FileFilter {
    /**
     * 
     */
    public static final String EXTENSION = "esa";
    @Override
	public final boolean accept(final File f) {
        if (f.isDirectory()) {
            return true;
        }
        String ext = FileUtilities.getExtension(f);
        if (ext != null) {
            return ext.equals(ESAFileFilter.EXTENSION);
        }
        return false;
    }

    @Override
    public final String getDescription() {
        return "ESA Save File (." + EXTENSION + ")";
    }

}
