package com.bezier.app.weddingcalculator;

import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment1 extends Fragment {

	private EditText editTextGroup1_01;
	private EditText editTextGroup2_01;
	private EditText editTextGroup2_02;
	private EditText editTextGroup3_01;
	private EditText editTextGroup3_02;
	private EditText editTextGroup3_03;
	private EditText editTextGroup3_04;
	private EditText editTextGroup3_05;
	private EditText editTextGroup3_06;
	private EditText editTextGroup3_07;
	private EditText editTextGroup3_08;
	private EditText editTextGroup3_09;
	private EditText editTextGroup3_10;
	private EditText editTextGroup3_11;	
	private EditText editTextGroup4_01;
	private EditText editTextGroup4_02;
	private EditText editTextGroup4_03;
	private EditText editTextGroup4_04;
	private EditText editTextGroup4_05;
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
	private long valueOfEditTextGroup3_07;
	private long valueOfEditTextGroup3_08;
	private long valueOfEditTextGroup3_09;
	private long valueOfEditTextGroup3_10;
	private long valueOfEditTextGroup3_11;	
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
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment1, container, false);
		
		Button button = (Button)view.findViewById(R.id.button1);
		button.setOnClickListener(buttonListener);
		
		//婚紗攝影及禮服
		editTextGroup1_01 = (EditText)view.findViewById(R.id.editTextGroup1_01);
		//提親禮品
		editTextGroup2_01 = (EditText)view.findViewById(R.id.editTextGroup2_01);
		//媒人禮
		editTextGroup2_02 = (EditText)view.findViewById(R.id.editTextGroup2_02);
		//六樣禮 / 十二樣禮
		editTextGroup3_01 = (EditText)view.findViewById(R.id.editTextGroup3_01);
		//"訂婚紅包禮"
		editTextGroup3_02 = (EditText)view.findViewById(R.id.editTextGroup3_02);
		//訂婚宴
		editTextGroup3_03 = (EditText)view.findViewById(R.id.editTextGroup3_03);
		//婚戒
		editTextGroup3_04 = (EditText)view.findViewById(R.id.editTextGroup3_04);
		//喜餅
		editTextGroup3_05 = (EditText)view.findViewById(R.id.editTextGroup3_05);	
		//聘金
		editTextGroup3_06 = (EditText)view.findViewById(R.id.editTextGroup3_06);
		//金飾
		editTextGroup3_07 = (EditText)view.findViewById(R.id.editTextGroup3_07);
		//錄影及攝影
		editTextGroup3_08 = (EditText)view.findViewById(R.id.editTextGroup3_08);
		//新娘秘書
		editTextGroup3_09 = (EditText)view.findViewById(R.id.editTextGroup3_09);
		//場地佈置
		editTextGroup3_10 = (EditText)view.findViewById(R.id.editTextGroup3_10);
		//訂婚喜帖印製
		editTextGroup3_11 = (EditText)view.findViewById(R.id.editTextGroup3_11);
		//喜帖印製寄發(含郵資、電話費…)
		editTextGroup4_01 = (EditText)view.findViewById(R.id.editTextGroup4_01);
		//喜宴酒席
		editTextGroup4_02 = (EditText)view.findViewById(R.id.editTextGroup4_02);
		//場地佈置
		editTextGroup4_03 = (EditText)view.findViewById(R.id.editTextGroup4_03);
		//禮車(親友幫忙無價)
		editTextGroup4_04 = (EditText)view.findViewById(R.id.editTextGroup4_04);	
		//美容、新娘秘書
		editTextGroup4_05 = (EditText)view.findViewById(R.id.editTextGroup4_05);	
		//結婚紅包類
		editTextGroup4_07 = (EditText)view.findViewById(R.id.editTextGroup4_07);	
		//婚禮錄影及攝影
		editTextGroup4_08 = (EditText)view.findViewById(R.id.editTextGroup4_08);	
		//蜜月旅行
		editTextGroup5_01 = (EditText)view.findViewById(R.id.editTextGroup5_01);
		//其他雜項
		editTextGroup6_01 = (EditText)view.findViewById(R.id.editTextGroup6_01);		
		//總金額
		textViewTotalAmount = (TextView)view.findViewById(R.id.textViewTotalAmount);
		
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
		valueOfEditTextGroup3_07 = 0;
		valueOfEditTextGroup3_08 = 0;
		valueOfEditTextGroup3_09 = 0;
		valueOfEditTextGroup3_10 = 0;
		valueOfEditTextGroup3_11 = 0;		
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
		
		return view;
	}

	@Override
	public void onStart() {
		super.onStart();
	}

	public OnClickListener buttonListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			if(v.getId() == R.id.button1) {
				total = 0;
				try {
					valueOfEditTextGroup1_01 = Integer.valueOf(editTextGroup1_01.getText().toString());
				} catch(NumberFormatException e) {
					valueOfEditTextGroup1_01 = 0;
				}
				
				try {
					valueOfEditTextGroup2_01 = Integer.valueOf(editTextGroup2_01.getText().toString());
				} catch(NumberFormatException e) {
					valueOfEditTextGroup2_01 = 0;
				}
				
				try {
					valueOfEditTextGroup2_02 = Integer.valueOf(editTextGroup2_02.getText().toString());
				} catch(NumberFormatException e) {
					valueOfEditTextGroup2_02 = 0;
				}
				
				try {
					valueOfEditTextGroup3_01 = Integer.valueOf(editTextGroup3_01.getText().toString());
				} catch(NumberFormatException e) {
					valueOfEditTextGroup3_01 = 0;
				}
				
				try {
					valueOfEditTextGroup3_02 = Integer.valueOf(editTextGroup3_02.getText().toString());
				} catch(NumberFormatException e) {
					valueOfEditTextGroup3_02 = 0;
				}
				
				try {
					valueOfEditTextGroup3_03 = Integer.valueOf(editTextGroup3_03.getText().toString());
				} catch(NumberFormatException e) {
					valueOfEditTextGroup3_03 = 0;
				}
				
				try {
					valueOfEditTextGroup3_04 = Integer.valueOf(editTextGroup3_04.getText().toString());
				} catch(NumberFormatException e) {
					valueOfEditTextGroup3_04 = 0;
				}
				
				try {
					valueOfEditTextGroup3_05 = Integer.valueOf(editTextGroup3_05.getText().toString());
				} catch(NumberFormatException e) {
					valueOfEditTextGroup3_05 = 0;
				}
				
				try {
					valueOfEditTextGroup3_06 = Integer.valueOf(editTextGroup3_06.getText().toString());
				} catch(NumberFormatException e) {
					valueOfEditTextGroup3_06 = 0;
				}
								
				try {
					valueOfEditTextGroup3_07 = Integer.valueOf(editTextGroup3_07.getText().toString());
				} catch(NumberFormatException e) {
					valueOfEditTextGroup3_07 = 0;
				}
				
				try {
					valueOfEditTextGroup3_08 = Integer.valueOf(editTextGroup3_08.getText().toString());
				} catch(NumberFormatException e) {
					valueOfEditTextGroup3_08 = 0;
				}
				
				try {
					valueOfEditTextGroup3_09 = Integer.valueOf(editTextGroup3_09.getText().toString());
				} catch(NumberFormatException e) {
					valueOfEditTextGroup3_09 = 0;
				}

				try {
					valueOfEditTextGroup3_10 = Integer.valueOf(editTextGroup3_10.getText().toString());
				} catch(NumberFormatException e) {
					valueOfEditTextGroup3_10 = 0;
				}				
				
				try {
					valueOfEditTextGroup3_11 = Integer.valueOf(editTextGroup3_11.getText().toString());
				} catch(NumberFormatException e) {
					valueOfEditTextGroup3_11 = 0;
				}
				
				try {
					valueOfEditTextGroup4_01 = Integer.valueOf(editTextGroup4_01.getText().toString());
				} catch(NumberFormatException e) {
					valueOfEditTextGroup4_01 = 0;
				}
				
				try {
					valueOfEditTextGroup4_02 = Integer.valueOf(editTextGroup4_02.getText().toString());
				} catch(NumberFormatException e) {
					valueOfEditTextGroup4_02 = 0;
				}
				
				try {
					valueOfEditTextGroup4_03 = Integer.valueOf(editTextGroup4_03.getText().toString());
				} catch(NumberFormatException e) {
					valueOfEditTextGroup4_03 = 0;
				}
				
				try {
					valueOfEditTextGroup4_04 = Integer.valueOf(editTextGroup4_04.getText().toString());
				} catch(NumberFormatException e) {
					valueOfEditTextGroup4_04 = 0;
				}
				
				try {
					valueOfEditTextGroup4_05 = Integer.valueOf(editTextGroup4_05.getText().toString());
				} catch(NumberFormatException e) {
					valueOfEditTextGroup4_05 = 0;
				}		
				
				try {
					valueOfEditTextGroup4_07 = Integer.valueOf(editTextGroup4_07.getText().toString());
				} catch(NumberFormatException e) {
					valueOfEditTextGroup4_07 = 0;
				}
				
				try {
					valueOfEditTextGroup4_08 = Integer.valueOf(editTextGroup4_08.getText().toString());
				} catch(NumberFormatException e) {
					valueOfEditTextGroup4_08 = 0;
				}
				
				try {
					valueOfEditTextGroup5_01 = Integer.valueOf(editTextGroup5_01.getText().toString());
				} catch(NumberFormatException e) {
					valueOfEditTextGroup5_01 = 0;
				}
				
				try {
					valueOfEditTextGroup6_01 = Integer.valueOf(editTextGroup6_01.getText().toString());
				} catch(NumberFormatException e) {
					valueOfEditTextGroup6_01 = 0;
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
				total += valueOfEditTextGroup3_07;
				total += valueOfEditTextGroup3_08;
				total += valueOfEditTextGroup3_09;
				total += valueOfEditTextGroup3_10;
				total += valueOfEditTextGroup3_11;				
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
				
				textViewTotalAmount.setText("$" + String.format("%,d", total));
			}
		}
	};
}
