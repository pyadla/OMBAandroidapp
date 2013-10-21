package com.OMBAAndroidApp;

import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import com.OMBAAndroidApp.ItemFiles.User;
import com.OMBAAndroidApp.ItemFiles.SecurityQuestion;
import com.OMBAAndroidApp.XmlHandlers.LoginHandler;
import com.OMBAAndroidApp.XmlHandlers.SQHandler;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginScreen extends Activity {
    /** Called when the activity is first created. */
	public static ArrayList<User> users;
	public static ArrayList<SecurityQuestion> sq;
	public static String customerId,customerName,gender,password;
	EditText cid,pwd;
	TextView text1;
	int tr=0,ci=0;
	public static int cc=0;
    private ProgressDialog progressDialog;
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        if(cc==1){
     	   finish();
    		Intent i=new Intent(LoginScreen.this, HomeScreen.class);
 		         startActivity(i);}
        else{
        setContentView(R.layout.login);
        ci=0;
        text1=(TextView)this.findViewById(R.id.text1);
        cid=(EditText)this.findViewById(R.id.cid);
        pwd=(EditText)this.findViewById(R.id.pwd);
        
       Button login=(Button)this.findViewById(R.id.login);
       Button chpwd=(Button)this.findViewById(R.id.chpwd);
       Button about=(Button)this.findViewById(R.id.ab);
       Button loc=(Button)this.findViewById(R.id.loc);
       
       loc.setOnClickListener(new View.OnClickListener() {  
           public void onClick(View v){  
              
            Uri uri = Uri.parse("http://g.co/maps/fsn74");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);

          
           }  });   
        chpwd.setOnClickListener(new OnClickListener(){        
    	      
     	   @Override
     	   public void onClick(View v) {

        		 progressDialog = ProgressDialog.show(LoginScreen.this, "", "Loading...");

               new Thread() {

               public void run() {

               try{

               sleep(3000);
        	   finish();
     		   Intent i=new Intent(LoginScreen.this, SQDisplay.class);
  		         startActivity(i);
     	   }catch (Exception e) {

               Log.e("tag", e.getMessage());

               }

               // dismiss the progress dialog

               progressDialog.dismiss();

               }

               }.start();
               }           
        }); 
        
        about.setOnClickListener(new OnClickListener(){        
  	      
      	   @Override
      	   public void onClick(View v) {
      		   Intent i=new Intent(LoginScreen.this, AboutUs.class);
   		         startActivity(i);
      	   }
         }); 
       

       login.setOnClickListener(new OnClickListener(){       
           
           @Override
           public void onClick(View v) {
              
               progressDialog = ProgressDialog.show(LoginScreen.this, "", "Loading...");

               new Thread() {

               public void run() {

               try{

               sleep(3000);
               String cd=cid.getText().toString().trim();
               if(cd.matches("\\d{8}")&&pwd!=null){
               users= new ArrayList<User>();
               fetchContent();
               if(ci==0){
                   for(User x:users){
                     customerName=x.getCustomerName();
                     gender=x.getGender();                         
                  }
                 //  display();
            if(cc==1){
         	   finish();
            Intent i=new Intent(LoginScreen.this, AfterLogin.class);
                  startActivity(i);                      } }                  
              else if(tr==3){
           	   finish();
               Intent i=new Intent(LoginScreen.this, SQDisplay.class);
                  startActivity(i);
              }}

               } catch (Exception e) {

               Log.e("tag", e.getMessage());

               }

               // dismiss the progress dialog

               progressDialog.dismiss();

               }

               }.start();
               }              
       });
   }}
    
    void fetchContent(){
         
    	customerId= cid.getText().toString();
    	customerId.trim();
        password= pwd.getText().toString();
        
    	try   
        {  
          // Create a URL we want to load some xml-data from.  
          URL url = new URL("http://code.google.codeat2.appspot.com/LoginUpdate?customerId="+customerId+"&password="+password);  
          // Get a SAXParser from the SAXPArserFactory.  
          SAXParserFactory spf = SAXParserFactory.newInstance();  
          SAXParser sp = spf.newSAXParser();  
          // Get the XMLReader of the SAXParser we created.  
          XMLReader xr = sp.getXMLReader();  
                 // Create a new ContentHandler and   
                 //apply it to the XML-Reader  
            LoginHandler xmlHandler = new LoginHandler();  
            xr.setContentHandler(xmlHandler);  
            InputSource xmlInput = new InputSource(url.openStream());  
            Log.e("HelloApp", "Input Source Defined: "   
                           + xmlInput.toString());  
            /* Parse the xml-data from our URL. */  
           xr.parse(xmlInput);  
           /* Parsing has finished. */  
                  /* LoginHandler now provides the parsed data to us. */  
           users = xmlHandler.getParsedData();
    }   
        catch (Exception e)   
    {  
     Log.e("HelloApp", "XML Error", e);   
    }
    	String status="";
    	for(User x:users){
   		   status=x.getStatus();
         }
    	
    	if(!(status.equals("SuccessfulLogin"))){
    		StatusDisp.st=status;
    		StatusDisp.screen=1;
    		Intent i=new Intent(LoginScreen.this, StatusDisp.class);
            startActivity(i);
        }
    	else if(status.equals("SuccessfulLogin")) 
    		cc=1;
    	if(status.equals("Invalid password")){
    		ci=1;tr++;}
   }
    
    public static void fetchSQ(){
    	sq= new ArrayList<SecurityQuestion>();
    	try   
        {  
          // Create a URL we want to load some xml-data from.  
          URL url = new URL("http://code.google.codeat2.appspot.com/SQUpdate?customerId="+customerId);  
          // Get a SAXParser from the SAXPArserFactory.  
          SAXParserFactory spf = SAXParserFactory.newInstance();  
          SAXParser sp = spf.newSAXParser();  
          // Get the XMLReader of the SAXParser we created.  
          XMLReader xr = sp.getXMLReader();  
                 // Create a new ContentHandler and   
                 //apply it to the XML-Reader  
            SQHandler xmlHandler = new SQHandler();  
            xr.setContentHandler(xmlHandler);  
            InputSource xmlInput = new InputSource(url.openStream());  
            Log.e("HelloApp", "Input Source Defined: "   
                           + xmlInput.toString());  
            /* Parse the xml-data from our URL. */  
           xr.parse(xmlInput);  
           /* Parsing has finished. */  
                  /* LoginHandler now provides the parsed data to us. */  
      sq = xmlHandler.getParsedData();
    }   
        catch (Exception e)   
    {  
     Log.e("HelloApp", "XML Error", e);   
    }
    }
    
    /*void display()
    {
    	TextView text1=(TextView)this.findViewById(R.id.text1);
    	text1.setText("Hi"+customerName+"Hello"+gender+"Hi"+id);
    }*/

}