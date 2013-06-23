package eesa.exceptions;

/**
 * Describes an exception that is thrown when an error with a file occurs.
 * @author Philip
 */
public class FileException extends EESAException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public FileException() {
        super();
    }
    /**
     * 
     * @param message Message
     */
    public FileException(final String message) {
        super(message);
    }
    
}
