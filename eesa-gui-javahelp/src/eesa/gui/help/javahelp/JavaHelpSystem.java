package eesa.gui.help.javahelp;

import eesa.gui.help.HelpException;
import eesa.gui.help.HelpManager;
import eesa.gui.help.HelpSystem;
import java.awt.event.ActionEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.help.CSH;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.swing.AbstractButton;

/**
 * Provides a HelpSystem connector for JavaHelp.
 * @author Philip
 */
public class JavaHelpSystem extends HelpSystem {
	/**
	 * 
	 */
    private final HelpSet hs;
    /**
     * 
     */
    private final HelpBroker hb;
    /**
     * 
     * @param properties
     * @throws HelpException 
     */
    public JavaHelpSystem(final Properties properties) throws HelpException {
        super(properties);
        try {
            File f = new File(properties.getProperty("help_Filename"));
            URL hsURL = f.toURI().toURL();
            hs = new HelpSet(null, hsURL);
        } catch (MalformedURLException ex) {
            Logger.getLogger(JavaHelpSystem.class.getName()).log(Level.SEVERE, null, ex);
            throw new HelpException(ex);
        } catch (HelpSetException ex) {
            Logger.getLogger(JavaHelpSystem.class.getName()).log(Level.WARNING, "Help System Exception", ex);
            throw new HelpException(ex);
        }
        hb = hs.createHelpBroker();
    }
    @Override
	public final void showHelp(final ActionEvent ae) {
        new CSH.DisplayHelpFromSource(hb).actionPerformed(ae);
    }
    @Override
	public final URI getURI() throws HelpException {
        return HelpManager.getDefautURI();
    }    
    
    @Override
	public final void addHelpForClassToButton(final AbstractButton button, final Class<?> topicClass) throws HelpException {
        hb.enableHelpOnButton(button, topicClass.getName(), hs);
    }
}
