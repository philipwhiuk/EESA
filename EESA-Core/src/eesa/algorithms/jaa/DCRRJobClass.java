package eesa.algorithms.jaa;

import eesa.core.Job;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Provides implementation of a Dual Classified Round Robin weight-class
 * as described by P. C. Bell and P. W. H. Wong
 * @author Philip
 */
public class DCRRJobClass {
    /**
     * 
     */
    private int hValue;
    /**
     * 
     */
    private Map<Integer, CRRJobClass> jobclasses;
    /**
     * 
     */
    private ArrayList<Job> jobs;
    /**
     * 
     */
    public DCRRJobClass() {
    	jobs = new ArrayList<Job>();
    	jobclasses = new HashMap<Integer, CRRJobClass>();
    }
    /**
     * 
     * @param i Class ID
     * @param jc Job Class
     */
    public final void addJobClass(final Integer i,
    		final CRRJobClass jc) {
        jobclasses.put(i, jc);
    }
    /**
     * Adds a job.
     * @param j Job
     */
	public final void addJob(final Job j) {
		jobs.add(j);
	}
	/**
	 * 
	 * @return The jobs
	 */
	public final ArrayList<Job> getJobs() {
		return jobs;
	}
	/**
	 * @param id The ID of the Job Class to fetch
	 * @return The CRRJobClass
	 */
	public final CRRJobClass getJobClass(final int id) {
		return jobclasses.get(id);
	}
	/**
	 * 
	 * @return mapping between class id and class
	 */
	public final Map<Integer, CRRJobClass> getJobClasses() {
		return jobclasses;
	}
}
