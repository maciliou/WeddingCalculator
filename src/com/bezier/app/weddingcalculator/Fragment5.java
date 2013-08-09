package com.bezier.app.weddingcalculator;

import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources.NotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Fragment5 extends Fragment {

	private Activity activity;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		activity = getActivity();
		
		View view = inflater.inflate(R.layout.fragment5, container, false);
		TextView textView = (TextView)view.findViewById(R.id.version);
		
		// Display the version
		try {
			textView.setText(activity.getResources().getText(R.string.currentVersion) + activity.getPackageManager().getPackageInfo(activity.getBaseContext().getPackageName(), 0).versionName);
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
	      
	    Button button = (Button)view.findViewById(R.id.loanButton);
	    button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_VIEW);
				intent.addCategory(Intent.CATEGORY_BROWSABLE);
				intent.setData(Uri.parse(activity.getResources().getText(R.string.fragment5ButtonLink).toString()));
				startActivity(intent);
			}
	    });
	    
		return view;
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}


}
