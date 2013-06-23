package eesa.db.mysql;

import eesa.db.DatabaseException;
import eesa.db.Field;
import eesa.db.InsertQuery;
import eesa.db.Row;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Provides the MySQL InsertQuery implementation.
 * @author Philip
 */
public class MySQLInsertQuery implements InsertQuery {

	/**
	 * 
	 */
    private final MySQLDatabase database;
    /**
     * 
     */
    private String table;
    /**
     * 
     */
    private List<Field> fields;
    /**
     * 
     */
    private ArrayList<Row> rows;
	/**
	 * 
	 */
    private String query;
    
    /**
     * 
     * @param database
     */
    MySQLInsertQuery(final MySQLDatabase db) {
        this.database = db;
        this.rows = new ArrayList<Row>();
        this.fields = new ArrayList<Field>();
    }

    /**
     * 
     * @param t table 
     */
    @Override
	public final void setTable(final String t) {
        this.table = t;
    }

    /**
     * 
     * @param f fields
     */
    @Override
	public final void setFields(final Field[] f) {
        this.fields = Arrays.asList(f);
    }

    @Override
	public final void setRows(final ArrayList<Row> r) {
        this.rows = r;
    }

    @Override
	public final void execute() throws DatabaseException {
        buildRows();
        buildQuery();
        PreparedStatement stmt;
        try {
            stmt = database.getConnection().prepareStatement(query);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }
    }
    /**
     * 
     */
    private void buildRows() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    /**
     * 
     */
    private void buildQuery() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
}
