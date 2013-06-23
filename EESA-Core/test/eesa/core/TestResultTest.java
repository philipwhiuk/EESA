package eesa.core;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Test;

/**
 * Tests the behaviour of {@link TestResult}.
 * @author Philip Whitehouse
 *
 */
public class TestResultTest {
	/**
	 * 
	 */
	@org.junit.Test
	public final void test() {
		eesa.core.Test t = mock(eesa.core.Test.class);
		new TestResult(t, null);
	}

    /**
     * Test of getJobResultCount method, of class Test.
     */
    @Test
	public final void testGetJobResultCount() {
        System.out.println("getJobResultCount");
        eesa.core.Test t = mock(eesa.core.Test.class);
        ProcessorResult[] r = 
        		new ProcessorResult[]{mock(ProcessorResult.class)};
        TestResult instance = new TestResult(t, r);
        int expResult = 0;
        int result = instance.getJobResultCount();
        assertEquals(expResult, result);
    }


    /**
     * Test of getProcessorResults method, of class Test.
     */
    @Test
	public final void testGetProcessorResults() {
        System.out.println("getProcessorResults");
        eesa.core.Test t = mock(eesa.core.Test.class);
        ProcessorResult[] r = 
        		new ProcessorResult[]{mock(ProcessorResult.class)};
        TestResult instance = new TestResult(t, r);
        int expResult = 1;
        ProcessorResult[] result = instance.getProcessorResults();
        assertEquals(expResult, result.length);
    }

    /**
     * Test of getProcessorResultByProcessor method, of class Test.
     */
    @Test
	public final void testGetProcessorResultByProcessor() {
        System.out.println("getProcessorResultByProcessor");
        Processor processor = null;
        eesa.core.Test t = mock(eesa.core.Test.class);
        TestResult instance = new TestResult(t, null);
        ProcessorResult expResult = null;
        ProcessorResult result = 
        		instance.getProcessorResultByProcessor(processor);
        assertEquals(expResult, result);
    }    
}
