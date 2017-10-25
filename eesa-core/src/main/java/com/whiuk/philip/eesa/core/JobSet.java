package com.whiuk.philip.eesa.core;

import com.whiuk.philip.eesa.event.JobEvent;
import com.whiuk.philip.eesa.event.JobEventListener;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
/**
 * JobSet (J) provides the job data collection in a single object. 
 * @author Philip
 */
public class JobSet implements Stored {
    /**
     * The list of jobs in the set.
     */
    private List<Job> jobs;
    /**
     * The next jobID that will be assigned.
     */
    private int nextJobID = 0;
    /**
     * The listeners attached to the set that response to events.
     */
    private List<JobEventListener> listeners;
    /**
     * Default Constructor.
     */
    public JobSet() {
        jobs = new ArrayList<Job>();
        listeners = new ArrayList<JobEventListener>();
    }
    /**
     * Constructs a JobSet from an array list
     * of jobs (Designed for temporary sets).
     * @param j 
     */
    public JobSet(final ArrayList<Job> j) {
        this.jobs = j;
        listeners = new ArrayList<JobEventListener>();
    }
    /**
     * The list of jobs for direct access (Avoid if possible).
     * @return Direct access to the list of jobs
     */
    public final List<Job> getJobs() {
        return jobs;
    }
    /**
     * Merges a ArrayList of jobs with the set.
     * @param j Jobs to merge
     */
    public final void addJobs(final ArrayList<Job> j) {
        if (j != null && j.size() > 0) {            
            for (int i = 0; i < j.size(); i++) {
                j.get(i).setID(this.getNextJobID());
            }
            this.jobs.addAll(j);
            firejobsAdded(j);
        }
    }
    /**
     * Replaces the set of jobs with a new set.
     * @param j jobs
     */
    public final void setJobs(final Collection<Job> j) {
        if (j == null) {
            throw new NullPointerException();
        } else {
            this.jobs = new ArrayList<Job>(j);
            firejobsReplaced(jobs);
        }
    }

    /**
     * Tests for emptiness.
     * @return Whether there are any jobs (true if there is at least 1 job)
     */
    public final boolean isNotEmpty() {
        return !this.jobs.isEmpty();
    }
    /**
     * Add a single job to the set.
     * @param job 
     */
    public final void addJob(final Job job) {
        if (job == null) {
            throw new NullPointerException("");
        } else {
            jobs.add(job);
            firejobAdded(job);
        }
    }
    /**
     * Removes a job by index.
     * @param index 
     */
    public final void removeJob(final int index) {
        Job j = jobs.remove(index);
        firejobRemoved(j);
    }
    /**
     * Removes a job by passing the job itself.
     * @param j 
     */
    public final void removeJob(final Job j) {
        jobs.remove(j);
        firejobRemoved(j);
    }
    /**
     * Passes back the next ID (increments the nextID whether used or not).
     * @return The next job id to be used.
     */
    public final int getNextJobID() {
        int returnVal = nextJobID;
        nextJobID++;
        return returnVal;
    }
    /**
     * Retrieves a job by index.
     * @param i rowIndex
     * @return The job at the given index (0-based)
     */
    public final Job getJob(final int i) {
        return jobs.get(i);
    }
    /**
     * Returns the size of the set.
     * @return The number of jobs in the set
     */
    public final int getSize() {
        return jobs.size();
    }
    /**
     * @param id The id
     * @return The job with the provided id (or null)
     */
    final Job getJobByID(final int id) {
        Iterator<Job> i = jobs.iterator();
        while (i.hasNext()) {
            Job j = i.next();
            if (j.getID() == id) {
                return j;
            }
        }
        return null;
    }
    /**
     * 
     * @param l 
     */
    public final void addJobEventListener(final JobEventListener l) {
        listeners.add(l);
    }
    /**
     * 
     * @param l 
     */
    public final void removeJobEventListener(final JobEventListener l) {
        listeners.remove(l);
    }
    /**
     * 
     * @param j The jobs that were added
     */
    private void firejobsAdded(final Collection<Job> j) {
        JobEvent event = new JobEvent(j, jobs.size() - j.size(),
        		jobs.size() - 1);
        Iterator<JobEventListener> i = listeners.iterator();
        while (i.hasNext()) {
            i.next().jobsAdded(event);
        }
    }
    /**
     * 
     * @param j The jobs that replaced the previous jobs
     */
    private void firejobsReplaced(final Collection<Job> j) {
        JobEvent event = new JobEvent(j, 0, jobs.size());
        Iterator<JobEventListener> i = listeners.iterator();
        while (i.hasNext()) {
            i.next().jobsReplaced(event);
        }
    }
    /**
     * 
     * @param j jobs
     * @param l listeners
     */
    public JobSet(final List<Job> j,
    		final List<JobEventListener> l) {
        this.jobs = j;
        this.listeners = l;
    }
    /**
     * 
     * @param job 
     */
    private void firejobAdded(final Job job) {
        JobEvent event = new JobEvent(job,
        		getIndexOfJob(job), getIndexOfJob(job));
        Iterator<JobEventListener> i = listeners.iterator();
        while (i.hasNext()) {
            i.next().jobAdded(event);
        }
    }
    /**
     * 
     * @param j 
     */
    private void firejobRemoved(final Job j) {
        JobEvent event = new JobEvent(j, getIndexOfJob(j), getIndexOfJob(j));
        Iterator<JobEventListener> i = listeners.iterator();
        while (i.hasNext()) {
            i.next().jobRemoved(event);
        }
    }

    /**
     * 
     * @param j job
     * @return the index of the given job
     */
    public final int getIndexOfJob(final Job j) {
        return jobs.indexOf(j);
    }
}
