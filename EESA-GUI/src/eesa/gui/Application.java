package eesa.gui;

import eesa.core.IApplication;
import eesa.core.Job;
import eesa.core.Simulation;
import eesa.core.Simulator;
import eesa.core.Test;
import eesa.core.TestList;
import eesa.dataSource.SimulationDataType;
import eesa.event.SimulationEvent;
import eesa.exceptions.AlgorithmException;
import eesa.exceptions.AlgorithmRuntimeException;
import eesa.exceptions.SimulationLoadingException;
import eesa.exceptions.SimulationSavingException;
import eesa.gui.help.HelpException;
import eesa.gui.fileFilters.ImageFileFilter;
import eesa.gui.help.HelpManager;
import eesa.gui.windows.AboutWindow;
import eesa.gui.windows.AddJobWindow;
import eesa.gui.windows.AddTestWindow;
import eesa.gui.windows.AlterJobWindow;
import eesa.gui.windows.AlterTestWindow;
import eesa.gui.windows.JobGenerationWindow;
import eesa.gui.windows.dataExport.jobs.ExportJobsWindow;
import eesa.gui.windows.dataExport.periods.ExportPeriodsWindow;
import eesa.gui.windows.dataExport.results.ExportResultsWindow;
import eesa.gui.windows.dataImport.jobs.ImportJobsWindow;
import eesa.gui.windows.imageExport.energy.ExportEnergyChartWindow;
import eesa.gui.windows.imageExport.results.ExportJobResultsChartWindow;
import eesa.gui.windows.imageExport.speed.ExportSpeedChartWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * ESA Application is the root class.
 * It provides the main GUI for the system including menus.
 * Singleton
 * @author Philip
 */
public final class Application extends JFrame implements IApplication {
	/**
	 * Font size for body text.
	 */
	public static final int FONT_SIZE = 10;
	/**
	 * Font size for headings.
	 */
	public static final int HEADING_FONT_SIZE = 12;
	/**
	 * Font size for 'step info'.
	 */
	public static final int STEP_FONT_SIZE = 11;
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
	public static final int GAP = 10;
    /**
     * 
     */
    private static Application application;
    /**
     * 
     */
    private static ArrayList<PluginConnector> pluginConnectors;

