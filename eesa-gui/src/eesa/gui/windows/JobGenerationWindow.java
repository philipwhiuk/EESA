/*
 * JobGenerationWindow.java
 *
 * Created on 07-Apr-2012, 13:42:11
 */
package eesa.gui.windows;

import com.whiuk.philip.eesa.core.Job;
import com.whiuk.philip.eesa.core.JobSet;
import com.whiuk.philip.eesa.core.Simulation;
import com.whiuk.philip.eesa.exceptions.JobException;
import com.whiuk.philip.eesa.exceptions.JobGeneratorException;
import com.whiuk.philip.eesa.exceptions.TimeIntervalException;
import eesa.gui.tables.JobSetTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 * Allows users to generate sets of jobs
 * using parameters and a variety of distributions.
 * @author Philip
 */
public class JobGenerationWindow extends JFrame {
	/**
	 * 
	 */
	private static Logger logger =
			Logger.getLogger(JobGenerationWindow.class.getName());
	
    /**
     * 
     */
    public static final int MAX_INVALID_PER_GENERATION = 100;
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
    private ArrayList<Job> jobData;
    /**
     * 
     */
    private Random r;
    /**
     * 
     */
    private String[] distributions = new String[]{
    		"Ignore",
    		"Value", "Uniform",
    		"Gaussian", "Exponential"};
	/**
	 * 
	 */
    private final JobSetTableModel jobsetTableModel;
	/**
	 * 
	 */
    private final JobSet jobset;
    /**
     * 
     */
	private GroupLayout layout;

    
    /**
     * Creates new form JobGenerationWindow.
     * @param sim 
     */
    public JobGenerationWindow(final Simulation sim) {
        this.simulation = sim;
        // this.setTitle("Job Generation");
        jobset = new JobSet(new ArrayList<Job>(0));
        jobsetTableModel = new JobSetTableModel(jobset);        
        r = new Random();
        initComponents();
        distributionJobCountActionPerformed(null);
        distributionJobReleaseActionPerformed(null);
        distributionJobDeadlineActionPerformed(null);
        distributionJobLengthActionPerformed(null);
        distributionJobWeightActionPerformed(null);
        distributionJobDensityActionPerformed(null);
    }

    /**
     * 
     */
    private void createFields() {
        maxJobWeight = new JTextField();
        actualJobLength = new JTextField();
        varianceJobCount = new JTextField();
        modeLabel = new JLabel();
        minimumLabel = new JLabel();
        maxJobDensity = new JTextField();
        maxJobCount = new JTextField();
        meanJobLength = new JTextField();
        varianceJobLength = new JTextField();
        meanJobWeight = new JTextField();
        actualJobWeight = new JTextField();
        maxJobLength = new JTextField();
        actualJobDensity = new JTextField();
        maximumLabel = new JLabel();
        jobDensityLabel = new JLabel();
        jLabel2 = new JLabel();
        minJobLength = new JTextField();
        distributionJobLength = new JComboBox<String>();
        jLabel3 = new JLabel();
        distributionJobCount = new JComboBox<String>();
        rateJobDensity = new JTextField();
        jobCountLabel = new JLabel();
        rateJobWeight = new JTextField();
        minJobCount = new JTextField();
        jLabel6 = new JLabel();
        jobLengthLabel = new JLabel();
        jLabel5 = new JLabel();
        jobWeightLabel = new JLabel();
        setupLabel = new JLabel();
        distributionJobWeight = new JComboBox<String>();
        meanJobDensity = new JTextField();
        rateJobCount = new JTextField();
        distributionJobDensity = new JComboBox<String>();
        rateJobLength = new JTextField();
        jLabel4 = new JLabel();
        meanJobCount = new JTextField();
        actualJobCount = new JTextField();
        jLabel1 = new JLabel();
        varianceJobDeadline = new JTextField();
        meanJobDeadline = new JTextField();
        maxJobDeadline = new JTextField();
        minJobDeadline = new JTextField();
        rateJobRelease = new JTextField();
        varianceJobRelease = new JTextField();
        meanJobRelease = new JTextField();
        maxJobRelease = new JTextField();
        minJobRelease = new JTextField();
        actualJobRelease = new JTextField();
        minJobWeight = new JTextField();
        varianceJobWeight = new JTextField();
        minJobDensity = new JTextField();
        generateButton = new JButton();
        previewLabel = new JLabel();
        jScrollPane2 = new JScrollPane();
        resultsTable = new JTable();
        varianceJobDensity = new JTextField();
        addButton = new JButton();
        replaceButton = new JButton();
        actualJobDeadline = new JTextField();
        rateJobDeadline = new JTextField();
        distributionJobDeadline = new JComboBox<String>();
        distributionJobRelease = new JComboBox<String>();    	
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {
    	createFields();


        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Generate Jobs");

        modeLabel.setFont(new java.awt.Font("Tahoma", 1, 
        		eesa.gui.Application.FONT_SIZE)); // NOI18N
        modeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        modeLabel.setText("Rate");

        minimumLabel.setFont(new java.awt.Font("Tahoma", 1, 
        		eesa.gui.Application.FONT_SIZE)); // NOI18N
        minimumLabel.setHorizontalAlignment(SwingConstants.CENTER);
        minimumLabel.setText("Minimum");

        maximumLabel.setFont(new java.awt.Font("Tahoma", 1, 
        		eesa.gui.Application.FONT_SIZE)); // NOI18N
        maximumLabel.setHorizontalAlignment(SwingConstants.CENTER);
        maximumLabel.setText("Maximum");

        jobDensityLabel.setFont(new java.awt.Font("Tahoma", 1, 
        		eesa.gui.Application.FONT_SIZE)); // NOI18N
        jobDensityLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        jobDensityLabel.setText("Job Density");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 
        		eesa.gui.Application.FONT_SIZE)); // NOI18N
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2.setText("Distribution");

