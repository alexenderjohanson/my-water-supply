package com.backyard.watershortage.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.backyard.watershortage.model.Reminder;
import com.backyard.watershortage.view.ReminderView;

public class RemindersAdapter extends BaseAdapter {

	private Context mContext;
	private List<Reminder> mReminders;
	
	public RemindersAdapter(Context context, List<Reminder> reminders){
		mContext = context;
		mReminders = reminders;
	}
	
	@Override
	public int getCount() {
		return mReminders.size();
	}

	@Override
	public Object getItem(int position) {
		return mReminders.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View cell = new ReminderView(mContext, mReminders.get(position));
		return cell;
	}

}
