package com.backyard.watershortage.model;

import android.content.Context;

import com.backyard.watershortage.DataStore;

public class AffectedAreaHelper {
	
	public static boolean didUserWantsNotification(Context context, AffectedArea area){
		
		String selectedArea = getAllUsersNotificationArea(context);
		
		if(selectedArea.contains(area.tamanName)){
			return true;
		}
		
		return false;
	}
	
	public static String getAllUsersNotificationArea(Context context){
		
		DataStore dataStore = new DataStore(context);
		StringBuilder builder = new StringBuilder(dataStore.getSelectedArea(1));
		builder.append(" " + dataStore.getSelectedArea(2));
		builder.append(" " + dataStore.getSelectedArea(3));
		builder.append(" " + dataStore.getSelectedArea(4));
		
		return builder.toString();
	}

}
