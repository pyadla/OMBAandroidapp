package com.OMBAAndroidApp.XmlHandlers;


import java.util.ArrayList;  
	  
import org.xml.sax.Attributes;  
import org.xml.sax.SAXException;  
import org.xml.sax.helpers.DefaultHandler; 
import com.OMBAAndroidApp.ItemFiles.*;
	  
import android.util.Log;  
	  
  
public class SQHandler extends DefaultHandler  
{  

	private boolean in_sq = false;
	private boolean in_question = false;
	private boolean in_answer = false;  
	   
	private SecurityQuestion sq = null;  
	   
	private ArrayList<SecurityQuestion> sqs = null;  
	  
	public ArrayList<SecurityQuestion> getParsedData()   
	 {  
		Log.e("LoginHandler", "I am in getParsedData");
	  return this.sqs;  
	 }  
	  
	 @Override  
	 public void startDocument() throws SAXException   
	 {  
	  Log.e("LoginHandler", "Initiating parser...");  
	  this.sqs = new ArrayList<SecurityQuestion>();  
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
	  if (localName.equals("SQ"))   
	  {  
	   this.in_sq = true;  
	   sq = new SecurityQuestion();  
	   Log.e("LoginHandler", "Found an SQ");  
	  } 
	  else if (localName.equals("Q"))   
	  {  
	   this.in_question = true;  
	  }
	  else if (localName.equals("A"))   
	  {  
	   this.in_answer = true;  
	  }  
	 }  
	   
	 /** Gets be called on closing tags like:  
	  * </tag> */  
	 @Override  
	 public void endElement(String namespaceURI, String localName,   
	String qName) throws SAXException   
	 {  
	  if (localName.equals("SQ"))   
	  {  
	   this.in_sq = false;  
	   sqs.add(sq); 
	   Log.e("LoginHandler", "Added an SQ");
	  }  
	  else if (localName.equals("Q"))   
	  {  
	   this.in_question = false;  
	  }
	  else if (localName.equals("A"))   
	  {  
	   this.in_answer = false;  
	  }  
	  
	 }  
	   
	 /** Gets be called on the following structure:  
	  * <tag>characters</tag> */  
	   
	    @Override  
	    public void characters(char ch[], int start, int length)   
	    {  
	     if(this.in_sq)  
	     {  
	            String textBetween = new String(ch, start, length);  
	            if(this.in_question){  
		             sq.setQuestion(textBetween);
		             Log.e("LoginHandler", "Set Attribute");}
	            else if(this.in_answer){
		             sq.setAnswer(textBetween);	
		             Log.e("LoginHandler", "Set Attribute");}
	     }  
	    } 	  
}
