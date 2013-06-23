package eesa.db;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import eesa.exceptions.EESARuntimeException;

/**
 * Loads, stores and manages all the database connectors.
 * @author Philip
 */
public final class DatabaseManager {
    /**
     * 
     */
    private static ArrayList<DatabaseConnector> databaseConnectors = new ArrayList<DatabaseConnector>();    
    /**
     * 
     */
    private static DatabaseConnector defaultDatabaseConnector;
    /**
     * Throws uncatchable exception if the class provided does not extend @link{Database}.
     * @param prop properties
     * @throws ParserConfigurationException parser error
     * @throws SAXException SAX error
     */
    public static void loadDatabaseClasses(final Properties prop)
    		throws ParserConfigurationException, SAXException {
        File databasesFile = new File(prop.getProperty("dbFile"));
        Document doc;
		try {
			doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(databasesFile);
		} catch (IOException e) {
			throw new EESARuntimeException(e);
		}
        doc.getDocumentElement().normalize();
        NodeList dbList = doc.getElementsByTagName("database");
        for (int d = 0; d < dbList.getLength(); d++) {
            if (dbList.item(d).getNodeType() == Node.ELEMENT_NODE) {
                    Element dbE = (Element) dbList.item(d);
                try {
                    @SuppressWarnings("unchecked")
                    Class<DatabaseConnector> dbClass = 
                    (Class<DatabaseConnector>) Class.forName(
                    		dbE.getAttribute("className"));
                    DatabaseConnector connector = 
                    		dbClass.getConstructor(String.class, Element.class)
                    		.newInstance(
                    				dbE.getAttribute("jdbcClass"), dbE);
                    databaseConnectors.add(connector);
                    if (dbE.getAttribute("default").
                    		equals("true")) {
                        defaultDatabaseConnector = connector;
                    }
                } catch (InstantiationException ex) {
                    Logger.getLogger(DatabaseManager.class.getName()).log(
                    		Level.WARNING, 
                    		"Error occured when creating database connector " 
                    		+ "from class",
                		ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(DatabaseManager.class.getName()).log(
                		Level.WARNING, 
                		"Access problem occured when creating database class",
                		ex);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(DatabaseManager.class.getName()).log(
                    		Level.WARNING,
                    		"Bad argument found when creating database class",
                    		ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(DatabaseManager.class.getName()).log(
                    		Level.WARNING,
                    		"Exception occured when creating database class",
                    		ex);
                } catch (NoSuchMethodException ex) {
                    Logger.getLogger(DatabaseManager.class.getName()).log(
                    		Level.WARNING,
                    		"Constructor not found for database class",
                    		ex);
                } catch (SecurityException ex) {
                    Logger.getLogger(DatabaseManager.class.getName()).log(
                    		Level.WARNING,
                    		"Not allowed to create database object from class",
                    		ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DatabaseManager.class.getName()).log(
                    		Level.WARNING, "Unable to find database class", ex);
                }                
            }
        }
    }    

    /**
     * 
     * @param className class name
     * @param host host
     * @param port port
     * @param username user name
     * @param password password
     * @param dbName name
     * @return
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    public static Database getDatabaseConnector(
    		final String className, final String host, 
    		final int port, final String username,
    		final String password, final String dbName)
    		throws ClassNotFoundException, InstantiationException, IllegalAccessException, 
    		NoSuchMethodException, InvocationTargetException {
        Class<?> dbClassName = Class.forName(className);
        Database database = ((Database) dbClassName.
                getDeclaredConstructor(
                    String.class, 
                    String.class, 
                    int.class, 
                    String.class,                     
                    String.class, 
                    String.class).
                newInstance(
                host, username, port, password, dbName));
        return database;
    }    
    /**
     * 
     * @return list of connectors
     */
    public static DatabaseConnector[] getDatabaseConnectors() {
        return databaseConnectors.toArray(new DatabaseConnector[]{});
    }
    /**
     * 
     * @return default connector
     */
    public static DatabaseConnector getDefaultDatabaseConnector() {
        return defaultDatabaseConnector;
    }
    /**
     * 
     */
    private DatabaseManager() {
    }
}
