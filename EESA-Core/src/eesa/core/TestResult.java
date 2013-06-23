package eesa.core;

/**
 * Provides a container for the results of executing a test.
 * @author Philip Whitehouse
 *
 */
public class TestResult {
	/**
	 * 
	 */
	private Test test;
	/**
	 * 
	 */
	private ProcessorResult[] processorResults;

	/**
	 * 
	 * @param t The test
	 * @param p The processor results
	 */
	public TestResult(final Test t, final ProcessorResult[] p) {
		this.setTest(t);
		this.setProcessorResults(p);
	}

	/**
	 * @return the processorResults
	 */
	public final ProcessorResult[] getProcessorResults() {
		return processorResults;
	}

    /**
     * Provides the results for a given Processor.
     * @param p Processor
     * @return The results object related to that processor (or null)
     */
    final ProcessorResult getProcessorResultByProcessor(final Processor p) {
        if (processorResults != null) {
            for (int i = 0; i < processorResults.length; i++) {
                Processor proc = processorResults[i].getProcessor();
                if (proc.equals(p)) {
                    return processorResults[i];
                }
            }
        }
        return null;
    }
	/**
	 * @param p the processorResults to set
	 */
	public final void setProcessorResults(
			final ProcessorResult[] p) {
		this.processorResults = p;
	}
    /**
     * Provides the number of job results.
     * @return The number of job results stored with this test
     */
    public final int getJobResultCount() {
        int resultCount = 0;
        for (int i = 0; i < processorResults.length; i++) {
            resultCount += processorResults[i].getJobResultCount();
        }
        return resultCount;
    }
	/**
	 * @return the test
	 */
	public final Test getTest() {
		return test;
	}

	/**
	 * @param t the test to set
	 */
	public final void setTest(final Test t) {
		this.test = t;
	}

}
