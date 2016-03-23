package com.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class GradeAnalysisOpenHelper extends SQLiteOpenHelper {
	
	private final static int DATABASE_VERSION = 1;//数据库版本号
	private final static String DATABASE_NAME = "gradeanalysis.db";//数据库名
	private static Context context;//内容上下文
	
	public static void setContext(Context context) {
		GradeAnalysisOpenHelper.context = context;
	}
	
	public GradeAnalysisOpenHelper() {
		super(context,DATABASE_NAME,null,DATABASE_VERSION);//创建数据库
	}
	/**
	 * sUser table
	 * @param context
	 * @param name
	 * @param factory
	 * @param version1
	 */
	public static final String CREATE_SUSER = "create table Suser (uId integer primary key autoincrement,uName varchar(64) not null,uPwd varchar(65) not null,uType varchar(16) not null)";
	
	/**
	 * Art table
	 * @param context
	 * @param name
	 * @param factory
	 * @param version1
	 */
	
	public static final String CREATE_ART = "create table Art (aid integer primary key autoincrement,usid integer,aChinese double,aMath double,aEnglish double,aPolitics double,aHistory double,aGeology double,aTotal double,aTime varchar(64),aSearchTime long)";
	
	/**
	 * Science table
	 * @param context
	 * @param name
	 * @param factory
	 * @param version1
	 */
	
	public static final String CREATE_SCIENCE = "create table Science (sid integer primary key autoincrement,usid integer,sChinese double,sMath double,sEnglish double,sPhysics double,sChemistry double,sBiology double,sTotal double,sTime varchar(64),sSearchTime long)";
	public GradeAnalysisOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_SUSER);//create tables
		db.execSQL(CREATE_ART);
		db.execSQL(CREATE_SCIENCE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}
	
	public SQLiteDatabase getConnection() {
		SQLiteDatabase db = getWritableDatabase();
		return db;
	}
	
	public void close(SQLiteDatabase db) {
		db.close();
	}

}
