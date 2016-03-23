package com.ui;

import com.controller.MyApplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

public class ScienceActivity extends BaseActivity implements OnClickListener{
	private TextView tv;
	private ImageBtnLayout addgradebtn;
	private ImageBtnLayout searchChinesebtn;
	private ImageBtnLayout searchMathbtn;
	private ImageBtnLayout searchEnglishbtn;
	private ImageBtnLayout searchPhysicalbtn;
	private ImageBtnLayout searchChemistrybtn;
	private ImageBtnLayout searchBiologybtn;
	private ImageBtnLayout searchTotalbtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_science);
		tv = (TextView) findViewById(R.id.susername);
		addgradebtn = (ImageBtnLayout) findViewById(R.id.addgrade);
		searchChinesebtn = (ImageBtnLayout) findViewById(R.id.searchChinese);
		searchMathbtn = (ImageBtnLayout) findViewById(R.id.searchMath);
		searchEnglishbtn = (ImageBtnLayout) findViewById(R.id.searchEnglish);
		searchPhysicalbtn = (ImageBtnLayout) findViewById(R.id.searchPhysical);
		searchChemistrybtn = (ImageBtnLayout) findViewById(R.id.searchChemistry);
		searchBiologybtn = (ImageBtnLayout) findViewById(R.id.searchBiology);
		searchTotalbtn = (ImageBtnLayout) findViewById(R.id.searchTotal);
		
		tv.setText(MyApplication.getUser().getuType());
		Toast.makeText(ScienceActivity.this, "欢迎  " + MyApplication.getUser().getuName() + " 同学", Toast.LENGTH_SHORT).show();
		
		addgradebtn.setOnClickListener(this);
		searchChinesebtn.setOnClickListener(this);
		searchMathbtn.setOnClickListener(this);
		searchEnglishbtn.setOnClickListener(this);
		searchPhysicalbtn.setOnClickListener(this);
		searchChemistrybtn.setOnClickListener(this);
		searchBiologybtn.setOnClickListener(this);
		searchTotalbtn.setOnClickListener(this);
		
		/* 图片设置 */
		addgradebtn.setImageResource(R.drawable.btn_add);
		searchChinesebtn.setImageResource(R.drawable.btn_chinese);
		searchMathbtn.setImageResource(R.drawable.btn_math);
		searchEnglishbtn.setImageResource(R.drawable.btn_english);
		searchPhysicalbtn.setImageResource(R.drawable.btn_physical);
		searchChemistrybtn.setImageResource(R.drawable.btn_chemistry);
		searchBiologybtn.setImageResource(R.drawable.btn_biology);
		searchTotalbtn.setImageResource(R.drawable.btn_total);
		
		/* text设置 */
		addgradebtn.setText("成绩添加");
		searchChinesebtn.setText("语文成绩");
		searchMathbtn.setText("数学成绩");
		searchEnglishbtn.setText("英语成绩");
		searchPhysicalbtn.setText("物理成绩");
		searchChemistrybtn.setText("化学成绩");
		searchBiologybtn.setText("生物成绩");
		searchTotalbtn.setText("总成绩");
		
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.addgrade:
			//如果点击添加科目成绩按钮，那么跳转到一个新的界面
			Intent intent = new Intent(ScienceActivity.this,AddScienceActivity.class);
			startActivity(intent);
			break;
		case R.id.searchChinese:
			Intent intent2 = new Intent(ScienceActivity.this,ShowActivity.class);
			intent2.putExtra("subject", 8);
			startActivity(intent2);
			break;
		case R.id.searchMath:
			Intent intent3 = new Intent(ScienceActivity.this,ShowActivity.class);
			intent3.putExtra("subject",9);
			startActivity(intent3);
			break;
		case R.id.searchEnglish:
			Intent intent4 = new Intent(ScienceActivity.this,ShowActivity.class);
			intent4.putExtra("subject",10);
			startActivity(intent4);
			break;
		case R.id.searchPhysical:
			Intent intent5 = new Intent(ScienceActivity.this,ShowActivity.class);
			intent5.putExtra("subject",11);
			startActivity(intent5);
			break;
		case R.id.searchChemistry:
			Intent intent6 = new Intent(ScienceActivity.this,ShowActivity.class);
			intent6.putExtra("subject",12);
			startActivity(intent6);
			break;
		case R.id.searchBiology:
			Intent intent7 = new Intent(ScienceActivity.this,ShowActivity.class);
			intent7.putExtra("subject",13);
			startActivity(intent7);
			break;
		case R.id.searchTotal:
			Intent intent8 = new Intent(ScienceActivity.this,ShowActivity.class);
			intent8.putExtra("subject",14);
			startActivity(intent8);
			break;
		default:
			break;
		}
	}
}
