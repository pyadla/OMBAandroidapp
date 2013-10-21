package com.OMBAAndroidApp;

import com.OMBAAndroidApp.ItemFiles.Status;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddBeneficiary extends Activity {
	EditText baccn,bname,bcode;
	Button home,submit,acb,tf;
	TextView status;
	String bn,bc,ba;
	private ProgressDialog progressDialog;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addbenf);
        bn="";
        bc="";
        ba="";
        
        home=(Button)this.findViewById(R.id.home);  
        submit=(Button)this.findViewById(R.id.sub);  
        acb=(Button)this.findViewById(R.id.acb);  
        tf=(Button)this.findViewById(R.id.tf);  
        
        baccn=(EditText)this.findViewById(R.id.baccn);
        bname=(EditText)this.findViewById(R.id.benname);
        bcode=(EditText)this.findViewById(R.id.bcode);
        
        status=(TextView)this.findViewById(R.id.status);
        
        TextView name=(TextView)this.findViewById(R.id.name);
        
        name.setText(LoginScreen.customerName);
        
        Button lg=(Button)this.findViewById(R.id.lg);
        
        lg.setOnClickListener(new OnClickListener(){        
    	      
        	   @Override
        	   public void onClick(View v) {
        		   progressDialog = ProgressDialog.show(AddBeneficiary.this, "", "Loading...");

                   new Thread() {

                   public void run() {

                   try{

                   sleep(3000);
            	   finish();
        		   LoginScreen.cc=0;
              		Intent logoutIntent = new Intent(AddBeneficiary.this, LoginScreen.class);
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
        
        home.setOnClickListener(new OnClickListener(){        
  	      
        	   @Override
        	   public void onClick(View v) {
        		   progressDialog = ProgressDialog.show(AddBeneficiary.this, "", "Loading...");

                   new Thread() {

                   public void run() {

                   try{

                   sleep(3000);
        		   
            	   finish();
        		   Intent i=new Intent(AddBeneficiary.this, HomeScreen.class);
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
        acb.setOnClickListener(new OnClickListener(){        
    	      
     	   @Override
     	   public void onClick(View v) {
     		  progressDialog = ProgressDialog.show(AddBeneficiary.this, "", "Loading...");

              new Thread() {

              public void run() {

              try{

              sleep(3000);
        	   finish();
     		   Intent i=new Intent(AddBeneficiary.this, AccountBalance.class);
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
        tf.setOnClickListener(new OnClickListener(){        
    	      
     	   @Override
     	   public void onClick(View v) {
     		  progressDialog = ProgressDialog.show(AddBeneficiary.this, "", "Loading...");

              new Thread() {

              public void run() {

              try{

              sleep(3000);
        	   finish();
     		   Intent i=new Intent(AddBeneficiary.this, FundsTransfer.class);
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
       /* bname.setOnClickListener(new OnClickListener(){        
  	      
      	   @Override
      	   public void onClick(View v) {
      		   if(bcode.getText().toString().equals(""))
      			   bcode.setText("Bank code");
      		   if(baccn.getText().toString().equals(""))
    			   baccn.setText("Account Number");
      		   bname.setText("");
      	   }
         });
        bcode.setOnClickListener(new OnClickListener(){        
  	      
      	   @Override
      	   public void onClick(View v) {
      		   if(bname.getText().toString().equals(""))
    			   bname.setText("Beneficiary Name");
    		   if(baccn.getText().toString().equals(""))
  			       baccn.setText("Account Number");
      		   bcode.setText("");
      	   }
         });
        baccn.setOnClickListener(new OnClickListener(){        
  	      
      	   @Override
      	   public void onClick(View v) {
      		 if(bname.getText().toString().equals(""))
  			   bname.setText("Beneficiary Name");
  		     if(bcode.getText().toString().equals(""))
			   bcode.setText("Bank code");
      		   baccn.setText("");
      	   }
         });*/
        submit.setOnClickListener(new OnClickListener(){        
    	      
     	   @Override
     	   public void onClick(View v) {
     		  bn=bname.getText().toString().trim();
     	      bc=bcode.getText().toString().trim();
     	      ba=baccn.getText().toString().trim();
     	      if(bn.matches("^[a-zA-Z][a-zA-Z ]*")&&bc.matches("\\d{8}")&&ba.matches("\\d{12}")){
     	    	  bn=bn.replace(" ","%20");
     	    	  bc=bc.replace(" ","%20");
     	    	  ba=ba.replace(" ","%20");
     	    	 FetchFunctions.addBen(ba,bn,bc);
     	    	for(Status t:FetchFunctions.addBenStatus)
     	    		status.setText(t.getStatus());  }
     	      else {
     	    	     if(bname.getText().toString().equals(""))
     	  			   bname.setText("Beneficiary Name");
     	  		     if(bcode.getText().toString().equals(""))
     				   bcode.setText("Bank code");
     	  		     if(baccn.getText().toString().equals(""))
     			       baccn.setText("Account Number");
     	    	  status.setText("Please enter valid details");
     	      }
     	   }           
       });
    }
    @Override
	public void onBackPressed() {    
    	AddBeneficiary.this.finish();
    	Intent i=new Intent(AddBeneficiary.this, HomeScreen.class);
        startActivity(i);
	}

}