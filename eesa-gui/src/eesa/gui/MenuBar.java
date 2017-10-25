package eesa.gui;

import com.whiuk.philip.eesa.core.Simulation;
import eesa.gui.help.HelpManager;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 * Provides the menu bar for the GUI.
 * @author Philip
 */
public class MenuBar extends JMenuBar {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    /**
     * 
     */
    /**
     * 
     */
    /**
     * 
     */
    /**
     * 
     */
    private JMenu fileMenu, simulationMenu, resultsMenu, helpMenu, simulationListSelector;
    /**
     * 
     */
    private final Application app;
    /**
     * 
     * @param a app 
     */
    public MenuBar(final Application a) {
        super();
        this.app = a;
        buildFileMenu();
        buildSimulationMenu();
        buildResultsMenu();
        buildHelpMenu();
        add(fileMenu);
        add(simulationMenu);
        add(resultsMenu);
        add(helpMenu);        
    }
    /**
     * 
     */
    private void buildFileMenu() {
        fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);       
            JMenuItem newS = new JMenuItem("New");
            newS.setMnemonic(KeyEvent.VK_N);
            newS.setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.CTRL_DOWN_MASK));            
            newS.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent e) {
                    app.newSimulation();
                }
            });
            JMenuItem openS = new JMenuItem("Open");        
            openS.setAccelerator(KeyStroke.getKeyStroke('O', InputEvent.CTRL_DOWN_MASK));                        
            openS.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent e) {
                    app.openSimulation();
                }
            });
            JMenuItem saveS = new JMenuItem("Save");        
            saveS.setAccelerator(KeyStroke.getKeyStroke('S', InputEvent.CTRL_DOWN_MASK));
            saveS.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent e) {
                    app.saveCurrentSimulation();
                }
            });
            JMenuItem saveAsS = new JMenuItem("Save As...");        
            saveAsS.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent e) {
                    app.saveAsCurrentSimulation();
                }
            });
            JMenuItem saveAllS = new JMenuItem("Save All");        
            saveAllS.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent e) {
                    app.saveAllSimulation();
                }
            });
            JMenuItem closeS = new JMenuItem("Close Simulation");    
            closeS.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent e) {
                    app.closeSimulation();
                }
            });            
            JMenuItem exit = new JMenuItem("Exit");                
            newS.setMnemonic(KeyEvent.VK_X);
            exit.setAccelerator(KeyStroke.getKeyStroke('Q', InputEvent.CTRL_DOWN_MASK));            
            exit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent e) {
                    app.exit();
                }
            });        
        fileMenu.add(newS);
        fileMenu.add(openS);
        fileMenu.add(saveS);
        fileMenu.add(saveAsS);
        fileMenu.add(saveAllS);
        fileMenu.add(closeS);
        fileMenu.add(exit);               
    }
    /**
     * 
     */
    private void buildSimulationMenu() {
        simulationMenu = new JMenu("Simulation");
        simulationMenu.setEnabled(false);
        simulationMenu.setMnemonic(KeyEvent.VK_S);
            simulationListSelector = new JMenu("Switch Simulation");            
            simulationListSelector.setEnabled(false);
            JMenuItem importJobs = new JMenuItem("Import Jobs");            
            importJobs.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent e) {
                    app.importJobs();
                }
            });  
            JMenuItem exportJobs = new JMenuItem("Export Jobs");            
            exportJobs.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent e) {
                    app.exportJobs();
                }
            });  
            JMenuItem generateJobs = new JMenuItem("Generate Jobs");
            generateJobs.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent e) {
                    app.generateJobs();
                }
            });
            JMenu alterJobSet = new JMenu("Alter JobSet");    
                JMenuItem addJob = new JMenuItem("Add Job");
                addJob.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(final ActionEvent e) {
                        app.addJob();
                    }
                });
                JMenuItem alterJob = new JMenuItem("Alter Job");
                alterJob.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(final ActionEvent e) {
                        app.alterJob();
                    }
                });
                JMenuItem deleteJob = new JMenuItem("Delete Job");
                deleteJob.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(final ActionEvent e) {
                        app.deleteJob();
                    }
                });                
            alterJobSet.add(addJob);
            alterJobSet.add(alterJob);
            alterJobSet.add(deleteJob);                
            JMenu tests = new JMenu("Tests");                
                JMenuItem newTest = new JMenuItem("New Test");
                newTest.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(final ActionEvent e) {
                        app.newTest();
                    }
                });
                
                JMenuItem alterTest = new JMenuItem("Alter Test");
                alterTest.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(final ActionEvent e) {
                        app.alterTest();
                    }
                });

                JMenuItem deleteTest = new JMenuItem("Delete Test");
                deleteTest.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(final ActionEvent e) {
                        app.deleteTest();
                    }
                });
                tests.add(newTest);
                tests.add(alterTest);
                tests.add(deleteTest);                
            JMenuItem runTests = new JMenuItem("Run Tests");
            runTests.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent e) { 
                    app.runTests();
                }
            });                
        simulationMenu.add(simulationListSelector);
        simulationMenu.add(importJobs);
        simulationMenu.add(exportJobs);        
        simulationMenu.add(generateJobs);
        simulationMenu.add(alterJobSet);
        simulationMenu.add(tests);
        simulationMenu.add(runTests);                
    }
    /**
     * 
     */
    private void buildResultsMenu() {
        resultsMenu = new JMenu("Results");
        resultsMenu.setMnemonic(KeyEvent.VK_R);
        resultsMenu.setEnabled(true);
            JMenu viewCharts = new JMenu("View Chart");
                JMenuItem viewSpeedChart = new JMenuItem("Speed Chart");
                JMenuItem viewEnergyChart = new JMenuItem("Energy Chart");
                JMenuItem viewJobChart = new JMenuItem("Job Chart");   
            viewCharts.add(viewSpeedChart);
            viewCharts.add(viewEnergyChart);
            viewCharts.add(viewJobChart);

            JMenu viewTables = new JMenu("View Table");
                JMenuItem viewJobResultsTable = new JMenuItem("Job Results Table");
                JMenuItem viewTimePeriodsTable = new JMenuItem("Time Periods Table");
            viewTables.add(viewJobResultsTable);
            viewTables.add(viewTimePeriodsTable);
            
            JMenu exportCharts = new JMenu("Export Chart");
                JMenuItem exportSpeedChart = new JMenuItem("Speed Chart");
                exportSpeedChart.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(final ActionEvent e) {
                        app.exportSpeedChart();
                    }
                });                
                JMenuItem exportEnergyChart = new JMenuItem("Energy Chart");
                exportEnergyChart.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(final ActionEvent e) {
                        app.exportEnergyChart();
                    }
                });                
                JMenuItem exportJobResultsChart = new JMenuItem("Job Results Chart");   
                exportJobResultsChart.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(final ActionEvent e) {
                        app.exportJobResultsChart();
                    }
                });
            exportCharts.add(exportSpeedChart);
            exportCharts.add(exportEnergyChart);
            exportCharts.add(exportJobResultsChart);
            
            JMenu exportTables = new JMenu("Export Table");
                JMenuItem exportJobResultsTable = new JMenuItem("Job Results Table");
                exportJobResultsTable.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(final ActionEvent e) {
                        app.exportJobResultsTable();
                    }
                });                
                JMenuItem exportTimePeriodsTable = new JMenuItem("Time Periods Table");
                exportTimePeriodsTable.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(final ActionEvent e) {
                        app.exportTimePeriodsTable();
                    }
                });                
            exportTables.add(exportJobResultsTable);
            exportTables.add(exportTimePeriodsTable);
        resultsMenu.add(viewCharts);
        resultsMenu.add(viewTables);
        resultsMenu.add(exportCharts);
        resultsMenu.add(exportTables);
    }
    /**
     * 
     */
    private void buildHelpMenu() {
        helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);
        helpMenu.setEnabled(true);
            JMenuItem contents = new JMenuItem("Help Contents");
            contents.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent e) {
                    HelpManager.showHelp(e);
                }
            });   
            JMenuItem online = new JMenuItem("Online Help");
            online.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent e) {
                    if (Desktop.isDesktopSupported()) {
                        try {
                            Desktop.getDesktop().browse(HelpManager.getURI());
                        } catch (IOException ex) {
                            Logger.getLogger(MenuBar.class.getName()).log(
                                    Level.SEVERE, "HELP: Unable to open URI - I/O Exception - Scheme may be unsupported.", ex);
                            JOptionPane.showMessageDialog(app, "Unable to view online help", "Online Help Error", JOptionPane.ERROR_MESSAGE);
                        } catch (NullPointerException ex) {
                            Logger.getLogger(MenuBar.class.getName()).log(
                                    Level.SEVERE, "HELP: Unable to open URI - Null Pointer Exception - Help System passed a null value back.", ex);
                            JOptionPane.showMessageDialog(app, "Unable to view online help", "Online Help Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        Logger.getLogger(MenuBar.class.getName()).log(
                                    Level.SEVERE, "HELP: Unable to open online help .");
                        JOptionPane.showMessageDialog(app, "HELP: Unable to view online help", "Online Help Error", JOptionPane.ERROR_MESSAGE);                        
                    }
                }
            });            
            JMenuItem about = new JMenuItem("About");
            about.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent e) {
                    app.about();
                }
            });
        helpMenu.add(contents);
        helpMenu.add(online);        
        helpMenu.add(about);
    }
    /**
     * 
     * @param enabled 
     */
    public final void setIsEnabledResultsMenu(final boolean enabled) {
        resultsMenu.setEnabled(enabled);
    }
    /**
     * 
     * @param enabled 
     */
    public final void setIsEnabledSimulationMenu(final boolean enabled) {
        simulationMenu.setEnabled(enabled);
    }
    /**
     * 
     * @param s 
     */
    public final void addSimulationMenuItemToList(final SimulationMenuItem s) {
        simulationListSelector.add(s);
        simulationListSelector.setEnabled(true);
        simulationListSelector.validate();
    }
    /**
     * 
     * @param s
     */
    public final void removeSimulationMenuItemFromList(final SimulationMenuItem s) {
        simulationListSelector.remove(s);
        if (simulationListSelector.getSubElements().length == 0) {
            simulationListSelector.setEnabled(false);
        }
        validate();
        repaint();
    }
    /**
     * 
     * @param s
     * @return
     */
    final SimulationMenuItem removeSimulationFromList(final Simulation s) {
        Component[] menuComponents = simulationListSelector.getMenuComponents();
        for (int i = 0; i < menuComponents.length; i++) {
            if (menuComponents[i] instanceof SimulationMenuItem) {
                SimulationMenuItem smi = (SimulationMenuItem) menuComponents[i];
                if (s.equals(smi.getSimulation())) {
                    removeSimulationMenuItemFromList(smi);
                }
            }
        }
        return null;
    }
}
