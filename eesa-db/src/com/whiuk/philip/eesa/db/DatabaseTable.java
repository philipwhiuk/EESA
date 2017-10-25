package com.whiuk.philip.eesa.db;

/**
 * Provides a base class to represent a database table.
 * @author Philip Whitehouse
 *
 */
public class DatabaseTable implements SQLObject {
	
	/**
	 * 
	 */
	private String tableName;
	/**
	 * 
	 * @param n tableName
	 */
	public DatabaseTable(final String n) {
		this.tableName = n;
	}
	
	@Override
	public final String output() {
		// TODO Auto-generated method stub
		return tableName;
	}

}
