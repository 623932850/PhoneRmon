package com.my.phonermon;

import android.app.Application;
import cn.bmob.v3.Bmob;

import com.my.phonermon.utils.PackageUtils;

public class MyApplication extends Application{
	
	private static MyApplication me;
	
	@Override
	public void onCreate() {
		super.onCreate();
		me = this;
		Bmob.initialize(this,  PackageUtils.getMetaData("bomb_app_id"));
	}
	
	public static MyApplication getMe(){
		return me;
	}
	
	
}
