package com.whiuk.philip.eesa.db.mysql;

import com.whiuk.philip.eesa.db.DatabaseTable;
import com.whiuk.philip.eesa.db.Field;

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
