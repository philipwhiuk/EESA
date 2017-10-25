package com.whiuk.philip.eesa.db;

/**
 * Provides an interface for where-based conditions.
 * @author Philip
 */
public abstract class WhereClause implements DatabaseCondition {
    /**
     * 
     */
	private final SQLObject object1;
    /**
     * 
     */
    private final Operator operator;
    /**
     * 
     */
    private final SQLObject object2;
    /**
     * 
     * @param o1 object 1
     * @param op operator
     * @param o2 object 2
     */
    public WhereClause(final SQLObject o1,
    		final Operator op,
    		final SQLObject o2) {
        this.object1 = o1;
        this.operator = op;
        this.object2 = o2;
    }
    /**
	 * @return the o1
	 */
	public final SQLObject getO1() {
		return object1;
	}
	/**
	 * @return the op
	 */
	public final Operator getOp() {
		return operator;
	}
	/**
	 * @return the o2
	 */
	public final SQLObject getO2() {
		return object2;
	}
	/**
     * 
     * @return The clause as ready to be processed by the database engine
     */
    @Override
    public abstract String output();

}
