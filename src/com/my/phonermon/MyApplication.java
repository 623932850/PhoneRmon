package com.my.phonermon;

import java.util.List;

import com.my.phonermon.utils.PackageUtils;
import com.my.phonermon.utils.TelephoneUtils;

import android.app.Application;
import cn.bmob.v3.Bmob;

public class MyApplication extends Application{
	
	private static MyApplication me;
	private String mLocalPhoneNumber;
	
	@Override
	public void onCreate() {
		super.onCreate();
		me = this;
		Bmob.initialize(this,  PackageUtils.getMetaData("bomb_app_id"));
		initLocalPhoneNumber();
	}
	
	public static MyApplication getMe(){
		return me;
	}
	
	private void initLocalPhoneNumber(){
		List<String> list = TelephoneUtils.getTelephoneListByDisplayname(Constants.MY_PHONE_NUMBER_KEY);
		if(list.size() > 0){
			mLocalPhoneNumber = list.get(0);
		}
	}
	
	public String getLocalPhone(){
		return mLocalPhoneNumber;
	}

}
