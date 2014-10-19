package com.backyard.watershortage;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.backyard.watershortage.adapter.AffectedAreaAdapter;
import com.backyard.watershortage.model.AffectedArea;
import com.backyard.watershortage.utility.Constant;

public class MainActivity extends Activity {

	private AffectedAreaAdapter adapter;
	private TextView results;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final Context context = this;
		EditText search = (EditText) findViewById(R.id.etSearch);
		ListView listView = (ListView) findViewById(R.id.lvArea);
		results = (TextView) findViewById(R.id.tvResults);
		
		adapter = new AffectedAreaAdapter(this, new ResultChangeListener(){

			@Override
			public void resultChanged(int count) {
				updateResultCount(count);
				
			}
		});
		
		updateResultCount(adapter.getCount());
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				
				 Intent i = new Intent(context, DetailActivity.class);
				 AffectedArea aa = adapter.getItem(position);
				 i.putExtra("affectedArea", aa);
				 startActivity(i);
			}
		});

		search.addTextChangedListener(new TextWatcher() {

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				adapter.getFilter().filter(s.toString().trim());
			}

			@Override
			public void afterTextChanged(Editable s) {
				
			}
		});
		
		// ExpandableListView listView = (ExpandableListView)
		// findViewById(R.id.elvArea);
		// adapter = new AffectedAreaExpandableAdapter(this);
		// listView.setAdapter(adapter);
		//
		// listView.setOnChildClickListener(new OnChildClickListener() {
		//
		// @Override
		// public boolean onChildClick(ExpandableListView parent, View v,
		// int groupPosition, int childPosition, long id) {
		//
		// Intent i = new Intent(context, DetailActivity.class);
		// AffectedArea aa = adapter.getChild(groupPosition, childPosition);
		// i.putExtra("affectedArea", aa);
		// startActivity(i);
		//
		// return true;
		// }
		// });

		// Animation set = AnimationUtils.loadAnimation(this,
		// R.anim.up_from_bottom);
		// LayoutAnimationController animCtrl = new
		// LayoutAnimationController(set);
		// listView.setLayoutAnimation(animCtrl);

	}

	@Override
	protected void onResume() {
		super.onResume();

		if (!isServiceRunning()
				&& System.currentTimeMillis() < Constant.EXPIRED_DATE) {
			Intent serviceIntent = new Intent(this, WaterShortageService.class);
			this.startService(serviceIntent);
		}

		adapter.notifyDataSetChanged();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);

		// Associate searchable configuration with the SearchView
		SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
		SearchView searchView = (SearchView) menu.findItem(R.id.action_search)
				.getActionView();
		searchView.setSearchableInfo(searchManager
				.getSearchableInfo(getComponentName()));

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_feedback:
			Intent intent = new Intent(Intent.ACTION_SEND);
			intent.setType("message/rfc822");
			intent.putExtra(Intent.EXTRA_SUBJECT,
					getText(R.string.feedback_title));
			intent.putExtra(
					Intent.EXTRA_EMAIL,
					new String[] { getText(R.string.feedback_email).toString() });
			Intent mailer = Intent.createChooser(intent, null);
			startActivity(mailer);
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	private boolean isServiceRunning() {
		ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
		for (RunningServiceInfo service : manager
				.getRunningServices(Integer.MAX_VALUE)) {
			if (WaterShortageService.class.getName().equals(
					service.service.getClassName())) {
				return true;
			}
		}
		return false;
	}
	
	private void updateResultCount(int count){
		String numberOfResult;
		if(count <= 1){
			numberOfResult = getText(R.string.number_of_result).toString();
		} else {
			numberOfResult = getText(R.string.number_of_results).toString();
		}
		
		results.setText(String.format(numberOfResult, count));
	}

}
