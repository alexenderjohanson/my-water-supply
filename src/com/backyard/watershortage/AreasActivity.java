package com.backyard.watershortage;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;

import com.backyard.watershortag.fragment.AreasFragment;
import com.backyard.watershortage.model.AffectedArea;
import com.backyard.watershortage.model.AffectedAreaFactory.Area;
import com.backyard.watershortage.model.Reminder;
import com.backyard.watershortage.utility.Constant;

public class AreasActivity extends Activity implements
		NavigationDrawerFragment.NavigationDrawerCallbacks {

	/**
	 * Fragment managing the behaviors, interactions and presentation of the
	 * navigation drawer.
	 */
	private NavigationDrawerFragment mNavigationDrawerFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_areas);

		mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager()
				.findFragmentById(R.id.navigation_drawer);

		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));
		
		FragmentManager fragmentManager = getFragmentManager();
		fragmentManager.beginTransaction()
				.replace(R.id.container, AreasFragment.newInstance()).commit();
	}

	@Override
	public void onNavigationDrawerItemSelected(Reminder reminder) {
		

		 Intent i = new Intent(this, DetailActivity.class);
		 AffectedArea aa = new AffectedArea(Area.Gombak, reminder.areaName, reminder.zone);
		 i.putExtra("affectedArea", aa);
		 startActivity(i);
		 
		// update the main content by replacing fragments
//		FragmentManager fragmentManager = getFragmentManager();
//		fragmentManager.beginTransaction()
//				.replace(R.id.container, AreasFragment.newInstance()).commit();
	}

	public void restoreActionBar() {
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(R.string.app_name);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (!mNavigationDrawerFragment.isDrawerOpen()) {
			// Only show items in the action bar relevant to this screen
			// if the drawer is not showing. Otherwise, let the drawer
			// decide what to show in the action bar.
//			getMenuInflater().inflate(R.menu.main, menu);
			restoreActionBar();
			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
//		int id = item.getItemId();
//		if (id == R.id.action_settings) {
//			return true;
//		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
		if (!isServiceRunning()
				&& System.currentTimeMillis() < Constant.EXPIRED_DATE) {
			Intent serviceIntent = new Intent(this, WaterShortageService.class);
			this.startService(serviceIntent);
		}
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
}
