package eesa.algorithms.ssa;

import java.util.ArrayList;

import eesa.algorithms.SpeedScalingAlgorithm;
import eesa.core.Job;
import eesa.core.ProcessorResult;
import eesa.core.ProcessorSpeedTimePeriod;
import eesa.core.Test;
import eesa.core.TimeInterval;

/**
 * Implements the Optimal-Available Algorithm as described
 * by F. Yao, A. Demers and S. Shenker
 * @author Philip
 */
public class OAAlgorithm implements SpeedScalingAlgorithm {
    /**
     * 
     */
    private String name = "Optimal Available (OA) Algorithm";
    /**
     * 
     */
    private final String desc = "Provides an implementation of the online "
    		+ "Optimal Available Algorithm as "
            + "described by F. Yao, A. Demers and "
    		+ "S. Shenker in \"A scheduling model "
            + "for reduced CPU energy\" (1995).";
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
        return true;
    }

    @Override
	public final void runSpeedScaling(final Test t, final ProcessorResult p) {
        ArrayList<Job> unassignedJobs = p.getJobs();
        ArrayList<TimeInterval> intervals = constructIntervals(unassignedJobs);
        for (TimeInterval ti : intervals) {
             throw new UnsupportedOperationException(ti.toString());        	
        }        
    }
    /**
     * 
     * @param j Unassigned jobs
     * @return constructed intervals
     */
    private ArrayList<TimeInterval> constructIntervals(
    		final ArrayList<Job> j) {
        throw new UnsupportedOperationException("Not yet implemented");
    }  
    /**
     * 
     * @param j jobs
     * @return intervals
     */
    private ArrayList<ProcessorSpeedTimePeriod> performOptimalSchedule(
    		final ArrayList<Job> j) {
        ArrayList<ProcessorSpeedTimePeriod> intervals = 
        		new ArrayList<ProcessorSpeedTimePeriod>();
        while (!j.isEmpty()) {
            ProcessorSpeedTimePeriod period = identifyCriticalInterval();
            removeJobsInPeriod(j, period);
            intervals.add(period);
        }
        return intervals;
    }
    /**
     * @return critical interval
     */
    private ProcessorSpeedTimePeriod identifyCriticalInterval() {
        return null;
    }
    /**
     * 
     * @param j jobs
     * @param p period
     */
    private void removeJobsInPeriod(
    		final ArrayList<Job> j,
    		final ProcessorSpeedTimePeriod p) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
