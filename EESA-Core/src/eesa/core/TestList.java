package eesa.core;

import eesa.algorithms.EESAAlgorithm;
import eesa.event.TestEvent;
import eesa.event.TestEventListener;
import eesa.exceptions.AlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
/**
 * Provides a collection for all Tests. 
 * Useful for running common commands against all tests and provides
 * Tabular Data Commands for SimulationDataPanel
 * @author Philip
 */
public class TestList implements Stored {
    /**
     * 
     */
    private final ArrayList<Test> tests;
    /**
     * 
     */
    private ArrayList<JobResult> results;
    /**
     * 
     */
    private ArrayList<ProcessorSpeedTimePeriod> periods;
    /**
     * 
     */
    private ArrayList<TestEventListener> listeners;
    /**
     * 
     */
    private int tID = 0;
    /**
     * 
     */
    private Simulation simulation;
    /**
     * 
     * @param sim Simulation
     */
    public TestList(final Simulation sim) {
        this();
        simulation = sim;
    }
    /**
     * 
     */
    public TestList() {
        tests = new ArrayList<Test>();
        listeners = new ArrayList<TestEventListener>();
        results = new ArrayList<JobResult>();
        periods = new ArrayList<ProcessorSpeedTimePeriod>();
    }
    
    /**
     * 
     * @return Whether any of the tests have results
     */
    public final boolean hasResults() {
        for (int t = 0; t < tests.size(); t++) {
            if (tests.get(t).hasResults()) {
                return true;
            }
        }
        return false;
    }
    /**
     * 
     * @param a Algorithm
     */
    final void addTest(final EESAAlgorithm a) {
        while (getTestByID(tID) != null) {
            tID++;
        }
        Test t = new Test(simulation, tID, a);
        tests.add(t);
        tID++;
        fireTestAdded(t);
    }
    /**
     * 
     * @param test 
     */
    final void addTest(final Test test) {
        if (test != null) {
            tests.add(test);
            fireTestAdded(test);        
        }
    }
    /**
     * 
     * @throws AlgorithmException 
     */
    public final void runTests() throws AlgorithmException {
        for (int i = 0; i < tests.size(); i++) {
            tests.get(i).runAlgorithm();
        }
    }
    /**
     * 
     * @return Whether there are any tests in the list
     */
    public final boolean hasTests() {
        return !this.tests.isEmpty();
    }
    /**
     * 
     * @param i The index of the test to return
     * @return The test with the specified index in the list
     */
    public final Test getTest(final int i) {
        return this.tests.get(i);
    }
    /**
     * 
     * @return The number of tests in the list
     */
    public final int numberOfTests() {
        return this.tests.size();
    }
    /**
     * 
     */
    public final void compileResults() {
        results = new ArrayList<JobResult>();
        for (int t = 0; t < tests.size(); t++) {
            ProcessorResult[] procResults = tests.get(t).getResults().getProcessorResults();
            for (int p = 0; p < procResults.length; p++) {   
                if (procResults[p] != null) {
                    results.addAll(Arrays.asList(
                    		procResults[p].getJobResults()));
                }
            }
        }
    }
    /**
     * 
     * @return The total number of results in the compiled data
     */
    public final int getNumResults() {
        return results.size();
    }
    /**
     * 
     * @param i Index
     * @return The result with the given index from the compiled list
     */
    public final JobResult getResult(final int i) {
        return results.get(i);
    }
    /**
     * 
     */
    public final void compilePeriods() {
        periods = new ArrayList<ProcessorSpeedTimePeriod>();
        for (int t = 0; t < tests.size(); t++) {
            ProcessorResult[] procResults = tests.get(t)
            		.getResults().getProcessorResults();
            for (int p = 0; p < procResults.length; p++) {
                if (procResults[p] != null) {
                    periods.addAll(procResults[p].getSpeedTimePeriods());
                }
            }
        }
    }
    /**
     * 
     * @return The total number of periods in the compiled data
     */
    public final int getNumPeriods() {
        return periods.size();
    }
    /**
     * 
     * @param i The index of the period to return
     * @return The period with the index specified
     */
    public final ProcessorSpeedTimePeriod getPeriod(final int i) {
        return periods.get(i);
    }
    /**
     * 
     * @param index 
     */
    final void removeTest(final int index) {
        if (index >= 0 && index <= tests.size()) {
            Test t = tests.remove(index);
            fireTestRemoved(t);
        }
    }
    /**
     * 
     * @param id The unique identifier of the test to return
     * @return The test with the ID specified
     */
    final Test getTestByID(final int id) {
        Iterator<Test> i = tests.iterator();
        while (i.hasNext()) {
            Test t = i.next();
            if (t.getID() == id) {
                return t;
            }
        }
        return null;
    }
    /**
     * 
     * @param t The test to remove from the list
     */
    public final void removeTest(final Test t) {
        if (t != null) {
            tests.remove(t);
            fireTestRemoved(t);
        }
    }
    /**
     * 
     * @param l 
     */
    public final void addTestEventListener(final TestEventListener l) {
        listeners.add(l);
    }
    /**
     * 
     * @param l 
     */
    public final void removeTestEventListener(final TestEventListener l) {
        listeners.remove(l);
    }
    /**
     * 
     * @param t 
     */
    private void fireTestAdded(final Test t) {
        TestEvent event = new TestEvent(t, tests.indexOf(t), tests.indexOf(t));
        Iterator<TestEventListener> i = listeners.iterator();
        while (i.hasNext()) {
            i.next().testAdded(event);
        }
    }
    /**
     * 
     * @param t 
     */
    private void fireTestRemoved(final Test t) {
        TestEvent event = new TestEvent(t, tests.indexOf(t), tests.indexOf(t));
        Iterator<TestEventListener> i = listeners.iterator();
        while (i.hasNext()) {
            i.next().testRemoved(event);
        }
    }

    /**
     * 
     * @return results
     */
    public final JobResult[] getResults() {
        return this.results.toArray(new JobResult[]{});
    }
    /**
     * 
     * @return array of periods
     */
    public final ProcessorSpeedTimePeriod[] getPeriods() {
        return this.periods.toArray(new ProcessorSpeedTimePeriod[]{});
    }
}
