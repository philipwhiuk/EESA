package eesa.gui.windows.db;

import com.whiuk.philip.eesa.db.Database;
import com.whiuk.philip.eesa.db.DatabaseCondition;
import com.whiuk.philip.eesa.db.DatabaseConnector;
import com.whiuk.philip.eesa.db.DatabaseSort;
import com.whiuk.philip.eesa.db.DatabaseTable;
import com.whiuk.philip.eesa.db.Field;
import com.whiuk.philip.eesa.db.Operator;

/**
 * Provides an interface to receive 
 * and send information on a database query.
 * @author Philip
 */
public interface DatabaseWindow {

    /**
     * 
     * @return The database to which the query is attached
     */
    Database getDatabase();
    /**
     * 
     * @return The database connector to which the query is attached
     */
    DatabaseConnector getDatabaseConnector();
    /**
     * 
     * @param table The name of the table to be added
     */
    void addTable(DatabaseTable table);
    /**
     * 
     * @return The list of tables as an array
     */
    DatabaseTable[] getTables();
    /**
     * 
     * @param f The field to be added
     */
    void addField(Field f);
    /**
     * 
     * @return The array of fields
     */
    Field[] getFields();
    /**
     * 
     * @return An array of the available operators
     */
    Operator[] getOperators();
    /**
     * 
     * @param condition Sets the conditional applied to the query
     */
    void setCondition(DatabaseCondition condition);
    /**
     * 
     * @return The conditional applied to the query
     */
    DatabaseCondition getCondition();
    /**
     * 
     * @param sort Adds a sort to the query
     */
    void addSort(DatabaseSort sort);
    /**
     * 
     * @return An array of current list of sorts
     */
    DatabaseSort[] getSorts();
}
