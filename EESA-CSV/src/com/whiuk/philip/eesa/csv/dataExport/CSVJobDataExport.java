package com.whiuk.philip.eesa.csv.dataExport;

import com.whiuk.philip.eesa.csv.CSVException;
import com.whiuk.philip.eesa.dataExport.JobDataExport;
import com.whiuk.philip.eesa.exceptions.EESAException;
import java.io.File;
import java.util.List;

import com.whiuk.philip.eesa.csv.CSVFile;

/**
 * Provides the structure for exporting jobs to CSV.
 * @author Philip
 */
public class CSVJobDataExport extends JobDataExport {
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
    /**
     * 
     * @param text 
     */
    public final void setDelimeter(final String text) {
        this.delimeter = text;
    }

    /**
     * 
     * @param f filename
     */
    public final void setFile(final String f) {
        setFile(new File(f));
    }
    /**
     * 
     * @param f File
     */
    public final void setFile(final File f) {
        this.file = f;
    }
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
