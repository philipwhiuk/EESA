package eesa.db.dataExport;

import eesa.dataExport.JobDataExport;
import eesa.db.Database;
import eesa.db.DatabaseConnector;
import eesa.db.DatabaseException;
import eesa.db.InsertQuery;
import eesa.db.Row;
import eesa.exceptions.EESAException;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides the structure for exporting jobs to SQL databases.
 * @author Philip
 */
public class SQLJobDataExport extends JobDataExport {
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
     */
    private ArrayList<Row> exportRows;

    /**
     * 
     * @return database
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
     * @param c dbConnector
     */
    public final void setDatabaseConnector(
    		final DatabaseConnector c) {
        this.dbConnector = c;
    }

    /**
     * 
     * @param db database
     */
    public final void setDatabase(final Database db) {
        this.database = db;
    }

    /**
     * 
     * @param i insertQuery
     */
    public final void setInsertQuery(final InsertQuery i) {
        this.insertQuery = i;
    }

    @Override
	public final void generateExport() throws EESAException {        
        processExportData();
        insertQuery.setRows(exportRows);
    }

    @Override
	public final void performExport() throws DatabaseException {
        insertQuery.execute();
    }

    /**
     * 
     * @throws EESAException exception
     */
    private void processExportData() throws EESAException {
        Object[][] resultData = getExportData();        
        exportRows = new ArrayList<Row>(resultData.length);
        List<String> choices = getChoices();
        String[] columns = getColumns();
        int[] keys = getColumnKeys();
        boolean[] columnSet = this.getParameters();
        for (int r = 0; r < resultData.length; r++) {
            Object[] fields = new Object[choices.size()];
            for (int c = 0; c < columns.length; c++) {
                if (columnSet[c]) {
                    fields[keys[c]] = resultData[r][0];
                }
            }            
            Row row = new Row(fields);            
            exportRows.add(row);
        }
    }


    
}
