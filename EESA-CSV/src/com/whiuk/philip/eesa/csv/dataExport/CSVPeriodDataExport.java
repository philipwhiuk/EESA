package com.whiuk.philip.eesa.csv.dataExport;

import com.whiuk.philip.eesa.csv.CSVException;
import com.whiuk.philip.eesa.dataExport.PeriodDataExport;
import com.whiuk.philip.eesa.exceptions.EESAException;
import java.io.File;
import java.util.List;

import com.whiuk.philip.eesa.csv.CSVFile;

/**
 * Provides the structure for exporting time periods to CSV.
 * @author Philip
 */
public class CSVPeriodDataExport extends PeriodDataExport {
    /**
     * 
     */
    private String delimeter;
    /**
     * 
     */
    private File file;
    /**
     * 
     */
    private CSVFile csvFile;
    
    @Override
	public final void generateExport() throws EESAException {
        csvFile = new CSVFile(file, delimeter);
        List<String> choices = getChoices();
        String[] columns = getColumns();
        int[] keys = getColumnKeys();
        boolean[] columnSet = this.getParameters();        
        Object[][] resultData = getExportData();        
        for (int r = 0; r < resultData.length; r++) {
            String[] fields = new String[choices.size()];
            for (int c = 0; c < columns.length; c++) {
                if (columnSet[c]) {
                    fields[keys[c]] = resultData[r][0].toString();
                }
            } 
            csvFile.addLine(fields);
        }        
    }
    
    @Override
	public final void performExport() throws CSVException {
        csvFile.writeToFile();
    }
}
