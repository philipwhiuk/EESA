package com.whiuk.philip.eesa.core;

import com.whiuk.philip.eesa.event.SimulationEvent;
import com.whiuk.philip.eesa.event.SimulationEventListener;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Tests the behaviour of {@link Simulator}.
 * @author Philip
 */
public class SimulatorTest {
    /**
     * 
     */
    public SimulatorTest() {
    }
    /**
     * 
     * @throws Exception
     */
    @BeforeClass
    public static void setUpClass() {
    }
    /**
     * 
     * @throws Exception
     */
    @AfterClass
    public static void tearDownClass() {
    }
    /**
     * 
     */
    @Before
    public void setUp() {
    }
    /**
     * 
     */
    @After
    public void tearDown() {
    }

    /**
     * Test of getSimulator method, of class Simulator.
     */
    @Test
	public final void testGetSimulator() {
        System.out.println("getSimulator");
        Simulator expResult = Simulator.getSimulator();
        Simulator result = Simulator.getSimulator();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSimulation method, of class Simulator.
     */
    @Test
	public final void testGetSimulation() {
        System.out.println("getSimulation");
        int i = 0;
        Simulator instance = Simulator.getSimulator();
        Simulation expResult = new Simulation(instance);
        instance.addSimulation(expResult);
        Simulation result = instance.getSimulation(i);
        assertEquals(expResult, result);
    }

    /**
     * Test of getSimulations method, of class Simulator.
     */
    @Test
	public final void testGetSimulations() {
        System.out.println("getSimulations");
        Simulator instance = Simulator.getSimulator();
        int expResult = 1;
        Simulation[] result = instance.getSimulations();
        assertEquals(expResult, result.length);
    }

    /**
     * Test of getSimulationCount method, of class Simulator.
     */
    @Test
	public final void testGetSimulationCount() {
        System.out.println("getSimulationCount");
        Simulator instance = Simulator.getSimulator();
        int expResult = 1;
        int result = instance.getSimulationCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCurrentSimulation method, of class Simulator.
     */
    @Test
	public final void testSetCurrentSimulation() {
        System.out.println("setCurrentSimulation");
        Simulation s = null;
        Simulator instance = Simulator.getSimulator();
        instance.setCurrentSimulation(s);
        assertEquals(s, instance.getCurrentSimulation());
    }

    /**
     * Test of addSimulation method, of class Simulator.
     */
    @Test
	public final void testAddSimulation() {
        System.out.println("addSimulation");
        Simulation s = null;
        Simulator instance = Simulator.getSimulator();        
        instance.addSimulation(s);
        assertEquals(instance.getSimulationCount(), 1);
    }

    /**
     * Test of removeSimulation method, of class Simulator.
     */
    @Test
	public final void testRemoveSimulation() {
        System.out.println("removeSimulation");
        Simulator instance = Simulator.getSimulator();
        Simulation s = new Simulation(instance);
        instance.addSimulation(s);
        instance.removeSimulation(s);
    }
    
    /**
     * Test of hasUnsavedSimulations method, of class Simulator.
     */
    @Test
	public final void testHasUnsavedSimulations() {
        System.out.println("hasUnsavedSimulations");
        Simulator instance = Simulator.getSimulator();
        boolean expResult = false;
        boolean result = instance.hasUnsavedSimulations();
        assertEquals(expResult, result);
    }

    /**
     * Test of addSimulationEventListener method, of class Simulator.
     */
    @Test
	public final void testAddSimulationEventListener() {
        System.out.println("addSimulationEventListener");
        SimulationEventListener l = null;
        Simulator instance = Simulator.getSimulator();
        instance.addSimulationEventListener(l);
    }

    /**
     * Test of removeSimulationEventListener method, of class Simulator.
     */
    @Test
	public final void testRemoveSimulationEventListener() {
        System.out.println("removeSimulationEventListener");
        SimulationEventListener l = new SimulationEventListener() {
            @Override
            public void simulationAdded(final SimulationEvent event) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
            @Override
            public void simulationRemoved(final SimulationEvent event) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
            @Override
            public void simulationAltered(final SimulationEvent event) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
            @Override
            public void simulationChanged(final SimulationEvent event) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
            @Override
            public void simulationSaveRequiredChangedEvent(
            		final SimulationEvent event) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
        Simulator instance = Simulator.getSimulator();
        instance.addSimulationEventListener(l);
        instance.removeSimulationEventListener(l);
    }

    /**
     * Test of fireSimulationSaveRequiredChangedEvent method of class Simulator.
     */
    @Test
	public final void testFireSimulationSaveRequiredChangedEvent() {
        System.out.println("fireSimulationSaveRequiredChangedEvent");
        Simulator instance = Simulator.getSimulator();
        Simulation s = new Simulation(instance);        
        instance.fireSimulationSaveRequiredChangedEvent(s);
    }
}
