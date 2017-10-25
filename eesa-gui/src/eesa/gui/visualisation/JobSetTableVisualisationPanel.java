package eesa.gui.visualisation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

import com.whiuk.philip.eesa.core.JobSet;
import eesa.gui.DataVisualisationPanel;
import eesa.gui.SimulationDataPanel;
import eesa.gui.tables.JobSetTableModel;

/**
 * Visualises a job set as a table.
 * @author Philip Whitehouse
 *
 */
public class JobSetTableVisualisationPanel extends JobSetVisualisationPanel {
	/*
	 * Model
	 */
	/**
	 * 
	 */
    private JobSetTableModel jobsetTableModel;
    /**
     * 
     */
    private ComboBoxModel<String> jobsFilterComboBoxModel;
    /**
     * 
     */
    private ComboBoxModel<String> jobsFilterOperatorsComboBoxModel;
    /*
     * ViewControllers
     */
    /**
     * 
     */
    private JScrollPane jobsetTableScrollPane;
    /**
     * 
     */
    private JTable jobsetTable;
    /**
     * 
     */
    private JLabel jobsFilterLabel;
    /**
     * 
     */
    private JTextField jobsFilterValueField;
    /**
     * 
     */
    private JComboBox<String> jobsFilterComboBox;
    /**
     * 
     */
    private JComboBox<String> jobsFilterOperatorsComboBox;
    /**
     * 
     */
    private TableRowSorter<JobSetTableModel> jobsetRowSorter;    
    /**
     * 
     */
    private String[] operators = new String[]{">=", ">", "<", "<=", "==", "!="};
    /**
     * 
     */
    public JobSetTableVisualisationPanel(SimulationDataPanel parent, JobSet js) {
    	super(parent, js);
    	jobsetTableModel = 
    			new JobSetTableModel(js);
        jobsetRowSorter = 
        		new TableRowSorter<JobSetTableModel>(jobsetTableModel);
        jobsFilterComboBoxModel =
        		new DefaultComboBoxModel<String>(jobsetTableModel.getColumns());
        jobsFilterOperatorsComboBoxModel =
        		new DefaultComboBoxModel<String>(operators);    	
    	
    	 jobsetTableScrollPane = new javax.swing.JScrollPane();
         jobsetTable = new javax.swing.JTable();
         jobsFilterLabel = new javax.swing.JLabel();
         jobsFilterComboBox = new javax.swing.JComboBox<String>();
         jobsFilterOperatorsComboBox = new javax.swing.JComboBox<String>();
         jobsFilterValueField = new javax.swing.JTextField();
         
         jobsetTable.setAutoCreateRowSorter(false);
         jobsetTable.setModel(jobsetTableModel);
         jobsetTable.setRowSorter(jobsetRowSorter);
         jobsetTableScrollPane.setViewportView(jobsetTable);

         jobsFilterLabel.setText("Filter Jobs:");
         jobsFilterComboBox.setModel(jobsFilterComboBoxModel);
         jobsFilterComboBox.addActionListener(new ActionListener() {
             public void actionPerformed(final ActionEvent evt) {
                 jobsFilterComboBoxActionPerformed(evt);
             }
         });
         jobsFilterOperatorsComboBox.setModel(jobsFilterOperatorsComboBoxModel);
         jobsFilterValueField.setText("0");         
    }
    /**
     * 
     * @param evt event
     */
    protected final void jobsFilterComboBoxActionPerformed(
    		final ActionEvent evt) {
    	changeJobsTableRowFilter();
	}
    /**
     * 
     */
	private void changeJobsTableRowFilter() {
        jobsetRowSorter.setRowFilter(
        		new RowFilter<JobSetTableModel, Integer>() {
            @Override
            public boolean include(
            		final RowFilter.Entry<? extends JobSetTableModel, 
            				? extends Integer> entry) {
                String[] columns =  jobsetTableModel.getColumns();
                Object selectedColumn = 
                		jobsFilterComboBoxModel.getSelectedItem();
                Object selectedOperator = 
                		jobsFilterOperatorsComboBoxModel.getSelectedItem();
                float comparisonVal;
                try {
                    comparisonVal = Float.parseFloat(
                    		jobsFilterValueField.getText());
                } catch (NumberFormatException ex) {
                    comparisonVal = 0;
                }
                for (int i = 0; i < columns.length; i++) {
                    if (selectedColumn.equals(columns[i])) {
                        float value = Float.parseFloat(entry.getStringValue(i));
                        if (selectedOperator.equals("==")) {
                            if (value == comparisonVal) { return true; }
                            return false;
                        } else if (selectedOperator.equals("<")) {
                            if (value < comparisonVal) { return true; }
                            return false;                            
                        } else if (selectedOperator.equals("<=")) {
                            if (value <= comparisonVal) { return true; }
                            return false;                            
                        } else if (selectedOperator.equals(">")) {
                            if (value > comparisonVal) { return true; }
                            return false;                            
                        } else if (selectedOperator.equals(">=")) {
                            if (value >= comparisonVal) { return true; }
                            return false;                            
                        } else if (selectedOperator.equals("!=")) {
                            if (value != comparisonVal) { return true; }
                            return false;                            
                        }
                        return false;
                    }
                }
                return false;
            }
        });
    }
}
