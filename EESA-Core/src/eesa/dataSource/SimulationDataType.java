package eesa.dataSource;

import java.lang.reflect.InvocationTargetException;

import eesa.core.Simulation;
import eesa.exceptions.SimulationLoadingException;
import eesa.exceptions.SimulationSavingException;

/**
 * Provides abstraction layer for types of Simulation data storage.
 * @author Philip Whitehouse
 *
 */
public class SimulationDataType {
	/**
	 * 
	 */
	private static Class<? extends SimulationDataType> 
		defaultDataSource;		

	/**
	 * 
	 * @return default data source
	 */
	public static Class<? extends SimulationDataType> 
		getDefaultDataSource() {
		return defaultDataSource;
	}
	
	/**
	 * 
	 * @param ds data source
	 */
	public static void setDefaultDataSource(
			final Class<? extends SimulationDataType> ds) {
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
					.getDeclaredMethod("loadSimulation")
					.invoke(null);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			throw new SimulationLoadingException(e);
		}
	}
	
	/**
	 * Load a simulation via a specified data source.
	 * @param source
	 * @return
	 * @throws SimulationLoadingException
	 */
	public static Simulation loadSimulation(
			final Class<? extends SimulationDataType> source) 
			throws SimulationLoadingException {
		try {
			return (Simulation) source
					.getDeclaredMethod("loadSimulation")
					.invoke(null);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			throw new SimulationLoadingException(e);
		}
	}
	/**
	 * Save a simulation to the default data source.
	 * @param simulation
	 * @throws SimulationSavingException
	 */
	public static void saveSimulation(Simulation simulation)
			throws SimulationSavingException {
		try {
			defaultDataSource.getDeclaredMethod("saveSimulation", Simulation.class)
					.invoke(null,simulation);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			throw new SimulationSavingException(e);
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
					.getDeclaredMethod("saveSimulation", Simulation.class)
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
					.getDeclaredMethod("saveSimulationAs", Simulation.class)
					.invoke(null, simulation);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			throw new SimulationSavingException(e);
		}
	}
}
