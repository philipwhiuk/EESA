package eesa.gui.tables;

import eesa.core.Job;
import eesa.core.JobSet;
import eesa.event.JobEvent;
import eesa.event.JobEventListener;

/**
 * Provides a {@link javax.swing.table.TableModel} for showing a JobSet.
 * @author Philip
 */
public class JobSetTableModel extends TableModel implements JobEventListener {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    private JobSet jobset; 
	/**
	 * 
	 */
    private String[] columns = new String[]{
    		"Job ID",
    		"Release Time",
    		"Deadline Time",
    		"Weight",
    		"Length",
    		"Density"};
    /**
     * 
     * @param js
     */
    public JobSetTableModel(final JobSet js) {
        jobset = js;
        js.addJobEventListener(this);
    }
    /**
     * 
     * @param rowIndex row
     * @param columnIndex column
     * @return The value at the specified row and column
     */
    @Override
	public final Object getValueAt(final int rowIndex, final int columnIndex) {
        Job j = jobset.getJob(rowIndex);
        switch(columnIndex) {
            case 0: return j.getID();
            case 1: return j.getReleaseTime();
            case 2: return j.getDeadlineTime();
            case 3: return j.getWeight();
            case 4: return j.getLength();
            case 5: return j.getDensity();
            default: return -1;
        }

    }
    /**
     * 
     * @return The number of rows
     */
    @Override
	public final int getRowCount() {
        return jobset.getSize();
    }
    /**
     * 
     * @return The number of columns
     */
    @Override
	public final int getColumnCount() {
        return 6;
    }

    /**
     * 
     * @param column The index of the column
     * @return The name of the column with the given index
     */
    @Override
	public final String getColumnName(final int column) {
        if (column >= 0 && column < columns.length) {
            return columns[column];
        }
        return null;
    }
    
    /**
     * 
     * @return
     */
    public final String[] getColumns() {
        return columns;
    }

    @Override
	public final void jobAdded(final JobEvent event) {
        System.out.println(
    		"Size:" + getRowCount()
    		+ ",First:" + event.getFirst()
    		+ ",Last:" + event.getLast()
    		+ ",Listeners:"
    		+ listenerList.getListenerCount());
        fireTableRowsInserted(event.getFirst(), event.getLast());
    }

    @Override
	public final void jobRemoved(final JobEvent event) {
        fireTableRowsDeleted(event.getFirst(), event.getLast());        
    }

    @Override
	public final void jobAltered(final JobEvent event) {
        fireTableRowsUpdated(event.getFirst(), event.getLast());
    }

    @Override
	public final void jobsAdded(final JobEvent event) {
        fireTableRowsInserted(event.getFirst(), event.getLast());
    }

    @Override
	public final void jobsRemoved(final JobEvent event) {
        fireTableRowsDeleted(event.getFirst(), event.getLast());
    }

    @Override
	public final void jobsAltered(final JobEvent event) {
        fireTableRowsUpdated(event.getFirst(), event.getLast());
    }

    @Override
	public final void jobsReplaced(final JobEvent event) {
        fireTableStructureChanged();
    }
}
