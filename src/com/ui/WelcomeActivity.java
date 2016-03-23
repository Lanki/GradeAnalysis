package com.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.controller.MyApplication;

public class WelcomeActivity extends BaseActivity implements OnClickListener{
	private TextView tv;
	private ImageBtnLayout addgradebtn;
	private ImageBtnLayout searchChinesebtn;
	private ImageBtnLayout searchMathbtn;
	private ImageBtnLayout searchEnglishbtn;
	private ImageBtnLayout searchPoliticsbtn;
	private ImageBtnLayout searchHistorybtn;
	private ImageBtnLayout searchGeologybtn;
	private ImageBtnLayout searchTotalbtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_welcome);
		
		tv = (TextView) findViewById(R.id.susername);
		addgradebtn = (ImageBtnLayout) findViewById(R.id.addgrade);
		searchChinesebtn = (ImageBtnLayout) findViewById(R.id.searchChinese);
		searchMathbtn = (ImageBtnLayout) findViewById(R.id.searchMath);
		searchEnglishbtn = (ImageBtnLayout) findViewById(R.id.searchEnglish);
		searchPoliticsbtn = (ImageBtnLayout) findViewById(R.id.searchPolitics);
		searchHistorybtn = (ImageBtnLayout) findViewById(R.id.searchHistory);
		searchGeologybtn = (ImageBtnLayout) findViewById(R.id.searchGeology);
		searchTotalbtn = (ImageBtnLayout) findViewById(R.id.searchTotal);
		
		tv.setText(MyApplication.getUser().getuType());
		Toast.makeText(WelcomeActivity.this, "欢迎  " + MyApplication.getUser().getuName() + " 同学", Toast.LENGTH_SHORT).show();
		
		addgradebtn.setOnClickListener(this);
		searchChinesebtn.setOnClickListener(this);
		searchMathbtn.setOnClickListener(this);
		searchEnglishbtn.setOnClickListener(this);
		searchPoliticsbtn.setOnClickListener(this);
		searchHistorybtn.setOnClickListener(this);
		searchGeologybtn.setOnClickListener(this);
		searchTotalbtn.setOnClickListener(this);
		
		/* 图片设置 */
		addgradebtn.setImageResource(R.drawable.btn_add);
		searchChinesebtn.setImageResource(R.drawable.btn_chinese);
		searchMathbtn.setImageResource(R.drawable.btn_math);
		searchEnglishbtn.setImageResource(R.drawable.btn_english);
		searchPoliticsbtn.setImageResource(R.drawable.btn_politic);
		searchHistorybtn.setImageResource(R.drawable.btn_history);
		searchGeologybtn.setImageResource(R.drawable.btn_geography);
		searchTotalbtn.setImageResource(R.drawable.btn_total);
		
		/* text设置 */
		addgradebtn.setText("添加成绩");
		searchChinesebtn.setText("语文成绩");
		searchMathbtn.setText("数学成绩");
		searchEnglishbtn.setText("英语成绩");
		searchPoliticsbtn.setText("政治成绩");
		searchHistorybtn.setText("历史成绩");
		searchGeologybtn.setText("地理成绩");
		searchTotalbtn.setText("总成绩");
		
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.addgrade:
			//如果点击添加科目成绩按钮，那么跳转到一个新的界面
			Intent intent = new Intent(WelcomeActivity.this,AddGradeActivity.class);
			startActivity(intent);
			break;
		case R.id.searchChinese:
			Intent intent2 = new Intent(WelcomeActivity.this,ShowActivity.class);
			intent2.putExtra("subject", 1);
			startActivity(intent2);
			break;
		case R.id.searchMath:
			Intent intent3 = new Intent(WelcomeActivity.this,ShowActivity.class);
			intent3.putExtra("subject",2);
			startActivity(intent3);
			break;
		case R.id.searchEnglish:
			Intent intent4 = new Intent(WelcomeActivity.this,ShowActivity.class);
			intent4.putExtra("subject",3);
			startActivity(intent4);
			break;
		case R.id.searchPolitics:
			Intent intent5 = new Intent(WelcomeActivity.this,ShowActivity.class);
			intent5.putExtra("subject",4);
			startActivity(intent5);
			break;
		case R.id.searchHistory:
			Intent intent6 = new Intent(WelcomeActivity.this,ShowActivity.class);
			intent6.putExtra("subject",5);
			startActivity(intent6);
			break;
		case R.id.searchGeology:
			Intent intent7 = new Intent(WelcomeActivity.this,ShowActivity.class);
			intent7.putExtra("subject",6);
			startActivity(intent7);
			break;
		case R.id.searchTotal:
			Intent intent8 = new Intent(WelcomeActivity.this,ShowActivity.class);
			intent8.putExtra("subject",7);
			startActivity(intent8);
			break;
			
		default:
			break;
		}
	}
}
