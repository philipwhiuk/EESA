package com.whiuk.philip.eesa.exceptions;

/**
 * Describes an exception that is thrown when generating jobs.
 * @author Philip
 */
public class JobGeneratorException extends EESAException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     * @param message Message
     */
    public JobGeneratorException(final String message) {
        super(message);
    }
    
}
