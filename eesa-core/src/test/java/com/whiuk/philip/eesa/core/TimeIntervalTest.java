package com.whiuk.philip.eesa.core;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests the behaviour of {@link TimeInterval}.
 * @author Philip Whitehouse
 *
 */
public class TimeIntervalTest {
	/**
	 * 
	 */
	@Test
	public final void getStartTimeTest() {
		TimeInterval t = new TimeInterval(0, 1);
		assertEquals(t.getStartTime(), 0, 0);
    }

}
