package com.mochou123.app.nowarry.app;

import java.util.ArrayList;
import java.util.List;

import com.mochou123.app.nowarry.R;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
//import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

public class AppAdapter extends BaseAdapter {

	private static final List<String> appNames = new ArrayList<String>();
	private static final List<Integer> appIcons = new ArrayList<Integer>();
	private static final List<String> appDescriptions = new ArrayList<String>();
	static {
		appNames.add("微信");
		appIcons.add(R.drawable.weichat);
		appDescriptions.add("免费聊天、发照片、打电话。");
		
		appNames.add("微博");
		appIcons.add(R.drawable.weibo);
		appDescriptions.add("时事新闻早知道，小道消息一个都不少。");

	}
	
	private LayoutInflater inflater;

	public AppAdapter(LayoutInflater inf) {
		super();
		inflater = inf;		
	}

	@Override
	public int getCount() {
		return appNames.size();
	}

	@Override
	public Object getItem(int position) {

		return appNames.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		LinearLayout row = (LinearLayout)inflater.inflate(R.layout.fragment_app_row, null);
		
		ImageView appImageView = (ImageView)row.findViewById(R.id.appImageView);
		TextView appNameTextView = (TextView)row.findViewById(R.id.appNameTextView);
		TextView appDescriptionTextView = (TextView)row.findViewById(R.id.appDescriptionTextView);
		Button appHelpButton = (Button)row.findViewById(R.id.appHelpButton);
		Button appOpenButton = (Button)row.findViewById(R.id.appOpenButton);
		
		String appName = appNames.get(position);
		int iconId = appIcons.get(position);
		String appDesc = appDescriptions.get(position);
		
		appImageView.setImageResource(iconId);
		appNameTextView.setText(appName);
		appDescriptionTextView.setText(appDesc);
		appHelpButton.setText("打开" + appName + "帮助");	
		appOpenButton.setText("打开" + appName + "应用");
		
		
		return row;
	}

}
