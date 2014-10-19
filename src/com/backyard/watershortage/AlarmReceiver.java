package com.backyard.watershortage;

import java.util.Calendar;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;

import com.backyard.watershortage.model.AffectedArea;
import com.backyard.watershortage.model.AffectedAreaFactory.Area;
import com.backyard.watershortage.model.ZoneFactory;
import com.backyard.watershortage.model.ZoneNotification;

public class AlarmReceiver extends BroadcastReceiver {

	public void SetAlarm(Context context) {
		AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
		Intent i = new Intent(context, AlarmReceiver.class);
		PendingIntent pi = PendingIntent.getBroadcast(context, 0, i, 0);
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		calendar.set(Calendar.HOUR_OF_DAY, 9);
		
		am.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_HALF_DAY, pi);
		//am.setInexactRepeating(AlarmManager.RTC_WAKEUP, new Date().getTime() + 1000, 1000 * 30 , pi);
	}

	public void CancelAlarm(Context context) {
		Intent intent = new Intent(context, AlarmReceiver.class);
		PendingIntent sender = PendingIntent.getBroadcast(context, 0, intent, 0);
		AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
		alarmManager.cancel(sender);
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		
		DataStore dataStore = new DataStore(context);
		ZoneNotification nextZone = ZoneFactory.getNextZone();
		
		if(nextZone.zone == 0){
			return;
		}
		boolean optedIn = dataStore.isZoneSelected(nextZone.zone);
		
		if(!optedIn){
			return;
		}
		
		int bigTextId = R.string.notification_big_text_24hours;
		
		if(nextZone.timeToWaterDisruption < 43200000L){
			bigTextId = R.string.notification_big_text_12hours;
		}
		
		String selectedArea = dataStore.getSelectedArea(nextZone.zone);
		String[] splitedText = selectedArea.split("~");
		
		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
				context).setSmallIcon(R.drawable.ic_launcher)
				.setContentTitle(context.getText(R.string.notification_title))
				.setContentText(context.getText(bigTextId));

		NotificationCompat.InboxStyle bigTextStyle = new NotificationCompat.InboxStyle();
		for(String text : splitedText){
			bigTextStyle.addLine(text.trim());
		}
		bigTextStyle.setSummaryText(context.getText(bigTextId));
		mBuilder.setStyle(bigTextStyle);

		// Creates an explicit intent for an Activity in your app
		Intent resultIntent = new Intent(context, DetailActivity.class);
		
		AffectedArea affArea = new AffectedArea(Area.Gombak, splitedText[0].trim(), nextZone.zone);
		affArea.selected = true;
		resultIntent.putExtra("affectedArea", affArea);

		// The stack builder object will contain an artificial back stack for the started Activity.
		// This ensures that navigating backward from the Activity leads out
		// of your application to the Home screen.
		TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
		// Adds the back stack for the Intent (but not the Intent itself)
		stackBuilder.addParentStack(DetailActivity.class);
		// Adds the Intent that starts the Activity to the top of the stack
		stackBuilder.addNextIntent(resultIntent);
		PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
		mBuilder.setContentIntent(resultPendingIntent);
		NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		
		// mId allows you to update the notification later on.
		Notification notification = mBuilder.build();
		notification.flags = Notification.DEFAULT_LIGHTS | Notification.FLAG_AUTO_CANCEL;
		mNotificationManager.notify(1, notification);
	}
}
