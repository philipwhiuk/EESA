package eesa.gui.lists.db;

import eesa.gui.windows.db.DatabaseWindow;
import java.util.ArrayList;

import com.whiuk.philip.eesa.db.DatabaseCondition;

/**
 * Provides an abstract list model for database conditions.
 * @author Philip
 */
public class DatabaseConditionListModel extends AbstractDatabaseDataListModel<DatabaseCondition> {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    private ArrayList<DatabaseCondition> conditions;

    /**
     * 
     * @param parent
     */
    public DatabaseConditionListModel(final DatabaseWindow parent) {
        super(parent);
        conditions = new ArrayList<DatabaseCondition>();
    }
    
    @Override
	public final int getSize() {
        return conditions.size();
    }

    @Override
	public final DatabaseCondition getElementAt(final int index) {
        return conditions.get(index);
    }

    /**
     * 
     * @param condition
     */
    public final void addCondition(final DatabaseCondition condition) {
        conditions.add(condition);
        fireIntervalAdded(this, conditions.indexOf(condition),
        		conditions.indexOf(condition));
    }

    /**
     * 
     * @return
     */
    public final DatabaseCondition[] getConditions() {
        return conditions.toArray(new DatabaseCondition[]{});
    }
    
}
