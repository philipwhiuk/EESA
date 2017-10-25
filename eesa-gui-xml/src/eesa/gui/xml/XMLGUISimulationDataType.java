package eesa.gui.xml;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.whiuk.philip.eesa.file.FileUtilities;

import com.whiuk.philip.eesa.core.Simulation;
import com.whiuk.philip.eesa.exceptions.SimulationLoadingException;
import com.whiuk.philip.eesa.exceptions.SimulationSavingException;
import eesa.gui.Application;
import eesa.gui.dataSource.GUISimulationDataType;
import eesa.gui.xml.fileFilters.ESAFileFilter;
import com.whiuk.philip.eesa.xml.XMLSimulationDataSource;
import com.whiuk.philip.eesa.xml.XMLSimulationDataType;

/**
 * Provides the GUI interface to load and save simulations via XML.
 * @author Philip Whitehouse
 *
 */
public class XMLGUISimulationDataType extends GUISimulationDataType {
	
	/**
	 * Required static method for {@link GUISimulationDataType}.
	 * @return Simulation
	 * @throws SimulationLoadingException exception
	 */
	public static final Simulation loadSimulationViaGUI() 
			throws SimulationLoadingException {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
        "ESA Save Files", "esa");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(Application.getApplication());
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            Logger.getLogger(Application.class.getName()).log(Level.INFO, 
            		"You chose to open this file: {0}",
            		chooser.getSelectedFile().getName());
            return XMLSimulationDataType.load(
            		new XMLSimulationDataSource(
            				chooser.getSelectedFile()));
        }
        return null;
	}

    /**
     * 
     * @param sim Simulation to save
     * @throws SimulationSavingException 
     */
    public static final void saveSimulationAsViaGUI(
    		final Simulation sim) 
    		throws SimulationSavingException {
        JFileChooser chooser = new JFileChooser();
        chooser.addChoosableFileFilter(new ESAFileFilter());
        chooser.setAcceptAllFileFilterUsed(false);
        int returnVal = chooser.showSaveDialog(Application.getApplication());
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                File f = FileUtilities.fixFileExtension(
                		chooser.getSelectedFile(), ESAFileFilter.EXTENSION);
                Logger.getLogger("eesa.gui.Simulator").log(
                		Level.INFO,
                		"You chose to save to this file: {0}",
                		f.getCanonicalPath());
                if (f.exists()) {
					int n = JOptionPane.showConfirmDialog(
							Application.getApplication(),
	                		"The file you selected already exists. "
	        				+ "Would you like to overwrite it?");
	                if (n == JOptionPane.NO_OPTION) {
	                    throw new SimulationSavingException(
	                    		"Please select a different file.");
	                }
				}             
                XMLSimulationDataType.save(sim, new XMLSimulationDataSource(f));
            } catch (IOException ex) {
                throw new SimulationSavingException(ex);
            }
        }        
    }

    /**
     * Saves the given simulation.
     * @param sim Simulation to save
     * @throws SimulationSavingException 
     */
    public static void saveSimulationViaGUI(final Simulation sim) 
    		throws SimulationSavingException {
    	try {
    		if (sim.getDataSource() != null) {
    			if (sim.getDataSource() instanceof XMLSimulationDataSource) {
    				XMLSimulationDataSource s = 
    						(XMLSimulationDataSource) sim.getDataSource();
    				if (s.getFile() != null) {
    					File f = s.getFile();
    					if (s.getFile().exists() && !s.getFile().canWrite()) {
    						throw new SimulationSavingException(
    								"Unable to write changes to the file.");
    					} else if (!s.getFile().exists()) {
    						//Somehow we've set a file but not written it.
    						s.getFile().createNewFile();
    		                if (!(s.getFile().canWrite() 
    		                		&& s.getFile().canRead())) {
    		                    throw new SimulationSavingException(
    		                		"Created a new file but unable to read "
    		                    		+ "or write to it!");
    		                }
    					}
    	                XMLSimulationDataType.save(sim, s);
    				}
    			} else {
    				saveSimulationAsViaGUI(sim);
    			}
    		} else {
    			saveSimulationAsViaGUI(sim);
    		}
            Logger.getLogger("eesa.gui.Simulator")
            .log(Level.INFO, "Saved file");
        } catch (IOException e) {   
            throw new SimulationSavingException(e);
        }
    }

	
}
