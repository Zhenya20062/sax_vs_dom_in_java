package com.euzhene.sax_vs_dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


public class MyDomParser {
	private static MyDomParser _instance;
	public static MyDomParser Instance() throws ParserConfigurationException {
		if (_instance == null) {
			_instance = new MyDomParser();
		}
		return _instance;
	}
	
	 
	private DocumentBuilder db;
	
	private ArrayList<GithubUser> users = new ArrayList<GithubUser>();
	
	private MyDomParser() throws ParserConfigurationException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
		db = dbf.newDocumentBuilder();
	}
	
	public void parse(File xmlFile) throws ParserConfigurationException, SAXException, IOException {
		users.clear();
		
        Document doc = db.parse(xmlFile);
        doc.getDocumentElement().normalize();
        
        NodeList list = doc.getElementsByTagName("GithubUser");

        for (int temp = 0; temp < list.getLength(); temp++) {

            Node node = list.item(temp);

            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element element = (Element) node;
               
                String id = element.getAttribute("id");
                

                // get text
                String name = element.getElementsByTagName("name").item(0).getTextContent();
                String projectCount = element.getElementsByTagName("projectCount").item(0).getTextContent();
                String registered = element.getElementsByTagName("registered").item(0).getTextContent();
                String commitCount = element.getElementsByTagName("commitCount").item(0).getTextContent();
                String acceptedPullRequestCount = element.getElementsByTagName("acceptedPullRequestCount").item(0).getTextContent();
                
                GithubUser user = new GithubUser();
                user.setId(id);
                user.setName(name);
                user.setProjectCount(Integer.parseInt(projectCount));
                user.setRegistered(registered);
                user.setCommitCount(Integer.parseInt(commitCount));
                user.setAcceptedPullRequestCount(Integer.parseInt(acceptedPullRequestCount));
                
                users.add(user);
            }
        }
        
	}
	public ArrayList<GithubUser> getUsers() {
		return users;
	}
}
