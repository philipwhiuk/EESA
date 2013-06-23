package eesa.core;

import eesa.exceptions.TimeIntervalException;

/**
 * Denotes a period of time.
 * @author Philip
 */
public class TimeInterval {
	/**
	 * Error text - end after start.
	 */
	public static final String END_TIME_AFTER_START =
			"End time must be after start time.";
	/**
	 * Start time.
	 */
    private float startTime;
    /**
     * End time.
     */
    private float endTime;
    /**
     * Blank constructor.
     */
    public TimeInterval() {    
    }
    /**
     * 
     * @param s Start time
     * @param e End time
     */
    public TimeInterval(final float s, final float e) {
        this();
        if (e <= s) {
            throw new TimeIntervalException(END_TIME_AFTER_START);
        } else {
            this.startTime = s;
            this.endTime = e;
        }
    }
    /**
     * @return start time
     */
    public final float getStartTime() {
        return this.startTime;
    }
    /**
     * @return end time
     */
    public final float getEndTime() {
        return this.endTime;
    }
    /**
     * @return length
     */
    public final float getLength() {
        return this.endTime - this.startTime;
    }
    /**
     * 
     * @param s Start time
     */
    public final void setStartTime(final float s) {
        if (this.endTime <= s) {
            throw new TimeIntervalException(END_TIME_AFTER_START);
        } else {
            this.startTime = s;
        }
    }
    /**
     * 
     * @param e End time
     */
    public final void setEndTime(final float e) {
        if (e <= this.startTime) {
        	throw new TimeIntervalException(END_TIME_AFTER_START);
        } else {
            this.endTime = e;
        }
    }    
}
