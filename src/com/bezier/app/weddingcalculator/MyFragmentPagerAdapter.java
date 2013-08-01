package com.bezier.app.weddingcalculator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

	private static final int PAGE_COUNT = 4;
	
	public MyFragmentPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int arg0) {
		Bundle data = new Bundle();
		switch(arg0){
		case 0:
			Fragment1 fragment1 = new Fragment1();
			data.putInt("current_page", arg0+1);
			fragment1.setArguments(data);
			return fragment1;
		case 1:
			Fragment2 fragment2 = new Fragment2();
			data.putInt("current_page", arg0+1);
			fragment2.setArguments(data);
			return fragment2;
		case 2:
			Fragment3 fragment3 = new Fragment3();
			data.putInt("current_page", arg0+1);
			fragment3.setArguments(data);
			return fragment3;		
		case 3:
			Fragment4 fragment4 = new Fragment4();
			data.putInt("current_page", arg0+1);
			fragment4.setArguments(data);
			return fragment4;				
/*		case 4:
			AppleFragment appleFragment = new AppleFragment();
			data.putInt("current_page", arg0+1);
			appleFragment.setArguments(data);
			return appleFragment;	*/		
		}
		
		return null;
	}

	@Override
	public int getCount() {
		return PAGE_COUNT;
	}

}
