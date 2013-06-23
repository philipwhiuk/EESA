package eesa.algorithms.jaa;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import eesa.core.Job;
import eesa.core.JobSet;
import eesa.core.Processor;
import eesa.core.ProcessorResult;
import eesa.exceptions.AlgorithmException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


/**
 * Performs tests to verify the {@link RoundRobinAlgorithm} class.
 * @author Philip
 */
public class RoundRobinAlgorithmTest {
    /**
     * 
     */
    public RoundRobinAlgorithmTest() {
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
     * Test of getDescription method, of class RoundRobinAlgorithm.
     */
    @Test
	public final void testGetDescription() {
        System.out.println("getDescription");
        RoundRobinAlgorithm instance = new RoundRobinAlgorithm();
        String expResult = "Provides an implementation of the "
    		+ "Round Robin Algorithm as described by S. Albers, "
    		+ "F. Muller and S. Schmelzer in \"Speed scaling on "
    		+ "parrelel processors\" (2007). ";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class RoundRobinAlgorithm.
     */
    @Test
	public final void testToString() {
        System.out.println("toString");
        RoundRobinAlgorithm instance = new RoundRobinAlgorithm();
        String expResult = "Round-Robin Algorithm";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of runJobAssignment method, of class RoundRobinAlgorithm.
     */
    @Test
	public final void testRunJobAssignment() {
        System.out.println("toString");
        RoundRobinAlgorithm instance = new RoundRobinAlgorithm();
        JobSet js = new JobSet();

        Job job = new Job();
        job.setDeadlineTime(1.0f);
        job.setReleaseTime(0.0f);
        
        Job job2 = new Job();
        job2.setDeadlineTime(2.0f);
        job2.setReleaseTime(1.0f);
        

        Job job3 = new Job();
        job3.setDeadlineTime(3.0f);
        job3.setReleaseTime(2.0f);
        
        js.addJob(job);
        js.addJob(job2);
        js.addJob(job3);
	
        Processor p0 = mock(Processor.class);
        Processor p1 = mock(Processor.class);
        Processor[] processors = new Processor[]{p0,p1};
        
        try {
			ProcessorResult[] results = 
					instance.runJobAssignment(js, processors);
			assertEquals(processors.length, results.length);
			assertEquals(2, results[0].getJobCount());
			assertEquals(1, results[1].getJobCount());
			assertEquals(job2, results[1].getJobs().get(0));
			assertEquals(job, results[0].getJobs().get(0));
			assertEquals(job3, results[0].getJobs().get(1));
		} catch (AlgorithmException e) {
			fail(e.getMessage());
		}
        
    }
}
