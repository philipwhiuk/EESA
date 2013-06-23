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
 * Performs tests to verify the {@link NaiveMinimumCompletionAlgorithm} class.
 * @author Philip
 */
public class NaiveJobCompletionAlgorithmTest {
    /**
     * 
     */
    public NaiveJobCompletionAlgorithmTest() {
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
     * Test of toString method, of class NaiveJobCompletionAlgorithm.
     */
    @Test
	public final void testToString() {
        System.out.println("toString");
        NaiveJobCompletionAlgorithm instance = 
        		new NaiveJobCompletionAlgorithm();
        String expResult = "Naive Job Completion Algorithm";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class NaiveJobCompletionAlgorithm.
     */
    @Test
	public final void testGetDescription() {
        System.out.println("getDescription");
        NaiveJobCompletionAlgorithm instance =
        		new NaiveJobCompletionAlgorithm();
        String expResult = "Provides an implementation of a naive offline "
    		+ "algorithm which completes jobs in order by calculating "
    		+ "speed based on min[d(j),a(j+1)], as described in: "
            + "http://www.columbia.edu/~cs2035/courses/ieor4405.S09/p2-1.ppt";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of isOnline method, of class NaiveJobCompletionAlgorithm.
     */
    @Test
	public final void testIsOnline() {
        System.out.println("isOnline");
        NaiveJobCompletionAlgorithm instance = 
        		new NaiveJobCompletionAlgorithm();
        boolean expResult = false;
        boolean result = instance.isOnline();
        assertEquals(expResult, result);
    }

    /**
     * Test of runSpeedScaling method, of class NaiveJobCompletionAlgorithm.
     * @throws AlgorithmException 
     */
    @Test
	public final void testRunSpeedScaling() throws AlgorithmException {
        System.out.println("runSpeedScaling");
        eesa.core.Test t = new eesa.core.Test();
        ProcessorResult p = new ProcessorResult();
        NaiveJobCompletionAlgorithm instance = 
        		new NaiveJobCompletionAlgorithm();
        instance.runSpeedScaling(t, p);
    }
}
