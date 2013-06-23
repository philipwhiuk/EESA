package eesa.dataExport;

import eesa.core.Job;
import eesa.core.Simulator;
import eesa.exceptions.EESAException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Provides a base structure for exporting jobs.
 * @author Philip
 */
public abstract class JobDataExport extends DataExport {
	public JobDataExport() {
		super(new String[]{
	    		"Job ID", "Release",
	    		"Deadline", "Length",
	    		"Weight", "Density"});
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
     * @throws EESAException 
     */
    public final void runMapping() throws EESAException {
        ArrayList<Object[]> data = new ArrayList<Object[]>();
        Iterator<Job> i = Simulator.getSimulator().getCurrentSimulation()
        		.getJobSet().getJobs().iterator();
        int count = 0;
        while (i.hasNext() && count < DataExport.MAPPING_ROW_LIMIT) {
            Job j = i.next();
            data.add(new Object[]{j.getID(), j.getReleaseTime(),
            		j.getDeadlineTime(), j.getLength(),
            		j.getWeight(), j.getDensity()});
            count++;            
        }
        setMappingData(data.toArray(new Object[][]{}));
    }
    /**
     * 
     * @return exported data
     */
    public final Object[][] getExportData() {
        ArrayList<Object[]> data = new ArrayList<Object[]>();
        Iterator<Job> i = Simulator.getSimulator().getCurrentSimulation().
        		getJobSet().getJobs().iterator();
        while (i.hasNext()) {
            Job j = i.next();
            data.add(new Object[]{j.getID(), j.getReleaseTime(),
            		j.getDeadlineTime(), j.getLength(),
            		j.getWeight(), j.getDensity()});
        }
        return data.toArray(new Object[][]{});
        
    }      
    /**
     * 
     * @param index The index to get choices for
     * @return The array of possible choices for the mapping
     */
    public final String[] getChoicesForIndex(final int index) {
        String[] indexChoices = getChoices().toArray(new String[getChoices().size()]);
        indexChoices[0] = getColumnByIndex(index);
        return indexChoices;
    }
}
