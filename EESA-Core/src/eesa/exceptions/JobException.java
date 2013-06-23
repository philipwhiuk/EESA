package eesa.exceptions;

/**
 * Describes an exception that is thrown by a job.
 * @author Philip
 */
public class JobException extends EESAException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 
     * @param message Message
     */
    public JobException(final String message) {
        super(message);
    }
    
}
