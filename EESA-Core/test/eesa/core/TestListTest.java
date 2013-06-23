package eesa.core;

import eesa.event.TestEventListener;
import eesa.exceptions.AlgorithmException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

/**
 * Tests the behaviour of {@link TestList}.
 * @author Philip
 */
public class TestListTest {
    /**
     * 
     */
    public TestListTest() {
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
     * Test of hasResults method, of class TestList.
     */
    @Test
	public final void testHasResults() {
        System.out.println("hasResults");
        TestList instance = new TestList();
        boolean expResult = false;
        boolean result = instance.hasResults();
        assertEquals(expResult, result);
    }

    /**
     * Test of addTest method, of class TestList.
     */
    @Test
	public final void testAddTestByTest() {
        System.out.println("addTest");
        eesa.core.Test test = null;
        TestList instance = new TestList();
        instance.addTest(test);
    }

    /**
     * Test of runTests method, of class TestList.
     * @throws AlgorithmException 
     */
    @Test
	public final void testRunTests() throws AlgorithmException {
        System.out.println("runTests");
        TestList instance = new TestList();
        instance.runTests();
    }

    /**
     * Test of hasTests method, of class TestList.
     */
    @Test
	public final void testHasTests() {
        System.out.println("hasTests");
        TestList instance = new TestList();
        boolean expResult = false;
        boolean result = instance.hasTests();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTest method, of class TestList.
     */
    @Test
	public final void testGetTest() {
        System.out.println("getTest");
        int i = 0;
        TestList instance = new TestList();
        eesa.core.Test expResult = new eesa.core.Test();
        instance.addTest(expResult);
        eesa.core.Test result = instance.getTest(i);
        assertEquals(expResult, result);
    }

    /**
     * Test of numberOfTests method, of class TestList.
     */
    @Test
	public final void testNumberOfTests() {
        System.out.println("numberOfTests");
        TestList instance = new TestList();
        int expResult = 0;
        int result = instance.numberOfTests();
        assertEquals(expResult, result);
    }

    /**
     * Test of compileResults method, of class TestList.
     */
    @Test
	public final void testCompileResults() {
        System.out.println("compileResults");
        TestList instance = new TestList();
        instance.compileResults();
    }

    /**
     * Test of getNumResults method, of class TestList.
     */
    @Test
	public final void testGetNumResults() {
        System.out.println("getNumResults");
        TestList instance = new TestList();
        int expResult = 0;
        int result = instance.getNumResults();
        assertEquals(expResult, result);
    }

    /**
     * Test of compilePeriods method, of class TestList.
     */
    @Test
	public final void testCompilePeriods() {
        System.out.println("compilePeriods");
        TestList instance = new TestList();
        instance.compilePeriods();
    }

    /**
     * Test of getNumPeriods method, of class TestList.
     */
    @Test
	public final void testGetNumPeriods() {
        System.out.println("getNumPeriods");
        TestList instance = new TestList();
        int expResult = 0;
        int result = instance.getNumPeriods();
        assertEquals(expResult, result);
    }

    /**
     * Test of removeTest method, of class TestList.
     */
    @Test
	public final void testRemoveTestInt() {
        System.out.println("removeTest");
        int index = 0;
        TestList instance = new TestList();
        instance.addTest(new eesa.core.Test());
        instance.removeTest(index);
    }

    /**
     * Test of getTestByID method, of class TestList.
     */
    @Test
	public final void testGetTestByID() {
        System.out.println("getTestByID");
        int id = 0;
        TestList instance = new TestList();
        eesa.core.Test expResult = null;
        eesa.core.Test result = instance.getTestByID(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeTest method, of class TestList.
     */
    @Test
	public final void testRemoveTest() {
        System.out.println("removeTest");
        eesa.core.Test t = null;
        TestList instance = new TestList();
        instance.removeTest(t);
    }

    /**
     * Test of addTestEventListener method, of class TestList.
     */
    @Test
	public final void testAddTestEventListener() {
        System.out.println("addTestEventListener");
        TestEventListener l = null;
        TestList instance = new TestList();
        instance.addTestEventListener(l);
    }

    /**
     * Test of removeTestEventListener method, of class TestList.
     */
    @Test
	public final void testRemoveTestEventListener() {
        System.out.println("removeTestEventListener");
        TestEventListener l = null;
        TestList instance = new TestList();
        instance.removeTestEventListener(l);
    }

    /**
     * Test of getResults method, of class TestList.
     */
    @Test
	public final void testGetResults() {
        System.out.println("getResults");
        TestList instance = new TestList();
        JobResult[] expResult = new JobResult[]{};
        JobResult[] result = instance.getResults();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getPeriods method, of class TestList.
     */
    @Test
	public final void testGetPeriods() {
        System.out.println("getPeriods");
        TestList instance = new TestList();
        ProcessorSpeedTimePeriod[] expResult = new ProcessorSpeedTimePeriod[]{};
        ProcessorSpeedTimePeriod[] result = instance.getPeriods();
        assertArrayEquals(expResult, result);
    }
}
