package eesa.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.whiuk.philip.eesa.core.Job;
import com.whiuk.philip.eesa.core.Test;
import eesa.gui.tables.TestTableModel;
import eesa.gui.tables.JobSetTableModel;
import eesa.gui.windows.AddTestWindow;
import eesa.gui.windows.JobGenerationWindow;
import com.whiuk.philip.eesa.core.Simulation;
import eesa.gui.help.HelpManager;
import eesa.gui.windows.dataExport.jobs.ExportJobsWindow;
import eesa.gui.windows.dataImport.jobs.ImportJobsWindow;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;

/**
 * The central panel for adjusting {@link eesa.core.Simulation} data.
 * Created on 15-Nov-2011, 16:03:32
 * @author Philip
 * @
 */
public class SimulationDataPanel extends javax.swing.JPanel {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    private TableRowSorter<JobSetTableModel> jobsetRowSorter;
    /**
     * 
     */
    private JobSetTableModel jobsetTableModel;
    /**
     * 
     */
    private TestTableModel testTableModel;
    /**
     * 
     */
    private TableRowSorter<TestTableModel> testRowSorter;
    /**
     * 
     */
    private ComboBoxModel<String> jobsFilterComboBoxModel;
    /**
     * 
     */
    private ComboBoxModel<String> jobsFilterOperatorsComboBoxModel;
    /**
     * 
     */
    private String[] operators = new String[]{">=", ">", "<", "<=", "==", "!="};
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
    /**
     * The list of tabs in the panel.
     */
    public static enum Tab {
        /**
         * Jobs tab.
         */
        JOBS,
        /**
         * Tests tab.
         */
        TESTS,
        /**
         * N/A.
         */
        UNKNOWN
    };
    /**
     * 
     */
    private final Simulation simulation;
    /**
     * 
     */
    private final Application app;
    /**
     * Creates new form SimulationDataPanel.
     * @param a The application framework in which the panel is loaded.
     * @param s The simulation which backs the data panel
     */
    public SimulationDataPanel(final Application a, final Simulation s) {
        app = a;
        simulation = s;
        jobsetTableModel = new JobSetTableModel(simulation.getJobSet());
        jobsetRowSorter = 
        		new TableRowSorter<JobSetTableModel>(jobsetTableModel);
        jobsFilterComboBoxModel =
        		new DefaultComboBoxModel<String>(jobsetTableModel.getColumns());
        jobsFilterOperatorsComboBoxModel =
        		new DefaultComboBoxModel<String>(operators);
        testTableModel = new TestTableModel(simulation.getTestList());
        testRowSorter = new TableRowSorter<TestTableModel>(testTableModel);
        initComponents();
        HelpManager.addHelpForClassToButton(helpButton,
        		SimulationDataPanel.class);
        processorCountField.getDocument().addDocumentListener(
        		new DocumentListener() {
            @Override
            public void insertUpdate(final DocumentEvent e) {
                processorCountChanged();
            }

            @Override
            public void removeUpdate(final DocumentEvent e) {
                processorCountChanged();
            }

            @Override
            public void changedUpdate(final DocumentEvent e) {
                processorCountChanged();
            }            
        });
        processorPowerFactor.getDocument().addDocumentListener(
        		new DocumentListener() {
            @Override
            public void insertUpdate(final DocumentEvent e) {
                processorPowerFactorChanged();
            }

            @Override
            public void removeUpdate(final DocumentEvent e) {
                processorPowerFactorChanged();
            }

            @Override
            public void changedUpdate(final DocumentEvent e) {
                processorPowerFactorChanged();
            }                        
        });        
        jobsFilterValueField.getDocument().addDocumentListener(
        		new DocumentListener() {
            @Override
            public void insertUpdate(final DocumentEvent e) {
                changeJobsTableRowFilter();
            }
            @Override
            public void removeUpdate(final DocumentEvent e) {
                changeJobsTableRowFilter();
            }
            @Override
            public void changedUpdate(final DocumentEvent e) {
                changeJobsTableRowFilter();
            }           
        });
        changeJobsTableRowFilter();
    }

