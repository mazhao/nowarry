package com.mochou123.app.nowarry;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {
	private MainFragmentStatePagerAdapter pagerAdapter ;
    private ViewPager viewPager;
    private ActionBar actionBar;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // action bar
        initVIewPager();
        initActionBar(); // 1st pager 2nd action bar.
    }

	

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    // ------------------------------------------------
    // Action Bar Section
    // ------------------------------------------------
    
	private void initActionBar() {
		actionBar = super.getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        
        Tab tabApp = actionBar.newTab();
        tabApp.setText(R.string.actionBar_tab_app_name);
        
        
        Tab tabRecommand = actionBar.newTab();
        tabRecommand.setText(R.string.actionBar_tab_recommand_name); 
        
        Tab tabPersonal = actionBar.newTab();
        tabPersonal.setText(R.string.actionBar_tab_personal_name);
        
        
        MainTabListener mtl = new MainTabListener(viewPager);
        tabApp.setTabListener(mtl);
        tabRecommand.setTabListener(mtl);
        tabPersonal.setTabListener(mtl);
        
        actionBar.addTab(tabApp);
        actionBar.addTab(tabRecommand);
        actionBar.addTab(tabPersonal);
	}
	
	// ------------------------------------------------
    // View Pager Section
    // ------------------------------------------------
    
	private void initVIewPager() {
		pagerAdapter = new MainFragmentStatePagerAdapter(super.getSupportFragmentManager());
        viewPager = (ViewPager)super.findViewById(R.id.pager);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOnPageChangeListener(new MainPageChangeListener( super.getSupportActionBar() ));
	}
	
	// ------------------------------------------------
    // Connection between View Pager and Action Bar.
    // ------------------------------------------------
    
}
