package eesa.core;

import java.util.Map;

import eesa.exceptions.JobException;

/**
 * Describes a single job (j) in the system.
 * @author Philip
 */
public class Job implements Stored {
	/**
	 * The properties of a job.
	 * @author Philip Whitehouse
	 *
	 */
	public static enum Property { RELEASE, DEADLINE, LENGTH, WEIGHT, DENSITY };
	
	/**
	 * Error text denoting the length provided was incorrect.
	 */
	private static final String LENGTH_INTERVAL_ERROR =
			"Length must be the interval between release and deadline";
	/**
	 * Error text denoting the density provided was incorrect.
	 */
	private static final String DENSITY_VALUE_ERROR =
			"Density must be the weight / length";
	/**
	 * Error text denoting there was insufficient data given for the job.
	 */
	private static final String INSUFFICIENT_DATA = 
			"Insufficient Data";
	
    /**
     * The structure storing the release, deadline and length of the job.
     */
    private TimeInterval timeInterval = new TimeInterval();
    /**
     * The weight of the job w(j).
     */
    private float weight;
    /**
     * The unique identifier for the job.
     */
    private int id;
    /**
     * Standard constructor.
     * @param i ID
     * @param r Release
     * @param d Deadline
     * @param w Weight (AKA work)
     */
    public Job(final int i, final float r,
    		final float d, final float w) {
        this.id = i;
        this.timeInterval = new TimeInterval(r, d);
        this.weight = w;
    }
    /**
     * Blank constructor for loading and data importing.
     */
    public Job() {
    }
    /**
     * Option-based constructor.
     * @param i	ID
     * @param p Job properties
     * @throws JobException Exception thrown if the job is invalid
     */
    public Job(final int i, 
    			final Map<Property, Float> p) throws JobException {
        this.id = i;
        
        if (p.containsKey(Property.RELEASE) 
        		&& p.containsKey(Property.DEADLINE)) {
            if (p.get(Property.DEADLINE) < p.get(Property.RELEASE)) {
                throw new JobException("Deadline must be after release");
            } else if (p.containsKey(Property.LENGTH) 
            		&& (p.get(Property.RELEASE) + p.get(Property.LENGTH) 
            				!= p.get(Property.DEADLINE))) {
                throw new JobException(LENGTH_INTERVAL_ERROR);
            } else {
                this.timeInterval = new TimeInterval(p.get(Property.RELEASE),
                		p.get(Property.DEADLINE));
                p.put(Property.LENGTH,
                		p.get(Property.DEADLINE) - p.get(Property.RELEASE));
            }
        } else if (
        		(p.containsKey(Property.LENGTH)
        				|| p.containsKey(Property.WEIGHT) 
        				&& p.containsKey(Property.DENSITY))
        		&& (p.containsKey(Property.RELEASE) 
        				|| p.containsKey(Property.DEADLINE))) {
            if (p.containsKey(Property.WEIGHT) & p.containsKey(Property.DENSITY)
            		&& p.containsKey(Property.LENGTH)) {
                if (p.get(Property.DENSITY) 
                		!= p.get(Property.WEIGHT) / p.get(Property.LENGTH)) {
                    throw new JobException(DENSITY_VALUE_ERROR);
                } else {
                    this.weight = p.get(Property.WEIGHT);
                }
            } else if (p.containsKey(Property.DENSITY)
            		&& p.containsKey(Property.WEIGHT)) {
                this.weight = p.get(Property.WEIGHT);
                p.put(Property.LENGTH,
                		p.get(Property.WEIGHT) / p.get(Property.DENSITY));
            }
            if (p.containsKey(Property.RELEASE)) {
                this.timeInterval = 
                		new TimeInterval(p.get(Property.RELEASE),
            				p.get(Property.RELEASE) + p.get(Property.LENGTH));
            } else if (p.containsKey(Property.DEADLINE)) {
                this.timeInterval = 
            		new TimeInterval(
            				p.get(Property.DEADLINE) - p.get(Property.LENGTH),
            				p.get(Property.DEADLINE));
            } else {
                throw new JobException(INSUFFICIENT_DATA);
            }
        } else {
            throw new JobException(INSUFFICIENT_DATA);
        }
        if (p.containsKey(Property.WEIGHT) 
        		|| p.containsKey(Property.DENSITY) 
        		&& p.containsKey(Property.LENGTH)) {
            if (p.containsKey(Property.WEIGHT) 
            		&& p.containsKey(Property.DENSITY)
            		&& p.containsKey(Property.LENGTH)) {
                if (p.get(Property.DENSITY) 
                		!= p.get(Property.WEIGHT) / p.get(Property.LENGTH)) {
                    throw new JobException(DENSITY_VALUE_ERROR);
                } else {
                    this.weight = p.get(Property.LENGTH) 
                    		* p.get(Property.DENSITY);
                }
            } else {
                this.weight = p.get(Property.WEIGHT);
            }
        } else {
            throw new JobException(INSUFFICIENT_DATA);
        }
    }
    /**
     * Accessor function for the unique ID.
     * @return The job's unique identifier
     * (a positive integers initialised at 0)
     */
    public final int getID() {
        return id;
    }
    /**
     * Accessor function for the length of a job len(j).
     * @return The length of the job (unit-less)
     */
    public final float getLength() {
        return timeInterval.getLength();
    }
    /**
     * Accessor function for the density of the job den(j).
     * @return The density of the job (unit-less)
     */
    public final float getDensity() {
        return weight / timeInterval.getLength();
    }
    /**
     * Accessor function for the release time of the job r(j).
     * @return The release time of the job (unit-less)
     */
    public final float getReleaseTime() {
        return timeInterval.getStartTime();
    }
    /**
     * Accessor function for the release time of the job d(j).
     * @return The deadline time of the job (unit-less)
     */
    public final float getDeadlineTime() {
        return timeInterval.getEndTime();
    }
    /**
     * Accessor function for the release time of the job w(j).
     * @return The weight of the job (unit-less)
     */
    public final float getWeight() {
        return this.weight;
    }
    /**
     * Update the release time of the job.
     * @param t Release time
     */
    public final void setReleaseTime(final float t) {
        timeInterval.setStartTime(t);
    }
    /**
     * Update the deadline of the job.
     * @param t Deadline time
     */
    public final void setDeadlineTime(final float t) {
        timeInterval.setEndTime(t);
    }
    /**
     * Update the weight of the job.
     * @param w Weight
     */
    public final void setWeight(final float w) {
        this.weight = w;
    }
    /**
     * @param i The new ID
     */
    public final void setID(final int i) {
        this.id = i;
    }
}
