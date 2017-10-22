package com.whiuk.philip.eesa.event;

/**
 * The listener that's notified when a change happens to a job.
 * @author Philip
 */
public interface JobEventListener extends EventListener {
    /**
     * Fired when a single job is added.
     * @param event 
     */
    void jobAdded(JobEvent event);
    /**
     * Fired when a single job is removed.
     * @param event 
     */
    void jobRemoved(JobEvent event);
    /**
     * Fired when a single job is altered.
     * @param event 
     */
    void jobAltered(JobEvent event);
    /**
     * Fired when many jobs are added.
     * @param event 
     */
    void jobsAdded(JobEvent event);
    /**
     * Fired when many jobs are removed.
     * @param event 
     */
    void jobsRemoved(JobEvent event);    
    /**
     * Fired when many jobs are altered.
     * @param event 
     */
    void jobsAltered(JobEvent event);
    /**
     * 
     * @param event 
     */
    void jobsReplaced(JobEvent event);
}
