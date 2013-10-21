package com.OMBAAndroidApp.XmlHandlers;


import java.util.ArrayList;  
	  
import org.xml.sax.Attributes;  
import org.xml.sax.SAXException;  
import org.xml.sax.helpers.DefaultHandler; 
import com.OMBAAndroidApp.ItemFiles.*;
	  
import android.util.Log;  
	  
  
public class LoginHandler extends DefaultHandler  
{  

	private boolean in_user = false;
	private boolean in_status = false;
	private boolean in_customerId = false;  
	private boolean in_customerName = false;
	private boolean in_gender = false;
	private boolean in_password = false;
	   
	private User user = null;  
	   
	private ArrayList<User> users = null;  
	  
	public ArrayList<User> getParsedData()   
	 {  
	  return this.users;  
	 }  
	  
	 @Override  
	 public void startDocument() throws SAXException   
	 {  
	  Log.e("LoginHandler", "Initiating parser...");  
	  this.users = new ArrayList<User>();  
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
	  if (localName.equals("Login"))   
	  {  
	   this.in_user = true;  
	   user = new User();  
	   Log.e("LoginHandler", "Found an User");  
	  } 
	  else if (localName.equals("Status"))   
	  {  
	   this.in_status = true;  
	  }
	  else if (localName.equals("CustomerId"))   
	  {  
	   this.in_customerId = true;  
	  }  
	  else if (localName.equals("CustomerName"))   
	  {  
	   this.in_customerName = true;  
	  }
	  else if (localName.equals("Gender"))   
	  {  
	   this.in_gender = true;  
	  }
	  else if (localName.equals("Password"))   
	  {  
	   this.in_password = true;
	  }
	 }  
	   
	 /** Gets be called on closing tags like:  
	  * </tag> */  
	 @Override  
	 public void endElement(String namespaceURI, String localName,   
	String qName) throws SAXException   
	 {  
	  if (localName.equals("Login"))   
	  {  
	   this.in_user = false;  
	   users.add(user);  
	  }  
	  else if (localName.equals("Status"))   
	  {  
	   this.in_status = false;  
	  }
	  else if (localName.equals("CustomerId"))   
	  {  
	   this.in_customerId = false;  
	  }  
	  else if (localName.equals("CustomerName"))   
	  {  
	   this.in_customerName = false;  
	  }
	  else if (localName.equals("Gender"))   
	  {  
	   this.in_gender = false;  
	  }
	  else if (localName.equals("Password"))   
	  {  
	   this.in_password = false;
	  }
	 }  
	   
	 /** Gets be called on the following structure:  
	  * <tag>characters</tag> */  
	   
	    @Override  
	    public void characters(char ch[], int start, int length)   
	    {  
	     if(this.in_user)  
	     {  
	            String textBetween = new String(ch, start, length);  
	            if(this.in_status)  
		             user.setStatus(textBetween);
	            else if(this.in_customerId)  
		             user.setCustomerId(textBetween);
	            else if(this.in_customerName)  
	             user.setCustomerName(textBetween);
	            else if(this.in_gender)  
		             user.setGender(textBetween);
	            else if(this.in_password)  
		             user.setPassword(textBetween);		              
	     }  
	    } 	  
}
