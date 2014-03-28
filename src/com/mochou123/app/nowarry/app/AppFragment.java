package com.mochou123.app.nowarry.app;

import com.mochou123.app.nowarry.BaseFragment;
import com.mochou123.app.nowarry.R;
import com.mochou123.app.nowarry.R.layout;
import com.mochou123.app.nowarry.R.string;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.LinearLayout;

public class AppFragment extends BaseFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(
                R.layout.fragment_app, container, false);
		ListView listView = (ListView)rootView.findViewById(R.id.appListView);
		
		
		LinearLayout headerView = (LinearLayout)inflater.inflate(R.layout.fragment_app_header, null);
		listView.addHeaderView(headerView);
		
		
		listView.setAdapter( new AppAdapter(inflater) );
		
        return rootView;
   }

	@Override
	public String getTitle() {
		return super.getResources().getString(R.string.actionBar_tab_app_name);
	}

}
