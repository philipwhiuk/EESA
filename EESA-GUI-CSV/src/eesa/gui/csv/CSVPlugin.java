package eesa.gui.csv;

import eesa.csv.dataExport.CSVJobDataExport;
import eesa.csv.dataExport.CSVJobResultDataExport;
import eesa.csv.dataExport.CSVPeriodDataExport;
import eesa.csv.dataImport.CSVJobDataImport;
import eesa.dataExport.JobDataExport;
import eesa.dataExport.JobResultDataExport;
import eesa.dataExport.PeriodDataExport;
import eesa.dataImport.JobDataImport;
import eesa.gui.PluginConnector;
import eesa.gui.windows.csv.dataExport.jobs.CSVExportJobsWindow;
import eesa.gui.windows.csv.dataExport.periods.CSVExportPeriodsWindow;
import eesa.gui.windows.csv.dataExport.results.CSVExportResultsWindow;
import eesa.gui.windows.csv.dataImport.jobs.CSVImportJobsWindow;
import eesa.gui.windows.dataExport.jobs.AbstractExportJobsWindow;
import eesa.gui.windows.dataExport.periods.AbstractExportPeriodsWindow;
import eesa.gui.windows.dataExport.results.AbstractExportResultsWindow;
import eesa.gui.windows.dataImport.jobs.AbstractImportJobsWindow;

/**
 * The module's plug-in connector which provides
 * the system the details of this module.
 * @author Philip
 */
public class CSVPlugin implements PluginConnector {
    /**
     * 
     */
    static final String DESCRIPTION =
    		"Comma-Separated Format is a common format "
    		+ "for passing information between software. "
            + "Note that while the default separator (delimiter) "
    		+ "is a comma as suggested, this can be changed.";
    /**
     * 
     * @param e 
     */
    public CSVPlugin() {
        
    }
    
    @Override
	public final String getDescription() {
        return DESCRIPTION;
    }

    @Override
	public final String toString() {
        return "Comma-Separated Values (CSV) File";
    }
    @Override
	public final boolean hasJobDataImportClass() {
        return true;
    }

    @Override
	public final Class<? extends JobDataImport> getJobDataImportClass() {
        return CSVJobDataImport.class;
    }

    @Override
	public final AbstractImportJobsWindow getNewImportJobsWindow(
    		final JobDataImport data) {
        return new CSVImportJobsWindow((CSVJobDataImport) data);
    }

    @Override
	public final AbstractImportJobsWindow getNewImportJobsWindow() {
        return new CSVImportJobsWindow(new CSVJobDataImport());
    }

    @Override
	public final boolean hasJobDataExportClass() {
        return true;
    }

    @Override
	public final Class<? extends JobDataExport> getJobDataExportClass() {
        return CSVJobDataExport.class;
    }

    @Override
	public final AbstractExportJobsWindow getNewExportJobsWindow(
    		final JobDataExport data) {
        return new CSVExportJobsWindow((CSVJobDataExport) data);
    }

    @Override
	public final AbstractExportJobsWindow getNewExportJobsWindow() {
        return new CSVExportJobsWindow(new CSVJobDataExport());
    }

    @Override
	public final boolean hasJobResultDataExportClass() {
        return true;
    }

    @Override
	public final Class<? extends JobResultDataExport> 
    	getJobResultDataExportClass() {
        return CSVJobResultDataExport.class;
    }

    @Override
	public final AbstractExportResultsWindow getNewExportResultsWindow(
    		final JobResultDataExport data) {
        return new CSVExportResultsWindow((CSVJobResultDataExport) data);
    }

    @Override
	public final AbstractExportResultsWindow getNewExportResultsWindow() {
        return new CSVExportResultsWindow(new CSVJobResultDataExport());
    }

    /**
     * 
     * @return
     */
    @Override
	public final boolean hasPeriodDataExportClass() {
        return true;
    }

    /**
     * 
     * @return
     */
    @Override
	public final Class<? extends PeriodDataExport> getPeriodDataExportClass() {
        return CSVPeriodDataExport.class;
    }

    @Override
	public final AbstractExportPeriodsWindow getNewExportPeriodsWindow(
    		final PeriodDataExport data) {
        return new CSVExportPeriodsWindow((CSVPeriodDataExport) data);
    }

    @Override
	public final AbstractExportPeriodsWindow getNewExportPeriodsWindow() {
        return new CSVExportPeriodsWindow(new CSVPeriodDataExport());
    }
    
}
