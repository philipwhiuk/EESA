package eesa.algorithms.ssa;

import eesa.algorithms.jaa.RoundRobinAlgorithm;
import eesa.core.ProcessorResult;
import eesa.exceptions.AlgorithmException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


/**
 * Performs tests to verify the {@link NaiveMinimumSpeedAlgorithm} class.
 * @author Philip
 */
public class NaiveMinimumSpeedAlgorithmTest {
    /**
     * 
     */
    public NaiveMinimumSpeedAlgorithmTest() {
    }
    /**
     * 
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
     * Test of toString method, of class NaiveMinimumSpeedAlgorithm.
     */
    @Test
	public final void testToString() {
        System.out.println("toString");
        NaiveMinimumSpeedAlgorithm instance = new NaiveMinimumSpeedAlgorithm();
        String expResult = "Naive Minimum Speed Algorithm";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class NaiveMinimumSpeedAlgorithm.
     */
    @Test
	public final void testGetDescription() {
        System.out.println("getDescription");
        NaiveMinimumSpeedAlgorithm instance = new NaiveMinimumSpeedAlgorithm();
        String expResult = "Provides an implementation of a naive offline "
    		+ "algorithm which completes jobs by calculating the minimum "
    		+ "required speed for all jobs assuming they must finish "
    		+ "before the next starts and applying it as jobs speed"
    		+ " - uses MAX(density(j)) as described in: "
            + "http://www.columbia.edu/~cs2035/courses/ieor4405.S09/p2-1.ppt "
    		+ "by Rachel Ferst and Alan Papir";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of isOnline method, of class NaiveMinimumSpeedAlgorithm.
     */
    @Test
	public final void testIsOnline() {
        System.out.println("isOnline");
        NaiveMinimumSpeedAlgorithm instance = new NaiveMinimumSpeedAlgorithm();
        boolean expResult = false;
        boolean result = instance.isOnline();
        assertEquals(expResult, result);
    }

    /**
     * Test of runSpeedScaling method, of class NaiveMinimumSpeedAlgorithm.
     * @throws AlgorithmException 
     */
    @Test
	public final void testRunSpeedScaling() throws AlgorithmException {
        System.out.println("runSpeedScaling");
        eesa.core.Test t = new eesa.core.Test();
        ProcessorResult p = new ProcessorResult();
        NaiveMinimumSpeedAlgorithm instance = new NaiveMinimumSpeedAlgorithm();
        instance.runSpeedScaling(t, p);
    }
}
