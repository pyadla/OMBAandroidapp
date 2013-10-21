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
import android.widget.TextView;

public class HomeScreen extends Activity {

    private ProgressDialog progressDialog;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
          
        Button acb=(Button)this.findViewById(R.id.acbal);
        Button mini=(Button)this.findViewById(R.id.mini);
        Button trh=(Button)this.findViewById(R.id.trh);
        Button trf=(Button)this.findViewById(R.id.trf);
        Button scd=(Button)this.findViewById(R.id.scd);
        Button addb=(Button)this.findViewById(R.id.addb);
        Button macc=(Button)this.findViewById(R.id.macc);
        Button sett=(Button)this.findViewById(R.id.settings);
        Button gll=(Button)this.findViewById(R.id.gll);
        Button loc=(Button)this.findViewById(R.id.loc);
        Button lg=(Button)this.findViewById(R.id.lg);
        TextView name=(TextView)this.findViewById(R.id.name);
        TextView t1=(TextView)this.findViewById(R.id.t1);
        TextView t2=(TextView)this.findViewById(R.id.t2);
        TextView t3=(TextView)this.findViewById(R.id.t3);
        TextView t4=(TextView)this.findViewById(R.id.t4);
        TextView t5=(TextView)this.findViewById(R.id.t5);
        TextView t6=(TextView)this.findViewById(R.id.t6);
        TextView t7=(TextView)this.findViewById(R.id.t7);
        TextView t8=(TextView)this.findViewById(R.id.t8);
        TextView t9=(TextView)this.findViewById(R.id.t9);
        TextView t10=(TextView)this.findViewById(R.id.t10);
       
        name.setText(LoginScreen.customerName); 
       
