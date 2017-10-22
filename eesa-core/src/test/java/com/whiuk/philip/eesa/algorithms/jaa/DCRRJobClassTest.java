package com.whiuk.philip.eesa.algorithms.jaa;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Performs tests to verify the {@link DCRRJobClass} class.
 * @author Philip
 */
public class DCRRJobClassTest {
    /**
     * 
     */
    public DCRRJobClassTest() {
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
     * Test of addJobClass method, of class DCRRJobClass.
     */
    @Test
	public final void testAddJobClass() {
        System.out.println("addJobClass");
        Integer i = null;
        CRRJobClass jc = null;
        DCRRJobClass instance = new DCRRJobClass();
        instance.addJobClass(i, jc);
    }
}
