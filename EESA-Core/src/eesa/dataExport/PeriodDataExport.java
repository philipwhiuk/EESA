package eesa.dataExport;

import eesa.core.ProcessorSpeedTimePeriod;
import eesa.core.Simulator;
import eesa.exceptions.EESAException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Provides a base structure for exporting time periods.
 * @author Philip
 */
public abstract class PeriodDataExport extends DataExport {
	/**
	 * The possible choices available when exporting 
	 * {@link eesa.core.ProcessorSpeedTimePeriod}s.
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
        public static final int COLUMN = 0, START = 1,
            END = 2, LENGTH = 3, SPEED = 4, ENERGY = 5,
            TESTID = 6, PROCESSORID = 7;
        /**
         * 
         */
        public static final int COUNT = 8;
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
                fields.put("Release", Choice.START);
                fields.put("Deadline", Choice.END);
                fields.put("Length", Choice.LENGTH);
                fields.put("Speed", Choice.SPEED);
                fields.put("Energy", Choice.ENERGY);
                fields.put("Test ID", Choice.TESTID);
                fields.put("Processor ID", Choice.PROCESSORID);
            }
            return fields;
        }
    };     
    /**
     * 
     */
    private ArrayList<ProcessorSpeedTimePeriod> periods;
	/**
	 * 
	 */
    public PeriodDataExport() {
		super(new String[]{});
	}    
    /**
     * 
     * @throws EESAException 
     */
    public final void runMapping() throws EESAException {
        ArrayList<Object[]> data = new ArrayList<Object[]>();
        ProcessorSpeedTimePeriod[] p = 
        		Simulator.getSimulator().getCurrentSimulation()
        		.getTestList().getPeriods();        
        for (int i = 0; i < p.length && i < DataExport.MAPPING_ROW_LIMIT; i++) {
            data.add(new Object[]{p[i].getStartTime(),
            		p[i].getEndTime(),
            		p[i].getLength(), p[i].getSpeed(),
            		p[i].getEnergy(), p[i].getTest().getID(),
            		p[i].getProcessor().getID()});
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
     * @param i Index
     * @return The array of possible choices for the mapping
     */
    public final String[] getChoicesForIndex(final int i) {
        String[] indexChoices = getChoices().toArray(
        		new String[getChoices().size()]);
        indexChoices[0] = getColumnByIndex(i);
        return indexChoices;
    }
    /**
     * 
     * @return data to export
     * @throws EESAException
     */
    public final Object[][] getExportData() {
        ArrayList<Object[]> data = new ArrayList<Object[]>();
        ProcessorSpeedTimePeriod[] ps = Simulator.getSimulator()
        		.getCurrentSimulation().getTestList().getPeriods();
        for (ProcessorSpeedTimePeriod p : ps) {
            data.add(new Object[]{
            	p.getStartTime(), p.getEndTime(),
                p.getLength(), p.getSpeed(),
                p.getEnergy(), p.getTest().getID(),
                p.getProcessor().getID()});
        }
        return data.toArray(new Object[][]{});
    }     
}