package com.OMBAAndroidApp;

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
import android.widget.TableLayout;
import android.widget.TextView;

import com.OMBAAndroidApp.ItemFiles.CustomerDetails;
import com.OMBAAndroidApp.ItemFiles.Status;

public class ManageAccount extends Activity {
    /** Called when the activity is first created. */
    String phoneno1,address1,email1,phoneno2,address2,email2;
   
    TableLayout table1;
    EditText et1,et2,et3;
    Button submit,home,loc,sett;
   
      TextView tv1,t1,t2,t3;
      int flag1,flag2,flag3;
  	private ProgressDialog progressDialog;
   
    @Override
    public void onCreate(Bundle savedInstanceState) {
       
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manageacc);
       
        flag1=0;
        flag2=0;
        flag3=0;
        phoneno1="";
        address1="";
        email1="";
        phoneno2="";
        address2="";
        email2="";       
       
        table1=(TableLayout)this.findViewById(R.id.table1);
        et1=(EditText)this.findViewById(R.id.et1);
        et2=(EditText)this.findViewById(R.id.et2);
        et3=(EditText)this.findViewById(R.id.et3);
        submit=(Button)this.findViewById(R.id.sub);
        tv1=(TextView)this.findViewById(R.id.tv1);
        t1=(TextView)this.findViewById(R.id.t1);
        t2=(TextView)this.findViewById(R.id.t2);
        t3=(TextView)this.findViewById(R.id.t3);
       
        loc=(Button)this.findViewById(R.id.loc);
        home=(Button)this.findViewById(R.id.home);
        sett=(Button)this.findViewById(R.id.settings);
        Button lg=(Button)this.findViewById(R.id.lg);
        TextView name=(TextView)this.findViewById(R.id.name);
       
        name.setText(LoginScreen.customerName);
       
       
        t1.setOnClickListener(new OnClickListener(){       
             
               @Override
               public void onClick(View v) {
                   flag1=1;
                   et1.setVisibility(View.VISIBLE);
               }
           });
        t2.setOnClickListener(new OnClickListener(){       
           
            @Override
            public void onClick(View v) {
                flag2=1;
                et2.setVisibility(View.VISIBLE);
            }
        });
        t3.setOnClickListener(new OnClickListener(){       
           
            @Override
            public void onClick(View v) {
                flag3=1;
                et1.setVisibility(View.VISIBLE);
            }
        });
       
        lg.setOnClickListener(new OnClickListener(){       
             
               @Override
               public void onClick(View v) {
            	   progressDialog = ProgressDialog.show(ManageAccount.this, "", "Loading...");

                   new Thread() {

                   public void run() {

                   try{

                   sleep(3000);
                   finish();
                   LoginScreen.cc=0;
                     Intent logoutIntent = new Intent(ManageAccount.this, LoginScreen.class);
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
        sett.setOnClickListener(new OnClickListener(){       
            
             @Override
             public void onClick(View v) {
            	 progressDialog = ProgressDialog.show(ManageAccount.this, "", "Loading...");

                 new Thread() {

                 public void run() {

                 try{

                 sleep(3000);
               finish();
                 Intent i=new Intent(ManageAccount.this, AccountSettings.class);
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
            	progressDialog = ProgressDialog.show(ManageAccount.this, "", "Loading...");

                new Thread() {

                public void run() {

                try{

                sleep(3000);
               finish();
                Intent i=new Intent(ManageAccount.this, HomeScreen.class);
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
       
        loc.setOnClickListener(new View.OnClickListener() { 
            public void onClick(View v){ 
              
             Uri uri = Uri.parse("http://g.co/maps/fsn74");
             Intent intent = new Intent(Intent.ACTION_VIEW, uri);
             startActivity(intent);

          
            }  });
       
        FetchFunctions.fetchCustomerDetails();
          
       for(CustomerDetails cus:FetchFunctions.cdetails){
           phoneno1=cus.getPhoneno();
           email1=cus.getEmail();
           address1=cus.getAddress();
      }
     
       submit.setOnClickListener(new OnClickListener(){       
           
               @Override
               public void onClick(View v) {
                   if(flag1==1)
                   {
                          phoneno2=et1.getText().toString().trim();                    
                   }
                   else
                   {
                       phoneno2=phoneno1;
                   }
                   if(flag2==1)
                   {
                       email2=et2.getText().toString().trim();                    
                   }
                   else
                   {
                       email2=email1;
                   }
                   if(flag3==1)
                   {
                       address2=et3.getText().toString().trim();                    
                   }
                   else
                   {
                       address2=address1;
                   }
 
                if(address2!=""&&phoneno2.matches("\\d{12}")&&
                   email2.matches("^[a-zA-Z]\\w*[\\._]*\\w*@[a-z]*.[a-z]*")){
                    address2=address2.replace(" ","%20");
                    FetchFunctions.changeDetails(phoneno2,address2,email2);   
                    table1.setVisibility(View.GONE);
                    tv1.setVisibility(View.VISIBLE);
                    for(Status st:FetchFunctions.manageAccStatus)
                       tv1.setText(st.getStatus());
                   }
                else tv1.setText("Please enter valid details");
                }       
           });
      }
    @Override
    public void onBackPressed() {   
        ManageAccount.this.finish();
        Intent i=new Intent(ManageAccount.this, HomeScreen.class);
        startActivity(i);
    }
}