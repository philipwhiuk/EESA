package com.whiuk.philip.eesa.algorithms.jaa;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Performs tests to verify the {@link ClassifiedRoundRobinAlgorithm} class.
 * @author Philip
 */
public class ClassifiedRoundRobinAlgorithmTest {
    /**
     * 
     */
    public ClassifiedRoundRobinAlgorithmTest() {
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
     * Test of toString method, of class ClassifiedRoundRobinAlgorithm.
     */
    @Test
	public final void testToString() {
        System.out.println("toString");
        ClassifiedRoundRobinAlgorithm instance = 
        		new ClassifiedRoundRobinAlgorithm();
        String expResult = "Classified Round-Robin Algorithm";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class ClassifiedRoundRobinAlgorithm.
     */
    @Test
	public final void testGetDescription() {
        System.out.println("getDescription");
        ClassifiedRoundRobinAlgorithm instance =
        		new ClassifiedRoundRobinAlgorithm();
        String expResult = "Provides an implementation of "
        		+ "Classified-Round-Robin as described by S. Albers, "
        		+ "F. Muller and S. Schmelzer in \"Speed scaling "
        		+ "on parrelel processors\" (2007). ";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }
}
