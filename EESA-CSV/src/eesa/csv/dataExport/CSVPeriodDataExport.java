package eesa.csv.dataExport;

import eesa.csv.CSVException;
import eesa.csv.CSVFile;
import eesa.dataExport.PeriodDataExport;
import eesa.exceptions.EESAException;
import java.io.File;
import java.util.List;

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
