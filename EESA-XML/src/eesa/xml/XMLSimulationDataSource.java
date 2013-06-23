package eesa.xml;

import java.io.File;

import eesa.dataSource.SimulationDataSource;

/**
 * Provides support for XML files as data sources for simulations.
 * @author Philip Whitehouse
 *
 */
public class XMLSimulationDataSource implements SimulationDataSource {
	
	/**
	 * 
	 */
	private final File file;

	/**
	 * 
	 * @param f File to use to store simulation
	 */
	public XMLSimulationDataSource(final File f) {
		this.file = f;
	}

	/**
	 * 
	 * @return the related file
	 */
	public final File getFile() {
		return file;
	}

}
