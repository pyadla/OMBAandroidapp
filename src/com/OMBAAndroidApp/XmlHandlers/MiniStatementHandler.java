package com.OMBAAndroidApp.XmlHandlers;


import java.util.ArrayList;  
	  
import org.xml.sax.Attributes;  
import org.xml.sax.SAXException;  
import org.xml.sax.helpers.DefaultHandler; 
import com.OMBAAndroidApp.ItemFiles.*;
	  
import android.util.Log;  
	  
  
public class MiniStatementHandler extends DefaultHandler  
{  

	private boolean in_transaction = false;
	private boolean in_date = false;
	private boolean in_amount = false;  
	private boolean in_desc = false;
	
	private MiniTransaction tr = null;  
	   
	private ArrayList<MiniTransaction> trs = null;  
	  
	public ArrayList<MiniTransaction> getParsedData()   
	 {  
	  return this.trs;  
	 }  
	  
	 @Override  
	 public void startDocument() throws SAXException   
	 {  
	  Log.e("MiniTransactionHandler", "Initiating parser...");  
	  this.trs = new ArrayList<MiniTransaction>();  
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
	  if (localName.equals("Transaction"))   
	  {  
	   this.in_transaction = true;  
	   tr = new MiniTransaction();  
	   Log.e("MiniTransactionHandler", "Found an User");  
	  } 

	  else if (localName.equals("Date"))   
	  {  
	   this.in_date = true;  
	  }
	  else if (localName.equals("Amount"))   
	  {  
	   this.in_amount= true;  
	  }  
	  else if (localName.equals("Desc"))   
	  {  
	   this.in_desc= true;  
	  }
	 }  
	   
	 /** Gets be called on closing tags like:  
	  * </tag> */  
	 @Override  
	 public void endElement(String namespaceURI, String localName,   
	String qName) throws SAXException   
	 {  
	  if (localName.equals("Transaction"))   
	  {  
	   this.in_transaction = false;  
	   trs.add(tr);  
	  }  
	  else if (localName.equals("Date"))   
	  {  
	   this.in_date = false;  
	  }
	  else if (localName.equals("Amount"))   
	  {  
	   this.in_amount = false;  
	  }  
	  else if (localName.equals("Desc"))   
	  {  
	   this.in_desc = false;  
	  } }  
	   
	 /** Gets be called on the following structure:  
	  * <tag>characters</tag> */  
	   
	   @Override  
	    public void characters(char ch[], int start, int length)   
	    {  
	     if(this.in_transaction)  
	     {  
	            String textBetween = new String(ch, start, length);  
	            if(this.in_date)  
		             tr.setDate(textBetween);
	            else if(this.in_amount)  
		             tr.setAmount(textBetween);
	            else if(this.in_desc)  
	                 tr.setDescription(textBetween);
	     }  
	    } 	  
}

