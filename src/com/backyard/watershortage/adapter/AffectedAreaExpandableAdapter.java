package com.backyard.watershortage.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.backyard.watershortage.R;
import com.backyard.watershortage.model.AffectedArea;
import com.backyard.watershortage.model.AffectedAreaFactory;
import com.backyard.watershortage.model.AffectedAreaFactory.Area;
import com.backyard.watershortage.utility.AreaHelper;
import com.backyard.watershortage.view.AffectedAreaView;

public class AffectedAreaExpandableAdapter extends BaseExpandableListAdapter {
	
	private Context context;
	private int lastPosition = -1;
	
	public AffectedAreaExpandableAdapter(Context context){
		this.context = context;
	}

	@Override
	public AffectedArea getChild(int groupPosition, int childPosition) {

		Area area = getGroup(groupPosition);
		return AffectedAreaFactory.generateAffectedArea(area, context, true).get(childPosition);
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
		
		View cell = new AffectedAreaView(context, getChild(groupPosition, childPosition));
		
//	    Animation animation = AnimationUtils.loadAnimation(context, R.anim.down_from_top);
//	    cell.startAnimation(animation);
//	    lastPosition = childPosition;

	    
		return cell;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		Area area = getGroup(groupPosition);
		return AffectedAreaFactory.generateAffectedArea(area, context, false).size();
	}

	@Override
	public Area getGroup(int groupPosition) {
		return Area.values()[groupPosition];
	}

	@Override
	public int getGroupCount() {
		return Area.values().length;
	}

	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		
		Area area = Area.values()[groupPosition];
		int stringId = AreaHelper.getAreaName(area);
				
		View cell = View.inflate(context, R.layout.area_group, null);
        ((TextView) cell.findViewById(R.id.tvGroup)).setText(stringId);
        
        List<AffectedArea> affAreas = AffectedAreaFactory.generateAffectedArea(area, context, true);
        for(AffectedArea affArea : affAreas){
        	if(affArea.selected){
        		cell.findViewById(R.id.ivStar).setVisibility(View.VISIBLE);
        	}
        }

        return cell;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return true;
	}

}
