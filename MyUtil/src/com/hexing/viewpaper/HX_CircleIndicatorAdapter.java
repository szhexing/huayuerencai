package com.hexing.viewpaper;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class HX_CircleIndicatorAdapter extends FragmentPagerAdapter {
	private ArrayList<Fragment> views;

	public HX_CircleIndicatorAdapter(FragmentManager fm) {
		super(fm);
	}

	public void setViews(ArrayList<Fragment> views) {
		this.views = views;

	}

	@Override
	public Fragment getItem(int position) {
		return views.get(position);
	}

	@Override
	public int getCount() {
		return views.size();
	}

}