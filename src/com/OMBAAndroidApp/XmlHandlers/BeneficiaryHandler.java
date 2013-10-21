package com.OMBAAndroidApp.XmlHandlers;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.util.Log;

import com.OMBAAndroidApp.ItemFiles.Beneficiary;

public class BeneficiaryHandler extends DefaultHandler{
	
	private boolean in_ben = false;
	private boolean in_accountNo = false;
	private boolean in_name = false;
	private boolean in_bankCode = false;
	   
	private Beneficiary ben = null;  
	   
	private ArrayList<Beneficiary> bens = null;  
	  
	public ArrayList<Beneficiary> getParsedData()   
	 {  
		Log.e("LoginHandler", "I am in getParsedData");
	  return this.bens;  
	 }  
	  
	 @Override  
	 public void startDocument() throws SAXException   
	 {  
	  Log.e("LoginHandler", "Initiating parser...");  
	  this.bens = new ArrayList<Beneficiary>();  
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
	  if (localName.equals("Beneficiary"))   
	  {  
	   this.in_ben = true;  
	   ben = new Beneficiary();  
	   Log.e("LoginHandler", "Found an Acc");  
	  } 
	  else if (localName.equals("AccountNo"))   
	  {  
	   this.in_accountNo = true;  
	  }
	  else if (localName.equals("Name"))   
	  {  
	   this.in_name = true;  
	  }
	  else if (localName.equals("BankCode"))   
	  {  
	   this.in_bankCode = true;  
	  }
	 }  
	   
	 /** Gets be called on closing tags like:  
	  * </tag> */  
	 @Override  
	 public void endElement(String namespaceURI, String localName,   
	String qName) throws SAXException   
	 {  
	  if (localName.equals("Beneficiary"))   
	  {  
	   this.in_ben = false;  
	   bens.add(ben); 
	   Log.e("LoginHandler", "Added an Acc");
	  }  
	  else if (localName.equals("AccountNo"))   
	  {  
	   this.in_accountNo = false;  
	  }
	  else if (localName.equals("Name"))   
	  {  
	   this.in_name = false;  
	  }
	  else if (localName.equals("BankCode"))   
	  {  
	   this.in_bankCode = false;  
	  }
	  
	 }  
	   
	 /** Gets be called on the following structure:  
	  * <tag>characters</tag> */  
	   
	    @Override  
	    public void characters(char ch[], int start, int length)   
	    {  
	     if(this.in_ben)  
	     {  
	            String textBetween = new String(ch, start, length);  
	            if(this.in_accountNo){  
		             ben.setAccountNo(textBetween);
		             Log.e("LoginHandler", "Set Attribute");}
	            else if(this.in_name){
		             ben.setName(textBetween);	
		             Log.e("LoginHandler", "Set Attribute");}
	            else if(this.in_bankCode){
		             ben.setBankCode(textBetween);	
		             Log.e("LoginHandler", "Set Attribute");}
	     }  
	    } 	  
}
