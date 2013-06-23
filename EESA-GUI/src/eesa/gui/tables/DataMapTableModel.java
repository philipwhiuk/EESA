package eesa.gui.tables;

/**
 * Provides implementation of the 
 * {@link javax.swing.table.TableModel} for data mapping tables.
 * @author Philip
 */
public class DataMapTableModel extends javax.swing.table.AbstractTableModel {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    private final Object[][] data;
    /**
     * 
     */
    private String[] columns;
    /**
     * 
     * @param d data
     * @param c columns
     */
    public DataMapTableModel(final Object[][] d,
    		final String[] c) {
        super();
        this.data = d;
        this.columns = c;
    }
    
    @Override
	public final int getRowCount() {
        return data.length;
    }

    @Override
	public final int getColumnCount() {
        if (data.length > 0) {
        return data[0].length;
        }
        return 0;
    }

    @Override
	public final Object getValueAt(final int row, final int col) {
        return data[row][col];
        
    }
    @Override
	public final String getColumnName(final int col) {
        return columns[col];
    }
}
