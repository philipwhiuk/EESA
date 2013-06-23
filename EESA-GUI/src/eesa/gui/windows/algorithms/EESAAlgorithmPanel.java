package eesa.gui.windows.algorithms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPanel;

import eesa.algorithms.EESAAlgorithm;
import eesa.core.Main;
import eesa.core.Simulation;
import eesa.gui.Application;
import eesa.gui.help.HelpManager;
import eesa.gui.windows.AddTestWindow;

public abstract class EESAAlgorithmPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Class logger.
	 */
	private static Logger logger =
			Logger.getLogger(EESAAlgorithmPanel.class.getName());

	/**
	 * 
	 */
	private static List<EESAAlgorithmPanel> eesaAlgorithmPanelsList;
	
	/**
	 * 
	 * @return
	 */
	public static EESAAlgorithmPanel[] getEESAAlgorithmPanels() {
        if (eesaAlgorithmPanelsList == null) {
        	eesaAlgorithmPanelsList = new ArrayList<EESAAlgorithmPanel>();
            String algorithmClass;
            File file = new File(Main.getProperties().getProperty("eesaGUIFile"));
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                algorithmClass = br.readLine();
                if (algorithmClass != null) {
                    do {
                        try {
                        	eesaAlgorithmPanelsList.add((EESAAlgorithmPanel) Class.
                            		forName(algorithmClass).newInstance());
                        } catch (ClassNotFoundException ex) {
                        	logger.log(Level.INFO,
                        			"Algorithm Class Not Found: {0}",
                        			algorithmClass);
                        } catch (InstantiationException ex) {
                        	logger.log(Level.INFO,
                    			"Algorithm Class Couldn't Be Instantiated: {0}",
                    			algorithmClass);
                        } catch (IllegalAccessException ex) {
                        	logger.log(Level.INFO,
                    			"Algorithm Class Couldn''t Be Accessed: {0}",
                    			algorithmClass);
                        } catch (ClassCastException ex) {
                        	logger.log(Level.INFO,
                    			"Algorithm Class Couldn''t Be Cast: {0}",
                    			algorithmClass);
                        }       
                        algorithmClass = br.readLine();
                    } while(algorithmClass != null);
                }
            } catch (FileNotFoundException ex) {
                try {
                	logger.log(Level.WARNING,
                			"FileNotFound: {0}",
                			file.getCanonicalPath());
                } catch (IOException ex1) {
                	logger.log(Level.SEVERE, null, ex1);
                }
                logger.log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
            	logger.log(Level.SEVERE, null, ex);
            }
        }
        return eesaAlgorithmPanelsList.toArray(new EESAAlgorithmPanel[]{});
	}
	/**
	 * 
	 * @return
	 */
	public abstract EESAAlgorithm getAlgorithm();

	@Override
	public String toString() {
		return getAlgorithm().toString();
	}

}
