package eesa.db;

import java.sql.ResultSet;

/**
 * Provides an interface to support select queries.
 * @author Philip
 */
public interface SelectQuery extends SQLObject {
    /**
     * 
     * @param field field
     */
    void field(Field field);
    /**
     * 
     * @param table table
     */
    void table(DatabaseTable table);
    /**
     * 
     * @param jc join clause
     */
    void join(JoinClause jc);
    /**
     * 
     * @param wc where clause
     */
    void where(WhereClause wc);

    /**
     * 
     * @param tables tables
     */
    void setTables(DatabaseTable[] tables);

    /**
     * 
     * @param fields fields
     */
    void setFields(Field[] fields);

    /**
     * 
     * @param condition condition
     */
    void setCondition(DatabaseCondition condition);

    /**
     * 
     * @param sorts
     */
    void setSorts(DatabaseSort[] sorts);

    /**
     * 
     * @return
     * @throws DatabaseException
     */
    ResultSet execute() throws DatabaseException;
}
