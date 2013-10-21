package com.OMBAAndroidApp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;

public class TranshistDisplay extends Activity {
	
	private ProgressDialog progressDialog;
	
	TextView acno;
	TableRow thr1,thr2,thr3,thr4,thr5,tlm;
	TextView stat,thr1c1,thr1c2,thr1c3,thr1c4,thr1c5,thr1c6;
	TextView thr2c1,thr2c2,thr2c3,thr2c4,thr2c5,thr2c6;
	TextView thr3c1,thr3c2,thr3c3,thr3c4,thr3c5,thr3c6;
	TextView thr4c1,thr4c2,thr4c3,thr4c4,thr4c5,thr4c6;
	TextView thr5c1,thr5c2,thr5c3,thr5c4,thr5c5,thr5c6;
	Button prev,next,home,back,acbal,tf;
	int count=0,i=0;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trhdisplay);
        
       count=0;
       acno=(TextView)this.findViewById(R.id.acno);
       TextView name=(TextView)this.findViewById(R.id.name);
       
       name.setText(LoginScreen.customerName);
       tlm=(TableRow)this.findViewById(R.id.tlm);
       thr1=(TableRow)this.findViewById(R.id.thr1);
       thr2=(TableRow)this.findViewById(R.id.thr2);
       thr3=(TableRow)this.findViewById(R.id.thr3);
       thr4=(TableRow)this.findViewById(R.id.thr4);
       thr5=(TableRow)this.findViewById(R.id.thr5);
       
       stat=(TextView)this.findViewById(R.id.stat);
       thr1c1=(TextView)this.findViewById(R.id.thr1c1);
       thr1c2=(TextView)this.findViewById(R.id.thr1c2);
       thr1c3=(TextView)this.findViewById(R.id.thr1c3);
       thr1c4=(TextView)this.findViewById(R.id.thr1c4);
       thr1c5=(TextView)this.findViewById(R.id.thr1c5);
       thr1c6=(TextView)this.findViewById(R.id.thr1c6);
       
       thr2c1=(TextView)this.findViewById(R.id.thr2c1);
       thr2c2=(TextView)this.findViewById(R.id.thr2c2);
       thr2c3=(TextView)this.findViewById(R.id.thr2c3);
       thr2c4=(TextView)this.findViewById(R.id.thr2c4);
       thr2c5=(TextView)this.findViewById(R.id.thr2c5);
       thr2c6=(TextView)this.findViewById(R.id.thr2c6);
       
       thr3c1=(TextView)this.findViewById(R.id.thr3c1);
       thr3c2=(TextView)this.findViewById(R.id.thr3c2);
       thr3c3=(TextView)this.findViewById(R.id.thr3c3);
       thr3c4=(TextView)this.findViewById(R.id.thr3c4);
       thr3c5=(TextView)this.findViewById(R.id.thr3c5);
       thr3c6=(TextView)this.findViewById(R.id.thr3c6);
       
       thr4c1=(TextView)this.findViewById(R.id.thr4c1);
       thr4c2=(TextView)this.findViewById(R.id.thr4c2);
       thr4c3=(TextView)this.findViewById(R.id.thr4c3);
       thr4c4=(TextView)this.findViewById(R.id.thr4c4);
       thr4c5=(TextView)this.findViewById(R.id.thr4c5);
       thr4c6=(TextView)this.findViewById(R.id.thr4c6);
       
       thr5c1=(TextView)this.findViewById(R.id.thr5c1);
       thr5c2=(TextView)this.findViewById(R.id.thr5c2);
       thr5c3=(TextView)this.findViewById(R.id.thr5c3);
       thr5c4=(TextView)this.findViewById(R.id.thr5c4);
       thr5c5=(TextView)this.findViewById(R.id.thr5c5);
       thr5c6=(TextView)this.findViewById(R.id.thr5c6);
       
       prev=(Button)this.findViewById(R.id.prev);
       next=(Button)this.findViewById(R.id.next);
       home=(Button)this.findViewById(R.id.home);
       back=(Button)this.findViewById(R.id.back);
       acbal=(Button)this.findViewById(R.id.acbal);
       tf=(Button)this.findViewById(R.id.tf);
       
        
       acno.setText(TransactionHistory.accSelected);
       setRows();
       
       home.setOnClickListener(new OnClickListener(){        
  	      
        	   @Override
        	   public void onClick(View v) {
        		   progressDialog = ProgressDialog.show(TranshistDisplay.this, "", "Loading...");

                   new Thread() {

                   public void run() {

                   try{

                   sleep(3000);
        		   finish();
        		   Intent i=new Intent(TranshistDisplay.this, HomeScreen.class);
     		         startActivity(i);
        	   } catch (Exception e) {

                   Log.e("tag", e.getMessage());

                   }

                   // dismiss the progress dialog

                   progressDialog.dismiss();

                   }

                   }.start();
                   }
           }); 
       back.setOnClickListener(new OnClickListener(){        
   	      
    	   @Override
    	   public void onClick(View v) {
    		   progressDialog = ProgressDialog.show(TranshistDisplay.this, "", "Loading...");

               new Thread() {

               public void run() {

               try{

               sleep(3000);
    		   finish();
    		   Intent i=new Intent(TranshistDisplay.this, TransactionHistory.class);
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
       acbal.setOnClickListener(new OnClickListener(){        
   	      
    	   @Override
    	   public void onClick(View v) {
    		   progressDialog = ProgressDialog.show(TranshistDisplay.this, "", "Loading...");

               new Thread() {

               public void run() {

               try{

               sleep(3000);
    		   finish();
    		   Intent i=new Intent(TranshistDisplay.this, AccountBalance.class);
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
    		   progressDialog = ProgressDialog.show(TranshistDisplay.this, "", "Loading...");

               new Thread() {

               public void run() {

               try{

               sleep(3000);
    		   finish();
    		   Intent i=new Intent(TranshistDisplay.this, FundsTransfer.class);
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
       prev.setOnClickListener(new OnClickListener(){        
   	      
    	   @Override
    	   public void onClick(View v) {
    		   toggleVisibility();
			   next.setVisibility(View.VISIBLE);
    		   if(count>=10) count-=(i+5);
    		   else count=0;
    		   setRows();
    	   }
       });
       
       next.setOnClickListener(new OnClickListener(){        
    	      
    	   @Override
    	   public void onClick(View v) {
    		   toggleVisibility();
    		   if(FetchFunctions.trns.size()<=count){
    			   tlm.setVisibility(View.GONE);
    			   next.setVisibility(View.GONE);
    		       stat.setVisibility(View.VISIBLE);
    		       stat.setText("No more transactions to display");
    		   }
    		   else setRows();
    	   }
       });
    }
    
    void toggleVisibility(){
    	tlm.setVisibility(View.VISIBLE);
	    stat.setVisibility(View.GONE);
    	thr1.setVisibility(View.GONE);
    	thr2.setVisibility(View.GONE);
    	thr3.setVisibility(View.GONE);
    	thr4.setVisibility(View.GONE);
    	thr5.setVisibility(View.GONE);
    }
    
    void setRows(){
    	String tf="";
        for(i=1;i<6&&FetchFunctions.trns.size()>count;i++){
        	if(i==1){
        		thr1.setVisibility(View.VISIBLE);
        		thr1c1.setText(FetchFunctions.trns.get(count).getDate());
        		tf=FetchFunctions.trns.get(count).getToFrom();
        		if(tf.substring(0,2).equals("to")){
        		thr1c2.setText("xxxx xxxx "+tf.substring(11,15));
        		thr1c3.setText("xxxx xxxx "+TransactionHistory.accSelected.substring(8,12));
        		}
        		else{
        			thr1c3.setText("xxxx xxxx "+tf.substring(13,17));
            		thr1c2.setText("xxxx xxxx "+TransactionHistory.accSelected.substring(8,12));
        		}
        		thr1c4.setText(FetchFunctions.trns.get(count).getAmount());
        		thr1c5.setText(FetchFunctions.trns.get(count).getDescription());
        		thr1c6.setText(FetchFunctions.trns.get(count).getBalance());count++;
        	}
        	else if(i==2){
        		thr2.setVisibility(View.VISIBLE);
        		thr2c1.setText(FetchFunctions.trns.get(count).getDate());
        		tf=FetchFunctions.trns.get(count).getToFrom();
        		if(tf.substring(0,2).equals("to")){
        		thr2c2.setText("xxxx xxxx "+tf.substring(11,15));
        		thr2c3.setText("xxxx xxxx "+TransactionHistory.accSelected.substring(8,12));
        		}
        		else{
        			thr2c3.setText("xxxx xxxx "+tf.substring(13,17));
            		thr2c2.setText("xxxx xxxx "+TransactionHistory.accSelected.substring(8,12));
        		}
        		thr2c4.setText(FetchFunctions.trns.get(count).getAmount());
        		thr2c5.setText(FetchFunctions.trns.get(count).getDescription());
        		thr2c6.setText(FetchFunctions.trns.get(count).getBalance());count++;
        	}
        	else if(i==3){
        		thr3.setVisibility(View.VISIBLE);
        		thr3c1.setText(FetchFunctions.trns.get(count).getDate());
        		tf=FetchFunctions.trns.get(count).getToFrom();
        		if(tf.substring(0,2).equals("to")){
        		thr3c2.setText("xxxx xxxx "+tf.substring(11,15));
        		thr3c3.setText("xxxx xxxx "+TransactionHistory.accSelected.substring(8,12));
        		}
        		else{
        			thr3c3.setText("xxxx xxxx "+tf.substring(13,17));
            		thr3c2.setText("xxxx xxxx "+TransactionHistory.accSelected.substring(8,12));
        		}
        		thr3c4.setText(FetchFunctions.trns.get(count).getAmount());
        		thr3c5.setText(FetchFunctions.trns.get(count).getDescription());
        		thr3c6.setText(FetchFunctions.trns.get(count).getBalance());count++;
        	}
        	else if(i==4){
        		thr4.setVisibility(View.VISIBLE);
        		thr4c1.setText(FetchFunctions.trns.get(count).getDate());
        		tf=FetchFunctions.trns.get(count).getToFrom();
        		if(tf.substring(0,2).equals("to")){
        		thr4c2.setText("xxxx xxxx "+tf.substring(11,15));
        		thr4c3.setText("xxxx xxxx "+TransactionHistory.accSelected.substring(8,12));
        		}
        		else{
        			thr4c3.setText("xxxx xxxx "+tf.substring(13,17));
            		thr4c2.setText("xxxx xxxx "+TransactionHistory.accSelected.substring(8,12));
        		}
        		thr4c4.setText(FetchFunctions.trns.get(count).getAmount());
        		thr4c5.setText(FetchFunctions.trns.get(count).getDescription());
        		thr4c6.setText(FetchFunctions.trns.get(count).getBalance());count++;
        	}
        	else if(i==5){
        		thr5.setVisibility(View.VISIBLE);
        		thr5c1.setText(FetchFunctions.trns.get(count).getDate());
        		tf=FetchFunctions.trns.get(count).getToFrom();
        		if(tf.substring(0,2).equals("to")){
        		thr5c2.setText("xxxx xxxx "+tf.substring(11,15));
        		thr5c3.setText("xxxx xxxx "+TransactionHistory.accSelected.substring(8,12));
        		}
        		else{
        			thr5c3.setText("xxxx xxxx "+tf.substring(13,17));
            		thr5c2.setText("xxxx xxxx "+TransactionHistory.accSelected.substring(8,12));
        		}
        		thr5c4.setText(FetchFunctions.trns.get(count).getAmount());
        		thr5c5.setText(FetchFunctions.trns.get(count).getDescription());
        		thr5c6.setText(FetchFunctions.trns.get(count).getBalance());count++;
        	}
        }
    }
    @Override
    public void onBackPressed() {
    	TranshistDisplay.this.finish();
    	Intent i=new Intent(TranshistDisplay.this,TransactionHistory.class);
        startActivity(i);
    }

}