package com.backyard.watershortage.utility;

import java.util.Calendar;
import java.util.Date;

import com.backyard.watershortage.R;
import com.backyard.watershortage.model.AffectedAreaFactory.Area;

public class AreaHelper {
	
	public static int getAreaName(Area area){

		int stringId = 0;
		switch (area) {
		case Gombak:
			stringId = R.string.area_gombak;
			break;
		case Kuala_Lumpur:
			stringId = R.string.area_kuala_lumpur;
			break;
		case Petaling:
			stringId = R.string.area_petaling;
			break;
		case Klang:
			stringId = R.string.area_klang;
			break;
		case Kuala_Selangor:
			stringId = R.string.area_kuala_selangor;
			break;
		case Hulu_selangor:
			stringId = R.string.area_hulu_selangor;
			break;
		case Hulu_Langat:
			stringId = R.string.area_hulu_langat;
			break;
		case Kuala_Langat_Sepang:
			stringId = R.string.area_kuala_langat;
			break;
		case New_Klang:
			stringId = R.string.area_klang_new;
			break;
		case Petaling_Sepang:
			stringId = R.string.area_petaling_sepang;
			break;
		
		}
		
		return stringId;
	}
	
	public static boolean isToday(Date date){
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c2.setTime(date);

		if (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR) && c1.get(Calendar.DAY_OF_YEAR) == c2.get(Calendar.DAY_OF_YEAR)){
			return true;
		}
		
		return false;
	}

}
