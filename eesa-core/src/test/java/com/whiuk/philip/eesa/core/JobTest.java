package com.whiuk.philip.eesa.core;

import java.util.HashMap;
import java.util.Map;

import com.whiuk.philip.eesa.exceptions.JobException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


/**
 * Tests the behaviour of {@link Job}.
 * @author Philip
 */
public class JobTest {
    /**
     * 
     */
    public JobTest() {
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
     * Test of getID method, of class Job.
     */
    @Test
	public final void testGetID() {
        System.out.println("getID");
        Job instance = new Job(1, 0f, 1f, 0f);
        int result = instance.getID();
        assertEquals(1, result);
    }
    /**
     * Test of constructor method, of class Job.
     * @throws JobException  
     */
    @Test
	public final void testJobConstructorIntBoolFloat()
    		throws JobException {
        System.out.println("constructorIntBoolFloat...BoolFloat");
        Map<Job.Property, Float> properties = 
        		new HashMap<Job.Property, Float>();
        properties.put(Job.Property.RELEASE, 0f);
        properties.put(Job.Property.DEADLINE, 1f);
        properties.put(Job.Property.WEIGHT, 1f);
        new Job(1, properties);
    }
    
    /**
     * Test of getID method, of class Job.
     */
    @Test
	public final void testSetID() {
        System.out.println("setID");
        Job instance = new Job(1, 0f, 1f, 0f);
        int expResult = 2;
        instance.setID(expResult);
        int result = instance.getID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLength method, of class Job.
     */
    @Test
	public final void testGetLength() {
        System.out.println("getLength");
        Job instance = new Job(0, 1f, 2f, 1f);
        float expResult = 1f;
        float result = instance.getLength();
        assertEquals(expResult, result, 0.0f);
    }

    /**
     * Test of getDensity method, of class Job.
     */
    @Test
	public final void testGetDensity() {
        System.out.println("getDensity");
        Job instance = new Job(0, 0f, 2f, 1f);
        final float expResult = 0.5F;
        float result = instance.getDensity();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getReleaseTime method, of class Job.
     */
    @Test
	public final void testGetReleaseTime() {
        System.out.println("getReleaseTime");
        Job instance = new Job(1, 0f, 1f, 1f);
        float expResult = 0.0F;
        float result = instance.getReleaseTime();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getDeadlineTime method, of class Job.
     */
    @Test
	public final void testGetDeadlineTime() {
        System.out.println("getDeadlineTime");
        Job instance = new Job(1, 0f, 1f, 1f);
        float expResult = 1.0F;
        float result = instance.getDeadlineTime();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getWeight method, of class Job.
     */
    @Test
	public final void testGetWeight() {
        System.out.println("getWeight");
        Job instance = new Job(1, 0f, 1f, 1f);
        float expResult = 1.0F;
        float result = instance.getWeight();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setReleaseTime method, of class Job.
     */
    @Test
	public final void testSetReleaseTime() {
        System.out.println("setReleaseTime");
        float t = 1.0F;
        Job instance = new Job(1, 0f, 2f, 1f);
        instance.setReleaseTime(t);
        assertEquals(t, instance.getReleaseTime(), 0.0f);
    }

    /**
     * Test of setDeadlineTime method, of class Job.
     */
    @Test
	public final void testSetDeadlineTime() {
        System.out.println("setDeadlineTime");
        float t = 1.0F;
        Job instance = new Job(1, 0f, 2f, 1f);
        instance.setDeadlineTime(t);
        assertEquals(t, instance.getDeadlineTime(), 0.0f);
    }

    /**
     * Test of setWeight method, of class Job.
     */    
    @Test
	public final void testSetWeight() {
        System.out.println("setWeight");
        float weight = 2.0F;
        Job instance = new Job(1, 0f, 2f, 1f);
        instance.setWeight(weight);
        assertEquals(weight, instance.getWeight(), 0.0f);
    }
}
