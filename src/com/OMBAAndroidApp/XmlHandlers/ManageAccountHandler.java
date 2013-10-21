package com.OMBAAndroidApp.XmlHandlers;


import java.util.ArrayList;  
	  
import org.xml.sax.Attributes;  
import org.xml.sax.SAXException;  
import org.xml.sax.helpers.DefaultHandler; 
import com.OMBAAndroidApp.ItemFiles.*;
	  
import android.util.Log;  
	  
  
public class ManageAccountHandler extends DefaultHandler  
{  

	private boolean in_customerDetails = false;
	private boolean in_phoneno = false;
	private boolean in_address= false;  
	private boolean in_email = false;

	   
	private CustomerDetails cus = null;  
	   
	private ArrayList<CustomerDetails> cusDetails = null;  
	  
	public ArrayList<CustomerDetails> getParsedData()   
	 {  
	  return this.cusDetails;  
	 }  
	  
	 @Override  
	 public void startDocument() throws SAXException   
	 {  
	  Log.e("SQHandler", "Initiating parser...");  
	  this.cusDetails = new ArrayList<CustomerDetails>();  
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
	  if (localName.equals("Customer"))   
	  {  
		  this.in_customerDetails = true; 
		  cus	= new CustomerDetails(); 
		  Log.e("ManageAccountHandler", "Found Details");
	  } 
	  else if(localName.equals("Phoneno"))
	  {
		  this.in_phoneno = true;    
	  }
	  else if (localName.equals("Address"))   
	  {  
	   this.in_address = true;  
	  }  
	  else if (localName.equals("Email"))   
	  {  
	   this.in_email = true;  
	  }
	
	 }  
	   
	 /** Gets be called on closing tags like:  
	  * </tag> */  
	 @Override  
	 public void endElement(String namespaceURI, String localName,   
	String qName) throws SAXException   
	 {  
	  if (localName.equals("Customer"))   
	  {  
		  this.in_customerDetails = false;
		  cusDetails.add(cus);
	  }  
	  else  if (localName.equals("Phoneno"))   
	  {  
		  this.in_phoneno= false;
		  
	  }
	  else if (localName.equals("Address"))   
	  {  
	   this.in_address= false;  
	  }  
	  else if (localName.equals("Email"))   
	  {  
	   this.in_email = false;  
	  }
	
	 }  
	   
	 /** Gets be called on the following structure:  
	  * <tag>characters</tag> */  
	   
	    @Override  
	    public void characters(char ch[], int start, int length)   
	    {  
	     if(this.in_customerDetails)  
	     { 
	    	    String textBetween = new String(ch, start, length);  
	            if(this.in_phoneno)  
		             cus.setPhoneno(textBetween);
	            else if(this.in_address)  
	            	cus.setAddress(textBetween);
	            else if(this.in_email)  
	            	cus.setEmail(textBetween);
	    
	    }  
	    } 	  
}
