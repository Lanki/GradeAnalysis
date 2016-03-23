package com.model;


public class Science {
	//理科类
	private int sid;
	private int usid;
	private double sChinese;
	private double sMath;
	private double sEnglish;
	private double sPhysics;
	private double sChemistry;
	private double sBiology;
	private double sTotal;
	private String sTime;//时间
	private long sSearchTime;//查询功能按时间排序
	
	
	
	public long getsSearchTime() {
		return sSearchTime;
	}
	public void setsSearchTime(long sSearchTime) {
		this.sSearchTime = sSearchTime;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getUsid() {
		return usid;
	}
	public void setUsid(int usid) {
		this.usid = usid;
	}
	public double getsChinese() {
		return sChinese;
	}
	public void setsChinese(double sChinese) {
		this.sChinese = sChinese;
	}
	public double getsMath() {
		return sMath;
	}
	public void setsMath(double sMath) {
		this.sMath = sMath;
	}
	public double getsEnglish() {
		return sEnglish;
	}
	public void setsEnglish(double sEnglish) {
		this.sEnglish = sEnglish;
	}
	public double getsPhysics() {
		return sPhysics;
	}
	public void setsPhysics(double sPhysics) {
		this.sPhysics = sPhysics;
	}
	public double getsChemistry() {
		return sChemistry;
	}
	public void setsChemistry(double sChemistry) {
		this.sChemistry = sChemistry;
	}
	public double getsBiology() {
		return sBiology;
	}
	public void setsBiology(double sBiology) {
		this.sBiology = sBiology;
	}
	public double getsTotal() {
		return sTotal;
	}
	public void setsTotal(double sTotal) {
		this.sTotal = sTotal;
	}
	public String getsTime() {
		return sTime;
	}
	public void setsTime(String sTime) {
		this.sTime = sTime;
	}
	
}
