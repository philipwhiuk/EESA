package eesa.gui.windows;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Provides a base class for windows that perform a process.
 * @author Philip
 */
public class AbstractProcessWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private JPanel stepsPanel;
	/**
	 * 
	 */
	private JLabel stepsTitle;
	/**
	 * 
	 */
	private JLabel step1;
	/**
	 * 
	 */
	private String step1Title;
	/**
	 * 
	 */
	private JLabel step2;
	/**
	 * 
	 */
	private String step2Title;
	/**
	 * 
	 */
	private JLabel step3;
	/**
	 * 
	 */
	private String step3Title;
	/**
	 * 
	 */
	private JLabel step4;
	/**
	 * 
	 */
	private String step4Title;
	/**
	 * 
	 */
	private JLabel step5;
	/**
	 * 
	 */
	private String step5Title;
	
	/**
	 * Builds the steps list.
	 * @param titles
	 */
	public void setSteps(String[] titles) {
		if(titles.length > 1) {
			step1Title = titles[0];
		}
		if(titles.length > 2) {
			step1Title = titles[1];
		}
		if(titles.length > 3) {
			step1Title = titles[2];
		}
		if(titles.length > 4) {
			step1Title = titles[3];
		}
		if(titles.length > 5) {
			step1Title = titles[4];
		}
	}
	
	public final void initaliseWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        buildSteps();
	}
	private final void buildSteps() {
        stepsPanel = new JPanel();
        stepsTitle = new JLabel();
        step1 = new JLabel();
        step2 = new JLabel();
        
        stepsPanel.setBackground(new Color(255, 255, 255));
        stepsTitle.setFont(new Font("Tahoma", 1, eesa.gui.Application.STEP_FONT_SIZE)); // NOI18N
        stepsTitle.setText("Steps");
        step1.setFont(new Font("Tahoma", 1, eesa.gui.Application.STEP_FONT_SIZE)); // NOI18N
        step1.setText(step1Title);
        step2.setFont(new Font("Tahoma", 1, eesa.gui.Application.STEP_FONT_SIZE)); // NOI18N
        step2.setText(step2Title);
        step3.setFont(new Font("Tahoma", 1, eesa.gui.Application.STEP_FONT_SIZE)); // NOI18N
        step3.setText(step3Title);
        step4.setFont(new Font("Tahoma", 1, eesa.gui.Application.STEP_FONT_SIZE)); // NOI18N
        step4.setText(step4Title);
        step5.setFont(new Font("Tahoma", 1, eesa.gui.Application.STEP_FONT_SIZE)); // NOI18N
        step5.setText(step5Title);

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
                    .addComponent(step3)
                    .addComponent(step4)
                    .addComponent(step5))
                .addContainerGap(55, Short.MAX_VALUE))
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
                .addComponent(step3)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(step4)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(step5)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );		
	}
}
