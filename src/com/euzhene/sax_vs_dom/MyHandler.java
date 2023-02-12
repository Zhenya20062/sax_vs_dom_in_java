package com.euzhene.sax_vs_dom;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;


public class MyHandler extends DefaultHandler{
	private ArrayList<GithubUser> users = new ArrayList<GithubUser>();
	
	private String currentElement;
	
	private GithubUser getLastUser() {
		return users.get(users.size()-1);
	}
	@Override
	public void startDocument() {
		users.clear();
	}
	
	@Override
    public void startElement (String uri, String localName,
                              String qName, Attributes attributes) {
		currentElement = qName;
		if (currentElement == "GithubUser") {
			users.add(new GithubUser());
			String idAttribute = attributes.getValue(attributes.getIndex("id"));
			getLastUser().setId(idAttribute);
		}
	}
	
	 @Override
	 public void characters (char ch[], int start, int length) {
		 String value = new String(ch,start,length);
		 if (value.trim().isEmpty()) return;
		 	

		 	if (currentElement == "name") {
		 		getLastUser().setName(value);
		 	}
		 	else if (currentElement == "projectCount") {
		 		getLastUser().setProjectCount(Integer.parseInt( value));
		 	} 
		 	else if (currentElement == "registered") {
		 		getLastUser().setRegistered(value);
		 	} 
		 	else if (currentElement == "commitCount") {
		 		getLastUser().setCommitCount(Integer.parseInt(value));
		 	}
		 	else if (currentElement == "acceptedPullRequestCount") {
		 		getLastUser().setAcceptedPullRequestCount(Integer.parseInt(value));
		 	}
	 }


	public ArrayList<GithubUser> getUsers() {
		return users;
	}
}
