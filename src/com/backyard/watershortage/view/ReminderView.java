package com.backyard.watershortage.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.backyard.watershortage.R;
import com.backyard.watershortage.model.Reminder;

public class ReminderView extends LinearLayout{

	public ReminderView(Context context, Reminder reminder) {
		super(context);
		
		View cell = View.inflate(context, R.layout.reminder_cell, null);
		TextView area = (TextView)cell.findViewById(R.id.tvReminderArea);
		TextView hasWater = (TextView)cell.findViewById(R.id.tvWaterStatus);
		
		area.setText(reminder.areaName);
		
		if(reminder.hasWater){
			hasWater.setTextColor(context.getResources().getColor(R.color.blue));
			hasWater.setText(R.string.has_water);
		} 
		
		addView(cell);
	}

}
