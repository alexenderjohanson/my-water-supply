package com.backyard.watershortage.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.backyard.watershortage.model.Zone;
import com.backyard.watershortage.model.ZoneFactory;
import com.backyard.watershortage.utility.AreaHelper;
import com.backyard.watershortage.view.ZoneView;

public class ZoneAdapter extends BaseAdapter{

	private Context context;
	private int zone;
	private List<Zone> zones;
	
	public ZoneAdapter(Context context, int zone){
		this.zone = zone;
		this.context = context;
		zones = ZoneFactory.GenerateZone(zone);
	}
	
	@Override
	public int getCount() {
		return zones.size();
	}

	@Override
	public Object getItem(int position) {
		return zones.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View cell = new ZoneView(context, ZoneFactory.GenerateZone(zone).get(position));
		return cell;
	}
	
	public int getTodayPosition(){
		for(int i = 0; i < zones.size(); i++){
			if(AreaHelper.isToday(zones.get(i).date)){
				return i;
			}
		}
		
		return 0;
	}

}
