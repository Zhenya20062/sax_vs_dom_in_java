package com.euzhene.sax_vs_dom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.*;

import org.xml.sax.SAXException;
import java.time.*;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws SAXException,ParserConfigurationException,IOException {
		File xmlFile = new File("src/com/euzhene/sax_vs_dom/example_small_data.xml");
		
		MyDomParser domParser = MyDomParser.Instance();
		MySaxParser saxParser = MySaxParser.Instance();
		
		Instant start;
		Instant end;
		Duration timeElapsed;

		start = Instant.now();
		saxParser.parse(xmlFile);
		end = Instant.now();
		timeElapsed = Duration.between(start, end);
		System.out.printf("SAX simple: %s \n", timeElapsed.toMillis());
		
		
		start = Instant.now();
		saxParser.parseReflex(xmlFile);
		end = Instant.now();
		timeElapsed = Duration.between(start, end);
		System.out.printf("SAX reflection: %s \n", timeElapsed.toMillis());
		
		
		start = Instant.now();
		domParser.parse(xmlFile);
		end = Instant.now();
		timeElapsed = Duration.between(start, end);
		System.out.printf("DOM: %s \n", timeElapsed.toMillis());
		
		
		ArrayList<GithubUser> users = domParser.getUsers();
		
	//	output
//		for (GithubUser user : users) {
//	
//			System.out.println(user.getId());
//			System.out.println(user.getName());
//			System.out.println(user.getProjectCount());
//			System.out.println(user.getCommitCount());
//			System.out.println(user.getAcceptedPullRequestCount());
//			System.out.println(user.getRegistered());
//			
//		}
		System.out.print("Exit");
		return;
	}

}
