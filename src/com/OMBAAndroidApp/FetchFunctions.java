package com.OMBAAndroidApp;

import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.util.Log;

import com.OMBAAndroidApp.XmlHandlers.AccBalanceHandler;
import com.OMBAAndroidApp.XmlHandlers.BeneficiaryHandler;
import com.OMBAAndroidApp.XmlHandlers.ManageAccountHandler;
import com.OMBAAndroidApp.XmlHandlers.MiniStatementHandler;
import com.OMBAAndroidApp.XmlHandlers.TransactionHandler;
import com.OMBAAndroidApp.XmlHandlers.StatusHandler;
import com.OMBAAndroidApp.ItemFiles.Account;
import com.OMBAAndroidApp.ItemFiles.Beneficiary;
import com.OMBAAndroidApp.ItemFiles.CustomerDetails;
import com.OMBAAndroidApp.ItemFiles.MiniTransaction;
import com.OMBAAndroidApp.ItemFiles.Transaction;
import com.OMBAAndroidApp.ItemFiles.Status;

public class FetchFunctions {
	
   public static ArrayList<Account> accounts;
   public static ArrayList<MiniTransaction> trs;
   public static ArrayList<Transaction> trns;
   public static ArrayList<Beneficiary> bens;
   public static ArrayList<Status> transferStatus;
   public static ArrayList<CustomerDetails> cdetails;
   public static ArrayList<Status> manageAccStatus;
   public static ArrayList<Status> addBenStatus;
   public static ArrayList<Status> addSQstatus;
   public static ArrayList<Status> scheduleStatus;
   
   public static void fetchAccBalance(){
	   accounts=new ArrayList<Account>();
   	try   
       {  
         // Create a URL we want to load some xml-data from.  
         URL url = new URL("http://code.google.codeat2.appspot.com/BalanceUpdate?customerId="+LoginScreen.customerId);  
         // Get a SAXParser from the SAXPArserFactory.  
         SAXParserFactory spf = SAXParserFactory.newInstance();  
         SAXParser sp = spf.newSAXParser();  
         // Get the XMLReader of the SAXParser we created.  
         XMLReader xr = sp.getXMLReader();  
                // Create a new ContentHandler and   
                //apply it to the XML-Reader  
           AccBalanceHandler xmlHandler = new AccBalanceHandler();  
           xr.setContentHandler(xmlHandler);  
           InputSource xmlInput = new InputSource(url.openStream());  
           Log.e("HelloApp", "Input Source Defined: "   
                          + xmlInput.toString());  
           /* Parse the xml-data from our URL. */  
          xr.parse(xmlInput);  
          /* Parsing has finished. */  
                 /* LoginHandler now provides the parsed data to us. */  
         accounts = xmlHandler.getParsedData();
   }   
       catch (Exception e)   
   {  
    Log.e("HelloApp", "XML Error", e);   
   }
   }
   
   public static void fetchMiniTransactions(String accountNo){
	   trs=new ArrayList<MiniTransaction>();
   	try   
       {  
         // Create a URL we want to load some xml-data from.  
         URL url = new URL("http://code.google.codeat2.appspot.com/MiniStatementUpdate?customerId="+LoginScreen.customerId+"&accountNo="+accountNo);  
         // Get a SAXParser from the SAXPArserFactory.  
         SAXParserFactory spf = SAXParserFactory.newInstance();  
         SAXParser sp = spf.newSAXParser();  
         // Get the XMLReader of the SAXParser we created.  
         XMLReader xr = sp.getXMLReader();  
                // Create a new ContentHandler and   
                //apply it to the XML-Reader  
           MiniStatementHandler xmlHandler = new MiniStatementHandler();  
           xr.setContentHandler(xmlHandler);  
           InputSource xmlInput = new InputSource(url.openStream());  
           Log.e("HelloApp", "Input Source Defined: "   
                          + xmlInput.toString());  
           /* Parse the xml-data from our URL. */  
          xr.parse(xmlInput);  
          /* Parsing has finished. */  
                 /* LoginHandler now provides the parsed data to us. */  
         trs = xmlHandler.getParsedData();
   }   
       catch (Exception e)   
   {  
    Log.e("HelloApp", "XML Error", e);   
   }
   }
   
   public static void fetchTransactions(String sDate,String eDate,String accountNo){
	   trns=new ArrayList<Transaction>();
   	try   
       {  
         // Create a URL we want to load some xml-data from.  
         URL url = new URL("http://code.google.codeat2.appspot.com/TransactionHistoryUpdate?sDate="+sDate+"&eDate="+eDate+"&acc="+accountNo);  
         // Get a SAXParser from the SAXPArserFactory.  
         SAXParserFactory spf = SAXParserFactory.newInstance();  
         SAXParser sp = spf.newSAXParser();  
         // Get the XMLReader of the SAXParser we created.  
         XMLReader xr = sp.getXMLReader();  
                // Create a new ContentHandler and   
                //apply it to the XML-Reader  
           TransactionHandler xmlHandler = new TransactionHandler();  
           xr.setContentHandler(xmlHandler);  
           InputSource xmlInput = new InputSource(url.openStream());  
           Log.e("HelloApp", "Input Source Defined: "   
                          + xmlInput.toString());  
           /* Parse the xml-data from our URL. */  
          xr.parse(xmlInput);  
          /* Parsing has finished. */  
                 /* LoginHandler now provides the parsed data to us. */  
         trns = xmlHandler.getParsedData();
   }   
       catch (Exception e)   
   {  
    Log.e("HelloApp", "XML Error", e);   
   }
   }
   
