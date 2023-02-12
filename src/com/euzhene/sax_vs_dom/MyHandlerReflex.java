package com.euzhene.sax_vs_dom;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.regex.*;


public class MyHandlerReflex extends DefaultHandler{
	private ReflectionHelper reflectionHelper = ReflectionHelper.Instance();
	
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
	 public void characters (char ch[], int start, int length){
		 String value = new String(ch,start,length);
		 
		 if (value.trim().isEmpty()) return;	

		 	try {
				 if (Pattern.compile("^-?\\d+$").matcher(value).matches()) {
					 reflectionHelper.setFieldValue(getLastUser(), currentElement, Integer.parseInt(value));
					 
				 }else {
					 reflectionHelper.setFieldValue(getLastUser(), currentElement, value);
				 }
		 		
				
			}
		 	catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
	 }


		public ArrayList<GithubUser> getUsers() {
			return users;
		}
}
