package com.backyard.watershortag.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.backyard.watershortage.DetailActivity;
import com.backyard.watershortage.R;
import com.backyard.watershortage.ResultChangeListener;
import com.backyard.watershortage.adapter.AffectedAreaAdapter;
import com.backyard.watershortage.model.AffectedArea;

public class AreasFragment extends Fragment{
	
	private TextView results;
	private AffectedAreaAdapter adapter;

    public static AreasFragment newInstance() {
    	AreasFragment fragment = new AreasFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    public AreasFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_main, container, false);
        
		EditText search = (EditText) rootView.findViewById(R.id.etSearch);
		ListView listView = (ListView) rootView.findViewById(R.id.lvArea);
		results = (TextView) rootView.findViewById(R.id.tvResults);
		
		adapter = new AffectedAreaAdapter(getActivity(), new ResultChangeListener(){

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
				
				 Intent i = new Intent(getActivity(), DetailActivity.class);
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
		
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }
    
    @Override
    public void onResume() {
    	super.onResume();
    	
    	adapter.notifyDataSetChanged();
    };
    
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
