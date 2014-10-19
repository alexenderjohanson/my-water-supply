package com.backyard.watershortage.model;

public class Reminder {
	
	public String areaName;
	public boolean hasWater;
	public int zone;
	
	public Reminder(String areaName, boolean hasWater, int zone){
		this.areaName = areaName;
		this.hasWater = hasWater;
		this.zone = zone;
	}

}
