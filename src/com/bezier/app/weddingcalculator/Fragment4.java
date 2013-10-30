package com.bezier.app.weddingcalculator;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import android.support.v4.app.Fragment;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

@SuppressLint("SetJavaScriptEnabled")
public class Fragment4 extends Fragment {
	
	private String bezierURL = null;
	private String dataProcessString = null;
	private WebView myBrowser = null;
	private ProgressDialog pd = null;
	private LinearLayout linlaHeaderProgress = null;
	private Activity mActivity;
	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		myBrowser = (WebView)inflater.inflate(R.layout.fragment4, container, false);
        WebSettings websettings = myBrowser.getSettings();  
        websettings.setSupportZoom(true);  
        websettings.setBuiltInZoomControls(true);   
        websettings.setJavaScriptEnabled(true);  
         
        myBrowser.setWebViewClient(new WebViewClient() {

			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				
				if(!url.equalsIgnoreCase(bezierURL)) {
					startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
				}
				
				return true;
			}

			@Override
			public void onReceivedError(WebView view, int errorCode,
					String description, String failingUrl) {
			}
	
        });         
            
        bezierURL = getActivity().getResources().getText(R.string.fragment4URL).toString();        
        dataProcessString = getActivity().getResources().getText(R.string.data_processing).toString();   
        
		return myBrowser;
	}

	
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		linlaHeaderProgress = (LinearLayout) getActivity().findViewById(R.id.linlaHeaderProgress);    		
    	if(linlaHeaderProgress != null) {
    		linlaHeaderProgress.setVisibility(View.VISIBLE);
            try {
            	// check whether server is accessible. If not, we show another screen
            	HttpTestThread thread = new HttpTestThread(bezierURL);
            	thread.start();
            	
            } catch (Exception e) {
            	e.printStackTrace();
            }	     		
    	}   	

	}


	@Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
		super.setUserVisibleHint(isVisibleToUser);
		
        if (isVisibleToUser) {
            //pd = ProgressDialog.show(getActivity(), null, dataProcessString,true,false,null);
            //pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        }		
	}

    
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		mActivity = activity;
	}

	@Override
	public void onDetach() {
		// TODO Auto-generated method stub
		super.onDetach();
		mActivity = null;
	}


	private class HttpTestThread extends Thread {
		
		private HttpURLConnection connection = null;	
		private boolean success = false;
		private String urlString = null;
		private int timeout = 1500;
		
		public HttpTestThread(String urlString) {
			this.urlString = urlString;
		}
		
		public void run() {
			try {
				
				// might as well test for the url we need to access
				URL url = new URL(urlString);

				connection = (HttpURLConnection) url.openConnection();
				connection.setConnectTimeout(timeout);

				connection.connect();
				success = (connection.getResponseCode() == HttpURLConnection.HTTP_OK);
				
			} catch (IOException e) {

				success = false;
			} finally {
				if (connection != null) {
					connection.disconnect();
				}
				
				// update webview
				if(mActivity != null) {
					mActivity.runOnUiThread(new Runnable() {

						@Override
						public void run() {
							
	/*						if(pd.isShowing()) {
								pd.dismiss();
							}*/
							
							if(linlaHeaderProgress != null)
								linlaHeaderProgress.setVisibility(View.GONE);
							
				        	if(success) {
				        		myBrowser.loadUrl(bezierURL);
				        	} else {
				        		myBrowser.loadUrl("file:///android_asset/ioerror.html");
				        	}	
						}
						
					});
				}
		
			}				
		}

	}
	
}
