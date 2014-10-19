package com.backyard.watershortage;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;

public class TimeReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {

		Log.e("Water Sortage Service", intent.getAction());
		if (intent.getAction().equals(Intent.ACTION_TIME_TICK)) {
			NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
					context).setSmallIcon(R.drawable.ic_launcher)
					.setContentTitle("Water Shortage Alert")
					.setContentText("Planned water shortage at your area");

			NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
			inboxStyle.setBigContentTitle("Water Shortage Alert");
			//inboxStyle.setSummaryText("There will be a planned water shortage at the following area:");
			inboxStyle.addLine("Batu Caves");
			inboxStyle.addLine("Serdang");
			mBuilder.setStyle(inboxStyle);
			
			// Creates an explicit intent for an Activity in your app
			Intent resultIntent = new Intent(context, ShortageActivity.class);

			// The stack builder object will contain an artificial back stack
			// for
			// the
			// started Activity.
			// This ensures that navigating backward from the Activity leads out
			// of
			// your application to the Home screen.
			TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
			// Adds the back stack for the Intent (but not the Intent itself)
			stackBuilder.addParentStack(ShortageActivity.class);
			// Adds the Intent that starts the Activity to the top of the stack
			stackBuilder.addNextIntent(resultIntent);
			PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(
					0, PendingIntent.FLAG_UPDATE_CURRENT);
			mBuilder.setContentIntent(resultPendingIntent);
			NotificationManager mNotificationManager = (NotificationManager) context
					.getSystemService(Context.NOTIFICATION_SERVICE);
			// mId allows you to update the notification later on.
			mNotificationManager.notify(1, mBuilder.build());
		}
	}
	
	private void getShortageArea(){
		
	}
}
