/*
 * ResultsDataPanel.java
 *
 * Created on 20-Nov-2011, 22:50:27
 */
package eesa.gui;


import com.whiuk.philip.eesa.core.Processor;
import com.whiuk.philip.eesa.core.Simulation;
import com.whiuk.philip.eesa.core.Test;
import eesa.gui.charts.Charts;
import eesa.gui.charts.Charts.SplitType;
import eesa.gui.charts.basic.EnergyCharts;
import eesa.gui.charts.basic.JobCharts;
import eesa.gui.charts.basic.SpeedCharts;
import eesa.gui.event.ProcessorViewEvent;
import eesa.gui.event.ProcessorViewEventListener;
import eesa.gui.event.TestViewEvent;
import eesa.gui.event.TestViewEventListener;
import eesa.gui.help.HelpManager;
import eesa.gui.lists.ProcessorListModel;
import eesa.gui.lists.TestListModel;
import eesa.gui.tables.JobResultsDataTableModel;
import eesa.gui.tables.TimePeriodsDataTableModel;
import eesa.gui.views.JobResultsView;
import eesa.gui.views.TimePeriodsView;
import eesa.gui.windows.dataExport.periods.ExportPeriodsWindow;
import eesa.gui.windows.dataExport.results.ExportResultsWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowSorter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;

/**
 * Shows the results of one or more Tests.
 * Embedded in the centre of the ESASimulator
 * @author Philip
 */
public class ResultsDataPanel extends javax.swing.JPanel {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    private static final SplitType DEFAULT_SPLIT_TYPE = SplitType.BY_BOTH;
    /**
     * 
     */
    private ProcessorListModel pListModel;
    /**
     * 
     */
    private TestListModel tListModel;
    /**
     * 
     */
    private ArrayList<ProcessorViewEventListener> processorViewEventListeners;
    /**
     * 
     */
    private ArrayList<TestViewEventListener> testViewEventListeners;
	/**
	 * 
	 */
    private TimePeriodsView timePeriodsView;
	/**
	 * 
	 */
    private JobResultsView jobResultsView;
    /**
     * 
     */
    private Charts chart;
	/**
	 * 
	 */
    private SplitType chartSplitType = DEFAULT_SPLIT_TYPE;
    
    /**
     * 
     */
    private final Simulation simulation;
	/**
	 * 
	 */
    private RowSorter<TimePeriodsDataTableModel> timePeriodsRowSorter;
	/**
	 * 
	 */
    private TimePeriodsDataTableModel timePeriodsTableModel;
	/**
	 * 
	 */
    private JobResultsDataTableModel jobResultsTableModel;
	/**
	 * 
	 */
    private RowSorter<JobResultsDataTableModel>jobResultsRowSorter;

    /** Creates new form ResultsDataPanel.
     * @param a 
     * @param s 
     */
    public ResultsDataPanel(final Application a, final Simulation s) {
        //Data Setup
        this.simulation = s;
        processorViewEventListeners = 
        		new ArrayList<ProcessorViewEventListener>();
        testViewEventListeners = 
        		new ArrayList<TestViewEventListener>();
        //Views
        timePeriodsView = new TimePeriodsView(this,
        		simulation.getTestList(), simulation.getProcessors());
        jobResultsView = new JobResultsView(this,
        		simulation.getTestList(), simulation.getProcessors());
        //Setup Table Models              
        timePeriodsTableModel = 
        		new TimePeriodsDataTableModel(timePeriodsView);
        timePeriodsRowSorter = new TableRowSorter<TimePeriodsDataTableModel>(
        		timePeriodsTableModel);
        //
        jobResultsTableModel = new JobResultsDataTableModel(jobResultsView);
        jobResultsRowSorter = new TableRowSorter<JobResultsDataTableModel>(
        		jobResultsTableModel);
        initComponents();  
        HelpManager.addHelpForClassToButton(helpButton, ResultsDataPanel.class);
        //Initial Charts
        chart = new EnergyCharts(timePeriodsView, Charts.SplitType.SINGLE);
        chartsPanel.add(chart);
        chart.setSize(chartsPanel.getSize());
        chartsPanel.addComponentListener(chart);
        chartsPanel.setSize(400, 240);
        //Toggle Button Selection Setup
        typeChartButtonGroup.setSelected(jobsToggleButton.getModel(), true);
        splitChartButtonGroup.setSelected(singleToggleButton.getModel(), true);
        tablesButtonGroup.setSelected(jobResultsToggleButton.getModel(), true);
        //Toggle Button Listener Setup
        
        chart.setSize(chartsPanel.getSize());
    }

