package com.bezier.app.weddingcalculator;

import android.support.v4.app.Fragment;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

@SuppressLint("SetJavaScriptEnabled")
public class Fragment4 extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		WebView myBrowser = (WebView)inflater.inflate(R.layout.fragment4, container, false);
        WebSettings websettings = myBrowser.getSettings();  
        websettings.setSupportZoom(true);  
        websettings.setBuiltInZoomControls(true);   
        websettings.setJavaScriptEnabled(true);  
         
        myBrowser.setWebViewClient(new WebViewClient() {

			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
				return true;
			}
        	
        });            
        myBrowser.loadUrl(getActivity().getResources().getText(R.string.fragment4URL).toString());  
        
		return myBrowser;
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}


}
