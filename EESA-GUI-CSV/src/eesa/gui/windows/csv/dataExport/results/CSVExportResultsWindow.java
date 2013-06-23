/*
 * CSVExportResultsWindow.java
 *
 * Created on 04-Apr-2012, 20:30:23
 */
package eesa.gui.windows.csv.dataExport.results;

import eesa.csv.dataExport.CSVJobResultDataExport;
import eesa.gui.windows.dataExport.results.AbstractExportResultsWindow;

/**
 * Enables the user to select the destination file and the delimeter.
 * @author Philip
 */
public class CSVExportResultsWindow extends AbstractExportResultsWindow {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    private final CSVJobResultDataExport data;

    /** Creates new form CSVExportResultsWindow.
     * @param d data 
     */
    public CSVExportResultsWindow(final CSVJobResultDataExport d) {
        this.data = d;
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
