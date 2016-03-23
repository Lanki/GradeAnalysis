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
	private EditText reUsername;//�û���Ψһ��
	private EditText rePwd;//����
	private EditText rrePwd;//�������������
	private RadioGroup rg;//��ѡ��ť��ѡ���Ŀƻ������
	private RadioButton rba;//�Ŀ�
	private RadioButton rbs;//���
	
	private String username;
	private String pwd;
	private String rpwd;
	private String type = "�Ŀ�";//�Ŀƻ������
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);//������ͷ��
		setContentView(R.layout.activity_register);
		
		regbtn = (Button) findViewById(R.id.registerbtn);
		reUsername = (EditText) findViewById(R.id.reUsername);
		rePwd = (EditText) findViewById(R.id.rePwd);
		rrePwd = (EditText) findViewById(R.id.rrePwd);
		rg = (RadioGroup) findViewById(R.id.subject);
		rba = (RadioButton) findViewById(R.id.rart);
		rbs = (RadioButton) findViewById(R.id.rscience);
		//��ȡ���Ŀƻ������
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
		//���ע�ᰴť������ɹ����򵯳�ע��ɹ���Ȼ����ת����¼���棬���ʧ�ܣ���˵��ԭ��Ȼ�󷵻�ע�����
		regbtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				//1 ���ע����Ϣ�е�ֵ
				username = reUsername.getText().toString();
				pwd = rePwd.getText().toString();
				rpwd = rrePwd.getText().toString();
				
				if(username == null || username.equals("")|| pwd == null || pwd.equals("")|| rpwd == null || rpwd.equals("")) {
					AlertDialog.Builder dialog = new AlertDialog.Builder(RegisterActivity.this);
					dialog.setTitle("ע��ʧ��");
					dialog.setMessage("�û��������벻��Ϊ��");
					dialog.setPositiveButton("Ok",new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface arg0, int arg1) {
							// TODO Auto-generated method stub
							
						}
					});
					dialog.show();
				}else if(!pwd.equals(rpwd)) {
					AlertDialog.Builder dialog = new AlertDialog.Builder(RegisterActivity.this);
					dialog.setTitle("ע��ʧ��");
					dialog.setMessage("��������Ӧ����ͬ");
					dialog.setPositiveButton("Ok",new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface arg0, int arg1) {
							// TODO Auto-generated method stub
							
						}
					});
					dialog.show();
				}else {
					//��Ϣ�޴��󣬲������ݿ⣬����username,pwd
				    boolean rs = new InforController().insertUser(username,pwd,type);
				    if(rs) {
				    	//�������ɹ�����ת����¼����
				    	AlertDialog.Builder dialog = new AlertDialog.Builder(RegisterActivity.this);
						dialog.setTitle("ע��ɹ�");
						dialog.setMessage("��������¼ҳ��");
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
						dialog.setTitle("ע��ʧ��");
						dialog.setMessage("ע����Ϣ�д���");
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
