package com.ui;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.controller.InforController;
import com.model.Art;

public class AddGradeActivity extends BaseActivity {
	private EditText chinese;
	private EditText math;
	private EditText english;
	private EditText politics;
	private EditText history;
	private EditText geography;
	private Button submit;
	
	private String schinese;
	private String smath;
	private String senglish;
	private String spolitics;
	private String shistory;
	private String sgeography;
	
	private double dchinese;
	private double dmath;
	private double denglish;
	private double dpolitics;
	private double dhistory;
	private double dgeography;
	private double dtotal;
	
	/**
	 * �ĿƳɼ����
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_add_grade);
		chinese = (EditText) findViewById(R.id.addChinese);
		math = (EditText) findViewById(R.id.addMath);
		english = (EditText) findViewById(R.id.addEnglish);
		politics = (EditText) findViewById(R.id.addPolitics);
		history = (EditText) findViewById(R.id.addHistory);
		geography = (EditText) findViewById(R.id.addGeography);
		
		submit = (Button) findViewById(R.id.addGrade);
		
		submit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				schinese = chinese.getText().toString();
				smath = math.getText().toString();
				senglish = english.getText().toString();;
				spolitics = politics.getText().toString();
				shistory = history.getText().toString();
				sgeography = geography.getText().toString();
				
				if(	schinese == null || schinese.equals("") 
					|| smath == null || smath.equals("")
					|| senglish == null || senglish.equals("")
					|| spolitics == null || spolitics.equals("") 
					|| shistory == null || shistory.equals("")
					|| sgeography == null || sgeography.equals("")) {
					AlertDialog.Builder dialog = new AlertDialog.Builder(AddGradeActivity.this);
					dialog.setTitle("��ӳɼ�ʧ��");
					dialog.setMessage("��Ϣ����Ϊ��");
					dialog.setPositiveButton("Ok",new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface arg0, int arg1) {
							// TODO Auto-generated method stub
							
						}
					});
					dialog.show();
				}else{
					//�����Ϣû�����⣬����ӵ����ݿ���
					dchinese = Double.parseDouble(schinese);
					dmath = Double.parseDouble(smath);
					denglish = Double.parseDouble(senglish);
					dpolitics = Double.parseDouble(spolitics);
					dhistory = Double.parseDouble(shistory);
					dgeography = Double.parseDouble(sgeography);
					
					dtotal = dchinese + dmath + denglish + dpolitics + dhistory + dgeography;
					DateFormat format= new SimpleDateFormat("yyyy.MM.dd");   
					Art art = new Art();
					art.setaChinese(dchinese);
					art.setaMath(dmath);
					art.setaEnglish(denglish);
					art.setaPolitics(dpolitics);
					art.setaHistory(dhistory);
					art.setaGeology(dgeography);
					art.setaTotal(dtotal);
					art.setaTime(format.format(new Date()));
					art.setaSearchTime(new Date().getTime());
					//Ȼ�����InforController �������ݿ���
					boolean rs = new InforController().addArt(art);
					if(rs) {
						AlertDialog.Builder dialog = new AlertDialog.Builder(AddGradeActivity.this);
						dialog.setTitle("��ӳɼ��ɹ�");
						dialog.setMessage("���γɼ���ӳɹ�");
						dialog.setPositiveButton("Ok",new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface arg0, int arg1) {
								// TODO Auto-generated method stub
								
							}
						});
						dialog.show();
						chinese.setText("");
						math.setText("");
						english.setText("");
						politics.setText("");
						history.setText("");
						geography.setText("");
					}else{
						AlertDialog.Builder dialog = new AlertDialog.Builder(AddGradeActivity.this);
						dialog.setTitle("��ӳɼ�ʧ��");
						dialog.setMessage("���γɼ����ʧ��");
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
