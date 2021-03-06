package com.mochou123.app.nowarry.personal;

import com.mochou123.app.nowarry.R;
import com.mochou123.app.nowarry.R.layout;
import com.mochou123.app.nowarry.R.string;
import com.mochou123.app.nowarry.base.BaseFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PersonalFragment extends BaseFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(
                R.layout.fragment_personal, container, false);
        return rootView;
	}
	
	@Override
	public String getTitle() {
		return super.getResources().getString(R.string.actionBar_tab_recommand_name);
	}

}
