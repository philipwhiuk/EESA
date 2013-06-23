package eesa.gui.lists.db;

import eesa.db.Database;
import eesa.gui.windows.db.DatabaseWindow;
import javax.swing.AbstractListModel;

/**
 * Provides an abstract list model for databases.
 * @author Philip
 * @param <T> List model type
 */
public abstract class AbstractDatabaseDataListModel<T> 
	extends AbstractListModel<T> {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    /**
     * 
     */
    private final DatabaseWindow parent;
    /**
     * 
     */
    private final Database database;
    /**
     * 
     * @param p parent
     */
    AbstractDatabaseDataListModel(final DatabaseWindow p) {
        this.parent = p;
        this.database = parent.getDatabase();
    }
	/**
	 * @return the parent
	 */
	public final DatabaseWindow getParent() {
		return parent;
	}
	/**
	 * @return the database
	 */
	public final Database getDatabase() {
		return database;
	} 
}
