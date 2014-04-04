package com.mochou123.app.nowarry.app;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.mochou123.app.nowarry.R;

public class AppHelpActivity extends ActionBarActivity {

	private AppHelpFragmentStatePagerAdapter appHelpFragmentStatePagerAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_app_help);

		initViewPager();
		initActionBar();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.app_help, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	// ========== init view pager ==========

	private void initViewPager() {
		appHelpFragmentStatePagerAdapter = new AppHelpFragmentStatePagerAdapter(
				super.getSupportFragmentManager());
		ViewPager viewPager = (ViewPager) super.findViewById(R.id.appHelper);
		viewPager.setAdapter(appHelpFragmentStatePagerAdapter);
		viewPager.setOnPageChangeListener(new AppHelpOnPageChangeListener());
	}

	private void initActionBar() {

		ActionBar actionBar = super.getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		AppHelpTabListener aptl = new AppHelpTabListener();
		
		for (int i = 0; i < appHelpFragmentStatePagerAdapter.getCount(); i++) {
			Tab tabHelp = actionBar.newTab();
			tabHelp.setText(appHelpFragmentStatePagerAdapter.getPageTitle(i));
			tabHelp.setTabListener(aptl);
			actionBar.addTab(tabHelp);
		}

	}
}
