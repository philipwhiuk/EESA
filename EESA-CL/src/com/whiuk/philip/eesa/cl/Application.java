package com.whiuk.philip.eesa.cl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Properties;

import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.whiuk.philip.eesa.core.IApplication;
import com.whiuk.philip.eesa.event.SimulationEvent;

/**
 * Command-line EESA Application.
 * @author Philip Whitehouse
 *
 */
public class Application extends Thread implements IApplication {
	/**
	 * Choice of actions to perform.
	 * @author Philip Whitehouse
	 *
	 */
	public final class Action {
		/**
		 * 
		 */
		private Action() {			
		}
		/**
		 * Add a test.
		 */
		public static final int ADD_TEST = 0;
		/**
		 * Delete a test.
		 */
		public static final int DELETE_TEST = 1;
		/**
		 * Add a job.
		 */
		public static final int ADD_JOB = 2;
		/**
		 * Delete job.
		 */
		public static final int DELETE_JOB = 3;

	}

	/**
	 * Options for command line arguments.
	 */
	private static Options options;
	
	
	/**
	 * Entry point from {@link eesa.core.Main}.
	 * @param properties Properties
	 * @param args Command line arguments
	 */
	public static void run(final Properties properties, String[] args) {
		options = new Options();
		CommandLineParser parser = new GnuParser();
		try {
			parser.parse(options, args);
		} catch (ParseException e) {
			throw new CommandLineException(e);
		}
		Application application = new Application();
		application.run();
	}

	/**
	 * 
	 */
	private boolean running;
	/**
	 * 
	 */
	private BufferedReader in;
	
	/**
	 * 
	 */
	public Application() {
		in = new BufferedReader(new InputStreamReader(System.in));
	}
	
	@Override
	public final void run() {
		running = true;
		while (running) {
			try {
				System.out.println("Select action");
				try {
					processAction(Integer.parseInt(in.readLine()));
				} catch (NumberFormatException e) {
					System.out.println("Invalid action");
				}
			} catch (IOException e) {
				throw new CommandLineException(e);
			}

		}
	}
	/**
	 * 
	 * @param action Parsed integer
	 */
	protected final void processAction(
			final int action) {
		switch(action) {
			case Action.ADD_TEST:
				addTest();
				break;
			case Action.DELETE_TEST:
				deleteTest();
				break;
			case Action.ADD_JOB:
				addJob();
				break;
			case Action.DELETE_JOB:
				deleteJob();
				break;
			default:
				System.out.println("Invalid action");
				break;			
		}		
	}

	/**
	 * 
	 */
	private void deleteJob() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 */
	private void addJob() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 */
	private void deleteTest() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 */
	private void addTest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final void simulationAdded(
			final SimulationEvent event) {
		System.out.println("Simulation added");
	}

	@Override
	public final void simulationRemoved(
			final SimulationEvent event) {
		System.out.println("Simulation removed");
		
	}

	@Override
	public final void simulationAltered(
			final SimulationEvent event) {
		System.out.println("Simulation altered");
		
	}

	@Override
	public final void simulationChanged(
			final SimulationEvent event) {
		System.out.println("Simulation changed");
		
	}

	@Override
	public void simulationSaveRequiredChangedEvent(
			final SimulationEvent event) {
		// TODO Work out whether a save has occurred.
		
	}

}
