package com.euzhene.sax_vs_dom;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;

public class MySaxParser  {
	private MyHandler handler;
	private MyHandlerReflex handlerReflex;
	private SAXParserFactory saxParserFactory;
	private SAXParser saxParser;

	private ArrayList<GithubUser> users;
	
	private static MySaxParser _instance;
	
	public static MySaxParser Instance() throws ParserConfigurationException, SAXException {
		if (_instance == null) {
			_instance = new MySaxParser();
		}
		return _instance;
	}

	
	private MySaxParser() throws ParserConfigurationException, SAXException {
		handler = new MyHandler();
		handlerReflex = new MyHandlerReflex();
		saxParserFactory = SAXParserFactory.newInstance();
		saxParser = saxParserFactory.newSAXParser();
	}
	
	public void parse(File xmlFile) throws SAXException, IOException {
		saxParser.parse(xmlFile, handler);
		users = handler.getUsers();
	}
	public void parseReflex(File xmlFile) throws SAXException, IOException {
		saxParser.parse(xmlFile, handlerReflex);
		users = handlerReflex.getUsers();
	}
	
	public ArrayList<GithubUser> getUsers() {
		return users;
	}
	
}
