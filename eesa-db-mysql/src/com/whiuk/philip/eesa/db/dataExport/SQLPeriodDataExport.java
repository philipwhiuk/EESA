package com.whiuk.philip.eesa.db.dataExport;

import com.whiuk.philip.eesa.dataExport.PeriodDataExport;
import com.whiuk.philip.eesa.exceptions.EESAException;
import java.util.ArrayList;
import java.util.List;

import com.whiuk.philip.eesa.db.Database;
import com.whiuk.philip.eesa.db.DatabaseConnector;
import com.whiuk.philip.eesa.db.InsertQuery;
import com.whiuk.philip.eesa.db.Row;

/**
 * Provides the structure for exporting time periods to SQL databases.
 * @author Philip
 */
public class SQLPeriodDataExport extends PeriodDataExport {
    /**
     * 
     */
    private Database database;
    /**
     * 
     */
    private DatabaseConnector dbConnector;
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
	public final void performExport() throws EESAException {
        processExportData();
        insertQuery.setRows(exportRows);
    }
    /**
     * 
     * @param c dbConnector
     */
    public final void setDatabaseConnector(final DatabaseConnector c) {
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
