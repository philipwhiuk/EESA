package eesa.exceptions;

/**
 * 
 * @author Philip Whitehouse
 *
 */
public class SimulationLoadingException extends EESAException {

	/**
	 * 
	 * @param string message
	 */
	public SimulationLoadingException(final String string) {
		super(string);
	}

	/**
	 * 
	 * @param t Cause
	 */
	public SimulationLoadingException(final Throwable t) {
		super(t);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -1694754994855400606L;

}
