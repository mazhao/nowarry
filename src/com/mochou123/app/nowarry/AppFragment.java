package com.mochou123.app.nowarry;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AppFragment extends BaseFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(
                R.layout.fragment_app, container, false);
        return rootView;
   }

	@Override
	public String getTitle() {
		return super.getResources().getString(R.string.actionBar_tab_app_name);
	}

}
