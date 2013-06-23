package eesa.gui;

import eesa.exceptions.EESAException;

/**
 * Describes an exception that was thrown during image generation / rendering / usage.
 * @author Philip
 */
public class ImageException extends EESAException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 * @param cause
	 */
	public ImageException(final Throwable cause) {
        super(cause);
    }
    
}
