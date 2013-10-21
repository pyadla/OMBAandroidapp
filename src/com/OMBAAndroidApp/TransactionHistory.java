package com.OMBAAndroidApp;

import java.util.Calendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.OMBAAndroidApp.ItemFiles.Account;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class TransactionHistory extends Activity {
  
    public static String accSelected;
  
    private ProgressDialog progressDialog;
    
    RadioGroup accnos;
    RadioButton rb1,rb2,rb3;
    Button sub,tf,mini;
    TextView err;
    TableLayout tl;
    private int mYear1;
    private int mMonth1;
    private int mDay1;

    private Button mPickDate1;
    private Button mPickDate2;

    static final int DATE_DIALOG_ID = 0;
    String sd="",ed="";
    String sDate="",eDate="";
    int flag;
  
    Date tdate,lmdate,start,end;
    DateFormat formatter;
 
  
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
     
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transhist);
        TextView name=(TextView)this.findViewById(R.id.name);
        tl=(TableLayout)this.findViewById(R.id.seldate);
        name.setText(LoginScreen.customerName);
        Calendar cal= Calendar.getInstance();
        cal.add(Calendar.DATE, -30);
        lmdate=cal.getTime();
        tdate= Calendar.getInstance().getTime();
        formatter = new SimpleDateFormat("dd-MM-yyyy");
        sDate=formatter.format(lmdate).toString();
        eDate=formatter.format(tdate).toString();              
        mini=(Button)this.findViewById(R.id.mini);
        tf=(Button)this.findViewById(R.id.tf);
        Button lg=(Button)this.findViewById(R.id.lg);
        Button home=(Button)this.findViewById(R.id.home);
      
        home.setOnClickListener(new OnClickListener(){      
            
            @Override
            public void onClick(View v) {
            	progressDialog = ProgressDialog.show(TransactionHistory.this, "", "Loading...");

                new Thread() {

                public void run() {

                try{

                sleep(3000);
                finish();
                Intent i=new Intent(TransactionHistory.this, HomeScreen.class);
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
            	   progressDialog = ProgressDialog.show(TransactionHistory.this, "", "Loading...");

                   new Thread() {

                   public void run() {

                   try{

                   sleep(3000);
                   finish();
                   LoginScreen.cc=0;
                     Intent logoutIntent = new Intent(TransactionHistory.this, LoginScreen.class);
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
            	 progressDialog = ProgressDialog.show(TransactionHistory.this, "", "Loading...");

                 new Thread() {

                 public void run() {

                 try{

                 sleep(3000);
                finish();
                Intent i=new Intent(TransactionHistory.this, AccountBalance.class);
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
            	progressDialog = ProgressDialog.show(TransactionHistory.this, "", "Loading...");

                new Thread() {

                public void run() {

                try{

                sleep(3000);
                finish();
                Intent i=new Intent(TransactionHistory.this, FundsTransfer.class);
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
      
       flag=0;
       accSelected="";
     
       accnos=(RadioGroup)this.findViewById(R.id.accnos);
     
       rb1=(RadioButton)this.findViewById(R.id.rb1);
       rb2=(RadioButton)this.findViewById(R.id.rb2);
       rb3=(RadioButton)this.findViewById(R.id.rb3);
     
       err=(TextView)this.findViewById(R.id.error);
     
       sub=(Button)this.findViewById(R.id.sub);
     //  mDateDisplay1 = (TextView) findViewById(R.id.showMyDate1);
      // mDateDisplay2 = (TextView) findViewById(R.id.showMyDate2);
     
     
       mPickDate1 = (Button) findViewById(R.id.myDatePickerButton1);
       mPickDate2 = (Button) findViewById(R.id.myDatePickerButton2);
      
       fetchthis();

       mPickDate1.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                  flag=1;
               showDialog(DATE_DIALOG_ID);
           }
       });
     
       mPickDate2.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
                  flag=2;
               showDialog(DATE_DIALOG_ID);
           }
       });
     
    
       // get the current date
       final Calendar c = Calendar.getInstance();
       mYear1 = c.get(Calendar.YEAR);
       mMonth1 = c.get(Calendar.MONTH);
       mDay1 = c.get(Calendar.DAY_OF_MONTH);

       // display the current date
       updateDisplay();

       sub.setOnClickListener(new OnClickListener(){      
          
               @Override
               public void onClick(View v) {
                                             
                         if(mPickDate1.getText().toString().equals("Choose From Date"))
                             mPickDate1.setText(sDate);
                         if(mPickDate2.getText().toString().equals("Choose To Date"))
                             mPickDate2.setText(eDate);
                         
                         try {
                            err.setVisibility(View.GONE);
                                if(flag==0)
                             {
                                 err.setVisibility(View.VISIBLE);
                                 err.setText("No dates chosen.Last 30days transactions will be displayed.");
                                 sd=formatter.format(lmdate);
                                 ed=formatter.format(tdate);
                                 System.out.println(sd+""+ed);
                             }
                             else
                             {
                                    sd=mPickDate1.getText().toString();
                                    ed=mPickDate2.getText().toString();
                             }
                           
                             start= formatter.parse(sd);
                             end= formatter.parse(ed);
                           
                              sDate=sd.substring(6,10)+"-"+sd.substring(3,5)+"-"+sd.substring(0,2);
                              eDate=ed.substring(6,10)+"-"+ed.substring(3,5)+"-"+ed.substring(0,2);
                           
                             if((start.after(end))||(end.after(tdate)))
                            		 
                             { 
                                 err.setVisibility(View.VISIBLE);
                                 err.setText("Please choose valid dates");
                             }
                            
                             FetchFunctions.fetchTransactions(sDate,eDate,accSelected);
                             if(FetchFunctions.trns.size()>0){
                                    finish();
                                  Intent i=new Intent(TransactionHistory.this, TranshistDisplay.class);
                                  startActivity(i);}
                                else {
                                	 StatusDisp.st="There are no transactions in the given period";
                                     StatusDisp.screen=4;
                                     Intent i=new Intent(TransactionHistory.this, StatusDisp.class);
                                     startActivity(i);
                                     flag=0;                  
                                }
                    }
                    catch (ParseException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
               }
           });
     
       accnos.setOnCheckedChangeListener(new OnCheckedChangeListener(){
           public void onCheckedChanged(RadioGroup group, final int checkedId) {
                   if(checkedId == R.id.rb1){
                      accSelected=rb1.getText().toString();
                      }
                  else if(checkedId == R.id.rb2){
                      accSelected=rb2.getText().toString();
                      }
                  else if(checkedId == R.id.rb3){
                      accSelected=rb3.getText().toString();
                      }
                  tl.setVisibility(View.VISIBLE);
                  }             
              });
    }
  
    private void updateDisplay() {
        String mm=Integer.toString(mMonth1+1);
        if(mm.length()==1)
            mm="0"+mm;
        String dd=Integer.toString(mDay1);
        if(dd.length()==1)
            dd="0"+dd;
        if(flag==1){
        this.mPickDate1.setText(
            new StringBuilder()
                    // Month is 0 based so add 1
                    .append(dd).append("-")
                    .append(mm).append("-")
                    .append(mYear1));}
        else if(flag==2){
            this.mPickDate2.setText(
                    new StringBuilder()
                             // Month is 0 based so add 1
                            .append(dd).append("-")
                            .append(mm).append("-")
                            .append(mYear1));}
    }
  
    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {
                    mYear1 = year;
                    mMonth1 = monthOfYear;
                    mDay1 = dayOfMonth;
                    updateDisplay();
                }
            };
          
            @Override
            protected Dialog onCreateDialog(int id) {
               switch (id) {
               case DATE_DIALOG_ID:
                  return new DatePickerDialog(this,
                            mDateSetListener,
                            mYear1, mMonth1, mDay1);
               }
               return null;
            }
          
    public void fetchthis()
            {
                 FetchFunctions.fetchAccBalance();
                 int i=1;
                 for(Account a:FetchFunctions.accounts){
                  
                     if(i==1){
                       rb1.setText(a.getAccountNo());
                       rb1.setVisibility(View.VISIBLE);i++;
                     }
                     else if(i==2){
                       rb2.setText(a.getAccountNo());
                       rb2.setVisibility(View.VISIBLE);i++;
                     }
                     else if(i==3){
                       rb3.setText(a.getAccountNo());
                       rb3.setVisibility(View.VISIBLE);
                     }
                 }        
            }

    @Override
    public void onBackPressed() {   
        TransactionHistory.this.finish();
        Intent i=new Intent(TransactionHistory.this, HomeScreen.class);
        startActivity(i);
    }
}