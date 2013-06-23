package eesa.csv.dataImport;

import eesa.core.Job;
import eesa.csv.CSVException;
import eesa.csv.CSVFile;
import eesa.dataImport.JobDataImport;
import eesa.exceptions.JobException;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Provides the structure for importing jobs from CSV.
 * @author Philip
 */
public class CSVJobDataImport extends JobDataImport {
    /**
     * 
     */
    private File source;
    /**
     * 
     */
    private String delimeter;
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
     * @param text
     */
    public final void setSource(final String text) {
        setSource(new File(text));
    }
    /**
     * 
     * @param f File
     */
    public final void setSource(final File f) {
        this.source = f;
    }
    @Override
	public final void runMapping() {
        String[][] lines = csvFile.getLines();
        ArrayList<String[]> mappingLines = new ArrayList<String[]>();
        for (int i = 0; i < lines.length && i < 10; i++) {
            mappingLines.add(lines[i]);
        }
        setMappingData(mappingLines.toArray(new String[][]{}));
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * 
     * @throws CSVException
     * @throws JobException
     */
    @Override
	public final void generateImport() throws CSVException, JobException {
        runImportQuery();
        processImportData();
    }
    
    /**
     * 
     * @throws CSVException
     */
    private void runImportQuery() throws CSVException {
        csvFile = new CSVFile(source, delimeter);
        csvFile.readFromFile();
        setResultData(csvFile.getLines());
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
            
            Map<Job.Property, Float> properties = 
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
            			(Float) resultData[r][columnKeys[Choice.RELEASE]]);
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
