package com.mochou123.app.nowarry.app;

import java.util.ArrayList;
import java.util.List;

import com.mochou123.app.nowarry.R;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
/**
 * appItem.setPackageName("com.tencent.mm");
 * appItem.setMainActivityName("LauncherUI");
 * Intent LaunchIntent = AppAdapter.this.activity.getPackageManager().getLaunchIntentForPackage(app.getPackageName());
 * AppAdapter.this.activity.startActivity(LaunchIntent);
 * 			
 * @author mazhao
 *
 */
public class AppAdapter extends BaseAdapter {

	private static final List<String> appNames = new ArrayList<String>();
	private static final List<Integer> appIcons = new ArrayList<Integer>();
	private static final List<String> appDescriptions = new ArrayList<String>();
	private static final List<String> appPackageNames = new ArrayList<String>();
	
	static {
		appNames.add("微信");
		appIcons.add(R.drawable.weichat);
		appDescriptions.add("免费聊天、发照片、打电话。");
		appPackageNames.add("com.tencent.mm");
		
		appNames.add("微博");
		appIcons.add(R.drawable.weibo);
		appDescriptions.add("时事新闻早知道，小道消息一个都不少。");
		appPackageNames.add("com.sina.weibo");
	}
	
	private LayoutInflater inflater;
	private Fragment fragment;

	public AppAdapter(LayoutInflater inf, Fragment frag) {
		super();
		inflater = inf;		
		fragment = frag;
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
		
		final String appName = appNames.get(position);
		final int iconId = appIcons.get(position);
		final String appDesc = appDescriptions.get(position);
		final String appPackageName = appPackageNames.get(position);
		
		// 显示属性设置
		appImageView.setImageResource(iconId);
		appNameTextView.setText(appName);
		appDescriptionTextView.setText(appDesc);
		appHelpButton.setText("打开" + appName + "帮助");	
		appOpenButton.setText("打开" + appName + "应用");
		
		// 事件处理设置
		appHelpButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d(AppAdapter.class.getName(),
						"open help button clicked for " + appName);
				
				Intent intent = new Intent(fragment.getActivity().getApplicationContext(), AppHelpActivity.class);
				fragment.startActivity(intent);
				
			}
		});
		
		appOpenButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d(AppAdapter.class.getName(), "open app button clicked for " + appName + " with package name " + appPackageName);
				Intent launchIntent = fragment.getActivity().getPackageManager().getLaunchIntentForPackage(appPackageName);
				fragment.startActivity(launchIntent);
			}
		});
		
		return row;
	}

}
