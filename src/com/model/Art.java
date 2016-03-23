package com.model;


public class Art {
	//文科类
	private int aid;
	private int usid;
	private double aChinese;
	private double aMath;
	private double aEnglish;
	private double aPolitics;
	private double aHistory;
	private double aGeology;
	private double aTotal;
	private String aTime;//时间
	private long aSearchTime;//查询功能按时间排序
	
	
	public long getaSearchTime() {
		return aSearchTime;
	}
	public void setaSearchTime(long aSearchTime) {
		this.aSearchTime = aSearchTime;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getUsid() {
		return usid;
	}
	public void setUsid(int usid) {
		this.usid = usid;
	}
	public double getaChinese() {
		return aChinese;
	}
	public void setaChinese(double aChinese) {
		this.aChinese = aChinese;
	}
	public double getaMath() {
		return aMath;
	}
	public void setaMath(double aMath) {
		this.aMath = aMath;
	}
	public double getaEnglish() {
		return aEnglish;
	}
	public void setaEnglish(double aEnglish) {
		this.aEnglish = aEnglish;
	}
	public double getaPolitics() {
		return aPolitics;
	}
	public void setaPolitics(double aPolitics) {
		this.aPolitics = aPolitics;
	}
	public double getaHistory() {
		return aHistory;
	}
	public void setaHistory(double aHistory) {
		this.aHistory = aHistory;
	}
	public double getaGeology() {
		return aGeology;
	}
	public void setaGeology(double aGeology) {
		this.aGeology = aGeology;
	}
	public double getaTotal() {
		return aTotal;
	}
	public void setaTotal(double aTotal) {
		this.aTotal = aTotal;
	}
	public String getaTime() {
		return aTime;
	}
	public void setaTime(String aTime) {
		this.aTime = aTime;
	}
	
}
