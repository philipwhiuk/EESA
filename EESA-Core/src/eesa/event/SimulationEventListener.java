package eesa.event;

/**
 * The listener that's notified when a change happens to a simulation.
 * @author Philip
 */
public interface SimulationEventListener extends EventListener {
    /**
     * 
     * @param event 
     */
    void simulationAdded(SimulationEvent event);
    /**
     * 
     * @param event 
     */
    void simulationRemoved(SimulationEvent event);
    /**
     * 
     * @param event 
     */
    void simulationAltered(SimulationEvent event);
    /**
     * 
     * @param event 
     */
    void simulationChanged(SimulationEvent event);
    /**
     * 
     * @param event 
     */
    void simulationSaveRequiredChangedEvent(SimulationEvent event);
}
