package com.whiuk.philip.eesa.event;

import com.whiuk.philip.eesa.core.Job;
import java.util.Collection;

/**
 * Provides information about changes to a job.
 * @author Philip
 */
public class JobEvent extends EventObject {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    private final int first;
    /**
     * 
     */
    private final int last;
    /**
     * 
     * @param j job
     * @param f The index of the first affected job
     * @param l The index of the last affected job
     */
    public JobEvent(final Job j, final int f, final int l) {
        super(j);
        this.first = f;
        this.last = l;
    }
    /**
     * 
     * @param j jobs
     * @param f The index of the first affected job
     * @param l The index of the last affected job
     */
    public JobEvent(final Collection<Job> j, final int f, final int l) {
        super(j);
        this.first = f;
        this.last = l;
    }
    /**
     * 
     * @return The job that was changed
     */
    public final Job getJob() {
        return (Job) this.source;
    }
    /**
     * 
     * @return The collection of jobs that were changed
     */
	@SuppressWarnings("unchecked")
	public final Collection<Job> getJobs() {
        return (Collection<Job>) this.source;
    }
    /**
     * 
     * @return The first job that could have been changed
     */
    public final int getFirst() {
        return first;
    }
    /**
     * 
     * @return The last job that could have been changed
     */
    public final int getLast() {
        return last;
    }
}
