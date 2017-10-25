package eesa.gui.help;

import java.awt.event.ActionEvent;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;

/**
 * Manages the loading and passing
 * of data to and from a help system.
 * @author Philip
 */
public final class HelpManager {
	/**
	 * Utility class.
	 */
	private HelpManager() {		
	}
	/**
	 * Class logger.
	 */
	private static Logger logger =
			Logger.getLogger(HelpManager.class.getName());
    /**
     * 
     */
    private static HelpSystem helpSystem;
    /**
     * 
     */
    private static URI defaultHelpURI;
    /**
     * 
     * @param properties
     * @throws HelpException 
     */
    public static void setupHelpSystem(final Properties properties) throws HelpException {
        try {
            defaultHelpURI = new URI(properties.getProperty("help_DefaultURI"));
        } catch (URISyntaxException ex) {
            Logger.getLogger(HelpManager.class.getName()).log(Level.SEVERE, "HELP: Attempting to define the default online help URI failed with a syntax error.", ex);
        }
        
        String helpSystemClassName = properties.getProperty("help_ClassName");
        if (helpSystemClassName == null) {
            Logger.getLogger(HelpManager.class.getName()).log(Level.WARNING, "System Class Name not defined");
            throw new HelpException("System Class Name not defined");  
        }
        try {
            Class<?> helpSystemClass = Class.forName(helpSystemClassName);
            Constructor<?> helpSystemClassConstructor = helpSystemClass.getDeclaredConstructor(Properties.class);
            helpSystem = (HelpSystem) helpSystemClassConstructor.newInstance(properties);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(HelpManager.class.getName()).log(Level.WARNING, null, ex);
            throw new HelpException(ex);
        } catch (SecurityException ex) {
            Logger.getLogger(HelpManager.class.getName()).log(Level.WARNING, null, ex);
            throw new HelpException(ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(HelpManager.class.getName()).log(Level.WARNING, null, ex);
            throw new HelpException(ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(HelpManager.class.getName()).log(Level.WARNING, null, ex);
            throw new HelpException(ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(HelpManager.class.getName()).log(Level.WARNING, null, ex);
            throw new HelpException(ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(HelpManager.class.getName()).log(Level.WARNING, null, ex);
            throw new HelpException(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HelpManager.class.getName()).log(Level.WARNING, null, ex);
            throw new HelpException(ex);
        }
    }
    /**
     * 
     * @param ae 
     */
    public static void showHelp(final ActionEvent ae) {
        if (helpSystem == null) {
            Logger.getLogger(HelpManager.class.getName()).log(Level.WARNING, "Help System unavailable");
            return;
        }
        try {
            helpSystem.showHelp(ae);
        } catch (HelpException ex) {
            Logger.getLogger(HelpManager.class.getName()).log(Level.WARNING, null, ex);
        }        
    }
    /**
     * 
     * @return The URI for the HelpSystem
     */
    public static URI getURI() {
        if (helpSystem != null) {
            try {
                return helpSystem.getURI();
            } catch (HelpException ex) {
                Logger.getLogger(HelpManager.class.getName()).log(Level.WARNING, null, ex);
            }             
        } else {
            Logger.getLogger(HelpManager.class.getName()).log(Level.WARNING, "Help System unavailable.");
        }
        Logger.getLogger(HelpManager.class.getName()).log(Level.WARNING, "Returning default URI");
        return defaultHelpURI;
    }
    /**
     * 
     * @return The default Help URI
     */
    public static URI getDefautURI() {
        return defaultHelpURI;
    }
    /**
     * 
     * @param button
     * @param topicClass
     */
    public static void addHelpForClassToButton(
    		final AbstractButton button,
    		final Class<?> topicClass) {
        if (helpSystem == null) {
            logger.log(Level.WARNING, "Help System unavailable");
            return;
        }
        try {
            helpSystem.addHelpForClassToButton(button, topicClass);
        } catch (HelpException ex) {
            logger.log(Level.WARNING, null, ex);
        }        
    }
}
