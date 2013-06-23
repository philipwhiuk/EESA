package eesa.core;

import eesa.exceptions.LoggingException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Main is the system entry point.
 * It loads core modules and calls the desired user interface.
 * @author Philip
 */
public final class Main {
	/**
	 * Private default constructor - utility class.
	 */
	private Main() {
		
	}
    /**
     * The filename for the properties of the system.
     */
    private static final String PROPERTY_FILE_PATH =
    		"properties/properties.xml";
    /**
     * The collection of properties available to the system.
     */
    private static Properties properties;
    /**
     * 
     */
    private static Logger logger =
    		Logger.getLogger(Main.class.getName());
    /**
     * The Java-defined entry point to the system. No arguments are recognised.
     * @param args 
     */
    public static void main(final String[] args) {
        setupProperties();
        setupLogger();
        setupDatabase();
        launch(args);
    }
    /**
     * Loads the properties file.
     */
    private static void setupProperties() {
        properties = new Properties();
        try {
            properties.loadFromXML(
            		new FileInputStream(new File(PROPERTY_FILE_PATH)));
        } catch (InvalidPropertiesFormatException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Creates the logging environment.
     */
    private static void setupLogger() {
        try {
            eesa.core.Logger.setup(properties);
        } catch (LoggingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Calls the database loader via reflection.
     */
    private static void setupDatabase() {
        if (properties.getProperty("dbManagerClass") != null) {
            try {
                Class<?> dbManager = 
                		Class.forName(properties.getProperty("dbManagerClass"));
                dbManager.
                	getDeclaredMethod("loadDatabaseClasses", Properties.class).
                	invoke(null, properties);
            } catch (ClassNotFoundException ex) {
            	logger.log(Level.SEVERE,
            			"Unable to load provided dbManagerClass", ex);
            } catch (NoSuchMethodException ex) {
            	logger.log(Level.SEVERE,
            			"loadDatabaseClasses(Properties properties) not found",
            			ex);
            } catch (IllegalAccessException ex) {
            	logger.log(Level.SEVERE,
            			"Not allowed to access method",
            			ex);
            } catch (InvocationTargetException ex) {
            	logger.log(Level.SEVERE,
            			"Bad target for method",
            			ex);
            } catch (SecurityException ex) {
            	logger.log(Level.SEVERE,
            			"Security exception invoking method",
            			ex);
            }            
        }
    }    
    /**
     * Starts the user interface via the
     * defined mainClass's static run() method.
     */
    private static void launch(final String[] args) {
        try {
            Class<?> app = Class.forName(properties.getProperty("mainClass"));
            app.getDeclaredMethod("run", Properties.class, String[].class).
            	invoke(null, properties, args);
        } catch (ClassNotFoundException ex) {
        	logger.log(
            		Level.SEVERE,
            		"Unable to load mainClass",
            		ex);
        } catch (NoSuchMethodException ex) {
        	logger.log(Level.SEVERE,
        			"Unable to invoke mainClass.run()",
        			ex);
        } catch (IllegalAccessException ex) {
        	logger.log(Level.SEVERE,
        			"Not allowed to invoke mainClass.run()",
        			ex);
        } catch (InvocationTargetException ex) {
        	logger.log(Level.SEVERE,
        			"Bad method mainClass.run()",
        			ex);
	} catch (SecurityException ex) {
			logger.log(Level.SEVERE, "Not allowed to invoke mainClass.run()",
					ex);
	}
    }
    /**
     * Retrieves the static properties object.
     * @return properties
     */
    public static Properties getProperties() {
        return properties;
    }
}
