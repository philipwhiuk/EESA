package com.whiuk.philip.eesa.xml.dataImport;

import com.whiuk.philip.eesa.core.Job;
import com.whiuk.philip.eesa.dataImport.JobDataImport;
import com.whiuk.philip.eesa.exceptions.EESAException;
import com.whiuk.philip.eesa.exceptions.JobException;
import com.whiuk.philip.eesa.exceptions.TimeIntervalException;
import com.whiuk.philip.eesa.exceptions.XMLException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Attr;
import org.xml.sax.SAXException;

/**
 * Provides the structure for importing jobs from XML
 * @author Philip
 */
public class XMLJobDataImport extends JobDataImport {
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
    private String jobElementTagName;
    private ArrayList<Element> resultElements;
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
            for (int n = 0; n < eCNodes.getLength(); n++) {
                if (eCNodes.item(n).getNodeType() == Node.ELEMENT_NODE) {
                    String[] tags = getElementTagNames((Element) eCNodes.item(n));
                    for (int i = 0; i < tags.length; i++) {
                        if (!elements.contains(tags[i])) {
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
    public void runMapping() {
        ArrayList<Object[]> queryData = new ArrayList<Object[]>();
        Element parent = (Element) doc.getElementsByTagName(parentElementTagName).item(0);
        NodeList jobs = parent.getElementsByTagName(jobElementTagName);
        int numColumns = jobs.item(0).getAttributes().getLength();
        for (int i = 0; i < jobs.getLength() && i < 10; i++) {
            Element job = (Element) jobs.item(0);
            Object[] rowData = new Object[numColumns];
            NamedNodeMap attributes = job.getAttributes();
            for (int a = 0; a < numColumns; a++) {
                rowData[a] = ((Attr) attributes.item(a)).getValue();
            }
            queryData.add(rowData);
        }
        setMappingData(queryData.toArray(new Object[][]{}));
    }

    /**
     * 
     * @throws EESAException
     * @throws JobException
     */
    @Override
    public void generateImport() throws EESAException, JobException {
        runImportQuery();
        processImportData();
    }

    /**
     * 
     * @param tagName
     */
    public void setJobElementTagName(String tagName) {
        this.jobElementTagName = tagName;
    }

    private void runImportQuery() {
        NodeList jobs = doc.getElementsByTagName(jobElementTagName);
        String[] columns = getColumns();
        ArrayList<Object[]> data = new ArrayList<Object[]>();
        for (int i = 0; i < jobs.getLength(); i++) {
            Element job = (Element) jobs.item(i);
            String[] jObj = new String[columns.length];
            for (int c = 0; c < columns.length; c++) {
                jObj[c] = job.getAttribute(columns[c]);
            }
            data.add(jObj);
        }
        setResultData(data.toArray(new Object[][]{}));
    }

    private void processImportData() throws JobException, TimeIntervalException {
        Object[][] resultData = getResultData();
        ArrayList<Job> resultJobs = new ArrayList<Job>(resultData.length);
        boolean[] parameters = getParameters();
        int[] columnKeys = getColumnKeys();
        for (int r = 0; r < resultElements.size(); r++) {
            int jobID = -1;
            HashMap<Job.Property,Float> properties = new HashMap<Job.Property,Float>();
            
            if (parameters[Choice.JOBID]) {
                jobID = (Integer) resultData[r][columnKeys[Choice.JOBID]];
            }
            if (parameters[Choice.RELEASE]) {
            	properties.put(Job.Property.RELEASE, (Float) resultData[r][columnKeys[Choice.RELEASE]]);
            }
            if (parameters[Choice.DEADLINE]) {
            	properties.put(Job.Property.DEADLINE, (Float) resultData[r][columnKeys[Choice.DEADLINE]]);
            }            
            if (parameters[Choice.LENGTH]) {
            	properties.put(Job.Property.LENGTH, (Float) resultData[r][columnKeys[Choice.LENGTH]]);
            }
            if (parameters[Choice.WEIGHT]) {
            	properties.put(Job.Property.WEIGHT, (Float) resultData[r][columnKeys[Choice.WEIGHT]]);
            }
            if (parameters[Choice.DENSITY]) {
            	properties.put(Job.Property.DENSITY, (Float) resultData[r][columnKeys[Choice.DENSITY]]);
            }
            Job j = new Job(jobID,properties);
            resultJobs.add(j);
        }
        setResultsJobs(resultJobs);
    }
    
    
}
