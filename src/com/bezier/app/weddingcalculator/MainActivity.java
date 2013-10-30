package com.bezier.app.weddingcalculator;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.bezier.app.weddingcalculator.R;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

import com.facebook.*;
import com.facebook.model.*;
import com.facebook.widget.WebDialog;
import com.facebook.widget.WebDialog.OnCompleteListener;

public class MainActivity extends FragmentActivity {
	
	private ActionBar mActionBar;
    private ViewPager mPager;    
    
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		Session.getActiveSession().onActivityResult(this, requestCode, resultCode, data);
	}

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// enable these two lines will show the progress spinner on actionbar
        //requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);          
		setContentView(R.layout.activity_main);		
		//setProgressBarIndeterminateVisibility(true);
				
		mActionBar = getActionBar();
		mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		/** Getting a reference to ViewPager from the layout */
        mPager = (ViewPager) findViewById(R.id.pager);
        
        /** Getting a reference to FragmentManager */
        FragmentManager fm = getSupportFragmentManager();
        
        ViewPager.SimpleOnPageChangeListener pageChangeListener = new ViewPager.SimpleOnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				super.onPageSelected(position);
				mActionBar.setSelectedNavigationItem(position);
			}
        	
        };
        
        mPager.setOnPageChangeListener(pageChangeListener);
        
        MyFragmentPagerAdapter fragmentPagerAdapter = new MyFragmentPagerAdapter(fm);
        
        mPager.setAdapter(fragmentPagerAdapter);
        
        mActionBar.setDisplayShowTitleEnabled(true);
        
        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
			
			@Override
			public void onTabUnselected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onTabSelected(Tab tab, FragmentTransaction ft) {
				mPager.setCurrentItem(tab.getPosition());
			}
			
			@Override
			public void onTabReselected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				
			}
		};
		
		Tab tab = mActionBar.newTab()
				.setText(MainActivity.this.getResources().getText(R.string.Fragment1))
				.setTabListener(tabListener);
		mActionBar.addTab(tab);
		
		tab = mActionBar.newTab()
				.setText(MainActivity.this.getResources().getText(R.string.Fragment2))
				.setTabListener(tabListener);
        mActionBar.addTab(tab);
        
		tab = mActionBar.newTab()
				.setText(MainActivity.this.getResources().getText(R.string.Fragment3))
				.setTabListener(tabListener);
        mActionBar.addTab(tab);
        
		tab = mActionBar.newTab()
				.setText(MainActivity.this.getResources().getText(R.string.Fragment4))
				.setTabListener(tabListener);
        mActionBar.addTab(tab);
		
		tab = mActionBar.newTab()
				.setText(MainActivity.this.getResources().getText(R.string.Fragment5))
				.setTabListener(tabListener);
        mActionBar.addTab(tab);
        
        //setup ActionBar background color
        mActionBar.setStackedBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.tab_background)));
        mActionBar.setSplitBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.tab_slider)));
        
        // Add code to print out the key hash
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.bezier.app.weddingcalculator", 
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.i("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
                }
        } catch (NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }    
		
    
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	 
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		if (item.getItemId() == R.id.action_like) {
			// start Facebook Login
			Session.openActiveSession(this, true, new Session.StatusCallback() {

				@Override
				public void call(Session session, SessionState state,
						Exception exception) {

					Log.i("log_tag", "Token=" + session.getAccessToken());
					Log.i("log_tag", "Token=" + session.isOpened());

					if (session.isOpened()) {
						// make request to the /me API
						// Request request = new
						// Request(Session.getActiveSession(), "me/feed",
						// params, HttpMethod.POST);

						Request.executeMeRequestAsync(session,
								new Request.GraphUserCallback() {

									// callback after Graph API response with
									// user object
									@Override
									public void onCompleted(GraphUser user,
											Response response) {
										if (user != null) {
											Bundle params = new Bundle();
											params.putString("caption", MainActivity.this.getResources().getText(R.string.facebookCaption).toString());
											params.putString("message", MainActivity.this.getResources().getText(R.string.facebookMessage).toString());
											params.putString("link", "https://play.google.com/store/apps/details?id=com.bezier.app.weddingcalculator");
											params.putString("picture", "https://drive.google.com/uc?export=view&id=0BxQow9kRw_AHUnZmbVFmWHdIUW8");

											WebDialog feedDialog = (new WebDialog.FeedDialogBuilder(
													MainActivity.this,
													Session.getActiveSession(),
													params))
													.setOnCompleteListener(
															new OnCompleteListener() {

																@Override
																public void onComplete(
																		Bundle values,
																		FacebookException error) {
																	if (error == null) {
																		final String postId = values.getString("post_id");
																		if (postId != null) {
																			Toast.makeText(MainActivity.this, MainActivity.this.getResources().getText(R.string.facebookSharedMessage).toString(), Toast.LENGTH_LONG).show();
																		}
																	}

																}
															}).build();
											feedDialog.show();
										}
									}
								});
					}
				}

			});
		}
		return super.onOptionsItemSelected(item);
	}

}
