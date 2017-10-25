package eesa.gui.tables;

import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 * Provides implementation of 
 * {@link javax.swing.table.JTableHeader} for data mapping tables.
 * @author Philip
 */
public class DataMapTableHeader extends JTableHeader implements CellEditorListener {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    private transient TableCellEditor cellEditor;
    /**
     * 
     */
    private transient int editingColumn;
    /**
     * 
     */
    private transient Component editorComp;
    /**
     * 
     */
    private JComboBox<String>[] comboBoxes;
    /**
     * 
     */
    private DataMapTableHeaderComboCellRenderer[] renderers;
    /**
     * 
     */
    public static final int HEADER_ROW = -10;

    /**
     * 
     * @param columnModel
     * @param b comboBoxes
     * @param r renderers
     */
    public DataMapTableHeader(
    		final TableColumnModel columnModel,
    		final JComboBox<String>[] b,
    		final DataMapTableHeaderComboCellRenderer[] r) {
        super(columnModel);
        setReorderingAllowed(false);
        cellEditor = null;        
        this.comboBoxes = b;
        this.renderers = r;        
        recreateTableColumn(columnModel);
    }
    /**
     * 
     */
    public final void updateUI() {
        setUI(new DataMapTableHeaderUI());
        resizeAndRepaint();
        invalidate();
      }    
    /**
     * 
     * @param columnModel
     */
    protected final void recreateTableColumn(
    		final TableColumnModel columnModel) {
        int n = columnModel.getColumnCount();
        DataMapTableColumn[] newCols = new DataMapTableColumn[n];
        TableColumn[] oldCols = new TableColumn[n];
        for (int i = 0; i < n; i++) {
            oldCols[i] = columnModel.getColumn(i);
            newCols[i] = new DataMapTableColumn(comboBoxes[i], renderers[i]);
            newCols[i].copyValues(oldCols[i]);
        }
        for (int i = 0; i < n; i++) {
            columnModel.removeColumn(oldCols[i]);
        }
        for (int i = 0; i < n; i++) {
            columnModel.addColumn(newCols[i]);
        }
    }
    /**
     * 
     * @param newEditor
     */
    public final void setCellEditor(final TableCellEditor newEditor) {
        TableCellEditor oldEditor = cellEditor;
        cellEditor = newEditor;
        // firePropertyChange
        if (oldEditor != null && oldEditor instanceof TableCellEditor) {
            ((TableCellEditor) oldEditor).removeCellEditorListener((CellEditorListener) this);
        }
        if (newEditor != null && newEditor instanceof TableCellEditor) {
            ((TableCellEditor) newEditor).addCellEditorListener((CellEditorListener) this);
        }
    }
    /**
     * 
     * @param e Event
     */
    @Override
	public final void editingStopped(final ChangeEvent e) {
        TableCellEditor editor = getCellEditor();
        if (editor != null) {
          Object value = editor.getCellEditorValue();
          int index = getEditingColumn();
          columnModel.getColumn(index).setHeaderValue(value);
          removeEditor();
        }
    }
    /**
     * 
     * @return
     */
    public final int getEditingColumn() {
        return editingColumn;
    }
    @Override
	public final void editingCanceled(final ChangeEvent e) {
        removeEditor();
    }
    /**
     * 
     * @return
     */
    public final TableCellEditor getCellEditor() {
        return cellEditor;
    }
    /**
     * 
     */
    public final void removeEditor() {
        TableCellEditor editor = getCellEditor();
        if (editor != null) {
            editor.removeCellEditorListener(this);
            requestFocus();
            remove(editorComp);
            int index = getEditingColumn();
            Rectangle cellRect = getHeaderRect(index);
            setCellEditor(null);
            setEditingColumn(-1);
            editorComp = null;
            repaint(cellRect);
        }
    }
    /**
     * 
     * @param aColumn
     */
    public final void setEditingColumn(final int aColumn) {
        editingColumn = aColumn;
    }

    /**
     * 
     * @param index
     * @param e
     * @return
     */
    final boolean editCellAt(final int index, final MouseEvent e) {
        if (cellEditor != null && !cellEditor.stopCellEditing()) {
            return false;
        }
        if (!isCellEditable(index)) {
            return false;
        }
            TableCellEditor editor = getCellEditor(index);

        if (editor != null && editor.isCellEditable(e)) {
        editorComp = prepareEditor(editor, index);
        editorComp.setBounds(getHeaderRect(index));
        add(editorComp);
        editorComp.validate();
        setCellEditor(editor);
        setEditingColumn(index);
        editor.addCellEditorListener(this);

        return true;
        }
        return false;
    }

    /**
     * 
     * @return
     */
    final Component getEditorComponent() {
        return editorComp;
    }

    /**
     * 
     * @param index
     * @return
     */
    private boolean isCellEditable(final int index) {
        if (getReorderingAllowed()) {
            return false;
        }
        int columnIndex = columnModel.getColumn(index).getModelIndex();
        DataMapTableColumn col = (DataMapTableColumn) columnModel.getColumn(columnIndex);
        return col.isHeaderEditable();
    }

    /**
     * 
     * @param index
     * @return
     */
    private TableCellEditor getCellEditor(final int index) {
        int columnIndex = columnModel.getColumn(index).getModelIndex();
        DataMapTableColumn col = (DataMapTableColumn) columnModel.getColumn(columnIndex);
        return col.getHeaderEditor();
    }

    /**
     * 
     * @param editor
     * @param index
     * @return
     */
    @SuppressWarnings("deprecation")
    private Component prepareEditor(final TableCellEditor editor, final int index) {
        Object value = columnModel.getColumn(index).getHeaderValue();
        boolean isSelected = true;
        int row = HEADER_ROW;
        JTable t = getTable();
        Component comp = editor.getTableCellEditorComponent(t, value,
            isSelected, row, index);
        if (comp instanceof JComponent) {
          ((JComponent) comp).setNextFocusableComponent(this);
        }
        return comp;
    }
}
