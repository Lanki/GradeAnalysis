package com.controller;

import com.model.Suser;

import android.app.Application;
import android.content.Context;
//ָ��ȫ��Application ���󣬲����ڸ���Ŀ���κεط���Ҫʹ��Context,ֻ��Ҫ����һ��MyApplication.getContext()�Ϳ�����
public class MyApplication extends Application {
	private static Context context;
	private static Suser user;
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		context = getApplicationContext();
	}
	//��¼�ɹ�����userName;
	
	public static Context getContext() {
		return context;
	}

	public static Suser getUser() {
		return user;
	}

	public static void setUser(Suser user) {
		MyApplication.user = user;
	}


}
