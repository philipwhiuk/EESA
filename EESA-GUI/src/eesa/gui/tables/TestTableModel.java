package eesa.gui.tables;

import com.whiuk.philip.eesa.algorithms.AssignmentAndScalingAlgorithm;
import com.whiuk.philip.eesa.core.TestList;
import com.whiuk.philip.eesa.event.TestEvent;
import com.whiuk.philip.eesa.event.TestEventListener;

/**
 * Provides a {@link javax.swing.table.TableModel} for showing tests.
 * @author Philip
 */
public class TestTableModel extends TableModel implements TestEventListener {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    private TestList tests;
    /**
     * 
     */
    private String[] columns = new String[]{
    		"Algorithm",
    		"Parameters"};
    /**
     * 
     * @param tl 
     */
    public TestTableModel(final TestList tl) {
        tests = tl;
        tests.addTestEventListener(this);
    }
    /**
     * 
     * @return The number of rows
     */
    @Override
	public final int getRowCount() {
        return tests.numberOfTests();
    }
    /**
     * 
     * @return The number of columns
     */
    @Override
	public final int getColumnCount() {
        return 2;
    }
    /**
     * 
     * @param rowIndex
     * @param columnIndex
     * @return The value at the given row and column
     */
    @Override
	public final Object getValueAt(final int rowIndex, final int columnIndex) {
        switch(columnIndex) {
            case 0: return tests.getTest(rowIndex).getAlgorithm().toString();
            case 1: return tests.getTest(rowIndex).getAlgorithm().getParameters();
            default:         return null;
        }
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
	public final void testAdded(final TestEvent event) {
        fireTableRowsInserted(event.getFirst(), event.getLast());
        System.out.println("" + event.getFirst() + "" + event.getLast());
    }

    @Override
	public final void testRemoved(final TestEvent event) {
        fireTableRowsDeleted(event.getFirst(), event.getLast());
    }

    @Override
	public final void testAltered(final TestEvent event) {
        fireTableRowsUpdated(event.getFirst(), event.getLast());
    }

    @Override
	public final void testsAdded(final TestEvent event) {
        fireTableRowsInserted(event.getFirst(), event.getLast());
    }

    @Override
	public final void testsRemoved(final TestEvent event) {
        fireTableRowsDeleted(event.getFirst(), event.getLast());
    }

    @Override
	public final void testsAltered(final TestEvent event) {
        fireTableRowsUpdated(event.getFirst(), event.getLast());
    }
}