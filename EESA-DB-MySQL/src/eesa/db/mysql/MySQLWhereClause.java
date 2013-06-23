package eesa.db.mysql;

import eesa.db.Operator;
import eesa.db.SQLObject;
import eesa.db.WhereClause;

/**
 * Implements a MySQL WHERE clause.
 * @author Philip
 */
public class MySQLWhereClause extends WhereClause {
    /**
     * 
     * @param o1
     * @param op
     * @param o2 
     */
    public MySQLWhereClause(final SQLObject o1,
    		final Operator op, final SQLObject o2) {
        super(o1, op, o2);
    }
    /**
     * 
     * @return The concatenated string after being processed.
     */
    @Override
	public final String output() {
        return " (" + getO1().output() + " " + getOp().output() + " " + getO2().output() + ")";
    }    
    /**
     * 
     * @return 
     */
    @Override
	public final String toString() {
        return " (" + getO1() + " " + getOp() + " " + getO2() + ")";
    }
}
