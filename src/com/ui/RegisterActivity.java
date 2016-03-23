package com.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.controller.InforController;
public class RegisterActivity extends BaseActivity {
	private Button regbtn;
	private EditText reUsername;//用户名唯一性
	private EditText rePwd;//密码
	private EditText rrePwd;//重新输入的密码
	private RadioGroup rg;//单选按钮，选择文科还是理科
	private RadioButton rba;//文科
	private RadioButton rbs;//理科
	
	private String username;
	private String pwd;
	private String rpwd;
	private String type = "文科";//文科还是理科
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);//设置无头部
		setContentView(R.layout.activity_register);
		
		regbtn = (Button) findViewById(R.id.registerbtn);
		reUsername = (EditText) findViewById(R.id.reUsername);
		rePwd = (EditText) findViewById(R.id.rePwd);
		rrePwd = (EditText) findViewById(R.id.rrePwd);
		rg = (RadioGroup) findViewById(R.id.subject);
		rba = (RadioButton) findViewById(R.id.rart);
		rbs = (RadioButton) findViewById(R.id.rscience);
		//获取是文科还是理科
		rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkId) {
				if(checkId == rba.getId()) {
					type = rba.getText().toString();
				}else if(checkId == rbs.getId()) {
					type = rbs.getText().toString();
				}
			}
		});
		//点击注册按钮，如果成功，则弹出注册成功，然后跳转到登录界面，如果失败，则说明原因，然后返回注册界面
		regbtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				//1 获得注册信息中的值
				username = reUsername.getText().toString();
				pwd = rePwd.getText().toString();
				rpwd = rrePwd.getText().toString();
				
				if(username == null || username.equals("")|| pwd == null || pwd.equals("")|| rpwd == null || rpwd.equals("")) {
					AlertDialog.Builder dialog = new AlertDialog.Builder(RegisterActivity.this);
					dialog.setTitle("注册失败");
					dialog.setMessage("用户名或密码不能为空");
					dialog.setPositiveButton("Ok",new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface arg0, int arg1) {
							// TODO Auto-generated method stub
							
						}
					});
					dialog.show();
				}else if(!pwd.equals(rpwd)) {
					AlertDialog.Builder dialog = new AlertDialog.Builder(RegisterActivity.this);
					dialog.setTitle("注册失败");
					dialog.setMessage("两次密码应该相同");
					dialog.setPositiveButton("Ok",new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface arg0, int arg1) {
							// TODO Auto-generated method stub
							
						}
					});
					dialog.show();
				}else {
					//信息无错误，插入数据库，传输username,pwd
				    boolean rs = new InforController().insertUser(username,pwd,type);
				    if(rs) {
				    	//如果插入成功，跳转到登录界面
				    	AlertDialog.Builder dialog = new AlertDialog.Builder(RegisterActivity.this);
						dialog.setTitle("注册成功");
						dialog.setMessage("点击进入登录页面");
						dialog.setPositiveButton("Ok",new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface arg0, int arg1) {
								// TODO Auto-generated method stub
								Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
						    	startActivity(intent);
						    	finish();
							}
						});
						dialog.show();
						
				    	
				    }else {
				    	AlertDialog.Builder dialog = new AlertDialog.Builder(RegisterActivity.this);
						dialog.setTitle("注册失败");
						dialog.setMessage("注册信息有错误");
						dialog.setPositiveButton("Ok",new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface arg0, int arg1) {
								// TODO Auto-generated method stub
								
							}
						});
						dialog.show();
				    }
				}
			}
		});
	}
}
