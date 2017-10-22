package eesa.gui.dataSource;

import java.lang.reflect.InvocationTargetException;
import com.whiuk.philip.eesa.core.Simulation;
import com.whiuk.philip.eesa.dataSource.SimulationDataType;
import com.whiuk.philip.eesa.exceptions.SimulationLoadingException;
import com.whiuk.philip.eesa.exceptions.SimulationSavingException;

/**
 * Manages the GUI handling of loading Simulations from data sources.
 * @author Philip Whitehouse
 *
 */
public class GUISimulationDataType extends SimulationDataType {
	/**
	 * 
	 */
	private static Class<? extends GUISimulationDataType> 
		defaultDataSource;		

	/**
	 * 
	 * @return default data source
	 */
	public static Class<? extends GUISimulationDataType> 
		getDefaultDataSource() {
		return defaultDataSource;
	}
	
	/**
	 * 
	 * @param ds data source
	 */
	public static void setDefaultGUIDataSource(
			final Class<? extends GUISimulationDataType> ds) {
		defaultDataSource = ds;
	}
	
	/**
	 * Load a simulation via the default data source.
	 * @return simulation
	 * @throws SimulationLoadingException exception
	 */
	public static Simulation loadSimulation() 
			throws SimulationLoadingException {
		try {
			return (Simulation) defaultDataSource
					.getDeclaredMethod("loadSimulationViaGUI")
					.invoke(null);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			throw new SimulationLoadingException(e);
		}
	}
	
	/**
	 * Load a simulation via the specific data source.
	 * @param source Data source
	 * @return simulation
	 * @throws SimulationLoadingException exception
	 */
	public static Simulation loadGUISimulation(
			final Class<? extends GUISimulationDataType> source) 
			throws SimulationLoadingException {
		try {
			return (Simulation) source
					.getDeclaredMethod("loadSimulationViaGUI")
					.invoke(null);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			throw new SimulationLoadingException(e);
		}
	}
	
	/**
	 * Save a simulation to the default data source overwriting as specified.
	 * @param simulation
	 * @param overwriteAuto
	 * @throws SimulationSavingException
	 */
	public static void saveSimulation(final Simulation simulation,
			final boolean overwriteAuto) throws SimulationSavingException {
		try {
			defaultDataSource
					.getDeclaredMethod("saveSimulationViaGUI", Simulation.class)
					.invoke(null, simulation, overwriteAuto);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			throw new SimulationSavingException(e);
		}
	}
	/**
	 * Save a simulation to the default data source under a new identifier.
	 * @param simulation
	 * @throws SimulationSavingException
	 */
	public static void saveSimulationAs(final Simulation simulation)
			throws SimulationSavingException {
		try {
			defaultDataSource
					.getDeclaredMethod("saveSimulationAsViaGUI", Simulation.class)
					.invoke(null, simulation);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			throw new SimulationSavingException(e);
		}
	}	
}
