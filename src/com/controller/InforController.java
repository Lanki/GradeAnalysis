package com.controller;

import java.util.ArrayList;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.db.GradeAnalysisOpenHelper;
import com.model.Art;
import com.model.Science;
import com.model.Suser;

public class InforController {
	/**
	 * 注册信息，如果成功返回true，否则返回false
	 * 
	 * @param userName
	 * @param pwd
	 * @return
	 */
	public boolean insertUser(String userName, String pwd, String type) {
		GradeAnalysisOpenHelper ga = new GradeAnalysisOpenHelper();
		SQLiteDatabase db = ga.getConnection();
		Log.w("debug", "register success");
		String sql = "insert into Suser(uName,uPwd,uType)" + "values('"
				+ userName + "','" + pwd + "','" + type + "')";
		db.execSQL(sql);
		db.close();
		return true;
	}

	/**
	 * 登录信息，登录成功返回信息Suser，否则返回null
	 * 
	 * @param userName
	 * @param pwd
	 * @return
	 */
	public Suser login(String userName, String pwd) {
		GradeAnalysisOpenHelper ga = new GradeAnalysisOpenHelper();
		SQLiteDatabase db = ga.getConnection();
		String sql = "select * from Suser where uName=? and uPwd=?";
		Cursor cursor = db.rawQuery(sql, new String[] { userName, pwd });
		if (cursor.moveToFirst() == true) {
			int uId = cursor.getInt(cursor.getColumnIndex("uId"));
			String uName = cursor.getString(cursor.getColumnIndex("uName"));
			String uType = cursor.getString(cursor.getColumnIndex("uType"));
			Suser user = new Suser();
			user.setuId(uId);
			user.setuName(uName);
			user.setuType(uType);
			cursor.close();
			db.close();
			return user;
		}
		return null;
	}

