package eesa.event;

import eesa.core.Simulation;

/**
 * Provides information about changes to a simulation.
 * @author Philip
 */
public class SimulationEvent extends EventObject {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 
     * @param simulation Source
     */
    public SimulationEvent(final Simulation simulation) {
        super(simulation);
    }

    /**
     * 
     * @return Event source
     */
    public final Simulation getSimulation() {
        return (Simulation) source;
    }
}
