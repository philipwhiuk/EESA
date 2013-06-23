package eesa.algorithms;

import eesa.core.ProcessorResult;
import eesa.core.Test;
import eesa.exceptions.AlgorithmException;

/**
 * Describes a Speed Scaling Algorithm.
 * @author Philip
 */
public interface SpeedScalingAlgorithm extends Algorithm {
    /**
     * Whether the algorithm works in an online fashion or not.
     * @return True if online, else false
     */
    boolean isOnline();
    /**
     * Performs the speed scaling for the jobs of a
     * single processor under the given test.
     * Note the processor result is stored in the test
     * @param t test
     * @param p processor result
     * @throws AlgorithmException 
     */
    void runSpeedScaling(Test t, ProcessorResult p) throws AlgorithmException;
}