    /**
     * 
     */
    private void createFields() {
        splitChartButtonGroup = new javax.swing.ButtonGroup();
        typeChartButtonGroup = new javax.swing.ButtonGroup();
        tablesButtonGroup = new javax.swing.ButtonGroup();
        exportData = new javax.swing.JButton();
        scrollPanel = new javax.swing.JScrollPane();
        resultsDataPanelSPInner = new javax.swing.JPanel();
        heading = new javax.swing.JLabel();
        viewSectionPanel = new javax.swing.JPanel();
        viewHeading = new javax.swing.JLabel();
        viewTestPanel = new javax.swing.JPanel();
        testLabel = new javax.swing.JLabel();
        testListScrollPane = new javax.swing.JScrollPane();
        testList = new javax.swing.JList<Test>();
        viewProcessorsPanel = new javax.swing.JPanel();
        processorLabel = new javax.swing.JLabel();
        processorListScrollPane = new javax.swing.JScrollPane();
        processorList = new javax.swing.JList<Processor>();
        chartsSectionPanel = new javax.swing.JPanel();
        chartsPanel = new javax.swing.JPanel();
        chartsHeading = new javax.swing.JLabel();
        jobsToggleButton = new javax.swing.JToggleButton();
        speedToggleButton = new javax.swing.JToggleButton();
        energyToggleButton = new javax.swing.JToggleButton();
        singleToggleButton = new javax.swing.JToggleButton();
        processorToggleButton = new javax.swing.JToggleButton();
        testToggleButton = new javax.swing.JToggleButton();
        bothToggleButton = new javax.swing.JToggleButton();
        exportChartButton = new javax.swing.JButton();
        tablesSelectionPanel = new javax.swing.JPanel();
        resultsTableScrollPane = new javax.swing.JScrollPane();
        resultsTable = new javax.swing.JTable();
        tableButtonsLabel = new javax.swing.JLabel();
        jobResultsToggleButton = new javax.swing.JToggleButton();
        timePeriodsToggleButton = new javax.swing.JToggleButton();
        helpButton = new javax.swing.JButton();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {
    	createFields();
        exportData.setText("Export Data");
        exportData.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                exportDataActionPerformed(evt);
            }
        });
        scrollPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        heading.setFont(new java.awt.Font("Tahoma", 1, eesa.gui.Application.HEADING_FONT_SIZE)); // NOI18N
        heading.setText("View Results");
        viewSectionPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        viewHeading.setFont(new java.awt.Font("Tahoma", 1, eesa.gui.Application.FONT_SIZE)); // NOI18N
        viewHeading.setText("Customise View");
        testLabel.setFont(new java.awt.Font("Tahoma", 3, eesa.gui.Application.FONT_SIZE)); // NOI18N
        testLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        testLabel.setText("Tests");
        testList.setModel(getTestListModel());
        testList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(final ListSelectionEvent evt) {
                testListValueChanged(evt);
            }
        });
        testListScrollPane.setViewportView(testList);
        buildTestPanelLayout();
        processorLabel.setFont(new java.awt.Font("Tahoma", 3, eesa.gui.Application.FONT_SIZE)); // NOI18N
        processorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        processorLabel.setText("Processors");
        processorList.setModel(getProcessorListModel());
        processorList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(final ListSelectionEvent evt) {
                processorListValueChanged(evt);
            }
        });
        processorListScrollPane.setViewportView(processorList);
        buildProcessorsPanelLayout();
        buildViewSelectionPanelLayout();
        chartsSectionPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        chartsPanel.setBackground(new java.awt.Color(255, 255, 255));
        chartsPanel.setPreferredSize(new java.awt.Dimension(320, 240));
        javax.swing.GroupLayout chartsPanelLayout = new javax.swing.GroupLayout(chartsPanel);
        chartsPanel.setLayout(chartsPanelLayout);
        chartsPanelLayout.setHorizontalGroup(
            chartsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        chartsPanelLayout.setVerticalGroup(
            chartsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 245, Short.MAX_VALUE)
        );
        chartsHeading.setFont(new java.awt.Font("Tahoma", 1, eesa.gui.Application.FONT_SIZE)); // NOI18N
        chartsHeading.setText("Charts");
        typeChartButtonGroup.add(jobsToggleButton);
        jobsToggleButton.setText("Jobs");
        jobsToggleButton.addItemListener(new ItemListener() {
            public void itemStateChanged(final ItemEvent evt) {
                jobsToggleButtonItemStateChanged(evt);
            }
        });
        typeChartButtonGroup.add(speedToggleButton);
        speedToggleButton.setText("Speed");
        speedToggleButton.addItemListener(new ItemListener() {
            public void itemStateChanged(final ItemEvent evt) {
                speedToggleButtonItemStateChanged(evt);
            }
        });
        typeChartButtonGroup.add(energyToggleButton);
        energyToggleButton.setText("Energy");
        energyToggleButton.addItemListener(new ItemListener() {
            public void itemStateChanged(final ItemEvent evt) {
                energyToggleButtonItemStateChanged(evt);
            }
        });
        splitChartButtonGroup.add(singleToggleButton);
        singleToggleButton.setText("Single Chart");
        singleToggleButton.addItemListener(new ItemListener() {
            public void itemStateChanged(final ItemEvent evt) {
                singleToggleButtonItemStateChanged(evt);
            }
        });
        splitChartButtonGroup.add(processorToggleButton);
        processorToggleButton.setText("By Processor");
        processorToggleButton.addItemListener(new ItemListener() {
            public void itemStateChanged(final ItemEvent evt) {
                processorToggleButtonItemStateChanged(evt);
            }
        });
        splitChartButtonGroup.add(testToggleButton);
        testToggleButton.setText("By Test");
        testToggleButton.addItemListener(new ItemListener() {
            public void itemStateChanged(final ItemEvent evt) {
                testToggleButtonItemStateChanged(evt);
            }
        });
        splitChartButtonGroup.add(bothToggleButton);
        bothToggleButton.setText("By Both");
        bothToggleButton.addItemListener(new ItemListener() {
            public void itemStateChanged(final ItemEvent evt) {
                bothToggleButtonItemStateChanged(evt);
            }
        });
        exportChartButton.setText("Export Chart");
        buildChartsSectionPanelLayout();
        tablesSelectionPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        resultsTable.setModel(timePeriodsTableModel);
        resultsTable.setRowSorter(timePeriodsRowSorter);
        resultsTableScrollPane.setViewportView(resultsTable);
        tableButtonsLabel.setFont(new java.awt.Font("Tahoma", 1, eesa.gui.Application.FONT_SIZE)); // NOI18N
        tableButtonsLabel.setText("Tables");
        tablesButtonGroup.add(jobResultsToggleButton);
        jobResultsToggleButton.setText("Job Results");
        jobResultsToggleButton.addItemListener(new ItemListener() {
            public void itemStateChanged(final ItemEvent evt) {
                jobResultsToggleButtonItemStateChanged(evt);
            }
        });
        tablesButtonGroup.add(timePeriodsToggleButton);
        timePeriodsToggleButton.setText("Time Periods");
        timePeriodsToggleButton.addItemListener(new ItemListener() {
            public void itemStateChanged(final ItemEvent evt) {
                timePeriodsToggleButtonItemStateChanged(evt);
            }
        });

        buildTableSelectionPanelLayout();

        helpButton.setText("Help");

        buildResultsDataPanelLayout();

        scrollPanel.setViewportView(resultsDataPanelSPInner);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
        );
    }
    /**
     * 
     */
    private void buildViewSelectionPanelLayout() {
        javax.swing.GroupLayout viewSectionPanelLayout = new javax.swing.GroupLayout(viewSectionPanel);
        viewSectionPanel.setLayout(viewSectionPanelLayout);
        viewSectionPanelLayout.setHorizontalGroup(
            viewSectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewSectionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(viewSectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewSectionPanelLayout.createSequentialGroup()
                        .addComponent(viewHeading)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(viewSectionPanelLayout.createSequentialGroup()
                        .addComponent(viewTestPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(viewProcessorsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        viewSectionPanelLayout.setVerticalGroup(
            viewSectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewSectionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewHeading)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(viewSectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(viewProcessorsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(viewTestPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
	}

	/**
     * 
     */
    private void buildTableSelectionPanelLayout() {
        javax.swing.GroupLayout tablesSelectionPanelLayout = new javax.swing.GroupLayout(tablesSelectionPanel);
        tablesSelectionPanel.setLayout(tablesSelectionPanelLayout);
        tablesSelectionPanelLayout.setHorizontalGroup(
            tablesSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablesSelectionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tablesSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(resultsTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
                    .addGroup(tablesSelectionPanelLayout.createSequentialGroup()
                        .addGroup(tablesSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tableButtonsLabel)
                            .addGroup(tablesSelectionPanelLayout.createSequentialGroup()
                                .addComponent(jobResultsToggleButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(timePeriodsToggleButton)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        tablesSelectionPanelLayout.setVerticalGroup(
            tablesSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablesSelectionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tableButtonsLabel)
                .addGap(4, 4, 4)
                .addGroup(tablesSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jobResultsToggleButton)
                    .addComponent(timePeriodsToggleButton))
                .addGap(18, 18, 18)
                .addComponent(resultsTableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
	}

	/**
     * 
     */
    private void buildTestPanelLayout() {
        javax.swing.GroupLayout viewTestPanelLayout = new javax.swing.GroupLayout(viewTestPanel);
        viewTestPanel.setLayout(viewTestPanelLayout);
        viewTestPanelLayout.setHorizontalGroup(
            viewTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewTestPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(viewTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(testListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                    .addComponent(testLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        viewTestPanelLayout.setVerticalGroup(
            viewTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewTestPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(testLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(testListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
	}

	/**
     * 
     */
    private void buildResultsDataPanelLayout() {
        javax.swing.GroupLayout resultsDataPanelSPInnerLayout = new javax.swing.GroupLayout(resultsDataPanelSPInner);
        resultsDataPanelSPInner.setLayout(resultsDataPanelSPInnerLayout);
        resultsDataPanelSPInnerLayout.setHorizontalGroup(
            resultsDataPanelSPInnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resultsDataPanelSPInnerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(resultsDataPanelSPInnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(viewSectionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chartsSectionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tablesSelectionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(resultsDataPanelSPInnerLayout.createSequentialGroup()
                        .addGroup(resultsDataPanelSPInnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(resultsDataPanelSPInnerLayout.createSequentialGroup()
                                .addGap(eesa.gui.Application.GAP, eesa.gui.Application.GAP, eesa.gui.Application.GAP)
                                .addComponent(helpButton))
                            .addComponent(heading))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        resultsDataPanelSPInnerLayout.setVerticalGroup(
            resultsDataPanelSPInnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resultsDataPanelSPInnerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(heading)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewSectionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chartsSectionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tablesSelectionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(helpButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
	}
    /**
     * 
     */
	private void buildProcessorsPanelLayout() {
        javax.swing.GroupLayout viewProcessorsPanelLayout = new javax.swing.GroupLayout(viewProcessorsPanel);
        viewProcessorsPanel.setLayout(viewProcessorsPanelLayout);
        viewProcessorsPanelLayout.setHorizontalGroup(
            viewProcessorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewProcessorsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(viewProcessorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(processorListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                    .addComponent(processorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        viewProcessorsPanelLayout.setVerticalGroup(
            viewProcessorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewProcessorsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(processorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(processorListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
	}

	/**
     * 
     */
    private void buildChartsSectionPanelLayout() {
        javax.swing.GroupLayout chartsSectionPanelLayout = new javax.swing.GroupLayout(chartsSectionPanel);
        chartsSectionPanel.setLayout(chartsSectionPanelLayout);
        chartsSectionPanelLayout.setHorizontalGroup(
            chartsSectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chartsSectionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(chartsSectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(chartsSectionPanelLayout.createSequentialGroup()
                        .addComponent(chartsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(chartsSectionPanelLayout.createSequentialGroup()
                        .addComponent(chartsHeading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(122, 122, 122))
                    .addGroup(chartsSectionPanelLayout.createSequentialGroup()
                        .addGroup(chartsSectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(chartsSectionPanelLayout.createSequentialGroup()
                                .addComponent(jobsToggleButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(speedToggleButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(energyToggleButton)
                                .addGap(60, 60, 60)
                                .addComponent(singleToggleButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(processorToggleButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(testToggleButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bothToggleButton))
                            .addComponent(exportChartButton))
                        .addContainerGap(130, Short.MAX_VALUE))))
        );
        chartsSectionPanelLayout.setVerticalGroup(
            chartsSectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chartsSectionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chartsHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(chartsSectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jobsToggleButton)
                    .addComponent(speedToggleButton)
                    .addComponent(energyToggleButton)
                    .addComponent(singleToggleButton)
                    .addComponent(processorToggleButton)
                    .addComponent(testToggleButton)
                    .addComponent(bothToggleButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chartsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exportChartButton)
                .addContainerGap())
        );
	}

	/**
     * 
     * @param evt Event
     */
    private void exportDataActionPerformed(final ActionEvent evt) {
        if (resultsTable.getModel() instanceof TimePeriodsDataTableModel) {
            new ExportPeriodsWindow().setVisible(true);
        } else if (resultsTable.getModel() instanceof JobResultsDataTableModel) {
            new ExportResultsWindow().setVisible(true);
        }        
    }
    /**
     * 
     * @param evt Event
     */
    private void processorListValueChanged(final ListSelectionEvent evt) {
        if (!evt.getValueIsAdjusting()) {
            Iterator<ProcessorViewEventListener> i = processorViewEventListeners.iterator();
            while (i.hasNext()) {
                i.next().processorViewStatusChanged(new ProcessorViewEvent(evt));
            }
        }
    }
    /**
     * 
     * @param evt Event
     */
    private void testListValueChanged(final ListSelectionEvent evt) {
        if (!evt.getValueIsAdjusting()) {
            Logger.getLogger(JobResultsView.class.getName()).log(Level.INFO, "Test List Value Status Changed Caught");
            Iterator<TestViewEventListener> i = testViewEventListeners.iterator();
            while (i.hasNext()) {
                i.next().testViewStatusChanged(new TestViewEvent(evt));
            }
        }
    }
    /**
     * 
     * @param evt Event
     */
    private void jobsToggleButtonItemStateChanged(final ItemEvent evt) {
        if (jobsToggleButton.isSelected()) {
            chartsPanel.remove(chart);
            chart = new JobCharts(jobResultsView, chartSplitType);
            chart.setSize(chartsPanel.getSize());
            chartsPanel.addComponentListener(chart);
            chartsPanel.add(chart);
            validate();
            repaint();
        }
    }
    /**
     * 
     * @param evt Event
     */
    private void speedToggleButtonItemStateChanged(final ItemEvent evt) {
        if (speedToggleButton.isSelected()) {
            chartsPanel.remove(chart);
            chart = new SpeedCharts(timePeriodsView, chartSplitType);
            chart.setSize(chartsPanel.getSize());
            chartsPanel.addComponentListener(chart);
            chartsPanel.add(chart);
            validate();
            repaint();            
        }
    }
    /**
     * 
     * @param evt Event
     */
    private void energyToggleButtonItemStateChanged(final ItemEvent evt) {
        if (energyToggleButton.isSelected()) {
            chartsPanel.remove(chart);
            chart = new EnergyCharts(timePeriodsView, chartSplitType);
            chart.setSize(chartsPanel.getSize());
            chartsPanel.addComponentListener(chart);
            chartsPanel.add(chart);
            chartsPanel.validate();
            chartsPanel.repaint();
        }
    }
    /**
     * 
     * @param evt Event
     */
    private void singleToggleButtonItemStateChanged(final ItemEvent evt) {
        if (singleToggleButton.isSelected()) {
            chartSplitType = Charts.SplitType.SINGLE;
            chart.setSplitType(Charts.SplitType.SINGLE);
            chart.validate();
            chart.repaint();
        }
    }
    /**
     * 
     * @param evt Event
     */
    private void processorToggleButtonItemStateChanged(final ItemEvent evt) {
        if (processorToggleButton.isSelected()) {
            chartSplitType = Charts.SplitType.BY_PROCESSOR;
            chart.setSplitType(Charts.SplitType.BY_PROCESSOR);
            chart.validate();
            chart.repaint();
        }
    }
    /**
     * 
     * @param evt Event
     */
    private void testToggleButtonItemStateChanged(final ItemEvent evt) {
        if (testToggleButton.isSelected()) {
            chartSplitType = Charts.SplitType.BY_TEST;
            chart.setSplitType(Charts.SplitType.BY_TEST);
            chart.validate();
            chart.repaint();
        }
    }
    /**
     * 
     * @param evt Event
     */
    private void bothToggleButtonItemStateChanged(final ItemEvent evt) {
        if (bothToggleButton.isSelected()) {
            chartSplitType = Charts.SplitType.BY_BOTH;
            chart.setSplitType(Charts.SplitType.BY_BOTH);
            chart.validate();
            chart.repaint();
        }
    }
    /**
     * 
     * @param evt Event
     */
    private void jobResultsToggleButtonItemStateChanged(final ItemEvent evt) {
        resultsTable.setModel(jobResultsTableModel);
        resultsTable.setRowSorter(jobResultsRowSorter);
        validate();
    }
    /**
     * 
     * @param evt Event
     */
    private void timePeriodsToggleButtonItemStateChanged(final ItemEvent evt) {
        resultsTable.setModel(timePeriodsTableModel);
        resultsTable.setRowSorter(timePeriodsRowSorter);
        validate();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
	/**
	 * 
	 */
    private javax.swing.JToggleButton bothToggleButton;
	/**
	 * 
	 */
    private javax.swing.JLabel chartsHeading;
	/**
	 * 
	 */
    private javax.swing.JPanel chartsPanel;
	/**
	 * 
	 */
    private javax.swing.JPanel chartsSectionPanel;
	/**
	 * 
	 */
    private javax.swing.JToggleButton energyToggleButton;
	/**
	 * 
	 */
    private javax.swing.JButton exportChartButton;
	/**
	 * 
	 */
    private javax.swing.JButton exportData;
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
    private javax.swing.JToggleButton jobResultsToggleButton;
	/**
	 * 
	 */
    private javax.swing.JToggleButton jobsToggleButton;
	/**
	 * 
	 */
    private javax.swing.JLabel processorLabel;
	/**
	 * 
	 */
    private javax.swing.JList<Processor> processorList;
	/**
	 * 
	 */
    private javax.swing.JScrollPane processorListScrollPane;
	/**
	 * 
	 */
    private javax.swing.JToggleButton processorToggleButton;
	/**
	 * 
	 */
    private javax.swing.JPanel resultsDataPanelSPInner;
	/**
	 * 
	 */
    private javax.swing.JTable resultsTable;
	/**
	 * 
	 */
    private javax.swing.JScrollPane resultsTableScrollPane;
	/**
	 * 
	 */
    private javax.swing.JScrollPane scrollPanel;
	/**
	 * 
	 */
    private javax.swing.JToggleButton singleToggleButton;
	/**
	 * 
	 */
    private javax.swing.JToggleButton speedToggleButton;
	/**
	 * 
	 */
    private javax.swing.ButtonGroup splitChartButtonGroup;
	/**
	 * 
	 */
    private javax.swing.JLabel tableButtonsLabel;
	/**
	 * 
	 */
    private javax.swing.ButtonGroup tablesButtonGroup;
	/**
	 * 
	 */
    private javax.swing.JPanel tablesSelectionPanel;
	/**
	 * 
	 */
    private javax.swing.JLabel testLabel;
	/**
	 * 
	 */
    private javax.swing.JList<Test> testList;
	/**
	 * 
	 */
    private javax.swing.JScrollPane testListScrollPane;
	/**
	 * 
	 */
    private javax.swing.JToggleButton testToggleButton;
	/**
	 * 
	 */
    private javax.swing.JToggleButton timePeriodsToggleButton;
	/**
	 * 
	 */
    private javax.swing.ButtonGroup typeChartButtonGroup;
	/**
	 * 
	 */
    private javax.swing.JLabel viewHeading;
	/**
	 * 
	 */
    private javax.swing.JPanel viewProcessorsPanel;
	/**
	 * 
	 */
    private javax.swing.JPanel viewSectionPanel;
	/**
	 * 
	 */
    private javax.swing.JPanel viewTestPanel;
    // End of variables declaration//GEN-END:variables

    /**
     * 
     * @return
     */
    private ProcessorListModel getProcessorListModel() {
        if (pListModel == null) {
            pListModel = new ProcessorListModel(
                    new ArrayList<Processor>(Arrays.asList(simulation.getProcessors()))
                    );
        }
        return pListModel;
    }
    /**
     * 
     * @return
     */
    private TestListModel getTestListModel() {
        if (tListModel == null) {
            tListModel = new TestListModel(simulation.getTestList());
        }
        return tListModel;
    }
    /**
     * 
     * @param l
     */
    public final void addProcessorViewEventListener(final ProcessorViewEventListener l) {
        processorViewEventListeners.add(l);
    }
    /**
     * 
     * @param l
     */
    public final void removeProcessorViewEventListener(final ProcessorViewEventListener l) {
        processorViewEventListeners.remove(l);
    }  
    /**
     * 
     * @param l
     */
    public final void addTestViewEventListener(final TestViewEventListener l) {
        testViewEventListeners.add(l);
    }
    /**
     * 
     * @param l
     */
    public final void removeTestViewEventListener(final TestViewEventListener l) {
        testViewEventListeners.add(l);
    }
}
