package com.backyard.watershortage.view;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.backyard.watershortage.R;
import com.backyard.watershortage.model.AffectedArea;

public class AffectedAreaView extends LinearLayout {

	public AffectedAreaView(Context context, AffectedArea affectedArea) {
		super(context);

		View cell = View.inflate(context, R.layout.area_cell, null);
		TextView area = (TextView) cell.findViewById(R.id.tvArea);
		CheckBox cb = (CheckBox)cell.findViewById(R.id.cbReminder);

		area.setText(affectedArea.tamanName);
		
		if(affectedArea.selected){
			cb.setVisibility(View.VISIBLE);
		}
		
		addView(cell);

	}
}