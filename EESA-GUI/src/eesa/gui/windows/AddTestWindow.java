/*
 * AddTestWindow.java
 *
 * Created on 20-Nov-2011, 00:22:16
 */
package eesa.gui.windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import eesa.gui.Application;
import com.whiuk.philip.eesa.algorithms.AssignmentAndScalingAlgorithm;
import com.whiuk.philip.eesa.algorithms.EESAAlgorithm;
import com.whiuk.philip.eesa.algorithms.JobAssignmentAlgorithm;
import com.whiuk.philip.eesa.algorithms.SpeedScalingAlgorithm;
import com.whiuk.philip.eesa.core.Simulation;
import eesa.gui.help.HelpManager;
import eesa.gui.windows.algorithms.EESAAlgorithmPanel;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

/**
 * Controls the creation and usage of the "Add Test" window,
 * allowing users to select a JobAssignment and SpeedScaling
 * Algorithm to run against the jobs.
 * @author Philip
 */
public class AddTestWindow extends JFrame {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    private final Simulation simulation;
    /**
     * 
     */
    private final Application app;
    /**
     * 
     */
    private JScrollPane eesaAlgorithmDescriptionScrollPane;
    /**
     * 
     */
    private JComboBox<EESAAlgorithmPanel> eesaAlgorithmPanelComboBox;
    /**
     * 
     */
    private JTextArea eesaAlgorithmDescriptionTextArea;
    /**
     * 
     */
    private JLabel eesaAlgorithmLabel;
    /**
     * Algorithm panel.
     */
    private EESAAlgorithmPanel eesaAlgorithmPanel;

    /** Creates new AddTestWindow form.
     * @param a 
     * @param sim 
     */
    public AddTestWindow(final Application a, final Simulation sim) {
        this.app = a;
        this.simulation = sim;
        initComponents();
        HelpManager.addHelpForClassToButton(helpButton, AddTestWindow.class);
    }

