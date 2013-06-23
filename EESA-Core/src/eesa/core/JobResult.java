package eesa.core;

import java.util.ArrayList;

/**
 * Connects a Job to the Processor it is run on during a Test.
 * @author Philip
 */
public class JobResult implements Stored {
    /**
     * The unique ID of the job result (within a test).
     */
    private int id;
    /**
     * The job connected to this JobResult object.
     */
    private Job job;
    /**
     * The processor that this result is connected to.
     */
    private Processor processor;
    /**
     * The test that this result is connected to.
     */
    private Test test;
    /**
     * 
     */
    private ArrayList<TimeInterval> timeIntervals;

    /**
     * Standard construction.
     * @param i The ID the job result object
     * @param t The test the job result is attached to
     * @param p The processor the job result is attached to
     * @param j The job the job result is attached to
     */
    public JobResult(final int i, final Test t,
    		final Processor p, final Job j) {
        this();
        this.id = i;
        this.job = j;
        this.processor = p;
        this.test = t;
        
    }
    /**
     * Blank constructor for data export & import.
     */
    public JobResult() {
        timeIntervals = new ArrayList<TimeInterval>();
    }
    /**
     * Accessor for the ID.
     * @return The unique identifier of the Job Result object
     */    
    public final int getID() {
        return this.id;
    }
    /**
     * Accessor for the test of the job.
     * @return The test of which the result is part of
     */
    public final Test getTest() {
        return test;
    }
    /**
     * Accessor for the processor of the job.
     * @return The processor that the job is run on
     */
    public final Processor getProcessor() {
        return processor;
    }
    /**
     * Accessor for the job.
     * @return The job that the result is serving
     */
    public final Job getJob() {
        return job;
    }
    /**
     * Add a time interval.
     * @param i The time interval
     */
    public final void addTimeInterval(final TimeInterval i) {
        timeIntervals.add(i);
    }
}
