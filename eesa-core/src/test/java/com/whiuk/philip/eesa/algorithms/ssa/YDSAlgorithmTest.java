package com.whiuk.philip.eesa.algorithms.ssa;

import com.whiuk.philip.eesa.core.ProcessorResult;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


/**
 * Performs tests to verify the {@link YDSAlgorithm} class.
 * @author Philip
 */
public class YDSAlgorithmTest {
    /**
     * 
     */
    public YDSAlgorithmTest() {
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
     * Test of toString method, of class YDSAlgorithm.
     */
    @Test
	public final void testToString() {
        System.out.println("toString");
        YDSAlgorithm instance = new YDSAlgorithm();
        String expResult = "YDS Algorithm";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class YDSAlgorithm.
     */
    @Test
	public final void testGetDescription() {
        System.out.println("getDescription");
        YDSAlgorithm instance = new YDSAlgorithm();
        String expResult = 
    		"Provides an implementation of the offline YDS Algorithm as "
            + "described by F. Yao, A. Demers and S. Shenker in "
			+ "\"A scheduling model for reduced CPU energy\" (1995).";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of isOnline method, of class YDSAlgorithm.
     */
    @Test
	public final void testIsOnline() {
        System.out.println("isOnline");
        YDSAlgorithm instance = new YDSAlgorithm();
        boolean expResult = false;
        boolean result = instance.isOnline();
        assertEquals(expResult, result);
    }

    /**
     * Test of runSpeedScaling method, of class YDSAlgorithm.
     */
    @Test
	public final void testRunSpeedScaling() {
        System.out.println("runSpeedScaling");
        com.whiuk.philip.eesa.core.Test t = new com.whiuk.philip.eesa.core.Test();
        ProcessorResult p = new ProcessorResult();
        YDSAlgorithm instance = new YDSAlgorithm();
        instance.runSpeedScaling(t, p);
    }
}
