package aiub.eatl.farhan.autoringtoneprofile;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.os.IBinder;
import android.util.Log;

public class SensorService extends Service implements SensorEventListener {
	private SensorManager sensorManager;
	private Sensor proximitySensor;
	private AudioManager audioManager;
	
	@Override
	public void onCreate() {
		super.onCreate();
		
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		sensorManager.unregisterListener(this);
		//Toast.makeText(getApplicationContext(), "Serivce Destroyed", Toast.LENGTH_SHORT).show();
	}
	
	

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		//Toast.makeText(getApplicationContext(), "Serivce onStartCommand", Toast.LENGTH_SHORT).show();
		sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
		sensorManager.registerListener(this, proximitySensor, SensorManager.SENSOR_DELAY_FASTEST);
		audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
		
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}
	
//	private int toggle(int current) {
//		if(current==AudioManager.RINGER_MODE_NORMAL)
//			return AudioManager.RINGER_MODE_VIBRATE;
//		else 
//			return AudioManager.RINGER_MODE_NORMAL;
//	}

	public void onSensorChanged(SensorEvent event) {
		if(event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
			double proximityValue = event.values[0];
			//Toast.makeText(getApplicationContext(), , Toast.LENGTH_SHORT/10).show();
			//Log.d("Proximity Value", ""+proximityValue);
			if(proximityValue==0) {
				//audioManager.setRingerMode(toggle(audioManager.getRingerMode()));
				audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
				//Toast.makeText(getApplicationContext(), "WILL VIBRATE NOW", Toast.LENGTH_SHORT).show();
			}
			else {
				
				audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
				//Toast.makeText(getApplicationContext(), "WILL RING NOW", Toast.LENGTH_SHORT).show();
			}
		}
		
	}

}
