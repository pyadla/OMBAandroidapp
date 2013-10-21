package com.OMBAAndroidApp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class StatusDisp extends Activity {
	
	public static String st="";
	public static int screen=0;
    /** Called when the activity is first created. */
  
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.status);
        Button b1=(Button)this.findViewById(R.id.bck);
        TextView tv=(TextView)this.findViewById(R.id.stat);
        tv.setText(st);
        b1.setOnClickListener(new OnClickListener(){                 
            @Override
            public void onClick(View v) {
            	finish();
            	if(screen==1){
            		Intent i=new Intent(StatusDisp.this, LoginScreen.class);
            		startActivity(i);
            	}
            	else if(screen==2){
                Intent i=new Intent(StatusDisp.this, FundsTransfer.class);
                   startActivity(i);
            	}
            	else if(screen==3){
                    Intent i=new Intent(StatusDisp.this, ScheduleTransfer.class);
                       startActivity(i);
                	}
            	else if(screen==4){
                    Intent i=new Intent(StatusDisp.this, TransactionHistory.class);
                       startActivity(i);
                	}
            }
        });
    }
    @Override
   	public void onBackPressed() {    
       	StatusDisp.this.finish();
       	Intent i=new Intent(StatusDisp.this, HomeScreen.class);
           startActivity(i);
   	}
}