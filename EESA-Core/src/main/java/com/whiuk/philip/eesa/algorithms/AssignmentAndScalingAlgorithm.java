package com.whiuk.philip.eesa.algorithms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.whiuk.philip.eesa.core.JobSet;
import com.whiuk.philip.eesa.core.Main;
import com.whiuk.philip.eesa.core.Processor;
import com.whiuk.philip.eesa.core.ProcessorResult;
import com.whiuk.philip.eesa.core.Test;
import com.whiuk.philip.eesa.core.TestResult;
import com.whiuk.philip.eesa.exceptions.AlgorithmException;

/**
 * Provides an implementation of an EESA Algorithm that separates the task
 * into two common parts, assignment and scheduling.
 * @author Philip Whitehouse
 *
 */
public class AssignmentAndScalingAlgorithm extends EESAAlgorithm {
	/**
	 * Description of algorithm.
	 */
	private static final String DESCRIPTION = 
			"Provides the standard model for multi-processor deadline "
			+ "scheduling in which a Job Assignment Algorithm is paired "
			+ "with a Speed Scaling Algorithm.";
	/**
	 * Class logger.
	 */
	private static Logger logger =
			Logger.getLogger(AssignmentAndScalingAlgorithm.class.getName());
	/**
     * A list of all loaded Job Assignment Algorithms.
     */
    private static List<JobAssignmentAlgorithm> jaaAlgorithmList;
    /**
     * A list of all loaded Speed Scaling Algorithms.
     */
    private static List<SpeedScalingAlgorithm> ssaAlgorithmList;
	
	/**
     * Builds (if necessary) and provides
     * a list of available job-assignment algorithms.
     * @return A safe array of algorithms, not backed
     */
    public static JobAssignmentAlgorithm[] getJobAssignmentAlgorithms() {
        if (jaaAlgorithmList == null) {
            jaaAlgorithmList = new ArrayList<JobAssignmentAlgorithm>();
            String algorithmClass;
            File file = new File(Main.getProperties().getProperty("jaaFile"));
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                algorithmClass = br.readLine();
                if (algorithmClass != null) {
                    do {
                        try {
                            jaaAlgorithmList.add((JobAssignmentAlgorithm) Class.
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
                br.close();
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
        return jaaAlgorithmList.toArray(new JobAssignmentAlgorithm[]{});
    }
    /**
     * Builds (if necessary) and provides a list of
     * available speed scaling algorithms.
     * @return A safe array of algorithms
     */
    public static SpeedScalingAlgorithm[] getSpeedScalingAlgorithms() {
        if (ssaAlgorithmList == null) {
            ssaAlgorithmList = new ArrayList<SpeedScalingAlgorithm>();
            String algorithmClass;
            File file = new File(Main.getProperties().getProperty("ssaFile"));
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                while ((algorithmClass = br.readLine()) != null) {
                    try {
                        ssaAlgorithmList.add((SpeedScalingAlgorithm) Class.
                        		forName(algorithmClass).newInstance());
                    } catch (ClassNotFoundException ex) {
                    	logger.log(Level.INFO,
                    			"Algorithm Class Not Found: {0}",
                    			algorithmClass);
                    } catch (InstantiationException ex) {
                    	logger.log(Level.INFO,
                			"Algorithm Class Couldn''t Be Instantiated: {0}",
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
                }
                br.close();
            } catch (FileNotFoundException ex) {
                try {
                	logger.log(Level.WARNING, "FileNotFound: {0}",
                			file.getCanonicalPath());
                } catch (IOException ex1) {
                	logger.log(Level.SEVERE, null, ex1);
                }
                logger.log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
            	logger.log(Level.SEVERE, null, ex);
            }
        }
        return ssaAlgorithmList.toArray(new SpeedScalingAlgorithm[]{});
    }
	/**
	 * The selected job assignment algorithm.
	 */
	private JobAssignmentAlgorithm jobAssignmentAlgorithm;
	/**
	 * The chosen speed scaling algorithm.
	 */
	private SpeedScalingAlgorithm speedScalingAlgorithm;
	/**
	 * 
	 */
	public AssignmentAndScalingAlgorithm() {
	}

	/**
	 * Constructor.
	 * @param jaa Job Assignment Algorithm
	 * @param ssa Speed Scaling Algorithm
	 */
	public AssignmentAndScalingAlgorithm(
			final JobAssignmentAlgorithm jaa, final SpeedScalingAlgorithm ssa) {
		this.jobAssignmentAlgorithm = jaa;
		this.speedScalingAlgorithm = ssa;
	}
	/**
	 * 
	 * @return string
	 */
	public final String toString() {
		return "Assignment & Scaling Algorithm";
	}
	@Override
	public final String getDescription() {
		return DESCRIPTION;
	}
    /**
     * 
     * @return The Job Assignment Algorithm attached to this algorithm.
     */
    public final JobAssignmentAlgorithm getJAA() {
        return jobAssignmentAlgorithm;
    }
    /**
     * 
     * @return The Speed Scaling Algorithm attached to this algorithm.
     */
    public final SpeedScalingAlgorithm getSSA() {
        return speedScalingAlgorithm;
    }
    @Override
    public final TestResult runAlgorithm(
    		final Test t,
    		final JobSet j,
    		final Processor[] p)
    		throws AlgorithmException {
    	ProcessorResult[] processorResults = jobAssignmentAlgorithm.
        		runJobAssignment(j, p);
        for (int i = 0; i < processorResults.length; i++) {
            speedScalingAlgorithm.runSpeedScaling(t, processorResults[i]);
        }
        return new TestResult(t, processorResults);
    }
    /**
     * Runs the assignment algorithm on the {@link eesa.core.Simulation}'s jobs.
     * @param j JobSet
     * @param p Processors
     * @throws AlgorithmException 
     * @return Processor assignment results
     */
    public final ProcessorResult[] runAssignmentAlgorithm(final JobSet j,
    		final Processor[] p) throws AlgorithmException {
    	return jobAssignmentAlgorithm.runJobAssignment(j, p);
    }
    /**
     * Runs the speed scaling algorithm on a single 
     * {@link eesa.core.Processor}'s jobs.
     * @param p Processor
     * @param t Test
     * @return Results of speed scaling
     * @throws AlgorithmException 
     */
    public final ProcessorResult runSpeedScalingAlgorithm(
    		final Test t, final ProcessorResult p) 
    		throws AlgorithmException {
        speedScalingAlgorithm.runSpeedScaling(t, p);
        return p;
    }
    /**
     * Runs the speed scaling algorithm on all {@link Processor}'s jobs.
     * @param t Test
     * @param p Processors and jobs to be scaled
     * @throws AlgorithmException 
     * @return results of scaling on each processor
     */
    public final ProcessorResult[] runSpeedScalingAlgorithmForAll(
    		final Test t, final ProcessorResult[] p) 
    		throws AlgorithmException {
        for (int i = 0; i < p.length; i++) {
            speedScalingAlgorithm.runSpeedScaling(t, p[i]);
        }
        return p;
    }
	/**
	 * 
	 * @param jaa Job Assignment Algorithm
	 */
    public final void setJAA(final JobAssignmentAlgorithm jaa) {
		this.jobAssignmentAlgorithm = jaa;
	}
    /**
     * 
     * @param ssa Speed Scaling Algorithm
     */
	public final void setSSA(final SpeedScalingAlgorithm ssa) {
		this.speedScalingAlgorithm = ssa;
	}
	@Override
	public final String getParameters() {
		return jobAssignmentAlgorithm.toString()
				+ " & "
				+ speedScalingAlgorithm.toString();
	}
    
}
