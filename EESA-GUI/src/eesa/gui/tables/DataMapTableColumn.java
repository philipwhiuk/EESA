package eesa.gui.tables;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

/**
 * Provides implementation of 
 * {@link javax.swing.table.TableColumn} for data mapping tables.
 * @author Philip
 */
class DataMapTableColumn extends TableColumn {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    private TableCellEditor headerEditor;
    /**
     * 
     */
    private boolean isHeaderEditable;
    /**
     * 
     * @param combo
     * @param renderer
     */
    public DataMapTableColumn(final JComboBox<String> combo, final DataMapTableHeaderComboCellRenderer renderer) {
        setHeaderEditor(createDefaultHeaderEditor());
        isHeaderEditable = true;
        setHeaderValue(combo.getItemAt(0));
        setHeaderRenderer(renderer);
        setHeaderEditor(new DefaultCellEditor(combo));
    }
    /**
     * 
     * @param h headerEditor
     */
    public void setHeaderEditor(final TableCellEditor h) {
        this.headerEditor = h;
    }
    /**
     * 
     * @return
     */
    protected TableCellEditor createDefaultHeaderEditor() {
        return new DefaultCellEditor(new JTextField());
    }
    /**
     * 
     * @return
     */
    public boolean isHeaderEditable() {
        return isHeaderEditable;
    }
    /**
     * 
     * @param isEditable
     */
    public void setHeaderEditable(final boolean isEditable) {
        isHeaderEditable = isEditable;
    }
    /**
     * 
     * @param base
     */
    public void copyValues(final TableColumn base) {
        modelIndex = base.getModelIndex();
        identifier = base.getIdentifier();
        width = base.getWidth();
        minWidth = base.getMinWidth();
        setPreferredWidth(base.getPreferredWidth());
        maxWidth = base.getMaxWidth();
        headerRenderer = base.getHeaderRenderer();
        headerValue = base.getHeaderValue();
        cellRenderer = base.getCellRenderer();
        cellEditor = base.getCellEditor();
        isResizable = base.getResizable();
    }

    /**
     * 
     * @return
     */
    TableCellEditor getHeaderEditor() {
        return headerEditor;
    }
}
