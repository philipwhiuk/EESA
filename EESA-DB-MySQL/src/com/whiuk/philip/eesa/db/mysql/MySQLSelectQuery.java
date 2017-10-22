package com.whiuk.philip.eesa.db.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.whiuk.philip.eesa.db.DatabaseCondition;
import com.whiuk.philip.eesa.db.DatabaseSort;
import com.whiuk.philip.eesa.db.DatabaseTable;
import com.whiuk.philip.eesa.db.Field;
import com.whiuk.philip.eesa.db.JoinClause;
import com.whiuk.philip.eesa.db.WhereClause;

import com.whiuk.philip.eesa.db.DatabaseException;
import com.whiuk.philip.eesa.db.SelectQuery;

/**
 * Implements a MySQL SELECT query.
 * @author Philip
 */
public class MySQLSelectQuery implements SelectQuery {
    
    /**
     * 
     */
    private List<Field> fields;
    /**
     * 
     */
    private List<DatabaseTable> tables;
    /**
     * 
     */
    private ArrayList<JoinClause> join;
    /**
     * 
     */
    private WhereClause where;
    /**
     * 
     */
    private int limit;
    /**
     * 
     */
    private String query;
    /**
     * 
     */
    private PreparedStatement stmt;
    /**
     * 
     */
    private final MySQLDatabase database;
    /**
     * 
     */
    private DatabaseCondition condition;
    /**
     * 
     */
    private List<DatabaseSort> sorts;
    /**
     * 
     * @param db database 
     */
    MySQLSelectQuery(final MySQLDatabase db) {
        this.database = db;
        fields = new ArrayList<Field>();
        tables = new ArrayList<DatabaseTable>();
        join = new ArrayList<JoinClause>();
        sorts = new ArrayList<DatabaseSort>();
    }
    
    @Override
	public final void field(final Field field) {
        fields.add(field);
    }
    
    @Override
	public final void table(final DatabaseTable table) {
        tables.add(table);
    }
    
    @Override
	public final void join(final JoinClause jc) {
        join.add(jc);
    }
    
    @Override
	public final void where(final WhereClause wc) {
        where = wc;
    }
    /**
     * 
     */
    private void buildQuery() {
        StringBuilder sb = new StringBuilder("SELECT ");
        for (int i = 0; i < fields.size(); i++) {
            if (i != 0) {
              sb.append(", ");
            }
            sb.append(fields.get(i));
        }
        sb.append(" FROM ");
        for (int i = 0; i < tables.size(); i++) {
            if (i != 0) {
              sb.append(", ");
            }
            sb.append(tables.get(i));
        }
        if (where != null) {
            sb.append(" WHERE ");
            sb.append(where.output());
        }
        if (limit != 0) {
            sb.append(" LIMIT ");
            sb.append(limit);
        }
        query = sb.toString();
    }
    /**
     * 
     * @return
     * @throws DatabaseException 
     */
    @Override
	public final ResultSet execute() throws DatabaseException {
        buildWhere();
        buildQuery();
        try {
            stmt = database.getConnection().prepareStatement(query);
            return stmt.executeQuery();
        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }
    }
    /**
     * 
     * @param s statement
     * @param rs
     * @throws SQLException 
     */
    public final void finishSelectQuery(final PreparedStatement s, 
    		final ResultSet rs) throws SQLException {
        rs.close();
        s.close();
    }
    @Override
	public final String output() {
        buildWhere();
        buildQuery();
        return query;
    }
    /**
     * 
     * @param t tables 
     */
    @Override
	public final void setTables(final DatabaseTable[] t) {
        this.tables = Arrays.asList(t);
    }
    /**
     * 
     * @param f fields 
     */
    @Override
	public final void setFields(final Field[] f) {
        this.fields = Arrays.asList(f);
    }

    /**
     * 
     * @param c condition
     */
    @Override
	public final void setCondition(final DatabaseCondition c) {
        this.condition = c;
    }

    /**
     * 
     * @param s sorts
     */
    @Override
	public final void setSorts(final DatabaseSort[] s) {
        this.sorts = Arrays.asList(s);
    }

    /**
     * 
     */
    private void buildWhere() {
        if (condition instanceof MySQLWhereClause) {
            this.where = (MySQLWhereClause) condition;
        }
    }
    
}
