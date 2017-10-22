package eesa.gui.lists.db;

import eesa.gui.windows.db.DatabaseWindow;
import java.util.ArrayList;
import java.util.Collections;

import com.whiuk.philip.eesa.db.DatabaseSort;

/**
 * Provides an abstract list model for database data sorting.
 * @author Philip
 */
public class DatabaseSortListModel extends AbstractDatabaseDataListModel<DatabaseSort> {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    private ArrayList<DatabaseSort> sorts;

    /**
     * 
     * @param parent
     */
    public DatabaseSortListModel(final DatabaseWindow parent) {
        super(parent);
        sorts = new ArrayList<DatabaseSort>();
    }
    
    @Override
	public final int getSize() {
        return sorts.size();
    }

    @Override
	public final DatabaseSort getElementAt(final int index) {
        return sorts.get(index);
    }

    /**
     * 
     * @param sort
     */
    public final void addSort(final DatabaseSort sort) {
        sorts.add(sort);
        fireIntervalAdded(sort, sorts.indexOf(sort), sorts.indexOf(sort));
    }
    /**
     * 
     * @param sort
     */
    public final void removeSort(final DatabaseSort sort) {
        int index = sorts.indexOf(sort);
        sorts.remove(sort);
        fireIntervalRemoved(this, index, index);
    }
    /**
     * 
     * @return
     */
    public final DatabaseSort[] getSorts() {
        return sorts.toArray(new DatabaseSort[]{});
    }

    /**
     * 
     * @param sort
     */
    public final void moveUp(final DatabaseSort sort) {
        int index = sorts.indexOf(sort);
        if (index >= 0) {
            Collections.swap(sorts, index - 1, index);
            this.fireContentsChanged(this, index - 1, index);
        }

    }
    /**
     * 
     * @param sort
     */
    public final void moveDown(final DatabaseSort sort) {
        int index = sorts.indexOf(sort);
        if (index >= 0) {
            Collections.swap(sorts, index, index + 1);
            this.fireContentsChanged(this, index, index + 1);
        }
    }
    
}
