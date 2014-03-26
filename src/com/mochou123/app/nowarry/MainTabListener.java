package com.mochou123.app.nowarry;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.util.Log;

final class MainTabListener implements ActionBar.TabListener {
	
	private ViewPager viewPager;
	
	
	public MainTabListener(ViewPager viewPager) {
		super();
		this.viewPager = viewPager;
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction arg1) {
		// uninitialize
		Log.d(MainActivity.class.getName(), "tab " + tab.getText() + " unselected");
	}
	
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction arg1) {
		// initialize
		Log.d(MainActivity.class.getName(), "tab " + tab.getText() + " selected");
		
		viewPager.setCurrentItem(tab.getPosition(), true);
		
	}
	
	@Override
	public void onTabReselected(Tab tab, FragmentTransaction arg1) {
		// reinitialize
		Log.d(MainActivity.class.getName(), "tab " + tab.getText() + " reselected");

	}
}