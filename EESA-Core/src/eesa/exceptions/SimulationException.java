package eesa.exceptions;

/**
 * Describes an exception that is thrown by a simulation.
 * @author Philip
 */
public class SimulationException extends EESAException {
	/**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    
    /**
     * 
     * @param ex 
     */
    public SimulationException(final Throwable ex) {
        super(ex);
    }
    /**
     * 
     * @param message Message
     * @param ex Underlying exception
     */
    public SimulationException(final String message, final Throwable ex) {
        super(message, ex);
    }
    
}