	public boolean addArt(Art art) {
		GradeAnalysisOpenHelper ga = new GradeAnalysisOpenHelper();
		SQLiteDatabase db = ga.getConnection();
		String sql = "insert into Art(usid,aChinese,aMath,aEnglish,aPolitics,aHistory,aGeology,aTotal,aTime,aSearchTime) values('"
				+ MyApplication.getUser().getuId()
				+ "','"
				+ art.getaChinese()
				+ "','"
				+ art.getaMath()
				+ "','"
				+ art.getaEnglish()
				+ "','"
				+ art.getaPolitics()
				+ "','"
				+ art.getaHistory()
				+ "','"
				+ art.getaGeology()
				+ "','"
				+ art.getaTotal()
				+ "','"
				+ art.getaTime() + "','" + art.getaSearchTime() + "')";
		try {
			db.execSQL(sql);
			Log.w("debug", sql);
			db.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean addScience(Science sci) {
		GradeAnalysisOpenHelper ga = new GradeAnalysisOpenHelper();
		SQLiteDatabase db = ga.getConnection();
		String sql = "insert into Science(usid,sChinese,sMath,sEnglish,sPhysics,sChemistry,sBiology,sTotal,sTime,sSearchTime) values('"
				+ MyApplication.getUser().getuId()
				+ "','"
				+ sci.getsChinese()
				+ "','"
				+ sci.getsMath()
				+ "','"
				+ sci.getsEnglish()
				+ "','"
				+ sci.getsPhysics()
				+ "','"
				+ sci.getsChemistry()
				+ "','"
				+ sci.getsBiology()
				+ "','"
				+ sci.getsTotal()
				+ "','"
				+ sci.getsTime() + "','" + sci.getsSearchTime() + "')";
		try {
			db.execSQL(sql);
			Log.w("debug", sql);
			db.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// 根据用户id查询文科语文成绩
	// 返回语文成绩
	public ArrayList<Art> searchArtChinese(int uid) {
		GradeAnalysisOpenHelper ga = new GradeAnalysisOpenHelper();
		SQLiteDatabase db = ga.getConnection();
		// 将查询的结果返回到ArrayList中
		ArrayList<Art> al = new ArrayList<Art>();
		String sql = "select aChinese,aTime from Art where usid=" + uid
				+ " order by aSearchTime";
		Cursor cs = db.rawQuery(sql, null);
		try {
			if (cs.moveToFirst()) {
				do {
					double aChinese = cs.getDouble(cs
							.getColumnIndex("aChinese"));
					String aTime = cs.getString(cs.getColumnIndex("aTime"));
					Art art = new Art();
					art.setaChinese(aChinese);
					art.setaTime(aTime);
					al.add(art);
				} while (cs.moveToNext());
			}
			cs.close();
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}

	/**
	 * 根据用户id查询文科数学成绩
	 * 
	 * @param uid
	 * @return
	 */
	public ArrayList<Art> searchArtMath(int uid) {
		GradeAnalysisOpenHelper ga = new GradeAnalysisOpenHelper();
		SQLiteDatabase db = ga.getConnection();
		// 将查询的结果返回到ArrayList中
		ArrayList<Art> al = new ArrayList<Art>();
		String sql = "select aMath,aTime from Art where usid=" + uid
				+ " order by aSearchTime";
		Cursor cs = db.rawQuery(sql, null);
		try {
			if (cs.moveToFirst()) {
				do {
					double aMath = cs.getDouble(cs.getColumnIndex("aMath"));
					String aTime = cs.getString(cs.getColumnIndex("aTime"));
					Art art = new Art();
					art.setaMath(aMath);
					art.setaTime(aTime);
					al.add(art);
				} while (cs.moveToNext());
			}
			cs.close();
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}

	/**
	 * 根据用户id查询文科英语成绩
	 * 
	 * @param uid
	 * @return
	 */
	public ArrayList<Art> searchArtEnglish(int uid) {
		GradeAnalysisOpenHelper ga = new GradeAnalysisOpenHelper();
		SQLiteDatabase db = ga.getConnection();
		// 将查询的结果返回到ArrayList中
		ArrayList<Art> al = new ArrayList<Art>();
		String sql = "select aEnglish,aTime from Art where usid=" + uid
				+ " order by aSearchTime";
		Cursor cs = db.rawQuery(sql, null);
		try {
			if (cs.moveToFirst()) {
				do {
					double aEnglish = cs.getDouble(cs
							.getColumnIndex("aEnglish"));
					String aTime = cs.getString(cs.getColumnIndex("aTime"));
					Art art = new Art();
					art.setaEnglish(aEnglish);
					art.setaTime(aTime);
					al.add(art);
				} while (cs.moveToNext());
			}
			cs.close();
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}

	/**
	 * 根据用户id查询文科政治成绩
	 * 
	 * @param uid
	 * @return
	 */
	public ArrayList<Art> searchArtPolitics(int uid) {
		GradeAnalysisOpenHelper ga = new GradeAnalysisOpenHelper();
		SQLiteDatabase db = ga.getConnection();
		// 将查询的结果返回到ArrayList中
		ArrayList<Art> al = new ArrayList<Art>();
		String sql = "select aPolitics,aTime from Art where usid=" + uid
				+ " order by aSearchTime";
		Cursor cs = db.rawQuery(sql, null);
		try {
			if (cs.moveToFirst()) {
				do {
					double aPolitics = cs.getDouble(cs
							.getColumnIndex("aPolitics"));
					String aTime = cs.getString(cs.getColumnIndex("aTime"));
					Art art = new Art();
					art.setaPolitics(aPolitics);
					art.setaTime(aTime);
					al.add(art);
				} while (cs.moveToNext());
			}
			cs.close();
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}

	/**
	 * 根据用户id查询文科历史成绩
	 * 
	 * @param uid
	 * @return
	 */
	public ArrayList<Art> searchArtHistory(int uid) {
		GradeAnalysisOpenHelper ga = new GradeAnalysisOpenHelper();
		SQLiteDatabase db = ga.getConnection();
		// 将查询的结果返回到ArrayList中
		ArrayList<Art> al = new ArrayList<Art>();
		String sql = "select aHistory,aTime from Art where usid=" + uid
				+ " order by aSearchTime";
		Cursor cs = db.rawQuery(sql, null);
		try {
			if (cs.moveToFirst()) {
				do {
					double aHistory = cs.getDouble(cs
							.getColumnIndex("aHistory"));
					String aTime = cs.getString(cs.getColumnIndex("aTime"));
					Art art = new Art();
					art.setaHistory(aHistory);
					art.setaTime(aTime);
					al.add(art);
				} while (cs.moveToNext());
			}
			cs.close();
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}

	/**
	 * 根据用户id查询文科地理成绩
	 * 
	 * @param uid
	 * @return
	 */
	public ArrayList<Art> searchArtGeology(int uid) {
		GradeAnalysisOpenHelper ga = new GradeAnalysisOpenHelper();
		SQLiteDatabase db = ga.getConnection();
		// 将查询的结果返回到ArrayList中
		ArrayList<Art> al = new ArrayList<Art>();
		String sql = "select aGeology,aTime from Art where usid=" + uid
				+ " order by aSearchTime";
		Cursor cs = db.rawQuery(sql, null);
		try {
			if (cs.moveToFirst()) {
				do {
					double aGeology = cs.getDouble(cs
							.getColumnIndex("aGeology"));
					String aTime = cs.getString(cs.getColumnIndex("aTime"));
					Art art = new Art();
					art.setaGeology(aGeology);
					art.setaTime(aTime);
					al.add(art);
				} while (cs.moveToNext());
			}
			cs.close();
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}

	/**
	 * 根据用户id查询文科总成绩
	 * 
	 * @param uid
	 * @return
	 */
	public ArrayList<Art> searchArtTotal(int uid) {
		GradeAnalysisOpenHelper ga = new GradeAnalysisOpenHelper();
		SQLiteDatabase db = ga.getConnection();
		// 将查询的结果返回到ArrayList中
		ArrayList<Art> al = new ArrayList<Art>();
		String sql = "select aTotal,aTime from Art where usid=" + uid
				+ " order by aSearchTime";
		Cursor cs = db.rawQuery(sql, null);
		try {
			if (cs.moveToFirst()) {
				do {
					double aTotal = cs.getDouble(cs.getColumnIndex("aTotal"));
					String aTime = cs.getString(cs.getColumnIndex("aTime"));
					Art art = new Art();
					art.setaTotal(aTotal);
					art.setaTime(aTime);
					al.add(art);
				} while (cs.moveToNext());
			}
			cs.close();
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}

	/**
	 * 根据用户id查询理科语文成绩
	 * 
	 * @param uid
	 * @return
	 */
	public ArrayList<Science> searchScienceChinese(int uid) {
		GradeAnalysisOpenHelper ga = new GradeAnalysisOpenHelper();
		SQLiteDatabase db = ga.getConnection();
		// 将查询的结果返回到ArrayList中
		ArrayList<Science> al = new ArrayList<Science>();
		String sql = "select sChinese,sTime from Science where usid=" + uid
				+ " order by sSearchTime";
		Cursor cs = db.rawQuery(sql, null);
		try {
			if (cs.moveToFirst()) {
				do {
					double sChinese = cs.getDouble(cs
							.getColumnIndex("sChinese"));
					String sTime = cs.getString(cs.getColumnIndex("sTime"));
					Science sci = new Science();
					sci.setsChinese(sChinese);
					sci.setsTime(sTime);
					al.add(sci);
				} while (cs.moveToNext());
			}
			cs.close();
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}

	/**
	 * 根据用户id查询理科数学成绩
	 * 
	 * @param uid
	 * @return
	 */
	public ArrayList<Science> searchScienceMath(int uid) {
		GradeAnalysisOpenHelper ga = new GradeAnalysisOpenHelper();
		SQLiteDatabase db = ga.getConnection();
		// 将查询的结果返回到ArrayList中
		ArrayList<Science> al = new ArrayList<Science>();
		String sql = "select sMath,sTime from Science where usid=" + uid
				+ " order by sSearchTime";
		Cursor cs = db.rawQuery(sql, null);
		try {
			if (cs.moveToFirst()) {
				do {
					double sMath = cs.getDouble(cs.getColumnIndex("sMath"));
					String sTime = cs.getString(cs.getColumnIndex("sTime"));
					Science sci = new Science();
					sci.setsMath(sMath);
					sci.setsTime(sTime);
					al.add(sci);
				} while (cs.moveToNext());
			}
			cs.close();
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}

	/**
	 * 根据用户id查询理科英语成绩
	 * 
	 * @param uid
	 * @return
	 */
	public ArrayList<Science> searchScienceEnglish(int uid) {
		GradeAnalysisOpenHelper ga = new GradeAnalysisOpenHelper();
		SQLiteDatabase db = ga.getConnection();
		// 将查询的结果返回到ArrayList中
		ArrayList<Science> al = new ArrayList<Science>();
		String sql = "select sEnglish,sTime from Science where usid=" + uid
				+ " order by sSearchTime";
		Cursor cs = db.rawQuery(sql, null);
		try {
			if (cs.moveToFirst()) {
				do {
					double sEnglish = cs.getDouble(cs
							.getColumnIndex("sEnglish"));
					String sTime = cs.getString(cs.getColumnIndex("sTime"));
					Science sci = new Science();
					sci.setsEnglish(sEnglish);
					sci.setsTime(sTime);
					al.add(sci);
				} while (cs.moveToNext());
			}
			cs.close();
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}

	/**
	 * 根据用户id查询理科物理成绩
	 * 
	 * @param uid
	 * @return
	 */
	public ArrayList<Science> searchSciencePhysical(int uid) {
		GradeAnalysisOpenHelper ga = new GradeAnalysisOpenHelper();
		SQLiteDatabase db = ga.getConnection();
		// 将查询的结果返回到ArrayList中
		ArrayList<Science> al = new ArrayList<Science>();
		String sql = "select sPhysics,sTime from Science where usid=" + uid
				+ " order by sSearchTime";
		Cursor cs = db.rawQuery(sql, null);
		try {
			if (cs.moveToFirst()) {
				do {
					double sPhysics = cs.getDouble(cs
							.getColumnIndex("sPhysics"));
					String sTime = cs.getString(cs.getColumnIndex("sTime"));
					Science sci = new Science();
					sci.setsPhysics(sPhysics);
					sci.setsTime(sTime);
					al.add(sci);
				} while (cs.moveToNext());
			}
			cs.close();
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}

	/**
	 * 根据用户id查询理科化学成绩
	 * 
	 * @param uid
	 * @return
	 */
	public ArrayList<Science> searchScienceChemistry(int uid) {
		GradeAnalysisOpenHelper ga = new GradeAnalysisOpenHelper();
		SQLiteDatabase db = ga.getConnection();
		// 将查询的结果返回到ArrayList中
		ArrayList<Science> al = new ArrayList<Science>();
		String sql = "select sChemistry,sTime from Science where usid=" + uid
				+ " order by sSearchTime";
		Cursor cs = db.rawQuery(sql, null);
		try {
			if (cs.moveToFirst()) {
				do {
					double sChemistry = cs.getDouble(cs
							.getColumnIndex("sChemistry"));
					String sTime = cs.getString(cs.getColumnIndex("sTime"));
					Science sci = new Science();
					sci.setsChemistry(sChemistry);
					sci.setsTime(sTime);
					al.add(sci);
				} while (cs.moveToNext());
			}
			cs.close();
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}

	/**
	 * 根据用户id查询理科地理成绩
	 * 
	 * @param uid
	 * @return
	 */
	public ArrayList<Science> searchScienceBiology(int uid) {
		GradeAnalysisOpenHelper ga = new GradeAnalysisOpenHelper();
		SQLiteDatabase db = ga.getConnection();
		// 将查询的结果返回到ArrayList中
		ArrayList<Science> al = new ArrayList<Science>();
		String sql = "select sBiology,sTime from Science where usid=" + uid
				+ " order by sSearchTime";
		Cursor cs = db.rawQuery(sql, null);
		try {
			if (cs.moveToFirst()) {
				do {
					double sBiology = cs.getDouble(cs
							.getColumnIndex("sBiology"));
					String sTime = cs.getString(cs.getColumnIndex("sTime"));
					Science sci = new Science();
					sci.setsBiology(sBiology);
					sci.setsTime(sTime);
					al.add(sci);
				} while (cs.moveToNext());
			}
			cs.close();
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}

	/**
	 * 根据用户id查询理科总成绩
	 * 
	 * @param uid
	 * @return
	 */
	public ArrayList<Science> searchScienceTotal(int uid) {
		GradeAnalysisOpenHelper ga = new GradeAnalysisOpenHelper();
		SQLiteDatabase db = ga.getConnection();
		// 将查询的结果返回到ArrayList中
		ArrayList<Science> al = new ArrayList<Science>();
		String sql = "select sTotal,sTime from Science where usid=" + uid
				+ " order by sSearchTime";
		Cursor cs = db.rawQuery(sql, null);
		try {
			if (cs.moveToFirst()) {
				do {
					double sTotal = cs.getDouble(cs.getColumnIndex("sTotal"));
					String sTime = cs.getString(cs.getColumnIndex("sTime"));
					Science sci = new Science();
					sci.setsTotal(sTotal);
					sci.setsTime(sTime);
					al.add(sci);
				} while (cs.moveToNext());
			}
			cs.close();
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}
}
