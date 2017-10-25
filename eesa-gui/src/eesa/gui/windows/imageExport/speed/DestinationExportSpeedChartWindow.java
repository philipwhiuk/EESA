package eesa.gui.windows.imageExport.speed;

import eesa.gui.Application;
import eesa.gui.fileFilters.ImageFileFilter;
import eesa.gui.windows.AbstractProcessWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileFilter;

/**
 * Allows the user to select the destination of the speed chart image.
 * @author Philip
 */
public class DestinationExportSpeedChartWindow extends AbstractProcessWindow {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Filter.
	 */
    private FileFilter fileSourceFilter;
    /**
     * Export data.
     */
    private SpeedImageExport data;

    /**
     * Creates new form DestinationExportSpeedChartWindow.
     * @param e data
     */
    public DestinationExportSpeedChartWindow(final SpeedImageExport e) {
        this.data = e;
    }

    /**
     * This method is called from within the constructor to initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void initComponents() {
        fileSourceField = new JTextField();
        stepsPanel = new JPanel();
        stepsTitle = new JLabel();
        step1 = new JLabel();
        step2 = new JLabel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        fileSourceLabel = new JLabel();
        helpButton = new JButton();
        nextButton = new JButton();
        finishButton = new JButton();
        cancelButton = new JButton();
        backButton = new JButton();
        heading = new JLabel();
        browseButton = new JButton();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        stepsPanel.setBackground(new java.awt.Color(255, 255, 255));
        stepsTitle.setFont(new java.awt.Font("Tahoma", 1, eesa.gui.Application.STEP_FONT_SIZE)); // NOI18N
        stepsTitle.setText("Steps");
        step1.setFont(new java.awt.Font("Tahoma", 2, eesa.gui.Application.STEP_FONT_SIZE)); // NOI18N
        step1.setText("1. Select Sources");
        step2.setFont(new java.awt.Font("Tahoma", 2, eesa.gui.Application.STEP_FONT_SIZE)); // NOI18N
        step2.setText("2. Select Chart Split Type");
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, eesa.gui.Application.STEP_FONT_SIZE)); // NOI18N
        jLabel1.setText("3. Select Destination");
        jLabel2.setText("4. View Output");
        
        buildStepsPanelLayout();
        
        fileSourceLabel.setText("File Destination:");
        
        helpButton.setText("Help");
        helpButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                helpButtonActionPerformed(evt);
            }
        });

        nextButton.setText("Next");
        nextButton.setEnabled(false);
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        finishButton.setText("Finish");
        finishButton.setEnabled(false);
        finishButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                finishButtonActionPerformed(evt);
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

        heading.setFont(new java.awt.Font("Tahoma", 1, eesa.gui.Application.HEADING_FONT_SIZE)); // NOI18N
        heading.setText("Select Image File Destination");

        browseButton.setText("Browse");
        browseButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });
        buildLayout();
        
        pack();
    }
    /**
     * 
     */
    private void buildStepsPanelLayout() {
    	GroupLayout stepsPanelLayout = new GroupLayout(stepsPanel);
	    stepsPanel.setLayout(stepsPanelLayout);
	    stepsPanelLayout.setHorizontalGroup(
	        stepsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	        .addGroup(stepsPanelLayout.createSequentialGroup()
	            .addContainerGap()
	            .addGroup(stepsPanelLayout.createParallelGroup(
	            		GroupLayout.Alignment.LEADING)
	                .addComponent(stepsTitle)
	                .addComponent(step2)
	                .addComponent(step1)
	                .addComponent(jLabel1)
	                .addComponent(jLabel2))
	            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	    );
	    stepsPanelLayout.setVerticalGroup(
	        stepsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	        .addGroup(stepsPanelLayout.createSequentialGroup()
	            .addContainerGap()
	            .addComponent(stepsTitle)
	            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	            .addComponent(step1)
	            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	            .addComponent(step2)
	            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	            .addComponent(jLabel1)
	            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	            .addComponent(jLabel2)
	            .addContainerGap(156, Short.MAX_VALUE))
	    );
    }
    /**
     * Builds the overall layout.
     */
    private void buildLayout() {
    	GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(
            		GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(stepsPanel,
                		GroupLayout.PREFERRED_SIZE,
                		GroupLayout.DEFAULT_SIZE,
                		GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(
                		GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(heading)
                        .addGap(0, 182, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fileSourceLabel)
                        .addPreferredGap(
                        		LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fileSourceField)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(browseButton)
                        .addContainerGap())))
            .addGroup(GroupLayout.Alignment.TRAILING,
            		layout.createSequentialGroup()
                .addContainerGap(190, Short.MAX_VALUE)
                .addComponent(backButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nextButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(finishButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(helpButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(
                		GroupLayout.Alignment.LEADING)
                    .addComponent(stepsPanel,
                    		GroupLayout.PREFERRED_SIZE,
                    		GroupLayout.DEFAULT_SIZE,
                    		GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(heading)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(
                        		GroupLayout.Alignment.BASELINE)
                            .addComponent(fileSourceLabel)
                            .addComponent(fileSourceField,
                            		GroupLayout.PREFERRED_SIZE,
                            		GroupLayout.DEFAULT_SIZE,
                            		GroupLayout.PREFERRED_SIZE)
                            .addComponent(browseButton))))
                .addPreferredGap(
                		LayoutStyle.ComponentPlacement.RELATED,
                		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(
                		GroupLayout.Alignment.BASELINE)
                    .addComponent(helpButton)
                    .addComponent(backButton)
                    .addComponent(nextButton)
                    .addComponent(finishButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );    	
    }
    /**
     * Responds to help button.
     * @param evt Click event
     */
    private void helpButtonActionPerformed(final ActionEvent evt) {
    	//GEN-FIRST:event_helpButtonActionPerformed

   }
    /**
     * Responds to next button.
     * @param evt Click event
     */
    private void nextButtonActionPerformed(final ActionEvent evt) {
    	//GEN-FIRST:event_nextButtonActionPerformed
        updateData();
        new OutputExportSpeedChartWindow(data).setVisible(true);
    }
    /**
     * Responds to finish button.
     * @param evt Click event
     */
    private void finishButtonActionPerformed(final ActionEvent evt) {
    	//GEN-FIRST:event_finishButtonActionPerformed
        // Do Nothing
    }
    /**
     * Respond to cancel button.
     * @param evt Click event
     */
    private void cancelButtonActionPerformed(final ActionEvent evt) {
    	//GEN-FIRST:event_cancelButtonActionPerformed
        setVisible(false);
        dispose();
    }
    /**
     * Respond to back button.
     * @param evt Click event
     */
    private void backButtonActionPerformed(final ActionEvent evt) {
    	//GEN-FIRST:event_backButtonActionPerformed
        // Do Nothing
    }
    /**
     * Respond to browse button.
     * @param evt Click event
     */
    private void browseButtonActionPerformed(final ActionEvent evt) {
    	//GEN-FIRST:event_browseButtonActionPerformed
        ArrayList<FileFilter> enabledFilters = new ArrayList<FileFilter>();
        ImageFileFilter[] filters = Application.getImageFilters();        
        String[] writerFormatNames = ImageIO.getWriterFormatNames();
        for (int w = 0; w < writerFormatNames.length; w++) {
            boolean supported = false;
            int f = 0;
            while (f < filters.length && !supported) {
                if (filters[f].supports(writerFormatNames[w])) {
                    filters[f].addFormatName(writerFormatNames[w]);
                    if (!enabledFilters.contains(filters[f])) {
                        enabledFilters.add(filters[f]);
                    }
                    supported = true;
                }
                f++;
            }
        }
        JFileChooser c = new JFileChooser();
        Iterator<FileFilter> i = enabledFilters.iterator();
        while (i.hasNext()) {
            c.addChoosableFileFilter(i.next());
        }
        int returnVal = c.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            fileSourceField.setText(c.getSelectedFile().getAbsolutePath());
            fileSourceFilter = c.getFileFilter();
        }
        updateNext();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
     * Back button.
     */
    private JButton backButton;
    /**
     * Browse button.
     */
    private JButton browseButton;
    /**
     * Cancel button.
     */
    private JButton cancelButton;
    /**
     * File source.
     */
    private JTextField fileSourceField;
    /**
     * File source label.
     */
    private JLabel fileSourceLabel;
    /**
     * Finish button.
     */
    private JButton finishButton;
    /**
     * Heading.
     */
    private JLabel heading;
    /**
     * Help button.
     */
    private JButton helpButton;
    /**
     * Empty label.
     */
    private JLabel jLabel1;
    /**
     * Empty label.
     */    
    private JLabel jLabel2;
    /**
     * Next button.
     */
    private JButton nextButton;
    /**
     * Step 1 Label.
     */
    private JLabel step1;
    /**
     * Step 2 Label.
     */    
    private JLabel step2;
    /**
     * Steps Panel.
     */    
    private JPanel stepsPanel;
    /**
     * Steps title.
     */
    private JLabel stepsTitle;
    // End of variables declaration//GEN-END:variables

    /**
     * 
     */
    private void updateData() {
        data.setSource(fileSourceField.getText());
        data.setFilter((ImageFileFilter) fileSourceFilter);
    }

    /**
     * 
     */
    private void updateNext() {
        nextButton.setEnabled(!fileSourceField.getText().equals(""));
    }
}