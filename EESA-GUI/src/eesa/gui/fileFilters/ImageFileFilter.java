package eesa.gui.fileFilters;

import eesa.file.FileUtilities;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The file filter used to limit the display of files to a specific image format.
 * @author Philip
 */
public class ImageFileFilter extends javax.swing.filechooser.FileFilter {
    /**
     * 
     */
    private List<String> supportedExtensions;
	/**
	 * 
	 */
    private ArrayList<String> enabledExtensions;
	/**
	 * 
	 */
    private String description;
   
    /**
     * 
     * @param d description
     * @param e supportedExtensions  
     */
    public ImageFileFilter(final String d,
    		final String[] e) {
        this.supportedExtensions = Arrays.asList(e);
        enabledExtensions = new ArrayList<String>();        
    }

    @Override
	public final String getDescription() {
            return description;
    }    
    /**
     * 
     * @param extension
     * @return
     */
    public final boolean supports(final String extension) {
        return supportedExtensions.contains(extension);
    }
    /**
     * 
     * @param extension
     */
    public final void addFormatName(final String extension) {
       enabledExtensions.add(extension);
    }
    /**
     * 
     * @return 
     */
    public final String getEnabledFormatName() {
        return enabledExtensions.get(0);
    } 
    /**
     * 
     * @param f
     * @return 
     */
    @Override
	public final boolean accept(final File f) {
        if (f.isDirectory()) {
            return true;
        }
        String fileExtension = FileUtilities.getExtension(f);
        if (fileExtension != null) {
            return supportedExtensions.contains(fileExtension);
        }
        return false;
    }    
}
