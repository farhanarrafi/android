package edu.aiub.farhan.project.eatl.calculator;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verticalview);
    }
    
    public void onConfigurationChanged(Configuration newConfig) {
    	super.onConfigurationChanged(newConfig);
    	
    	Log.d("ConfigCnage", "Configuration Changed!!");
    	if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
    		setContentView(R.layout.verticalview);
    	} else {
    		setContentView(R.layout.horizontalview);
    	}
    }
}