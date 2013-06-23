package eesa.algorithms.jaa;

import eesa.exceptions.AlgorithmException;
import eesa.algorithms.JobAssignmentAlgorithm;
import eesa.core.Job;
import eesa.core.JobSet;
import eesa.core.Processor;
import eesa.core.ProcessorResult;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Implements the Round-Robin Algorithm as described
 * by S. Albers, F. Muller and S. Schmelzer
 * @author Philip Whitehouse
 */
public class RoundRobinAlgorithm implements JobAssignmentAlgorithm {
    /**
     * 
     */
    private final String name = "Round-Robin Algorithm";
    /**
     * 
     */
    private String desc = "Provides an implementation of the "
    		+ "Round Robin Algorithm as described by S. Albers, "
    		+ "F. Muller and S. Schmelzer in \"Speed scaling on "
    		+ "parrelel processors\" (2007). ";
    @Override
	public final String getDescription() {
        return desc;
    }
    @Override
	public final String toString() {
        return name;
    }
    
    @Override
	public final ProcessorResult[] runJobAssignment(final JobSet js,
			final Processor[] processors) throws AlgorithmException {
        if (processors.length == 0) {
            throw new AlgorithmException("No processors!");
        }
        //Get the Jobs to Assign
        List<Job> jobs = js.getJobs();
        if (jobs.size() == 0) {
            throw new AlgorithmException("No jobs!");
        }
        Collections.sort(jobs, new Comparator<Job>() {
            @Override
            public int compare(final Job j1, final Job j2) {
                if (j1.getReleaseTime() < j2.getReleaseTime()) { 
                	return -1;
                } else if (j1.getReleaseTime() == j2.getReleaseTime()) {
                	return 0;
                } else { 
                	return 1;
                }
            }
        
        });
        //Build the Result Objects
        ProcessorResult[] procResults = new ProcessorResult[processors.length];
        for (int p = 0; p < processors.length; p++) {
        	procResults[p] = new ProcessorResult(processors[p]);
        }
        //Do The Assignment
        for (int j = 0; j < jobs.size(); j++) {
        	procResults[(j % processors.length)].addJob(jobs.get(j));
        }
        return procResults;
    }    
}
