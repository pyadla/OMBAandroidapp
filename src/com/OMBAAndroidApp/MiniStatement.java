package com.OMBAAndroidApp;

import com.OMBAAndroidApp.ItemFiles.Account;
import com.OMBAAndroidApp.ItemFiles.MiniTransaction;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TableRow;
import android.widget.TextView;

public class MiniStatement extends Activity {
	
	Button home,trh,tf;
	RadioGroup accnos;
	RadioButton rb1,rb2,rb3;
	TableRow minihr,minir1,minir2,minir3,minir4,minir5;
	TextView acctext,accbal;
	TextView dt1,dt2,dt3,dt4,dt5;
	TextView am1,am2,am3,am4,am5;
	TextView cd1,cd2,cd3,cd4,cd5;
	String bal1="",bal2="",bal3="";
	String accountNo="";
	private ProgressDialog progressDialog;
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ministmnt);
        
        FetchFunctions.fetchAccBalance();
        
        home=(Button)this.findViewById(R.id.home);  
        trh=(Button)this.findViewById(R.id.trh);
        tf=(Button)this.findViewById(R.id.tf);
        Button lg=(Button)this.findViewById(R.id.lg);
        TextView name=(TextView)this.findViewById(R.id.name);
        
        name.setText(LoginScreen.customerName);
        
        lg.setOnClickListener(new OnClickListener(){        
    	      
        	   @Override
        	   public void onClick(View v) {
            	   finish();
        		   LoginScreen.cc=0;
              	   Intent logoutIntent = new Intent(MiniStatement.this, LoginScreen.class);
                   logoutIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                   startActivity(logoutIntent);
        	   }
           });
        accnos=(RadioGroup)this.findViewById(R.id.accnos);
        
        rb1=(RadioButton)this.findViewById(R.id.rb1);
        rb2=(RadioButton)this.findViewById(R.id.rb2);
        rb3=(RadioButton)this.findViewById(R.id.rb3);
        
        acctext=(TextView)this.findViewById(R.id.acctext);
        accbal=(TextView)this.findViewById(R.id.accbal);
        
        minihr=(TableRow)this.findViewById(R.id.minihr);
        minir1=(TableRow)this.findViewById(R.id.minir1);
        minir2=(TableRow)this.findViewById(R.id.minir2);
        minir3=(TableRow)this.findViewById(R.id.minir3);
        minir4=(TableRow)this.findViewById(R.id.minir4);
        minir5=(TableRow)this.findViewById(R.id.minir5);
        
        dt1=(TextView)this.findViewById(R.id.dt1);
        dt2=(TextView)this.findViewById(R.id.dt2);
        dt3=(TextView)this.findViewById(R.id.dt3);
        dt4=(TextView)this.findViewById(R.id.dt4);
        dt5=(TextView)this.findViewById(R.id.dt5);
        
        am1=(TextView)this.findViewById(R.id.am1);
        am2=(TextView)this.findViewById(R.id.am2);
        am3=(TextView)this.findViewById(R.id.am3);
        am4=(TextView)this.findViewById(R.id.am4);
        am5=(TextView)this.findViewById(R.id.am5);
        
        cd1=(TextView)this.findViewById(R.id.cd1);
        cd2=(TextView)this.findViewById(R.id.cd2);
        cd3=(TextView)this.findViewById(R.id.cd3);
        cd4=(TextView)this.findViewById(R.id.cd4);
        cd5=(TextView)this.findViewById(R.id.cd5);
        
        int i=1;
        for(Account a:FetchFunctions.accounts){
          
      	  if(i==1){
      		rb1.setText(a.getAccountNo());
      	    rb1.setVisibility(View.VISIBLE);
      	    bal1=(a.getBalance());i++;
      	  }
      	  else if(i==2){
        		rb2.setText(a.getAccountNo());
          	    rb2.setVisibility(View.VISIBLE);
          	    bal2=(a.getBalance());i++;
          	  }
      	  else if(i==3){
        		rb3.setText(a.getAccountNo());
          	    rb3.setVisibility(View.VISIBLE);
          	    bal3=(a.getBalance());
          	  }
        }
       
       home.setOnClickListener(new OnClickListener(){        
  	      
        	   @Override
        	   public void onClick(View v) {
        		   progressDialog = ProgressDialog.show(MiniStatement.this, "", "Loading...");

                   new Thread() {

                   public void run() {

                   try{

                   sleep(3000);
            	   finish();
        		   Intent i=new Intent(MiniStatement.this, HomeScreen.class);
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
       trh.setOnClickListener(new OnClickListener(){        
   	      
    	   @Override
    	   public void onClick(View v) {
    		   progressDialog = ProgressDialog.show(MiniStatement.this, "", "Loading...");

               new Thread() {

               public void run() {

               try{

               sleep(3000);
        	   finish();
    		   Intent i=new Intent(MiniStatement.this, TransactionHistory.class);
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
    		   progressDialog = ProgressDialog.show(MiniStatement.this, "", "Loading...");

               new Thread() {

               public void run() {

               try{

               sleep(3000);
        	   finish();
    		   Intent i=new Intent(MiniStatement.this, FundsTransfer.class);
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
       
        accnos.setOnCheckedChangeListener(new OnCheckedChangeListener(){
        	 public void onCheckedChanged(RadioGroup group, int checkedId) {
        		 minihr.setVisibility(View.VISIBLE);
        		 acctext.setVisibility(View.VISIBLE);
                 accbal.setVisibility(View.VISIBLE);
        	        if(checkedId == R.id.rb1){
        	        	accbal.setText(bal1);
        	        	accountNo=rb1.getText().toString();
        	        	FetchFunctions.fetchMiniTransactions(accountNo);
        	            int i=1;
        	            for(MiniTransaction m:FetchFunctions.trs){
        	            	if(i==1){
        	            		minir1.setVisibility(View.VISIBLE);
        	            		dt1.setText(m.getDate());
        	            		am1.setText(m.getAmount());
        	            		cd1.setText(m.getDescription());i++;
        	            	}
        	            	else if(i==2){
        	            		minir2.setVisibility(View.VISIBLE);
        	            		dt2.setText(m.getDate());
        	            		am2.setText(m.getAmount());
        	            		cd2.setText(m.getDescription());i++;
        	            	}
        	            	else if(i==3){
        	            		minir3.setVisibility(View.VISIBLE);
        	            		dt3.setText(m.getDate());
        	            		am3.setText(m.getAmount());
        	            		cd3.setText(m.getDescription());i++;
        	            	}
        	            	else if(i==4){
        	            		minir4.setVisibility(View.VISIBLE);
        	            		dt4.setText(m.getDate());
        	            		am4.setText(m.getAmount());
        	            		cd4.setText(m.getDescription());i++;
        	            	}
        	            	else if(i==5){
        	            		minir5.setVisibility(View.VISIBLE);
        	            		dt5.setText(m.getDate());
        	            		am5.setText(m.getAmount());
        	            		cd5.setText(m.getDescription());
        	            	}
        	            }
        	        }
        	        else if(checkedId == R.id.rb2){
        	        	accbal.setText(bal2);
        	        	accountNo=rb2.getText().toString();
        	        	FetchFunctions.fetchMiniTransactions(accountNo);
        	            int i=1;
        	            for(MiniTransaction m:FetchFunctions.trs){
        	            	if(i==1){
        	            		minir1.setVisibility(View.VISIBLE);
        	            		dt1.setText(m.getDate());
        	            		am1.setText(m.getAmount());
        	            		cd1.setText(m.getDescription());i++;
        	            	}
        	            	else if(i==2){
        	            		minir2.setVisibility(View.VISIBLE);
        	            		dt2.setText(m.getDate());
        	            		am2.setText(m.getAmount());
        	            		cd2.setText(m.getDescription());i++;
        	            	}
        	            	else if(i==3){
        	            		minir3.setVisibility(View.VISIBLE);
        	            		dt3.setText(m.getDate());
        	            		am3.setText(m.getAmount());
        	            		cd3.setText(m.getDescription());i++;
        	            	}
        	            	else if(i==4){
        	            		minir4.setVisibility(View.VISIBLE);
        	            		dt4.setText(m.getDate());
        	            		am4.setText(m.getAmount());
        	            		cd4.setText(m.getDescription());i++;
        	            	}
        	            	else if(i==5){
        	            		minir5.setVisibility(View.VISIBLE);
        	            		dt5.setText(m.getDate());
        	            		am5.setText(m.getAmount());
        	            		cd5.setText(m.getDescription());
        	            	}
        	            }
        	        }
        	        else if(checkedId == R.id.rb3){
        	        	accbal.setText(bal3);
        	        	accountNo=rb3.getText().toString();
        	        	FetchFunctions.fetchMiniTransactions(accountNo);
        	            int i=1;
        	            for(MiniTransaction m:FetchFunctions.trs){
        	            	if(i==1){
        	            		minir1.setVisibility(View.VISIBLE);
        	            		dt1.setText(m.getDate());
        	            		am1.setText(m.getAmount());
        	            		cd1.setText(m.getDescription());i++;
        	            	}
        	            	else if(i==2){
        	            		minir2.setVisibility(View.VISIBLE);
        	            		dt2.setText(m.getDate());
        	            		am2.setText(m.getAmount());
        	            		cd2.setText(m.getDescription());i++;
        	            	}
        	            	else if(i==3){
        	            		minir3.setVisibility(View.VISIBLE);
        	            		dt3.setText(m.getDate());
        	            		am3.setText(m.getAmount());
        	            		cd3.setText(m.getDescription());i++;
        	            	}
        	            	else if(i==4){
        	            		minir4.setVisibility(View.VISIBLE);
        	            		dt4.setText(m.getDate());
        	            		am4.setText(m.getAmount());
        	            		cd4.setText(m.getDescription());i++;
        	            	}
        	            	else if(i==5){
        	            		minir5.setVisibility(View.VISIBLE);
        	            		dt5.setText(m.getDate());
        	            		am5.setText(m.getAmount());
        	            		cd5.setText(m.getDescription());
        	            	}
        	            }
        	        }
                 }         
                });
    } 
    @Override
	public void onBackPressed() {    
    	MiniStatement.this.finish();
    	Intent i=new Intent(MiniStatement.this, HomeScreen.class);
        startActivity(i);
	}

}