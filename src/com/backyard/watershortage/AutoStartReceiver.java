package com.backyard.watershortage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.backyard.watershortage.utility.Constant;

public class AutoStartReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {

		//do not start after May first
		if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED) && System.currentTimeMillis() < Constant.EXPIRED_DATE) {
			Intent serviceIntent = new Intent(context,
					WaterShortageService.class);
			context.startService(serviceIntent);
		}
	}
}
