/*
 * CSVViewExportJobsWindow.java
 *
 * Created on 04-Apr-2012, 20:21:13
 */
package eesa.gui.windows.csv.dataExport.jobs;

import eesa.csv.CSVException;
import eesa.csv.dataExport.CSVJobDataExport;
import eesa.gui.help.HelpManager;
import eesa.gui.windows.AbstractProcessWindow;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Allows the user to view the data prior to export.
 * @author Philip
 */
public class CSVViewExportJobsWindow extends AbstractProcessWindow {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    private CSVJobDataExport data;

    /**
     * Creates new form CSVViewExportJobsWindow.
     * @param data 
     */
    public CSVViewExportJobsWindow(final CSVJobDataExport data) {
        this.data = data;
        initComponents();
        HelpManager.addHelpForClassToButton(helpButton, CSVViewExportJobsWindow.class);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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

        step2.setFont(new java.awt.Font("Tahoma", 2, eesa.gui.Application.STEP_FONT_SIZE)); // NOI18N
        step2.setText("2. Select Destination");

        step3.setFont(new java.awt.Font("Tahoma", 2, eesa.gui.Application.STEP_FONT_SIZE)); // NOI18N
        step3.setText("3. Customise Output");

        step4.setFont(new java.awt.Font("Tahoma", 1, eesa.gui.Application.STEP_FONT_SIZE)); // NOI18N
        step4.setText("4. View Exported Data");

        javax.swing.GroupLayout stepsPanelLayout = new javax.swing.GroupLayout(stepsPanel);
        stepsPanel.setLayout(stepsPanelLayout);
        stepsPanelLayout.setHorizontalGroup(
            stepsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stepsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(stepsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(stepsTitle)
                    .addComponent(step4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(step1)
                    .addComponent(step3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(step2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
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
                .addComponent(step3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(step4)
                .addContainerGap(145, Short.MAX_VALUE))
        );

        heading.setFont(new java.awt.Font("Tahoma", 1,
        		eesa.gui.Application.HEADING_FONT_SIZE)); // NOI18N
        heading.setText("View CSV Output");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(240, Short.MAX_VALUE)
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
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(heading, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(180, 180, 180))
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(stepsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(eesa.gui.Application.GAP, eesa.gui.Application.GAP, eesa.gui.Application.GAP))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(heading)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(helpButton)
                    .addComponent(backButton2)
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
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
    private void backButton2ActionPerformed(final java.awt.event.ActionEvent evt) {
        //Do Nothing
}

    /**
     * 
     * @param evt
     */
    private void finishButtonActionPerformed(final java.awt.event.ActionEvent evt) {
        try {
            exportData();
            setVisible(false);
            dispose();
        } catch (CSVException ex) {
            Logger.getLogger(CSVViewExportJobsWindow.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Export Error", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
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
    private void nextButtonActionPerformed(final java.awt.event.ActionEvent evt) {
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
    private javax.swing.JScrollPane jScrollPane1;
    /**
     * 
     */
    private javax.swing.JTextArea jTextArea1;
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
    private void exportData() throws CSVException {
        data.performExport();
    }
}
