package com.whiuk.philip.eesa.core;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


/**
 * Tests the behaviour of {@link ProcessorSpeedTimePeriod}.
 * @author Philip
 */
public class ProcessorSpeedTimePeriodTest {
    /**
     * 
     */
    public ProcessorSpeedTimePeriodTest() {
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
     * Test of getID method, of class ProcessorSpeedTimePeriod.
     */
    @Test
	public final void testGetID() {
        System.out.println("getID");
        ProcessorSpeedTimePeriod instance = 
        		new ProcessorSpeedTimePeriod(1, 
        				new ProcessorResult(), new Processor(), 
        				new com.whiuk.philip.eesa.core.Test(), 0f, 1f);
        int expResult = 1;
        int result = instance.getID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLength method, of class ProcessorSpeedTimePeriod.
     */
    @Test
	public final void testGetLength() {
        System.out.println("getLength");
        ProcessorSpeedTimePeriod instance = 
        		new ProcessorSpeedTimePeriod(
        				1, new ProcessorResult(), new Processor(),
        				new com.whiuk.philip.eesa.core.Test(), 0f, 1f);
        float expResult = 1.0F;
        float result = instance.getLength();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getSpeed method, of class ProcessorSpeedTimePeriod.
     */    
    @Test
	public final void testGetSpeed() {
        System.out.println("getSpeed");
        ProcessorSpeedTimePeriod instance = 
        		new ProcessorSpeedTimePeriod(1, new ProcessorResult(),
        				new Processor(), new com.whiuk.philip.eesa.core.Test(),
        				0f, 1f);
        instance.setSpeed(1.0F);
        float expResult = 1.0F;
        float result = instance.getSpeed();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getStartTime method, of class ProcessorSpeedTimePeriod.
     */
    @Test
	public final void testGetStartTime() {
        System.out.println("getStartTime");
        ProcessorSpeedTimePeriod instance = new ProcessorSpeedTimePeriod(
        		1, new ProcessorResult(),
        		new Processor(), new com.whiuk.philip.eesa.core.Test(),
        		0f, 1f);
        float expResult = 0.0F;
        float result = instance.getStartTime();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getEndTime method, of class ProcessorSpeedTimePeriod.
     */
    @Test
	public final void testGetEndTime() {
        System.out.println("getEndTime");
        ProcessorSpeedTimePeriod instance = new ProcessorSpeedTimePeriod(
        		1, new ProcessorResult(),
        		new Processor(), new com.whiuk.philip.eesa.core.Test(),
        		0f, 1f);
        float expResult = 1.0F;
        float result = instance.getEndTime();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setSpeed method, of class ProcessorSpeedTimePeriod.
     */
    @Test
	public final void testSetSpeed() {
        System.out.println("setSpeed");
        float speed = 1.0F;
        ProcessorSpeedTimePeriod instance = 
        		new ProcessorSpeedTimePeriod(1, new ProcessorResult(),
        				new Processor(), new com.whiuk.philip.eesa.core.Test(),
        				0f, 1f);
        instance.setSpeed(speed);
    }

    /**
     * Test of getTest method, of class ProcessorSpeedTimePeriod.
     */
    @Test
	public final void testGetTest() {
        System.out.println("getTest");
        com.whiuk.philip.eesa.core.Test expResult = new com.whiuk.philip.eesa.core.Test();
        ProcessorSpeedTimePeriod instance = new ProcessorSpeedTimePeriod(
        		1, new ProcessorResult(),
        		new Processor(), expResult,
        		0f, 1f);
        com.whiuk.philip.eesa.core.Test result = instance.getTest();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProcessor method, of class ProcessorSpeedTimePeriod.
     */
    @Test
	public final void testGetProcessor() {
        System.out.println("getProcessor");
        Processor expResult = new Processor();
        ProcessorSpeedTimePeriod instance = 
        		new ProcessorSpeedTimePeriod(1, new ProcessorResult(),
        				expResult, new com.whiuk.philip.eesa.core.Test(), 0f, 1f);
        Processor result = instance.getProcessor();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProcessorResult method, of class ProcessorSpeedTimePeriod.
     */
    @Test
	public final void testGetProcessorResult() {
        System.out.println("getProcessorResult");
        ProcessorResult expResult = new ProcessorResult();
        ProcessorSpeedTimePeriod instance = 
        		new ProcessorSpeedTimePeriod(1, expResult, new Processor(),
        				new com.whiuk.philip.eesa.core.Test(), 0f, 1f);
        ProcessorResult result = instance.getProcessorResult();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProcessorResult method, of class ProcessorSpeedTimePeriod.
     */
    @Test
	public final void testSetProcessorResult() {
        System.out.println("setProcessorResult");
        ProcessorResult proc = null;
        ProcessorSpeedTimePeriod instance = new ProcessorSpeedTimePeriod();
        instance.setProcessorResult(proc);
    }
}
