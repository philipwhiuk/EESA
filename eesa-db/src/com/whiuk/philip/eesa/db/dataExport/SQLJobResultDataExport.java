package com.whiuk.philip.eesa.db.dataExport;

import com.whiuk.philip.eesa.core.Job;
import com.whiuk.philip.eesa.dataExport.JobResultDataExport;
import com.whiuk.philip.eesa.db.Database;
import com.whiuk.philip.eesa.db.DatabaseConnector;
import com.whiuk.philip.eesa.db.DatabaseException;
import com.whiuk.philip.eesa.db.InsertQuery;
import com.whiuk.philip.eesa.db.SelectQuery;
import com.whiuk.philip.eesa.exceptions.EESAException;
import com.whiuk.philip.eesa.exceptions.JobException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Provides the structure for importing jobs to SQL databases.
 * @author Philip
 */
public class SQLJobResultDataExport extends JobResultDataExport {
    /**
     * 
     */
    private DatabaseConnector dbConnector;
    /**
     * 
     */
    private Database database;
    /**
     * 
     */
    private InsertQuery insertQuery;
    /**
     * 
     * @param c dbConnector 
     */
    public final void setDatabaseConnector(final DatabaseConnector c) {
        this.dbConnector = c;
    }
    /**
     * 
     * @param db 
     */
    public final void setDatabase(final Database db) {
        this.database = db;
    }
    /**
     * 
     * @return db
     */
    public final Database getDatabase() {
        return database;
    }
    /**
     * 
     * @return connector
     */
    public final DatabaseConnector getDatabaseConnector() {
        return dbConnector;
    }
    /**
     * 
     * @param s insertQuery 
     */
    public final void setInsertQuery(final InsertQuery s) {
        this.insertQuery = s;
    }
	@Override
	public void generateExport() throws EESAException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}
	@Override
	public void performExport() throws EESAException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}
}
