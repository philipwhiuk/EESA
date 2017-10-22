package com.whiuk.philip.eesa.algorithms.ssa;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.whiuk.philip.eesa.algorithms.jaa.RoundRobinAlgorithm;
import com.whiuk.philip.eesa.core.ProcessorResult;
import static org.junit.Assert.assertEquals;

/**
 * Performs tests to verify the {@link AVRAlgorithm} class.
 * @author Philip
 */
public class AVRAlgorithmTest {
    /**
     * 
     */
    public AVRAlgorithmTest() {
    }
    /**
     * 
     * @throws Exception
     */
    @BeforeClass
    public static final void setUpClass() {
    }
    /**
     * 
     * @throws Exception
     */
    @AfterClass
    public static final void tearDownClass() {
    }
    /**
     * 
     */
    @Before
    public final void setUp() {
    }
    /**
     * 
     */
    @After
    public final void tearDown() {
    }

    /**
     * Test of toString method, of class AVRAlgorithm.
     */
    @Test
    public final void testToString() {
        System.out.println("toString");
        AVRAlgorithm instance = new AVRAlgorithm();
        String expResult = "AVerage Rate Algorithm";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class AVRAlgorithm.
     */
    @Test
    public final void testGetDescription() {
        System.out.println("getDescription");
        AVRAlgorithm instance = new AVRAlgorithm();
        String expResult = "Provides an implementation of the online "
        		+ "Average Rate Algorithm as described by F. Yao, "
        		+ "A. Demers and S. Shenker in \"A scheduling model "
        		+ "for reduced CPU energy\" (1995).";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of isOnline method, of class AVRAlgorithm.
     */
    @Test
    public final void testIsOnline() {
        System.out.println("isOnline");
        AVRAlgorithm instance = new AVRAlgorithm();
        boolean expResult = false;
        boolean result = instance.isOnline();
        assertEquals(expResult, result);
    }

    /**
     * Test of runSpeedScaling method, of class AVRAlgorithm.
     */
    @Test
    public final void testRunSpeedScaling() {
        System.out.println("runSpeedScaling");
        com.whiuk.philip.eesa.core.Test test = new com.whiuk.philip.eesa.core.Test();
        ProcessorResult procResult = new ProcessorResult();
        AVRAlgorithm instance = new AVRAlgorithm();
        instance.runSpeedScaling(test, procResult);
    }
}
