package eesa.algorithms.jaa;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Performs tests to verify the {@link DualClassifiedRoundRobinAlgorithm} class.
 * @author Philip
 */
public class DualClassifiedRoundRobinAlgorithmTest {
    /**
     * 
     */
    public DualClassifiedRoundRobinAlgorithmTest() {
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
     * Test of getDescription method of DualClassifiedRoundRobinAlgorithm.
     */
    @Test
	public final void testGetDescription() {
        System.out.println("getDescription");
        DualClassifiedRoundRobinAlgorithm instance = 
        		new DualClassifiedRoundRobinAlgorithm();
        String expResult = "Provides an implementation of "
        	+ "Dual-Classified Round-Robin as "
            + "described by P.C. Bell and P. Wong "
        	+ "in \"Multiprocessor Speed Scaling for Jobs with Arbitrary Sizes "
            + "and Deadlines\" (2009).";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class DualClassifiedRoundRobinAlgorithm.
     */
    @Test
	public final void testToString() {
        System.out.println("toString");
        DualClassifiedRoundRobinAlgorithm instance =
        		new DualClassifiedRoundRobinAlgorithm();
        String expResult = "Dual Classified Round-Robin Algorithm";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
