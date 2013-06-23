package eesa.core;

import eesa.algorithms.EESAAlgorithm;
import eesa.event.SimulationEvent;
import eesa.event.SimulationEventListener;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;

/**
 * The container and manager for Simulations within the system.
 * @author Philip
 */
public final class Simulator {
	/**
	 * Class logger.
	 */
	private static java.util.logging.Logger logger =
			java.util.logging.Logger.getLogger(Simulator.class.getName());
	
    /**
     * A static reference to the simulator (Singleton).
     */
    private static Simulator simulator;
    /**
     * 
     * @param file
     * @return  
     */   
    /**
     * Provides access to the singleton Simulator object -
     * cleans up system access. 
     * @return The singleton Simulator object
     */
    public static Simulator getSimulator() {
        if (simulator == null) {
            simulator = new Simulator();
        }
        return simulator;
    }
    /**
     * A list of all loaded algorithms.
     */
    private ArrayList<EESAAlgorithm> algorithmList;
    /**
     * A list of all open simulations.
     */
    private ArrayList<Simulation> simulations;    
    /**
     * Reference to the current simulation.
     */
    private Simulation currentSimulation;
    /**
     * All registered simulation event listeners.
     */
    private ArrayList<SimulationEventListener> listeners;
    /**
     * The singleton constructor.
     */
    private Simulator() {
        simulations = new ArrayList<Simulation>();
        listeners = new ArrayList<SimulationEventListener>();
    }
    /**
     * Returns the current simulation.
     * @return Current simulation
     */
    public Simulation getCurrentSimulation() {
        return currentSimulation;
    }
    /**
     * Returns the simulation with the given index.
     * @param i Index
     * @return The simulation
     */
    public Simulation getSimulation(final int i) {
        return simulations.get(i);
    }
    /**
     * Returns a safe array (not backed) of open simulations.
     * @return List of simulations
     */
    public Simulation[] getSimulations() {
        return simulations.toArray(new Simulation[]{});
    }
    /**
     * Provides the number of open simulations.
     * @return The number of simulations
     */
    public int getSimulationCount() {
        return simulations.size();
    }
    /**
     * Changes the current simulation to the one specified.
     * @param s 
     */
    public void setCurrentSimulation(final Simulation s) {
        if (s != null) {
            currentSimulation = s;
            fireSimulationChanged(s);
        }
    }
    /**
     * Adds a new simulation to the list.
     * @param s 
     */
    public void addSimulation(final Simulation s) {
        if (s != null) {
            simulations.add(s);
            fireSimulationAdded(s);
        }
    }
    /**
     * Removes a simulation.
     * @param s 
     */
    public void removeSimulation(final Simulation s) {
        simulations.remove(s);
        fireSimulationRemoved(s);
    }
    /**
     * Provides information on if there are any unsaved simulations.
     * @return true if 1+ is unsaved
     */
    public boolean hasUnsavedSimulations() {
        Iterator<Simulation> i = simulations.iterator();
        while (i.hasNext()) {
            if (i.next().isSaveRequired()) {
                return true;
            }
        }
        return false;
    }
    /**
     * Adds a  listener for simulation events.
     * @param l 
     */
    public void addSimulationEventListener(final SimulationEventListener l) {
        if (l != null) {
            listeners.add(l);
        }
    }
    /**
     * Removes a listener for simulation events.
     * @param l 
     */
    public void removeSimulationEventListener(final SimulationEventListener l) {
        listeners.remove(l);
    }
    /**
     * Notifies listeners that a simulation has changed.
     * @param s 
     */
    private void fireSimulationChanged(final Simulation s) {
        SimulationEvent event = new SimulationEvent(s);
        Iterator<SimulationEventListener> i = listeners.iterator();
        while (i.hasNext()) {
            i.next().simulationChanged(event);
        }
    }
    /**
     * Notifies listeners that a simulation has been added.
     * @param s 
     */
    private void fireSimulationAdded(final Simulation s) {
        SimulationEvent event = new SimulationEvent(s);
        Iterator<SimulationEventListener> i = listeners.iterator();
        while (i.hasNext()) {
            i.next().simulationAdded(event);
        }
    }
    /**
     * Notifies listeners that a simulation has been removed.
     * @param s 
     */
    private void fireSimulationRemoved(final Simulation s) {
        SimulationEvent event = new SimulationEvent(s);
        Iterator<SimulationEventListener> i = listeners.iterator();
        while (i.hasNext()) {
            i.next().simulationRemoved(event);
        }
    }
    /**
     * @param s Simulation
     */
    void fireSimulationSaveRequiredChangedEvent(final Simulation s) {
        SimulationEvent event = new SimulationEvent(s);
        Iterator<SimulationEventListener> i = listeners.iterator();
        while (i.hasNext()) {
            i.next().simulationSaveRequiredChangedEvent(event);
        }        
    }
}
