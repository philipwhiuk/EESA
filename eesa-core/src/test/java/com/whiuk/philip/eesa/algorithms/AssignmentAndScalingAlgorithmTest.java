package com.whiuk.philip.eesa.algorithms;

import static org.mockito.Mockito.mock;

import org.junit.Test;

/**
 * Performs tests to verify the AssignmentAndScalingAlgorithm class.
 * @author Philip Whitehouse
 *
 */
public class AssignmentAndScalingAlgorithmTest {
	/**
	 * 
	 */
	@Test
	public final void test() {
		JobAssignmentAlgorithm jaa = mock(JobAssignmentAlgorithm.class);
		SpeedScalingAlgorithm ssa = mock(SpeedScalingAlgorithm.class);
		new AssignmentAndScalingAlgorithm(jaa, ssa);
	}

}