   public static void fetchBeneficiaries(){
	   bens=new ArrayList<Beneficiary>();
   	try   
       {  
         // Create a URL we want to load some xml-data from.  
         URL url = new URL("http://code.google.codeat2.appspot.com/getBeneficiaryList?customerId="+LoginScreen.customerId);  
         // Get a SAXParser from the SAXPArserFactory.  
         SAXParserFactory spf = SAXParserFactory.newInstance();  
         SAXParser sp = spf.newSAXParser();  
         // Get the XMLReader of the SAXParser we created.  
         XMLReader xr = sp.getXMLReader();  
                // Create a new ContentHandler and   
                //apply it to the XML-Reader  
           BeneficiaryHandler xmlHandler = new BeneficiaryHandler();  
           xr.setContentHandler(xmlHandler);  
           InputSource xmlInput = new InputSource(url.openStream());  
           Log.e("HelloApp", "Input Source Defined: "   
                          + xmlInput.toString());  
           /* Parse the xml-data from our URL. */  
          xr.parse(xmlInput);  
          /* Parsing has finished. */  
                 /* LoginHandler now provides the parsed data to us. */  
         bens = xmlHandler.getParsedData();
   }   
       catch (Exception e)   
   {  
    Log.e("HelloApp", "XML Error", e);   
   }
   }
   
   public static void transferMoney(String fa,String ta,String amt){
	   transferStatus=new ArrayList<Status>();
   	try   
       {  
         // Create a URL we want to load some xml-data from.  
         URL url = new URL("http://code.google.codeat2.appspot.com/transfunds?customerId="+LoginScreen.customerId+"&fromaccount="+fa+"&toaccount="+ta+"&amount="+amt);  
         // Get a SAXParser from the SAXPArserFactory.  
         SAXParserFactory spf = SAXParserFactory.newInstance();  
         SAXParser sp = spf.newSAXParser();  
         // Get the XMLReader of the SAXParser we created.  
         XMLReader xr = sp.getXMLReader();  
                // Create a new ContentHandler and   
                //apply it to the XML-Reader  
           StatusHandler xmlHandler = new StatusHandler();  
           xr.setContentHandler(xmlHandler);  
           InputSource xmlInput = new InputSource(url.openStream());  
           Log.e("HelloApp", "Input Source Defined: "   
                          + xmlInput.toString());  
           /* Parse the xml-data from our URL. */  
          xr.parse(xmlInput);  
          /* Parsing has finished. */  
                 /* LoginHandler now provides the parsed data to us. */  
         transferStatus = xmlHandler.getParsedData();
   }   
       catch (Exception e)   
   {  
    Log.e("HelloApp", "XML Error", e);   
   }
   }
   
   public static void fetchCustomerDetails(){
   	
	   cdetails=new ArrayList<CustomerDetails>();
   	try   
       {  
   		
         // Create a URL we want to load some xml-data from.  
         URL url = new URL("http://code.google.codeat2.appspot.com/customerDetailsUpdate?customerId="+LoginScreen.customerId);  
         // Get a SAXParser from the SAXPArserFactory.  
         SAXParserFactory spf = SAXParserFactory.newInstance();  
         SAXParser sp = spf.newSAXParser();  
         // Get the XMLReader of the SAXParser we created.  
         XMLReader xr = sp.getXMLReader();  
                // Create a new ContentHandler and   
                //apply it to the XML-Reader  
           ManageAccountHandler xmlHandler = new ManageAccountHandler();  
           xr.setContentHandler(xmlHandler);  
           InputSource xmlInput = new InputSource(url.openStream());  
           Log.e("HelloApp", "Input Source Defined: "   
                          + xmlInput.toString());  
           /* Parse the xml-data from our URL. */  
          xr.parse(xmlInput);  
          /* Parsing has finished. */  
                 /* LoginHandler now provides the parsed data to us. */  
          cdetails = xmlHandler.getParsedData();
   }   
       catch (Exception e)   
   {  
    Log.e("HelloApp", "XML Error", e);   
   }
}
   public static void changeDetails(String ph,String ad,String em){
	   manageAccStatus=new ArrayList<Status>();
   	try   
       {  
         // Create a URL we want to load some xml-data from.  
         URL url = new URL("http://code.google.codeat2.appspot.com/ManageAccUpdate?customerId="+LoginScreen.customerId+"&phoneno="+ph+"&address="+ad+"&email="+em);  
         // Get a SAXParser from the SAXPArserFactory.  
         SAXParserFactory spf = SAXParserFactory.newInstance();  
         SAXParser sp = spf.newSAXParser();  
         // Get the XMLReader of the SAXParser we created.  
         XMLReader xr = sp.getXMLReader();  
                // Create a new ContentHandler and   
                //apply it to the XML-Reader  
           StatusHandler xmlHandler = new StatusHandler();  
           xr.setContentHandler(xmlHandler);  
           InputSource xmlInput = new InputSource(url.openStream());  
           Log.e("HelloApp", "Input Source Defined: "   
                          + xmlInput.toString());  
           /* Parse the xml-data from our URL. */  
          xr.parse(xmlInput);  
          /* Parsing has finished. */  
                 /* LoginHandler now provides the parsed data to us. */  
         manageAccStatus = xmlHandler.getParsedData();
   }   
       catch (Exception e)   
   {  
    Log.e("HelloApp", "XML Error", e);   
   }
   }
   
