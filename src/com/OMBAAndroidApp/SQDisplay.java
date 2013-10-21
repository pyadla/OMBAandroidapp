package com.OMBAAndroidApp;


import java.util.ArrayList;
import java.util.List;

import com.OMBAAndroidApp.ItemFiles.SecurityQuestion;

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


public class SQDisplay extends Activity {
    /** Called when the activity is first created. */
	String password;
	TextView sqq,text1;
	EditText an,cid;
	Button login;
	List<String> ques;
	List<String> ans;
	int i,tr,ct,flag;
    private ProgressDialog progressDialog;
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.securityquestion);
        i=0;
        tr=0;
        ct=0;
        flag=0;
        ques=new ArrayList<String>();
        ans=new ArrayList<String>();
        
       login=(Button)this.findViewById(R.id.login); 
       text1=(TextView)this.findViewById(R.id.text1);
       sqq=(TextView)this.findViewById(R.id.sqq);
       an=(EditText)this.findViewById(R.id.ans);
       cid=(EditText)this.findViewById(R.id.cid);
       
     /*  cid.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				cid.setText("");
				text1.setText("");
			}
      });
       
       an.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				an.setText("");
				text1.setText("");
			}
     });*/
       
       Button loc=(Button)this.findViewById(R.id.loc);
       
       loc.setOnClickListener(new View.OnClickListener() {  
           public void onClick(View v){  
            Uri uri = Uri.parse("http://g.co/maps/fsn74");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
           }  
        }); 
       
        login.setOnClickListener(new OnClickListener(){
        	   @Override
        	   public void onClick(View v) {
        		   progressDialog = ProgressDialog.show(SQDisplay.this, "", "Loading...");
                   new Thread() {
                   public void run() {
                   try{
                   sleep(3000);
        		   if(flag==1){
        		   text1.setText(" ");  
                   checkAnswer();
        		   if(tr==1){   
                   finish(); 
        		   Intent i=new Intent(SQDisplay.this, ChangePassword.class);
     		         startActivity(i);}
        	   }
        	   else{
        		   LoginScreen.customerId=cid.getText().toString().trim();
        			if(LoginScreen.customerId.matches("\\d{8}")){
        				LoginScreen.fetchSQ();
        			if(LoginScreen.sq.size()!=0){
        				for(SecurityQuestion q:LoginScreen.sq){
        		        	ques.add(q.getQuestion());
        		        	ans.add(q.getAnswer());
        		        	ct++;
        		        }
        				flag=1;
        				cid.setVisibility(View.GONE);
        				sqq.setVisibility(View.VISIBLE);
        				an.setVisibility(View.VISIBLE);
        				displayQuestion();
        				}
        			else text1.setText("Invalid CustomerId");
        			}
        		}
        		}catch (Exception e) {

                    Log.e("tag", e.getMessage());

                    }

                    // dismiss the progress dialog

                    progressDialog.dismiss();

                    }

                    }.start();
                    }              
            });
    }
    void displayQuestion(){
    	if((i+1)<=ct)
    	sqq.setText(""+ques.get(i));
    	else
    	{
    	text1.setText("Successful Login!");
    	tr=1;
    	}
    } 
    	void checkAnswer(){
    	String a=an.getText().toString();
    	if(a!=null && a.equals(ans.get(i))){
    	    i++;
    	    displayQuestion();
    	}
    	else{
    	text1.setText("Please enter the correct answer");
    	}
       }
}