package com.rakesh.selenium.selenium_with_java;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class _33_implementing_xmlFile {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		File file = new File("C:\\Users\\shubh\\Documents\\GitHub\\Selenium-with-Java\\selenium-with-java\\src\\main\\java\\com\\rakesh\\selenium\\selenium_with_java\\file.xml");
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbf.newDocumentBuilder();
		
		Document doc = dBuilder.parse(file);

		Element root = doc.getDocumentElement();	//extracts root node from the xml file
		NodeList nodeList = root.getChildNodes();	//extracts child nodes from the xml file
		
		System.out.println(doc.getDocumentElement().getNodeName());	//prints the root 
		
		NodeList nodelist = doc.getElementsByTagName("roll");
		int nodelength = nodelist.getLength();
		System.out.println("Total roll elements: " + nodelength);
		
		for (int i = 0; i < nodelength; i++) {
			Node node = nodelist.item(i);

			// Ensures the node is an actual <roll> element (not whitespace or text)
		    if (node.getNodeType() == Node.ELEMENT_NODE) { 
		        Element element = (Element) node;

		        // Get attribute
		        String rollNum = element.getAttribute("num");
		        System.out.println("Roll number: " + rollNum);

		        // Get child elements
		        System.out.println("Student name: " + 				element.getElementsByTagName("stu1").item(0).getTextContent());
		        System.out.println("Surname: " + 				element.getElementsByTagName("stu1_sur").item(0).getTextContent());
		        System.out.println("Phone: " + 				element.getElementsByTagName("stu1_phone_num").item(0).getTextContent());
		    }
		}
		
	}

}
