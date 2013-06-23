package eesa.db;

/**
 * Provides an interface for a database engine connector.
 * @author Philip
 */
public interface DatabaseConnector {

    /**
     * 
     * @return 
     */
    @Override
    String toString();
    /**
     * 
     * @param url
     * @return
     */
    Database getDatabase(String url);
    /**
     * 
     * @return 
     */
    String getJDBCCode();
    /**
     * 
     * @return 
     */
    Database getDefaultDatabase();
    /**
     * 
     * @return 
     */
    Database[] getDefinedDatabaseConnections();
}
