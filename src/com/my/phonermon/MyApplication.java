package com.my.phonermon;

import com.my.phonermon.utils.PackageUtils;

import android.app.Application;
import cn.bmob.v3.Bmob;

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