    /** This method is called from within the constructor to
     * initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {
    	createFields();
        processorCountLabel.setText("Number of Processors");
        processorCountField.setText("" + simulation.getProcessors().length);
        processorCountField.setMinimumSize(new java.awt.Dimension(50, 20));
        processorCountField.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                processorCountFieldActionPerformed(evt);
            }
        });
        processorPowerFactorLabel.setText("Processor Power Factor");
        processorPowerFactor.setText("" + simulation.getPowerFactor());
        processorPowerFactor.setMinimumSize(new java.awt.Dimension(50, 20));
        jobsetTable.setAutoCreateRowSorter(false);
        jobsetTable.setModel(jobsetTableModel);
        jobsetTable.setRowSorter(jobsetRowSorter);
        jobsetTableScrollPane.setViewportView(jobsetTable);
        addJobButton.setText("Add Job");
        addJobButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                addJobButtonActionPerformed(evt);
            }
        });
        deleteJobButton.setText("Delete Job");
        deleteJobButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                deleteJobButtonActionPerformed(evt);
            }
        });
        generateJobsButton.setText("Generate Jobs");
        generateJobsButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                generateJobsButtonActionPerformed(evt);
            }
        });
        importJobsButton.setText("Import Jobs");
        importJobsButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                importJobsButtonActionPerformed(evt);
            }
        });
        exportJobsButton.setText("Export Jobs");
        exportJobsButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                exportJobsButtonActionPerformed(evt);
            }
        });
        jobsFilterLabel.setText("Filter Jobs:");
        jobsFilterComboBox.setModel(jobsFilterComboBoxModel);
        jobsFilterComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                jobsFilterComboBoxActionPerformed(evt);
            }
        });
        jobsFilterOperatorsComboBox.setModel(jobsFilterOperatorsComboBoxModel);
        jobsFilterValueField.setText("0");
        buildJobSetPanel();
        tabPane.addTab("Jobs", jobsetPanel);
        testTable.setModel(testTableModel);
        testTable.setRowSorter(testRowSorter);
        testTableScrollPane.setViewportView(testTable);
        addTestButton.setText("Add Test");
        addTestButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                addTestButtonActionPerformed(evt);
            }
        });
        runTestsButton.setText("Run Tests");
        runTestsButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                runTestsButtonActionPerformed(evt);
            }
        });
        deleteTestButton.setText("Delete Test");
        deleteTestButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                deleteTestButtonActionPerformed(evt);
            }
        });
        buildTestsPanelLayout();


        tabPane.addTab("Tests", testsPanel);

        helpButton.setText("Help");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(
                		GroupLayout.Alignment.LEADING)
                    .addComponent(tabPane)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(
                        		GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(
                            		GroupLayout.Alignment.TRAILING, false)
                                .addGroup(GroupLayout.Alignment.LEADING, 
                                		layout.createSequentialGroup()
                                    .addComponent(processorCountLabel)
                                    .addGap(18, 18, 18)
                                    .addComponent(processorCountField,
                                    		GroupLayout.DEFAULT_SIZE,
                                    		GroupLayout.DEFAULT_SIZE,
                                    		Short.MAX_VALUE))
                                .addGroup(GroupLayout.Alignment.LEADING,
                                		layout.createSequentialGroup()
                                    .addComponent(processorPowerFactorLabel)
                                    .addPreferredGap(LayoutStyle
                                    		.ComponentPlacement.UNRELATED)
                                    .addComponent(processorPowerFactor, 0, 1,
                                    		Short.MAX_VALUE)))
                            .addComponent(helpButton))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(
                		GroupLayout.Alignment.BASELINE)
                    .addComponent(processorCountLabel)
                    .addComponent(processorCountField,
                    		GroupLayout.PREFERRED_SIZE,
                    		GroupLayout.DEFAULT_SIZE,
                    		GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(
                		GroupLayout.Alignment.BASELINE)
                    .addComponent(processorPowerFactorLabel)
                    .addComponent(processorPowerFactor,
                    		GroupLayout.PREFERRED_SIZE,
                    		GroupLayout.DEFAULT_SIZE,
                    		GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(tabPane, GroupLayout.DEFAULT_SIZE,
                		318, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(helpButton)
                .addContainerGap())
        );
    }
    /**
     * 
     */
    private void buildTestsPanelLayout() {
        GroupLayout testsPanelLayout = new GroupLayout(testsPanel);
        testsPanel.setLayout(testsPanelLayout);
        testsPanelLayout.setHorizontalGroup(
            testsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(testsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(testsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(testTableScrollPane, GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                    .addGroup(testsPanelLayout.createSequentialGroup()
                        .addComponent(addTestButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteTestButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 231, Short.MAX_VALUE)
                        .addComponent(runTestsButton)))
                .addContainerGap())
        );
        testsPanelLayout.setVerticalGroup(
            testsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, testsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(testTableScrollPane, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(testsPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(addTestButton)
                    .addComponent(runTestsButton)
                    .addComponent(deleteTestButton))
                .addContainerGap())
        );
	}

	/**
     * 
     */
    private void buildJobSetPanel() {
        GroupLayout jobsetPanelLayout = new GroupLayout(jobsetPanel);
        jobsetPanel.setLayout(jobsetPanelLayout);
        jobsetPanelLayout.setHorizontalGroup(
            jobsetPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jobsetPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jobsetPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jobsetTableScrollPane, GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                    .addGroup(jobsetPanelLayout.createSequentialGroup()
                        .addGroup(jobsetPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jobsetPanelLayout.createSequentialGroup()
                                .addComponent(addJobButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteJobButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(generateJobsButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(importJobsButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(exportJobsButton))
                            .addGroup(jobsetPanelLayout.createSequentialGroup()
                                .addComponent(jobsFilterLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jobsFilterComboBox, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jobsFilterOperatorsComboBox, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jobsFilterValueField, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jobsetPanelLayout.setVerticalGroup(
            jobsetPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jobsetPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jobsetPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jobsFilterLabel)
                    .addComponent(jobsFilterComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jobsFilterOperatorsComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jobsFilterValueField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jobsetTableScrollPane, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jobsetPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(addJobButton)
                    .addComponent(deleteJobButton)
                    .addComponent(generateJobsButton)
                    .addComponent(importJobsButton)
                    .addComponent(exportJobsButton))
                .addContainerGap())
        );
	}

	/**
     * 
     */
    private void createFields() {
        processorCountLabel = new javax.swing.JLabel();
        processorCountField = new javax.swing.JTextField();
        processorPowerFactorLabel = new javax.swing.JLabel();
        processorPowerFactor = new javax.swing.JTextField();
        tabPane = new javax.swing.JTabbedPane();
        jobsetPanel = new javax.swing.JPanel();
        jobsetTableScrollPane = new javax.swing.JScrollPane();
        jobsetTable = new javax.swing.JTable();
        addJobButton = new javax.swing.JButton();
        deleteJobButton = new javax.swing.JButton();
        generateJobsButton = new javax.swing.JButton();
        importJobsButton = new javax.swing.JButton();
        exportJobsButton = new javax.swing.JButton();
        jobsFilterLabel = new javax.swing.JLabel();
        jobsFilterComboBox = new javax.swing.JComboBox<String>();
        jobsFilterOperatorsComboBox = new javax.swing.JComboBox<String>();
        jobsFilterValueField = new javax.swing.JTextField();
        testsPanel = new javax.swing.JPanel();
        testTableScrollPane = new javax.swing.JScrollPane();
        testTable = new javax.swing.JTable();
        addTestButton = new javax.swing.JButton();
        runTestsButton = new javax.swing.JButton();
        deleteTestButton = new javax.swing.JButton();
        helpButton = new javax.swing.JButton();
	}

	/**
     * 
     */
    private void processorCountChanged() {
        try {
            simulation.changeProcessorCount(Integer.parseInt(processorCountField.getText()));
        } catch (NumberFormatException e) {
            simulation.changeProcessorCount(0);
        }
    }
    /**
     * 
     */
    private void processorPowerFactorChanged() {
        try {
            simulation.changePowerFactor(Float.parseFloat(processorPowerFactor.getText()));                    
        } catch (NumberFormatException ex) {
            simulation.changePowerFactor(0);
        }            
    }
    /**
     * 
     * @param evt 
     */
    private void processorCountFieldActionPerformed(final ActionEvent evt) {
    }
    /**
     * 
     * @param evt 
     */
    private void runTestsButtonActionPerformed(final ActionEvent evt) {
        app.runTests();
    }
    /**
     * 
     * @param evt 
     */
    private void addTestButtonActionPerformed(final ActionEvent evt) {
        AddTestWindow addtest = new AddTestWindow(app, simulation);
        addtest.setVisible(true);
    }
    /**
     * 
     * @param evt 
     */
    private void addJobButtonActionPerformed(final ActionEvent evt) {
        app.addJob();
    }
    /**
     * 
     * @param evt 
     */
    private void deleteTestButtonActionPerformed(final ActionEvent evt) {
        simulation.removeTest(testTable.getSelectedRow());
    }
    /**
     * 
     * @param evt 
     */
    private void deleteJobButtonActionPerformed(final ActionEvent evt) {
        simulation.getJobSet().removeJob(jobsetTable.getSelectedRow());
    }
    /**
     * 
     * @param evt 
     */
    private void generateJobsButtonActionPerformed(final ActionEvent evt) {
        new JobGenerationWindow(simulation).setVisible(true);
    }
    /**
     * 
     * @param evt 
     */
    private void importJobsButtonActionPerformed(final ActionEvent evt) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ImportJobsWindow().setVisible(true);
            }
        });
    }
    /**
     * 
     * @param evt 
     */
    private void exportJobsButtonActionPerformed(final ActionEvent evt) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ExportJobsWindow().setVisible(true);
            }
        });
    }
    /**
     * 
     * @param evt
     */
    private void jobsFilterComboBoxActionPerformed(final ActionEvent evt) {
        changeJobsTableRowFilter();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
     * 
     */
    private javax.swing.JButton addJobButton;
    /**
     * 
     */
    private javax.swing.JButton addTestButton;
    /**
     * 
     */
    private javax.swing.JButton deleteJobButton;
    /**
     * 
     */
    private javax.swing.JButton deleteTestButton;
    /**
     * 
     */
    private javax.swing.JButton exportJobsButton;
    /**
     * 
     */
    private javax.swing.JButton generateJobsButton;
    /**
     * 
     */
    private javax.swing.JButton helpButton;
    /**
     * 
     */
    private javax.swing.JButton importJobsButton;
    /**
     * 
     */
    private javax.swing.JComboBox<String> jobsFilterComboBox;
    /**
     * 
     */
    private javax.swing.JLabel jobsFilterLabel;
    /**
     * 
     */
    private javax.swing.JComboBox<String> jobsFilterOperatorsComboBox;
    /**
     * 
     */
    private javax.swing.JTextField jobsFilterValueField;
    /**
     * 
     */
    private javax.swing.JPanel jobsetPanel;
    /**
     * 
     */
    private javax.swing.JTable jobsetTable;
    /**
     * 
     */
    private javax.swing.JScrollPane jobsetTableScrollPane;
    /**
     * 
     */
    private javax.swing.JTextField processorCountField;
    /**
     * 
     */
    private javax.swing.JLabel processorCountLabel;
    /**
     * 
     */
    private javax.swing.JTextField processorPowerFactor;
    /**
     * 
     */
    private javax.swing.JLabel processorPowerFactorLabel;
    /**
     * 
     */
    private javax.swing.JButton runTestsButton;
    /**
     * 
     */
    private javax.swing.JTabbedPane tabPane;
    /**
     * 
     */
    private javax.swing.JTable testTable;
    /**
     * 
     */
    private javax.swing.JScrollPane testTableScrollPane;
    /**
     * 
     */
    private javax.swing.JPanel testsPanel;
    // End of variables declaration//GEN-END:variables

    /**
     * 
     * @return
     */
    final Job getSelectedJob() {
        try {
            return simulation.getJobSet().getJob(jobsetTable.getSelectedRow());
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }
    /**
     * 
     * @return
     */
    final Tab getSelectedTab() {
        if (tabPane.getSelectedComponent().equals(jobsetPanel)) {
            return Tab.JOBS;
        } else if (tabPane.getSelectedComponent().equals(testsPanel)) {
            return Tab.TESTS;
        } else {
            return Tab.UNKNOWN;
        }
    }
    /**
     * 
     * @return
     */
    final Test getSelectedTest() {
        try {
            return simulation.getTestList().getTest(testTable.getSelectedRow());
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }    
}
