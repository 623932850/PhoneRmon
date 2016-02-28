package com.my.phonermon.utils;

import com.my.phonermon.MyApplication;

import android.widget.Toast;

public class ToastUtils {

	public static void showToast(String text){
		Toast.makeText(MyApplication.getMe(), text, Toast.LENGTH_LONG).show();
	}
	
	public static void showToast(int resId){
		MyApplication me = MyApplication.getMe();
		showToast(me.getString(resId));
	}
}
