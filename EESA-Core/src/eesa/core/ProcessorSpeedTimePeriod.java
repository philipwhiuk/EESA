package eesa.core;

import java.util.ArrayList;

/**
 * Describes a contiguous period of time with a set speed
 * and the jobs performed during this period.
 * @author Philip
 */
public class ProcessorSpeedTimePeriod implements Stored {
    /** 
     * The time interval covered by the period.
     */
    private TimeInterval timeInterval;    
    /**
     * The speed at which the processor runs during this period.
     */
    private float speed;
    /**
     * The job that is performed during this period.
     */
    private ArrayList<JobResult> jobsPerformed;
    /**
     * The test that this period is attached to.
     */
    private Test test;
    /**
     * The processor that this period is attached to.
     */
    private Processor processor;
    /**
     * The processor result that this period is attached to.
     */
    private ProcessorResult processorResult;
    /**
     * The unique ID of this period (within a test).
     */
    private int id;
    
    /**
     * Standard constructor.
     * @param i 
     * @param proc 
     * @param p 
     * @param t 
     * @param startTime Start time
     * @param endTime End time
     */
    public ProcessorSpeedTimePeriod(final int i, final ProcessorResult proc, 
    		final Processor p, final Test t, 
    		final float startTime, final float endTime) {
        this();
        this.id = i;
        this.test = t;
        this.processor = p;
        this.timeInterval = new TimeInterval(startTime, endTime);
        this.processorResult = proc;
    }

    /**
     * Blank constructor for loading and data import.
     */
    ProcessorSpeedTimePeriod() {
        jobsPerformed = new ArrayList<JobResult>();
    }
    /**
     * The unique ID of this period.
     * @return ID
     */
    public final int getID() {
        return id;
    }
    /**
     * Returns the length of the period.
     * @return The length of this period (unitless)
     */
    public final float getLength() {
        return timeInterval.getLength();
    }
    /**
     * Returns the speed of the period.
     * @return The speed of this period (unitless)
     */
    public final float getSpeed() {
        return speed;
    }
    /**
     * Returns the start time of the period.
     * @return The start of this period
     */
    public final float getStartTime() {
        return timeInterval.getStartTime();        
    }
    /**
     * Returns the end time of the period.
     * @return The end time of this period (unitless)
     */
    public final float getEndTime() {
        return timeInterval.getEndTime();
    }
    /**
     * Sets the speed of the period.
     * @param s The speed which the processor is run at during this period
     */
    public final void setSpeed(final float s) {
        this.speed = s;
    }
    /**
     * Returns the test of the period.
     * @return The test to which this period is attached to
     */
    public final Test getTest() {
        return this.test;
    }
    /**
     * Returns the processor the period is related to.
     * @return The processor that this period is attached to
     */
    public final Processor getProcessor() {
        return this.processor;
    }
    /**
     * Returns the processor result this period is attached to.
     * @return The processor result
     */
    public final ProcessorResult getProcessorResult() {
        return this.processorResult;
    }
    /**
     * Sets the processor result this period is attached to.
     * @param proc The processor result
     */
    public final void setProcessorResult(final ProcessorResult proc) {
        this.processorResult = proc;
    }
    /**
     * Calculates and retrieves the power based on the
     * currently set power factor for the simulation.
     * @return The power at which this period operates at
     */
    public final double getPower() {
        return Math.pow(speed, test.getSimulation().getPowerFactor());
    }
    /**
     * Calculates and retrieves the energy based on the
     * currently set power factor for the simulation.
     * @return The energy used during this period 
     */
    public final double getEnergy() {
        return Math.pow(speed, 
        		test.getSimulation().getPowerFactor()) 
        		* (timeInterval.getLength());
    }

    /**
     * Adds a job result to be run in this period.
     * @param job 
     */
    public final void addJobResult(final JobResult job) {
        jobsPerformed.add(job);
    }
    /**
     * Provides the job results run in this period.
     * @return job results
     */
    public final ArrayList<JobResult> getJobResults() {
        return this.jobsPerformed;
    }
}
