package com.whiuk.philip.eesa.algorithms.jaa;

import com.whiuk.philip.eesa.core.Job;
import java.util.ArrayList;

/**
 * Provides implementation of a Classified-Round-Robin
 * density-class as described by S. Albers, F. Muller and S. Schmelzer
 * @author Philip
 */
public class CRRJobClass {
    /**
     * The k-value associated with the density-class.
     */
    private final float kValue;
    /**
     * 
     */
    private ArrayList<Job> jobs = new ArrayList<Job>();
	/**
	 * 
	 * @param k
	 */
	public CRRJobClass(final float k) {
		kValue = k;
	}
	
    /**
     * 
     * @param j Job
     */
    public final void addJob(final Job j) {
        jobs.add(j);
    }

    /**
     * 
     * @return jobs in this class
     */
    public final ArrayList<Job> getJobs() {
        return jobs;
    }

	/**
	 * @return the kValue
	 */
	public final float getkValue() {
		return kValue;
	}
}
