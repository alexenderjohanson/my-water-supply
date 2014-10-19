package com.backyard.watershortage;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.backyard.watershortage.adapter.SearchableAdapter;
import com.backyard.watershortage.model.AffectedArea;
import com.backyard.watershortage.model.AffectedAreaFactory;

public class SearchableActvity extends Activity{

	private SearchableAdapter adapter;
	private static List<AffectedArea> areas;
	private Context context;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_searchable);
		
		context = this;
		getActionBar().setDisplayHomeAsUpEnabled(true);
        
        ListView listView = (ListView)findViewById(R.id.lvSearable);
        adapter = new SearchableAdapter(this);
        listView.setAdapter(adapter);
        
        listView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View v, int position, long id) {
				Intent i = new Intent(context, DetailActivity.class);
				AffectedArea aa = (AffectedArea)adapter.getItem(position);
				i.putExtra("affectedArea", aa);
				startActivity(i);
				
			}
        	
        });
        
        handleIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
    	super.onNewIntent(intent);
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {

    	if(areas == null){
        	areas = AffectedAreaFactory.generateAllArea(null, false);
        }
    	
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY).toLowerCase();
            
            List<AffectedArea> result = new ArrayList<AffectedArea>();
            for (AffectedArea area : areas) {
				if(area.tamanName.toLowerCase().contains(query)){
					result.add(area);
				}
			}
            
            adapter.SetResult(result);
            adapter.notifyDataSetChanged();
            
            String actionBarText;
            if(result.size() == 0){
            	actionBarText = getText(R.string.search_no_result).toString();
            }else{
            	actionBarText = String.format(getText(R.string.search_result).toString(), result.size());
            }
            
            getActionBar().setTitle(actionBarText);
            //use the query to search your data somehow
        }
    }
}
