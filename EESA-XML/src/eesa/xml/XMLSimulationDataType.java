package eesa.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import eesa.core.Main;
import eesa.core.Simulation;
import eesa.exceptions.SimulationLoadingException;
import eesa.exceptions.SimulationSavingException;

/**
 * Manages loading and saving Simulations from XML files.
 * @author Philip Whitehouse
 *
 */
public final class XMLSimulationDataType {
	/**
	 * Utility class.
	 */
	private XMLSimulationDataType() {
		
	}
	
    /**
     * 
     * @param source file
     * @return simulation
     * @throws SimulationLoadingException 
     */
	public static Simulation load(final XMLSimulationDataSource source) 
			throws SimulationLoadingException {
		throw new SimulationLoadingException("Not implemented");
	}
	/**
	 * 
	 * @param sim simulation
	 * @param s source
	 * @throws SimulationSavingException Thrown if an XML factory error occurs
	 */
	public static void save(final Simulation sim, 
			final XMLSimulationDataSource s)
			throws SimulationSavingException {
		try {
			Document doc = DocumentBuilderFactory
					.newInstance().newDocumentBuilder().newDocument();
	        Element simulation = doc.createElement("simulation");
	        //TODO: (Re)Implement Saving
	        doc.appendChild(simulation);
	        Transformer transformer;
			transformer = TransformerFactory.newInstance().newTransformer();
	        transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM,
	        		Main.getProperties().getProperty("dtd"));
	        DOMSource source = new DOMSource(doc);
	        StreamResult result = new StreamResult(s.getFile());
	        transformer.transform(source, result);
			sim.setDataSource(s);
			sim.setSaved();
		} catch (TransformerFactoryConfigurationError 
				| ParserConfigurationException 
				| TransformerException e) {
			throw new SimulationSavingException(e);
		}

	}
}
