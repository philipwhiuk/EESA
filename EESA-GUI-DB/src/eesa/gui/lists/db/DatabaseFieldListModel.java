package eesa.gui.lists.db;

import eesa.gui.windows.db.DatabaseWindow;
import java.util.ArrayList;

import com.whiuk.philip.eesa.db.Field;

/**
 * Provides an list model for database fields.
 * @author Philip
 */
public class DatabaseFieldListModel 
	extends AbstractDatabaseDataListModel<Field> {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    private ArrayList<Field> fields; 

    /**
     * 
     * @param parent
     */
    public DatabaseFieldListModel(final DatabaseWindow parent) {
        super(parent);
        fields = new ArrayList<Field>();
    }
    
    @Override
	public final int getSize() {
        return fields.size();
    }

    @Override
	public final Field getElementAt(final int index) {
        return fields.get(index);
    }

    /**
     * 
     * @param field
     */
    public final void addField(final Field field) {
        fields.add(field);
        fireIntervalAdded(this, fields.indexOf(field), fields.indexOf(field));
    }

    /**
     * 
     * @return
     */
    public final Field[] getFields() {
        return fields.toArray(new Field[]{});
    }
    /**
     * 
     * @return
     */
    public final boolean hasFields() {
        return !fields.isEmpty();
    }
    /**
     * 
     * @param field
     */
    public final void removeField(final Field field) {
        int index = fields.indexOf(field);
        fields.remove(field);
        fireIntervalRemoved(this, index, index);
    }
}
