package aiub.eatl.farhan.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

class NormalService extends Service {

	
	
	@Override
	public void onCreate() {
		super.onCreate();
		
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Toast.makeText(getApplicationContext(), "Service Stopped", Toast.LENGTH_SHORT).show();
		
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Toast.makeText(getApplicationContext(), "Service Started", Toast.LENGTH_SHORT).show();
		
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
