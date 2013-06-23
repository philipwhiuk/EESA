package eesa.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * The Test results for a single processor. 
 * Following JobAssignment, contains unscheduled jobs 
 * assigned to this processor.
 * Following SpeedScaling, contains 
 * speed graph elements (ProcessorTimePeriod objects) and job results.
 * @author Philip
 */
public class ProcessorResult implements Stored {
    /**
     * The attached processor.
     */
    private Processor processor;
    /**
     * The list of intervals with their speed and energy usage.
     */
    private List<ProcessorSpeedTimePeriod> speedGraph = 
    		new ArrayList<ProcessorSpeedTimePeriod>();
    /**
     * The job results attached to the processor.
     */
    private JobResult[] jobResults;
    /**
     * The jobs to be attached to processor results.
     */
    private ArrayList<Job> jobs = new ArrayList<Job>();
    /**
     * The time the processor runs for.
     */
    private float maxTime;
    /**
     * The fastest speed the processor runs at.
     */
    private float maxSpeed;
    /**
     * Constructor.
     * @param p 
     */
    public ProcessorResult(final Processor p) {
        this();
        this.processor = p;
    }

    /**
     * Blank constructor for data import and loading.
     */
    public ProcessorResult() {
    }
    /**
     * Set a Job as being computed by this processor during a given test.
     * @param job 
     */
    public final void addJob(final Job job) {
        jobs.add(job);
    }
    /**
     * 
     * @return The number of unassigned jobs
     */
    public final int getJobCount() {
        return jobs.size();
    }
    /**
     * Return a list of all jobs to be assigned.
     * @return The unassigned jobs (direct access)
     */
    public final ArrayList<Job> getJobs() {
        return jobs;
    }
    /**
     * Add the results.
     * @param results 
     */
    public final void setJobResults(final JobResult[] results) {
        this.jobResults = results;
    }
    /**
     * Provide the SpeedTimePeriod data.
     * @param periods 
     */
    public final void setSpeedGraph(
    		final List<ProcessorSpeedTimePeriod> periods) {
        this.speedGraph = periods;
    }
    /**
     * Calculates the largest time in the ProcessorSpeedTimePeriod data.
     * @return The largest time value recorded (unit-less)
     */
    public final float getMaxTime() {
        if (maxTime == 0) {
            maxTime = 0;
            Iterator<ProcessorSpeedTimePeriod> i = speedGraph.iterator();
            while (i.hasNext()) {
                ProcessorSpeedTimePeriod p = i.next();
                if (p.getEndTime() > maxTime) {
                    maxTime = p.getEndTime();
                }
            }
        }
        return maxTime;
    }
    /**
     * Calculates the highest speed in the ProcessorSpeedTimePeriod data.
     * @return The highest speed at which the processor runs (unitless)
     */
    public final float getMaxSpeed() {
        if (maxSpeed == 0) {
            maxSpeed = 0;
            Iterator<ProcessorSpeedTimePeriod> i = speedGraph.iterator();
            while (i.hasNext()) {
                ProcessorSpeedTimePeriod p = i.next();
                if (p.getSpeed() > maxSpeed) {
                    maxSpeed = p.getSpeed();
                }
            }
        }
        return maxSpeed;
    }
    /**
     * Retrieves the related processor that this result acts on.
     * @return The processor the set of results is attached to
     */
    public final Processor getProcessor() {
        return processor;
    }
    /**
     * Retrieves the computed periods.
     * @return The list of time periods (directly)
     */
    public final List<ProcessorSpeedTimePeriod> getSpeedTimePeriods() {
        return speedGraph;
    }
    /**
     * Returns the number of JobResults.
     * @return The number of results
     */
    public final int getJobResultCount() {
        if (jobResults != null) {
            return jobResults.length;
        }
        return 0;
    }
    /**
     * Returns the job results (direct access).
     * @return The results
     */
    public final JobResult[] getJobResults() {
        return jobResults;
    }

    /**
     * Retrieves a job result by its id.
     * @param id The ID
     * @return The job result (or null if non found)
     */
    final JobResult getJobResultByID(final int id) {
        if (jobResults != null) {
            for (int i = 0; i < jobResults.length; i++) {
                if (jobResults[i].getID() == id) {
                    return jobResults[i];
                }
            }
        }
        return null;
    }
}