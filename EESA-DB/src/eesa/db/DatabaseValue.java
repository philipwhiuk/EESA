package eesa.db;

/**
 * Used to provide raw data to queries.
 * @author Philip
 */
public class DatabaseValue implements SQLObject {
    /**
     * 
     */
    private final String value;
    /**
     * 
     * @param val value
     */
    public DatabaseValue(final String val) {
        this.value = val;
    }
    @Override
	public final String toString() {
        return value;
    }
    /**
     * 
     * @return
     */
    @Override
	public final String output() {
        return value;
    }
    
}
