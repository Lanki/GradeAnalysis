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
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 设置无头部
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
		/*if(MyApplication.getUser().getuType().equals("文科")) {
			listView.setAdapter(adapter1);
		}else{
			listView.setAdapter(adapter2);
		}*/
		tv.setText("欢迎  " + MyApplication.getUser().getuName() + " 同学" + ":" + MyApplication.getUser().getuType());
		switch (subject) {
		case 1:
			// 如果是1那么查询文科语文成绩
			
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
			// 如果是2那么查询文科数学成绩
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
			// 如果是3那么查询文科英语成绩
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
			// 如果是4那么查询文科政治成绩
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
			// 如果是5那么查询文科历史成绩
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
			// 如果是6那么查询文科地理成绩
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
			// 如果是7那么查询文科总成绩
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
			// 如果是8那么查询理科语文成绩
			als = new InforController().searchScienceChinese(MyApplication.getUser().getuId());
			GradeAdapterS adapter8 = new GradeAdapterS(ShowActivity.this, R.layout.grade_item, als,"Chinese");
			listView.setAdapter(adapter8);
			for (Science sci : als) {
				yList.add(sci.getsChinese());
				xRawDatas.add(sci.getsTime());
			}
			tu.setData(yList, xRawDatas, 100, 20);
			break;
		case 9:// 如果是9那么查询理科数学成绩
			als = new InforController().searchScienceMath(MyApplication.getUser().getuId());
			GradeAdapterS adapter9 = new GradeAdapterS(ShowActivity.this, R.layout.grade_item, als,"Math");
			listView.setAdapter(adapter9);
			for (Science sci : als) {
				yList.add(sci.getsMath());
				xRawDatas.add(sci.getsTime());
			}
			tu.setData(yList, xRawDatas, 100, 20);
			break;
		case 10:// 如果是10那么查询理科外语成绩
			als = new InforController().searchScienceEnglish(MyApplication.getUser().getuId());
			GradeAdapterS adapter10 = new GradeAdapterS(ShowActivity.this, R.layout.grade_item, als,"English");
			listView.setAdapter(adapter10);
			for (Science sci : als) {
				yList.add(sci.getsEnglish());
				xRawDatas.add(sci.getsTime());
			}
			tu.setData(yList, xRawDatas, 100, 20);
			break;
		case 11:// 如果是11那么查询理科物理成绩
			als = new InforController().searchSciencePhysical(MyApplication.getUser().getuId());
			GradeAdapterS adapter11 = new GradeAdapterS(ShowActivity.this, R.layout.grade_item, als,"Physics");
			listView.setAdapter(adapter11);
			for (Science sci : als) {
				yList.add(sci.getsPhysics());
				xRawDatas.add(sci.getsTime());
			}
			tu.setData(yList, xRawDatas, 100, 20);
			break;
		case 12:// 如果是12那么查询理科化学成绩
			als = new InforController().searchScienceChemistry(MyApplication.getUser().getuId());
			GradeAdapterS adapter12 = new GradeAdapterS(ShowActivity.this, R.layout.grade_item, als,"Chemistry");
			listView.setAdapter(adapter12);
			for (Science sci : als) {
				yList.add(sci.getsChemistry());
				xRawDatas.add(sci.getsTime());
			}
			tu.setData(yList, xRawDatas, 100, 20);
			break;
		case 13:// 如果是13那么查询理科生物成绩
			als = new InforController().searchScienceBiology(MyApplication.getUser().getuId());
			GradeAdapterS adapter13 = new GradeAdapterS(ShowActivity.this, R.layout.grade_item, als,"Biology");
			listView.setAdapter(adapter13);
			for (Science sci : als) {
				yList.add(sci.getsBiology());
				xRawDatas.add(sci.getsTime());
			}
			tu.setData(yList, xRawDatas, 100, 20);
			break;
		case 14:// 如果是14那么查询理科总成绩
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
			viewHolder.projectName.setText("语文");
			viewHolder.projectScore.setText(String.valueOf(art.getaChinese()));
		}else if(pro.equals("Math")) {
			viewHolder.projectName.setText("数学");
			viewHolder.projectScore.setText(String.valueOf(art.getaMath()));
		}else if(pro.equals("English")) {
			viewHolder.projectName.setText("英语");
			viewHolder.projectScore.setText(String.valueOf(art.getaEnglish()));
		}else if(pro.equals("Politics")) {
			viewHolder.projectName.setText("政治");
			viewHolder.projectScore.setText(String.valueOf(art.getaPolitics()));
		}else if(pro.equals("History")) {
			viewHolder.projectName.setText("历史");
			viewHolder.projectScore.setText(String.valueOf(art.getaHistory()));
		}else if(pro.equals("Geology")) {
			viewHolder.projectName.setText("地理");
			viewHolder.projectScore.setText(String.valueOf(art.getaGeology()));
		}else if(pro.equals("Total")) {
			viewHolder.projectName.setText("总分");
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
			viewHolder.projectName.setText("语文");
			viewHolder.projectScore.setText(String.valueOf(sci.getsChinese()));
		}else if(pro.equals("Math")){
			viewHolder.projectName.setText("数学");
			viewHolder.projectScore.setText(String.valueOf(sci.getsMath()));
		}else if(pro.equals("English")){
			viewHolder.projectName.setText("英语");
			viewHolder.projectScore.setText(String.valueOf(sci.getsEnglish()));
		}else if(pro.equals("Physics")){
			viewHolder.projectName.setText("物理");
			viewHolder.projectScore.setText(String.valueOf(sci.getsPhysics()));
		}else if(pro.equals("Chemistry")){
			viewHolder.projectName.setText("化学");
			viewHolder.projectScore.setText(String.valueOf(sci.getsChemistry()));
		}else if(pro.equals("Biology")){
			viewHolder.projectName.setText("生物");
			viewHolder.projectScore.setText(String.valueOf(sci.getsBiology()));
		}else if(pro.equals("Total")){
			viewHolder.projectName.setText("总分");
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
