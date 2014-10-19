package com.backyard.watershortage.model;

import java.util.Date;

public class Zone {
	
	public Date date;
	public boolean hasWater;
	
	public Zone(Date date, boolean hasWater){
		this.date = date;
		this.hasWater = hasWater;
	}

}
