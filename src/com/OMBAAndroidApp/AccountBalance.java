package com.OMBAAndroidApp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.OMBAAndroidApp.ItemFiles.Account;

public class AccountBalance extends Activity {

    private ProgressDialog progressDialog;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_summary);
       
         FetchFunctions.fetchAccBalance();
        
      Button home=(Button)this.findViewById(R.id.home); 
      Button mini=(Button)this.findViewById(R.id.mini);
      Button trans=(Button)this.findViewById(R.id.tf);
      Button lg=(Button)this.findViewById(R.id.lg);
      TextView ac1=(TextView)this.findViewById(R.id.ac1);
      TextView bal1=(TextView)this.findViewById(R.id.bal1);
      TextView ac2=(TextView)this.findViewById(R.id.ac2);
      TextView bal2=(TextView)this.findViewById(R.id.bal2);
      TextView ac3=(TextView)this.findViewById(R.id.ac3);
      TextView bal3=(TextView)this.findViewById(R.id.bal3);
      TextView name=(TextView)this.findViewById(R.id.name);
      
      name.setText(LoginScreen.customerName);
     
      int i=1;
      for(Account a:FetchFunctions.accounts){
          if(i==1){
          ac1.setText(a.getAccountNo());
          ac1.setVisibility(View.VISIBLE);
          bal1.setText(a.getBalance());
          bal1.setVisibility(View.VISIBLE);i++;}
          else if(i==2){
              ac2.setText(a.getAccountNo());
              ac2.setVisibility(View.VISIBLE);
              bal2.setText(a.getBalance());
              bal2.setVisibility(View.VISIBLE);i++;}
          else if(i==3){
              ac3.setText(a.getAccountNo());
              ac3.setVisibility(View.VISIBLE);
              bal3.setText(a.getBalance());
              bal3.setVisibility(View.VISIBLE);}
      }
      home.setOnClickListener(new OnClickListener(){  
               @Override
               public void onClick(View v) {
            	   progressDialog = ProgressDialog.show(AccountBalance.this, "", "Loading...");

                   new Thread() {

                   public void run() {

                   try{

                   sleep(3000);
            	   finish();
                   Intent i=new Intent(AccountBalance.this, HomeScreen.class);
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
        	  progressDialog = ProgressDialog.show(AccountBalance.this, "", "Loading...");

              new Thread() {

              public void run() {

              try{

              sleep(3000);
        	  LoginScreen.cc=0;
       	   finish();
        		Intent logoutIntent = new Intent(AccountBalance.this, LoginScreen.class);
             logoutIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
             startActivity(logoutIntent);
          }catch (Exception e) {

              Log.e("tag", e.getMessage());

              }

              // dismiss the progress dialog

              progressDialog.dismiss();

              }

              }.start();
              }    
      });
 
      mini.setOnClickListener(new OnClickListener(){       
           
          @Override
          public void onClick(View v) {
        	  progressDialog = ProgressDialog.show(AccountBalance.this, "", "Loading...");

              new Thread() {

              public void run() {

              try{

              sleep(3000);
        	  LoginScreen.cc=0;
       	   finish();
              Intent i=new Intent(AccountBalance.this, MiniStatement.class);
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
     
      trans.setOnClickListener(new OnClickListener(){       
           
          @Override
          public void onClick(View v) {
        	  progressDialog = ProgressDialog.show(AccountBalance.this, "", "Loading...");

              new Thread() {

              public void run() {

              try{

              sleep(3000);
        	  LoginScreen.cc=0;
       	   finish();
              Intent i=new Intent(AccountBalance.this, FundsTransfer.class);
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
    }
    @Override
	public void onBackPressed() { 
    	AccountBalance.this.finish();
    	Intent i=new Intent(AccountBalance.this, HomeScreen.class);
        startActivity(i);
	}
}