package eesa.gui.event;

/**
 * The listener that's notified when a change happens to the ability to view processor results.
 * @author Philip
 */
public interface ProcessorViewEventListener extends java.util.EventListener {
	/**
	 * 
	 * @param event
	 */
    void processorViewStatusChanged(ProcessorViewEvent event);
}
