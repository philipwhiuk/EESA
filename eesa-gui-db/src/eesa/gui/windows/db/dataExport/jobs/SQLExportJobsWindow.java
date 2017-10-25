package eesa.gui.windows.db.dataExport.jobs;

import com.whiuk.philip.eesa.db.dataExport.SQLJobDataExport;
import eesa.gui.help.HelpManager;
import eesa.gui.windows.dataExport.jobs.AbstractExportJobsWindow;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import com.whiuk.philip.eesa.db.Database;
import com.whiuk.philip.eesa.db.DatabaseConnector;
import com.whiuk.philip.eesa.db.DatabaseException;
import com.whiuk.philip.eesa.db.DatabaseManager;

/**
 * Allows the user to customise the database connection details.
 * @author Philip
 */
public class SQLExportJobsWindow extends AbstractExportJobsWindow  {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    private final SQLJobDataExport data;

    /** Creates new form SQLExportJobsWindow.
     * @param data 
     */
    public SQLExportJobsWindow(final SQLJobDataExport data) {
        this.data = data;
        initComponents();
        HelpManager.addHelpForClassToButton(helpButton, SQLExportJobsWindow.class);
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
        step1.setFont(new java.awt.Font("Tahoma", 2, eesa.gui.Application.STEP_FONT_SIZE)); // NOI18N
        step1.setText("1. Select Type");
        step2.setFont(new java.awt.Font("Tahoma", 1,
        		eesa.gui.Application.STEP_FONT_SIZE)); // NOI18N
        step2.setText("2. Select Destination");
        step3.setText("3. Customise Insertion");
        step4.setText("4. Map Data");
        buildStepsPanelLayout();


        heading.setFont(new java.awt.Font("Tahoma", 1,
        		eesa.gui.Application.HEADING_FONT_SIZE)); // NOI18N
        heading.setText("Select SQL Database Source");

        typeLabel.setText("Database Type");

        jLabel1.setText("Database Connection");

        hostLabel.setText("Database Host");

        databaseTypeComboBox.setModel(getDatabaseTypes());
        databaseTypeComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(final java.awt.event.ItemEvent evt) {
                databaseTypeComboBoxItemStateChanged(evt);
            }
        });
        databaseTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                databaseTypeComboBoxActionPerformed(evt);
            }
        });

        databaseConnectionComboBox.setModel(getDefinedDatabaseConnections());
        databaseConnectionComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(final java.awt.event.ItemEvent evt) {
                databaseConnectionComboBoxItemStateChanged(evt);
            }
        });

        customConnectionCheckBox.setText("Custom Connection");
        customConnectionCheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(final java.awt.event.ItemEvent evt) {
                customConnectionCheckBoxItemStateChanged(evt);
            }
        });
        customConnectionCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                customConnectionCheckBoxActionPerformed(evt);
            }
        });

        hostField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                hostFieldActionPerformed(evt);
            }
        });

        jdbcField.setEditable(false);

        jdbcCustomiseCheckbox.setText("Custom JDBC URL");
        jdbcCustomiseCheckbox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(final java.awt.event.ItemEvent evt) {
                jdbcCustomiseCheckboxItemStateChanged(evt);
            }
        });
        jdbcCustomiseCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                jdbcCustomiseCheckboxActionPerformed(evt);
            }
        });

        jdbcLabel.setText("JDBC Connection");

        nameLabel.setText("Database Name");

        passwordLabel.setText("Database Password");

        usernameLabel.setText("Database Username");

        portLabel.setText("Database Port");

        connectionCheck.setText("Test Connection");
        connectionCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                connectionCheckActionPerformed(evt);
            }
        });

        buildLayout();

        pack();
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
                    .add(step1)
                    .add(step4))
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
                .addContainerGap(224, Short.MAX_VALUE))
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
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(240, Short.MAX_VALUE)
                .add(backButton2)
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
                .add(stepsPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(hostLabel)
                            .add(portLabel)
                            .add(passwordLabel)
                            .add(usernameLabel)
                            .add(nameLabel)
                            .add(jdbcLabel))
                        .add(eesa.gui.Application.GAP, eesa.gui.Application.GAP, eesa.gui.Application.GAP)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jdbcField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, usernameField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, portField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, hostField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, passwordField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, nameField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jdbcCustomiseCheckbox)))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, connectionCheck)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, heading, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 182, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(typeLabel)
                        .add(34, 34, 34)
                        .add(databaseTypeComboBox, 0, 249, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(jLabel1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(customConnectionCheckBox)
                            .add(databaseConnectionComboBox, 0, 249, Short.MAX_VALUE))))
                .add(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(stepsPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(eesa.gui.Application.GAP, eesa.gui.Application.GAP, eesa.gui.Application.GAP))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(heading)
                        .add(5, 5, 5)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(databaseTypeComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(typeLabel))
                        .add(9, 9, 9)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel1)
                            .add(databaseConnectionComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(2, 2, 2)
                        .add(customConnectionCheckBox)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(hostLabel)
                            .add(hostField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(portLabel)
                            .add(portField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(usernameLabel)
                            .add(usernameField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(passwordLabel)
                            .add(passwordField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(nameField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(nameLabel))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jdbcField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jdbcLabel))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jdbcCustomiseCheckbox)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(connectionCheck)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)))
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(helpButton)
                    .add(backButton2)
                    .add(nextButton)
                    .add(finishButton)
                    .add(cancelButton))
                .addContainerGap())
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
        heading = new javax.swing.JLabel();
        typeLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        hostLabel = new javax.swing.JLabel();
        databaseTypeComboBox = new javax.swing.JComboBox<DatabaseConnector>();
        databaseConnectionComboBox = new javax.swing.JComboBox<Database>();
        customConnectionCheckBox = new javax.swing.JCheckBox();
        hostField = new javax.swing.JTextField();
        portField = new javax.swing.JTextField();
        usernameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        nameField = new javax.swing.JTextField();
        jdbcField = new javax.swing.JTextField();
        jdbcCustomiseCheckbox = new javax.swing.JCheckBox();
        jdbcLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        portLabel = new javax.swing.JLabel();
        connectionCheck = new javax.swing.JButton();
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
        new SQLInsertionExportJobsWindow(data).setVisible(true);
        dispose();
}
    /**
     * 
     * @param evt Event
     */
    private void databaseTypeComboBoxItemStateChanged(final java.awt.event.ItemEvent evt) {
        databaseConnectionComboBox.setModel(this.getDefinedDatabaseConnections());
}
    /**
     * 
     * @param evt Event
     */
    private void databaseTypeComboBoxActionPerformed(final java.awt.event.ActionEvent evt) {
        
}
    /**
     * 
     * @param evt Event
     */
    private void databaseConnectionComboBoxItemStateChanged(final java.awt.event.ItemEvent evt) {
        jdbcField.setText(((Database) databaseConnectionComboBox.getSelectedItem()).getURL());
}
    /**
     * 
     * @param evt Event
     */
    private void customConnectionCheckBoxItemStateChanged(final java.awt.event.ItemEvent evt) {
        hostField.setEditable(customConnectionCheckBox.isSelected());
        portField.setEditable(customConnectionCheckBox.isSelected());
        usernameField.setEditable(customConnectionCheckBox.isSelected());
        passwordField.setEditable(customConnectionCheckBox.isSelected());
        nameField.setEditable(customConnectionCheckBox.isSelected());
        jdbcCustomiseCheckbox.setEnabled(customConnectionCheckBox.isSelected());
        jdbcField.setEditable(customConnectionCheckBox.isSelected() && jdbcCustomiseCheckbox.isSelected());
}
    /**
     * 
     * @param evt Event
     */
    private void customConnectionCheckBoxActionPerformed(final java.awt.event.ActionEvent evt) {
        
}
    /**
     * 
     * @param evt Event
     */
    private void hostFieldActionPerformed(final java.awt.event.ActionEvent evt) {
        
}
    /**
     * 
     * @param evt Event
     */
    private void jdbcCustomiseCheckboxItemStateChanged(final java.awt.event.ItemEvent evt) {
        jdbcField.setEditable(customConnectionCheckBox.isSelected() && jdbcCustomiseCheckbox.isSelected());
}
    /**
     * 
     * @param evt Event
     */
    private void jdbcCustomiseCheckboxActionPerformed(final java.awt.event.ActionEvent evt) {
        
}
    /**
     * 
     * @param evt Event
     */
    private void connectionCheckActionPerformed(final java.awt.event.ActionEvent evt) {
        Database db;
        DatabaseConnector dbConnector = (DatabaseConnector) databaseTypeComboBox.getSelectedItem();
        if (customConnectionCheckBox.isSelected()) {
            String url = jdbcField.getText() + new String(passwordField.getPassword());
            db = dbConnector.getDatabase(url);
        } else {
            db = (Database) databaseConnectionComboBox.getSelectedItem();
        }
        try {
            db.getConnection();
        } catch (DatabaseException ex) {
            JOptionPane.showMessageDialog(this, 
            		dbConnector.toString() + " Error: " + ex.getMessage(),
            		"Connection Error",
            		JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(SQLExportJobsWindow.class.getName()).log(Level.INFO, "Connection Test Error", ex);
            return;
        }
        JOptionPane.showMessageDialog(this,
        		dbConnector.toString() + " Connection Succesful!",
        		"Connection Success",
        		JOptionPane.INFORMATION_MESSAGE);
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JButton connectionCheck;
	/**
	 * 
	 */
    private javax.swing.JCheckBox customConnectionCheckBox;
	/**
	 * 
	 */
    private javax.swing.JComboBox<Database> databaseConnectionComboBox;
	/**
	 * 
	 */
    private javax.swing.JComboBox<DatabaseConnector> databaseTypeComboBox;
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
    private javax.swing.JTextField hostField;
	/**
	 * 
	 */
    private javax.swing.JLabel hostLabel;
	/**
	 * 
	 */
    private javax.swing.JLabel jLabel1;
	/**
	 * 
	 */
    private javax.swing.JCheckBox jdbcCustomiseCheckbox;
	/**
	 * 
	 */
    private javax.swing.JTextField jdbcField;
	/**
	 * 
	 */
    private javax.swing.JLabel jdbcLabel;
	/**
	 * 
	 */
    private javax.swing.JTextField nameField;
	/**
	 * 
	 */
    private javax.swing.JLabel nameLabel;
	/**
	 * 
	 */
    private javax.swing.JButton nextButton;
	/**
	 * 
	 */
    private javax.swing.JPasswordField passwordField;
	/**
	 * 
	 */
    private javax.swing.JLabel passwordLabel;
	/**
	 * 
	 */
    private javax.swing.JTextField portField;
	/**
	 * 
	 */
    private javax.swing.JLabel portLabel;
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
    private javax.swing.JLabel typeLabel;
	/**
	 * 
	 */
    private javax.swing.JTextField usernameField;
	/**
	 * 
	 */
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables

    /**
     * 
     */
    private void updateData() {
        Database db;
        DatabaseConnector dbConnector = (DatabaseConnector) databaseTypeComboBox.getSelectedItem();
        if (customConnectionCheckBox.isSelected()) {
            String url = jdbcField.getText() + new String(passwordField.getPassword()); 
            db = dbConnector.getDatabase(url);
        } else {
            db = (Database) databaseConnectionComboBox.getSelectedItem();
        }
        data.setDatabaseConnector(dbConnector);
        data.setDatabase(db);
    }
    /**
     * 
     * @return 
     */
    private ComboBoxModel<DatabaseConnector> getDatabaseTypes() {
        DatabaseConnector[] databaseTypes = DatabaseManager.getDatabaseConnectors();
        return new DefaultComboBoxModel<DatabaseConnector>(databaseTypes);
    }
    /**
     * 
     * @return 
     */
    private ComboBoxModel<Database> getDefinedDatabaseConnections() {
        Database[] definedDatabaseConnections = ((DatabaseConnector) databaseTypeComboBox.getSelectedItem()).getDefinedDatabaseConnections();
        return new DefaultComboBoxModel<Database>(definedDatabaseConnections);        
    }
}
