package com.backyard.watershortage.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.backyard.watershortage.R;
import com.backyard.watershortage.model.AffectedArea;
import com.backyard.watershortage.utility.AreaHelper;

public class SearchableView extends LinearLayout {
	
	public SearchableView(Context context, AffectedArea affArea) {
		super(context);
		
		View cell = View.inflate(context, R.layout.area_cell_new, null);
		TextView taman = (TextView) cell.findViewById(R.id.tvTaman);
		TextView area = (TextView) cell.findViewById(R.id.tvArea);
		TextView isNew = (TextView) cell.findViewById(R.id.tvNew);
		TextView reminderSet = (TextView) cell.findViewById(R.id.tvReminderSet);

		taman.setText(affArea.tamanName);
		
		int stringId = AreaHelper.getAreaName(affArea.areaName);
		area.setText(stringId);
		
		if(affArea.newZone){
			isNew.setVisibility(View.VISIBLE);
		}
		
		if(affArea.selected){
			reminderSet.setVisibility(View.VISIBLE);
		}
		
		addView(cell);

	}
	
	

}
