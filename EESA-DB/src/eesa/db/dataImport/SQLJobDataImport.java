package eesa.db.dataImport;

import eesa.core.Job;
import eesa.dataImport.JobDataImport;
import eesa.db.Database;
import eesa.db.DatabaseConnector;
import eesa.db.DatabaseException;
import eesa.db.SelectQuery;
import eesa.exceptions.EESAException;
import eesa.exceptions.JobException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Provides the structure for importing jobs to SQL databases.
 * @author Philip
 */
public class SQLJobDataImport extends JobDataImport {
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
    private SelectQuery selectQuery;
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
     * @param s selectQuery 
     */
    public final void setSelectQuery(final SelectQuery s) {
        this.selectQuery = s;
    }
    /**
     * 
     * @throws EESAException
     */
    @Override
	public final void runMapping() throws EESAException {
        try {
            ArrayList<Object[]> queryData = new ArrayList<Object[]>();
            ResultSet results = selectQuery.execute();
            ResultSetMetaData md = results.getMetaData();
            int numColumns = md.getColumnCount();
            String[] columns = new String[numColumns];
            for (int i = 0; i < numColumns; i++) {
                columns[i] = md.getColumnName(i + 1);
            }        
            while (results.next()) {
                Object[] rowData = new Object[numColumns];
                for (int i = 0; i < numColumns; i++) {
                    rowData[i] = results.getObject(i + 1);
                }
                queryData.add(rowData);
            }
            results.close();
            setColumns(columns);
            setNumColumns(numColumns);
            setMappingData(queryData.toArray(new Object[][]{}));
        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }
    }
    /**
     * 
     * @throws DatabaseException
     * @throws JobException
     */
    @Override
	public final void generateImport() throws DatabaseException, JobException {
        runImportQuery();
        processImportData();
    }
    /**
     * 
     * @throws DatabaseException
     */
    private void runImportQuery() throws DatabaseException {
        try {
            ArrayList<Object[]> queryData = new ArrayList<Object[]>();
            ResultSet results = selectQuery.execute();
            ResultSetMetaData md = results.getMetaData();
            int numColumns = md.getColumnCount();
            String[] columns = new String[numColumns];
            columns = new String[numColumns];
            for (int i = 0; i < numColumns; i++) {
                columns[i] = md.getColumnName(i + 1);
            }        
            while (results.next()) {
                Object[] rowData = new Object[numColumns];
                for (int i = 0; i < numColumns; i++) {
                    rowData[i] = results.getObject(i + 1);
                }
                queryData.add(rowData);
            }
            results.close();
            setColumns(columns);
            setNumColumns(numColumns);            
            setResultData(queryData.toArray(new Object[][]{}));        
        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }
    }
    /**
     * 
     * @throws JobException
     */
    private void processImportData() throws JobException {
        Object[][] resultData = getResultData();
        ArrayList<Job> resultJobs = new ArrayList<Job>(resultData.length);
        boolean[] parameters = getParameters();
        int[] columnKeys = getColumnKeys();
        for (int r = 0; r < resultData.length; r++) {
            int jobID = -1;
            HashMap<Job.Property, Float> properties = 
            		new HashMap<Job.Property, Float>();
            
            if (parameters[Choice.JOBID]) {
                jobID = (Integer) resultData[r][columnKeys[Choice.JOBID]];
            }
            if (parameters[Choice.RELEASE]) {
            	properties.put(Job.Property.RELEASE,
            			(Float) resultData[r][columnKeys[Choice.RELEASE]]);
            }
            if (parameters[Choice.DEADLINE]) {
            	properties.put(Job.Property.DEADLINE,
            			(Float) resultData[r][columnKeys[Choice.DEADLINE]]);
            }            
            if (parameters[Choice.LENGTH]) {
            	properties.put(Job.Property.LENGTH,
            			(Float) resultData[r][columnKeys[Choice.LENGTH]]);
            }
            if (parameters[Choice.WEIGHT]) {
            	properties.put(Job.Property.WEIGHT,
            			(Float) resultData[r][columnKeys[Choice.WEIGHT]]);
            }
            if (parameters[Choice.DENSITY]) {
            	properties.put(Job.Property.DENSITY,
            			(Float) resultData[r][columnKeys[Choice.DENSITY]]);
            }
            Job j = new Job(jobID, properties);
            resultJobs.add(j);
        }
        setResultsJobs(resultJobs);
    }
}
