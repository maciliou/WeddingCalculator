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
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ShareActionProvider;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.*;
import com.facebook.model.*;
import com.facebook.widget.WebDialog;
import com.facebook.widget.WebDialog.OnCompleteListener;

public class MainActivity extends FragmentActivity {

	private EditText editTextGroup1_01;
	private EditText editTextGroup2_01;
	private EditText editTextGroup2_02;
	private EditText editTextGroup3_01;
	private EditText editTextGroup3_02;
	private EditText editTextGroup3_03;
	private EditText editTextGroup3_04;
	private EditText editTextGroup3_05;
	private EditText editTextGroup3_06;
	private EditText editTextGroup4_01;
	private EditText editTextGroup4_02;
	private EditText editTextGroup4_03;
	private EditText editTextGroup4_04;
	private EditText editTextGroup4_05;
	private EditText editTextGroup4_06;
	private EditText editTextGroup4_07;
	private EditText editTextGroup4_08;
	private EditText editTextGroup5_01;
	private EditText editTextGroup6_01;
	private TextView textViewTotalAmount;
	private long valueOfEditTextGroup1_01;
	private long valueOfEditTextGroup2_01;
	private long valueOfEditTextGroup2_02;
	private long valueOfEditTextGroup3_01;
	private long valueOfEditTextGroup3_02;
	private long valueOfEditTextGroup3_03;
	private long valueOfEditTextGroup3_04;
	private long valueOfEditTextGroup3_05;
	private long valueOfEditTextGroup3_06;
	private long valueOfEditTextGroup4_01;
	private long valueOfEditTextGroup4_02;
	private long valueOfEditTextGroup4_03;	
	private long valueOfEditTextGroup4_04;	
	private long valueOfEditTextGroup4_05;	
	private long valueOfEditTextGroup4_06;	
	private long valueOfEditTextGroup4_07;	
	private long valueOfEditTextGroup4_08;	
	private long valueOfEditTextGroup5_01;	
	private long valueOfEditTextGroup6_01;		
	private long total;
	
	private ShareActionProvider mShareActionProvider;
	ActionBar mActionBar;
    ViewPager mPager;
    
    
    
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		Session.getActiveSession().onActivityResult(this, requestCode, resultCode, data);
	}


	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
