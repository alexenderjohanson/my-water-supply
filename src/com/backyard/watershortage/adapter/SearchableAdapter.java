package com.backyard.watershortage.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.backyard.watershortage.model.AffectedArea;
import com.backyard.watershortage.view.SearchableView;

public class SearchableAdapter extends BaseAdapter{
	
	private List<AffectedArea> areas = new ArrayList<AffectedArea>();
	private Context context;
	
	public SearchableAdapter(Context context){
		this.context = context;
	}

	@Override
	public int getCount() {
		return areas.size();
	}

	@Override
	public Object getItem(int position) {
		return areas.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View cell = new SearchableView(context, areas.get(position));
		return cell;
	}
	
	public void SetResult(List<AffectedArea> affArea){
		areas = affArea;
	}
}
