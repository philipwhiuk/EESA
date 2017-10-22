package eesa.gui.tables;

import eesa.gui.event.TimePeriodViewEvent;
import eesa.gui.views.TimePeriodsView;
import com.whiuk.philip.eesa.core.ProcessorSpeedTimePeriod;
import eesa.gui.event.TimePeriodViewEventListener;

/**
 * Provides a {@link javax.swing.table.TableModel} for showing time periods.
 * Columns:
 * 0 TestID
 * 1 Processor
 * 2 Start Time
 * 3 End Time
 * 4 Jobs
 * 5 Speed
 * 6 Power
 * 7 Energy
 * @author Philip
 */
public class TimePeriodsDataTableModel extends TableModel
	implements TimePeriodViewEventListener {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    private TimePeriodsView view;
    /**
     * 
     * @param v view
     */
    public TimePeriodsDataTableModel(final TimePeriodsView v) {
        this.view = v;
        view.addTimePeriodViewEventListener(this);
    } 
    @Override
	public final int getRowCount() {
        return view.getNumVisibleResults();
    }
    /**
     * 
     * @param column The index of the column
     * @return The name of the column with the given index
     */
    @Override
	public final String getColumnName(final int column) {   
        switch(column) {
            case 0: return "Test ID";
            case 1: return "Processor";
            case 2: return "Start Time";
            case 3: return "End Time";
            case 4: return "Length";
            case 5: return "Speed";
            case 6: return "Power";
            case 7: return "Energy";
            case 8: return "Period ID";
            default: return null;
         }
    }
    /**
     * @return The number of columns
     */
    @Override
	public final int getColumnCount() {
        return 9;
    }

    @Override
	public final Object getValueAt(final int rowIndex, final int columnIndex) {
        ProcessorSpeedTimePeriod period = view.getVisibleResult(rowIndex);
        switch(columnIndex) {
            case 0:
                return period.getTest().getID();
            case 1: 
                return period.getProcessor().getID();
            case 2: 
                return period.getStartTime();
            case 3:
                return period.getEndTime();
            case 4:
                return period.getLength();
            case 5:
                return period.getSpeed();
            case 6:
                return period.getPower();
            case 7: 
                return period.getEnergy();
            case 8:
                return period.getID();
            default: return "";
        }
    }

    /**
     * 
     * @param event
     */
    @Override
	public final void timePeriodViewStatusChanged(final TimePeriodViewEvent event) {
//        Logger.getLogger(TimePeriodsDataTableModel.class.getName()).log(Level.INFO, "Periods View Status Changed Caught");
        fireTableDataChanged();
    }
    
}
