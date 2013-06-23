package eesa.algorithms;

import eesa.core.JobSet;
import eesa.core.Processor;
import eesa.core.ProcessorResult;
import eesa.exceptions.AlgorithmException;

/**
 * The super-interface for all algorithms which assign jobs to processors:
 * e.g. Round-Robin, Classified Round-Robin and Classified Round-Robin
 * @author Philip
 */
public interface JobAssignmentAlgorithm extends Algorithm {
    /**
     * 
     * @param js The set of jobs to be assigned
     * @param processors The processors to assign the jobs to
     * @return The set of processors with jobs assigned to them
     * @throws AlgorithmException Indicates an algorithm loading problem
     */
    ProcessorResult[] runJobAssignment(JobSet js, Processor[] processors)
    		throws AlgorithmException;

}
