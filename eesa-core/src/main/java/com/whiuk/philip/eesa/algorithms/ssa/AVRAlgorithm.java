package com.whiuk.philip.eesa.algorithms.ssa;

import com.whiuk.philip.eesa.algorithms.SpeedScalingAlgorithm;
import com.whiuk.philip.eesa.core.Job;
import com.whiuk.philip.eesa.core.JobResult;
import com.whiuk.philip.eesa.core.Processor;
import com.whiuk.philip.eesa.core.ProcessorResult;
import com.whiuk.philip.eesa.core.ProcessorSpeedTimePeriod;
import com.whiuk.philip.eesa.core.Test;
import com.whiuk.philip.eesa.core.TimeInterval;
import com.whiuk.philip.eesa.exceptions.AlgorithmRuntimeException;
import com.whiuk.philip.eesa.exceptions.TimeIntervalException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Implements the AVR Algorithm as described by F. Yao, A. Demers and S. Shenker
 * @author Philip
 */
public class AVRAlgorithm implements SpeedScalingAlgorithm {
    /**
     * 
     */
    private static final String NAME = "AVerage Rate Algorithm";
    /**
     * 
     */
    private static final String DESC = 
    		"Provides an implementation of the online Average Rate Algorithm as"
            + " described by F. Yao, A. Demers and S. Shenker in "
			+ "\"A scheduling model for reduced CPU energy\" (1995).";
    @Override
    public final String toString() {
        return NAME;
    }
    @Override
    public final String getDescription() {
        return DESC;
    }    
    @Override
    public final boolean isOnline() {
        return false;
    }
    /**
     * We have a list of jobs ProcessorResult.getJobs(), j1,j2.. jn
     * For each job, ji: a(ji), b(ji), R(ji), d(j)
     * Speed is the sum of the density of jobs at a point in time
     * Points in time are aj, bj, for all j
     * 
     * Method:
     * 1) Retrieve time points 
     * 2) Build the job result objects
     * 3) Generate time periods for each consecutive pair
     *      a) Add jobs in the time period, computing sum density
     *      b) Use sum density as speed
     * 2) For each period
     *      a) Sort job results by deadline
     *      b) Add intervals of time to each job
     *      result for the work done in the period
     * @param test 
     * @param procResult Contains the jobs to be assigned
     */
    @Override
    public final void runSpeedScaling(final Test test,
    		final ProcessorResult procResult) {
        ArrayList<Job> jobs = procResult.getJobs();
        Processor proc = procResult.getProcessor();
        // Calculate Steps - Gather All Points
        ArrayList<Float> timePoints = getTimePoints(jobs);
        
        ArrayList<JobResult> jobResults = new ArrayList<JobResult>(jobs.size());
        for (int i = 0; i < jobs.size(); i++) {
            jobResults.add(new JobResult(i, test, proc, jobs.get(i)));
        }
        ArrayList<ProcessorSpeedTimePeriod> periods = 
        		new ArrayList<ProcessorSpeedTimePeriod>();
        //Generate objects
        for (int i = 0; i < timePoints.size() - 1; i++) {
            float startTime = timePoints.get(i);
            float endTime = timePoints.get(i + 1);
            ProcessorSpeedTimePeriod p = 
            		new ProcessorSpeedTimePeriod(i, 
            				procResult, 
			                proc,
			                test,
			                startTime,
			                endTime);
            float speed = 0; 
            for (int j = 0; j < jobResults.size(); j++) {
                Job job = jobResults.get(j).getJob();
                if (job.getReleaseTime() <= startTime 
                		&& jobs.get(j).getDeadlineTime() > startTime 
                		|| job.getReleaseTime() > startTime 
                		&& job.getReleaseTime() < endTime) {
                    speed += job.getDensity();        
                    p.addJobResult(jobResults.get(j));
                }  
            }      
            p.setSpeed(speed);
            periods.add(p);
        }
        //Build intervals
        for (int i = 0; i < periods.size(); i++) {
            ProcessorSpeedTimePeriod period = periods.get(i);
            ArrayList<JobResult> pJRs = period.getJobResults();
            //Sort by Deadline
            Collections.sort(pJRs, new Comparator<JobResult>() {
                @Override
                public int compare(final JobResult j1, final JobResult j2) {
                    if (j1.getJob().getDeadlineTime() 
                    		< j2.getJob().getDeadlineTime()) {
                    	return -1;
                    } else if (j1.getJob().getDeadlineTime() 
                    		== j2.getJob().getDeadlineTime()) {
                    	return 0;
                    } else {
                    	return 1;
                    }
                }            
            });
            float startTime = period.getStartTime();
            for (int h = 0; h < pJRs.size(); h++) {
                JobResult pJR = pJRs.get(h);
                float length = (pJR.getJob().getDensity() / period.getSpeed())
                		* period.getLength();
                try {
                    pJR.addTimeInterval(
                    		new TimeInterval(startTime, startTime + length));
                } catch (TimeIntervalException ex) {
                    throw new AlgorithmRuntimeException(ex.getMessage());
                }
                startTime += length;                
            }
        }
        //Hand Back Data
        procResult.setJobResults(jobResults.toArray(new JobResult[]{}));
        procResult.setSpeedGraph(periods);
    }
    /**
     * Calculates the points in time for the time periods.
     * @param j jobs
     * @return list of time points
     */
    private ArrayList<Float> getTimePoints(final ArrayList<Job> j) {
        ArrayList<Float> timePoints = new ArrayList<Float>();
        for (int i = 0; i < j.size(); i++) {
            if (!timePoints.contains(j.get(i).getReleaseTime())) {
                timePoints.add(j.get(i).getReleaseTime());
            }
            if (!timePoints.contains(j.get(i).getDeadlineTime())) {
                timePoints.add(j.get(i).getDeadlineTime());            
            }
        }
        //Sort the list
        Collections.sort(timePoints);
        return timePoints;
    }
}
