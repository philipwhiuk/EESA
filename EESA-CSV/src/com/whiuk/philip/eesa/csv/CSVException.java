package com.whiuk.philip.eesa.csv;

import com.whiuk.philip.eesa.exceptions.EESAException;

/**
 * Describes an exception that is thrown by the CSV module.
 * @author Philip
 */
public class CSVException extends EESAException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     * @param cause Cause
     */
    CSVException(final Throwable cause) {
        super(cause);
    }
    
}
