package com.OMBAAndroidApp;


import java.util.ArrayList;

import com.OMBAAndroidApp.ItemFiles.SecurityQuestion;
import com.OMBAAndroidApp.ItemFiles.Status;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class AccountSettings extends Activity {
    /** Called when the activity is first created. */
    String answer;
    Spinner sqs;
    TextView stt;
    EditText sqans;
    Button secq,sub,chpwd,lg,home,macc;
    ArrayList<String> ques;
    ArrayList<String>questions;
    int flag;
    private ProgressDialog progressDialog;
   
    @Override
    public void onCreate(Bundle savedInstanceState) {
       
       
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accountsettings);
        TextView name=(TextView)this.findViewById(R.id.name);
       
        name.setText(LoginScreen.customerName);
       
        LoginScreen.fetchSQ();
       
        ques=new ArrayList<String>();      
        questions=new ArrayList<String>();
       
        questions.add("What is your mother maiden name?");
        questions.add("What is your pet name?");
        questions.add("What is your first school name?");
        questions.add("Who is your favorite teacher?");
        questions.add("What is your street name?");
       
        for(String qq:questions){
            flag=0;
            for(SecurityQuestion q:LoginScreen.sq)
              if(q.getQuestion().equals(qq))
                flag=1;
            if(flag==0) ques.add(qq);
        }
       secq=(Button)this.findViewById(R.id.secq);
       stt=(TextView)this.findViewById(R.id.stt);
       sqans=(EditText)this.findViewById(R.id.sqans);
       sqs=(Spinner)this.findViewById(R.id.sqs);
       sub=(Button)this.findViewById(R.id.sub);
       chpwd=(Button)this.findViewById(R.id.chpwd);
       lg=(Button)this.findViewById(R.id.lg);
       home=(Button)this.findViewById(R.id.home);
       macc=(Button)this.findViewById(R.id.macc);
      
       macc.setOnClickListener(new OnClickListener(){        
  	      
     	   @Override
     	   public void onClick(View v) {
     		  progressDialog = ProgressDialog.show(AccountSettings.this, "", "Loading...");

              new Thread() {

              public void run() {

              try{

              sleep(3000);
     		   finish();
     		   Intent i=new Intent(AccountSettings.this, ManageAccount.class);
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
       home.setOnClickListener(new OnClickListener(){       
            
           @Override
           public void onClick(View v) {
        	   progressDialog = ProgressDialog.show(AccountSettings.this, "", "Loading...");

               new Thread() {

               public void run() {

               try{

               sleep(3000);
               Intent i=new Intent(AccountSettings.this, HomeScreen.class);
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
       lg.setOnClickListener(new OnClickListener(){       
            
              @Override
              public void onClick(View v) {
               LoginScreen.cc=0;
               Intent logoutIntent = new Intent(AccountSettings.this, LoginScreen.class);
            logoutIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(logoutIntent);
              }
          });
        secq.setOnClickListener(new OnClickListener(){       
           
               @Override
               public void onClick(View v) {
                   stt.setVisibility(View.VISIBLE);
                   if(LoginScreen.sq.size()==3){
                   stt.setText("You have already added 3 security questions."+
                               "Set a strong password for more privacy!");}
                   else if(LoginScreen.sq.size()<3){
                   sqs.setVisibility(View.VISIBLE);
                   sqans.setVisibility(View.VISIBLE);
                   sub.setVisibility(View.VISIBLE);
                   setSpinner();}
               }
           });
       
       chpwd.setOnClickListener(new OnClickListener(){       
           
               @Override
               public void onClick(View v) {
            	   progressDialog = ProgressDialog.show(AccountSettings.this, "", "Loading...");

                   new Thread() {

                   public void run() {

                   try{

                   sleep(3000);
                   Intent i=new Intent(AccountSettings.this, ChangePassword.class);
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
       sqans.setOnClickListener(new OnClickListener(){       
            
           @Override
           public void onClick(View v) {
               sqans.setText("");
           }
       });
       sub.setOnClickListener(new OnClickListener(){       
             
           @Override
           public void onClick(View v) {
               String s=sqs.getSelectedItem().toString();
               for(String ss:questions)
                   if(s.equals(ss))
                       s=Integer.toString(questions.indexOf(ss)+1);
               answer=sqans.getText().toString();
               FetchFunctions.addSecurityQues(s,answer);
               for(Status t:FetchFunctions.addSQstatus)
                   stt.setText(t.getStatus());
           }     
       });
    }  
         
        @SuppressWarnings({ "unchecked", "rawtypes" })
        void setSpinner(){
            ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(this,
                    android.R.layout.simple_spinner_dropdown_item,
                        ques);
            sqs.setAdapter(spinnerArrayAdapter);
       }
        @Override
        public void onBackPressed() {       
            AccountSettings.this.finish();
            Intent i=new Intent(AccountSettings.this, HomeScreen.class);
            startActivity(i);
        }

}