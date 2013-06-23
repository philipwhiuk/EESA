package eesa.core;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Tests the behaviour of {@link JobResult}.
 * @author Philip
 */
public class JobResultTest {
    /**
     * 
     */
    public JobResultTest() {
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
     * Test of getID method, of class JobResult.
     */
    @Test
	public final void testGetID() {
        System.out.println("getID");
        JobResult instance = new JobResult(1, new eesa.core.Test(),
        		new Processor(), new Job());
        int expResult = 1;
        int result = instance.getID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTest method, of class JobResult.
     */
    @Test
	public final void testGetTest() {
        System.out.println("getTest");
        eesa.core.Test expResult = new eesa.core.Test();
        JobResult instance = new JobResult(1, expResult,
        		new Processor(), new Job());
        eesa.core.Test result = instance.getTest();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProcessor method, of class JobResult.
     */
    @Test
	public final void testGetProcessor() {
        System.out.println("getProcessor");
        Processor expResult = new eesa.core.Processor();
        JobResult instance = new JobResult(1, new eesa.core.Test(),
        		expResult, new eesa.core.Job());
        Processor result = instance.getProcessor();
        assertEquals(expResult, result);
    }

    /**
     * Test of getJob method, of class JobResult.
     */
    @Test
	public final void testGetJob() {
        System.out.println("getJob");
        Job expResult = new eesa.core.Job();
        JobResult instance = new JobResult(1, new eesa.core.Test(),
        		new Processor(), expResult);
        Job result = instance.getJob();
        assertEquals(expResult, result);
    }
}
