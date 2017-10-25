package eesa.gui.windows.algorithms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;

import com.whiuk.philip.eesa.algorithms.AssignmentAndScalingAlgorithm;
import com.whiuk.philip.eesa.algorithms.EESAAlgorithm;
import com.whiuk.philip.eesa.algorithms.JobAssignmentAlgorithm;
import com.whiuk.philip.eesa.algorithms.SpeedScalingAlgorithm;
import eesa.gui.help.HelpManager;
import eesa.gui.windows.AddTestWindow;

/**
 * 
 * @author Philip Whitehouse
 *
 */
public class AssignmentAndScalingAlgorithmPanel extends EESAAlgorithmPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Algorithm.
	 */
	private AssignmentAndScalingAlgorithm algorithm = 
			new AssignmentAndScalingAlgorithm();
    /**
     * 
     */
    private JScrollPane jScrollPane1;
    /**
     * 
     */
    private JScrollPane jScrollPane2;
    /**
     * 
     */
    private JComboBox<JobAssignmentAlgorithm> jobAssignmentAlgorithmComboBox;
    /**
     * 
     */
    private JTextArea jobAssignmentAlgorithmDescriptionTextArea;
    /**
     * 
     */
    private JLabel jobAssignmentAlgorithmLabel;
    /**
     * 
     */
    private JComboBox<SpeedScalingAlgorithm> speedScalingAlgorithmComboBox;
    /**
     * 
     */
    private JTextArea speedScalingAlgorithmDescriptionTextArea;
    /**
     * 
     */
    private JLabel speedScalingAlgorithmLabel;
    
    /**
     * 
     */
	public AssignmentAndScalingAlgorithmPanel() {
        initComponents();
        buildLayout();
    }
    /**
     * 
     */
	private void buildLayout() {
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(
                		GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(
                    		GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane2, 
                        		GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, 
                        		GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.LEADING,
                        		layout.createSequentialGroup()
                            .addComponent(jobAssignmentAlgorithmLabel)
                            .addPreferredGap(
                            		LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jobAssignmentAlgorithmComboBox, 0,
                            		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.LEADING,
                        		layout.createSequentialGroup()
                            .addComponent(speedScalingAlgorithmLabel)
                            .addGap(8, 8, 8)
                            .addComponent(speedScalingAlgorithmComboBox,
                            		GroupLayout.PREFERRED_SIZE, 234,
                            		GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(
                		GroupLayout.Alignment.BASELINE)
                    .addComponent(jobAssignmentAlgorithmLabel)
                    .addComponent(jobAssignmentAlgorithmComboBox,
                    		GroupLayout.PREFERRED_SIZE,
                    		GroupLayout.DEFAULT_SIZE,
                    		GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 51,
                		GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(
                		GroupLayout.Alignment.BASELINE)
                    .addComponent(speedScalingAlgorithmLabel)
                    .addComponent(speedScalingAlgorithmComboBox,
                    		GroupLayout.PREFERRED_SIZE,
                    		GroupLayout.DEFAULT_SIZE,
                    		GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2,
                		GroupLayout.PREFERRED_SIZE, 51,
                		GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addContainerGap(19, Short.MAX_VALUE))
        );
	}

	/**
	 * 
	 */
	private void initComponents() {
		jobAssignmentAlgorithmLabel = new JLabel();
		speedScalingAlgorithmLabel = new JLabel();
		jobAssignmentAlgorithmComboBox = 
				new JComboBox<JobAssignmentAlgorithm>();
		speedScalingAlgorithmComboBox = new JComboBox<SpeedScalingAlgorithm>();
        jobAssignmentAlgorithmLabel.setText("Job Assignment Algorithm");

        speedScalingAlgorithmLabel.setText("Speed Scaling Algorithm");
        jScrollPane1 = new JScrollPane();
        jobAssignmentAlgorithmDescriptionTextArea = new JTextArea();
        jScrollPane2 = new JScrollPane();
        speedScalingAlgorithmDescriptionTextArea = new JTextArea();
        
        jobAssignmentAlgorithmDescriptionTextArea.setColumns(20);
        jobAssignmentAlgorithmDescriptionTextArea.setEditable(false);
        jobAssignmentAlgorithmDescriptionTextArea.setFont(
        		new java.awt.Font("Arial", 0,
        				eesa.gui.Application.FONT_SIZE)); // NOI18N
        jobAssignmentAlgorithmDescriptionTextArea.setLineWrap(true);
        jobAssignmentAlgorithmDescriptionTextArea.setRows(5);
        jobAssignmentAlgorithmDescriptionTextArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jobAssignmentAlgorithmDescriptionTextArea);

        speedScalingAlgorithmDescriptionTextArea.setColumns(20);
        speedScalingAlgorithmDescriptionTextArea.setEditable(false);
        speedScalingAlgorithmDescriptionTextArea.setFont(
        		new java.awt.Font("Arial", 0,
        				eesa.gui.Application.FONT_SIZE)); // NOI18N
        speedScalingAlgorithmDescriptionTextArea.setLineWrap(true);
        speedScalingAlgorithmDescriptionTextArea.setRows(5);
        speedScalingAlgorithmDescriptionTextArea.setWrapStyleWord(true);
        jScrollPane2.setViewportView(speedScalingAlgorithmDescriptionTextArea);

        jobAssignmentAlgorithmComboBox.setModel(
        		getJobAssignmentAlgorithmsComboBoxModel());
        jobAssignmentAlgorithmComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                jobAssignmentAlgorithmComboBoxActionPerformed(evt);
            }
        });

        speedScalingAlgorithmComboBox.setModel(
        		getSpeedScalingAlgorithmsComboBoxModel());
        speedScalingAlgorithmComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                speedScalingAlgorithmComboBoxActionPerformed(evt);
            }
        });
	}
    /**
     * 
     * @param evt 
     */
    private void jobAssignmentAlgorithmComboBoxActionPerformed(
    		final ActionEvent evt) {
        JobAssignmentAlgorithm selected = (JobAssignmentAlgorithm)
        		jobAssignmentAlgorithmComboBox.getSelectedItem();
        jobAssignmentAlgorithmDescriptionTextArea.setText(
        		selected.getDescription());
        jobAssignmentAlgorithmDescriptionTextArea.setCaretPosition(0);
    }
    /**
     * 
     * @param evt event
     */
    private void speedScalingAlgorithmComboBoxActionPerformed(
    		final ActionEvent evt) {
        SpeedScalingAlgorithm selected = 
        		(SpeedScalingAlgorithm) speedScalingAlgorithmComboBox
        			.getSelectedItem();
        speedScalingAlgorithmDescriptionTextArea.setText(
        		selected.getDescription());
        speedScalingAlgorithmDescriptionTextArea.setCaretPosition(0);
    }
    /**
     * 
     * @return model
     */
    private ComboBoxModel<JobAssignmentAlgorithm>
    		getJobAssignmentAlgorithmsComboBoxModel() {
        ComboBoxModel<JobAssignmentAlgorithm> m = 
        		new DefaultComboBoxModel<JobAssignmentAlgorithm>(
				AssignmentAndScalingAlgorithm.getJobAssignmentAlgorithms()); 
        if (m.getSelectedItem() != null) {
	        jobAssignmentAlgorithmDescriptionTextArea.setText(((
        		JobAssignmentAlgorithm) m.getSelectedItem()).getDescription());
        } else {
        	jobAssignmentAlgorithmDescriptionTextArea.setText("");
        	
        }
        jobAssignmentAlgorithmDescriptionTextArea.setCaretPosition(0);
        return m;
        
    }
    /**
     * 
     * @return model
     */
    private ComboBoxModel<SpeedScalingAlgorithm> 
    		getSpeedScalingAlgorithmsComboBoxModel() {
        ComboBoxModel<SpeedScalingAlgorithm> m =
        		new DefaultComboBoxModel<SpeedScalingAlgorithm>(
    				AssignmentAndScalingAlgorithm.getSpeedScalingAlgorithms());
        if (m.getSelectedItem() != null) {
        	speedScalingAlgorithmDescriptionTextArea.setText(((
    			SpeedScalingAlgorithm) m.getSelectedItem()).getDescription());
        } else {
        	speedScalingAlgorithmDescriptionTextArea.setText("");
        	
        }
        speedScalingAlgorithmDescriptionTextArea.setCaretPosition(0);
        return m;
    }
	@Override
	public final EESAAlgorithm getAlgorithm() {
		return algorithm;
	}
}
