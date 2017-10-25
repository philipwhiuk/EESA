package eesa.gui.event;

/**
 * Provides information about changes in viewing of job results.
 * @author Philip
 */
public class JobResultViewEvent extends java.util.EventObject {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 
     * @param source
     */
    public JobResultViewEvent(final Object source) {
        super(source);
    }
}
