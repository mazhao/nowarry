package com.mochou123.app.nowarry.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mochou123.app.nowarry.R;
import com.mochou123.app.nowarry.base.BaseFragment;

public class AppHelpFragment extends BaseFragment {
	private String name;
	private int imageId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	@Override
	public String getTitle() {
		return name;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_app_help, container,
				false);

		ImageView imageView = (ImageView) rootView
				.findViewById(R.id.appHelpImageView);
		imageView.setImageResource(imageId);

		return rootView;
	}

}
