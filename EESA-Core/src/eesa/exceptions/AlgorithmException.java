package eesa.exceptions;

/**
 * Describes an exception that was thrown by/about an algorithm.
 * @author Philip
 */
public class AlgorithmException extends EESAException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    public AlgorithmException() {
        super();
    }
    /**
     * 
     * @param cause Cause
     */
    public AlgorithmException(final Throwable cause) {
        super(cause);
    }
    /**
     * 
     * @param message Message
     */
    public AlgorithmException(final String message) {
        super(message);
    }
    
}
