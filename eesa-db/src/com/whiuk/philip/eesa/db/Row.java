package com.whiuk.philip.eesa.db;

/**
 * Provides a base class to store row data for inserts and updates.
 * @author Philip
 */
public class Row {
    /**
     * 
     */
    private Object[] fields;
    /**
     * 
     * @param f fields
     */
    public Row(final Object[] f) {
        this.fields = f;
    }
}
