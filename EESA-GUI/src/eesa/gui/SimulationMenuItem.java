package eesa.gui;

import eesa.core.Simulation;
import javax.swing.JMenuItem;

/**
 * Provides a menu item that connects to an open {@link eesa.core.Simulation}.
 * @author Philip
 */
public class SimulationMenuItem extends JMenuItem {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    private final Simulation simulation;
    /**
     * 
     * @param s
     */
    public SimulationMenuItem(final Simulation s) {
        simulation = s;
        setText(simulation.getName());
    }

    /**
     * 
     * @return
     */
    final Simulation getSimulation() {
        return simulation;
    }
}
