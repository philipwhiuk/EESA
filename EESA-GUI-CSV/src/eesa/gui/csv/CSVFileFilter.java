package eesa.gui.csv;

import eesa.file.FileUtilities;

import java.io.File;

/**
 * The file filter used to limit the display of files to the CSV format.
 * @author Philip
 */
public class CSVFileFilter extends javax.swing.filechooser.FileFilter {
    /**
     * 
     */
    public static final String EXTENSION = "csv";

    @Override
	public final boolean accept(final File f) {
        if (f.isDirectory()) {
            return true;
        }
        String fileExtension = FileUtilities.getExtension(f);
        if (fileExtension != null) {
            return fileExtension.equalsIgnoreCase(CSVFileFilter.EXTENSION);
        }
        return false;
    }

    @Override
	public final String getDescription() {
            return "Comma Seperated Value (CSV) files";
    }
}