    /** This method is called from within the constructor to
     * initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {
    	eesaAlgorithmLabel = new JLabel();
    	eesaAlgorithmPanelComboBox = new JComboBox<EESAAlgorithmPanel>();
    	eesaAlgorithmLabel.setText("Scheduling Algorithm");
    	
    	eesaAlgorithmDescriptionScrollPane = new JScrollPane();
    	eesaAlgorithmDescriptionTextArea = new JTextArea();
    	
    	eesaAlgorithmDescriptionTextArea.setColumns(20);
    	eesaAlgorithmDescriptionTextArea.setEditable(false);
    	eesaAlgorithmDescriptionTextArea.setFont(
        		new java.awt.Font("Arial", 0,
        				eesa.gui.Application.FONT_SIZE)); // NOI18N
    	eesaAlgorithmDescriptionTextArea.setLineWrap(true);
    	eesaAlgorithmDescriptionTextArea.setRows(5);
    	eesaAlgorithmDescriptionTextArea.setWrapStyleWord(true);
    	eesaAlgorithmDescriptionScrollPane.setViewportView(eesaAlgorithmDescriptionTextArea);


    	eesaAlgorithmPanelComboBox.setModel(
    			getEESAAlgorithmPanelsComboBoxModel());
    	eesaAlgorithmPanelComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                eesaAlgorithmComboBoxActionPerformed(evt);
            }
        });   	
    	
    	eesaAlgorithmPanel = (EESAAlgorithmPanel) eesaAlgorithmPanelComboBox.getSelectedItem();
    	eesaAlgorithmDescriptionTextArea.setText(eesaAlgorithmPanel.getAlgorithm().getDescription());
    	eesaAlgorithmDescriptionTextArea.setCaretPosition(0);
    	
        addTestButton = new JButton();
        header = new JLabel();
        cancelButton = new JButton();
        helpButton = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        addTestButton.setText("Submit");
        addTestButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                addTestButtonActionPerformed(evt);
            }
        });


        header.setFont(new java.awt.Font("Tahoma", 1,
        		eesa.gui.Application.HEADING_FONT_SIZE)); // NOI18N
        header.setText("Add Test");

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        helpButton.setText("Help");
        buildLayout();
        pack();
    }
    /**
     * 
     */
    private void buildLayout() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(
                		GroupLayout.Alignment.LEADING)
                    .addComponent(header)
                    .addGroup(layout.createParallelGroup(
                    		GroupLayout.Alignment.TRAILING, false)
                        .addGroup(GroupLayout.Alignment.LEADING,
                        		layout.createSequentialGroup()
                            .addComponent(addTestButton)
                            .addPreferredGap(
                            		LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cancelButton)
                            .addPreferredGap(
                            		LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(helpButton))
                        .addComponent(eesaAlgorithmDescriptionScrollPane,
                        		GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.LEADING,
                        		layout.createSequentialGroup()
                            .addComponent(eesaAlgorithmLabel)
                            .addPreferredGap(
                            		LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(eesaAlgorithmPanelComboBox, 0,
                            		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                		.addComponent(eesaAlgorithmPanel,
                    		GroupLayout.Alignment.LEADING)
                    )
            	)
    		)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(header)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(
                		GroupLayout.Alignment.BASELINE)
                    .addComponent(eesaAlgorithmLabel)
                    .addComponent(eesaAlgorithmPanelComboBox,
                    		GroupLayout.PREFERRED_SIZE,
                    		GroupLayout.DEFAULT_SIZE,
                    		GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eesaAlgorithmDescriptionScrollPane,
                		GroupLayout.PREFERRED_SIZE, 51,
                		GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eesaAlgorithmPanel, 
                		GroupLayout.PREFERRED_SIZE, 51,
                		GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(
                		GroupLayout.Alignment.BASELINE)
                    .addComponent(addTestButton)
                    .addComponent(cancelButton)
                    .addComponent(helpButton))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
	}

	/**
     * 
     * @param evt 
     */
    private void addTestButtonActionPerformed(final ActionEvent evt) {
       simulation.addTest(eesaAlgorithmPanel.getAlgorithm());
       app.validate();
       setVisible(false);
       dispose();
    }


    /**
     * 
     * @param evt event
     */
    private void cancelButtonActionPerformed(final ActionEvent evt) {
        setVisible(false);
        dispose();
    }

    /**
     * 
     */
    private JButton addTestButton;
    /**
     * 
     */
    private JButton cancelButton;
    /**
     * 
     */
    private JLabel header;
    /**
     * 
     */
    private JButton helpButton;
    // End of variables declaration//GEN-END:variables
    /**
     * 
     * @return model
     */
    private ComboBoxModel<EESAAlgorithmPanel>
    		getEESAAlgorithmPanelsComboBoxModel() {
        ComboBoxModel<EESAAlgorithmPanel> m = 
        		new DefaultComboBoxModel<EESAAlgorithmPanel>(
        				EESAAlgorithmPanel.getEESAAlgorithmPanels()); 
        if (m.getSelectedItem() != null) {
        	eesaAlgorithmDescriptionTextArea.setText(((
        			EESAAlgorithmPanel) m.getSelectedItem())
        			.getAlgorithm().getDescription());
        } else {
        	eesaAlgorithmDescriptionTextArea.setText("");
        	
        }
        eesaAlgorithmDescriptionTextArea.setCaretPosition(0);
        return m;
        
    }
    /**
     * 
     * @param evt 
     */
    private void eesaAlgorithmComboBoxActionPerformed(final ActionEvent evt) {
    	SwingUtilities.invokeLater(new Runnable() {
    		public void run() {
	            EESAAlgorithmPanel selected = (EESAAlgorithmPanel)
	            		eesaAlgorithmPanelComboBox.getSelectedItem();
	            eesaAlgorithmDescriptionTextArea.setText(
	            		selected.getAlgorithm().getDescription());
	            eesaAlgorithmDescriptionTextArea.setCaretPosition(0);
	            System.out.println(eesaAlgorithmPanel);
	            eesaAlgorithmPanel = selected;
	            removeAll();
	            buildLayout();
	            System.out.println(eesaAlgorithmPanel);
	            validate(); 
	            repaint();		
    		}
    	});
    }
}
