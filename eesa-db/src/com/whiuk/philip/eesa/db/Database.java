package com.whiuk.philip.eesa.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Provides the base class for all databases in EESA.
 * @author Philip
 */

public abstract class Database {
    /**
     * 
     */
    private Connection conn;
    /**
     * 
     */
    private final String url;
    /**
     * Recommended access to individual databases is via the connector.
     * @param u URL
     */
    public Database(final String u) {
        this.url = u;
    }
    /**
     * 
     * @return connection
     * @throws DatabaseException exception
     */
    public final Connection getConnection() throws DatabaseException {
        try {
            if (conn == null || !conn.isValid(0)) {
               conn = DriverManager.getConnection(url);
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex.getMessage());
        }
        return conn;
    }
    /**
     * 
     * @return url
     */
    public final String getURL() {
        return url;
    }    
    /**
     * 
     * @return string representation of database
     */
    @Override
    public abstract String toString();
    /**
     * 
     * @return object to construct a select query
     */
    public abstract SelectQuery select();
    /**
     * 
     * @return object to construct an insert query
     */
    public abstract InsertQuery insert();    
    /**
     * 
     * @param o1 object 1
     * @param op operator
     * @param o2 object 2
     * @return object to construct a where clause
     */
    public abstract WhereClause where(SQLObject o1, Operator op, SQLObject o2);
    /**
     * 
     * @return  object to construct a join clause
     */
    public abstract JoinClause join();
    /**
     * 
     * @param f field
     * @param ordering type of ordering
     * @return an order by clause
     */
    public abstract OrderByClause orderBy(Field f, int ordering);
    
    /**
     * 
     * @return a list of tables
     * @throws DatabaseException  
     */
    public abstract DatabaseTable[] getTables() throws DatabaseException;

    /**
     * 
     * @param t the tables
     * @return list of fields from a set of tables
     * @throws DatabaseException exception
     */
    public abstract Field[] getFields(DatabaseTable[] t)
    		throws DatabaseException;

    /**
     * 
     * @return
     */
    public abstract Operator[] getOperators();
}