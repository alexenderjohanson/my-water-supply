package com.backyard.watershortage.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class ZoneFactory {
	
	public static List<Zone> GenerateZone(int zone){
		
		List<Zone> zones = new ArrayList<Zone>();
		switch(zone)
		{
		case 1:
			zones.add(new Zone(new GregorianCalendar(2014, 3, 1).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 2).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 3).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 4).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 5).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 6).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 7).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 8).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 9).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 10).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 11).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 12).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 13).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 14).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 15).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 16).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 17).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 18).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 19).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 20).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 21).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 22).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 23).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 24).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 25).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 26).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 27).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 28).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 29).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 30).getTime(), true));
			break;
			
		case 2:
			zones.add(new Zone(new GregorianCalendar(2014, 3, 1).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 2).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 3).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 4).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 5).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 6).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 7).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 8).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 9).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 10).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 11).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 12).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 13).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 14).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 15).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 16).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 17).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 18).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 19).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 20).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 21).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 22).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 23).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 24).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 25).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 26).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 27).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 28).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 29).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 30).getTime(), false));
			break;
			
		case 3:
			zones.add(new Zone(new GregorianCalendar(2014, 3, 1).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 2).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 3).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 4).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 5).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 6).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 7).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 8).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 9).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 10).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 11).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 12).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 13).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 14).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 15).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 16).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 17).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 18).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 19).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 20).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 21).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 22).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 23).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 24).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 25).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 26).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 27).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 28).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 29).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 30).getTime(), false));
			
			break;
		
		case 4:
			zones.add(new Zone(new GregorianCalendar(2014, 3, 1).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 2).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 3).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 4).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 5).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 6).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 7).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 8).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 9).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 10).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 11).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 12).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 13).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 14).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 15).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 16).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 17).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 18).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 19).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 20).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 21).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 22).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 23).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 24).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 25).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 26).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 27).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 28).getTime(), false));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 29).getTime(), true));
			zones.add(new Zone(new GregorianCalendar(2014, 3, 30).getTime(), true));
			break;
		}
		
		return zones;
	}
	
	public static ZoneNotification getNextZone(){
		
		long zone1 = timeToNextShortage(1);
		long zone2 = timeToNextShortage(2);
		long zone3 = timeToNextShortage(3);
		long zone4 = timeToNextShortage(4);
		
		if(zone1 == 0 && zone2 == 0 && zone3 == 0 && zone4 == 0){
			return new ZoneNotification();
		}
		
		int nextZone = 0;
		long zoneTiming = Long.MAX_VALUE;
		
		if(zone1 != 0 && zone1 < zoneTiming){
			nextZone = 1;
			zoneTiming = zone1;
		}
		
		if(zone2 != 0 && zone2 < zoneTiming){
			nextZone = 2;
			zoneTiming = zone2;
		}
		
		if(zone3 != 0 && zone3 < zoneTiming){
			nextZone = 3;
			zoneTiming = zone3;
		}
		
		if(zone4 != 0 && zone4 < zoneTiming){
			nextZone = 4;
			zoneTiming = zone4;
		}
		
		ZoneNotification nextNotification = new ZoneNotification();
		nextNotification.timeToWaterDisruption = zoneTiming;
		nextNotification.zone = nextZone;
		
		return nextNotification;
	}
	
	private static long timeToNextShortage(int zoneId){
		
		Date now = new Date();
		long shortestTime = 0;
		
		List<Zone> zones = GenerateZone(zoneId);
		
		for (int i = 0; i < zones.size(); i++) {
			if(!zones.get(i).hasWater && zones.get(i).date.after(now) && zones.get(i).date.getTime() - now.getTime() < 1000* 60 * 60 * 24){
				
				if(i == 0 || !zones.get(i -1).hasWater){
					continue;
				}
				
				shortestTime = zones.get(i).date.getTime() - now.getTime();
				break;
			}
		}
		
		return shortestTime;
	}
	
	public static boolean zoneHasWater(int zone){
		List<Zone> zones = GenerateZone(zone);
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(new Date());
		for (Zone zone2 : zones) {
			Calendar cal2 = Calendar.getInstance();
			cal2.setTime(zone2.date);
			boolean sameDay = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
			                  cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
			if(sameDay){
				return zone2.hasWater;
			}
		}
		
		return true;
	}
}
