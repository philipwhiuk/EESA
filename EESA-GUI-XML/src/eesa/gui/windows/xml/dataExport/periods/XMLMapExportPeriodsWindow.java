package eesa.gui.windows.xml.dataExport.periods;

import eesa.exceptions.InvalidMappingException;
import eesa.exceptions.XMLException;
import eesa.gui.tables.DataMapTableHeader;
import eesa.gui.tables.DataMapTableHeaderComboCellRenderer;
import eesa.gui.tables.DataMapTableModel;
import eesa.xml.dataExport.XMLPeriodDataExport;
import java.util.ArrayList;
import java.util.List;
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
public class XMLMapExportPeriodsWindow extends javax.swing.JFrame {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    private final XMLPeriodDataExport data;

    /**
     * Creates new form XMLMapExportPeriodsWindow.
     * @param data 
     */
    public XMLMapExportPeriodsWindow(final XMLPeriodDataExport data) {
        this.data = data;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        stepsPanel = new javax.swing.JPanel();
        stepsTitle = new javax.swing.JLabel();
        step1 = new javax.swing.JLabel();
        step2 = new javax.swing.JLabel();
        step3 = new javax.swing.JLabel();
        step4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nextButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        finishButton = new javax.swing.JButton();
        helpButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        heading = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataMapTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
        step4.setText("4. Map Data");

        jLabel1.setText("5. View Exported Data");

        javax.swing.GroupLayout stepsPanelLayout = new javax.swing.GroupLayout(stepsPanel);
        stepsPanel.setLayout(stepsPanelLayout);
        stepsPanelLayout.setHorizontalGroup(
            stepsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stepsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(stepsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(stepsTitle)
                    .addComponent(step2)
                    .addComponent(step4)
                    .addComponent(step1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(step3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        nextButton.setText("Next");
        nextButton.setEnabled(false);
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
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

        backButton.setText("Back");
        backButton.setEnabled(false);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        heading.setFont(new java.awt.Font("Tahoma", 1, eesa.gui.Application.HEADING_FONT_SIZE)); // NOI18N
        heading.setText("Map Periods to XML");

        dataMapTable.setModel(getDataMapTableModel());
        dataMapTable.setTableHeader(getDataMapTableHeader());
        jScrollPane1.setViewportView(dataMapTable);

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
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(heading)
                                .addGap(414, 414, 414))
                            .addComponent(jScrollPane1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap()
                .addComponent(heading)
                .addGap(eesa.gui.Application.GAP, eesa.gui.Application.GAP, eesa.gui.Application.GAP)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(helpButton)
                    .addComponent(backButton)
                    .addComponent(nextButton)
                    .addComponent(finishButton)
                    .addComponent(cancelButton))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(stepsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(40, 40, 40))
        );

        pack();
    }
    /**
     * 
     * @param evt
     */
    private void nextButtonActionPerformed(final java.awt.event.ActionEvent evt) {
        try {
            updateData();
            new XMLViewExportPeriodsWindow(data).setVisible(true);
            dispose();
        } catch (InvalidMappingException ex) {
            Logger.getLogger(XMLMapExportPeriodsWindow.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Mapping Error Occured", "Mapping Error: " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);            
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
    private void backButtonActionPerformed(final java.awt.event.ActionEvent evt) {
        //Do Nothing
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
    private javax.swing.JLabel jLabel1;
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
        int[] columnKeys = new int[data.getChoices().size()];
        boolean[] parameters = new boolean[data.getChoices().size()];
        for (int c = 0; c < dataMapTable.getModel().getColumnCount(); c++) {
            String colName = dataMapTable.getModel().getColumnName(c);
            List<String> choices = data.getChoices();
            if (choices.contains(colName)) {
                parameters[choices.indexOf(colName)] = true;
                columnKeys[choices.indexOf(colName)] = c;
            }
            data.setParameters(parameters);
            data.setColumnKeys(columnKeys);            
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
        @SuppressWarnings("unchecked")
		JComboBox<String>[] comboBoxes = new JComboBox[columns];
        for (int c = 0; c < columns; c++) {
            comboBoxes[c] = new JComboBox<String>(data.getChoicesForIndex(c));
        }
        return comboBoxes;
    }
    /**
     * 
     * @throws InvalidMappingException 
     */
    private void exportData() throws InvalidMappingException, XMLException {
        updateData();
        data.performExport();
    }
    /**
     * 
     * @return 
     */
    private DataMapTableHeaderComboCellRenderer[] getDataMapRenderers() {
        int columns = data.getNumColumns();
        DataMapTableHeaderComboCellRenderer[] renderers = new DataMapTableHeaderComboCellRenderer[columns];
        for (int c = 0; c < columns; c++) {
            renderers[c] = new DataMapTableHeaderComboCellRenderer(data.getChoicesForIndex(c));
        }
        return renderers;
    }
}