        lg.setOnClickListener(new OnClickListener(){       
             
               @Override
               public void onClick(View v) {
                   finish();
                   LoginScreen.cc=0;
                     Intent logoutIntent = new Intent(HomeScreen.this, LoginScreen.class);
                   logoutIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                   startActivity(logoutIntent);
               }
           });
        loc.setOnClickListener(new View.OnClickListener() { 
            public void onClick(View v){ 
              
             Uri uri = Uri.parse("http://g.co/maps/fsn74");
             Intent intent = new Intent(Intent.ACTION_VIEW, uri);
             startActivity(intent);

          
            }  });
        t10.setOnClickListener(new View.OnClickListener() { 
            public void onClick(View v){ 
              
             Uri uri = Uri.parse("http://g.co/maps/fsn74");
             Intent intent = new Intent(Intent.ACTION_VIEW, uri);
             startActivity(intent);

          
            }  });
         gll.setOnClickListener(new OnClickListener(){       
            
                @Override
                public void onClick(View v) {
               
                progressDialog = ProgressDialog.show(HomeScreen.this, "", "Loading...");

               new Thread() {

               public void run() {

               try{

               sleep(3000);
                   finish();
                    Intent i=new Intent(HomeScreen.this, ViewGallery.class);
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
         t9.setOnClickListener(new OnClickListener(){       
               
              @Override
              public void onClick(View v) {
             
              progressDialog = ProgressDialog.show(HomeScreen.this, "", "Loading...");

             new Thread() {

             public void run() {

             try{

             sleep(3000);
                 finish();
                  Intent i=new Intent(HomeScreen.this, ViewGallery.class);
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
               progressDialog = ProgressDialog.show(HomeScreen.this, "", "Loading...");

            new Thread() {

            public void run() {

            try{

            sleep(3000);
               finish();
                  Intent i=new Intent(HomeScreen.this, AccountBalance.class);
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
        
         t1.setOnClickListener(new OnClickListener(){       
              
                @Override
                public void onClick(View v) {
                 progressDialog = ProgressDialog.show(HomeScreen.this, "", "Loading...");

              new Thread() {

              public void run() {

              try{

              sleep(3000);
                 finish();
                    Intent i=new Intent(HomeScreen.this, AccountBalance.class);
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

         sett.setOnClickListener(new OnClickListener(){       
              
                @Override
                public void onClick(View v) {
                   progressDialog = ProgressDialog.show(HomeScreen.this, "", "Loading...");

                  new Thread() {

                  public void run() {

                  try{

                  sleep(3000);
                   finish();
                    Intent i=new Intent(HomeScreen.this, AccountSettings.class);
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
        
         t8.setOnClickListener(new OnClickListener(){       
             
              @Override
              public void onClick(View v) {
                 progressDialog = ProgressDialog.show(HomeScreen.this, "", "Loading...");

                new Thread() {

                public void run() {

                try{

                sleep(3000);
                 finish();
                  Intent i=new Intent(HomeScreen.this, AccountSettings.class);
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
         mini.setOnClickListener(new OnClickListener(){       
              
                @Override
                public void onClick(View v) {
                   progressDialog = ProgressDialog.show(HomeScreen.this, "", "Loading...");

                  new Thread() {

                  public void run() {

                  try{

                  sleep(3000);
                   finish();
                    Intent i=new Intent(HomeScreen.this, MiniStatement.class);
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
        t2.setOnClickListener(new OnClickListener(){       
             
              @Override
              public void onClick(View v) {
                 progressDialog = ProgressDialog.show(HomeScreen.this, "", "Loading...");

                new Thread() {

                public void run() {

                try{

                sleep(3000);
                 finish();
                  Intent i=new Intent(HomeScreen.this, MiniStatement.class);
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
               progressDialog = ProgressDialog.show(HomeScreen.this, "", "Loading...");

            new Thread() {

            public void run() {

            try{

            sleep(3000);
               finish();
                  Intent i=new Intent(HomeScreen.this, TransactionHistory.class);
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

         t3.setOnClickListener(new OnClickListener(){       
            
                @Override
                public void onClick(View v) {
                 progressDialog = ProgressDialog.show(HomeScreen.this, "", "Loading...");

              new Thread() {

              public void run() {

              try{

              sleep(3000);
                 finish();
                    Intent i=new Intent(HomeScreen.this, TransactionHistory.class);
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
         trf.setOnClickListener(new OnClickListener(){       
            
                @Override
                public void onClick(View v) {
                   progressDialog = ProgressDialog.show(HomeScreen.this, "", "Loading...");

                  new Thread() {

                  public void run() {

                  try{

                  sleep(3000);
                    finish();
                    Intent i=new Intent(HomeScreen.this, FundsTransfer.class);
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
         t4.setOnClickListener(new OnClickListener(){       
               
              @Override
              public void onClick(View v) {
                 progressDialog = ProgressDialog.show(HomeScreen.this, "", "Loading...");

                new Thread() {

                public void run() {

                try{

                sleep(3000);
                  finish();
                  Intent i=new Intent(HomeScreen.this, FundsTransfer.class);
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

         scd.setOnClickListener(new OnClickListener(){       
               
              @Override
              public void onClick(View v) {
               progressDialog = ProgressDialog.show(HomeScreen.this, "", "Loading...");

            new Thread() {

            public void run() {

            try{

            sleep(3000);
                  finish();
                  Intent i=new Intent(HomeScreen.this, ScheduleTransfer.class);
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

         t5.setOnClickListener(new OnClickListener(){       
              
                @Override
                public void onClick(View v) {
                 progressDialog = ProgressDialog.show(HomeScreen.this, "", "Loading...");

              new Thread() {

              public void run() {

              try{

              sleep(3000);
                    finish();
                    Intent i=new Intent(HomeScreen.this, ScheduleTransfer.class);
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
               progressDialog = ProgressDialog.show(HomeScreen.this, "", "Loading...");

            new Thread() {

            public void run() {

            try{

            sleep(3000);
                  finish();
                  Intent i=new Intent(HomeScreen.this, AddBeneficiary.class);
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

         t6.setOnClickListener(new OnClickListener(){       
              
                @Override
                public void onClick(View v) {
                 progressDialog = ProgressDialog.show(HomeScreen.this, "", "Loading...");

              new Thread() {

              public void run() {

              try{

              sleep(3000);
                    finish();
                    Intent i=new Intent(HomeScreen.this, AddBeneficiary.class);
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

         macc.setOnClickListener(new OnClickListener(){       
              
                @Override
                public void onClick(View v) {
                   progressDialog = ProgressDialog.show(HomeScreen.this, "", "Loading...");

                  new Thread() {

                  public void run() {

                  try{

                  sleep(3000);
                    finish();
                    Intent i=new Intent(HomeScreen.this, ManageAccount.class);
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
        t7.setOnClickListener(new OnClickListener(){       
             
              @Override
              public void onClick(View v) {
                 progressDialog = ProgressDialog.show(HomeScreen.this, "", "Loading...");

                new Thread() {

                public void run() {

                try{

                sleep(3000);
                  finish();
                  Intent i=new Intent(HomeScreen.this, ManageAccount.class);
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
        HomeScreen.this.finish();
        LoginScreen.cc=0;
        Intent i=new Intent(HomeScreen.this,LoginScreen.class);
        startActivity(i);
    }
}