
/*
 * SQLRetrievalImportJobsWindow.java
 *
 * Created on 27-Mar-2012, 01:55:16
 */

package eesa.gui.windows.db.dataImport.jobs;

import eesa.db.Database;
import eesa.db.DatabaseCondition;
import eesa.db.DatabaseConnector;
import eesa.db.DatabaseException;
import eesa.db.DatabaseSort;
import eesa.db.DatabaseTable;
import eesa.db.Field;
import eesa.db.Operator;
import eesa.db.SelectQuery;
import eesa.db.dataImport.SQLJobDataImport;
import eesa.exceptions.EESAException;
import eesa.gui.help.HelpManager;
import eesa.gui.lists.db.DatabaseTableListModel;
import eesa.gui.lists.db.DatabaseFieldListModel;
import eesa.gui.lists.db.DatabaseSortListModel;
import eesa.gui.windows.AbstractProcessWindow;
import eesa.gui.windows.db.AddDatabaseConditionWindow;
import eesa.gui.windows.db.AddDatabaseFieldWindow;
import eesa.gui.windows.db.AddDatabaseSortWindow;
import eesa.gui.windows.db.AddDatabaseTableWindow;
import eesa.gui.windows.db.DatabaseWindow;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 * Allows the user to customize the retrieval query.
 * @author Philip
 */
public class SQLRetrievalImportJobsWindow extends AbstractProcessWindow implements DatabaseWindow {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    private final SQLJobDataImport data;
    /**
     * 
     */
    private DatabaseTableListModel databaseTableListModel;
    /**
     * 
     */
    private DatabaseFieldListModel databaseFieldListModel;
    /**
     * 
     */
    private DatabaseSortListModel databaseSortListModel;
    /**
     * 
     */
    private DatabaseCondition condition;

