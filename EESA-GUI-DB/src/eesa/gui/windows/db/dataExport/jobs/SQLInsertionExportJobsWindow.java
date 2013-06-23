/*
 * SQLInsertionExportJobsWindow.java
 *
 * Created on 04-Apr-2012, 20:19:43
 */
package eesa.gui.windows.db.dataExport.jobs;

import eesa.db.Database;
import eesa.db.DatabaseCondition;
import eesa.db.DatabaseConnector;
import eesa.db.DatabaseSort;
import eesa.db.DatabaseTable;
import eesa.db.Field;
import eesa.db.InsertQuery;
import eesa.db.Operator;
import eesa.db.dataExport.SQLJobDataExport;
import eesa.gui.help.HelpManager;
import eesa.gui.lists.db.DatabaseFieldListModel;
import eesa.gui.windows.AbstractProcessWindow;
import eesa.gui.windows.db.AddDatabaseFieldWindow;
import eesa.gui.windows.db.AddDatabaseTableWindow;
import eesa.gui.windows.db.DatabaseWindow;

/**
 * Allows the user to select the fields to insert into.
 * @author Philip
 */
public class SQLInsertionExportJobsWindow extends AbstractProcessWindow implements DatabaseWindow {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    private final SQLJobDataExport data;
    /**
     * 
     */
    private DatabaseFieldListModel databaseFieldListModel;
    /** 
     * Creates new form SQLInsertionExportJobsWindow.
     * @param data 
     */
    public SQLInsertionExportJobsWindow(final SQLJobDataExport data) {
        this.data = data;
        initComponents();
        HelpManager.addHelpForClassToButton(helpButton, SQLInsertionExportJobsWindow.class);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {
    	createFields();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        helpButton.setText("Help");
        helpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                helpButtonActionPerformed(evt);
            }
        });
        backButton2.setText("Back");
        backButton2.setEnabled(false);
        backButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                backButton2ActionPerformed(evt);
            }
        });

        finishButton.setText("Finish");
        finishButton.setEnabled(false);
        finishButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                finishButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        nextButton.setText("Next");
        nextButton.setEnabled(false);
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        stepsPanel.setBackground(new java.awt.Color(255, 255, 255));
        stepsTitle.setFont(new java.awt.Font("Tahoma", 1, eesa.gui.Application.STEP_FONT_SIZE)); // NOI18N
        stepsTitle.setText("Steps");
        step1.setFont(new java.awt.Font("Tahoma", 2,
        		eesa.gui.Application.STEP_FONT_SIZE)); // NOI18N
        step1.setText("1. Select Type");
        step2.setFont(new java.awt.Font("Tahoma", 2,
        		eesa.gui.Application.STEP_FONT_SIZE)); // NOI18N
        step2.setText("2. Select Destination");
        step3.setFont(new java.awt.Font("Tahoma", 1,
        		eesa.gui.Application.STEP_FONT_SIZE)); // NOI18N
        step3.setText("3. Customise Insertion");
        step4.setText("4. Map Data");
        buildStepsPanelLayout();
        databaseConnectionLabel.setText(getDatabase().toString());
        databaseTypeLabel.setText(getDatabaseConnector().toString());
        heading.setFont(new java.awt.Font("Tahoma", 1,
        		eesa.gui.Application.HEADING_FONT_SIZE)); // NOI18N
        heading.setText("Customise Insertion Query");
        dataSourceLabel.setFont(new java.awt.Font("Tahoma", 1,
        		eesa.gui.Application.STEP_FONT_SIZE)); // NOI18N
        dataSourceLabel.setText("Data Source:");
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
        dataTablesLabel.setText("Data Tables:");
        addDataTableButton.setText("Set");
        addDataTableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                addDataTableButtonActionPerformed(evt);
            }
        });
        removeDataTableButton.setText("Remove");
        removeDataTableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                removeDataTableButtonActionPerformed(evt);
            }
        });

        databaseTableField.setEditable(false);

        buildJPanel2Layout();

        dataSourceSeparator.setText("::");
        buildLayout();


        pack();
    }
    /**
     * 
     */
    private void buildLayout() {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(199, Short.MAX_VALUE)
                        .addComponent(backButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(finishButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(helpButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(stepsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(heading, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dataSourceLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(databaseTypeLabel)
                                .addGap(6, 6, 6)
                                .addComponent(dataSourceSeparator)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(databaseConnectionLabel))
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stepsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(heading)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dataSourceLabel)
                            .addComponent(databaseTypeLabel)
                            .addComponent(databaseConnectionLabel)
                            .addComponent(dataSourceSeparator))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 13, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(helpButton)
                    .addComponent(backButton2)
                    .addComponent(nextButton)
                    .addComponent(finishButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );
	}

	/**
     * 
     */
    private void buildJPanel2Layout() {
        
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(addDataTableButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dataTablesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(removeDataTableButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(databaseTableField)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dataTablesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addDataTableButton)
                    .addComponent(databaseTableField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeDataTableButton)
                .addContainerGap(34, Short.MAX_VALUE))
        );
	}

	/**
     * 
     */
    private void buildJPanel3Layout() {
        
        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dataFieldsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(removeDataFieldButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addDataFieldButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dataFieldsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(addDataFieldButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeDataFieldButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
	}

	/**
     * 
     */
    private void buildStepsPanelLayout() {
        javax.swing.GroupLayout stepsPanelLayout = new javax.swing.GroupLayout(stepsPanel);
        stepsPanel.setLayout(stepsPanelLayout);
        stepsPanelLayout.setHorizontalGroup(
            stepsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stepsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(stepsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stepsTitle)
                    .addComponent(step2)
                    .addComponent(step1)
                    .addComponent(step3)
                    .addComponent(step4))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        stepsPanelLayout.setVerticalGroup(
            stepsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stepsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(stepsTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(step1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(step2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(step3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(step4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
	}

	/**
     * 
     */
    private void createFields() {
        helpButton = new javax.swing.JButton();
        backButton2 = new javax.swing.JButton();
        finishButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        stepsPanel = new javax.swing.JPanel();
        stepsTitle = new javax.swing.JLabel();
        step1 = new javax.swing.JLabel();
        step2 = new javax.swing.JLabel();
        step3 = new javax.swing.JLabel();
        step4 = new javax.swing.JLabel();
        databaseConnectionLabel = new javax.swing.JLabel();
        databaseTypeLabel = new javax.swing.JLabel();
        heading = new javax.swing.JLabel();
        dataSourceLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        dataFieldsLabel = new javax.swing.JLabel();
        addDataFieldButton = new javax.swing.JButton();
        removeDataFieldButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        dataFieldsList = new javax.swing.JList<Field>();
        jPanel2 = new javax.swing.JPanel();
        dataTablesLabel = new javax.swing.JLabel();
        addDataTableButton = new javax.swing.JButton();
        removeDataTableButton = new javax.swing.JButton();
        databaseTableField = new javax.swing.JTextField();
        dataSourceSeparator = new javax.swing.JLabel();
	}

	/**
     * 
     * @param evt Event
     */
    private void helpButtonActionPerformed(final java.awt.event.ActionEvent evt) {
        
}
    /**
     * 
     * @param evt Event
     */
    private void backButton2ActionPerformed(final java.awt.event.ActionEvent evt) {
        //Do Nothing
}
    /**
     * 
     * @param evt Event
     */
    private void finishButtonActionPerformed(final java.awt.event.ActionEvent evt) {
    	// Do Nothing
}
    /**
     * 
     * @param evt Event
     */
    private void cancelButtonActionPerformed(final java.awt.event.ActionEvent evt) {
        setVisible(false);
        dispose();
}
    /**
     * 
     * @param evt Event
     */
    private void nextButtonActionPerformed(final java.awt.event.ActionEvent evt) {
        updateData();
        new SQLMapExportJobsWindow(data).setVisible(true);
        dispose();
}
    /**
     * 
     * @param evt Event
     */
    private void addDataFieldButtonActionPerformed(final java.awt.event.ActionEvent evt) {
        new AddDatabaseFieldWindow(this).setVisible(true);
    }
    /**
     * 
     * @param evt Event
     */
    private void removeDataFieldButtonActionPerformed(final java.awt.event.ActionEvent evt) {
        databaseFieldListModel.removeField((Field) dataFieldsList.getSelectedValue());
    }
    /**
     * 
     * @param evt Event
     */
    private void addDataTableButtonActionPerformed(final java.awt.event.ActionEvent evt) {
        new AddDatabaseTableWindow(this).setVisible(true);
    }
    /**
     * 
     * @param evt Event
     */
    private void removeDataTableButtonActionPerformed(final java.awt.event.ActionEvent evt) {
        databaseTableField.setText("");
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
    private javax.swing.JButton backButton2;
    /**
     * 
     */
    private javax.swing.JButton cancelButton;
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
    private javax.swing.JLabel databaseConnectionLabel;
    /**
     * 
     */
    private javax.swing.JTextField databaseTableField;
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
    private javax.swing.JPanel jPanel2;
    /**
     * 
     */
    private javax.swing.JPanel jPanel3;
    /**
     * 
     */
    private javax.swing.JScrollPane jScrollPane2;
    /**
     * 
     */
    private javax.swing.JButton nextButton;
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
    /**
     * 
     */
	private DatabaseTable databaseTable;
    // End of variables declaration//GEN-END:variables

    /**
     * 
     */
    private void updateData() {
        InsertQuery insert = data.getDatabase().insert();
        insert.setTable(getTable());
        insert.setFields(getFields());
        data.setInsertQuery(insert);
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
    	databaseTable = table;
        databaseTableField.setText(table.output());
    }

    /**
     * 
     * @return
     */
    public final String getTable() {
        return databaseTableField.getText();
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
        throw new UnsupportedOperationException("Insert Query Does Not Use Operators.");
    }

    @Override
	public final void setCondition(final DatabaseCondition condition) {
        throw new UnsupportedOperationException("Insert Query Does Not Support Conditions.");
    }

    @Override
	public final DatabaseCondition getCondition() {
        throw new UnsupportedOperationException("Insert Query Does Not Support Conditions.");
    }

    @Override
	public final void addSort(final DatabaseSort sort) {
        throw new UnsupportedOperationException("Insert Query Does Not Support Sorting.");
    }

    @Override
	public final DatabaseSort[] getSorts() {
        throw new UnsupportedOperationException("Insert Query Does Not Support Sorting.");
    }

    @Override
	public final DatabaseTable[] getTables() {
        return new DatabaseTable[]{databaseTable};
    }
}
