package com.bezier.app.weddingcalculator;

import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.app.Activity;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources.NotFoundException;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment4 extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.fragment4, container, false);
		TextView textView = (TextView)view.findViewById(R.id.version);
		Activity activity = getActivity();
		
		// Display the version
		try {
			textView.setText("¥Ø«eª©¥»¡Gv" + activity.getPackageManager().getPackageInfo(activity.getBaseContext().getPackageName(), 0).versionName);
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		
		TextView textViewTitle1 = (TextView)view.findViewById(R.id.title1);
		SpannableString s = null;
		try {
			s = new SpannableString(activity.getResources().getText(R.string.fragment4Title1Content));
		} catch (NotFoundException e) {
			s = new SpannableString("");
		}
	    Linkify.addLinks(s, Linkify.ALL);
	    textViewTitle1.setMovementMethod(LinkMovementMethod.getInstance());	    
	    textViewTitle1.setText(s);		
		
		return view;
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}


}
