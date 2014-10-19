package com.backyard.watershortage.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import com.backyard.watershortage.ResultChangeListener;
import com.backyard.watershortage.model.AffectedArea;
import com.backyard.watershortage.model.AffectedAreaFactory;
import com.backyard.watershortage.view.SearchableView;

public class AffectedAreaAdapter extends BaseAdapter implements Filterable{

	private List<AffectedArea> affectedAreas;
	private List<AffectedArea> filteredAreas;
	private Context context;
	private ResultChangeListener listener;
	
	public AffectedAreaAdapter(Context context, ResultChangeListener listener){
		this.context = context;
		filteredAreas = affectedAreas = AffectedAreaFactory.generateAllArea(context, true);
		this.listener = listener;
	}
	
	@Override
	public int getCount() {
		return filteredAreas.size();
	}

	@Override
	public AffectedArea getItem(int position) {
		return filteredAreas.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View cell = new SearchableView(context, filteredAreas.get(position));
		return cell;
	}

	@Override
	public Filter getFilter() {
		
		Filter filter = new Filter(){

			@Override
			protected FilterResults performFiltering(CharSequence constraint) {
				FilterResults results = new FilterResults();

                constraint = constraint.toString().toLowerCase();
                List<AffectedArea> result = new ArrayList<AffectedArea>();
                
                for (AffectedArea area : affectedAreas) {
    				if(area.tamanName.toLowerCase().contains(constraint)){
    					result.add(area);
    				}
    			}

                results.count = result.size();
                results.values = result;

                return results;
			}

			@Override
			protected void publishResults(CharSequence constraint, FilterResults results) {
				filteredAreas = (List<AffectedArea>) results.values;
				listener.resultChanged(results.count);
                notifyDataSetChanged();
				
			}};
			
		return filter;
	}

}
