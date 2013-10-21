package com.OMBAAndroidApp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AboutUs extends Activity {
    /** Called when the activity is first created. */
  
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        Button b1=(Button)this.findViewById(R.id.button1);
        b1.setOnClickListener(new OnClickListener(){    
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:9985806396"));
                startActivity(callIntent);
            }
        });
    }
}