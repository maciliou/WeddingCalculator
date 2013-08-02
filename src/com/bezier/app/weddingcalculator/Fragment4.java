package com.bezier.app.weddingcalculator;

import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.app.Activity;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Fragment4 extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.fragment4, container, false);
		TextView textView = (TextView)view.findViewById(R.id.textView2);
		Activity activity = getActivity();
		try {
			textView.append("\nv" + activity.getPackageManager().getPackageInfo(activity.getBaseContext().getPackageName(), 0).versionName);
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return view;
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}


}
