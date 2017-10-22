package com.whiuk.philip.eesa.exceptions;

/**
 * Indicates that the time interval created / updated was invalid.
 * @author Philip
 */
public class TimeIntervalException extends EESARuntimeException {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param msg Message
	 */
    public TimeIntervalException(final String msg) {
        super(msg);
    }
    
}
