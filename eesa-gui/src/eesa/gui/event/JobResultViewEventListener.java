package eesa.gui.event;

/**
 * The listener that's notified when a change happens to the ability to view job results.
 * @author Philip
 */
public interface JobResultViewEventListener extends java.util.EventListener {
	
	/**
	 * 
	 * @param event
	 */
    void jobResultViewStatusChanged(JobResultViewEvent event);
    
}
