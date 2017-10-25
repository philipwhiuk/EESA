package eesa.gui.event;

import java.util.EventObject;
import javax.swing.event.ListSelectionEvent;

/**
 * Provides information about changes in viewing of processors.
 * @author Philip
 */
public class ProcessorViewEvent extends EventObject {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    private final ListSelectionEvent sourceEvent;
    /**
     * 
     * @param s sourceEvent
     */
    public ProcessorViewEvent(final ListSelectionEvent s) {
        super(s.getSource());
        this.sourceEvent = s;
    }
    /**
     * 
     * @return
     */
    public final ListSelectionEvent getSourceEvent() {
        return sourceEvent;
    }
}
