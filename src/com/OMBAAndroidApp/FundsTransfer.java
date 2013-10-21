package com.OMBAAndroidApp;

import java.util.ArrayList;

import com.OMBAAndroidApp.ItemFiles.Account;
import com.OMBAAndroidApp.ItemFiles.Beneficiary;
import com.OMBAAndroidApp.ItemFiles.Status;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.app.ListActivity;
import android.app.ProgressDialog;

public class FundsTransfer extends ListActivity
{
    ArrayList<String> accs,benaccs;
    EditText amt;
    Button home,send,acb,addb,from,to,tg;
    TextView trstatus;
    String amount;
    LinearLayout l1;
    //TextView t1,t2;
    ListView lv;
    int flag,flag1,flag2;
    String fromaccs[],toaccs[];
    private ProgressDialog progressDialog;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      
        setContentView(R.layout.fundstransfer);
        amount="";
        flag=0;
      //  t1=(TextView)this.findViewById(R.id.t1);
        //t2=(TextView)this.findViewById(R.id.t2);
       
        TextView name=(TextView)this.findViewById(R.id.name);
       
        name.setText(LoginScreen.customerName);
      
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
        send=(Button)this.findViewById(R.id.send);
        acb=(Button)this.findViewById(R.id.acb);
        addb=(Button)this.findViewById(R.id.addb);
        tg=(Button)this.findViewById(R.id.tg);
        Button lg=(Button)this.findViewById(R.id.lg);
      
        lg.setOnClickListener(new OnClickListener(){ 
               @Override
               public void onClick(View v) {
                   progressDialog = ProgressDialog.show(FundsTransfer.this, "", "Loading...");

                   new Thread() {

                   public void run() {

                   try{

                   sleep(3000);
                   finish();
                   LoginScreen.cc=0;
                      Intent logoutIntent = new Intent(FundsTransfer.this, LoginScreen.class);
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
                   progressDialog = ProgressDialog.show(FundsTransfer.this, "", "Loading...");

                   new Thread() {

                   public void run() {

                   try{

                   sleep(3000);
                   finish();
                   Intent i=new Intent(FundsTransfer.this, HomeScreen.class);
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
                progressDialog = ProgressDialog.show(FundsTransfer.this, "", "Loading...");

                new Thread() {

                public void run() {

                try{

                sleep(3000);
                finish();
                Intent i=new Intent(FundsTransfer.this, AccountBalance.class);
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
                progressDialog = ProgressDialog.show(FundsTransfer.this, "", "Loading...");

                new Thread() {

                public void run() {

                try{

                sleep(3000);
                finish();
                Intent i=new Intent(FundsTransfer.this, AddBeneficiary.class);
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
       
       /* amt.setOnClickListener(new OnClickListener(){      
            
            @Override
            public void onClick(View v) {
                amt.setText("");
            }
        });*/
       
        tg.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                //t1.setVisibility(View.VISIBLE);
                //t2.setVisibility(View.VISIBLE);
                from.setVisibility(View.VISIBLE);
                to.setVisibility(View.VISIBLE);
                amt.setVisibility(View.VISIBLE);
                send.setVisibility(View.VISIBLE);
                tg.setVisibility(View.GONE);
                amt.setText("Amount");
                from.setText("From Account No");
                to.setText("To Account No");
                trstatus.setText("");
            }
        });
        send.setOnClickListener(new OnClickListener(){
             @Override
             public void onClick(View v) {
                 send.setVisibility(View.GONE);
                 String am=amt.getText().toString().trim();
                 if(am.matches("^[1-9]\\d*$")){
                     amount=am+".0";
                     transfer();}
                 else if(am.matches("^[1-9]\\d*(\\.\\d)?$")){
                     amount=am;
                     transfer();}
                 else amt.setText("Enter valid amount");
                 send.setVisibility(View.VISIBLE);
             }           
         });
    }
    void transfer(){
        if(flag==2)
        {  
        String fa=from.getText().toString();
        String ta=to.getText().toString();
        FetchFunctions.transferMoney(fa,ta,amount);
        for(Status t:FetchFunctions.transferStatus){
            StatusDisp.st=t.getStatus();
            StatusDisp.screen=2;
        }
        Intent i=new Intent(FundsTransfer.this, StatusDisp.class);
       
        startActivity(i);
        flag=0;
        }
        else{
            StatusDisp.st="Account Nos not selected";
            StatusDisp.screen=2;
            Intent i=new Intent(FundsTransfer.this, StatusDisp.class);
            startActivity(i);
            flag=0;
        }
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
    @Override
    public void onBackPressed() {   
        FundsTransfer.this.finish();
        Intent i=new Intent(FundsTransfer.this, HomeScreen.class);
        startActivity(i);
    }
}