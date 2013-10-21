package com.OMBAAndroidApp;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AfterLogin extends Activity {
    /** Called when the activity is first created. */
	private static final long DELAY = 1000;
    private boolean scheduled = false;
    private Timer splashTimer;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afterlogin);
        
        TextView hello=(TextView)this.findViewById(R.id.hello);
        hello.setText("Hello "+LoginScreen.gender+" "+LoginScreen.customerName+"!");
        splashTimer = new Timer();
        splashTimer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
            	AfterLogin.this.finish();
                startActivity(new Intent(AfterLogin.this, LoginScreen.class));
            }
         }, DELAY);
       scheduled = true;

    }
    
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        if (scheduled)
            splashTimer.cancel();
        splashTimer.purge();
    }
}