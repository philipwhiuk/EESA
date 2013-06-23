package eesa.xml.dataExport;

import eesa.dataExport.PeriodDataExport;
import eesa.exceptions.EESAException;
import eesa.exceptions.XMLException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Provides the structure for exporting time periods to XML
 * @author Philip
 */
public class XMLPeriodDataExport extends PeriodDataExport {
    /**
     * 
     */
    private File source;
    /**
     * 
     */
    private Document doc;
    /**
     * 
     */
    private DocumentBuilderFactory factory; 
    /**
     * 
     */
    private DocumentBuilder builder;
    private String periodElementTagName;
    private String parentElementTagName;
    
    /**
     * 
     * @param filename
     */
    public void setSource(String filename) {
        setSource(new File(filename));
    }

    /**
     * 
     * @param file
     */
    private void setSource(File file) {
        source = file;
    }

    /**
     * 
     * @return
     */
    public File getSource() {
        return source;
    }

    /**
     * 
     * @return
     * @throws XMLException
     */
    public String[] getDocumentTagNames() throws XMLException {
        Element e = getDocument().getDocumentElement();
        List<String> elements = Arrays.asList(getElementTagNames(e));
        Collections.sort(elements);
        return elements.toArray(new String[]{});
    }
    /**
     * 
     * @param e
     * @return
     */
    public String[] getElementTagNames(Element e) {
        ArrayList<String> elements = new ArrayList<String>(1);
        if(!elements.contains(e.getTagName())) {
            elements.add(e.getTagName());
        }
        if(e.getChildNodes().getLength() > 0) {
            NodeList eCNodes = e.getChildNodes();
            for(int n = 0; n < eCNodes.getLength(); n++) {
                if(eCNodes.item(n).getNodeType() == Node.ELEMENT_NODE) {
                    String[] tags = getElementTagNames((Element) eCNodes.item(n));
                    for(int i = 0; i < tags.length; i++) {
                        if(!elements.contains(tags[i])) {
                            elements.add(tags[i]);
                        }
                    }
                }
            }
        }
        return elements.toArray(new String[]{});
    }
    /**
     * 
     * @return
     * @throws XMLException
     */
    private Document getDocument() throws XMLException {
        if(factory == null) {
            factory = DocumentBuilderFactory.newInstance();
        }
        if(builder == null) {
            try {
                builder = factory.newDocumentBuilder();
            } catch (ParserConfigurationException ex) {
                throw new XMLException(ex);
            }
        }
        try {
            doc = builder.parse(source);
        } catch (SAXException ex) {
            throw new XMLException(ex);
        } catch (IOException ex) {
            throw new XMLException(ex);
        }
        return doc;
    }

    @Override
	public final void generateExport() throws EESAException {
        Object[][] resultData = getExportData();
        Element parent = (Element) doc.getElementsByTagName(parentElementTagName).item(0);
        List<String> choices = getChoices();
        String[] columns = getColumns();
        int[] keys = getColumnKeys();
        boolean[] columnSet = this.getParameters();
        for(int r = 0; r < resultData.length; r++) {
            Element period = doc.createElement(periodElementTagName);
            for(int c = 0; c < columns.length; c++) {
                if(columnSet[c]) {
                    period.setAttribute(choices.get(keys[c]), resultData[r][0].toString());
                }
            }
            parent.appendChild(period);
        }
    }
    
    @Override
    public void performExport() throws XMLException {
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "http://philip.whiuk.com/eesa/dtd/eesa.dtd");
            DOMSource domsource = new DOMSource(doc);
            StreamResult result = new StreamResult(source);
            transformer.transform(domsource, result);
        } catch (TransformerConfigurationException ex) {
            throw new XMLException(ex);
        } catch (TransformerException ex) {
            throw new XMLException(ex);
        }
    }
    /**
     * 
     * @param tagName
     */
    public void setPeriodElementTagName(String tagName) {
        this.periodElementTagName = tagName;
    }
    
}
