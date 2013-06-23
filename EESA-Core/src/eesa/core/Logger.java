package eesa.core;

import eesa.exceptions.LoggingException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.FileHandler;
/**
 * Logger provides EESA with an implementation of logging,
 * organising the file-based storage of messages.
 * @author Philip
 */
final class Logger {
	/**
	 * Private default constructor - utility class.
	 */
	private Logger() {
		
	}
	
    /**
     * Setup uses properties to correctly create the required logging.
     * @param p properties
     */
    static void setup(final Properties p) {
        if (p.getProperty("logging").equals("true")) {
        	//java.util.logging.Logger.getLogger("")
        	//.setUseParentHandlers(false);
            try {
                java.util.logging.Logger.getLogger("").
                addHandler(new FileHandler(p.
                		getProperty("logfile"), false));
            } catch (IOException ex) {
                throw new LoggingException("IO Exception");
            } catch (SecurityException ex) {
                throw new LoggingException("Security Exception");
            }
        }
    }   
}
