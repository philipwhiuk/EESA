package eesa.db;

/**
 * Provides a class to represent objects in queries.
 * @author Philip
 */
public class QueryObject {
    /**
     * 
     */
    private SelectQuery selectQuery;
    /**
     * 
     */
    private Database database;
    /**
     * 
     */
    private DatabaseConnector databaseConnector;

    /**
     * 
     * @param c database connector
     * @param d database
     */
    public QueryObject(final DatabaseConnector c,
    		final Database d) {
        this.database = d;
        this.databaseConnector = c;
    }
    /**
     * 
     * @return select query
     */
    public final SelectQuery getSelectQuery() {
        return this.selectQuery;
    }

    /**
     * 
     * @param select
     */
    public final void setSelectQuery(final SelectQuery select) {
        this.selectQuery = select;
    }

    /**
     * 
     * @return db
     */
    public final Database getDatabase() {
        return this.database;
    }

    /**
     * 
     * @return connector
     */
    public final DatabaseConnector getDatabaseConnector() {
        return this.databaseConnector;
    }
}