        distributionJobLength.setModel(getDistributions());
        distributionJobLength.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                distributionJobLengthActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 
        		eesa.gui.Application.FONT_SIZE)); // NOI18N
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel3.setText("Mean");

        distributionJobCount.setModel(getDistributions());
        distributionJobCount.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                distributionJobCountActionPerformed(evt);
            }
        });

        jobCountLabel.setFont(new java.awt.Font("Tahoma", 1, eesa.gui.Application.FONT_SIZE)); // NOI18N
        jobCountLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        jobCountLabel.setText("Number of Jobs");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, eesa.gui.Application.FONT_SIZE)); // NOI18N
        jLabel6.setText("Job Deadline Time");

        jobLengthLabel.setFont(new java.awt.Font("Tahoma", 1, eesa.gui.Application.FONT_SIZE)); // NOI18N
        jobLengthLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        jobLengthLabel.setText("Job Length");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, eesa.gui.Application.FONT_SIZE)); // NOI18N
        jLabel5.setText("Job Release Time");

        jobWeightLabel.setFont(new java.awt.Font("Tahoma", 1, eesa.gui.Application.FONT_SIZE)); // NOI18N
        jobWeightLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        jobWeightLabel.setText("Job Weight");

        setupLabel.setFont(new java.awt.Font("Tahoma", 1, eesa.gui.Application.HEADING_FONT_SIZE)); // NOI18N
        setupLabel.setText("Setup Generation");

        distributionJobWeight.setModel(getDistributions());
        distributionJobWeight.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                distributionJobWeightActionPerformed(evt);
            }
        });

        distributionJobDensity.setModel(getDistributions());
        distributionJobDensity.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                distributionJobDensityActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, eesa.gui.Application.FONT_SIZE)); // NOI18N
        jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel4.setText("Variance");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, eesa.gui.Application.FONT_SIZE)); // NOI18N
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("Actual");

        generateButton.setText("Generate");
        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                generateButtonActionPerformed(evt);
            }
        });

        previewLabel.setFont(new java.awt.Font("Tahoma", 1, eesa.gui.Application.HEADING_FONT_SIZE)); // NOI18N
        previewLabel.setText("Preview Results");

        resultsTable.setModel(jobsetTableModel);
        jScrollPane2.setViewportView(resultsTable);

        addButton.setText("Add to Jobs");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        replaceButton.setText("Replace Existing Jobs");
        replaceButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                replaceButtonActionPerformed(evt);
            }
        });

        distributionJobDeadline.setModel(getDistributions());
        distributionJobDeadline.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                distributionJobDeadlineActionPerformed(evt);
            }
        });

        distributionJobRelease.setModel(getDistributions());
        distributionJobRelease.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                distributionJobReleaseActionPerformed(evt);
            }
        });

        buildLayout();
        


        pack();
    }
    /**
     * 
     */
    private void buildLayout() {
        layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        buildLayoutHorizontal();
        buildLayoutVertical();
    }
    /**
     * 
     */
    private void buildLayoutVertical() {
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(212, Short.MAX_VALUE)
                .addComponent(generateButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(previewLabel)
                .addGap(149, 149, 149))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(setupLabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(minimumLabel)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(maximumLabel))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(actualJobCount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(minJobCount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(distributionJobCount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(maxJobCount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jobCountLabel))
                            .addGap(5, 5, 5)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(actualJobRelease, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(minJobRelease, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(maxJobRelease, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(meanJobRelease, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(varianceJobRelease, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(rateJobRelease, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(distributionJobRelease, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(rateJobDeadline, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(minJobDeadline, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(maxJobDeadline, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(meanJobDeadline, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(varianceJobDeadline, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(actualJobDeadline, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(distributionJobDeadline, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(modeLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(varianceJobCount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(rateJobCount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(meanJobCount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGap(7, 7, 7)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(actualJobLength, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jobLengthLabel)
                        .addComponent(distributionJobLength, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(minJobLength, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(maxJobLength, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(meanJobLength, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(varianceJobLength, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(rateJobLength, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(eesa.gui.Application.GAP, eesa.gui.Application.GAP, eesa.gui.Application.GAP)
                            .addComponent(jobWeightLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(addButton)
                                .addComponent(replaceButton)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(minJobWeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(maxJobWeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(meanJobWeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(rateJobWeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(distributionJobWeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(actualJobWeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(varianceJobWeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(minJobDensity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(distributionJobDensity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(maxJobDensity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(meanJobDensity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(varianceJobDensity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rateJobDensity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(actualJobDensity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jobDensityLabel)))
                            .addGap(192, 192, 192)))
                    .addContainerGap()))
        );
	}
    /**
     * 
     */
	private void buildLayoutHorizontal() {
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(generateButton)
                        .addComponent(previewLabel))
                    .addContainerGap(511, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
                            .addComponent(setupLabel)
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(
                                		GroupLayout.Alignment.LEADING)
                                    .addComponent(jobWeightLabel, GroupLayout.Alignment.TRAILING, 
                                    		GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                    .addComponent(jobDensityLabel, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                    .addComponent(jobLengthLabel, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                    .addComponent(jLabel5, GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, GroupLayout.Alignment.TRAILING)
                                    .addComponent(jobCountLabel, GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(actualJobRelease, 0, 1, Short.MAX_VALUE)
                                    .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                                    .addComponent(actualJobCount, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                                    .addComponent(actualJobDeadline, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                                    .addComponent(actualJobLength, 
                                    		GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                                    .addComponent(actualJobWeight, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                                    .addComponent(actualJobDensity, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(distributionJobCount, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(distributionJobLength, GroupLayout.Alignment.TRAILING, 0, 
                                    		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(distributionJobWeight, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(distributionJobDensity, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(distributionJobRelease, 
                                    		GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 
                                    		78, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(distributionJobDeadline, GroupLayout.PREFERRED_SIZE, 78, 
                                    		GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(minJobRelease, 0, 1, Short.MAX_VALUE)
                                    .addComponent(minJobLength, GroupLayout.Alignment.LEADING, 0, 1, Short.MAX_VALUE)
                                    .addComponent(minJobDeadline, GroupLayout.Alignment.LEADING, 0, 1, Short.MAX_VALUE)
                                    .addComponent(minJobWeight, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                                    .addComponent(minJobDensity, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                                    .addComponent(minJobCount, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                                    .addComponent(minimumLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(maxJobDensity, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                                    .addComponent(maxJobWeight, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                                    .addComponent(maxJobLength, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                                    .addComponent(maxJobRelease, GroupLayout.Alignment.TRAILING, 0, 1, Short.MAX_VALUE)
                                    .addComponent(maxJobDeadline, 0, 1, Short.MAX_VALUE)
                                    .addComponent(maxJobCount, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                                    .addComponent(maximumLabel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(meanJobDensity, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                                    .addComponent(meanJobWeight, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                                    .addComponent(meanJobLength, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                                    .addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                                    .addComponent(meanJobCount, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                                    .addComponent(meanJobRelease, 0, 1, Short.MAX_VALUE)
                                    .addComponent(meanJobDeadline, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(varianceJobLength, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                                    .addComponent(varianceJobRelease, 0, 1, Short.MAX_VALUE)
                                    .addComponent(varianceJobDeadline, 0, 1, Short.MAX_VALUE)
                                    .addComponent(varianceJobWeight, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                                    .addComponent(varianceJobDensity, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                                    .addComponent(varianceJobCount, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                                    .addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(modeLabel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(rateJobDeadline, GroupLayout.Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
                                        .addComponent(rateJobRelease, GroupLayout.Alignment.TRAILING)
                                        .addComponent(rateJobLength, GroupLayout.Alignment.TRAILING)
                                        .addComponent(rateJobWeight)
                                        .addComponent(rateJobDensity)
                                        .addComponent(rateJobCount, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(replaceButton)))
                        .addContainerGap()))
            );
	}

	/**
     * 
     * @param evt Event
     */
    private void generateButtonActionPerformed(final ActionEvent evt) {
        int jobCount;
        try {
            jobCount = generateJobCount();
            jobData = new ArrayList<Job>(jobCount);
            for (int i = 0; i < jobCount; i++) {
                jobData.add(generateJob(i));
            }
            jobset.setJobs(jobData);
        } catch (JobGeneratorException ex) {
            JOptionPane.showMessageDialog(this, "Unable to generate jobs - " + ex.getMessage(), "Generator Error", JOptionPane.ERROR_MESSAGE);
        }
}
    /**
     * 
     * @param evt Event
     */
    private void addButtonActionPerformed(final ActionEvent evt) {
        simulation.getJobSet().addJobs(jobData);
        setVisible(false);
        dispose();
}
    /**
     * 
     * @param evt Event
     */
    private void replaceButtonActionPerformed(final ActionEvent evt) {
        simulation.getJobSet().setJobs(jobData);
        setVisible(false);
        dispose();
}
    /**
     * 
     * @param actual
     * @param min
     * @param max
     * @param mean
     * @param variance
     * @param rate
     */
    private void distributionJobCountUpdate(final boolean actual, final boolean min, final boolean max, final boolean mean, final boolean variance, final boolean rate) {
        this.actualJobCount.setEnabled(actual);
        this.minJobCount.setEnabled(min);
        this.maxJobCount.setEnabled(max);
        this.meanJobCount.setEnabled(mean);
        this.varianceJobCount.setEnabled(variance);
        this.rateJobCount.setEnabled(rate);        
    }
    /**
     * 
     * @param actual
     * @param min
     * @param max
     * @param mean
     * @param variance
     * @param rate
     */
    private void distributionJobReleaseUpdate(final boolean actual, final boolean min, final boolean max, final boolean mean, final boolean variance, final boolean rate) {
        this.actualJobRelease.setEnabled(actual);
        this.minJobRelease.setEnabled(min);
        this.maxJobRelease.setEnabled(max);
        this.meanJobRelease.setEnabled(mean);
        this.varianceJobRelease.setEnabled(variance);
        this.rateJobRelease.setEnabled(rate);        
    }    
    /**
     * 
     * @param actual
     * @param min
     * @param max
     * @param mean
     * @param variance
     * @param rate
     */
    private void distributionJobDeadlineUpdate(final boolean actual, final boolean min, final boolean max, final boolean mean, final boolean variance, final boolean rate) {
        this.actualJobDeadline.setEnabled(actual);
        this.minJobDeadline.setEnabled(min);
        this.maxJobDeadline.setEnabled(max);
        this.meanJobDeadline.setEnabled(mean);
        this.varianceJobDeadline.setEnabled(variance);
        this.rateJobDeadline.setEnabled(rate);        
    }    
    /**
     * 
     * @param actual
     * @param min
     * @param max
     * @param mean
     * @param variance
     * @param rate
     */
    private void distributionJobLengthUpdate(
    		final boolean actual, final boolean min,
    		final boolean max, final boolean mean,
    		final boolean variance, final boolean rate) {
        this.actualJobLength.setEnabled(actual);
        this.minJobLength.setEnabled(min);
        this.maxJobLength.setEnabled(max);
        this.meanJobLength.setEnabled(mean);
        this.varianceJobLength.setEnabled(variance);
        this.rateJobLength.setEnabled(rate);        
    }
    /**
     * 
     * @param actual
     * @param min
     * @param max
     * @param mean
     * @param variance
     * @param rate
     */
    private void distributionJobWeightUpdate(
    		final boolean actual, final boolean min,
    		final boolean max, final boolean mean,
    		final boolean variance, final boolean rate) {
        this.actualJobWeight.setEnabled(actual);
        this.minJobWeight.setEnabled(min);
        this.maxJobWeight.setEnabled(max);
        this.meanJobWeight.setEnabled(mean);
        this.varianceJobWeight.setEnabled(variance);
        this.rateJobWeight.setEnabled(rate);        
    }
    /**
     * 
     * @param actual
     * @param min
     * @param max
     * @param mean
     * @param variance
     * @param rate
     */
    private void distributionJobDensityUpdate(
    		final boolean actual, final boolean min,
    		final boolean max, final boolean mean,
    		final boolean variance, final boolean rate) {
        this.actualJobDensity.setEnabled(actual);
        this.minJobDensity.setEnabled(min);
        this.maxJobDensity.setEnabled(max);
        this.meanJobDensity.setEnabled(mean);
        this.varianceJobDensity.setEnabled(variance);
        this.rateJobDensity.setEnabled(rate);        
    }    
    /**
     * 
     * @param evt Event
     */
    private void distributionJobCountActionPerformed(final ActionEvent evt) {
        switch(distributionJobCount.getSelectedIndex()) {
            case 0: distributionJobCountUpdate(
            		false, false, false, false, false, false); break;
            case 1: distributionJobCountUpdate(
            		true, false, false, false, false, false); break;
            case 2: distributionJobCountUpdate(
            		false, true, true, false, false, false); break;
            case 3: distributionJobCountUpdate(
            		false, false, false, true, true, false); break;
            case 4: distributionJobCountUpdate(
            		false, false, false, false, false, true); break;
    		default:
    				throw new RuntimeException("Invalid index");
        }
    }
    /**
     * 
     * @param evt Event
     */
    private void distributionJobReleaseActionPerformed(final ActionEvent evt) {
        switch(distributionJobRelease.getSelectedIndex()) {
            case 0: distributionJobReleaseUpdate(
            		false, false, false, false, false, false); break;
            case 1: distributionJobReleaseUpdate(
            		true, false, false, false, false, false); break;
            case 2: distributionJobReleaseUpdate(
            		false, true, true, false, false, false); break;
            case 3: distributionJobReleaseUpdate(
            		false, false, false, true, true, false); break;
            case 4: distributionJobReleaseUpdate(
            		false, false, false, false, false, true); break;
    		default:
				throw new RuntimeException("Invalid index");
        }
    }
    /**
     * 
     * @param evt Event
     */
    private void distributionJobDeadlineActionPerformed(final ActionEvent evt) {
        switch(distributionJobDeadline.getSelectedIndex()) {
            case 0: distributionJobDeadlineUpdate(
            		false, false, false, false, false, false); break;
            case 1: distributionJobDeadlineUpdate(
            		true, false, false, false, false, false); break;
            case 2: distributionJobDeadlineUpdate(
            		false, true, true, false, false, false); break;
            case 3: distributionJobDeadlineUpdate(
            		false, false, false, true, true, false); break;
            case 4: distributionJobDeadlineUpdate(
            		false, false, false, false, false, true); break;
    		default:
				throw new RuntimeException("Invalid index");
        }
    }
    /**
     * 
     * @param evt Event
     */
    private void distributionJobLengthActionPerformed(final ActionEvent evt) {
        switch(distributionJobLength.getSelectedIndex()) {
            case 0: distributionJobLengthUpdate(
            		false, false, false, false, false , false); break;
            case 1: distributionJobLengthUpdate(
            		true, false, false, false, false, false); break;
            case 2: distributionJobLengthUpdate(
            		false, true, true, false, false, false); break;
            case 3: distributionJobLengthUpdate(
            		false, false, false, true, true, false); break;
            case 4: distributionJobLengthUpdate(
            		false, false, false, false, false, true); break;
    		default:
				throw new RuntimeException("Invalid index");
        }
    }
    /**
     * 
     * @param evt Event
     */
    private void distributionJobWeightActionPerformed(final ActionEvent evt) {
        switch(distributionJobWeight.getSelectedIndex()) {
            case 0: distributionJobWeightUpdate(
            		false, false, false, false, false, false); break;
            case 1: distributionJobWeightUpdate(
            		true, false, false, false, false, false); break;
            case 2: distributionJobWeightUpdate(
            		false, true, true, false, false, false); break;
            case 3: distributionJobWeightUpdate(
            		false, false, false, true, true, false); break;
            case 4: distributionJobWeightUpdate(
            		false, false, false, false, false, true); break;
    		default:
				throw new RuntimeException("Invalid index");
        }
    }
    /**
     * 
     * @param evt Event
     */
    private void distributionJobDensityActionPerformed(final ActionEvent evt) {
        switch(distributionJobDensity.getSelectedIndex()) {
            case 0: distributionJobDensityUpdate(
            		false, false, false, false, false, false); break;
            case 1: distributionJobDensityUpdate(
            		true, false, false, false, false, false); break;
            case 2: distributionJobDensityUpdate(
            		false, true, true, false, false, false); break;
            case 3: distributionJobDensityUpdate(
            		false, false, false, true, true, false); break;
            case 4: distributionJobDensityUpdate(
            		false, false, false, false, false, true); break;
    		default:
				throw new RuntimeException("Invalid index");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
	/**
	 * 
	 */
    private JLabel jobCountLabel;
	/**
	 * 
	 */
    private JLabel jobDensityLabel;
	/**
	 * 
	 */
    private JLabel jobLengthLabel;
	/**
	 * 
	 */
    private JLabel jobWeightLabel;
	/**
	 * 
	 */
    private JLabel maximumLabel;
	/**
	 * 
	 */
    private JLabel minimumLabel;
	/**
	 * 
	 */
    private JLabel modeLabel;
	/**
	 * 
	 */
    private JTextField actualJobCount;
	/**
	 * 
	 */
    private JTextField actualJobDeadline;
	/**
	 * 
	 */
    private JTextField actualJobDensity;
	/**
	 * 
	 */
    private JTextField actualJobLength;
	/**
	 * 
	 */
    private JTextField actualJobRelease;
	/**
	 * 
	 */
    private JTextField actualJobWeight;
	/**
	 * 
	 */
    private JButton addButton;
	/**
	 * 
	 */
    private JComboBox<String> distributionJobCount;
	/**
	 * 
	 */
    private JComboBox<String> distributionJobDeadline;
	/**
	 * 
	 */
    private JComboBox<String> distributionJobDensity;
	/**
	 * 
	 */
    private JComboBox<String> distributionJobLength;
	/**
	 * 
	 */
    private JComboBox<String> distributionJobRelease;
	/**
	 * 
	 */
    private JComboBox<String> distributionJobWeight;
	/**
	 * 
	 */
    private JButton generateButton;
	/**
	 * 
	 */
    private JLabel jLabel1;
	/**
	 * 
	 */
    private JLabel jLabel2;
	/**
	 * 
	 */
    private JLabel jLabel3;
	/**
	 * 
	 */
    private JLabel jLabel4;
	/**
	 * 
	 */
    private JLabel jLabel5;
	/**
	 * 
	 */
    private JLabel jLabel6;
	/**
	 * 
	 */
    private JScrollPane jScrollPane2;
	/**
	 * 
	 */
    private JTextField maxJobCount;
	/**
	 * 
	 */
    private JTextField maxJobDeadline;
	/**
	 * 
	 */
    private JTextField maxJobDensity;
	/**
	 * 
	 */
    private JTextField maxJobLength;
	/**
	 * 
	 */
    private JTextField maxJobRelease;
	/**
	 * 
	 */
    private JTextField maxJobWeight;
	/**
	 * 
	 */
    private JTextField meanJobCount;
	/**
	 * 
	 */
    private JTextField meanJobDeadline;
	/**
	 * 
	 */
    private JTextField meanJobDensity;
	/**
	 * 
	 */
    private JTextField meanJobLength;
	/**
	 * 
	 */
    private JTextField meanJobRelease;
	/**
	 * 
	 */
    private JTextField meanJobWeight;
	/**
	 * 
	 */
    private JTextField minJobCount;
	/**
	 * 
	 */
    private JTextField minJobDeadline;
	/**
	 * 
	 */
    private JTextField minJobDensity;
	/**
	 * 
	 */
    private JTextField minJobLength;
	/**
	 * 
	 */
    private JTextField minJobRelease;
	/**
	 * 
	 */
    private JTextField minJobWeight;
	/**
	 * 
	 */
    private JLabel previewLabel;
	/**
	 * 
	 */
    private JTextField rateJobCount;
	/**
	 * 
	 */
    private JTextField rateJobDeadline;
	/**
	 * 
	 */
    private JTextField rateJobDensity;
	/**
	 * 
	 */
    private JTextField rateJobLength;
	/**
	 * 
	 */
    private JTextField rateJobRelease;
	/**
	 * 
	 */
    private JTextField rateJobWeight;
	/**
	 * 
	 */
    private JButton replaceButton;
	/**
	 * 
	 */
    private JTable resultsTable;
	/**
	 * 
	 */
    private JLabel setupLabel;
	/**
	 * 
	 */
    private JTextField varianceJobCount;
	/**
	 * 
	 */
    private JTextField varianceJobDeadline;
	/**
	 * 
	 */
    private JTextField varianceJobDensity;
	/**
	 * 
	 */
    private JTextField varianceJobLength;
	/**
	 * 
	 */
    private JTextField varianceJobRelease;
	/**
	 * 
	 */
    private JTextField varianceJobWeight;
    // End of variables declaration//GEN-END:variables
    /**
     * 
     * @return The ComboBoxModel with the list of distributions.
     */
    private ComboBoxModel<String> getDistributions() {
        DefaultComboBoxModel<String> cbm = new DefaultComboBoxModel<String>(distributions);
        cbm.setSelectedItem(distributions[0]);
        return cbm;
    }
    /**
     * 
     * @return
     * @throws JobGeneratorException
     */
    private int generateJobCount() throws JobGeneratorException {
        try {
            int jobCount = 0;
            switch(distributionJobCount.getSelectedIndex()) {
                case 0: throw new JobGeneratorException("Job count can't be ignored.");
                case 1: jobCount = Integer.parseInt(actualJobCount.getText()); break; 
                case 2: jobCount = (int) getUniform(
                		Float.parseFloat(minJobCount.getText()),
                		Float.parseFloat(maxJobCount.getText())); break;
                case 3: jobCount = (int) getGaussian(
                		Float.parseFloat(minJobCount.getText()),
                		Float.parseFloat(maxJobCount.getText())); break;
                case 4: jobCount = (int) getExponential(
                		Float.parseFloat(rateJobCount.getText())); break;
                default: throw new JobGeneratorException("Invalid distribution selection."); 
            }
            if (jobCount < 0) {
                throw new JobGeneratorException("Job count must be > 0");
            }
            return jobCount;
        } catch (NumberFormatException e) {
            throw new JobGeneratorException("Job count must be an integer");
        }
    }
    /**
     * 
     * @param id
     * @return The generated job according to the conditions set
     * @throws JobGeneratorException
     */
    private Job generateJob(final int id) throws JobGeneratorException {
        try {
        	HashMap<Job.Property, Float> properties = new HashMap<Job.Property, Float>();
        	
            int invalidJobCount = 0;
            while (invalidJobCount < MAX_INVALID_PER_GENERATION) {
                switch(distributionJobRelease.getSelectedIndex()) {
                    case 1: 
                    	properties.put(Job.Property.RELEASE,
                    			Float.parseFloat(actualJobRelease.getText()));
                    	break; 
                    case 2: 
                    	properties.put(Job.Property.RELEASE, getUniform(
                    		Float.parseFloat(minJobRelease.getText()), 
                            Float.parseFloat(maxJobRelease.getText())));
                    	break;
                    case 3: 
                    	properties.put(Job.Property.RELEASE, getGaussian(
                    		Float.parseFloat(meanJobRelease.getText()),
                    		Float.parseFloat(varianceJobRelease.getText())));
                    	break;
                    case 4: 
                    	properties.put(Job.Property.RELEASE, getExponential(
                    		Float.parseFloat(rateJobRelease.getText()))); break;
                    case 0: break;                
                    default: throw new JobGeneratorException("Invalid distribution selection.");
                }
                switch(distributionJobDeadline.getSelectedIndex()) {
                    case 1: 
                    	properties.put(Job.Property.DEADLINE,
                    			Float.parseFloat(actualJobDeadline.getText()));
                    	break; 
                    case 2: 
                    	properties.put(Job.Property.DEADLINE, getUniform(
                    			Float.parseFloat(minJobDeadline.getText()), 
                                Float.parseFloat(maxJobDeadline.getText())));
                    	break;
                    case 3: 
                    	properties.put(Job.Property.DEADLINE, getGaussian(
                    		Float.parseFloat(meanJobDeadline.getText()),
                    		Float.parseFloat(varianceJobDeadline.getText())));
                    	break;
                    case 4: 
                    	properties.put(Job.Property.DEADLINE, getExponential(
                    		Float.parseFloat(rateJobDeadline.getText())));
                    	break;
                    case 0: break;            
                    default: 
                    	throw new JobGeneratorException("Invalid distribution selection.");
                }
                switch(distributionJobLength.getSelectedIndex()) {
                    case 1: 
                    	properties.put(Job.Property.LENGTH,
                    			Float.parseFloat(actualJobLength.getText()));
                    	break;
                    case 2: 
                    	properties.put(Job.Property.LENGTH,
                    			getUniform(Float.parseFloat(
                    					minJobLength.getText()), 
                    					Float.parseFloat(
                    							maxJobLength.getText())));
                    	break;
                    case 3: 
                    	properties.put(Job.Property.LENGTH,
                    		getGaussian(Float.parseFloat(
                    				meanJobLength.getText()),
                    				Float.parseFloat(
                    						varianceJobLength.getText())));
                    	break;
                    case 4: 
                    	properties.put(Job.Property.LENGTH,
                    			getExponential(Float.parseFloat(
                    					rateJobLength.getText())));
                    	break;
                    case 0: break;                
                    default: 
                    	throw new JobGeneratorException(
                    		"Invalid distribution selection.");
                }            
                switch(distributionJobWeight.getSelectedIndex()) {
                    case 1: 
                    	properties.put(Job.Property.WEIGHT,
                    			Float.parseFloat(actualJobWeight.getText()));
                    	break; 
                    case 2: 
                    	properties.put(Job.Property.WEIGHT,
                    			getUniform(Float.parseFloat(
                    					minJobWeight.getText()), 
                                Float.parseFloat(maxJobWeight.getText())));
                    	break;
                    case 3: 
                    	properties.put(Job.Property.WEIGHT, getGaussian(
                    			Float.parseFloat(meanJobWeight.getText()),
                    			Float.parseFloat(varianceJobWeight.getText())));
                    	break;
                    case 4: 
                    	properties.put(Job.Property.WEIGHT,
                    			getExponential(
                    					Float.parseFloat(
                    							rateJobWeight.getText())));
                    	break;
                    case 0: 
                    	break;                
                    default: 
                    	throw new JobGeneratorException(
                    			"Invalid distribution selection.");
                }
                switch(distributionJobDensity.getSelectedIndex()) {
                    case 1: 
                    	properties.put(Job.Property.DENSITY,
                    			Float.parseFloat(actualJobDensity.getText()));
                    	break; 
                    case 2: 
                    	properties.put(Job.Property.DENSITY, getUniform(
                    			Float.parseFloat(minJobDensity.getText()), 
                                Float.parseFloat(maxJobDensity.getText())));
                    	break;
                    case 3: 
                    	properties.put(Job.Property.DENSITY, getGaussian(
                    			Float.parseFloat(meanJobDensity.getText()),
                    			Float.parseFloat(
                    					varianceJobRelease.getText())));
                    	break;
                    case 4: 
                    	properties.put(Job.Property.DENSITY, getExponential(
                    			Float.parseFloat(rateJobDensity.getText())));
                    	break;
                    case 0: break;                
                    default: 
                    	throw new JobGeneratorException(
                    			"Invalid distribution selection.");
                }
                try {
                    return new Job(id, properties);
                } catch (JobException e) {
                    logger.log(Level.INFO, null, e);
                    invalidJobCount++;
                } catch (TimeIntervalException e) {
                    logger.log(Level.INFO, null, e);
                    invalidJobCount++;                    
                }
            }
            throw new JobGeneratorException("Parameters likely contradict each other. " + MAX_INVALID_PER_GENERATION + " invalid jobs were generated in a row.");
        } catch (NumberFormatException ex) {
            throw new JobGeneratorException("Job parameters are floating point numbers");
        }
        
    }
    /**
     * 
     * @param min
     * @param max
     * @return
     */
    private float getUniform(final float min, final float max) {
        return ((r.nextFloat() * (max - min)) + min);
    }
    /**
     * 
     * @param mean
     * @param variance
     * @return
     */
    private float getGaussian(final float mean, final float variance) {
        return (float) ((r.nextGaussian() * mean) + Math.sqrt(variance));
    }
    /**
     * 
     * @param rate
     * @return
     */
    private float getExponential(final float rate) {
        return (float) Math.log(1 - r.nextDouble()) / (-rate);
    }
}
