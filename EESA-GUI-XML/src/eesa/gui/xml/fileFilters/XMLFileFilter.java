package eesa.gui.xml.fileFilters;


import java.io.File;

import com.whiuk.philip.eesa.file.FileUtilities;

/**
 * The file filter used to limit the display of files to the XML format.
 * @author Philip
 */
public class XMLFileFilter extends javax.swing.filechooser.FileFilter {
    /**
     * 
     */
    public static final String EXTENSION = "xml";

    @Override
	public final boolean accept(final File f) {
        if (f.isDirectory()) {
            return true;
        }
        String fileExtension = FileUtilities.getExtension(f);
        if (fileExtension != null) {
            return fileExtension.equalsIgnoreCase(XMLFileFilter.EXTENSION);
        }
        return false;
    }

    @Override
	public final String getDescription() {
            return "Extensible Markup Language [XML] (." + EXTENSION + ") files";
    }
}
