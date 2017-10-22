package com.whiuk.philip.eesa.core;

import static org.junit.Assert.assertEquals;
import com.whiuk.philip.eesa.event.JobEvent;
import com.whiuk.philip.eesa.event.JobEventListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Tests the behaviour of {@link JobSet}.
 * @author Philip
 */
public class JobSetTest {
    /**
     * 
     */
    public JobSetTest() {
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
     * Test of getJobs method, of class JobSet.
     */
    @Test
	public final void testGetJobs() {
        System.out.println("getJobs");
        JobSet instance = new JobSet();
        List<Job> expResult = new ArrayList<Job>();
        List<Job> result = instance.getJobs();
        assertEquals(expResult, result);
    }

    /**
     * Test of addJobs method, of class JobSet.
     */
    @Test
	public final void testAddJobs() {
        System.out.println("addJobs");
        ArrayList<Job> jobs = new ArrayList<Job>();
        JobSet instance = new JobSet();
        instance.addJobs(jobs);
    }

    /**
     * Test of setJobs method, of class JobSet.
     */
    @Test
	public final void testSetJobs() {
        System.out.println("setJobs");
        Collection<Job> jobs = new ArrayList<Job>();
        JobSet instance = new JobSet();
        instance.setJobs(jobs);
    }

    /**
     * Test of isNotEmpty method, of class JobSet.
     */
    @Test
	public final void testIsNotEmpty() {
        System.out.println("isNotEmpty");
        JobSet instance = new JobSet();
        boolean expResult = false;
        boolean result = instance.isNotEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of addJob method, of class JobSet.
     */
    @Test
	public final void testAddJob() {
        System.out.println("addJob");
        Job job = new Job();
        JobSet instance = new JobSet();
        instance.addJob(job);
        assertEquals(instance.getSize(), 1);
    }

    /**
     * Test of removeJob method, of class JobSet.
     */
    @Test
	public final void testRemoveJobInt() {
        System.out.println("removeJob");
        int index = 0;
        JobSet instance = new JobSet();
        Job j1 = new Job(1, 0f, 1f, 0f);
        Job j2 = new Job(2, 0f, 1f, 0f);
        instance.addJob(j1);
        instance.addJob(j2);        
        instance.removeJob(index);
        assertEquals(j2, instance.getJob(0));
    }

    /**
     * Test of removeJob method, of class JobSet.
     */
    @Test
	public final void testRemoveJob() {
        System.out.println("removeJob");
        JobSet instance = new JobSet();
        Job j1 = new Job(1, 0f, 1f, 0f);
        Job j2 = new Job(2, 0f, 1f, 0f);
        instance.addJob(j1);
        instance.addJob(j2);        
        instance.removeJob(j1);
        assertEquals(j2, instance.getJob(0));
    }

    /**
     * Test of getNextJobID method, of class JobSet.
     */
    @Test
	public final void testGetNextJobID() {
        System.out.println("getNextJobID");
        JobSet instance = new JobSet();
        int expResult = 0, exp2Result = 1;
        int result = instance.getNextJobID();
        int result2 = instance.getNextJobID();
        assertEquals(expResult, result);
        assertEquals(exp2Result, result2);
    }

    /**
     * Test of getJob method, of class JobSet.
     */
    @Test
	public final void testGetJob() {
        System.out.println("getJob");
        int rowIndex = 0;
        Job expResult = new Job();
        JobSet instance = new JobSet();
        instance.addJob(expResult);
        Job result = instance.getJob(rowIndex);
        assertEquals(expResult, result);
    }

    /**
     * Test of getSize method, of class JobSet.
     */
    @Test
	public final void testGetSize() {
        System.out.println("getSize");
        JobSet instance = new JobSet();
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(expResult, result);
   }

    /**
     * Test of getJobByID method, of class JobSet.
     */
    @Test
	public final void testGetJobByID() {
        System.out.println("getJobByID");
        int id = 2;
        Job expResult = new Job(2, 0f, 1f, 1f);        
        JobSet instance = new JobSet();
        instance.addJob(expResult);
        Job result = instance.getJobByID(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of addJobEventListener method, of class JobSet.
     */
    @Test
	public final void testAddJobEventListener() {
        System.out.println("addJobEventListener");
        JobEventListener l = null;
        JobSet instance = new JobSet();
        instance.addJobEventListener(l);
    }

    /**
     * Test of removeJobEventListener method, of class JobSet.
     */
    @Test
	public final void testRemoveJobEventListener() {
        System.out.println("removeJobEventListener");
        JobEventListener l = new JobEventListener() {
            @Override
            public void jobAdded(final JobEvent event) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
            @Override
            public void jobRemoved(final JobEvent event) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
            @Override
            public void jobAltered(final JobEvent event) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
            @Override
            public void jobsAdded(final JobEvent event) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
            @Override
            public void jobsRemoved(final JobEvent event) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void jobsAltered(final JobEvent event) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
            @Override
            public void jobsReplaced(final JobEvent event) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
        JobSet instance = new JobSet();
        instance.addJobEventListener(l);
        instance.removeJobEventListener(l);
    }

    /**
     * Test of getIndexOfJob method, of class JobSet.
     */
    @Test
	public final void testGetIndexOfJob() {
        System.out.println("getIndexOfJob");
        Job job = new Job();
        JobSet instance = new JobSet();
        instance.addJob(job);
        int expResult = 0;
        int result = instance.getIndexOfJob(job);
        assertEquals(expResult, result);
    }
}
