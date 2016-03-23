package com.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.controller.InforController;
import com.controller.MyApplication;
import com.db.GradeAnalysisOpenHelper;
import com.model.Suser;

public class MainActivity extends BaseActivity {
	private String username;
	private String pwd;
	private EditText eusername;
	private EditText epwd;
	private Button login;
	private Button reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        GradeAnalysisOpenHelper.setContext(this.getApplicationContext());
        eusername = (EditText) findViewById(R.id.eUsername);
        epwd = (EditText) findViewById(R.id.ePwd);
        login = (Button) findViewById(R.id.login);
        reg = (Button) findViewById(R.id.register);
        //注册按钮监听器
        reg.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
				startActivity(intent);
			}
		});
        //登录按钮监听器
        login.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				username = eusername.getText().toString();
				pwd = epwd.getText().toString();
				if(username == null || username.equals("") || pwd == null || pwd.equals("")) {
					AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
					dialog.setTitle("登录失败");
					dialog.setMessage("用户名或密码不能为空");
					dialog.setPositiveButton("Ok",new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface arg0, int arg1) {
							// TODO Auto-generated method stub
							
						}
					});
					dialog.show();
				}else {
					Suser rs = new InforController().login(username, pwd);
					//如果rs 结果不为nul，则表示登录成功
					if(rs != null) {
						Log.w("debug", "login success" + rs.getuType());
						MyApplication.setUser(rs);
						if("文科".equals(rs.getuType())){
						//如果登录成功，如果是文科，则跳转到WelcomeActivity
							Intent aintent = new Intent(MainActivity.this,WelcomeActivity.class);
							startActivity(aintent);
							finish();
						}else{
						//如果登录成功，如果是理科，则跳转到
							Intent sintent = new Intent(MainActivity.this,ScienceActivity.class);
							startActivity(sintent);
							finish();
						}
					}else {
						AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
						dialog.setTitle("登录失败");
						dialog.setMessage("用户名或密码错误");
						dialog.setPositiveButton("Ok",new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface arg0, int arg1) {
								
							}
						});
						dialog.show();
					}
				}
			}
		});
    }
}
