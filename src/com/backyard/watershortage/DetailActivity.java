package com.backyard.watershortage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.backyard.watershortage.adapter.ZoneAdapter;
import com.backyard.watershortage.model.AffectedArea;
import com.backyard.watershortage.model.AffectedAreaHelper;

public class DetailActivity extends Activity {

	private AffectedArea affectedArea;
	private Context context;
	private ZoneAdapter adapter;
	private ListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);

		context = this;
		affectedArea = (AffectedArea) getIntent().getSerializableExtra(
				"affectedArea");

		TextView taman = (TextView) findViewById(R.id.tvTaman);
		lv = (ListView) findViewById(R.id.lvWaterShortage);
		CheckBox checkbox = (CheckBox)findViewById(R.id.cbNotification);
		
		affectedArea.selected = AffectedAreaHelper.didUserWantsNotification(this, affectedArea);
		
		if(affectedArea.selected){
			checkbox.setChecked(true);
		}
		
		checkbox.setOnCheckedChangeListener(new OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				DataStore dataStore = new DataStore(context);
				
				if(isChecked){
					dataStore.addSelectedArea(affectedArea.zone, affectedArea.tamanName);
					Toast.makeText(context, context.getText(R.string.reminder_toast), Toast.LENGTH_LONG).show();
				} else {
					dataStore.removeSelectedArea(affectedArea.zone, affectedArea.tamanName);
				}
			}
			
		});
		
		taman.setText(affectedArea.tamanName);
		setupActionBar();

		adapter = new ZoneAdapter(this, affectedArea.zone);
		lv.setAdapter(adapter);

		Animation set = AnimationUtils.loadAnimation(this, R.anim.left_from_right);
		LayoutAnimationController animCtrl = new LayoutAnimationController(set);
		lv.setLayoutAnimation(animCtrl);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		lv.setSelection(adapter.getTodayPosition());
	};

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detail, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
	        Intent upIntent = NavUtils.getParentActivityIntent(this);
	        if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
	            // This activity is NOT part of this app's task, so create a new task
	            // when navigating up, with a synthesized back stack.
	            TaskStackBuilder.create(this)
	                    // Add all of this activity's parents to the back stack
	                    .addNextIntentWithParentStack(upIntent)
	                    // Navigate up to the closest parent
	                    .startActivities();
	        } else {
	            // This activity is part of this app's task, so simply
	            // navigate up to the logical parent activity.
                upIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	            NavUtils.navigateUpTo(this, upIntent);
	        }
	        return true;
		
		case R.id.action_feedback:
			Intent intent = new Intent(Intent.ACTION_SEND);
			intent.setType("message/rfc822");
			intent.putExtra(Intent.EXTRA_SUBJECT, getText(R.string.feedback_title));
			intent.putExtra(Intent.EXTRA_EMAIL, new String[] { getText(R.string.feedback_email).toString() });
			Intent mailer = Intent.createChooser(intent, null);
			startActivity(mailer);
			return true;
		}
			
		return super.onOptionsItemSelected(item);
	}

}
