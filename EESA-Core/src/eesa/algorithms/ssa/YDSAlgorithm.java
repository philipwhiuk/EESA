package eesa.algorithms.ssa;

import eesa.algorithms.SpeedScalingAlgorithm;
import eesa.core.Job;
import eesa.core.JobResult;
import eesa.core.Processor;
import eesa.core.ProcessorResult;
import eesa.core.ProcessorSpeedTimePeriod;
import eesa.core.Test;
import eesa.core.TimeInterval;
import eesa.exceptions.AlgorithmRuntimeException;
import eesa.exceptions.TimeIntervalException;
import java.util.ArrayList;

/**
 * Implements the YDS "Optimal-Schedule" Algorithm as
 * described by F. Yao, A. Demers and S. Shenker
 * @author Philip
 */
public class YDSAlgorithm implements SpeedScalingAlgorithm {
    /**
     * 
     */
    private class YDSJob extends TimeInterval {
    	/**
    	 * 
    	 */
        private Job job;
        /**
         * 
         */
        private float startTime;
        /**
         * 
         */
        private float endTime;
        /**
         * 
         */
        private float length;
        /**
         * 
         * @param j 
         */
        YDSJob(final Job j) {
            this.job = j;
            this.startTime = job.getReleaseTime();
            this.endTime = job.getDeadlineTime();
            this.length = job.getLength();
        }
        /**
         * 
         * @return job
         */
        private Job getJob() {
            return job;
        }
    }
    /**
     * 
     */
    private final class YDSInterval extends TimeInterval {
    	/**
    	 * 
    	 */
        private ArrayList<YDSJob> jobs;
        /**
         * 
         */
        private float startTime;
        /**
         * 
         */
        private float endTime;
        /**
         * 
         */
        private float length;
        /**
         * 
         * @param s start time
         * @param e end time 
         */
        private YDSInterval(final float s,
        		final float e) {
            super(s, e);
            jobs = new ArrayList<YDSJob>();
        }
        /**
         * @return intensity
         */
        public float getIntensity() {
            float sumWeight = 0;
            for (int j = 0; j < jobs.size(); j++) {
                sumWeight += jobs.get(j).getJob().getWeight();
            }
            return (sumWeight / getLength());
        }
        /**
         * 
         * @param ydsJob 
         */
        private void addJob(final YDSJob ydsJob) {
            jobs.add(ydsJob);
        }
        /**
         * @return jobs
         */
        private ArrayList<YDSJob> getJobs() {
            return jobs;
        }
        /**
         * 
         * @param job 
         */
        private void removeJob(final YDSJob job) {
            jobs.remove(job);
        }
        /**
         * 
         * @return true if not empty
         */
        private boolean hasJobs() {
            return !jobs.isEmpty();
        }
    }
    /**
     * 
     */
    private final String name = "YDS Algorithm";
    /**
     * 
     */
    private final String desc =
    		"Provides an implementation of the offline YDS Algorithm as "
            + "described by F. Yao, A. Demers and S. Shenker in "
			+ "\"A scheduling model for reduced CPU energy\" (1995).";
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
	public final void runSpeedScaling(final Test test,
			final ProcessorResult p) { 
        int jrID = 0;
        int pstpID = 0;
        Processor processor = p.getProcessor();
        ArrayList<Job> jobs = p.getJobs();
        ArrayList<YDSJob> ydsJobs = new ArrayList<YDSJob>(jobs.size());
        for (int j = 0; j < jobs.size(); j++) {
            ydsJobs.add(new YDSJob(jobs.get(j)));
        }
        ArrayList<YDSInterval> ydsIntervals = new ArrayList<YDSInterval>();
        for (int j = 0; j < ydsJobs.size(); j++) {
            try {
                ydsIntervals.add(new YDSInterval(
                		ydsJobs.get(j).startTime,
                		ydsJobs.get(j).endTime));
            } catch (TimeIntervalException ex) {
                throw new AlgorithmRuntimeException(ex.getMessage());
            }
        }
        for (int j = 0; j < ydsJobs.size(); j++) {
            YDSJob ydsJob = ydsJobs.get(j);
            for (int i = 0; i < ydsIntervals.size(); i++) {
                YDSInterval ydsInterval = ydsIntervals.get(i);
                if (ydsInterval.getStartTime() <= ydsJob.startTime
                		&&
                        ydsInterval.getEndTime() >= ydsJob.endTime) {
                    ydsInterval.addJob(ydsJob);
                }
            }
        }
        while (ydsIntervals.size() > 0) {
            YDSInterval maxIntensityInterval = null;
            float maxIntensity = 0;
            for (int i = 0; i < ydsIntervals.size(); i++) {
                if (ydsIntervals.get(i).getIntensity() > maxIntensity) {
                    maxIntensityInterval = ydsIntervals.get(i);
                    maxIntensity = ydsIntervals.get(i).getIntensity();
                }
            }
            ArrayList<YDSJob> maxIntensityJobs = maxIntensityInterval.getJobs();
            try {
                ProcessorSpeedTimePeriod period = 
                		new ProcessorSpeedTimePeriod(pstpID, p,
                		processor, test,
                		maxIntensityInterval.getStartTime(),
                		maxIntensityInterval.getEndTime());
                period.setSpeed(maxIntensity);
                for (int j = 0; j < maxIntensityJobs.size(); j++) {
                    JobResult jobResult = 
                    		new JobResult(jrID, test,
            				processor, maxIntensityJobs.get(j).getJob());
                    jrID++;                    
                    period.addJobResult(jobResult);
                }
            } catch (TimeIntervalException ex) {
                throw new AlgorithmRuntimeException();
            }
            ydsIntervals.remove(maxIntensityInterval);
            for (int i = 0; i < ydsIntervals.size(); i++) {
                YDSInterval ydsInterval = ydsIntervals.get(i);
                for (int j = 0; j < maxIntensityJobs.size(); j++) {
                    ydsInterval.removeJob(maxIntensityJobs.get(j));
                }
                if (ydsInterval.hasJobs()) {
                	updateYDSInterval(ydsInterval, maxIntensityInterval);
                    
                } else {
                    ydsIntervals.set(i, null);
                }
            }
        }
    }
    /**
     * Updates a YDS Interval based on the maximum intensity interval.
     * @param ydsInterval Selected interval
     * @param maxIntensityInterval Max interval
     */
	private void updateYDSInterval(
			final YDSInterval ydsInterval,
			final YDSInterval maxIntensityInterval) {
		if (
				ydsInterval.getStartTime() > maxIntensityInterval.getStartTime()
			&& ydsInterval.getStartTime() <= maxIntensityInterval.getEndTime()
			&& ydsInterval.getEndTime() > maxIntensityInterval.getEndTime()
		) {

	        try {
	            ydsInterval.setStartTime(maxIntensityInterval.getEndTime());
	        } catch (TimeIntervalException ex) {
	            throw new AlgorithmRuntimeException(ex.getMessage());
	        }

        } else if (
        		ydsInterval.getStartTime() < maxIntensityInterval.getStartTime()
    		&& ydsInterval.getEndTime() >= maxIntensityInterval.getStartTime()
    		&& ydsInterval.getEndTime() < maxIntensityInterval.getEndTime()
    	) {
            try {
                ydsInterval.setEndTime(maxIntensityInterval.getEndTime());
            } catch (TimeIntervalException ex) {
                throw new AlgorithmRuntimeException(ex.getMessage());
            }
        }
	}
}