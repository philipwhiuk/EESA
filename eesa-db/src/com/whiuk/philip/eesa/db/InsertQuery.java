package com.whiuk.philip.eesa.db;

import java.util.ArrayList;

/**
 * Provides an interface for perform database inserts.
 * @author Philip
 */
public interface InsertQuery {

    /**
     * 
     * @param table 
     */
    void setTable(String table);

    /**
     * 
     * @param fields
     */
    void setFields(Field[] fields);

    /**
     * 
     * @param rows
     */
    void setRows(ArrayList<Row> rows);

    /**
     * 
     * @throws DatabaseException
     */
    void execute() throws DatabaseException;

    
}
