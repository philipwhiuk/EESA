package eesa.cl;

import eesa.exceptions.EESARuntimeException;

/**
 * Wraps exceptions that occur on the command line into an unchecked form.
 * @author Philip Whitehouse
 *
 */
public class CommandLineException extends EESARuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param t Cause
	 */
	public CommandLineException(final Throwable t) {
		super(t);
	}

}
