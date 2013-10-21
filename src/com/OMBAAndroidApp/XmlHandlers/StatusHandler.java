package com.OMBAAndroidApp.XmlHandlers;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.util.Log;

import com.OMBAAndroidApp.ItemFiles.Status;

public class StatusHandler extends DefaultHandler{

	private boolean in_update = false;
	private boolean in_status = false; 
	
	private String text="";
	   
	private Status trnf = null;  
	   
	private ArrayList<Status> trfs = null;  
	  
	public ArrayList<Status> getParsedData()   
	 {  
		Log.e("LoginHandler", "I am in getParsedData");
	  return this.trfs;  
	 }  
	  
	 @Override  
	 public void startDocument() throws SAXException   
	 {  
	  Log.e("LoginHandler", "Initiating parser...");  
	  this.trfs = new ArrayList<Status>();  
	 }  
	  
	 @Override  
	 public void endDocument() throws SAXException   
	 {  
	  // Nothing to do  
	 }  
	  
	 /** Gets be called on opening tags like:  
	  * <tag>  
	  * Can provide attribute(s), when xml was like: 
	  * <tag attribute="attributeValue">*/  
	 @Override  
	 public void startElement(String namespaceURI, String localName,   
	          String qName, Attributes atts)   
	               throws SAXException   
	 {  
	  if (qName.equals("StatusUpdate"))   
	  {  
	   this.in_update= true;  
	   trnf = new Status();  
	   Log.e("LoginHandler", "Found an Status");  
	  } 
	  else if(qName.equals("Status")){
		  this.in_status= true;
	  }
	 }  
	   
	 /** Gets be called on closing tags like:  
	  * </tag> */  
	 @Override  
	 public void endElement(String namespaceURI, String localName,   
	String qName) throws SAXException   
	 {  
	  if (qName.equals("StatusUpdate"))   
	  {  
	   this.in_update= false;  
	   trfs.add(trnf); 
	   Log.e("LoginHandler", "Added a Status");
	  }  
	  else if(qName.equals("Status")){
		  trnf.setStatus(text);
		  this.in_status= false;
	  }
	 }  
	   
	 /** Gets be called on the following structure:  
	  * <tag>characters</tag> */  
	   
	    @Override   
	    public void characters(char ch[], int start, int length)   
	    {       
	       if(this.in_update){
	    	   String textBetween = new String(ch, start, length);
	    	   if(this.in_status){
		     text+=(textBetween);
		     Log.e("LoginHandler", "Set Attribute");} 
	    }} 	  
}
