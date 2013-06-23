package eesa.algorithms;

/**
 * Provides interface for generic properties of algorithms.
 * @author Philip Whitehouse
 *
 */
public interface Algorithm {
    /**
     * 
     * @return The human-friendly name of the algorithm
     */
    @Override
    String toString();
    /**
     * 
     * @return The long description of the Algorithm
     */
    String getDescription();
}
