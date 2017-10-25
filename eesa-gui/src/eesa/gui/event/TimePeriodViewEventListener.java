package eesa.gui.event;

/**
 * The listener that's notified when a change happens to the ability to view time periods.
 * @author Philip
 */
public interface TimePeriodViewEventListener extends java.util.EventListener {
	/**
	 * 
	 * @param event
	 */
	void timePeriodViewStatusChanged(TimePeriodViewEvent event);
}
