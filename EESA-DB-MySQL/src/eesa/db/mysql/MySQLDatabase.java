package eesa.db.mysql;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.w3c.dom.Element;

import eesa.db.Database;
import eesa.db.DatabaseException;
import eesa.db.DatabaseTable;
import eesa.db.Field;
import eesa.db.InsertQuery;
import eesa.db.JoinClause;
import eesa.db.Operator;
import eesa.db.OrderByClause;
import eesa.db.SQLObject;
import eesa.db.SelectQuery;
import eesa.db.WhereClause;

/**
 * Manages a MySQL database.
 * @author Philip
 */
public class MySQLDatabase extends Database {
    /**
     * 
     */
    private String name;
    /**
     * 
     * @param url
     */
    public MySQLDatabase(final String url) {
        super(url);
    }  
    /**
     * 
     * @param host
     * @param username
     * @param port
     * @param password
     * @param dbName
     */
    public MySQLDatabase(final String host, final String username, final int port,
    		final String password, final String dbName) {
        this("mysql://" + host + "/");
    }
    /**
     * Construct a database object from a stored XML fragment.
     * @param connector 
     * @param e 
     */
    public MySQLDatabase(final MySQL connector, final Element e) {
        this("jdbc:" + connector.getJDBCCode()
                + "://" + e.getAttribute("host")
                + ":" + e.getAttribute("port")
                + "/" + e.getAttribute("database")
                + "?user=" + e.getAttribute("username") + "&password=" + e.getAttribute("password"));
        name = e.getAttribute("name");
    }
    @Override
	public final SelectQuery select() {
        return new MySQLSelectQuery(this);
    }
    
    @Override
	public final InsertQuery insert() {
        return new MySQLInsertQuery(this);
    }

    @Override
	public final WhereClause where(final SQLObject o1,
    		final Operator op, final SQLObject o2) {
        return new MySQLWhereClause(o1, op, o2);
    }

    @Override
	public final JoinClause join() {
        return new MySQLJoinClause();
    }

    @Override
	public final String toString() {
        if (name == null) {
            return getURL();
        }
        return name;
    }
    /**
     * 
     * @return
     * @throws DatabaseException 
     */
    @Override
	public final DatabaseTable[] getTables() throws DatabaseException {        
        try {
            ArrayList<DatabaseTable> tables = new ArrayList<DatabaseTable>();
            DatabaseMetaData md = getConnection().getMetaData();
            ResultSet rs = md.getTables(null, null, "%", null);
            while (rs.next()) {
              tables.add(new DatabaseTable(rs.getString(3)));
            }
            rs.close();
            return tables.toArray(new DatabaseTable[]{});
        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }
    }

    /**
     * 
     * @param tables
     * @return
     */
    @Override
	public final Field[] getFields(final DatabaseTable[] tables) throws DatabaseException {
        ArrayList<Field> fields = new ArrayList<Field>();
        for (int t = 0; t < tables.length; t++) {            
            try {
                Statement st = getConnection().createStatement();            
                ResultSet rs = st.executeQuery("SELECT * FROM `" + tables[t] + "` LIMIT 1");
                ResultSetMetaData metaData = rs.getMetaData();
                for (int c = 1; c <= metaData.getColumnCount(); c++) {
                    fields.add(new MySQLField(tables[t], metaData.getColumnName(c)));
                }
                rs.close();
                st.close();
            } catch (SQLException ex) {
                throw new DatabaseException(ex);
            }
        }
        return fields.toArray(new Field[]{});
    }

    /**
     * 
     * @return
     */
    @Override
	public final Operator[] getOperators() {
        return Operator.getOperators();
    }

    @Override
	public final OrderByClause orderBy(final Field f, final int ordering) {
        return new MySQLOrderByClause(f, ordering);
    }
}
