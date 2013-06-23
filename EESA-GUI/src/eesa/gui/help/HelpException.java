package eesa.gui.help;

import eesa.exceptions.EESAException;

/**
 * Describes an exception that is thrown by a help system.
 * @author Philip
 */
public class HelpException extends EESAException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     * @param ex
     */
    public HelpException(final Exception ex) {
        super(ex);
    }

    /**
     * 
     * @param string
     */
    public HelpException(final String string) {
        super(string);
    }
    
}
