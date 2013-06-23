package eesa.db.mysql;

import eesa.db.DatabaseTable;
import eesa.db.Field;

/**
 * Provides the MySQL field implementation.
 * @author Philip
 */
class MySQLField extends Field {
    /**
     * 
     * @param tables
     * @param column 
     */
    MySQLField(final DatabaseTable tables, final String column) {
        super(tables, column);
    }
    /**
     * 
     * @return 
     */
    @Override
    public String output() {
        if (getAlias() == null) {
            return "`" + getTable() + "`.`" + getColumn() + "`";
        }
        return getAlias();
    }
    
}
