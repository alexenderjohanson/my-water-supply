package com.backyard.watershortage;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

public class WaterShortageService extends Service {

	private AlarmReceiver receiver = new AlarmReceiver();

	@Override
	public void onCreate() {
		super.onCreate();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		receiver.SetAlarm(WaterShortageService.this);
		//Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
		return START_STICKY;
	}

	public void onStart(Context context, Intent intent, int startId) {
		receiver.SetAlarm(context);
		//Toast.makeText(this, "Service Started1", Toast.LENGTH_LONG).show();
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

}
