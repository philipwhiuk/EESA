package com.whiuk.philip.eesa.core;

import com.whiuk.philip.eesa.algorithms.EESAAlgorithm;
import com.whiuk.philip.eesa.dataSource.SimulationDataSource;
import com.whiuk.philip.eesa.exceptions.AlgorithmException;
import com.whiuk.philip.eesa.exceptions.AlgorithmRuntimeException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Describes a single simulation - containing references to results. 
 * Provides JMenuItem functionality for the Simulation Selector SubMenu
 * 
 * @author Philip
 */
public class Simulation implements Stored {
    /**
     * The set of jobs in the simulation.
     */
    private JobSet jobs;
    /**
     * The list of processors.
     */
    private ArrayList<Processor> processors;
    /**
     * The list of tests.
     */
    private TestList tests;
    /**
     * The simulation container to which the simulation is attached.
     */
    private Simulator sim;
    /**
     * The name (filename of the simulation).
     */
    private String name;
    /**
     * The storage for the simulation.
     */
    private SimulationDataSource source;
    /**
     * The power factor used by the simulation.
     */
    private float powerFactor;
    /**
     * Whether the simulation has changed since
     * it was saved (assuming changes are reported).
     */
    private boolean saveRequired;
    /**
     * The next processor ID to use as a unique ID.
     */
    private int pID = 0;
    /**
     * Simplified Constructor that uses "Untitled" as a default name.
     * @param s Simulator
     */
    public Simulation(final Simulator s) {
        this(s, "Untitled");
    }    
    /**
     * Constructor. Private as the correct method of
     * generating a blank simulation is
     * 'Simulation.New'.
     * Workaround as 'new Simulation()' is called by Load and New. 
     * @param s Simulation 
     * @param n Simulation name (not filename) 
     */
    private Simulation(final Simulator s, final String n) {
        this.sim = s;        
        this.name = n;
        processors = new ArrayList<Processor>();
        jobs = new JobSet();
        tests = new TestList(this);         
    }
    /**
     * Returns the data source this simulation is stored in .
     * @return The data source (may be null)
     */
    public final SimulationDataSource getDataSource() {
        return this.source;        
    }
    /**
     * Sets the data source this simulation is stored in.
     * @param s The data source this simulation is stored in
     */
    public final void setDataSource(final SimulationDataSource s) {
        this.source = s;
    }
    /**
     * Runs the algorithms on all the tests.
     * @throws AlgorithmRuntimeException
     * @throws AlgorithmException  
     */
    public final void runAlgorithms() throws AlgorithmException {
        if (hasJobs() & getTestList().hasTests() & hasProcessor()) {            
            getTestList().runTests();
        } else {
            throw new AlgorithmRuntimeException();
        }
    }
    /**
     * Adds a pair of algorithms as a new test to perform.
     * @param a Algorithm
     */
    public final void addTest(final EESAAlgorithm a) {
       tests.addTest(a);
    }
    /**
     * Adds a processor to the list.
     * @param p 
     */
    public final void addProcessor(final Processor p) {
        processors.add(p);
    }
    /**
     * Marks the simulation as being saved.
     */
    public final void setSaved() {
        saveRequired = false;
        sim.fireSimulationSaveRequiredChangedEvent(this);
    }
    /**
     * Marks the simulation as needing saving.
     */
    public final void setSaveRequired() {
        saveRequired = true;
        sim.fireSimulationSaveRequiredChangedEvent(this);
    }
    /**
     * Whether the simulation has unsaved data or not.
     * (Assuming changes are reported)
     * @return true if it needs saving, else false
     */
    public final boolean isSaveRequired() {
        return saveRequired;
    }
    /**
     * Returns the processors.
     * @return A safe array of the all processors in the simulation
     */
    public final Processor[] getProcessors() {
        return this.processors.toArray(new Processor[]{});
    }
    /**
     * Sets the processors as the given list.
     * @param p The processors
     */
    public final void setProcessors(final ArrayList<Processor> p) {
       this.processors = p; 
    }
    /**
     * Whether the simulation has at least 1 or more jobs.
     * @return true if 1+
     */
    public final boolean hasJobs() {
        return this.jobs.isNotEmpty();
    }
    /**
     * Whether the simulation has 1 or more processors.
     * @return true if 1+
     */
    public final boolean hasProcessor() {
        return !this.processors.isEmpty();
    }
    /**
     * Alters the exponent applied to calculate the power
     * from the speed. The power is calculated according
     * to the following formula:
     * P = s^a     
     * @param factor The new power factor
     */
    public final void changePowerFactor(final float factor) {
        powerFactor = factor;
    }
    /**
     * Provides a way of quickly setting up N processors.
     * @param count The number of processors
     */
    public final void changeProcessorCount(final int count) {
        this.processors = new ArrayList<Processor>();
        for (int p = 0; p < count; p++) {
            processors.add(new Processor(pID));
            pID++;
        }
    }
    /**
     * Returns the exponent applied to the processor speed.
     * to calculate the power used.
     * @return the exponent
     */
    public final float getPowerFactor() {
        return powerFactor;
    }
    /**
     * Returns the set of jobs attached to the simulation.
     * @return set of jobs
     */
    public final JobSet getJobSet() {
        return this.jobs;
    }
    /**
     * 
     * @return The list of tests to be run by the simulation.
     */
    public final TestList getTestList() {
        return this.tests;
    }
    /**
     * 
     * @param t The list of tests to be run by the simulation.
     */
    public final void setTestList(final TestList t) {
        this.tests = t;
    }
    /**
     * 
     * @param j The set of jobs processed in the simulation.
     */
    public final void setJobSet(final JobSet j) {
        this.jobs = j;
    }
    /**
     * 
     * @param index The index of the test that is to be removed.
     */
    public final void removeTest(final int index) {
        tests.removeTest(index);
    }
    /**
     * 
     * @return The name of the simulation (file name).
     */
    public final String getName() {
        return name;
    }
    /**
     * 
     * @param id The unique identifier of the processor to retrieve
     * @return The processor with the specified ID
     */
    final Processor getProcessorByID(final int id) {
        Iterator<Processor> i = processors.iterator();
        while (i.hasNext()) {
            Processor p = i.next();
            if (p.getID() == id) {
                return p;
            }
        }
        return null;
    }
    /**
     * Whether the simulation has 1 or more results stored (true).
     * or otherwise (false).
     * @return True if results are present
     */
    public final boolean hasResults() {
        return getTestList().hasResults();
    }
}