   public static void addBen(String ba,String bn,String bc){
	   addBenStatus=new ArrayList<Status>();
   	try   
       {  
         // Create a URL we want to load some xml-data from.  
         URL url = new URL("http://code.google.codeat2.appspot.com/BeneficiaryUpdate?customerId="+LoginScreen.customerId+"&name="+bn+"&benacc="+ba+"&bcode="+bc);  
         // Get a SAXParser from the SAXPArserFactory.  
         SAXParserFactory spf = SAXParserFactory.newInstance();  
         SAXParser sp = spf.newSAXParser();  
         // Get the XMLReader of the SAXParser we created.  
         XMLReader xr = sp.getXMLReader();  
                // Create a new ContentHandler and   
                //apply it to the XML-Reader  
           StatusHandler xmlHandler = new StatusHandler();  
           xr.setContentHandler(xmlHandler);  
           InputSource xmlInput = new InputSource(url.openStream());  
           Log.e("HelloApp", "Input Source Defined: "   
                          + xmlInput.toString());  
           /* Parse the xml-data from our URL. */  
          xr.parse(xmlInput);  
          /* Parsing has finished. */  
                 /* LoginHandler now provides the parsed data to us. */  
         addBenStatus = xmlHandler.getParsedData();
   }   
       catch (Exception e)   
   {  
    Log.e("HelloApp", "XML Error", e);   
   }
   }
   
   public static void addSecurityQues(String q,String a){
	   addSQstatus=new ArrayList<Status>();
   	try   
       {  
         // Create a URL we want to load some xml-data from.  
         URL url = new URL("http://code.google.codeat2.appspot.com/AddSecurityQuestion?customerId="+LoginScreen.customerId+"&questionId="+q+"&answer="+a);  
         // Get a SAXParser from the SAXPArserFactory.  
         SAXParserFactory spf = SAXParserFactory.newInstance();  
         SAXParser sp = spf.newSAXParser();  
         // Get the XMLReader of the SAXParser we created.  
         XMLReader xr = sp.getXMLReader();  
                // Create a new ContentHandler and   
                //apply it to the XML-Reader  
           StatusHandler xmlHandler = new StatusHandler();  
           xr.setContentHandler(xmlHandler);  
           InputSource xmlInput = new InputSource(url.openStream());  
           Log.e("HelloApp", "Input Source Defined: "   
                          + xmlInput.toString());  
           /* Parse the xml-data from our URL. */  
          xr.parse(xmlInput);  
          /* Parsing has finished. */  
                 /* LoginHandler now provides the parsed data to us. */  
         addSQstatus = xmlHandler.getParsedData();
   }   
       catch (Exception e)   
   {  
    Log.e("HelloApp", "XML Error", e);   
   }
   }
   
   public static void scheduleTransfer(String fromaccount,String toaccount,String amount,String date){
	   scheduleStatus=new ArrayList<Status>();
   	try   
       {  
         // Create a URL we want to load some xml-data from.  
         URL url = new URL("http://code.google.codeat2.appspot.com/schTransferUpdate?customerId="+LoginScreen.customerId+"&fromaccount="+fromaccount+"&toaccount="+toaccount+"&amount="+amount+"&date="+date);  
         // Get a SAXParser from the SAXPArserFactory.  
         SAXParserFactory spf = SAXParserFactory.newInstance();  
         SAXParser sp = spf.newSAXParser();  
         // Get the XMLReader of the SAXParser we created.  
         XMLReader xr = sp.getXMLReader();  
                // Create a new ContentHandler and   
                //apply it to the XML-Reader  
           StatusHandler xmlHandler = new StatusHandler();  
           xr.setContentHandler(xmlHandler);  
           InputSource xmlInput = new InputSource(url.openStream());  
           Log.e("HelloApp", "Input Source Defined: "   
                          + xmlInput.toString());  
           /* Parse the xml-data from our URL. */  
          xr.parse(xmlInput);  
          /* Parsing has finished. */  
                 /* LoginHandler now provides the parsed data to us. */  
         scheduleStatus = xmlHandler.getParsedData();
   }   
       catch (Exception e)   
   {  
    Log.e("HelloApp", "XML Error", e);   
   }
   }
}
