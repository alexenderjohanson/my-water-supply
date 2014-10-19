package com.backyard.watershortage.model;

import java.io.Serializable;

import com.backyard.watershortage.model.AffectedAreaFactory.Area;

public class AffectedArea implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1919156737987703789L;
	public Area areaName;
	public String tamanName;
	public int zone;
	public boolean selected;
	public boolean newZone;
	
	public AffectedArea(Area areaName, String tamanName, int zone){
		this.areaName = areaName;
		this.tamanName = tamanName;
		this.zone = zone;
	}
	
	public AffectedArea(Area areaName, String tamanName, int zone, boolean newZone){
		this(areaName, tamanName, zone);
		this.newZone = newZone;
	}
}
