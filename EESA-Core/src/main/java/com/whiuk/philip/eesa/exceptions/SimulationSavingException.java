package com.whiuk.philip.eesa.exceptions;

/**
 * Thrown when an error occurs saving a simulation.
 * @author Philip Whitehouse
 *
 */
public class SimulationSavingException extends EESAException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param string message
	 */
	public SimulationSavingException(final String string) {
		super(string);
	}

	/**
	 * 
	 * @param t Cause
	 */
	public SimulationSavingException(final Throwable t) {
		super(t);
	}
}
