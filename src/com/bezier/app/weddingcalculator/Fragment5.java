package com.bezier.app.weddingcalculator;

import android.support.v4.app.Fragment;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

@SuppressLint("SetJavaScriptEnabled")
public class Fragment5 extends Fragment {

	private String myURL = "http://www.google.com/";
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		WebView myBrowser = (WebView)inflater.inflate(R.layout.fragment5, container, false);
        WebSettings websettings = myBrowser.getSettings();  
        websettings.setSupportZoom(true);  
        websettings.setBuiltInZoomControls(true);   
        websettings.setJavaScriptEnabled(true);  
         
        myBrowser.setWebViewClient(new WebViewClient());  
        myBrowser.loadUrl(myURL);  
        
		return myBrowser;
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}


}
