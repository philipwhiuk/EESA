package com.whiuk.philip.eesa.algorithms.ssa;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Performs tests to verify the {@link OAAlgorithm} class.
 * @author Philip
 */
public class OAAlgorithmTest {
    /**
     * 
     */
    public OAAlgorithmTest() {
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
     * Test of toString method, of class OAAlgorithm.
     */
    @Test
	public final void testToString() {
        System.out.println("toString");
        OAAlgorithm instance = new OAAlgorithm();
        String expResult = "Optimal Available (OA) Algorithm";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class OAAlgorithm.
     */
    @Test
	public final void testGetDescription() {
        System.out.println("getDescription");
        OAAlgorithm instance = new OAAlgorithm();
        String expResult = "Provides an implementation of the online "
        		+ "Optimal Available Algorithm as "
            + "described by F. Yao, A. Demers and S. Shenker in "
    		+ "\"A scheduling model for reduced CPU energy\" (1995).";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of isOnline method, of class OAAlgorithm.
     */
    @Test
	public final void testIsOnline() {
        System.out.println("isOnline");
        OAAlgorithm instance = new OAAlgorithm();
        boolean expResult = true;
        boolean result = instance.isOnline();
        assertEquals(expResult, result);
    }
}