/*		Button button = (Button)findViewById(R.id.button1);
		button.setOnClickListener(buttonListener);
		
		//�B����v��§�A
		editTextGroup1_01 = (EditText)findViewById(R.id.editTextGroup1_01);
		//����§�~
		editTextGroup2_01 = (EditText)findViewById(R.id.editTextGroup2_01);
		//�C�H§
		editTextGroup2_02 = (EditText)findViewById(R.id.editTextGroup2_02);
		//����§ / �Q�G��§
		editTextGroup3_01 = (EditText)findViewById(R.id.editTextGroup3_01);
		//"�q�B���]§"
		editTextGroup3_02 = (EditText)findViewById(R.id.editTextGroup3_02);
		//�q�B�b
		editTextGroup3_03 = (EditText)findViewById(R.id.editTextGroup3_03);
		//�B��
		editTextGroup3_04 = (EditText)findViewById(R.id.editTextGroup3_04);
		//�߻�
		editTextGroup3_05 = (EditText)findViewById(R.id.editTextGroup3_05);	
		//�u��
		editTextGroup3_06 = (EditText)findViewById(R.id.editTextGroup3_06);
		//�ߩ��L�s�H�o(�t�l��B�q�ܶO�K)
		editTextGroup4_01 = (EditText)findViewById(R.id.editTextGroup4_01);
		//�߮b�s�u
		editTextGroup4_02 = (EditText)findViewById(R.id.editTextGroup4_02);
		//���a�G�m
		editTextGroup4_03 = (EditText)findViewById(R.id.editTextGroup4_03);
		//§��(�ˤ������L��)
		editTextGroup4_04 = (EditText)findViewById(R.id.editTextGroup4_04);	
		//���e�B�s�Q����
		editTextGroup4_05 = (EditText)findViewById(R.id.editTextGroup4_05);	
		//�����t��(�c�B�ݪ�K)
		editTextGroup4_06 = (EditText)findViewById(R.id.editTextGroup4_06);	
		//���B���]��
		editTextGroup4_07 = (EditText)findViewById(R.id.editTextGroup4_07);	
		//�B§���v����v
		editTextGroup4_08 = (EditText)findViewById(R.id.editTextGroup4_08);	
		//�e��Ȧ�
		editTextGroup5_01 = (EditText)findViewById(R.id.editTextGroup5_01);
		//��L����
		editTextGroup6_01 = (EditText)findViewById(R.id.editTextGroup6_01);		
		//�`���B
		textViewTotalAmount = (TextView)findViewById(R.id.textViewTotalAmount);*/
		
		// init each value
		valueOfEditTextGroup1_01 = 0;
		valueOfEditTextGroup2_01 = 0;
		valueOfEditTextGroup2_02 = 0;
		valueOfEditTextGroup3_01 = 0;
		valueOfEditTextGroup3_02 = 0;
		valueOfEditTextGroup3_03 = 0;
		valueOfEditTextGroup3_04 = 0;
		valueOfEditTextGroup3_05 = 0;
		valueOfEditTextGroup3_06 = 0;
		valueOfEditTextGroup4_01 = 0;
		valueOfEditTextGroup4_02 = 0;
		valueOfEditTextGroup4_03 = 0;
		valueOfEditTextGroup4_04 = 0;
		valueOfEditTextGroup4_05 = 0;
		valueOfEditTextGroup4_06 = 0;
		valueOfEditTextGroup4_07 = 0;
		valueOfEditTextGroup4_08 = 0;
		valueOfEditTextGroup5_01 = 0;
		valueOfEditTextGroup6_01 = 0;	
		total = 0;
		
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
        
