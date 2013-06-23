package eesa.db.mysql;

import eesa.db.Field;
import eesa.db.OrderByClause;

/**
 * Implements a MySQL ORDER BY clause.
 * @author Philip
 */
class MySQLOrderByClause implements OrderByClause {
    /**
     * 
     */
    private final Field field;
    /**
     * 
     */
    private final String ordering;
    /**
     * 
     * @param f
     * @param o 
     */
    MySQLOrderByClause(final Field f, final int o) {
        this.field = f;
        if (o == 0) {
            this.ordering = "ASC";
        } else {
            this.ordering = "DESC";
        }
    }
    
    @Override
    public String toString() {
        return field + " " + ordering;
    }
}
