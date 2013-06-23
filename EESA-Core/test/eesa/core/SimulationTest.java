package eesa.core;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import eesa.algorithms.EESAAlgorithm;
import eesa.dataSource.SimulationDataSource;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

/**
 * Tests the behaviour of {@link Simulation}.
 * @author Philip
 */
public class SimulationTest {
    /**
     * 
     */
    public SimulationTest() {
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
     * Test of getDataSource method, of class Simulation.
     */
    @Test
	public final void testGetDataSource() {
        System.out.println("getFile");
        Simulation instance = new Simulation(Simulator.getSimulator());
        SimulationDataSource expResult = null;
        SimulationDataSource result = instance.getDataSource();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFile method, of class Simulation.
     */
    @Test
	public final void testSetFile() {
        System.out.println("setFile");
        SimulationDataSource source = null;
        Simulation instance = new Simulation(Simulator.getSimulator());
        instance.setDataSource(source);
    }

    /**
     * Test of addTest method, of class Simulation.
     */
    @Test
	public final void testAddTest() {
        System.out.println("addTest");
        EESAAlgorithm a = null;
        Simulation instance = new Simulation(Simulator.getSimulator());
        instance.addTest(a);
    }

    /**
     * Test of addProcessor method, of class Simulation.
     */
    @Test
	public final void testAddProcessor() {
        System.out.println("addProcessor");
        Processor p = null;
        Simulation instance = new Simulation(Simulator.getSimulator());
        instance.addProcessor(p);
    }

    /**
     * Test of setSaved method, of class Simulation.
     */
    @Test
	public final void testSetSaved() {
        System.out.println("setSaved");
        Simulation instance = new Simulation(Simulator.getSimulator());
        instance.setSaved();
    }

    /**
     * Test of setSaveRequired method, of class Simulation.
     */
    @Test
	public final void testSetSaveRequired() {
        System.out.println("setSaveRequired");
        Simulation instance = new Simulation(Simulator.getSimulator());
        instance.setSaveRequired();
    }

    /**
     * Test of isSaveRequired method, of class Simulation.
     */
    @Test
	public final void testIsSaveRequired() {
        System.out.println("isSaveRequired");
        Simulation instance = new Simulation(Simulator.getSimulator());
        boolean expResult = false;
        boolean result = instance.isSaveRequired();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProcessors method, of class Simulation.
     */
    @Test
	public final void testGetProcessors() {
        System.out.println("getProcessors");
        Simulation instance = new Simulation(Simulator.getSimulator());
        Processor[] expResult = new Processor[]{};
        Processor[] result = instance.getProcessors();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of setProcessors method, of class Simulation.
     */
    @Test
	public final void testSetProcessors() {
        System.out.println("setProcessors");
        ArrayList<Processor> processors = null;
        Simulation instance = new Simulation(Simulator.getSimulator());
        instance.setProcessors(processors);
    }

    /**
     * Test of hasJobs method, of class Simulation.
     */
    @Test
	public final void testHasJobs() {
        System.out.println("hasJobs");
        Simulation instance = new Simulation(Simulator.getSimulator());
        boolean expResult = false;
        boolean result = instance.hasJobs();
        assertEquals(expResult, result);
    }

    /**
     * Test of hasProcessor method, of class Simulation.
     */
    @Test
	public final void testHasProcessor() {
        System.out.println("hasProcessor");
        Simulation instance = new Simulation(Simulator.getSimulator());
        boolean expResult = false;
        boolean result = instance.hasProcessor();
        assertEquals(expResult, result);
    }

    /**
     * Test of changePowerFactor method, of class Simulation.
     */
    @Test
	public final void testChangePowerFactor() {
        System.out.println("changePowerFactor");
        float factor = 0.0F;
        Simulation instance = new Simulation(Simulator.getSimulator());
        instance.changePowerFactor(factor);
    }

    /**
     * Test of changeProcessorCount method, of class Simulation.
     */
    @Test
	public final void testChangeProcessorCount() {
        System.out.println("changeProcessorCount");
        int count = 0;
        Simulation instance = new Simulation(Simulator.getSimulator());
        instance.changeProcessorCount(count);
    }

    /**
     * Test of getPowerFactor method, of class Simulation.
     */
    @Test
	public final void testGetPowerFactor() {
        System.out.println("getPowerFactor");
        Simulation instance = new Simulation(Simulator.getSimulator());
        float expResult = 0.0F;
        float result = instance.getPowerFactor();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of removeTest method, of class Simulation.
     */
    @Test
	public final void testRemoveTest() {
        System.out.println("removeTest");
        int index = 0;
        Simulation instance = new Simulation(Simulator.getSimulator());
        instance.addTest(null);
        instance.removeTest(index);
    }

    /**
     * Test of getName method, of class Simulation.
     */
    @Test
	public final void testGetName() {
        System.out.println("getName");
        Simulation instance = new Simulation(Simulator.getSimulator());
        String expResult = "Untitled";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProcessorByID method, of class Simulation.
     */
    @Test
	public final void testGetProcessorByID() {
        System.out.println("getProcessorByID");
        int id = 0;
        Simulation instance = new Simulation(Simulator.getSimulator());
        Processor expResult = null;
        Processor result = instance.getProcessorByID(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of hasResults method, of class Simulation.
     */
    @Test
	public final void testHasResults() {
        System.out.println("hasResults");
        Simulation instance = new Simulation(Simulator.getSimulator());
        boolean expResult = false;
        boolean result = instance.hasResults();
        assertEquals(expResult, result);
    }
}
