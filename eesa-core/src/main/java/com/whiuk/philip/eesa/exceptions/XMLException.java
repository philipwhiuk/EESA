package com.whiuk.philip.eesa.exceptions;


/**
 * Describes an exception that is thrown by the XML system.
 * @author Philip
 */
public class XMLException extends EESAException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     * @param ex Underlying exception
     */
    public XMLException(final Exception ex) {
        super(ex);
    }
    /**
     * 
     * @param msg Message
     */
    public XMLException(final String msg) {
        super(msg);
    }
    
}
