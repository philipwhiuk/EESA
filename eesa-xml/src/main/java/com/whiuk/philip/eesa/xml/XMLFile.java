package com.whiuk.philip.eesa.xml;

import com.whiuk.philip.eesa.exceptions.XMLException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * Provides functions for manipulating XML files
 * @author Philip
 */
public class XMLFile {
    
    /**
     * 
     * @param file 
     * @return 
     * @throws XMLException 
     */
    public static Document getDocument(File file) throws XMLException {
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
            doc.getDocumentElement().normalize();
            return doc;
        } catch (FileNotFoundException ex) {            
            Logger.getLogger(XMLFile.class.getName()).log(Level.INFO, "File Not Found (Assuming DTD): {0}", ex.getMessage());
            throw new XMLException("Unable to open DTD file associated with save file: " + ex.getMessage());
        } catch (SAXException ex) {
            Logger.getLogger(XMLFile.class.getName()).log(Level.INFO, "XML Invalid (SAX): {0}", ex.getMessage());
            throw new XMLException("Invalid XML File");
        } catch (IOException ex) {
            Logger.getLogger(XMLFile.class.getName()).log(Level.INFO, "IO Error: {0}", ex.getMessage());
            throw new XMLException("Unable to open file (I/O Error)");
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XMLFile.class.getName()).log(Level.INFO, "Parser Config Error{0}", ex.getMessage());
            throw new XMLException("Unable to parse file");
        }
    }
    
}
