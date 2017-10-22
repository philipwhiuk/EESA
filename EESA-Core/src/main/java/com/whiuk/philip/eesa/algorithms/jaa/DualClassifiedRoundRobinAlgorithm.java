package com.whiuk.philip.eesa.algorithms.jaa;

import com.whiuk.philip.eesa.exceptions.AlgorithmException;
import com.whiuk.philip.eesa.algorithms.JobAssignmentAlgorithm;
import com.whiuk.philip.eesa.core.Job;
import com.whiuk.philip.eesa.core.JobSet;
import com.whiuk.philip.eesa.core.Processor;
import com.whiuk.philip.eesa.core.ProcessorResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Implements the Classified Round Robin algorithm as
 * described by P. C. Bell and P. W. H. Wong
 * @author Philip
 */
public class DualClassifiedRoundRobinAlgorithm 
	implements JobAssignmentAlgorithm {
    /**
     * 
     */
    private final String name = "Dual Classified Round-Robin Algorithm";
    /**
     * 
     */
    private final String desc = "Provides an implementation of "
    		+ "Dual-Classified Round-Robin as "
            + "described by P.C. Bell and P. Wong in "
    		+ "\"Multiprocessor Speed Scaling for "
    		+ "Jobs with Arbitrary Sizes and Deadlines\" (2009).";
    /**
     * 
     * @return The long description of the algorithm
     */
    @Override
	public final String getDescription() {
        return desc;
    }
    /**
     * 
     * @return The human friendly name of the algorithm
     */
    @Override
	public final String toString() {
        return name;
    }
    /**
     * 
     * @param js JobSet
     * @param p Processors
     * @return The set of processor results following assignment
     * @throws AlgorithmException 
     */
    @Override
	public final ProcessorResult[] runJobAssignment(final JobSet js,
    		final Processor[] p) throws AlgorithmException {
        /**
         * Method
         * 1) Determine Max(Density), delta         n
         * 2) Determine Max(Size), gamma            n
         * 2) Classify Jobs
         *      Sort the Jobs                       n(log(n))
         *      Loop through the jobs               n+c-1 comparisons
         * 3  Classify the Jobs
         *      Sort each the Job Class             c * (n/c)log(n/c)
         *      Loop through the jobs               c * ((n/c)+d-1))
         * 3) Perform Round Robin on JobClasses     
         *      Sort the Jobs                       cd * (n/cd)log(n/cd)
         *      Build the Result Objects            p
         *      Do The Assignment                   
         *      nlogn + nlog(n/c) + nlog(n/cd) + 2n + 2nc + cd - c - 1
         *                                          
         * @param js
         * @param processors
         * @return
         * @throws AlgorithmException 
         */
        if (p.length == 0) {
            throw new AlgorithmException("No processors!");
        }
        Map<Integer, DCRRJobClass> classes = 
        		new HashMap<Integer, DCRRJobClass>();
        ProcessorResult[] procResults = new ProcessorResult[p.length];
        for (int i = 0; i < procResults.length; i++) {
            procResults[i] = new ProcessorResult(p[i]);
        }
        List<Job> uJobs = js.getJobs();

        float maxDensity = 0;
        float maxWeight = 0;
        Iterator<Job> iJ = uJobs.iterator();
        while (iJ.hasNext()) {
            Job j = iJ.next();
            if (j.getDensity() > maxDensity) {
                maxDensity = j.getDensity();
            }
            if (j.getWeight() > maxWeight) {
                maxWeight = j.getWeight();
            }
        }
        //Sort By Weight
        Collections.sort(uJobs, new Comparator<Job>() {
            @Override
            public int compare(final Job j1, final Job j2) {
                if (j1.getWeight() > j2.getWeight()) {
                    return -1;
                } else if (j1.getWeight() > j2.getWeight()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        Iterator<Job> iJ2 = uJobs.iterator();
        classes.put(0, new DCRRJobClass());
        float weight = maxWeight;
        int currentClassW = 0;
        //Assign to Weight Class
        while (iJ2.hasNext()) {
            Job j = iJ2.next();
            while (j.getWeight() < weight) {
                weight /= 2;
                currentClassW++;
                classes.put(currentClassW, new DCRRJobClass());
            }
            classes.get(currentClassW).addJob(j);
        }
        //Sort By Density And Assign to Density Class
        Set<Entry<Integer, DCRRJobClass>> set = classes.entrySet();
        Iterator<Entry<Integer, DCRRJobClass>> iJC = set.iterator();
        while (iJC.hasNext()) {
            DCRRJobClass c = iJC.next().getValue();
            ArrayList<Job> jobs = c.getJobs();
            Collections.sort(jobs, new Comparator<Job>() {
                @Override
                public int compare(final Job j1, final Job j2) {
                    if (j1.getDensity() > j2.getDensity()) {
                        return -1;
                    } else if (j1.getDensity() > j2.getDensity()) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            });                        
            Iterator<Job> iJ3 = jobs.iterator();
            c.addJobClass(0, new CRRJobClass(maxDensity));
            float density = maxDensity;
            int currentClassD = 0;
            while (iJ3.hasNext()) {
                Job j = iJ3.next();
                while (j.getDensity() < density) {
                    density /= 2;
                    currentClassD++;
                    c.addJobClass(currentClassD, new CRRJobClass(density));
                }
                c.getJobClass(currentClassD).addJob(j);
            }
        }
        //Assign Jobs
        Set<Entry<Integer, DCRRJobClass>> setD = classes.entrySet();
        Iterator<Entry<Integer, DCRRJobClass>> iJD = setD.iterator(); 
        while (iJD.hasNext()) {
            //Per D
            DCRRJobClass d = iJD.next().getValue();
            Set<Entry<Integer, CRRJobClass>> setDC = d.
            		getJobClasses().entrySet();
            Iterator<Entry<Integer, CRRJobClass>> iJDC = setDC.iterator();
            while (iJDC.hasNext()) {
                //Per DC
                ArrayList<Job> jobs = iJDC.next().getValue().getJobs();
                Iterator<Job> iJ3 = jobs.iterator();
                int pID = 0;
                while (iJ3.hasNext()) {
                    if (pID >= p.length) {
                        pID = 0;
                    }
                    procResults[pID].addJob(iJ3.next());
                    pID++;
                }
            }
        }
        return procResults;
    }
}
