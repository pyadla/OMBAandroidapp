package com.OMBAAndroidApp.XmlHandlers;


import java.util.ArrayList;  
	  
import org.xml.sax.Attributes;  
import org.xml.sax.SAXException;  
import org.xml.sax.helpers.DefaultHandler; 
import com.OMBAAndroidApp.ItemFiles.*;
	  
import android.util.Log;  
	  
  
public class AccBalanceHandler extends DefaultHandler  
{  

	private boolean in_acc = false;
	private boolean in_accountNo = false;
	private boolean in_balance = false;  
	   
	private Account acc = null;  
	   
	private ArrayList<Account> accs = null;  
	  
	public ArrayList<Account> getParsedData()   
	 {  
		Log.e("LoginHandler", "I am in getParsedData");
	  return this.accs;  
	 }  
	  
	 @Override  
	 public void startDocument() throws SAXException   
	 {  
	  Log.e("LoginHandler", "Initiating parser...");  
	  this.accs = new ArrayList<Account>();  
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
	  if (localName.equals("Account"))   
	  {  
	   this.in_acc = true;  
	   acc = new Account();  
	   Log.e("LoginHandler", "Found an Acc");  
	  } 
	  else if (localName.equals("AccountNo"))   
	  {  
	   this.in_accountNo = true;  
	  }
	  else if (localName.equals("Balance"))   
	  {  
	   this.in_balance = true;  
	  }  
	 }  
	   
	 /** Gets be called on closing tags like:  
	  * </tag> */  
	 @Override  
	 public void endElement(String namespaceURI, String localName,   
	String qName) throws SAXException   
	 {  
	  if (localName.equals("Account"))   
	  {  
	   this.in_acc = false;  
	   accs.add(acc); 
	   Log.e("LoginHandler", "Added an Acc");
	  }  
	  else if (localName.equals("AccountNo"))   
	  {  
	   this.in_accountNo = false;  
	  }
	  else if (localName.equals("Balance"))   
	  {  
	   this.in_balance = false;  
	  }  
	  
	 }  
	   
	 /** Gets be called on the following structure:  
	  * <tag>characters</tag> */  
	   
	    @Override  
	    public void characters(char ch[], int start, int length)   
	    {  
	     if(this.in_acc)  
	     {  
	            String textBetween = new String(ch, start, length);  
	            if(this.in_accountNo){  
		             acc.setAccountNo(textBetween);
		             Log.e("LoginHandler", "Set Attribute");}
	            else if(this.in_balance){
		             acc.setBalance(textBetween);	
		             Log.e("LoginHandler", "Set Attribute");}
	     }  
	    } 	  
}
