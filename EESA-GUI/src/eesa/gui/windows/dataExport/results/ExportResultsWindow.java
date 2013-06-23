/*
 * ExportResultsWindow.java
 *
 * Created on 04-Apr-2012, 20:30:12
 */
package eesa.gui.windows.dataExport.results;

import eesa.dataExport.JobResultDataExport;
import eesa.gui.Application;
import eesa.gui.PluginConnector;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

/**
 * Provides exporter selection of job results.
 * @author Philip
 */
public class ExportResultsWindow extends javax.swing.JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * 
     */
    private JobResultDataExport data;
    /**
     * 
     */
    private ArrayList<PluginConnector> validConnectors;

    /** Creates new form ExportResultsWindow. */
    public ExportResultsWindow() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {
    	createFields();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        finishButton.setText("Finish");
        finishButton.setEnabled(false);
        finishButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                finishButtonActionPerformed(evt);
            }
        });
        nextButton.setText("Next");
        nextButton.setEnabled(false);
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });
        stepsPanel.setBackground(new java.awt.Color(255, 255, 255));
        stepsTitle.setFont(new java.awt.Font("Tahoma", 1, eesa.gui.Application.STEP_FONT_SIZE)); // NOI18N
        stepsTitle.setText("Steps");
        step1.setFont(new java.awt.Font("Tahoma", 1, eesa.gui.Application.STEP_FONT_SIZE)); // NOI18N
        step1.setText("1. Select Type");

        step2.setText("2. ...");

        javax.swing.GroupLayout stepsPanelLayout = new javax.swing.GroupLayout(stepsPanel);
        stepsPanel.setLayout(stepsPanelLayout);
        stepsPanelLayout.setHorizontalGroup(
            stepsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stepsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(stepsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stepsTitle)
                    .addComponent(step1)
                    .addComponent(step2))
                .addContainerGap(55, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        heading.setFont(new java.awt.Font("Tahoma", 1, eesa.gui.Application.HEADING_FONT_SIZE)); // NOI18N
        heading.setText("Select Type");

        helpButton.setText("Help");
        helpButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                helpButtonActionPerformed(evt);
            }
        });

        formatComboBox.setModel(getPluginConnectorsComboBoxModel());
        formatComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                formatComboBoxActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.setEnabled(false);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        formatDescriptionTextArea.setColumns(20);
        formatDescriptionTextArea.setEditable(false);
        formatDescriptionTextArea.setFont(new java.awt.Font("Arial", 0, eesa.gui.Application.FONT_SIZE)); // NOI18N
        formatDescriptionTextArea.setLineWrap(true);
        formatDescriptionTextArea.setRows(5);
        formatDescriptionTextArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(formatDescriptionTextArea);

        jobAssignmentAlgorithmLabel.setText("Type");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(stepsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(heading)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jobAssignmentAlgorithmLabel)
                                .addGap(18, 18, 18)
                                .addComponent(formatComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(205, Short.MAX_VALUE)
                        .addComponent(backButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(finishButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(helpButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(stepsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(44, 44, 44))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(heading)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jobAssignmentAlgorithmLabel)
                    .addComponent(formatComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(helpButton)
                    .addComponent(backButton)
                    .addComponent(nextButton)
                    .addComponent(finishButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        pack();
    }
    /**
     * 
     */
    private void createFields() {
        finishButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        stepsPanel = new javax.swing.JPanel();
        stepsTitle = new javax.swing.JLabel();
        step1 = new javax.swing.JLabel();
        step2 = new javax.swing.JLabel();
        heading = new javax.swing.JLabel();
        helpButton = new javax.swing.JButton();
        formatComboBox = new javax.swing.JComboBox<PluginConnector>();
        cancelButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        formatDescriptionTextArea = new javax.swing.JTextArea();
        jobAssignmentAlgorithmLabel = new javax.swing.JLabel();

	}

	/**
     * 
     * @param evt Event
     */
    private void finishButtonActionPerformed(final ActionEvent evt) {
        // Do Nothing
    }
    /**
     * 
     * @param evt Event
     */
    private void nextButtonActionPerformed(final ActionEvent evt) {
        PluginConnector plugin = (PluginConnector) formatComboBox.getSelectedItem();
        if (data != null & data.getClass().equals(plugin.getClass())) {
            plugin.getNewExportResultsWindow(data).setVisible(true);
            dispose();
        } else {
            plugin.getNewExportResultsWindow().setVisible(true);
            dispose();
        }
    }
    /**
     * 
     * @param evt Event
     */
    private void helpButtonActionPerformed(final ActionEvent evt) {

    }
    /**
     * 
     * @param evt Event
     */
    private void formatComboBoxActionPerformed(final ActionEvent evt) {
        PluginConnector selected = (PluginConnector) formatComboBox.getSelectedItem();
        formatDescriptionTextArea.setText(selected.getDescription());
        formatDescriptionTextArea.setCaretPosition(0);
    }
    /**
     * 
     * @param evt Event
     */
    private void cancelButtonActionPerformed(final ActionEvent evt) {
        setVisible(false);
        dispose();
    }
    /**
     * 
     * @param evt Event
     */
    private void backButtonActionPerformed(final ActionEvent evt) {
        // Do Nothing
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JButton finishButton;
    /**
     * 
     */
    private javax.swing.JComboBox<PluginConnector> formatComboBox;
    /**
     * 
     */
    private javax.swing.JTextArea formatDescriptionTextArea;
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
    private javax.swing.JScrollPane jScrollPane1;
    /**
     * 
     */
    private javax.swing.JLabel jobAssignmentAlgorithmLabel;
    /**
     * 
     */
    private javax.swing.JButton nextButton;
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
    private javax.swing.JPanel stepsPanel;
    /**
     * 
     */
    private javax.swing.JLabel stepsTitle;
    // End of variables declaration//GEN-END:variables

    /**
     * 
     */
    public final void getValidConnectors() {
        PluginConnector[] connectors = Application.getPluginConnectors();
        validConnectors = new ArrayList<PluginConnector>();
        for (int c = 0; c < connectors.length; c++) {
            if (connectors[c].hasJobResultDataExportClass()) {
                validConnectors.add(connectors[c]);
            }
        }
    }
    /**
     * 
     * @return connectors
     */
    private ComboBoxModel<PluginConnector> getPluginConnectorsComboBoxModel() {
        ComboBoxModel<PluginConnector> m = 
        		new DefaultComboBoxModel<PluginConnector>(
        		validConnectors.toArray(new PluginConnector[]{}));
        formatDescriptionTextArea.setText(
        		((PluginConnector) m.getSelectedItem()).getDescription());
        formatDescriptionTextArea.setCaretPosition(0);
        return m;
    }
}
