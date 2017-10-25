package com.whiuk.philip.eesa.exceptions;

/**
 * Describes an exception that was thrown when an algorithm was running.
 * @author Philip
 */
public class AlgorithmRuntimeException extends EESARuntimeException {
	/**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    /**
     * 
     * @param message Message
     */
    public AlgorithmRuntimeException(final String message) {
        super(message);
    }
    /**
     * 
     */
    public AlgorithmRuntimeException() {
        super();
    }
}
