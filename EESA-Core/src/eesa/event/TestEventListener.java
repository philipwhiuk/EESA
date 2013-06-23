package eesa.event;

/**
 * The listener that's notified when a change happens to a test.
 * @author Philip
 */
public interface TestEventListener extends EventListener {
    /**
     * 
     * @param event 
     */
    void testAdded(TestEvent event);
    /**
     * 
     * @param event 
     */
    void testRemoved(TestEvent event);
    /**
     * 
     * @param event 
     */
    void testAltered(TestEvent event);
    /**
     * 
     * @param event 
     */
    void testsAdded(TestEvent event);
    /**
     * 
     * @param event 
     */
    void testsRemoved(TestEvent event);
    /**
     * 
     * @param event 
     */
    void testsAltered(TestEvent event);
}
