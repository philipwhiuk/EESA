package eesa.gui.visualisation;

import eesa.gui.DataVisualisationPanel;
import eesa.gui.ResultsDataPanel;
import eesa.gui.event.ProcessorViewEvent;
import eesa.gui.event.ProcessorViewEventListener;
import eesa.gui.event.TestViewEvent;
import eesa.gui.event.TestViewEventListener;

/**
 * 
 * @author Philip Whitehouse
 *
 */
public abstract class ResultsDataVisualisationPanel
	extends DataVisualisationPanel
	implements ProcessorViewEventListener, TestViewEventListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Basic setup - registers to listen for events.
	 * @param parent parent panel
	 */
	public ResultsDataVisualisationPanel(final ResultsDataPanel parent) {
		parent.addProcessorViewEventListener(this);
		parent.addTestViewEventListener(this);
	}
	
}
