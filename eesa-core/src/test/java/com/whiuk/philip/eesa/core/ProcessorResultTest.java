package com.whiuk.philip.eesa.core;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

/**
 * Tests the behaviour of {@link ProcessorResult}.
 * @author Philip
 */
public class ProcessorResultTest {
    
	/**
	 * Constructor.
	 */
    public ProcessorResultTest() {
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
     * Test of addJob method, of class ProcessorResult.
     */
    @Test
	public final void testAddJob() {
        System.out.println("addJob");
        Job job = null;
        ProcessorResult instance = new ProcessorResult();        
        instance.addJob(job);
        assertEquals(1, instance.getJobCount());
    }

    /**
     * Test of getUnassignedJobs method, of class ProcessorResult.
     */
    @Test
	public final void testGetJobs() {
        System.out.println("getJobs");
        ProcessorResult instance = new ProcessorResult();
        ArrayList<Job> expResult = new ArrayList<Job>();
        ArrayList<Job> result = instance.getJobs();
        assertEquals(expResult, result);
    }

    /**
     * Test of setJobResults method, of class ProcessorResult.
     */
    @Test
	public final void testSetJobResults() {
        System.out.println("setJobResults");
        JobResult[] results = null;
        ProcessorResult instance = new ProcessorResult();
        instance.setJobResults(results);
    }

    /**
     * Test of setSpeedGraph method, of class ProcessorResult.
     */
    @Test
	public final void testSetSpeedGraph() {
        System.out.println("setSpeedGraph");
        ArrayList<ProcessorSpeedTimePeriod> periods = null;
        ProcessorResult instance = new ProcessorResult();
        instance.setSpeedGraph(periods);
    }

    /**
     * Test of getMaxTime method, of class ProcessorResult.
     */
    @Test
	public final void testGetMaxTime() {
        System.out.println("getMaxTime");
        ProcessorResult instance = new ProcessorResult();
        float expResult = 0.0F;
        float result = instance.getMaxTime();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getMaxSpeed method, of class ProcessorResult.
     */
    @Test
	public final void testGetMaxSpeed() {
        System.out.println("getMaxSpeed");
        ProcessorResult instance = new ProcessorResult();
        float expResult = 0.0F;
        float result = instance.getMaxSpeed();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getProcessor method, of class ProcessorResult.
     */
    @Test
	public final void testGetProcessor() {
        System.out.println("getProcessor");
        Processor expResult = new Processor();
        ProcessorResult instance = new ProcessorResult(expResult);
        Processor result = instance.getProcessor();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSpeedTimePeriods method, of class ProcessorResult.
     */
    @Test
	public final void testGetSpeedTimePeriods() {
        System.out.println("getSpeedTimePeriods");
        ArrayList<ProcessorSpeedTimePeriod> expResult = 
        		new ArrayList<ProcessorSpeedTimePeriod>();
        ProcessorResult instance = new ProcessorResult();
        instance.setSpeedGraph(expResult);
        List<ProcessorSpeedTimePeriod> result =
        		instance.getSpeedTimePeriods();
        assertEquals(expResult, result);
    }

    /**
     * Test of getJobResultCount method, of class ProcessorResult.
     */
    @Test
	public final void testGetJobResultCount() {
        System.out.println("getJobResultCount");
        ProcessorResult instance = new ProcessorResult();
        int expResult = 0;
        int result = instance.getJobResultCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of getJobResults method, of class ProcessorResult.
     */
    @Test
	public final void testGetJobResults() {
        System.out.println("getJobResults");
        ProcessorResult instance = new ProcessorResult();
        JobResult[] expResult = null;
        JobResult[] result = instance.getJobResults();
        assertArrayEquals(expResult, result);
    }
    /**
     * Test of getJobResultByID method, of class ProcessorResult.
     */
    @Test
	public final void testGetJobResultByID() {
        System.out.println("getJobResultByID");
        int id = 0;
        ProcessorResult instance = new ProcessorResult();
        JobResult expResult = null;
        JobResult result = instance.getJobResultByID(id);
        assertEquals(expResult, result);
    }
}
