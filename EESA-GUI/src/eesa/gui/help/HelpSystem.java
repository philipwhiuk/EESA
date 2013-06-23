package eesa.gui.help;

import java.awt.event.ActionEvent;
import java.net.URI;
import java.util.Properties;
import javax.swing.AbstractButton;

/**
 * Provides a base class for a help system module that provides support to users.
 * @author Philip
 */
public abstract class HelpSystem {
    /**
     * 
     * @param properties
     * @throws HelpException
     */
    public HelpSystem(final Properties properties) throws HelpException {
        
    }
    /**
     * 
     * @param ae
     * @throws HelpException
     */
    public abstract void showHelp(final ActionEvent ae) throws HelpException;

    /**
     * 
     * @param button The to click to show the help
     * @param topicClass The class to return help on
     * @throws HelpException Help Error
     */
    public abstract void addHelpForClassToButton(
    		AbstractButton button, Class<?> topicClass)
    		throws HelpException;

    /**
     * 
     * @return URI
     * @throws HelpException Help exception
     */
    public abstract URI getURI() throws HelpException;
}
