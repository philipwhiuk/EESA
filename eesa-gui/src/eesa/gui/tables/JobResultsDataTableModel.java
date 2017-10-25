package eesa.gui.tables;

import eesa.gui.event.JobResultViewEvent;
import eesa.gui.views.JobResultsView;
import com.whiuk.philip.eesa.core.JobResult;
import eesa.gui.event.JobResultViewEventListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Provides a {@link javax.swing.table.TableModel} for showing job results.
 * @author Philip
 */
public class JobResultsDataTableModel extends TableModel implements JobResultViewEventListener {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    private final JobResultsView view;
    
    /**
     * 
     * @param v view
     */
    public JobResultsDataTableModel(final JobResultsView v) {
        this.view = v;
        view.addJobResultViewEventListener(this);
    }
    @Override
	public final String getColumnName(final int column) {
        switch(column) {
            case 0: return "Test ID";
            case 1: return "Algorithms";
            case 2: return "Processor";
            case 3: return "Job ID";
            case 4: return "Start Time";
            case 5: return "End Time";
            case 6: return "Length";
            case 7: return "Weight";
            case 8: return "Density";
            default: return null;
        }
    }

    @Override
	public final int getRowCount() {   
        return view.getNumVisibleResults();
    }
    /**
     * Returns the column count.
     * Columns:
     * 0 TestID
     * 1 Algorithms
     * 2 Processor
     * 3 Job ID
     * 4 Start Time
     * 5 End Time
     * 6 Length
     * 7 Weight
     * 8 Density
     * @return The number of columns
     */
    @Override
	public final int getColumnCount() {
        return 9;
    }

    /**
     * 
     * @param rowIndex
     * @param columnIndex
     * @return
     */
    @Override
	public final Object getValueAt(final int rowIndex, final int columnIndex) {
        JobResult result = view.getVisibleResult(rowIndex);
        switch(columnIndex) {
            case 0:
                return result.getTest().getID();
            case 1:
                return result.getTest().getAlgorithm();                
            case 2: 
                return result.getProcessor().getID();
            case 3:
                return result.getJob().getID();
            case 4: 
                return result.getJob().getReleaseTime();
            case 5:
                return result.getJob().getDeadlineTime();
            case 6:
                return result.getJob().getLength();
            case 7:
                return result.getJob().getWeight();
            case 8: 
                return result.getJob().getDensity();
            default:
            	return "";
        }
    }

    /**
     * 
     * @param event
     */
    @Override
	public final void jobResultViewStatusChanged(final JobResultViewEvent event) {
        Logger.getLogger(JobResultsDataTableModel.class.getName()).log(Level.INFO, "Job Results View Status Changed Caught");
        fireTableDataChanged();
    }
}
