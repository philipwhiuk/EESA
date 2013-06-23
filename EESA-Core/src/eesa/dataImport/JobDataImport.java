package eesa.dataImport;

import eesa.core.Job;
import eesa.core.Simulator;
import eesa.exceptions.EESAException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Provides a base structure for importing jobs.
 * @author Philip
 */
public abstract class JobDataImport {
    /**
     * Stores the data retrieved that's used in mapping.
     */
    private Object[][] mappingData;
    /**
     * Stores the results data retrieved.
     */
    private Object[][] resultData;    
    /**
     * Stores the jobs that created from retrieved results.
     */
    private ArrayList<Job> resultJobs;
    /**
     * Stores the names of columns of data from the source.
     */
    private String[] columns;
    /**
     * Stores the number of columns of data from the source.
     */
    private int numColumns;
    /**
     * 
     */
    private int[] columnKeys;
    /**
     * 
     */
    private boolean[] parameters;
    /**
     * Details on the options for each mapping.
     */
    public static class Choice {
        /**
         * 
         */
        /**
         * 
         */
        /**
         * 
         */
        /**
         * 
         */
        /**
         * 
         */
        /**
         * 
         */
        /**
         * 
         */
        public static final int COLUMN = 0, JOBID = 1, RELEASE = 2,
            DEADLINE = 3, LENGTH = 4, WEIGHT = 5, DENSITY = 6;
        /**
         * 
         */
        public static final int COUNT = 7;
        /**
         * 
         */
        private static HashMap<String, Integer> fields;
        /**
         * 
         * @return fields
         */
        public static HashMap<String, Integer> getFields() {
            if (fields == null) {
                fields = new HashMap<String, Integer>(Choice.COUNT);
                fields.put("Job ID", Choice.JOBID);
                fields.put("Release", Choice.RELEASE);
                fields.put("Deadline", Choice.DEADLINE);
                fields.put("Length", Choice.LENGTH);
                fields.put("Weight", Choice.WEIGHT);
                fields.put("Density", Choice.DENSITY);        
            }
            return fields;
        }
    };
    /**
     * 
     * @return The data used for mapping
     */
    public final Object[][] getMappingData() {
        return mappingData;
    }
    /**
     * 
     * @return The names of the columns that were set
     */
    public final String[] getColumns() {
        return columns;
    }    
    /**
     * 
     * @return The number of columns
     */
    public final int getNumColumns() {
        return numColumns;
    }
    /**
     * 
     * @param index The column index
     * @return The array of possible choices for the mapping
     */
    public final String[] getChoices(final int index) {
        String[] choices = new String[Choice.COUNT];
        choices[Choice.COLUMN] = columns[index];
        choices[Choice.JOBID] = "Job ID";
        choices[Choice.RELEASE] = "Release";
        choices[Choice.DEADLINE] = "Deadline";
        choices[Choice.LENGTH] = "Length";
        choices[Choice.WEIGHT] = "Weight";
        choices[Choice.DENSITY] = "Density";
        return choices;
    }    
    /**
     * 
     * @param n Number of columns 
     */
    public final void setNumColumns(final int n) {
        this.numColumns = n;
    }
    /**
     * 
     * @param c Columns 
     */
    public final void setColumns(final String[] c) {
        this.columns = c;
    }    
    /**
     * 
     * @param m Mapping data 
     */
    public final void setMappingData(final Object[][] m) {
        this.mappingData = m;
    }
    /**
     * 
     * @return column keys
     */
    public final int[] getColumnKeys() {
        return this.columnKeys;      
    } 
    /**
     * 
     * @param c The choice set for each column
     */
    public final void setColumnKeys(final int[] c) {
        this.columnKeys = c;
    }  
    /**
     * 
     * @return parameters
     */
    public final boolean[] getParameters() {
        return this.parameters;      
    }    
    /**
     * 
     * @param p Whether a certain field was used
     */
    public final void setParameters(final boolean[] p) {
        this.parameters = p;        
    }
    /**
     * 
     * @return The jobs that were obtained when the import was performed
     */
    public final ArrayList<Job> getResultJobs() {
        return resultJobs;
    }   
    /**
     * 
     * @param r Jobs that were obtained when the import was performed
     */
    public final void setResultsJobs(final ArrayList<Job> r) {
        this.resultJobs = r;
    }
    /**
     * 
     * @return results data
     */
    public final Object[][] getResultData() {
        return resultData;
    }
    /**
     * 
     * @param r Results data 
     */
    public final void setResultData(final Object[][] r) {
        this.resultData = r;
    }
    /**
     * 
     * @throws EESAException 
     */
    public abstract void runMapping() throws EESAException;
    /**
     * @throws EESAException 
     * 
     */
    public abstract void generateImport() throws EESAException;

    /**
     * 
     * @throws EESAException 
     */
    public final void addJobsImport() throws EESAException {
        Simulator.getSimulator().getCurrentSimulation()
        .getJobSet().addJobs(resultJobs);
    }
    /**
     * 
     * @throws EESAException 
     */
    public final void replaceJobsImport() throws EESAException {
        Simulator.getSimulator().getCurrentSimulation().
        getJobSet().setJobs(resultJobs);
    }      
}