/*		tab = mActionBar.newTab()
				.setText("Apple")
				.setTabListener(tabListener);
        mActionBar.addTab(tab);*/
		
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
/*		mShareActionProvider = (ShareActionProvider) menu.findItem(R.id.menu_share).getActionProvider();

	    // If you use more than one ShareActionProvider, each for a different action,
	    // use the following line to specify a unique history file for each one.
	    // mShareActionProvider.setShareHistoryFileName("custom_share_history.xml");

	    // Set the default share intent
	    mShareActionProvider.setShareIntent(getDefaultShareIntent());		*/
		return true;
	}
	
	private Intent getDefaultShareIntent() {
	        Intent intent = new Intent(Intent.ACTION_SEND);
	        intent.setType("text/plain");
	        intent.putExtra(Intent.EXTRA_SUBJECT, "SUBJECT");
	        intent.putExtra(Intent.EXTRA_TEXT,"Extra Text");
	        return intent;
	}
	 
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getItemId() == R.id.action_settings) {
			
		} else if(item.getItemId() == R.id.action_like) {
			// start Facebook Login
			  Session.openActiveSession(this, true, new Session.StatusCallback() {

				@Override
				public void call(Session session, SessionState state,
						Exception exception) {
					
					Log.i("log_tag", "Token=" + session.getAccessToken());
		            Log.i("log_tag", "Token=" + session.isOpened());
		            
					if(session.isOpened()) {
						// make request to the /me API
						//Request request = new Request(Session.getActiveSession(), "me/feed", params, HttpMethod.POST);
						
						Request.executeMeRequestAsync(session, new Request.GraphUserCallback() {

						  // callback after Graph API response with user object
						  @Override
						  public void onCompleted(GraphUser user, Response response) {
							  if(user != null) {
									Bundle params = new Bundle();
									params.putString("caption", "�жU�p���");
									params.putString("message", "�i�жU�p����j �ֳt�պ�жU�Q�v�Ĥ@����A�O�ʫΡB���B�򤶤��i�ʪ��p�u��");
									params.putString("link", "https://play.google.com/store/apps/details?id=com.bezier.app.loancalculator");
									params.putString("picture", "https://drive.google.com/uc?export=view&id=0BxQow9kRw_AHOEtqRGk1U18xSWc");					
									
									WebDialog feedDialog = (
									        new WebDialog.FeedDialogBuilder(MainActivity.this,
									            Session.getActiveSession(),
									            params))
									        .setOnCompleteListener(new OnCompleteListener(){

												@Override
												public void onComplete(Bundle values,
														FacebookException error) {
									                if (error == null) {
									                    // When the story is posted, echo the success
									                    // and the post Id.
									                    final String postId = values.getString("post_id");
									                    if (postId != null) {
									                        Toast.makeText(MainActivity.this,
									                            "�w���ɦ��y��",
									                            Toast.LENGTH_LONG).show();
									                    }
									                }
													
												}})
									        .build();
									    feedDialog.show();								  
								  //Toast.makeText(MainActivity.this, user.getName() + "���g!!!", Toast.LENGTH_SHORT).show();	
							  }					  
						  }
						});						
											
					}
				}
				  
			  });
		}
		return super.onOptionsItemSelected(item);
	}

	public OnClickListener buttonListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			/*
			if(v.getId() == R.id.button1) {
				total = 0;
				try {
					valueOfEditTextGroup1_01 = Integer.valueOf(editTextGroup1_01.getText().toString());
				} catch(NumberFormatException e) {
					Toast.makeText(MainActivity.this, "�B����v��§�A ���ର��", Toast.LENGTH_SHORT).show();  
					return;
				}
				
				try {
					valueOfEditTextGroup2_01 = Integer.valueOf(editTextGroup2_01.getText().toString());
				} catch(NumberFormatException e) {
					Toast.makeText(MainActivity.this, "����§�~ ���ର��", Toast.LENGTH_SHORT).show();  
					return;
				}
				
				try {
					valueOfEditTextGroup2_02 = Integer.valueOf(editTextGroup2_02.getText().toString());
				} catch(NumberFormatException e) {
					Toast.makeText(MainActivity.this, "�B�C�H§  ���ର��", Toast.LENGTH_SHORT).show();  
					return;
				}
				
				try {
					valueOfEditTextGroup3_01 = Integer.valueOf(editTextGroup3_01.getText().toString());
				} catch(NumberFormatException e) {
					Toast.makeText(MainActivity.this, "����§ / �Q�G��§ ���ର��", Toast.LENGTH_SHORT).show();  
					return;
				}
				
				try {
					valueOfEditTextGroup3_02 = Integer.valueOf(editTextGroup3_02.getText().toString());
				} catch(NumberFormatException e) {
					Toast.makeText(MainActivity.this, "�q�B���]§ ���ର��", Toast.LENGTH_SHORT).show();  
					return;
				}
				
				try {
					valueOfEditTextGroup3_03 = Integer.valueOf(editTextGroup3_03.getText().toString());
				} catch(NumberFormatException e) {
					Toast.makeText(MainActivity.this, "�q�B�b  ���ର��", Toast.LENGTH_SHORT).show();  
					return;
				}
				
				try {
					valueOfEditTextGroup3_04 = Integer.valueOf(editTextGroup3_04.getText().toString());
				} catch(NumberFormatException e) {
					Toast.makeText(MainActivity.this, "�B�B�� ���ର��", Toast.LENGTH_SHORT).show();  
					return;
				}
				
				try {
					valueOfEditTextGroup3_05 = Integer.valueOf(editTextGroup3_05.getText().toString());
				} catch(NumberFormatException e) {
					Toast.makeText(MainActivity.this, "�߻�  ���ର��", Toast.LENGTH_SHORT).show();  
					return;
				}
				
				try {
					valueOfEditTextGroup3_06 = Integer.valueOf(editTextGroup3_06.getText().toString());
				} catch(NumberFormatException e) {
					Toast.makeText(MainActivity.this, "�u��  ���ର��", Toast.LENGTH_SHORT).show();  
					return;
				}
				
				try {
					valueOfEditTextGroup4_01 = Integer.valueOf(editTextGroup4_01.getText().toString());
				} catch(NumberFormatException e) {
					Toast.makeText(MainActivity.this, "�ߩ��L�s�H�o(�t�l��B�q�ܶO�K)  ���ର��", Toast.LENGTH_SHORT).show();  
					return;
				}
				
				try {
					valueOfEditTextGroup4_02 = Integer.valueOf(editTextGroup4_02.getText().toString());
				} catch(NumberFormatException e) {
					Toast.makeText(MainActivity.this, "�߮b�s�u  ���ର��", Toast.LENGTH_SHORT).show();  
					return;
				}
				
				try {
					valueOfEditTextGroup4_03 = Integer.valueOf(editTextGroup4_03.getText().toString());
				} catch(NumberFormatException e) {
					Toast.makeText(MainActivity.this, "���a�G�m  ���ର��", Toast.LENGTH_SHORT).show();  
					return;
				}
				
				try {
					valueOfEditTextGroup4_04 = Integer.valueOf(editTextGroup4_04.getText().toString());
				} catch(NumberFormatException e) {
					Toast.makeText(MainActivity.this, "�B���e�B�s�Q����  ���ର��", Toast.LENGTH_SHORT).show();  
					return;
				}
				
				try {
					valueOfEditTextGroup4_05 = Integer.valueOf(editTextGroup4_05.getText().toString());
				} catch(NumberFormatException e) {
					Toast.makeText(MainActivity.this, "�B����v��§�A ���ର��", Toast.LENGTH_SHORT).show();  
					return;
				}
				
				try {
					valueOfEditTextGroup4_06 = Integer.valueOf(editTextGroup4_06.getText().toString());
				} catch(NumberFormatException e) {
					Toast.makeText(MainActivity.this, "�����t��(�c�B�ݪ�K) ���ର��", Toast.LENGTH_SHORT).show();  
					return;
				}
				
				try {
					valueOfEditTextGroup4_07 = Integer.valueOf(editTextGroup4_07.getText().toString());
				} catch(NumberFormatException e) {
					Toast.makeText(MainActivity.this, "���B���]��  ���ର��", Toast.LENGTH_SHORT).show();  
					return;
				}
				
				try {
					valueOfEditTextGroup4_08 = Integer.valueOf(editTextGroup4_08.getText().toString());
				} catch(NumberFormatException e) {
					Toast.makeText(MainActivity.this, "�B§���v����v  ���ର��", Toast.LENGTH_SHORT).show();  
					return;
				}
				
				try {
					valueOfEditTextGroup5_01 = Integer.valueOf(editTextGroup5_01.getText().toString());
				} catch(NumberFormatException e) {
					Toast.makeText(MainActivity.this, "�e��Ȧ�  ���ର��", Toast.LENGTH_SHORT).show();  
					return;
				}
				
				try {
					valueOfEditTextGroup6_01 = Integer.valueOf(editTextGroup6_01.getText().toString());
				} catch(NumberFormatException e) {
					Toast.makeText(MainActivity.this, "��L���� ���ର��", Toast.LENGTH_SHORT).show();  
					return;
				}		

				total += valueOfEditTextGroup1_01;
				total += valueOfEditTextGroup2_01;
				total += valueOfEditTextGroup2_02;
				total += valueOfEditTextGroup3_01;
				total += valueOfEditTextGroup3_02;
				total += valueOfEditTextGroup3_03;
				total += valueOfEditTextGroup3_04;
				total += valueOfEditTextGroup3_05;
				total += valueOfEditTextGroup3_06;
				total += valueOfEditTextGroup4_01;
				total += valueOfEditTextGroup4_02;
				total += valueOfEditTextGroup4_03;
				total += valueOfEditTextGroup4_04;
				total += valueOfEditTextGroup4_05;
				total += valueOfEditTextGroup4_06;
				total += valueOfEditTextGroup4_07;
				total += valueOfEditTextGroup4_08;
				total += valueOfEditTextGroup5_01;
				total += valueOfEditTextGroup6_01;
				
				textViewTotalAmount.setText(String.valueOf(total));
			}*/
		}
	};

}
