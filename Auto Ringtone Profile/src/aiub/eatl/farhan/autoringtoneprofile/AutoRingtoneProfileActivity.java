package aiub.eatl.farhan.autoringtoneprofile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class AutoRingtoneProfileActivity extends Activity {
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
				intent = new Intent(getApplicationContext(), SensorService.class);
				//Toast.makeText(getApplicationContext(), "Service Started", Toast.LENGTH_SHORT).show();
				startService(intent);
			}
		});
        
        stop.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				intent = new Intent(getApplicationContext(), SensorService.class);
				//Toast.makeText(getApplicationContext(), "Service Stopped", Toast.LENGTH_SHORT).show();
				
				stopService(intent);
			}
		});
        
    }
}