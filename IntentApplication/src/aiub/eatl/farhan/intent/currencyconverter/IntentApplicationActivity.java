package aiub.eatl.farhan.intent.currencyconverter;

import android.app.Activity;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;

public class IntentApplicationActivity extends Activity implements OnClickListener {
    Spinner spin_from, spin_to;
    
    Button select;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        spin_from = (Spinner) findViewById(R.id.spinner_basecurr);
        spin_to = (Spinner) findViewById(R.id.spinner_convcurr);
        
        select = (Button) findViewById(R.id.button_select);
        
        select.setOnClickListener(this);
        
    }

	@Override
	protected void onResume() {
		super.onResume();
		
		
	}

	public void onClick(View v) {
		if(v.getId()==select.getId()) {
			
			Intent intent = new Intent(this, ConverterActivity.class);
			intent.putExtra("from", spin_from.getSelectedItem().toString());
			intent.putExtra("to", spin_to.getSelectedItem().toString());
			
			startActivityForResult(intent, 0);
			
		}
	}
    
    
}