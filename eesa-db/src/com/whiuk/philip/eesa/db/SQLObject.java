package com.whiuk.philip.eesa.db;

/**
 * Provides an interface to support objects in SQL queries.
 * @author Philip
 */
public interface SQLObject {

    /**
     * 
     * @return
     */
    String output();
    /**
     * 
     * @return
     */
    @Override
    String toString();
    
}
