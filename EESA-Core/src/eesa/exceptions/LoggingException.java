package eesa.exceptions;

/**
 * Describes an exception that is thrown by the logging system.
 * @author Philip
 */
public class LoggingException extends EESARuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public LoggingException() {
        super();
    }

    /**
     * 
     * @param message Message
     */
    public LoggingException(final String message) {
        super(message);
    }
    
}
