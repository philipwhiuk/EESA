
/*
 * XMLOutputExportJobsWindow.java
 *
 * Created on 04-Apr-2012, 20:20:08
 */

package eesa.gui.windows.xml.dataExport.jobs;

import com.whiuk.philip.eesa.exceptions.XMLException;
import com.whiuk.philip.eesa.xml.dataExport.XMLJobDataExport;
import eesa.gui.help.HelpManager;
import eesa.gui.windows.AbstractProcessWindow;

import java.io.IOException;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

/**
 * Allows the user to select the XML element to use. 
 * @author Philip
 */
public class XMLOutputExportJobsWindow extends AbstractProcessWindow {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    /**
     * 
     */
    private final XMLJobDataExport data;
    /**
     * 
     */
    private final String filePath;
    /**
     * 
     */
    private final String[] elements;

    /** 
     * Creates new form XMLOutputExportJobsWindow.
     * @param data
     * @throws IOException
     * @throws XMLException  
     */
    public XMLOutputExportJobsWindow(final XMLJobDataExport data) throws IOException, XMLException {
        this.data = data;
        this.filePath = data.getSource().getCanonicalPath();
        this.elements = data.getDocumentTagNames();
        initComponents();
        HelpManager.addHelpForClassToButton(helpButton, XMLOutputExportJobsWindow.class);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {

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
        jLabel2 = new javax.swing.JLabel();
        heading = new javax.swing.JLabel();
        dataSourceLabel = new javax.swing.JLabel();
        xmlFileLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jobElementSelectComboBox = new javax.swing.JComboBox<String>();

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

        step3.setFont(new java.awt.Font("Tahoma", 1, eesa.gui.Application.STEP_FONT_SIZE)); // NOI18N
        step3.setText("3. Customise Output");

        step4.setText("4. Map Data");

        jLabel2.setText("5. View Ouput");

        org.jdesktop.layout.GroupLayout stepsPanelLayout = new org.jdesktop.layout.GroupLayout(stepsPanel);
        stepsPanel.setLayout(stepsPanelLayout);
        stepsPanelLayout.setHorizontalGroup(
            stepsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(stepsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(stepsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(stepsTitle)
                    .add(step2)
                    .add(step1)
                    .add(step3)
                    .add(step4)
                    .add(jLabel2))
                .addContainerGap(13, Short.MAX_VALUE))
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
                .add(step3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(step4)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel2)
                .addContainerGap(135, Short.MAX_VALUE))
        );

        heading.setFont(new java.awt.Font("Tahoma", 1, eesa.gui.Application.HEADING_FONT_SIZE)); // NOI18N
        heading.setText("Customise XML Data Output");

        dataSourceLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        dataSourceLabel.setText("Data Source:");

        xmlFileLabel.setText(getFilePath());

        jLabel1.setText("Job Element");

        jobElementSelectComboBox.setModel(getElementSelectorBoxModel());

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(171, Short.MAX_VALUE)
                        .add(backButton2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(nextButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(finishButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cancelButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(helpButton))
                    .add(layout.createSequentialGroup()
                        .add(stepsPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(heading)
                            .add(layout.createSequentialGroup()
                                .add(jLabel1)
                                .add(18, 18, 18)
                                .add(jobElementSelectComboBox, 0, 213, Short.MAX_VALUE))
                            .add(layout.createSequentialGroup()
                                .add(dataSourceLabel)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(xmlFileLabel)))
                        .add(46, 46, 46)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(stepsPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(heading)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(dataSourceLabel)
                            .add(xmlFileLabel))
                        .add(13, 13, 13)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel1)
                            .add(jobElementSelectComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(helpButton)
                    .add(backButton2)
                    .add(nextButton)
                    .add(finishButton)
                    .add(cancelButton))
                .addContainerGap())
        );

        pack();
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
        // Do Nothing
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
        updateData();
        new XMLViewExportJobsWindow(data).setVisible(true);
        dispose();
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
    private javax.swing.JLabel dataSourceLabel;
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
    private javax.swing.JLabel jLabel2;
    /**
     * 
     */
    private javax.swing.JComboBox<String> jobElementSelectComboBox;
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
    /**
     * 
     */
    private javax.swing.JLabel xmlFileLabel;
    // End of variables declaration//GEN-END:variables

    /**
     * 
     */
    private void updateData() {
        data.setJobElementTagName((String) jobElementSelectComboBox.getSelectedItem());
    }

    /**
     * 
     * @return
     */
    private String getFilePath() {
        return filePath;
    }

    /**
     * 
     * @return
     */
    private ComboBoxModel<String> getElementSelectorBoxModel() {
        return new DefaultComboBoxModel<String>(elements);
    }

}
