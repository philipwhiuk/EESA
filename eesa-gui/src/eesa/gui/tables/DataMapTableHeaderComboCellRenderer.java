package eesa.gui.tables;

import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 * Provides implementation of a 
 * {@link javax.swing.table.TableCellRenderer} for data mapping tables.
 * @author Philip
 */
public class DataMapTableHeaderComboCellRenderer extends JComboBox<String>
	implements TableCellRenderer {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     * @param items
     */
    public DataMapTableHeaderComboCellRenderer(final String[] items) {
      for (int i = 0; i < items.length; i++) {
        addItem(items[i]);
      }
    }
    @Override
	public final Component getTableCellRendererComponent(final JTable table,
        final Object value, final boolean isSelected, final boolean hasFocus, final int row,
        final int column) {
      setSelectedItem(value);
      return this;
    }    
}