    /**
     * Provides entry to the GUI - this is the function
     * called by the reflexive loader when launched.
     * @param properties 
     */
    public static void run(final Properties properties) {
        setupHelp(properties);
        loadPlugins(properties);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);            
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                application = new Application();
                application.setVisible(true);
            }
        });
    }
    /**
     * 
     * @param properties
     */
    private static void setupHelp(final Properties properties) {
        try {
            HelpManager.setupHelpSystem(properties);
        } catch (HelpException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.WARNING, null, ex);
        }
    }
    /**
     * 
     * @param prop
     * @throws SAXException
     * @throws IOException
     */
    public static void loadPlugins(final Properties prop) {
        pluginConnectors = new ArrayList<PluginConnector>();
        try {
            File guiFile = new File(prop.getProperty("guiFile"));
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(guiFile);
            doc.getDocumentElement().normalize();
            NodeList pList = doc.getElementsByTagName("plugin");
            for (int p = 0; p < pList.getLength(); p++) {
                if (pList.item(p).getNodeType() == Node.ELEMENT_NODE) {
                    Element pE = (Element) pList.item(p);                    
                    try {
                        @SuppressWarnings("unchecked")
                        Class<PluginConnector> pClass = (Class<PluginConnector>) Class.forName(pE.getAttribute("className"));
                        PluginConnector connector = pClass.getConstructor().newInstance();
                        pluginConnectors.add(connector);
                    } catch (InstantiationException ex) {
                        Logger.getLogger(Application.class.getName()).log(Level.WARNING, "Error occured when creating plugin object from class", ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(Application.class.getName()).log(Level.WARNING, "Access problem occured when creating plugin object", ex);
                    } catch (IllegalArgumentException ex) {
                        Logger.getLogger(Application.class.getName()).log(Level.WARNING, "Bad argument found when creating plugin object", ex);
                    } catch (InvocationTargetException ex) {
                        Logger.getLogger(Application.class.getName()).log(Level.WARNING, "Exception occured when creating plugin object", ex);
                    } catch (NoSuchMethodException ex) {
                        Logger.getLogger(Application.class.getName()).log(Level.WARNING, "Constructor not found for plugin object", ex);
                    } catch (SecurityException ex) {
                        Logger.getLogger(Application.class.getName()).log(Level.WARNING, "Not allowed to create plugin object from class", ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Application.class.getName()).log(Level.WARNING, "Unable to find plugin object class", ex);
                    }                
                }
            }
        } catch (SAXException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);            
        }
    }

    /**
     * 
     * @return
     */
    public static PluginConnector[] getPluginConnectors() {
        return pluginConnectors.toArray(new PluginConnector[]{});
    }
    /**
     * 
     * @return
     */
    public static ImageFileFilter[] getImageFilters() {
        return new ImageFileFilter[]{
            new ImageFileFilter("Portable Network Graphics (PNG) files",
            		new String[]{"PNG", "png"}),
            new ImageFileFilter("Joint Photographic Experts Group (JPEG) files",
            		new String[]{"JPG", "jpg"}),
            new ImageFileFilter("Graphics Interchange Format (GIF) files",
            		new String[]{"GIF", "gif"}),
            new ImageFileFilter("Device Independent Bitmap (BMP) files",
            		new String[]{"BMP", "bmp"})};
    }

    /**
     * 
     */
    private MenuBar mb;
    /**
     * 
     */
    private JPanel centre;    
    /**
     * 
     */
    private Simulator simulator;    
    /**
     * 
     */
    private String title = "EESA Simulator";
    /**
     * Private constructor - creates simulation list and
     * calls GUI builder and creates an initial Simulation Object.
     */    
    private Application() {
        simulator = Simulator.getSimulator();
        simulator.addSimulationEventListener(this);
        buildGUILayout();
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        newSimulation();        
    }
    /**
     * 
     */
    private void buildGUILayout() {
        buildMenuBar();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(final WindowEvent e) {
            }
            @Override
            public void windowClosing(final WindowEvent e) {
                exit();
            }
            @Override
            public void windowClosed(final WindowEvent e) {
            }
            @Override
            public void windowIconified(final WindowEvent e) {
            }
            @Override
            public void windowDeiconified(final WindowEvent e) {
            }
            @Override
            public void windowActivated(final WindowEvent e) {
            }
            @Override
            public void windowDeactivated(final WindowEvent e) {
            }
        });
        pack();
        setSize(800, 600);
    }
    /**
     * 
     */
    private void buildMenuBar() {
        mb = new MenuBar(this);
        setJMenuBar(mb);
    }
    /**
     * 
     */
    public void newSimulation() {
        Simulation s = new Simulation(simulator);
        changeCurrentSimulation(s);
        addSimulation(s);
    }
    /**
     * 
     */
    public void openSimulation() {
        Simulation s = load();
        if (s != null) {
            changeCurrentSimulation(s);
            addSimulation(s);
        }
    }
    /**
     * 
     * @return 
     */
    private Simulation load() {
    	try {
    		return SimulationDataType.loadSimulation();
    	} catch (SimulationLoadingException ex) {
	        JOptionPane.showMessageDialog(Application.getApplication(), ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        Logger.getLogger(Application.class.getName()).log(Level.WARNING, ex.getMessage());
	        return null;
    	}
    }
    /**
     * Closes the current simulation.
     */
    public void closeSimulation() {
        Logger.getLogger(Application.class.getName()).log(Level.INFO, "Closing");
        if (simulator.getSimulationCount() > 1) {
            Logger.getLogger(Application.class.getName()).log(Level.FINE, "More than 1 simulation. Closing");            
            removeSimulation(simulator.getCurrentSimulation());
            changeCurrentSimulation(simulator.getSimulation(0));
        } else {
            Logger.getLogger(Application.class.getName()).log(Level.FINE, "Only than 1 simulation. Replacing");            
            Simulation s = new Simulation(simulator);
            removeSimulation(simulator.getCurrentSimulation());
            changeCurrentSimulation(s);
            addSimulation(s);
        }
        validate();
    }   
    /**
     * Exits the Application. - System.exit(0) employed;
     */
    public void exit() {
        if (simulator.getSimulationCount() > 0) {
            if (simulator.hasUnsavedSimulations()) {
                int saveChoice = JOptionPane.showConfirmDialog(this, "Would you like to save the open simulations before quitting?", "Save & Quit?", JOptionPane.YES_NO_CANCEL_OPTION);
                if (saveChoice == JOptionPane.YES_OPTION) {
                    saveAllSimulation();
                } else if (saveChoice == JOptionPane.CANCEL_OPTION) {
                    return;
                }
            }
        }
        int quitConfirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to quit?", "Quit?", JOptionPane.YES_NO_OPTION);
        if (quitConfirm == JOptionPane.YES_OPTION) {
            setVisible(false);
            dispose();
            //Necessary to avoid hanging issues with Help
            System.exit(0);
        }
    }
    /**
     * 
     */
    public void generateJobs() {
        new JobGenerationWindow(simulator.getCurrentSimulation()).setVisible(true);
    }
    /**
     * 
     */
    public void addJob() {
        AddJobWindow addJob = new AddJobWindow(simulator.getCurrentSimulation());
        addJob.setVisible(true);
    }
    /**
     * 
     */
    public void alterJob() {
        if (centre instanceof SimulationDataPanel 
        		&& ((SimulationDataPanel) centre).getSelectedTab()
        			== SimulationDataPanel.Tab.JOBS) {
            Job j = ((SimulationDataPanel) centre).getSelectedJob();
            if (j != null) {
                new AlterJobWindow(j).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(centre, "No job selected",
                		"Error!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(centre, "No job selected",
            		"Error!", JOptionPane.ERROR_MESSAGE);
        }        
    }
    /**
     * 
     */
    public void deleteJob() {
        if (centre instanceof SimulationDataPanel 
        		&& ((SimulationDataPanel) centre).getSelectedTab() 
        			== SimulationDataPanel.Tab.JOBS) {
            Job j = ((SimulationDataPanel) centre).getSelectedJob();
            if (j != null) {
                int confirm = JOptionPane.showConfirmDialog(centre,
                		"Are you sure you want to delete the selected job?");
                if (confirm == JOptionPane.YES_OPTION) {
                    simulator.getCurrentSimulation().getJobSet().removeJob(j);
                    ((SimulationDataPanel) centre).validate();
                    ((SimulationDataPanel) centre).repaint();                
                }
            } else {
                JOptionPane.showMessageDialog(centre,
                		"No job selected", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(centre,
            		"No job selected", "Error!", JOptionPane.ERROR_MESSAGE);
        }        
    }  
    /**
     * 
     */
    public void newTest() {
        AddTestWindow addtest = 
        		new AddTestWindow(this, simulator.getCurrentSimulation());
        addtest.setVisible(true);
    }
    /**
     * 
     */
    public void alterTest() {
        if (centre instanceof SimulationDataPanel 
        		&& ((SimulationDataPanel) centre).getSelectedTab()
        			== SimulationDataPanel.Tab.TESTS) {
            Test t = ((SimulationDataPanel) centre).getSelectedTest();
            if (t != null) {
                new AlterTestWindow(t).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(centre,
            		"No test selected", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(centre,
            		"No test selected", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
     * 
     */
    public void deleteTest() {
        if (centre instanceof SimulationDataPanel
    		&& ((SimulationDataPanel) centre).getSelectedTab()
    			== SimulationDataPanel.Tab.TESTS) {
            Test t = ((SimulationDataPanel) centre).getSelectedTest();
            if (t != null) {
                int confirm = JOptionPane.showConfirmDialog(centre, 
                		"Are you sure you want to delete the selected test?");
                if (confirm == JOptionPane.YES_OPTION) {
                    simulator.getCurrentSimulation()
                    .getTestList().removeTest(t);
                    ((SimulationDataPanel) centre).validate();
                    ((SimulationDataPanel) centre).repaint();                
                }
            } else {
                JOptionPane.showMessageDialog(centre, "No test selected",
                		"Error!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(centre, "No test selected",
            		"Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
     * 
     */
    public void runTests() {
        try {
            simulator.getCurrentSimulation().runAlgorithms();
        } catch (AlgorithmRuntimeException e) {
            JOptionPane.showMessageDialog(rootPane,
            		"You need atleast: 1 test, 1 job and 1 processor first!"); 
            return;
        } catch (AlgorithmException ex) {
                JOptionPane.showMessageDialog(null,
                    ex.getMessage(),
                    "Algorithm Error",
                    JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(TestList.class.getName())
                .log(Level.SEVERE, null, ex);   
                return;
        }
        if (simulator.getCurrentSimulation().hasResults()) {
            mb.setIsEnabledResultsMenu(true);
            if (centre != null) {
                remove(centre);
            }
            centre = new ResultsDataPanel(this,
            		simulator.getCurrentSimulation());
            centre.setVisible(true);
            add(centre);
            validate();
            Logger.getLogger(Application.class.getName())
            	.log(Level.INFO, "Finished");
        } else {
            JOptionPane.showMessageDialog(rootPane,
            		"No results were produced.");
        }
    }
    /**
     * 
     */
    public void about() {
        AboutWindow aboutWindow = new AboutWindow();
        aboutWindow.setVisible(true);
    }  
    /**
     * 
     * @param s 
     */
    private void changeCurrentSimulation(final Simulation s) {
        simulator.setCurrentSimulation(s);        
        updateGUI(s);
        updateTitle();
        validate();
    }
    /**
     * 
     * @param s Simulation
     */
    private void updateGUI(final Simulation s) {
        final Application app = this;
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                if (centre != null) {
                    remove(centre);
                }        
                if (s != null) {
                    mb.setIsEnabledSimulationMenu(true);
                    if (s.getTestList().hasResults()) {
                        mb.setIsEnabledResultsMenu(true);
                        centre = new ResultsDataPanel(app, s);
                    } else {
                        
                            centre = new SimulationDataPanel(app, s);
                            centre.setVisible(true);
                    }
                    add(centre);
                } else {
                    mb.setIsEnabledResultsMenu(false);
                }
                app.validate();
                app.repaint();
            }
        });
    }
    /**
     * 
     * @param s 
     */
    private void addSimulation(final Simulation s) {
        if (s != null) {
            SimulationMenuItem smi = new SimulationMenuItem(s);
            smi.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent e) {
                    changeCurrentSimulation((Simulation) e.getSource());
                }                
            });
            simulator.addSimulation(s);
            mb.addSimulationMenuItemToList(smi);
        }
    }
    /**
     * 
     * @param s 
     */
    private void removeSimulation(final Simulation s) {
        Logger.getLogger(Application.class.getName())
        	.log(Level.INFO, "Removing simulation");
        mb.removeSimulationFromList(s);        
        simulator.removeSimulation(s);
    }
    /**
     * 
     */
    public void updateTitle() {
        String newTitle = this.title;
        if (simulator.getCurrentSimulation() != null) {
            newTitle += " - " + simulator.getCurrentSimulation().getName();
            if (simulator.getCurrentSimulation().isSaveRequired()) {
                newTitle += "*";
            }
        }
        setTitle(newTitle);
    }
    /**
     * 
     * @param event 
     */
    @Override
    public void simulationAdded(final SimulationEvent event) {
        //Can safely ignore
    }
    /**
     * 
     * @param event 
     */
    @Override
    public void simulationRemoved(final SimulationEvent event) {
        //Can safely ignore
    }
    /**
     * 
     * @param event 
     */
    @Override
    public void simulationChanged(final SimulationEvent event) {
        //Can safely ignore
    }
    /**
     * 
     * @param event 
     */
    @Override
    public void simulationAltered(final SimulationEvent event) {
        //Can safely ignore
    }
    /**
     * 
     */
    void exportSpeedChart() {
        new ExportSpeedChartWindow().setVisible(true);
    }
    /**
     * 
     */
    void exportEnergyChart() {
        new ExportEnergyChartWindow().setVisible(true);
    }
    /**
     * 
     */
    void exportJobResultsChart() {
        new ExportJobResultsChartWindow().setVisible(true);
    }
    /**
     * 
     */
    void exportJobResultsTable() {
        new ExportResultsWindow().setVisible(true);
    }
    /**
     * 
     */
    void exportTimePeriodsTable() {
        new ExportPeriodsWindow().setVisible(true);
    }
    /**
     * 
     */
    void importJobs() {
        new ImportJobsWindow().setVisible(true);
    }
    /**
     * 
     */
    void exportJobs() {
        new ExportJobsWindow().setVisible(true);
    }

    /**
     * 
     * @param event 
     */
    @Override
    public void simulationSaveRequiredChangedEvent(
    		final SimulationEvent event) {
        updateTitle();
    }
    /**
     * @return running instance
     */
    public static Application getApplication() {
		return application;
	}
    /**
     * 
     */
	public void saveCurrentSimulation() {
        saveSimulation(simulator.getCurrentSimulation());
	}
    /**
     * 
     */
	public void saveSimulation(Simulation sim) {
        Logger.getLogger(Application.class.getName()).log(Level.INFO, "Saving");
        try {
        	SimulationDataType.saveSimulation(simulator.getCurrentSimulation());
    	} catch (SimulationSavingException ex) {
	        JOptionPane.showMessageDialog(Application.getApplication(), ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        Logger.getLogger(Application.class.getName()).log(Level.WARNING, ex.getMessage());
    	}
        
	}	
	/**
	 * 
	 */
	public void saveAsCurrentSimulation() {
		Logger.getLogger(Application.class.getName()).log(Level.INFO, "Saving");
        try {
        	SimulationDataType.saveSimulationAs(simulator.getCurrentSimulation());
    	} catch (SimulationSavingException ex) {
	        JOptionPane.showMessageDialog(Application.getApplication(), ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        Logger.getLogger(Application.class.getName()).log(Level.WARNING, ex.getMessage());
    	}
	}
	/**
	 * 
	 */
	public void saveAllSimulation() {
		Logger.getLogger(Application.class.getName()).log(Level.INFO, "Saving All");
        Simulation[] simulations  = simulator.getSimulations();
        for (int s = 0; s < simulations.length; s++) {
            saveSimulation(simulations[s]);
        }
	}
}
