package eesa.gui.windows.algorithms;

import com.whiuk.philip.eesa.algorithms.BasicSingleJobAndProcessorAlgorithm;
import com.whiuk.philip.eesa.algorithms.EESAAlgorithm;

/**
 * 
 * @author Philip Whitehouse
 *
 */
public class BasicSingleJobAndProcessorAlgorithmPanel extends
		EESAAlgorithmPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Algorithm.
	 */
	private BasicSingleJobAndProcessorAlgorithm algorithm = 
			new BasicSingleJobAndProcessorAlgorithm();
	

	@Override
	public final EESAAlgorithm getAlgorithm() {
		return algorithm;
	}

}
