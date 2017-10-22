package com.whiuk.philip.eesa.core;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


/**
 * Tests the behaviour of {@link Processor}.
 * @author Philip
 */
public class ProcessorTest {
    /**
     * 
     */
    public ProcessorTest() {
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
     * Test of getID method, of class Processor.
     */
    @Test
	public final void testGetID() {
        System.out.println("getID");
        Processor instance = new Processor(1);
        int expResult = 1;
        int result = instance.getID();
        assertEquals(expResult, result);
    }
    /**
     * Test of toString method, of class Processor.
     */
    @Test
	public final void testToString() {
        System.out.println("toString");
        Processor instance = new Processor(1);
        String expResult = "Processor 1";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
