package com.OMBAAndroidApp;

import java.net.URL;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import com.OMBAAndroidApp.XmlHandlers.LoginHandler;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ChangePassword extends Activity {
    /** Called when the activity is first created. */
	EditText pwd,rpwd;
	Button submit;
	TextView text1;
	String pw;
	int ch=0;
	@Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.changepwd);
        
        pwd=(EditText)this.findViewById(R.id.pwd);
        rpwd=(EditText)this.findViewById(R.id.rpwd);
        submit=(Button)this.findViewById(R.id.change);
        text1=(TextView)this.findViewById(R.id.text1);
        Button gll=(Button)this.findViewById(R.id.gll);
        Button loc=(Button)this.findViewById(R.id.loc);
        
        loc.setOnClickListener(new View.OnClickListener() {  
            public void onClick(View v){  
               
             Uri uri = Uri.parse("http://g.co/maps/fsn74");
             Intent intent = new Intent(Intent.ACTION_VIEW, uri);
             startActivity(intent);

           
            }  }); 
         gll.setOnClickListener(new OnClickListener(){        
   	      
         	   @Override
         	   public void onClick(View v) {
            	   finish();
         		   Intent i=new Intent(ChangePassword.this, ViewGallery.class);
      		         startActivity(i);
         	   }
            }); 
       pwd.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				pwd.setText("");				
			}
      });
        rpwd.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				rpwd.setText("");				
			}
      });
        submit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
				checkPassword();
				if(ch==1){
				     changePassword();	
				     text1.setText("Password Successfully changed");
	            	   finish();
				     Intent i=new Intent(ChangePassword.this, LoginScreen.class);
     		         startActivity(i);
				}
			}       
	       });
    }
	
	void checkPassword(){
		pw=pwd.getText().toString();
		String rpw=rpwd.getText().toString();
		if(pw.matches("^[a-zA-Z]\\w*[\\.@$!_]*\\w*")){
			if(pw.equals(rpw))
				ch=1;
		}
		else text1.setText("Invalid Password");
	}
	
	void changePassword(){
		try   
        {  
          // Create a URL we want to load some xml-data from.  
          URL url = new URL("http://code.google.codeat2.appspot.com/LoginSQ?customerId="+LoginScreen.customerId+"&password="+pw);  
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
      LoginScreen.users = xmlHandler.getParsedData();
    }   
        catch (Exception e)   
    {  
     Log.e("HelloApp", "XML Error", e);   
    }
	}
	
}