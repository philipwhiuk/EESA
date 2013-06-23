package eesa.gui.event;

/**
 * Provides information about changes in viewing of time periods.
 * @author Philip
 */
public class TimePeriodViewEvent extends java.util.EventObject {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     * @param source
     */
    public TimePeriodViewEvent(final Object source) {
        super(source);
    }
}
