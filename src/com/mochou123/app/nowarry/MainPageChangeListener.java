package com.mochou123.app.nowarry;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBar;
import android.util.Log;


public class MainPageChangeListener implements OnPageChangeListener {
	
	private ActionBar actionBar;
	
	
	
	public MainPageChangeListener(ActionBar actionBar) {
		super();
		this.actionBar = actionBar;
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		Log.d(this.getClass().getName(),"page scroll state change " + arg0);
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		Log.d(this.getClass().getName(), " page scrolled from " + arg0 + " to " + arg2 + " at position of " + arg1 );
	}

	@Override
	public void onPageSelected(int arg0) {
		
		actionBar.selectTab(actionBar.getTabAt(arg0));
		Log.d(this.getClass().getName(), "page selected for " + arg0);

	}

}
