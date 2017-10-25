package eesa.gui.event;

import java.util.EventObject;
import javax.swing.event.ListSelectionEvent;

/**
 * Provides information about changes in viewing of tests.
 * @author Philip
 */
public class TestViewEvent extends EventObject {
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
     * @param s
     */
    public TestViewEvent(final ListSelectionEvent s) {
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
