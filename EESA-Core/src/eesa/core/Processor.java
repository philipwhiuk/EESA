package eesa.core;

/**
 * The Processor class stores information about a single processor.
 * @author Philip
 */
public class Processor implements Stored {
    /**
     * The processor's unique ID within the system.
     */
    private int id;
    /**
     * Constructor.
     * @param i 
     */
    Processor(final int i) {
        this.id = i;
    }
    /**
     * Blank constructor for loading and data import.
     */
    Processor() {
    }
    /**
     * Accessor for the unique ID.
     * @return The processor's unique identifier
     */
    public final int getID() {
        return id;
    }
    /**
     * Outputs a human readable string version of the processor.
     * @return String of the format "Processor <ID>"
     */    
    @Override
	public final String toString() {
        return "Processor " + id;
    }
}