    /** Creates new form SQLRetrievalImportJobsWindow.
     * @param data 
     */
    public SQLRetrievalImportJobsWindow(final SQLJobDataImport data) {
        this.data = data;
        databaseTableListModel = new DatabaseTableListModel(this);
        databaseFieldListModel = new DatabaseFieldListModel(this);
        databaseSortListModel = new DatabaseSortListModel(this);        
        initComponents();
        HelpManager.addHelpForClassToButton(helpButton, SQLRetrievalImportJobsWindow.class);
        
    }
    /**
     * 
     */
	private void createFields() {
        jPanel1 = new javax.swing.JPanel();
        finishButton = new javax.swing.JButton();
        connectionCheckLabel = new javax.swing.JLabel();
        nextButton = new javax.swing.JButton();
        helpButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        heading = new javax.swing.JLabel();
        stepsPanel = new javax.swing.JPanel();
        stepsTitle = new javax.swing.JLabel();
        step1 = new javax.swing.JLabel();
        step2 = new javax.swing.JLabel();
        step3 = new javax.swing.JLabel();
        step4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        dataSourceLabel = new javax.swing.JLabel();
        databaseTypeLabel = new javax.swing.JLabel();
        databaseConnectionLabel = new javax.swing.JLabel();
        dataSourceSeparator = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        dataTablesLabel = new javax.swing.JLabel();
        addDataTableButton = new javax.swing.JButton();
        removeDataTableButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataTablesList = new javax.swing.JList<DatabaseTable>();
        jPanel3 = new javax.swing.JPanel();
        dataFieldsLabel = new javax.swing.JLabel();
        addDataFieldButton = new javax.swing.JButton();
        removeDataFieldButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        dataFieldsList = new javax.swing.JList<Field>();
        jPanel4 = new javax.swing.JPanel();
        conditionsLabel = new javax.swing.JLabel();
        setConditionButton = new javax.swing.JButton();
        removeConditionButton = new javax.swing.JButton();
        conditionField = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        sortingLabel = new javax.swing.JLabel();
        addSortButton = new javax.swing.JButton();
        removeSortButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        dataSortsList = new javax.swing.JList<DatabaseSort>();
        moveUpSortButton = new javax.swing.JButton();
        moveDownSortButton = new javax.swing.JButton();
	}
	/**
	 * 
	 */
	private void buildStepsPanelLayout() {
        org.jdesktop.layout.GroupLayout stepsPanelLayout = new org.jdesktop.layout.GroupLayout(stepsPanel);
        stepsPanel.setLayout(stepsPanelLayout);
        stepsPanelLayout.setHorizontalGroup(
            stepsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(stepsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(stepsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(stepsTitle)
                    .add(step2)
                    .add(step3)
                    .add(step4)
                    .add(step1)
                    .add(jLabel1))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        stepsPanelLayout.setVerticalGroup(
            stepsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(stepsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(stepsTitle)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(step1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(step2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(step3)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(step4)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel1)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
	}
	/**
	 * 
	 */
	private void buildJPanel1Layout() {
		org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 100, Short.MAX_VALUE)
        );
	}
	/**
	 * 
	 */
	private void buildJPanel2Layout() {
		org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(addDataTableButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(dataTablesLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(removeDataTableButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .add(27, 27, 27)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(dataTablesLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(addDataTableButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(removeDataTableButton)
                        .add(0, 23, Short.MAX_VALUE))
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
	}
    /**
     * 
     */
	private void buildJPanel3Layout() {
        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(dataFieldsLabel)
                    .add(addDataFieldButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 43, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(removeDataFieldButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 43, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 33, Short.MAX_VALUE)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 102, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 89, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(dataFieldsLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(addDataFieldButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(removeDataFieldButton)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }
	/** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {
    	createFields();
        buildJPanel1Layout();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        finishButton.setText("Finish");
        finishButton.setEnabled(false);
        finishButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                finishButtonActionPerformed(evt);
            }
        });
        connectionCheckLabel.setText(" ");
        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });
        helpButton.setText("Help");
        helpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                helpButtonActionPerformed(evt);
            }
        });
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        heading.setFont(new java.awt.Font("Tahoma", 1,
        		eesa.gui.Application.HEADING_FONT_SIZE)); // NOI18N
        heading.setText("Customise Retrieval Query");
        stepsPanel.setBackground(new java.awt.Color(255, 255, 255));
        stepsTitle.setFont(new java.awt.Font("Tahoma", 1,
        		eesa.gui.Application.STEP_FONT_SIZE)); // NOI18N
        stepsTitle.setText("Steps");
        step1.setFont(new java.awt.Font("Tahoma", 2,
        		eesa.gui.Application.STEP_FONT_SIZE)); // NOI18N
        step1.setText("1. Select Type");
        step2.setFont(new java.awt.Font("Tahoma", 2,
        		eesa.gui.Application.STEP_FONT_SIZE)); // NOI18N
        step2.setText("2. Select Source");
        step3.setFont(new java.awt.Font("Tahoma", 1,
        		eesa.gui.Application.STEP_FONT_SIZE)); // NOI18N
        step3.setText("3. Customise Retrieval");
        step4.setText("4. Map Data");
        jLabel1.setText("5. View Results");
        buildStepsPanelLayout();
        backButton.setText("Back");
        backButton.setEnabled(false);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        dataSourceLabel.setFont(new java.awt.Font("Tahoma", 1, eesa.gui.Application.FONT_SIZE)); // NOI18N
        dataSourceLabel.setText("Data Source:");
        databaseTypeLabel.setText(getDatabaseConnector().toString());
        databaseConnectionLabel.setText(getDatabase().toString());
        dataSourceSeparator.setText("::");
        dataTablesLabel.setText("Data Tables:");
        addDataTableButton.setText("+");
        addDataTableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                addDataTableButtonActionPerformed(evt);
            }
        });
        removeDataTableButton.setText("-");
        removeDataTableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                removeDataTableButtonActionPerformed(evt);
            }
        });
        dataTablesList.setModel(databaseTableListModel);
        jScrollPane1.setViewportView(dataTablesList);
        buildJPanel2Layout();
        dataFieldsLabel.setText("Data Fields");
        addDataFieldButton.setText("+");
        addDataFieldButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                addDataFieldButtonActionPerformed(evt);
            }
        });
        removeDataFieldButton.setText("-");
        removeDataFieldButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                removeDataFieldButtonActionPerformed(evt);
            }
        });
        dataFieldsList.setModel(databaseFieldListModel);
        jScrollPane2.setViewportView(dataFieldsList);
        buildJPanel3Layout();
        conditionsLabel.setText("Condition");
        setConditionButton.setText("Set");
        setConditionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                setConditionButtonActionPerformed(evt);
            }
        });
        removeConditionButton.setText("Remove");
        removeConditionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                removeConditionButtonActionPerformed(evt);
            }
        });
        conditionField.setEditable(false);
        buildJPanel4Layout();
        sortingLabel.setText("Sorting");
        addSortButton.setText("+");
        addSortButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                addSortButtonActionPerformed(evt);
            }
        });
        removeSortButton.setText("-");
        removeSortButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                removeSortButtonActionPerformed(evt);
            }
        });
        dataSortsList.setModel(databaseSortListModel);
        jScrollPane4.setViewportView(dataSortsList);
        moveUpSortButton.setText("^");
        moveUpSortButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                moveUpSortButtonActionPerformed(evt);
            }
        });
        moveDownSortButton.setText("v");
        moveDownSortButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                moveDownSortButtonActionPerformed(evt);
            }
        });
        buildJPanel5Layout();
        buildLayout();
        pack();
    }
    /**
     * 
     */
    private void buildJPanel4Layout() {
        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel4Layout.createSequentialGroup()
                        .add(conditionsLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(conditionField))
                    .add(jPanel4Layout.createSequentialGroup()
                        .add(setConditionButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(removeConditionButton)
                        .add(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(conditionsLabel)
                    .add(conditionField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(setConditionButton)
                    .add(removeConditionButton))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );    	
    }
    
    /**
     * 
     */
    private void buildJPanel5Layout() {
        org.jdesktop.layout.GroupLayout jPanel5Layout = new org.jdesktop.layout.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(sortingLabel)
                    .add(addSortButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 49, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(removeSortButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 49, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jScrollPane4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 122, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(moveUpSortButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 55, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(moveDownSortButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 55, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .add(jPanel5Layout.createSequentialGroup()
                        .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel5Layout.createSequentialGroup()
                                .add(moveUpSortButton)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(moveDownSortButton))
                            .add(jPanel5Layout.createSequentialGroup()
                                .add(sortingLabel)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(addSortButton)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(removeSortButton)))
                        .add(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }
    
    /**
     * 
     */
    private void buildLayout() {
        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(stepsPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(heading, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 182, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(layout.createSequentialGroup()
                                .add(213, 213, 213)
                                .add(connectionCheckLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(backButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(nextButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(finishButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cancelButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(helpButton)
                        .addContainerGap())
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .add(18, 18, 18)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(jPanel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(jPanel5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .add(layout.createSequentialGroup()
                                .add(dataSourceLabel)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(databaseTypeLabel)
                                .add(6, 6, 6)
                                .add(dataSourceSeparator)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(databaseConnectionLabel)))
                        .add(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(stepsPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(20, 20, 20))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .add(heading)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(dataSourceLabel)
                            .add(databaseTypeLabel)
                            .add(databaseConnectionLabel)
                            .add(dataSourceSeparator))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jPanel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jPanel5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .add(0, 8, Short.MAX_VALUE)))
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(connectionCheckLabel)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(helpButton)
                        .add(backButton)
                        .add(nextButton)
                        .add(finishButton)
                        .add(cancelButton)))
                .addContainerGap())
        );    	
    }
    /**
     * 
     * @param evt 
     */
    private void finishButtonActionPerformed(final java.awt.event.ActionEvent evt) {
        // Do Nothing
}
    /**
     * 
     * @param evt 
     */
    private void nextButtonActionPerformed(final java.awt.event.ActionEvent evt) {
        if (!databaseTableListModel.hasTables() || !databaseFieldListModel.hasFields()) {
            JOptionPane.showMessageDialog(this, "You need atleast one table and one field first!", "Retrieval Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        updateData();
        try {
            new SQLMapImportJobsWindow(data).setVisible(true);
            dispose();
        } catch (DatabaseException ex) {
            Logger.getLogger(SQLRetrievalImportJobsWindow.class.getName()).log(Level.INFO, null, ex);
            JOptionPane.showMessageDialog(this, data.getDatabaseConnector().toString() + "Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        } catch (EESAException ex) {
            Logger.getLogger(SQLRetrievalImportJobsWindow.class.getName()).log(Level.INFO, null, ex);
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);            
        }
}
    /**
     * 
     * @param evt 
     */
    private void helpButtonActionPerformed(final java.awt.event.ActionEvent evt) {
}
    /**
     * 
     * @param evt 
     */
    private void cancelButtonActionPerformed(final java.awt.event.ActionEvent evt) {
        setVisible(false);
        dispose();
}
    /**
     * 
     * @param evt 
     */
    private void backButtonActionPerformed(final java.awt.event.ActionEvent evt) {
        updateData();
        new SQLImportJobsWindow(data).setVisible(true);
        dispose();
}
    /**
     * 
     * @param evt 
     */
    private void addDataTableButtonActionPerformed(final java.awt.event.ActionEvent evt) {
        new AddDatabaseTableWindow(this).setVisible(true);
    }
    /**
     * 
     * @param evt 
     */
    private void removeDataTableButtonActionPerformed(final java.awt.event.ActionEvent evt) {
        databaseTableListModel.removeTable(dataTablesList.getSelectedValue());
    }
    /**
     * 
     * @param evt 
     */
    private void setConditionButtonActionPerformed(final java.awt.event.ActionEvent evt) {
        new AddDatabaseConditionWindow(this).setVisible(true);
    }
    /**
     * 
     * @param evt 
     */
    private void removeConditionButtonActionPerformed(final java.awt.event.ActionEvent evt) {
        this.condition = null;
        this.conditionField.setText("");
    }
    /**
     * 
     * @param evt 
     */
    private void addDataFieldButtonActionPerformed(final java.awt.event.ActionEvent evt) {
        new AddDatabaseFieldWindow(this).setVisible(true);
    }
    /**
     * 
     * @param evt 
     */
    private void removeDataFieldButtonActionPerformed(final java.awt.event.ActionEvent evt) {
        if (dataFieldsList.getSelectedValue() != null) {
            databaseFieldListModel.removeField((Field) dataFieldsList.getSelectedValue());
        }
    }
    /**
     * 
     * @param evt 
     */
    private void addSortButtonActionPerformed(final java.awt.event.ActionEvent evt) {
        new AddDatabaseSortWindow(this).setVisible(true);
    }
    /**
     * 
     * @param evt 
     */
    private void removeSortButtonActionPerformed(final java.awt.event.ActionEvent evt) {
        databaseSortListModel.removeSort((DatabaseSort) dataSortsList.getSelectedValue());
    }
    /**
     * 
     * @param evt 
     */    /**
     * 
     * @param evt 
     */    /**
     * 
     * @param evt 
     */
    private void moveUpSortButtonActionPerformed(final java.awt.event.ActionEvent evt) {
        databaseSortListModel.moveUp((DatabaseSort) dataSortsList.getSelectedValue());
    }
    /**
     * 
     * @param evt 
     */
    private void moveDownSortButtonActionPerformed(final java.awt.event.ActionEvent evt) {
        databaseSortListModel.moveUp((DatabaseSort) dataSortsList.getSelectedValue());
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
     * 
     */
    private javax.swing.JButton addDataFieldButton;
    /**
     * 
     */
    private javax.swing.JButton addDataTableButton;
    /**
     * 
     */
    private javax.swing.JButton addSortButton;
    /**
     * 
     */
    private javax.swing.JButton backButton;
    /**
     * 
     */
    private javax.swing.JButton cancelButton;
    /**
     * 
     */
    private javax.swing.JTextField conditionField;
    /**
     * 
     */
    private javax.swing.JLabel conditionsLabel;
    /**
     * 
     */
    private javax.swing.JLabel connectionCheckLabel;
    /**
     * 
     */
    private javax.swing.JLabel dataFieldsLabel;
    /**
     * 
     */
    private javax.swing.JList<Field> dataFieldsList;
    /**
     * 
     */
    private javax.swing.JList<DatabaseSort> dataSortsList;
    /**
     * 
     */
    private javax.swing.JLabel dataSourceLabel;
    /**
     * 
     */
    private javax.swing.JLabel dataSourceSeparator;
    /**
     * 
     */
    private javax.swing.JLabel dataTablesLabel;
    /**
     * 
     */
    private JList<DatabaseTable> dataTablesList;
    /**
     * 
     */
    private javax.swing.JLabel databaseConnectionLabel;
    /**
     * 
     */
    private javax.swing.JLabel databaseTypeLabel;
    /**
     * 
     */
    private javax.swing.JButton finishButton;
    /**
     * 
     */
    private javax.swing.JLabel heading;
    /**
     * 
     */
    private javax.swing.JButton helpButton;
    /**
     * 
     */
    private javax.swing.JLabel jLabel1;
    /**
     * 
     */
    private javax.swing.JPanel jPanel1;
    /**
     * 
     */
    private javax.swing.JPanel jPanel2;
    /**
     * 
     */
    private javax.swing.JPanel jPanel3;
    /**
     * 
     */
    private javax.swing.JPanel jPanel4;
    /**
     * 
     */
    private javax.swing.JPanel jPanel5;
    /**
     * 
     */
    private javax.swing.JScrollPane jScrollPane1;
    /**
     * 
     */
    private javax.swing.JScrollPane jScrollPane2;
    /**
     * 
     */
    private javax.swing.JScrollPane jScrollPane4;
    /**
     * 
     */
    private javax.swing.JButton moveDownSortButton;
    /**
     * 
     */
    private javax.swing.JButton moveUpSortButton;
    /**
     * 
     */
    private javax.swing.JButton nextButton;
    /**
     * 
     */
    private javax.swing.JButton removeConditionButton;
    /**
     * 
     */
    private javax.swing.JButton removeDataFieldButton;
    /**
     * 
     */
    private javax.swing.JButton removeDataTableButton;
    /**
     * 
     */
    private javax.swing.JButton removeSortButton;
    /**
     * 
     */
    private javax.swing.JButton setConditionButton;
    /**
     * 
     */
    private javax.swing.JLabel sortingLabel;
    /**
     * 
     */
    private javax.swing.JLabel step1;
    /**
     * 
     */
    private javax.swing.JLabel step2;
    /**
     * 
     */
    private javax.swing.JLabel step3;
    /**
     * 
     */
    private javax.swing.JLabel step4;
    /**
     * 
     */
    private javax.swing.JPanel stepsPanel;
    /**
     * 
     */
    private javax.swing.JLabel stepsTitle;
    // End of variables declaration//GEN-END:variables

    /**
     * 
     */
    private void updateData() {
        SelectQuery select = data.getDatabase().select();
        select.setTables(getTables());
        select.setFields(getFields());
        select.setCondition(getCondition());
        select.setSorts(getSorts());
        data.setSelectQuery(select);
    }

    @Override
	public final Database getDatabase() {
        return data.getDatabase();
    }

    @Override
	public final DatabaseConnector getDatabaseConnector() {
        return data.getDatabaseConnector();
    }

    @Override
	public final void addTable(final DatabaseTable table) {
        databaseTableListModel.addTable(table);
    }

    @Override
	public final DatabaseTable[] getTables() {
        return databaseTableListModel.getTables();
    }

    @Override
	public final void addField(final Field field) {
        databaseFieldListModel.addField(field);
    }

    @Override
	public final Field[] getFields() {
        return databaseFieldListModel.getFields();
    }

    @Override
	public final Operator[] getOperators() {
        return data.getDatabase().getOperators();
    }

    @Override
	public final void setCondition(final DatabaseCondition c) {
        this.condition = c;
        this.conditionField.setText(condition.toString());
    }
    
    @Override
	public final DatabaseCondition getCondition() {
        return condition;
    }

    @Override
	public final void addSort(final DatabaseSort sort) {
        databaseSortListModel.addSort(sort);
    }
    
    @Override
	public final DatabaseSort[] getSorts() {
        return databaseSortListModel.getSorts();
    }
    
}
