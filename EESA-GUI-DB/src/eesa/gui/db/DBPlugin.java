package eesa.gui.db;

import eesa.dataExport.JobDataExport;
import eesa.dataExport.JobResultDataExport;
import eesa.dataExport.PeriodDataExport;
import eesa.dataImport.JobDataImport;
import eesa.db.dataExport.SQLJobDataExport;
import eesa.db.dataExport.SQLJobResultDataExport;
import eesa.db.dataExport.SQLPeriodDataExport;
import eesa.db.dataImport.SQLJobDataImport;
import eesa.gui.PluginConnector;
import eesa.gui.windows.dataExport.jobs.AbstractExportJobsWindow;
import eesa.gui.windows.dataExport.periods.AbstractExportPeriodsWindow;
import eesa.gui.windows.dataExport.results.AbstractExportResultsWindow;
import eesa.gui.windows.dataImport.jobs.AbstractImportJobsWindow;
import eesa.gui.windows.db.dataExport.jobs.SQLExportJobsWindow;
import eesa.gui.windows.db.dataExport.periods.SQLExportPeriodsWindow;
import eesa.gui.windows.db.dataExport.results.SQLExportResultsWindow;
import eesa.gui.windows.db.dataImport.jobs.SQLImportJobsWindow;
/**
 * The module's plug-in connector which 
 * provides the system the details of this module.
 * @author Philip
 */
public class DBPlugin implements PluginConnector {
    /**
     * 
     */
    private String description = 
    		"Structured Query Language (SQL) is the standard for "
    		+ "querying databases. Providing the correct SQL implementation "
			+ "is available along with the JDBC driver, data can be imported "
    		+ "from a variety of common SQL sources, such as MySQL.";
    /**
     * 
     */
    public DBPlugin() {
        
    }
    
    @Override
	public final String getDescription() {
        return description;
    }
    @Override
	public final String toString() {
        return "Structured Query Language (SQL)";
    }
    @Override
	public final boolean hasJobDataImportClass() {
        return true;
    }

    @Override
	public final Class<? extends JobDataImport> getJobDataImportClass() {
        return SQLJobDataImport.class;
    }

    @Override
	public final AbstractImportJobsWindow getNewImportJobsWindow(final JobDataImport data) {
        return new SQLImportJobsWindow((SQLJobDataImport) data);
    }

    @Override
	public final AbstractImportJobsWindow getNewImportJobsWindow() {
        return new SQLImportJobsWindow(new SQLJobDataImport());
    }

    @Override
	public final boolean hasJobDataExportClass() {
        return true;
    }

    @Override
	public final Class<? extends JobDataExport> getJobDataExportClass() {
        return SQLJobDataExport.class;
    }

    @Override
	public final AbstractExportJobsWindow getNewExportJobsWindow(final JobDataExport data) {
        return new SQLExportJobsWindow((SQLJobDataExport) data);
    }

    @Override
	public final AbstractExportJobsWindow getNewExportJobsWindow() {
        return new SQLExportJobsWindow(new SQLJobDataExport());
    }

    @Override
	public final boolean hasJobResultDataExportClass() {
        return true;
    }

    @Override
	public final Class<? extends JobResultDataExport> getJobResultDataExportClass() {
        return SQLJobResultDataExport.class;
    }

    @Override
	public final AbstractExportResultsWindow getNewExportResultsWindow(final JobResultDataExport data) {
        return new SQLExportResultsWindow((SQLJobResultDataExport) data);
    }

    @Override
	public final AbstractExportResultsWindow getNewExportResultsWindow() {
        return new SQLExportResultsWindow(new SQLJobResultDataExport());
    }

    @Override
	public final boolean hasPeriodDataExportClass() {
        return true;
    }

    @Override
	public final Class<? extends PeriodDataExport> getPeriodDataExportClass() {
        return SQLPeriodDataExport.class;
    }

    @Override
	public final AbstractExportPeriodsWindow getNewExportPeriodsWindow(
			final PeriodDataExport data) {
        return new SQLExportPeriodsWindow((SQLPeriodDataExport) data);
    }

    @Override
	public final AbstractExportPeriodsWindow getNewExportPeriodsWindow() {
        return new SQLExportPeriodsWindow(new SQLPeriodDataExport());
    }
    
}
