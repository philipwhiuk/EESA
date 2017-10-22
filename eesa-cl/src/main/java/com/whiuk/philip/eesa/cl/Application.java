package com.whiuk.philip.eesa.cl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.whiuk.philip.eesa.core.IApplication;
import com.whiuk.philip.eesa.core.Job;
import com.whiuk.philip.eesa.core.JobSet;
import com.whiuk.philip.eesa.core.Simulation;
import com.whiuk.philip.eesa.core.Simulator;
import com.whiuk.philip.eesa.core.Test;
import com.whiuk.philip.eesa.event.SimulationEvent;
import com.whiuk.philip.eesa.exceptions.AlgorithmException;
import com.whiuk.philip.eesa.exceptions.EESAException;

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
		/**
		 * Run tests
		 */
		public static final int RUN_TESTS = 4;
		/**
		 * List job
		 */
		public static final int LIST_JOBS = 5;
		/**
		 * List tests
		 */
		public static final int LIST_TESTS = 6;

	}

	/**
	 * Options for command line arguments.
	 */
	private static Options options;
	
	public static void main(String[] args) {
		run(null, args);
	}
	
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
	private Simulator simulator = Simulator.getSimulator();
	private Simulation simulation = new Simulation(simulator);
	private ArrayList<Job> jobs = new ArrayList<Job>();
	private ArrayList<Test> tests = new ArrayList<Test>();
	
	/**
	 * 
	 */
	public Application() {
		in = new BufferedReader(new InputStreamReader(System.in));
		simulator.setCurrentSimulation(simulation);
		simulator.addSimulationEventListener(this);
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
			} catch (EESAException e) {
				throw new CommandLineException(e);
			}

		}
	}
	/**
	 * 
	 * @param action Parsed integer
	 * @throws IOException 
	 * @throws NumberFormatException 
	 * @throws EESAException 
	 */
	protected final void processAction(
			final int action) throws NumberFormatException, IOException, EESAException {
		switch(action) {
			case Action.RUN_TESTS:
				runTests();
				break;
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
			case Action.LIST_JOBS:
				listJobs();
				break;
			case Action.LIST_TESTS:
				listTests();
				break;
			default:
				System.out.println("Invalid action");
				break;			
		}		
	}

	/**
	 * @throws IOException 
	 * @throws NumberFormatException 
	 * 
	 */
	private void deleteJob() throws NumberFormatException, IOException {
		System.out.println("Index of job to delete:");
		int index = Integer.parseInt(in.readLine());
		if (index < 0 || index >= jobs.size()) {
			System.out.println("Job doesn't exist");
			return;
		}
		simulation.removeTest(Integer.parseInt(in.readLine()));
	
	}

	/**
	 * 
	 */
	private void addJob() {
		jobs.add(new Job());
		System.out.println("Job added");
	}

	/**
	 * 
	 */
	private void listJobs() {
		System.out.println("Jobs:");
		for (Job job : jobs) {
			System.out.println(job);
		}
	}

	/**
	 * @throws IOException 
	 * @throws NumberFormatException 
	 * 
	 */
	private void deleteTest() throws NumberFormatException, IOException {
		System.out.println("Index of test to delete:");
		int index = Integer.parseInt(in.readLine());
		if (index < 0 || index >= tests.size()) {
			System.out.println("Test doesn't exist");
			return;
		}
		tests.remove(Integer.parseInt(in.readLine()));
	}

	/**
	 * 
	 */
	private void addTest() {
		simulation.addTest(null);
	}

	/**
	 * 
	 */
	private void listTests() {
		System.out.println("Tests:");
		for (Test test : tests) {
			System.out.println(test);
		}
	}
	
	private void runTests() throws AlgorithmException {
		simulation.setJobSet(new JobSet(jobs));
		simulation.runAlgorithms();
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
