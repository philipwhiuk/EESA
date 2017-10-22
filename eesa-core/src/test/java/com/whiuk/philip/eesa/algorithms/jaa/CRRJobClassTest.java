package com.whiuk.philip.eesa.algorithms.jaa;

import static org.junit.Assert.assertEquals;
import com.whiuk.philip.eesa.core.Job;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Performs tests to verify the {@link CRRJobClass} class.
 * @author Philip
 */
public class CRRJobClassTest {
    /**
     * 
     */
    public CRRJobClassTest() {
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
     * Test of addJob method, of class CRRJobClass.
     */
    @Test
	public final void testAddJob() {
        System.out.println("addJob");
        Job j = null;
        CRRJobClass instance = new CRRJobClass(0);
        instance.addJob(j);
    }

    /**
     * Test of getJobs method, of class CRRJobClass.
     */
    @Test
	public final void testGetJobs() {
        System.out.println("getJobs");
        CRRJobClass instance = new CRRJobClass(0);
        ArrayList<Job> expResult = new ArrayList<Job>();
        ArrayList<Job> result = instance.getJobs();
        assertEquals(expResult, result);
    }
}
