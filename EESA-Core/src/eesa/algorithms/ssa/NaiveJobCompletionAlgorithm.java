package eesa.algorithms.ssa;

import eesa.exceptions.AlgorithmException;
import eesa.algorithms.SpeedScalingAlgorithm;
import eesa.core.Job;
import eesa.core.JobResult;
import eesa.core.ProcessorResult;
import eesa.core.ProcessorSpeedTimePeriod;
import eesa.core.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Implements the Naive Job Completion Algorithm as described by
 * Rachel Ferst and Alan Papir.
 * @author Philip
 */
public class NaiveJobCompletionAlgorithm implements SpeedScalingAlgorithm {
	/**
	 * Error message for simultaneous job release.
	 */
	private static final String SIMULTANEOUS_ERROR =
			"Simultaneous Job Release Not Allowed In " 
			+ "Naive Job Completion Algorithm.";
    /**
     * 
     */
    private String name = "Naive Job Completion Algorithm";
    /**
     * 
     */
    private final String desc = "Provides an implementation of a naive offline "
    		+ "algorithm which completes jobs in order by calculating speed "
    		+ "based on min[d(j),a(j+1)], as described in: "
    		+ "http://www.columbia.edu/~cs2035/courses/ieor4405.S09/p2-1.ppt";
    /**
     * 
     */
	private Test test;
	/**
	 * 
	 */
	private ProcessorResult processorResult;
	/**
	 * 
	 */
	private int pstID;
	/**
	 * 
	 */
	private int jrID;
	/**
	 * 
	 */
	private ArrayList<ProcessorSpeedTimePeriod> periods;
	/**
	 * 
	 */
	private ArrayList<JobResult> jobResults;
	/**
	 * 
	 */
	private Job[] sortedJobs;
    /**
     * 
     * @return The short human-friendly name of the algorithm
     */
    @Override
	public final String toString() {
        return name;
    }
    /**
     * 
     * @return The long description of the algorithm
     */
    @Override
	public final String getDescription() {
        return desc;
    }    
    /**
     * 
     * @return Whether the algorithm works online or offline
     */
    @Override
	public final boolean isOnline() {
        return false;
    }

    /**
     * 
     * @param t Test
     * @param p ProcessorResult
     * @throws AlgorithmException Exception thrown for errors
     */
    @Override
	public final void runSpeedScaling(
			final Test t,
			final ProcessorResult p) throws AlgorithmException {
    	test = t;
    	processorResult = p;
    	pstID = 0;
        jrID = 0;
        periods = new ArrayList<ProcessorSpeedTimePeriod>();
        jobResults = new ArrayList<JobResult>();
        
        ArrayList<Job> jobs = p.getJobs();
        Collections.sort(jobs, new Comparator<Job>() {
            @Override
            public int compare(final Job j1, final Job j2) {
                if (j1.getReleaseTime() < j2.getReleaseTime()) {
                	return -1; 
                } else if (j1.getReleaseTime() == j2.getReleaseTime()) {
                	return 0; 
                } else { return 1; }
            }            
        });        
        sortedJobs = jobs.toArray(new Job[0]);
        for (int i = 0; i < sortedJobs.length; i++) {
            try {
            	processJob(i);

            } catch (java.lang.ArithmeticException e) {
                throw new AlgorithmException(SIMULTANEOUS_ERROR);
            }
        }
    }
    /**
     * 
     * @param i Index of job to process
     */
    private void processJob(final int i) {
        if (i + 1 < sortedJobs.length) {
            if (sortedJobs[i].getDeadlineTime() 
            		< sortedJobs[i + 1].getReleaseTime()) {
                ProcessorSpeedTimePeriod p1;
                p1 = new ProcessorSpeedTimePeriod(pstID, processorResult,
                		processorResult.getProcessor(), test,
                		sortedJobs[i].getReleaseTime(),
                		sortedJobs[i].getDeadlineTime());
                pstID++;
                ProcessorSpeedTimePeriod p2;
                p2 = new ProcessorSpeedTimePeriod(pstID, processorResult,
                		processorResult.getProcessor(), test,
                		sortedJobs[i].getDeadlineTime(),
                		sortedJobs[i + 1].getReleaseTime());
                pstID++;
                JobResult jr = new JobResult(jrID, test,
                		processorResult.getProcessor(),
                		sortedJobs[i]);
                jrID++;
                p1.addJobResult(jr);
                p1.setSpeed(sortedJobs[i].getDensity());
                p2.setSpeed(0);
                jobResults.add(jr);
                periods.add(p1);
                periods.add(p2);
            } else {
                ProcessorSpeedTimePeriod p1;
                p1 = new ProcessorSpeedTimePeriod(pstID, processorResult,
                		processorResult.getProcessor(), test,
                		sortedJobs[i].getReleaseTime(),
                		sortedJobs[i + 1].getReleaseTime());
                pstID++;
                JobResult jr = new JobResult(jrID, test,
                		processorResult.getProcessor(),
                		sortedJobs[i]);
                jrID++;                        
                p1.addJobResult(jr);
                p1.setSpeed(sortedJobs[i].getWeight() 
                		/ (sortedJobs[i].getReleaseTime()
                				- sortedJobs[i + 1].getReleaseTime()));
                jobResults.add(jr);
                periods.add(p1);
            }
        } else {
            ProcessorSpeedTimePeriod p1;
            p1 = new ProcessorSpeedTimePeriod(pstID, processorResult,
            		processorResult.getProcessor(), test,
            		sortedJobs[i].getReleaseTime(),
            		sortedJobs[i].getDeadlineTime());
            pstID++;
            JobResult jr = new JobResult(jrID, test,
            		processorResult.getProcessor(),
            		sortedJobs[i]);
            jrID++;                        
            p1.addJobResult(jr);
            p1.setSpeed(sortedJobs[i].getDensity());
            jobResults.add(jr);
            periods.add(p1);                    
        }    	
    }
}
