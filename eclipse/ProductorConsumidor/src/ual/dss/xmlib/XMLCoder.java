package ual.dss.xmlib;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXParseException;

import ual.dss.core.Mensaje;

// TODO: Auto-generated Javadoc
/**
 * The Class XMLCoder.
 */
public class XMLCoder {

	/**
	 * Codifica la lista de mensajes en el archivo que entra por parametro en formato XML.
	 *
	 * @param fileName the file name
	 * @param entrada the entrada
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public static boolean codeXML(String fileName, List<Mensaje> entrada) throws Exception {
		
		if (entrada.isEmpty()) {
			System.out.println("ERROR empty List");
			return false;
		} else {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();
			Document document = implementation.createDocument(null, fileName, null);
			document.setXmlVersion("1.0");
			// Main Node
			Element raiz = document.getDocumentElement();
			
			// Por cada correo creamos un registro con el valor
			for(int i=0; i<entrada.size();i++){
			
				Element mensajeNode = document.createElement("mensaje");
				Element fechaNode = document.createElement("fecha");
				Element nivelInteresNode = document.createElement("nivelInteres");
				Element descripcionCortaNode = document.createElement("descripcionCorta");
				Element descripcionLargaNode = document.createElement("descripcionLarga");

				Text nodeFechaValue = document.createTextNode(entrada.get(i).getfecha());
				Text nodeNivelInteresValue = document.createTextNode(entrada.get(i).getnivelInteres());
				Text nodeDescripcionCortaValue = document.createTextNode(entrada.get(i).getDescripcionCorta());
				Text nodeDescripcionLargaValue = document.createTextNode(entrada.get(i).getDescripcionLarga());

				fechaNode.appendChild(nodeFechaValue);
				nivelInteresNode.appendChild(nodeNivelInteresValue);
				descripcionCortaNode.appendChild(nodeDescripcionCortaValue);
				descripcionLargaNode.appendChild(nodeDescripcionLargaValue);
				
				raiz.appendChild(mensajeNode);
				mensajeNode.appendChild(fechaNode);
				mensajeNode.appendChild(nivelInteresNode);
				mensajeNode.appendChild(descripcionCortaNode);
				mensajeNode.appendChild(descripcionLargaNode);

				
			}
			// Generate XML
			Source source = new DOMSource(document);
			// Indicamos donde lo queremos almacenar
			Result result = new StreamResult(new java.io.File(fileName + ".xml"));
																				
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(source, result);
			return true;
		}
	}
	
	/**
	 * Codifica la lista de mensajes en XML en forma de texto
	 *
	 * @param entrada the entrada
	 * @return the string
	 * @throws Exception the exception
	 */
	public static String codeXML(List<Mensaje> entrada) throws Exception {
		
		if (entrada.isEmpty()) {
			return "ERROR empty List";
		} else {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();
			Document document = implementation.createDocument(null, "documentoProductorConsumidor", null);
			document.setXmlVersion("1.0");
			// Main Node
			Element raiz = document.getDocumentElement();
			
			// Por cada correo creamos un registro con el valor
			for(int i=0; i<entrada.size();i++){
				
				Element mensajeNode = document.createElement("mensaje");
				Element fechaNode = document.createElement("fecha");
				Element nivelInteresNode = document.createElement("nivelInteres");
				Element descripcionCortaNode = document.createElement("descripcionCorta");
				Element descripcionLargaNode = document.createElement("descripcionLarga");

	
				Text nodeFechaValue = document.createTextNode(entrada.get(i).getfecha());
				Text nodeNivelInteresValue = document.createTextNode(entrada.get(i).getnivelInteres());
				Text nodeDescripcionCortaValue = document.createTextNode(entrada.get(i).getDescripcionCorta());
				Text nodeDescripcionLargaValue = document.createTextNode(entrada.get(i).getDescripcionLarga());

	
				fechaNode.appendChild(nodeFechaValue);
				nivelInteresNode.appendChild(nodeNivelInteresValue);
				descripcionCortaNode.appendChild(nodeDescripcionCortaValue);
				descripcionLargaNode.appendChild(nodeDescripcionLargaValue);

				
				raiz.appendChild(mensajeNode);
				mensajeNode.appendChild(fechaNode);
				mensajeNode.appendChild(nivelInteresNode);
				mensajeNode.appendChild(descripcionCortaNode);
				mensajeNode.appendChild(descripcionLargaNode);

				
			}
			// Generate XML
			Source source = new DOMSource(document);
			// Indicamos donde lo queremos almacenar

			StringWriter writer = new StringWriter();
		    StreamResult result = new StreamResult(writer);
		    TransformerFactory tFactory = TransformerFactory.newInstance();
		    Transformer transformer = tFactory.newTransformer();
		    transformer.transform(source,result);
		    String strResult = writer.toString();
			System.out.println(strResult);
			return strResult;
		}
	}
}
