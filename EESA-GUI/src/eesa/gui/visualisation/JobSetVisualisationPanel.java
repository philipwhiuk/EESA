package eesa.gui.visualisation;

import eesa.core.JobSet;
import eesa.gui.SimulationDataPanel;

/**
 * Visualisation of a job set.
 * @author Philip Whitehouse
 *
 */
public abstract class JobSetVisualisationPanel 
	extends InputDataVisualisationPanel {
	/**
	 * Visualised {@link JobSet}.
	 */
	private final JobSet jobset;
	/**
	 * 
	 */
	private SimulationDataPanel parent;

	/**
	 * 
	 * @param parent 
	 * @param js
	 */
	public JobSetVisualisationPanel(SimulationDataPanel parent, final JobSet js) {
		this.parent = parent;
		this.jobset = js;
	}
	
	/**
	 * 
	 * @return job set
	 */
	public final JobSet getJobSet() {
		return jobset;
	}
}
