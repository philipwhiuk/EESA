package com.whiuk.philip.eesa.dataExport;

import com.whiuk.philip.eesa.core.JobResult;
import com.whiuk.philip.eesa.core.Simulator;
import com.whiuk.philip.eesa.exceptions.EESAException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Provides a base structure for exporting job results.
 * @author Philip
 */
public abstract class JobResultDataExport extends DataExport {
	/**
	 * The possible choices available when 
	 * exporting {@link eesa.core.JobResult}s.
	 * @author Philip Whitehouse
	 *
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
            DEADLINE = 3, LENGTH = 4, WEIGHT = 5, 
            DENSITY = 6, TESTID = 7, PROCESSORID = 8;
        /**
         * 
         */
        public static final int COUNT = 9;
        /**
         * 
         */
        private static HashMap<String, Integer> fields;
        /**
         * 
         * @return field mapping
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
                fields.put("Test ID", Choice.TESTID);
                fields.put("Processor ID", Choice.PROCESSORID);
            }
            return fields;
        }
    };    
    /**
     * 
     */
    private List<JobResult> jobResults;
	/**
	 * 
	 */
    public JobResultDataExport() {
		super(new String[]{});
	}  
    /**
     * 
     * @throws EESAException 
     */
    public final void runMapping() throws EESAException {
        List<Object[]> data = new ArrayList<Object[]>();
        JobResult[] results = Simulator.getSimulator().getCurrentSimulation().
        		getTestList().getResults();
        for (int i = 0; i < results.length && i < DataExport.MAPPING_ROW_LIMIT; i++) {
            data.add(new Object[]{
                results[i].getID(), results[i].getJob().getReleaseTime(),
                results[i].getJob().getDeadlineTime(),
                results[i].getJob().getLength(),
                results[i].getJob().getWeight(),
                results[i].getJob().getDensity(), results[i].getTest().getID(),
                results[i].getProcessor().getID()});
        }
        setMappingData(data.toArray(new Object[][]{}));
    }
    /**
     * 
     * @throws EESAException 
     */
    public abstract void generateExport() throws EESAException;
    /**
     * 
     * @throws EESAException 
     */
    public abstract void performExport() throws EESAException;
    /**
     * 
     * @param index Column index
     * @return The array of possible choices for the mapping
     */
    public final String[] getChoicesForIndex(final int index) {
        String[] indexChoices = getChoices().toArray(new String[getChoices().size()]);
        indexChoices[0] = getColumnByIndex(index);
        return indexChoices;
    }
    /**
     * 
     * @return data to export
     */
    public final Object[][] getExportData() {
        List<Object[]> data = new ArrayList<Object[]>();
        JobResult[] results = Simulator.getSimulator().getCurrentSimulation().
        		getTestList().getResults();
        for (int i = 0; i < results.length; i++) {
            data.add(new Object[]{
                results[i].getID(),
                results[i].getJob().getReleaseTime(),
                results[i].getJob().getDeadlineTime(),
                results[i].getJob().getLength(),
                results[i].getJob().getWeight(),
                results[i].getJob().getDensity(),
                results[i].getTest().getID(),
                results[i].getProcessor().getID()});
        }
        return data.toArray(new Object[][]{});
        
    }     
}