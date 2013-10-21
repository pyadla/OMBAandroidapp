package com.OMBAAndroidApp;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class OMBAAndroidAppActivity extends Activity {
    /** Called when the activity is first created. */
	private static final long DELAY = 3000;
    private boolean scheduled = false;
    private Timer splashTimer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        splashTimer = new Timer();
        splashTimer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
            	OMBAAndroidAppActivity.this.finish();
                startActivity(new Intent(OMBAAndroidAppActivity.this, LoginScreen.class));
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