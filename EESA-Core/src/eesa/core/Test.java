package eesa.core;

import eesa.algorithms.EESAAlgorithm;
import eesa.exceptions.AlgorithmException;
/**
 * Describes a single pair of algorithms which are tested on the set of Jobs.
 * @author Philip
 */
public class Test implements Stored {
    /**
     * Provides a reference to the simulation under which the test operates.
     */
    private Simulation simulation;
    /**
     * Provides the storage of results for each processor under the test.
     */
    private TestResult results;
    /**
     * Provides the algorithm for the test.
     */
    private EESAAlgorithm algorithm;
    /**
     * Provides the unique ID of the test.
     */
    private int id;
    /**
     * Default constructor.
     * @param s Simulation
     * @param i ID
     * @param a Algorithm
     */
    Test(final Simulation s, final int i,
    		final EESAAlgorithm a) {
        this();
        this.id = i;
        this.simulation = s;
        this.algorithm = a;
    }
    /**
     * Blank constructor for data loading.
     */
    public Test() {
    }
    /**
     * Provides the simulation that the test is attached to.
     * @return The simulation
     */
    final Simulation getSimulation() {
        return this.simulation;
    }
    /**
     * 
     * @return The Algorithm attached to this test
     */
    public final EESAAlgorithm getAlgorithm() {
        return algorithm;
    }

    /**
     * Provides information on whether there are any results stored.
     * @return true if there are results, else false
     */
    public final boolean hasResults() {
        return (results != null);
    }
    /**
     * Provides information on whether there are any results stored.
     * @return true if there are results, else false
     */
    public final TestResult getResults() {
        return results;
    }    
    /**
     * 
     * @return The test's unique identifier (0+)
     */
    public final int getID() {
        return id;
    }
    /**
     * Provides a string representation of the algorithm.
     * @return A string representation of the pair of algorithms 
     */
    public final String getAlgorithmName() {
        return algorithm.toString();
    }
    /**
     * Outputs a human readable string version of the test.
     * @return String of the format "<ID>. <JAA> & <SSA>"
     */
    @Override
    public final String toString() {
        return "" + id + ". " + algorithm;
    }
    /**
     * Changes the current Algorithm.
     * @param a Algorithm
     */
    public final void setAlgorithm(final EESAAlgorithm a) {
        this.algorithm = a;
    }
    /**
     * Runs the algorithm.
     * @throws AlgorithmException 
     */
	public final void runAlgorithm() throws AlgorithmException {
		results = algorithm.runAlgorithm(this,
				simulation.getJobSet(),
				simulation.getProcessors());
	}   
}
