package eesa.gui;

import eesa.dataExport.JobDataExport;
import eesa.dataExport.JobResultDataExport;
import eesa.dataExport.PeriodDataExport;
import eesa.dataImport.JobDataImport;
import eesa.gui.windows.dataExport.jobs.AbstractExportJobsWindow;
import eesa.gui.windows.dataExport.periods.AbstractExportPeriodsWindow;
import eesa.gui.windows.dataExport.results.AbstractExportResultsWindow;
import eesa.gui.windows.dataImport.jobs.AbstractImportJobsWindow;

/**
 * Provides an interface for plug-ins which can provide certain functionality.
 * @author Philip
 */
public interface PluginConnector {

    /**
     * 
     * @return
     */
    @Override
    String toString();
    /**
     * 
     * @return
     */
    String getDescription();

    /**
     * 
     * @return
     */
    boolean hasJobDataImportClass();
    /**
     * 
     * @return
     */
    Class<? extends JobDataImport> getJobDataImportClass();
    /**
     * 
     * @param data
     * @return
     */
    AbstractImportJobsWindow getNewImportJobsWindow(JobDataImport data);
    /**
     * 
     * @return
     */
    AbstractImportJobsWindow getNewImportJobsWindow();
    
    /**
     * 
     * @return
     */
    boolean hasJobDataExportClass();
    /**
     * 
     * @return
     */
    Class<? extends JobDataExport> getJobDataExportClass();
    /**
     * 
     * @param data
     * @return
     */
    AbstractExportJobsWindow getNewExportJobsWindow(JobDataExport data);
    /**
     * 
     * @return
     */
    AbstractExportJobsWindow getNewExportJobsWindow();

    /**
     * 
     * @return
     */
    boolean hasJobResultDataExportClass();
    /**
     * 
     * @return
     */
    Class<? extends JobResultDataExport> getJobResultDataExportClass();
    /**
     * 
     * @param data
     * @return
     */
    AbstractExportResultsWindow getNewExportResultsWindow(JobResultDataExport data);
    /**
     * 
     * @return
     */
    AbstractExportResultsWindow getNewExportResultsWindow();    

    /**
     * 
     * @return
     */
    boolean hasPeriodDataExportClass();
    /**
     * 
     * @return
     */
    Class<? extends PeriodDataExport> getPeriodDataExportClass();
    /**
     * 
     * @param data
     * @return
     */
    AbstractExportPeriodsWindow getNewExportPeriodsWindow(PeriodDataExport data);
    /**
     * 
     * @return
     */
    AbstractExportPeriodsWindow getNewExportPeriodsWindow();
    
}
