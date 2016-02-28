package com.my.phonermon.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SPUtils {
	
	private static final String DEF_PREFS = "phoneRmon";
	private SharedPreferences mPrefs; 
	
	public SPUtils(Context context){
		this(context, DEF_PREFS);
	}
	
	public SPUtils(Context context, String name){
		mPrefs = context.getSharedPreferences(name, Context.MODE_PRIVATE);
	}
	
	public String getString(String key, String defValue){
		return mPrefs.getString(key, defValue);
	}
	
	public void setString(String key, String value){
		mPrefs.edit().putString(key, value).commit();
	}

}
