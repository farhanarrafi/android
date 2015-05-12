package aiub.eatl.farhan.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ServiceActivity extends Activity{
    
	Button start, stop;
	
	Intent intent;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        start = (Button) findViewById(R.id.button_start);
        stop = (Button) findViewById(R.id.button_stop);
        
        start.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				intent = new Intent(getApplicationContext(), NormalService.class);
				startService(intent);
			}
		});
        
        stop.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				intent = new Intent(getApplicationContext(), NormalService.class);
				stopService(intent);
			}
		});
        
    }

}