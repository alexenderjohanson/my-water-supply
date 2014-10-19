package com.backyard.watershortage.view;

import java.text.SimpleDateFormat;
import java.util.Locale;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.backyard.watershortage.R;
import com.backyard.watershortage.model.Zone;
import com.backyard.watershortage.utility.AreaHelper;

public class ZoneView extends LinearLayout{

	public ZoneView(Context context, Zone zone) {
		super(context);

		View cell = View.inflate(context, R.layout.zone_cell, null);
		TextView date = (TextView) cell.findViewById(R.id.tvDate);
		TextView hasWater = (TextView) cell.findViewById(R.id.tvWater);
		TextView today = (TextView) cell.findViewById(R.id.tvToday);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, E", Locale.getDefault());
		date.setText(dateFormat.format(zone.date));
		
		if(AreaHelper.isToday(zone.date)){
			today.setVisibility(View.VISIBLE);
		}
		
		if(zone.hasWater){
			hasWater.setText(R.string.has_water);
			cell.setBackgroundColor(context.getResources().getColor(R.color.blue));
		}else{
			hasWater.setText(R.string.no_water);
		}
		
		addView(cell);

	}
}
