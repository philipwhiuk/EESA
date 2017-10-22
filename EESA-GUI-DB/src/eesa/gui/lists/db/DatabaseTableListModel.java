package eesa.gui.lists.db;

import eesa.gui.windows.db.DatabaseWindow;
import java.util.ArrayList;

import com.whiuk.philip.eesa.db.DatabaseTable;

/**
 * Provides an abstract list model for database tables.
 * @author Philip
 */
public class DatabaseTableListModel extends AbstractDatabaseDataListModel<DatabaseTable> {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    private static ArrayList<DatabaseTable> tables;

    /**
     * 
     * @param parent
     */
    public DatabaseTableListModel(final DatabaseWindow parent) {
        super(parent);
        tables = new ArrayList<DatabaseTable>();
    }
    
    @Override
	public final int getSize() {
        return tables.size();
    }

    @Override
	public final DatabaseTable getElementAt(final int index) {
        return tables.get(index);
    }

    /**
     * 
     * @param table
     */
    public final void addTable(final DatabaseTable table) {
        tables.add(table);
        fireIntervalAdded(this, tables.indexOf(table), tables.indexOf(table));
    }
    /**
     * 
     * @param databaseTable
     */
    public final void removeTable(final DatabaseTable databaseTable) {
        int index = tables.indexOf(databaseTable);
        tables.remove(databaseTable);
        fireIntervalRemoved(this, index, index);
    }
    /**
     * 
     * @return
     */
    public final DatabaseTable[] getTables() {
        return tables.toArray(new DatabaseTable[]{});
    }
    /**
     * 
     * @return
     */
    public final boolean hasTables() {
        return !tables.isEmpty();
    }
}
