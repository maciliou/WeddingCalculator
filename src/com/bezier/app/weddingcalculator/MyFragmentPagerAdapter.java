package com.bezier.app.weddingcalculator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

	private static final int PAGE_COUNT = 5;
	private Fragment1 fragment1 = null;
	private Fragment2 fragment2 = null;
	private Fragment3 fragment3 = null;
	private Fragment4 fragment4 = null;
	private Fragment5 fragment5 = null;
	
	public MyFragmentPagerAdapter(FragmentManager fm) {
		super(fm);
		
		// init Fragment1
		Bundle data1 = new Bundle();
		fragment1 = new Fragment1();
		data1.putInt("current_page", 1);
		fragment1.setArguments(data1);	
		
		// init Fragment2
		Bundle data2 = new Bundle();
		fragment2 = new Fragment2();
		data2.putInt("current_page", 2);
		fragment2.setArguments(data2);		
		
		// init Fragment3
		Bundle data3 = new Bundle();
		fragment3 = new Fragment3();
		data3.putInt("current_page", 3);
		fragment3.setArguments(data3);	
		
		// init Fragment4
		Bundle data4 = new Bundle();
		fragment4 = new Fragment4();
		data4.putInt("current_page", 4);
		fragment4.setArguments(data4);	
		
		// init Fragment5
		Bundle data5 = new Bundle();
		fragment5 = new Fragment5();
		data5.putInt("current_page", 5);
		fragment5.setArguments(data5);			
	}

	@Override
	public Fragment getItem(int arg0) {
		Bundle data = new Bundle();
		switch(arg0){
		case 0:
			return fragment1;
		case 1:
			return fragment2;
		case 2:
			return fragment3;		
		case 3:
			return fragment4;	
		case 4:
			return fragment5;		
		}
		
		return null;
	}

	@Override
	public int getCount() {
		return PAGE_COUNT;
	}

}
