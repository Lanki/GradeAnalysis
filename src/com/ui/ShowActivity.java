package com.ui;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.controller.InforController;
import com.controller.MyApplication;
import com.model.Art;
import com.model.Science;

public class ShowActivity extends BaseActivity {
	private ArrayList<Double> yList;
	ArrayList<String> xRawDatas = new ArrayList<String>();
	private LineGraphicView tu;
	private TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// ������ͷ��
		setContentView(R.layout.activity_show);
		tu = (LineGraphicView) findViewById(R.id.line_graphic);
		tv = (TextView) findViewById(R.id.name);
		Intent intent = getIntent();
		yList = new ArrayList<Double>();
		ArrayList<Art> al = new ArrayList<Art>();
		ArrayList<Science> als = new ArrayList<Science>();
		int subject = intent.getIntExtra("subject", 0);
		//GradeAdapter adapter1 = new GradeAdapter(ShowActivity.this, R.layout.grade_item, al);
		//GradeAdapterS adapter2 = new GradeAdapterS(ShowActivity.this, R.layout.grade_item, als);
		ListView listView = (ListView)findViewById(R.id.subjectlist);
		/*if(MyApplication.getUser().getuType().equals("�Ŀ�")) {
			listView.setAdapter(adapter1);
		}else{
			listView.setAdapter(adapter2);
		}*/
		tv.setText("��ӭ  " + MyApplication.getUser().getuName() + " ͬѧ" + ":" + MyApplication.getUser().getuType());
		switch (subject) {
		case 1:
			// �����1��ô��ѯ�Ŀ����ĳɼ�
			
			al = new InforController().searchArtChinese(MyApplication.getUser().getuId());
			GradeAdapter adapter1 = new GradeAdapter(ShowActivity.this, R.layout.grade_item, al,"Chinese");
			listView.setAdapter(adapter1);
			for (Art art : al) {
				yList.add(art.getaChinese());
				xRawDatas.add(art.getaTime());
			}
			tu.setData(yList, xRawDatas, 100, 20);
			break;
		case 2:
			// �����2��ô��ѯ�Ŀ���ѧ�ɼ�
			al = new InforController().searchArtMath(MyApplication.getUser().getuId());
			GradeAdapter adapter2 = new GradeAdapter(ShowActivity.this, R.layout.grade_item, al,"Math");
			listView.setAdapter(adapter2);
			for (Art art : al) {
				yList.add(art.getaMath());
				xRawDatas.add(art.getaTime());
			}
			tu.setData(yList, xRawDatas, 100, 20);
			break;
		case 3:
			// �����3��ô��ѯ�Ŀ�Ӣ��ɼ�
			al = new InforController().searchArtEnglish(MyApplication.getUser().getuId());
			GradeAdapter adapter3 = new GradeAdapter(ShowActivity.this, R.layout.grade_item, al,"English");
			listView.setAdapter(adapter3);
			for (Art art : al) {
				yList.add(art.getaEnglish());
				xRawDatas.add(art.getaTime());
			}
			tu.setData(yList, xRawDatas, 100, 20);
			break;
		case 4:
			// �����4��ô��ѯ�Ŀ����γɼ�
			al = new InforController().searchArtPolitics(MyApplication.getUser().getuId());
			GradeAdapter adapter4 = new GradeAdapter(ShowActivity.this, R.layout.grade_item, al,"Politics");
			listView.setAdapter(adapter4);
			for (Art art : al) {
				yList.add(art.getaPolitics());
				xRawDatas.add(art.getaTime());
			}
			tu.setData(yList, xRawDatas, 100, 20);
			break;
		case 5:
			// �����5��ô��ѯ�Ŀ���ʷ�ɼ�
			al = new InforController().searchArtHistory(MyApplication.getUser().getuId());
			GradeAdapter adapter5 = new GradeAdapter(ShowActivity.this, R.layout.grade_item, al,"History");
			listView.setAdapter(adapter5);
			for (Art art : al) {
				yList.add(art.getaHistory());
				xRawDatas.add(art.getaTime());
			}
			tu.setData(yList, xRawDatas, 100, 20);
			break;
		case 6:
			// �����6��ô��ѯ�ĿƵ���ɼ�
			al = new InforController().searchArtGeology(MyApplication.getUser().getuId());
			GradeAdapter adapter6 = new GradeAdapter(ShowActivity.this, R.layout.grade_item, al,"Geology");
			listView.setAdapter(adapter6);
			for (Art art : al) {
				yList.add(art.getaGeology());
				xRawDatas.add(art.getaTime());
			}
			tu.setData(yList, xRawDatas, 100, 20);
			break;
		case 7:
			// �����7��ô��ѯ�Ŀ��ܳɼ�
			al = new InforController().searchArtTotal(MyApplication.getUser().getuId());
			GradeAdapter adapter7 = new GradeAdapter(ShowActivity.this, R.layout.grade_item, al,"Total");
			listView.setAdapter(adapter7);
			for (Art art : al) {
				yList.add(art.getaTotal());
				xRawDatas.add(art.getaTime());
			}
			tu.setData(yList, xRawDatas, 750, 150);
			break;
		case 8:
			// �����8��ô��ѯ������ĳɼ�
			als = new InforController().searchScienceChinese(MyApplication.getUser().getuId());
			GradeAdapterS adapter8 = new GradeAdapterS(ShowActivity.this, R.layout.grade_item, als,"Chinese");
			listView.setAdapter(adapter8);
			for (Science sci : als) {
				yList.add(sci.getsChinese());
				xRawDatas.add(sci.getsTime());
			}
			tu.setData(yList, xRawDatas, 100, 20);
			break;
		case 9:// �����9��ô��ѯ�����ѧ�ɼ�
			als = new InforController().searchScienceMath(MyApplication.getUser().getuId());
			GradeAdapterS adapter9 = new GradeAdapterS(ShowActivity.this, R.layout.grade_item, als,"Math");
			listView.setAdapter(adapter9);
			for (Science sci : als) {
				yList.add(sci.getsMath());
				xRawDatas.add(sci.getsTime());
			}
			tu.setData(yList, xRawDatas, 100, 20);
			break;
		case 10:// �����10��ô��ѯ�������ɼ�
			als = new InforController().searchScienceEnglish(MyApplication.getUser().getuId());
			GradeAdapterS adapter10 = new GradeAdapterS(ShowActivity.this, R.layout.grade_item, als,"English");
			listView.setAdapter(adapter10);
			for (Science sci : als) {
				yList.add(sci.getsEnglish());
				xRawDatas.add(sci.getsTime());
			}
			tu.setData(yList, xRawDatas, 100, 20);
			break;
		case 11:// �����11��ô��ѯ�������ɼ�
			als = new InforController().searchSciencePhysical(MyApplication.getUser().getuId());
			GradeAdapterS adapter11 = new GradeAdapterS(ShowActivity.this, R.layout.grade_item, als,"Physics");
			listView.setAdapter(adapter11);
			for (Science sci : als) {
				yList.add(sci.getsPhysics());
				xRawDatas.add(sci.getsTime());
			}
			tu.setData(yList, xRawDatas, 100, 20);
			break;
		case 12:// �����12��ô��ѯ��ƻ�ѧ�ɼ�
			als = new InforController().searchScienceChemistry(MyApplication.getUser().getuId());
			GradeAdapterS adapter12 = new GradeAdapterS(ShowActivity.this, R.layout.grade_item, als,"Chemistry");
			listView.setAdapter(adapter12);
			for (Science sci : als) {
				yList.add(sci.getsChemistry());
				xRawDatas.add(sci.getsTime());
			}
			tu.setData(yList, xRawDatas, 100, 20);
			break;
		case 13:// �����13��ô��ѯ�������ɼ�
			als = new InforController().searchScienceBiology(MyApplication.getUser().getuId());
			GradeAdapterS adapter13 = new GradeAdapterS(ShowActivity.this, R.layout.grade_item, als,"Biology");
			listView.setAdapter(adapter13);
			for (Science sci : als) {
				yList.add(sci.getsBiology());
				xRawDatas.add(sci.getsTime());
			}
			tu.setData(yList, xRawDatas, 100, 20);
			break;
		case 14:// �����14��ô��ѯ����ܳɼ�
			als = new InforController().searchScienceTotal(MyApplication.getUser().getuId());
			GradeAdapterS adapter14 = new GradeAdapterS(ShowActivity.this, R.layout.grade_item, als,"Total");
			listView.setAdapter(adapter14);
			for (Science sci : als) {
				yList.add(sci.getsTotal());
				xRawDatas.add(sci.getsTime());
			}
			tu.setData(yList, xRawDatas, 750, 150);
			break;
		default:
			break;
		}

	}

	public void show() {
		
		  yList = new ArrayList<Double>(); yList.add(550.0); yList.add(555.0);
		  yList.add(585.0); yList.add(590.0); yList.add(592.0); yList.add(693.0);
		  yList.add(695.0);
		  
		  xRawDatas = new ArrayList<String>(); xRawDatas.add("05-19");
		  xRawDatas.add("05-20"); xRawDatas.add("05-21");
		 xRawDatas.add("05-22"); xRawDatas.add("05-23");
		  xRawDatas.add("05-24"); xRawDatas.add("05-25");
		  xRawDatas.add("05-26");
		 
		tu.setData(yList, xRawDatas, 750, 150);
	}
}
class GradeAdapter extends ArrayAdapter<Art> {
	private int resourceId;
	private String pro;
	public GradeAdapter(Context context, int resource, List<Art> objects,String project) {
		super(context, resource, objects);
		resourceId = resource;
		pro = project;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Art art = getItem(position);
		View view;
		ViewHolder viewHolder;
		if(convertView == null) {
			view = LayoutInflater.from(getContext()).inflate(resourceId, null);
			viewHolder = new ViewHolder();
			viewHolder.projectName = (TextView) view.findViewById(R.id.projectName);
			viewHolder.projectScore = (TextView) view.findViewById(R.id.projectScore);
			viewHolder.projectTime = (TextView) view.findViewById(R.id.projectTime);
			view.setTag(viewHolder);
		}else{
			view = convertView;
			viewHolder = (ViewHolder) view.getTag();
		}
		
		if(pro.equals("Chinese")) {
			viewHolder.projectName.setText("����");
			viewHolder.projectScore.setText(String.valueOf(art.getaChinese()));
		}else if(pro.equals("Math")) {
			viewHolder.projectName.setText("��ѧ");
			viewHolder.projectScore.setText(String.valueOf(art.getaMath()));
		}else if(pro.equals("English")) {
			viewHolder.projectName.setText("Ӣ��");
			viewHolder.projectScore.setText(String.valueOf(art.getaEnglish()));
		}else if(pro.equals("Politics")) {
			viewHolder.projectName.setText("����");
			viewHolder.projectScore.setText(String.valueOf(art.getaPolitics()));
		}else if(pro.equals("History")) {
			viewHolder.projectName.setText("��ʷ");
			viewHolder.projectScore.setText(String.valueOf(art.getaHistory()));
		}else if(pro.equals("Geology")) {
			viewHolder.projectName.setText("����");
			viewHolder.projectScore.setText(String.valueOf(art.getaGeology()));
		}else if(pro.equals("Total")) {
			viewHolder.projectName.setText("�ܷ�");
			viewHolder.projectScore.setText(String.valueOf(art.getaTotal()));
		}
		viewHolder.projectTime.setText(art.getaTime());
		return view;
	}
	class ViewHolder {
		TextView projectName;
		TextView projectScore;
		TextView projectTime;
	}
}
class GradeAdapterS extends ArrayAdapter<Science> {
	private int resourceId;
	private String pro;
	public GradeAdapterS(Context context, int resource, List<Science> objects,String project) {
		super(context, resource, objects);
		resourceId = resource;
		pro = project;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Science sci = getItem(position);
		View view;
		ViewHolder viewHolder;
		if(convertView == null) {
			view = LayoutInflater.from(getContext()).inflate(resourceId, null);
			viewHolder = new ViewHolder();
			viewHolder.projectName = (TextView) view.findViewById(R.id.projectName);
			viewHolder.projectScore = (TextView) view.findViewById(R.id.projectScore);
			viewHolder.projectTime = (TextView) view.findViewById(R.id.projectTime);
			view.setTag(viewHolder);
		}else{
			view = convertView;
			viewHolder = (ViewHolder) view.getTag();
		}
		
		if(pro.equals("Chinese")) {
			viewHolder.projectName.setText("����");
			viewHolder.projectScore.setText(String.valueOf(sci.getsChinese()));
		}else if(pro.equals("Math")){
			viewHolder.projectName.setText("��ѧ");
			viewHolder.projectScore.setText(String.valueOf(sci.getsMath()));
		}else if(pro.equals("English")){
			viewHolder.projectName.setText("Ӣ��");
			viewHolder.projectScore.setText(String.valueOf(sci.getsEnglish()));
		}else if(pro.equals("Physics")){
			viewHolder.projectName.setText("����");
			viewHolder.projectScore.setText(String.valueOf(sci.getsPhysics()));
		}else if(pro.equals("Chemistry")){
			viewHolder.projectName.setText("��ѧ");
			viewHolder.projectScore.setText(String.valueOf(sci.getsChemistry()));
		}else if(pro.equals("Biology")){
			viewHolder.projectName.setText("����");
			viewHolder.projectScore.setText(String.valueOf(sci.getsBiology()));
		}else if(pro.equals("Total")){
			viewHolder.projectName.setText("�ܷ�");
			viewHolder.projectScore.setText(String.valueOf(sci.getsTotal()));
		}
		viewHolder.projectTime.setText(sci.getsTime());
		return view;
	}
	class ViewHolder {
		TextView projectName;
		TextView projectScore;
		TextView projectTime;
	}
}
