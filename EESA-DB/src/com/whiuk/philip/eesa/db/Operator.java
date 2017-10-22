package com.whiuk.philip.eesa.db;

/**
 * Provides common operators and format for their creation.
 * @author Philip
 */
public final class Operator {
    /**
     * 
     */
	private static final Operator AND = new Operator("AND");
    /**
     * 
     */
	private static final Operator OR = new Operator("OR");
    /**
     * 
     */
	private static final Operator EQUALS = new Operator("=");
    /**
     * 
     */
	private static final Operator NOT_EQUALS = new Operator("!=");
    /**
     * 
     */
	private static final Operator LESSTHAN = new Operator("<");    
    /**
     * 
     */
	private static final Operator GREATERTHAN = new Operator(">");
    /**
     * 
     */
	private static final Operator LESSTHANEQUALS = new Operator("<=");
    /**
     * 
     */
	private static final Operator GREATERTHANEQUALS = new Operator(">=");

    /**
     * 
     * @return
     */
    public static Operator[] getOperators() {
        return new Operator[]{
        		AND, OR, EQUALS,
        		NOT_EQUALS, LESSTHAN,
        		GREATERTHAN, LESSTHANEQUALS,
        		GREATERTHANEQUALS};
    }
    
    /**
     * 
     */
    private final String operator;

    /**
     * 
     * @param op operator
     */
    private Operator(final String op) {
        this.operator = op;
    }
    @Override
    public String toString() {
        return operator;
    }
    /**
     * 
     * @return string output
     */
    public String output() {
        return operator;
    }
}
