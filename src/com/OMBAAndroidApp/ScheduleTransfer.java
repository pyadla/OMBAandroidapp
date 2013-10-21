package com.OMBAAndroidApp;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
 
import com.OMBAAndroidApp.ItemFiles.Account;
import com.OMBAAndroidApp.ItemFiles.Beneficiary;
import com.OMBAAndroidApp.ItemFiles.Status;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.app.ListActivity;

public class ScheduleTransfer extends ListActivity {
	
	private ProgressDialog progressDialog;
	 
    private int mYear1;
    private int mMonth1;
    private int mDay1;

    private TextView mDateDisplay1;

    private Button mPickDate1;
    static final int DATE_DIALOG_ID = 0;
    ArrayList<String> accs,benaccs;
    Button from,to;
    EditText amt;
    Button home,send,acb,addb,tg;
    TextView trstatus;
    String amount,trdate;
    LinearLayout l1;
    //TextView t1,t2;
    ListView lv;
    int flag,flag1,flag2;
    Date tdate,trd;
    DateFormat formatter;

    String fromaccs[],toaccs[];
  
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule);
        TextView name=(TextView)this.findViewById(R.id.name);
        name.setText(LoginScreen.customerName);
      
        amount="";
        flag=0;
        Calendar cal= Calendar.getInstance();
        cal.add(Calendar.DATE, +0);
        tdate= cal.getTime();
        formatter = new SimpleDateFormat("dd-MM-yyyy");
        FetchFunctions.fetchAccBalance();
        FetchFunctions.fetchBeneficiaries();      
        accs=new ArrayList<String>();
        benaccs=new ArrayList<String>();      
        for(Account a:FetchFunctions.accounts)
            accs.add(a.getAccountNo());      
        for(Beneficiary b:FetchFunctions.bens)
            benaccs.add(b.getAccountNo());   
        fromaccs = accs.toArray(new String[accs.size()]);
        toaccs=benaccs.toArray(new String[benaccs.size()]);
      
        from=(Button)this.findViewById(R.id.button1);
        to=(Button)this.findViewById(R.id.button2);
           
        trstatus=(TextView)this.findViewById(R.id.trstatus);
        amt=(EditText)this.findViewById(R.id.amt);
        home=(Button)this.findViewById(R.id.home);
        send=(Button)this.findViewById(R.id.sub);
        tg=(Button)this.findViewById(R.id.tg);
        acb=(Button)this.findViewById(R.id.acb);
        addb=(Button)this.findViewById(R.id.addb);
       // t1=(TextView)this.findViewById(R.id.t1);
       // t2=(TextView)this.findViewById(R.id.t2);      
        mPickDate1=(Button)this.findViewById(R.id.myDatePickerButton1);
        mDateDisplay1 = (TextView) findViewById(R.id.showDate1);
        Button lg=(Button)this.findViewById(R.id.lg);      
        lg.setOnClickListener(new OnClickListener(){
               @Override
               public void onClick(View v) {
                   finish();
                   LoginScreen.cc=0;
                      Intent logoutIntent = new Intent(ScheduleTransfer.this, LoginScreen.class);
                   logoutIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                   startActivity(logoutIntent);
               }
           });
        from.setOnClickListener(new OnClickListener(){     
          
            @Override
            public void onClick(View v) {
               trstatus.setText("");
                flag++;
                flag1=0;
                fillfromlist();
            }
        });
  
        to.setOnClickListener(new OnClickListener(){     
       
            @Override
            public void onClick(View v) {
             
               trstatus.setText("");
                flag++;
               flag2=0;
                filltolist();
            }
        });     
        home.setOnClickListener(new OnClickListener(){
               @Override
               public void onClick(View v) {
            	   progressDialog = ProgressDialog.show(ScheduleTransfer.this, "", "Loading...");

                   new Thread() {

                   public void run() {

                   try{

                   sleep(3000);
                   finish();
                   Intent i=new Intent(ScheduleTransfer.this, HomeScreen.class);
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
            	progressDialog = ProgressDialog.show(ScheduleTransfer.this, "", "Loading...");

                new Thread() {

                public void run() {

                try{

                sleep(3000);
               finish();
                Intent i=new Intent(ScheduleTransfer.this, AccountBalance.class);
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
        addb.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
            	progressDialog = ProgressDialog.show(ScheduleTransfer.this, "", "Loading...");

                new Thread() {

                public void run() {

                try{

                sleep(3000);
               finish();
                Intent i=new Intent(ScheduleTransfer.this, AddBeneficiary.class);
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
      
       /* amt.setOnClickListener(new OnClickListener(){      
            
            @Override
            public void onClick(View v) {
                amt.setText("");
            }
        });*/
      
        tg.setOnClickListener(new OnClickListener(){      
          
             @Override
             public void onClick(View v) {
                 from.setVisibility(View.VISIBLE);
                 to.setVisibility(View.VISIBLE);
                 amt.setVisibility(View.VISIBLE);
                 mPickDate1.setVisibility(View.VISIBLE);
                 mDateDisplay1.setVisibility(View.VISIBLE);
                 send.setVisibility(View.VISIBLE);
                 tg.setVisibility(View.GONE);
                 trstatus.setVisibility(View.GONE);
             }
         });
      
        mPickDate1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
              showDialog(DATE_DIALOG_ID);
          }
        });
      
        final Calendar c = Calendar.getInstance();
        mYear1 = c.get(Calendar.YEAR);
        mMonth1 = c.get(Calendar.MONTH);
        mDay1 = c.get(Calendar.DAY_OF_MONTH);
      
        updateDisplay();
      
        send.setOnClickListener(new OnClickListener(){      
          
             @Override
             public void onClick(View v) {
               trdate=mPickDate1.getText().toString();
             try {
                trd= formatter.parse(trdate);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
                 String am=amt.getText().toString().trim();
                 am.trim();
                 if(tdate.after(trd))
                     mDateDisplay1.setText("Please enter a valid date");
                 if(am.matches("^[1-9]\\d*$")){
                      amount=am+".0";
                      if(Double.parseDouble(am)>50000.0)
                            amt.setText("Amount exceeds transfer limit");
                          else transfer();}
                 else if(am.matches("^[1-9]\\d*(\\.\\d)?$")){
                     amount=am;
                     if(Double.parseDouble(am)>50000.0)
                       amt.setText("Amount exceeds transfer limit");
                     else transfer();}
                 else amt.setText("Enter valid amount");}
       });
    }
  
    void transfer(){
          if(flag==2)
          { 
          String fa=from.getText().toString();
          String ta=to.getText().toString();
          FetchFunctions.scheduleTransfer(fa,ta,amount,trdate);
          for(Status t:FetchFunctions.scheduleStatus){
              StatusDisp.st=t.getStatus();
              StatusDisp.screen=3;
          }
              Intent i=new Intent(ScheduleTransfer.this, StatusDisp.class);
              startActivity(i);
          flag=0;
          }
          else
          {
              StatusDisp.st="Account Nos not selected";
              StatusDisp.screen=3;
              Intent i=new Intent(ScheduleTransfer.this, StatusDisp.class);
              startActivity(i);
          }
    }
  
    private void updateDisplay() {
        String mm=Integer.toString(mMonth1+1);
        if(mm.length()==1)
            mm="0"+mm;
        String dd=Integer.toString(mDay1);
        if(dd.length()==1)
            dd="0"+dd;
        this.mPickDate1.setText(
            new StringBuilder()
                    // Month is 0 based so add 1
                    .append(dd).append("-")
                    .append(mm).append("-")
                    .append(mYear1));
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
  
    @Override
    public void onBackPressed() {  
        ScheduleTransfer.this.finish();
        Intent i=new Intent(ScheduleTransfer.this, HomeScreen.class);
        startActivity(i);
    }
  
    public void onListItemClick(ListView parent, View v,int position, long id)
    {
       /* Toast.makeText(this,
            "You have selected " + presidents[position],
            Toast.LENGTH_SHORT).show();*/
        if(flag1==1)
            from.setText(fromaccs[position]);
        if(flag2==1)
            to.setText(toaccs[position]);
        l1.setVisibility(View.GONE);
        flag1=0;
        flag2=0;
    }
 
    public void fillfromlist()
    {
        flag1=1;
        setListAdapter(new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_single_choice, fromaccs));
                final ListView listView = getListView();
                listView.setItemsCanFocus(false);
                listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
                l1=(LinearLayout)this.findViewById(R.id.listdisp);
                l1.setVisibility(View.VISIBLE);
               
    }
    public void filltolist()
    {
        flag2=1;
        setListAdapter(new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_single_choice, toaccs));
                final ListView listView = getListView();
                listView.setItemsCanFocus(false);
                listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
                l1=(LinearLayout)this.findViewById(R.id.listdisp);
                l1.setVisibility(View.VISIBLE);
    }
}