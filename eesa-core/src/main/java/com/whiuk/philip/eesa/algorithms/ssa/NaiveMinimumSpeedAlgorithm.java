package com.whiuk.philip.eesa.algorithms.ssa;

import com.whiuk.philip.eesa.algorithms.SpeedScalingAlgorithm;
import com.whiuk.philip.eesa.core.Job;
import com.whiuk.philip.eesa.core.JobResult;
import com.whiuk.philip.eesa.exceptions.AlgorithmException;
import com.whiuk.philip.eesa.core.ProcessorResult;
import com.whiuk.philip.eesa.core.ProcessorSpeedTimePeriod;
import com.whiuk.philip.eesa.core.Test;
import com.whiuk.philip.eesa.exceptions.AlgorithmRuntimeException;
import com.whiuk.philip.eesa.exceptions.TimeIntervalException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Implements the Naive Minimum Speed Algorithm as described by
 * Rachel Ferst and Alan Papir.
 * @author Philip
 */
public class NaiveMinimumSpeedAlgorithm implements SpeedScalingAlgorithm {
	/**
	 * Error message for simultaneous job release.
	 */
	private static final String SIMULTANEOUS_ERROR =
			"Simultaneous Job Release Not Allowed In " 
			+ "Naive Minimum Speed Algorithm.";
	/**
     * 
     */
    private String name = "Naive Minimum Speed Algorithm";
    /**
     * 
     */
    private final String desc = 
    		"Provides an implementation of a naive offline algorithm which "
            + "completes jobs by calculating the minimum required speed for "
			+ "all jobs assuming they must finish before the next starts "
            + "and applying it as jobs speed - uses MAX(density(j)) as "
			+ "described in: "
            + "http://www.columbia.edu/~cs2035/courses/ieor4405.S09/p2-1.ppt "
            + "by Rachel Ferst and Alan Papir";
    @Override
	public final String toString() {
        return name;
    }
    @Override
	public final String getDescription() {
        return desc;
    }    
    @Override
	public final boolean isOnline() {
        return false;
    }
    @Override
	public final void runSpeedScaling(final Test t,
			final ProcessorResult p) throws AlgorithmException {
        ArrayList<Job> jobs = p.getJobs();
        float minSpeed = getMinSpeed(jobs);
        int id = 0;
        int pstID = 0;
        ArrayList<JobResult> jobResults = new ArrayList<JobResult>(jobs.size());
        ArrayList<ProcessorSpeedTimePeriod> periods = 
        		new ArrayList<ProcessorSpeedTimePeriod>(jobs.size());
        for (int i = 0; i < jobs.size(); i++) {
            Job job = jobs.get(i);
            JobResult j = new JobResult(id, t, p.getProcessor(), job);
            jobResults.add(j);
            if (i < jobs.size() - 1) {
                if (job.getDeadlineTime() < jobs.get(i + 1).getReleaseTime()) {
                    ProcessorSpeedTimePeriod p1;
                    try {
                        p1 = new ProcessorSpeedTimePeriod(pstID, p, 
                        		p.getProcessor(),
                        		t, job.getReleaseTime(), job.getDeadlineTime());
                    } catch (TimeIntervalException ex) {
                        throw new AlgorithmRuntimeException(ex.getMessage());
                    }
                    pstID++;
                    p1.setSpeed(minSpeed);
                    ProcessorSpeedTimePeriod p2;
                    try {
                        p2 = new ProcessorSpeedTimePeriod(pstID, p,
                        		p.getProcessor(),
                        		t, job.getDeadlineTime(), 
                        		jobs.get(i + 1).getReleaseTime());
                    } catch (TimeIntervalException ex) {
                        throw new AlgorithmRuntimeException(ex.getMessage());
                    }
                    pstID++;
                    p2.setSpeed(0);
                    periods.add(p1);
                    periods.add(p2);
                } else {
                    ProcessorSpeedTimePeriod p1;                    
                    try {
                        p1 = new ProcessorSpeedTimePeriod(pstID, 
                        		p, p.getProcessor(), 
                        		t, job.getReleaseTime(), 
                        		jobs.get(i + 1).getReleaseTime());
                    } catch (TimeIntervalException ex) {
                        throw new AlgorithmRuntimeException(ex.getMessage());
                    }
                    pstID++;
                    p1.setSpeed(minSpeed);
                    periods.add(p1);
                }
            } else {
                ProcessorSpeedTimePeriod p1;                
                try {
                    p1 = new ProcessorSpeedTimePeriod(pstID, p, 
                    		p.getProcessor(), t, 
                    		job.getReleaseTime(), 
                    		job.getDeadlineTime());
                } catch (TimeIntervalException ex) {
                    throw new AlgorithmRuntimeException(ex.getMessage());
                }
                pstID++;
                p1.setSpeed(minSpeed);
                periods.add(p1);
            }
        }        

    }
    /**
     * 
     * @param j jobs
     * @return minimum speed
     * @throws AlgorithmException thrown if a condition is broken
     */
    private float getMinSpeed(final List<Job> j) 
    		throws AlgorithmException {
        float minSpeed = 0;
        Collections.sort(j, new Comparator<Job>() {
            /**
             * 
             */
            @Override
            public int compare(final Job o1, final Job o2) {
                return (int) (o2.getReleaseTime() - o1.getReleaseTime());
            }            
        });
        //All Jobs But Final Job
        for (int i = 0; i < (j.size() - 1); i++) {
            try {
                float jobSpeed = 0;
                if (j.get(i + 1).getReleaseTime() 
                		> j.get(i).getDeadlineTime()) {
                    jobSpeed = j.get(i).getWeight() 
                    		/ (j.get(i + 1).getReleaseTime() 
                    				- j.get(i).getReleaseTime());
                } else {
                    jobSpeed = j.get(i).getWeight() 
                    		/ (j.get(i).getDeadlineTime() 
                    				- j.get(i).getReleaseTime());
                }
                if (minSpeed < jobSpeed) {
                    jobSpeed = minSpeed;
                }
            } catch (java.lang.ArithmeticException e) {
                throw new AlgorithmException(SIMULTANEOUS_ERROR);
            }
        }
        //Final Job
        try {
            if (j.size() > 1) {
            	Job lastJob = j.get(j.size() - 1);            	
                float jobSpeed = lastJob.getWeight()
                		/ (lastJob.getLength());
                if (minSpeed < jobSpeed) {
                    minSpeed = jobSpeed;
                }
            }
        } catch (java.lang.ArithmeticException e) {
            throw new AlgorithmException(SIMULTANEOUS_ERROR);
        }        
        return minSpeed;
    }
    
}
