
/*
 * XMLMapImportJobsWindow.java
 *
 * Created on 07-Apr-2012, 17:03:14
 */
package eesa.gui.windows.xml.dataImport.jobs;

import com.whiuk.philip.eesa.dataImport.JobDataImport;
import com.whiuk.philip.eesa.exceptions.InvalidMappingException;
import com.whiuk.philip.eesa.exceptions.JobException;
import com.whiuk.philip.eesa.exceptions.XMLException;
import eesa.gui.help.HelpManager;
import eesa.gui.tables.DataMapTableHeader;
import eesa.gui.tables.DataMapTableHeaderComboCellRenderer;
import eesa.gui.tables.DataMapTableModel;
import com.whiuk.philip.eesa.xml.dataImport.XMLJobDataImport;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

/**
 * Allows the user to map the XML data to EESA data.
 * @author Philip
 */
public class XMLMapImportJobsWindow extends javax.swing.JFrame {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    private final XMLJobDataImport data;

    /** Creates new form XMLMapImportJobsWindow.
     * @param data
     */
    public XMLMapImportJobsWindow(final XMLJobDataImport data) {
        this.data = data;
        initComponents();
        HelpManager.addHelpForClassToButton(helpButton, XMLMapImportJobsWindow.class);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        stepsPanel = new javax.swing.JPanel();
        stepsTitle = new javax.swing.JLabel();
        step1 = new javax.swing.JLabel();
        step2 = new javax.swing.JLabel();
        step3 = new javax.swing.JLabel();
        step4 = new javax.swing.JLabel();
        step5 = new javax.swing.JLabel();
        heading = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        finishButton = new javax.swing.JButton();
        helpButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataMapTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        stepsPanel.setBackground(new java.awt.Color(255, 255, 255));

        stepsTitle.setFont(new java.awt.Font("Tahoma", 1, eesa.gui.Application.STEP_FONT_SIZE)); // NOI18N
        stepsTitle.setText("Steps");

        step1.setFont(new java.awt.Font("Tahoma", 2, eesa.gui.Application.STEP_FONT_SIZE)); // NOI18N
        step1.setText("1. Select Type");

        step2.setFont(new java.awt.Font("Tahoma", 2, eesa.gui.Application.STEP_FONT_SIZE)); // NOI18N
        step2.setText("2. Select Source");

        step3.setFont(new java.awt.Font("Tahoma", 2, eesa.gui.Application.STEP_FONT_SIZE)); // NOI18N
        step3.setText("3. Customise Retrieval");

        step4.setFont(new java.awt.Font("Tahoma", 1, eesa.gui.Application.STEP_FONT_SIZE)); // NOI18N
        step4.setText("4. Map Data");

        step5.setText("5. View Results");

        javax.swing.GroupLayout stepsPanelLayout = new javax.swing.GroupLayout(stepsPanel);
        stepsPanel.setLayout(stepsPanelLayout);
        stepsPanelLayout.setHorizontalGroup(
            stepsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stepsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(stepsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stepsTitle)
                    .addComponent(step2)
                    .addComponent(step3)
                    .addComponent(step4)
                    .addComponent(step1)
                    .addComponent(step5))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(step5)
                .addContainerGap(156, Short.MAX_VALUE))
        );

        heading.setFont(new java.awt.Font("Tahoma", 1, eesa.gui.Application.HEADING_FONT_SIZE)); // NOI18N
        heading.setText("Map XML Data");

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.setEnabled(false);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        finishButton.setText("Finish");
        finishButton.setEnabled(false);
        finishButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                finishButtonActionPerformed(evt);
            }
        });

        helpButton.setText("Help");
        helpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                helpButtonActionPerformed(evt);
            }
        });

        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        dataMapTable.setModel(getDataMapTableModel());
        dataMapTable.setTableHeader(getDataMapTableHeader());
        jScrollPane1.setViewportView(dataMapTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(stepsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(heading)
                        .addGap(424, 424, 424))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(346, Short.MAX_VALUE)
                .addComponent(backButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nextButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(finishButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(helpButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(stepsPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(heading)
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        try {
            updateData();
        } catch (InvalidMappingException ex) {
            Logger.getLogger(XMLMapImportJobsWindow.class.getName()).log(Level.INFO, null, ex);
            JOptionPane.showMessageDialog(this, "An invalid mapping was selected, discarding", "Import Error", JOptionPane.ERROR_MESSAGE);
        }
        try {
            new XMLRetrievalImportJobsWindow(data).setVisible(true);
        } catch (IOException ex) {
            new XMLImportJobsWindow(data).setVisible(true);
        } catch (XMLException ex) {
            new XMLImportJobsWindow(data).setVisible(true);
        }
        dispose();
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
    private void helpButtonActionPerformed(final java.awt.event.ActionEvent evt) {
}
    /**
     * 
     * @param evt
     */
    private void nextButtonActionPerformed(final java.awt.event.ActionEvent evt) {
        try {
            updateData();
        } catch (InvalidMappingException ex) {
            Logger.getLogger(XMLMapImportJobsWindow.class.getName()).log(Level.INFO, null, ex);
            JOptionPane.showMessageDialog(this, "An invalid mapping was selected", "Import Error", JOptionPane.ERROR_MESSAGE);
        }
        try {
            new XMLResultsImportJobsWindow(data).setVisible(true); 
            dispose();
        } catch (XMLException ex) {
            Logger.getLogger(XMLMapImportJobsWindow.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "XML Parser Error: " + ex.getMessage(), "Database Error", WIDTH);

        } catch (JobException ex) {
            Logger.getLogger(XMLMapImportJobsWindow.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Unable to parse one or more jobs:" + ex.getMessage(), "Import Error", WIDTH);
        }
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
    private javax.swing.JTable dataMapTable;
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
    private javax.swing.JLabel step5;
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
     * @throws InvalidMappingException
     */
    private void updateData() throws InvalidMappingException {
        boolean[] parameters = new boolean[JobDataImport.Choice.COUNT];
        int[] columnKeys = new int[JobDataImport.Choice.COUNT];
        HashMap<String, Integer> fields = JobDataImport.Choice.getFields();        
        for (int c = 0; c < dataMapTable.getModel().getColumnCount(); c++) {            
            String colName = dataMapTable.getModel().getColumnName(c);
            if (JobDataImport.Choice.getFields().containsKey(colName)) {
                parameters[fields.get(colName)] = true;
                columnKeys[fields.get(colName)] = c;
            }
        }
        if (
           (parameters[JobDataImport.Choice.RELEASE]
        		   && parameters[JobDataImport.Choice.DEADLINE]
        				   && parameters[JobDataImport.Choice.WEIGHT]) 
            ||
           (parameters[JobDataImport.Choice.RELEASE]
        		   && parameters[JobDataImport.Choice.DEADLINE]
        				   && parameters[JobDataImport.Choice.DENSITY])
            ||
           (parameters[JobDataImport.Choice.RELEASE]
        		   && parameters[JobDataImport.Choice.LENGTH]
        				   && parameters[JobDataImport.Choice.WEIGHT])
            ||
           (parameters[JobDataImport.Choice.RELEASE]
        		   && parameters[JobDataImport.Choice.LENGTH]
        				   && parameters[JobDataImport.Choice.DENSITY])
            ||
           (parameters[JobDataImport.Choice.DEADLINE]
        		   && parameters[JobDataImport.Choice.LENGTH]
        				   && parameters[JobDataImport.Choice.WEIGHT])
            ||
           (parameters[JobDataImport.Choice.DEADLINE]
        		   && parameters[JobDataImport.Choice.LENGTH]
        				   && parameters[JobDataImport.Choice.DENSITY])
                    ) {
            data.setParameters(parameters);
            data.setColumnKeys(columnKeys);
        } else { 
        	throw new InvalidMappingException();
        }
    }
    /**
     * 
     * @return
     */
    private TableModel getDataMapTableModel() {
        return new DataMapTableModel(data.getMappingData(), data.getColumns());
    }

    /**
     * 
     * @return
     */
    private JTableHeader getDataMapTableHeader() {
        return new DataMapTableHeader(dataMapTable.getColumnModel(),
        		getDataMapComboBoxes(), getDataMapRenderers());
    }
    /**
     * 
     * @return
     */
    private JComboBox<String>[] getDataMapComboBoxes() {
        int columns = data.getNumColumns();
        /*
         * Only way to do this.
         */
        @SuppressWarnings("unchecked")
		JComboBox<String>[] comboBoxes = new JComboBox[columns];
        for (int c = 0; c < columns; c++) {
            comboBoxes[c] = new JComboBox<String>(data.getChoices(c));
        }
        return comboBoxes;
    }
    /**
     * 
     * @return
     */
    private DataMapTableHeaderComboCellRenderer[] getDataMapRenderers() {
        int columns = data.getNumColumns();
        DataMapTableHeaderComboCellRenderer[] renderers = new DataMapTableHeaderComboCellRenderer[columns];
        for (int c = 0; c < columns; c++) {
            renderers[c] = new DataMapTableHeaderComboCellRenderer(data.getChoices(c));
        }
        return renderers;
    }
}
