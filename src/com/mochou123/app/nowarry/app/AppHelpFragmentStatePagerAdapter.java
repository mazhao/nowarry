package com.mochou123.app.nowarry.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mochou123.app.nowarry.R;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class AppHelpFragmentStatePagerAdapter extends FragmentStatePagerAdapter {
	
	private static final List<String> appHelpNames = new ArrayList<String>();
	private static final List<Integer> appHelpImages = new ArrayList<Integer>();
	
	static {
		appHelpNames.add("1 注册");
		appHelpImages.add(R.drawable.wechat_help_1);
		
		appHelpNames.add("2 登录");
		appHelpImages.add(R.drawable.wechat_help_2);
		
		appHelpNames.add("3 添加好友");
		appHelpImages.add(R.drawable.wechat_help_3);
		
		appHelpNames.add("4 发语音");
		appHelpImages.add(R.drawable.wechat_help_4);
		
		appHelpNames.add("5 发照片");
		appHelpImages.add(R.drawable.wechat_help_5);
		
	}
	
	public AppHelpFragmentStatePagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		AppHelpFragment appHelpFragment = new AppHelpFragment();
		appHelpFragment.setName(appHelpNames.get(position));
		appHelpFragment.setImageId(appHelpImages.get(position));
		return appHelpFragment;
	}

	@Override
	public int getCount() {
		return appHelpNames.size();
	}

	
	@Override
    public CharSequence getPageTitle(int position) {
		
		if(position < 0 || position >= appHelpNames.size()) {
			return "";
		} else {
			return appHelpNames.get(position);
		}
	}
}
