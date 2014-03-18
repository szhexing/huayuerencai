package com.hexing.viewpaper;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class HX_TitleIndicatorAdapter extends FragmentPagerAdapter {
	private ArrayList<Fragment> views;
	private ArrayList<String> titles;

	public HX_TitleIndicatorAdapter(FragmentManager fm) {
		super(fm);
	}

	public void setViews(ArrayList<Fragment> views, ArrayList<String> titles) {
		this.views = views;
		this.titles = titles;
	}

	@Override
	public Fragment getItem(int position) {
		return views.get(position);
	}

	@Override
	public int getCount() {
		return views.size();
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return titles.get(position);
	}

}