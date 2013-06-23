package eesa.core;

import eesa.algorithms.AssignmentAndScalingAlgorithm;
import eesa.algorithms.EESAAlgorithm;
import eesa.algorithms.jaa.RoundRobinAlgorithm;
import eesa.algorithms.ssa.AVRAlgorithm;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Tests the behaviour of {@link Test}.
 * @author Philip
 */
public class TestTest {
    /**
     * 
     */
    public TestTest() {
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
     * Test of getSimulation method, of class Test.
     */
    @Test
	public final void testGetSimulation() {
        System.out.println("getSimulation");
        eesa.core.Test instance = new eesa.core.Test();
        Simulation expResult = null;
        Simulation result = instance.getSimulation();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAlgorithm method, of class Test.
     */
    @Test
	public final void testGetAlgorithm() {
        System.out.println("getJAA");
        eesa.core.Test instance = new eesa.core.Test();
        EESAAlgorithm expResult = null;
        EESAAlgorithm result = instance.getAlgorithm();
        assertEquals(expResult, result);
    }

    /**
     * Test of hasResults method, of class Test.
     */
    @Test
	public final void testHasResults() {
        System.out.println("hasResults");
        eesa.core.Test instance = new eesa.core.Test();
        boolean expResult = false;
        boolean result = instance.hasResults();
        assertEquals(expResult, result);
    }


    /**
     * Test of getID method, of class Test.
     */
    @Test
	public final void testGetID() {
        System.out.println("getID");
        eesa.core.Test instance = new eesa.core.Test();
        int expResult = 0;
        int result = instance.getID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAlgorithmPair method, of class Test.
     */
    @Test
	public final void testGetAlgorithmPair() {
        System.out.println("getAlgorithmPair");
        eesa.core.Test instance = new eesa.core.Test(
        		new Simulation(Simulator.getSimulator()), 0, 
        		new AssignmentAndScalingAlgorithm(
        				new RoundRobinAlgorithm(), new AVRAlgorithm()));
        String expResult = "Round-Robin Algorithm & AVerage Rate Algorithm";
        String result = instance.getAlgorithmName();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Test.
     */
    @Test
	public final void testToString() {
        System.out.println("toString");
        eesa.core.Test instance = new eesa.core.Test(
        		new Simulation(Simulator.getSimulator()), 0, 
        		new AssignmentAndScalingAlgorithm(
        				new RoundRobinAlgorithm(), new AVRAlgorithm()));
        String expResult = "0. Round-Robin Algorithm & AVerage Rate Algorithm";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of setJAA method, of class Test.
     */
    @Test
	public final void testSetAlgorithm() {
        System.out.println("setJAA");
        EESAAlgorithm a = null;
        eesa.core.Test instance = new eesa.core.Test();
        instance.setAlgorithm(a);
    }
}
