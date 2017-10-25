package com.whiuk.philip.eesa.db;

import com.whiuk.philip.eesa.exceptions.EESAException;

/**
 * Describes an exception thrown by the database module.
 * @author Philip
 */
public class DatabaseException extends EESAException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     * @param cause cause of exception
     */
    public DatabaseException(final Throwable cause) {
        super(cause);
    }

    /**
     * 
     * @param message message
     */
    DatabaseException(final String message) {
        super(message);
    }
}
