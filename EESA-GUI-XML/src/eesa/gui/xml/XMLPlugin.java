package eesa.gui.xml;

import eesa.dataExport.JobDataExport;
import eesa.dataExport.JobResultDataExport;
import eesa.dataExport.PeriodDataExport;
import eesa.dataImport.JobDataImport;
import eesa.gui.PluginConnector;
import eesa.gui.windows.dataExport.jobs.AbstractExportJobsWindow;
import eesa.gui.windows.dataExport.periods.AbstractExportPeriodsWindow;
import eesa.gui.windows.dataExport.results.AbstractExportResultsWindow;
import eesa.gui.windows.dataImport.jobs.AbstractImportJobsWindow;
import eesa.gui.windows.xml.dataExport.jobs.XMLExportJobsWindow;
import eesa.gui.windows.xml.dataExport.periods.XMLExportPeriodsWindow;
import eesa.gui.windows.xml.dataExport.results.XMLExportResultsWindow;
import eesa.gui.windows.xml.dataImport.jobs.XMLImportJobsWindow;
import eesa.xml.dataExport.XMLJobDataExport;
import eesa.xml.dataExport.XMLJobResultDataExport;
import eesa.xml.dataExport.XMLPeriodDataExport;
import eesa.xml.dataImport.XMLJobDataImport;

/**
 * The module's plug-in connector which provides the system the details of this module.
 * @author Philip
 */
public class XMLPlugin implements PluginConnector {
    /**
     * 
     */
    private static String description = "The simulator stores its data in the human and machine-readable eXtensible Markup Language (XML). "
            + "In addition to merge multiple files it is also possible to read data from other XML formats";
    /**
     * 
     * @param e 
     */
    public XMLPlugin() {
        
    }
    
    @Override
	public final String getDescription() {
        return description;
    }
    @Override
	public final String toString() {
        return "eXtensible Markup Language (XML) File";
    }
    @Override
	public final boolean hasJobDataImportClass() {
        return true;
    }

    @Override
	public final Class<? extends JobDataImport> getJobDataImportClass() {
        return XMLJobDataImport.class;
    }

    @Override
	public final AbstractImportJobsWindow getNewImportJobsWindow(final JobDataImport data) {
        return new XMLImportJobsWindow((XMLJobDataImport) data);
    }

    @Override
	public final AbstractImportJobsWindow getNewImportJobsWindow() {
        return new XMLImportJobsWindow(new XMLJobDataImport());
    }

    @Override
	public final boolean hasJobDataExportClass() {
        return true;
    }
    @Override
	public final Class<? extends JobDataExport> getJobDataExportClass() {
        return XMLJobDataExport.class;
    }

    @Override
	public final AbstractExportJobsWindow getNewExportJobsWindow(final JobDataExport data) {
        return new XMLExportJobsWindow((XMLJobDataExport) data);
    }

    @Override
	public final AbstractExportJobsWindow getNewExportJobsWindow() {
        return new XMLExportJobsWindow(new XMLJobDataExport());
    }
    @Override
	public final boolean hasJobResultDataExportClass() {
        return true;
    }
    @Override
	public final Class<? extends JobResultDataExport> getJobResultDataExportClass() {
        return XMLJobResultDataExport.class;
    }

    @Override
	public final AbstractExportResultsWindow getNewExportResultsWindow(final JobResultDataExport data) {
        return new XMLExportResultsWindow((XMLJobResultDataExport) data);
    }

    @Override
	public final AbstractExportResultsWindow getNewExportResultsWindow() {
        return new XMLExportResultsWindow(new XMLJobResultDataExport());
    }

    @Override
	public final boolean hasPeriodDataExportClass() {
        return true;
    }
    @Override
	public final Class<? extends PeriodDataExport> getPeriodDataExportClass() {
        return XMLPeriodDataExport.class;
    }

    @Override
	public final AbstractExportPeriodsWindow getNewExportPeriodsWindow(
			final PeriodDataExport data) {
        return new XMLExportPeriodsWindow((XMLPeriodDataExport) data);
    }

    @Override
	public final AbstractExportPeriodsWindow getNewExportPeriodsWindow() {
        return new XMLExportPeriodsWindow(new XMLPeriodDataExport());
    }
    
}
