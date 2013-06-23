package eesa.dataExport;

import java.util.List;

/**
 * 
 * @author Philip Whitehouse
 *
 */
public abstract class DataExport {
	/**
	 * Maximum number of rows to show for mapping data.
	 */
	protected static final int MAPPING_ROW_LIMIT = 10;
    /**
     * 
     */
    private Object[][] exportData;
    /**
     * 
     */
    private Object[][] mappingData;
    /**
     * 
     */
    private boolean[] parameters;
    /**
     * 
     */
    private int[] columnKeys;
    /**
     * 
     */
    private String[] columns;
    /**
     * 
     */
    private List<String> choices;
    /**
     * 
     * @param c
     */
    public DataExport(String[] c) {
    	columns = c;
    }
    /**
     * 
     * @param i
     * @return column
     */
    public final String getColumnByIndex(int i) {
    	return columns[i];
    }
    public final int getNumColumns() {
    	return columns.length;
    }
	/**
	 * @return the mappingData
	 */
	public final Object[][] getMappingData() {
		return mappingData;
	}
	/**
	 * @param mappingData the mappingData to set
	 */
	public final void setMappingData(Object[][] mappingData) {
		this.mappingData = mappingData;
	}
	/**
	 * @return the choices
	 */
	public final List<String> getChoices() {
		return choices;
	}
	/**
	 * @param choices the choices to set
	 */
	public final void setChoices(List<String> choices) {
		this.choices = choices;
	}
	/**
	 * @return the columnKeys
	 */
	public final int[] getColumnKeys() {
		return columnKeys;
	}
	/**
	 * @param columnKeys the columnKeys to set
	 */
	public final void setColumnKeys(int[] columnKeys) {
		this.columnKeys = columnKeys;
	}
	/**
	 * @return the columnKeys
	 */
	public final String[] getColumns() {
		return columns;
	}
	/**
	 * @param columnKeys the columnKeys to set
	 */
	public final void setColumns(String[] columns) {
		this.columns = columns;
	}
	/**
	 * @return the parameters
	 */
	public final boolean[] getParameters() {
		return parameters;
	}
	/**
	 * @param parameters the parameters to set
	 */
	public final void setParameters(boolean[] parameters) {
		this.parameters = parameters;
	}
}
