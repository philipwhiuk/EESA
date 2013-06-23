package eesa.algorithms; 

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import eesa.core.JobSet;
import eesa.core.Main;
import eesa.core.Processor;
import eesa.core.Test;
import eesa.core.TestResult;
import eesa.exceptions.AlgorithmException;

/**
 * Provides an interface for algorithms which perform EESA functionality.
 * @author Philip
 */
public abstract class EESAAlgorithm implements Algorithm {
	/**
	 * Class logger.
	 */
	private static Logger logger =
			Logger.getLogger(EESAAlgorithm.class.getName());
    /**
     * A list of all loaded EESA Algorithms.
     */
    private static List<EESAAlgorithm> eesaAlgorithmList;
	/**
     * Builds (if necessary) and provides
     * a list of available algorithms.
     * @return A safe array of algorithms, not backed
     */
    public static EESAAlgorithm[] getEESAAlgorithms() {
        if (eesaAlgorithmList == null) {
        	eesaAlgorithmList = new ArrayList<EESAAlgorithm>();
            String algorithmClass;
            File file = new File(Main.getProperties().getProperty("eesaFile"));
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                algorithmClass = br.readLine();
                if (algorithmClass != null) {
                    do {
                        try {
                        	eesaAlgorithmList.add((EESAAlgorithm) Class.
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
        return eesaAlgorithmList.toArray(new EESAAlgorithm[]{});
    }
	/**
     * Run the algorithm.
     * @param t Tests
     * @param j JobSet
     * @param p Processors
     * @return Test result
     * @throws AlgorithmException 
     */
	public abstract TestResult runAlgorithm(Test t,
			JobSet j,
			Processor[] p)
			throws AlgorithmException;
	/**
	 * Provides the parameters this algorithm is to be run with.
	 * @return Human readable list of assigned parameters.
	 */
	public abstract String getParameters();
}
