package eesa.exceptions;

/**
 * Describes an exception that was thrown when an algorithm was loading.
 * @author Philip
 */
public class AlgorithmLoadingException extends AlgorithmException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * @param ex Underlying exception
     */
    public AlgorithmLoadingException(final Exception ex) {
        super(ex);
    }
    
}
