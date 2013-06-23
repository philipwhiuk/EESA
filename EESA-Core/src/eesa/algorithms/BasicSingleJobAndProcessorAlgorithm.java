package eesa.algorithms;

import java.util.ArrayList;
import java.util.List;

import eesa.core.Job;
import eesa.core.JobSet;
import eesa.core.Processor;
import eesa.core.ProcessorResult;
import eesa.core.ProcessorSpeedTimePeriod;
import eesa.core.Test;
import eesa.core.TestResult;
import eesa.exceptions.AlgorithmException;

/**
 * Implements a naive single processor algorithm in the EESA simulator.
 * @author Philip Whitehouse
 *
 */
public class BasicSingleJobAndProcessorAlgorithm extends EESAAlgorithm {

	/**
	 * 
	 */
	private static final String DESCRIPTION = 
			"Implements a naive single processor algorithm which assigns "
			+ "all jobs to the same processor and runs them at the "
			+ "necessary speed to complete.";
	/**
	 * 
	 * @return string
	 */
	public final String toString() {
		return "Basic Single Job & Processor Algorithm";
	}
	
	@Override
	public final String getDescription() {
		return DESCRIPTION;
	}
	
	@Override
	public final TestResult runAlgorithm(final Test t, 
			final JobSet j, final Processor[] p)
			throws AlgorithmException {
		/*
		 * Build the processor result objects 
		 */
		ProcessorResult[] pR = new ProcessorResult[p.length];
		for (int i = 0; i < p.length; i++) {
			pR[i] = new ProcessorResult(p[i]);
		}
		if (j.getSize() > 1) {
			throw new AlgorithmException("Handling than 1 job not implemented");
		}	
		Job job = j.getJobs().get(0);
		
		List<ProcessorSpeedTimePeriod> periods = 
				new ArrayList<ProcessorSpeedTimePeriod>();
				
		ProcessorSpeedTimePeriod period = new ProcessorSpeedTimePeriod(
				0, pR[0], p[0], t, job.getReleaseTime(), job.getDeadlineTime());
		period.setSpeed(job.getDensity());
		
		periods.add(period);
		
		pR[0].setSpeedGraph(periods);
				
		return new TestResult(t, pR);
		
	}

	@Override
	public final String getParameters() {
		return null;
	}

}
