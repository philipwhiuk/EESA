package com.whiuk.philip.eesa.core;

import com.whiuk.philip.eesa.algorithms.AssignmentAndScalingAlgorithm;
import com.whiuk.philip.eesa.algorithms.EESAAlgorithm;
import com.whiuk.philip.eesa.algorithms.jaa.RoundRobinAlgorithm;
import com.whiuk.philip.eesa.algorithms.ssa.AVRAlgorithm;
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
        com.whiuk.philip.eesa.core.Test instance = new com.whiuk.philip.eesa.core.Test();
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
        com.whiuk.philip.eesa.core.Test instance = new com.whiuk.philip.eesa.core.Test();
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
        com.whiuk.philip.eesa.core.Test instance = new com.whiuk.philip.eesa.core.Test();
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
        com.whiuk.philip.eesa.core.Test instance = new com.whiuk.philip.eesa.core.Test();
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
        com.whiuk.philip.eesa.core.Test instance = new com.whiuk.philip.eesa.core.Test(
        		new Simulation(Simulator.getSimulator()), 0, 
        		new AssignmentAndScalingAlgorithm(
        				new RoundRobinAlgorithm(), new AVRAlgorithm()));
        String expResult = "Assignment & Scaling Algorithm";
        String result = instance.getAlgorithmName();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Test.
     */
    @Test
	public final void testToString() {
        System.out.println("toString");
        com.whiuk.philip.eesa.core.Test instance = new com.whiuk.philip.eesa.core.Test(
        		new Simulation(Simulator.getSimulator()), 0, 
        		new AssignmentAndScalingAlgorithm(
        				new RoundRobinAlgorithm(), new AVRAlgorithm()));
        String expResult = "0. Assignment & Scaling Algorithm";
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
        com.whiuk.philip.eesa.core.Test instance = new com.whiuk.philip.eesa.core.Test();
        instance.setAlgorithm(a);
    }
}
