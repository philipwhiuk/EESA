package com.whiuk.philip.eesa.db;

/**
 * Provides a base class for storing field data.
 * @author Philip
 */
public abstract class Field implements SQLObject {
    /**
     * 
     */
    private DatabaseTable table;
    /**
     * 
     */
    private String column;
    /**
     * 
     */
    private String alias;
    /**
     * 
     * @param t table
     * @param c column
     */
    public Field(final DatabaseTable t, final String c) {
        this.table = t;
        this.column = c;
    }
    @Override
	public final String toString() {
        if (alias == null) {
            return "`" + table + "`.`" + column + "`";
        }
        return alias;
    }

    /**
     * 
     * @param a alias
     */
    public final void setAlias(final String a) {
        alias = a;
    }
    /**
     * 
     * @return table
     */
    public final DatabaseTable getTable() {
        return table;
    }
    /**
     * 
     * @return column
     */
    public final String getColumn() {
        return column;
    }
    /**
     * 
     * @return alias
     */
    public final String getAlias() {
       return alias; 
    }
}
