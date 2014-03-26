package com.mochou123.app.nowarry;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class MainFragmentStatePagerAdapter extends FragmentStatePagerAdapter {

	private static List<BaseFragment> fragmentList = new ArrayList<BaseFragment>();
	static {
		fragmentList.add(new AppFragment());
		fragmentList.add(new RecommandFragment());
		fragmentList.add(new PersonalFragment());
		
	}
	
	public MainFragmentStatePagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int i) {
		
		BaseFragment f = (BaseFragment)fragmentList.get(i);
        Bundle args = new Bundle();
        f.setArguments(args);
		return f;
	}

	@Override
	public int getCount() {
		return fragmentList.size();
	}
	
	@Override
    public CharSequence getPageTitle(int position) {
        return fragmentList.get(position).getTitle();
    }
	
}
