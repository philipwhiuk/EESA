package eesa.algorithms.jaa;

import eesa.exceptions.AlgorithmException;
import eesa.algorithms.JobAssignmentAlgorithm;
import eesa.core.Job;
import eesa.core.JobSet;
import eesa.core.Processor;
import eesa.core.ProcessorResult;
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
 * described by S. Albers, F. Muller and S. Schmelzer 
 * @author Philip
 */
public class ClassifiedRoundRobinAlgorithm implements JobAssignmentAlgorithm {
    /**
     * 
     */
    private final String name = "Classified Round-Robin Algorithm";
    /**
     * 
     */
    private final String desc = "Provides an implementation of "
    		+ "Classified-Round-Robin as described by S. Albers, "
    		+ "F. Muller and S. Schmelzer in \"Speed scaling on "
    		+ "parrelel processors\" (2007). ";
    
    @Override
	public final String toString() {
        return name;
    }
    @Override
	public final String getDescription() {
        return desc;
    }
    /**
     * Runs the classified round-robin job assignment
     * algorithm on the given jobs.
     * Method
     * 1) Determine Max(Density), delta         n
     * 2) Classify Jobs
     *      Sort the Jobs                       n(log(n))
     *      Loop through the jobs               n+c-1 comparisons
     * 3) Perform Round Robin on JobClasses     
     *      Sort the Jobs                       c * (n/c)log(n/c)
     *      Build the Result Objects            
     *      Do The Assignment                   
     *                                          nlogn + 2n+c + nlog(n/c)
     * @param js JobSet
     * @param processors Processors
     * @return The set of results for each processor following assignment
     * @throws AlgorithmException 
     */
    @Override
	public final ProcessorResult[] runJobAssignment(
			final JobSet js,
			final Processor[] processors) throws AlgorithmException {
        if (processors.length == 0) {
            throw new AlgorithmException("No processors!");
        }
        Map<Integer, CRRJobClass> classes = new HashMap<Integer, CRRJobClass>();
        ProcessorResult[] procResults = new ProcessorResult[processors.length];
        for (int p = 0; p < procResults.length; p++) {
            procResults[p] = new ProcessorResult(processors[p]);
        }
        List<Job> uJobs = js.getJobs();

        float maxDensity = 0;
        Iterator<Job> iJ = uJobs.iterator();
        while (iJ.hasNext()) {
            Job j = iJ.next();
            if (j.getDensity() > maxDensity) {
                maxDensity = j.getDensity();
            }
        }
        
        Collections.sort(uJobs, new Comparator<Job>() {
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
        Iterator<Job> iJ2 = uJobs.iterator();
        classes.put(0, new CRRJobClass(0));
        float density = maxDensity;
        int currentClass = 0;
        while (iJ2.hasNext()) {
            Job j = iJ2.next();
            while (j.getDensity() < density) {
                density /= 2;
                currentClass++;
                classes.put(currentClass, new CRRJobClass(density));
            }
            classes.get(currentClass).addJob(j);
        }
        
        Set<Entry<Integer, CRRJobClass>> set = classes.entrySet();
        Iterator<Entry<Integer, CRRJobClass>> iJC = set.iterator();
        while (iJC.hasNext()) {
            ArrayList<Job> jobs = iJC.next().getValue().getJobs();
            Collections.sort(jobs, new Comparator<Job>() {
                @Override
                public int compare(final Job j1, final Job j2) {
                    if (j1.getReleaseTime() < j2.getReleaseTime()) {
                    	return -1;
                    } else if (j1.getReleaseTime() == j2.getReleaseTime()) {
                    	return 0;
                    } else {
                    	return 1;
                    }
                }

            });            
            Iterator<Job> iJ3 = jobs.iterator();
            int pID = 0;
            while (iJ3.hasNext()) {
                if (pID >= processors.length) {
                    pID = 0;
                }
                procResults[pID].addJob(iJ3.next());
                pID++;
            }
        }
        return procResults;
    }
    
}
