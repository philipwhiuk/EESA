package eesa.gui.event;

/**
 * The listener that's notified when a change
 * happens to the ability to view tests.
 * @author Philip
 */
public interface TestViewEventListener extends java.util.EventListener {
    /**
     * 
     * @param event
     */
    void testViewStatusChanged(TestViewEvent event);
}
