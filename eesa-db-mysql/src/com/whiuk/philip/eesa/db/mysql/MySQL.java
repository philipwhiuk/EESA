package com.whiuk.philip.eesa.db.mysql;

import java.util.ArrayList;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.whiuk.philip.eesa.db.Database;
import com.whiuk.philip.eesa.db.DatabaseConnector;

/**
 * Provides a MySQL database connector to EESA.
 * @author Philip
 */
public class MySQL implements DatabaseConnector {
    /**
     * 
     */
    private final ArrayList<Database> definedDatabases = new ArrayList<Database>();
    /**
     * 
     */
    private Database defaultDatabase;
    /**
     * 
     * @param driverClass
     * @param cE
     * @throws ClassNotFoundException 
     */
    public MySQL(final String driverClass, final Element cE)
    		throws ClassNotFoundException {
        Class.forName(driverClass);
        NodeList childNodes = cE.getChildNodes();
        for (int d = 0; d < childNodes.getLength(); d++) {
            if (childNodes.item(d).getNodeType() == Node.ELEMENT_NODE) {
                Element dbE = (Element) childNodes.item(d);
                MySQLDatabase db = new MySQLDatabase(this, dbE);
                definedDatabases.add(db);
                if (dbE.getAttribute("default").equals("true")) {
                    defaultDatabase = db;
                }
            }
        }
    }
    @Override
	public final String toString() {
        return "MySQL";
    }
    @Override
	public final Database getDatabase(final String url) {
        return new MySQLDatabase(url);
    }

    @Override
	public final String getJDBCCode() {
        return "mysql";
    }

    @Override
	public final Database getDefaultDatabase() {
        return defaultDatabase;
    }

    @Override
	public final Database[] getDefinedDatabaseConnections() {
        return definedDatabases.toArray(new Database[]{});
    }
}
