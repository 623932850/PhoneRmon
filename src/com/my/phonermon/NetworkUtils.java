package com.my.phonermon;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtils {

	public static boolean isNetworkAvailable(){
		MyApplication me = MyApplication.getMe();
		ConnectivityManager connMgr = (ConnectivityManager)me.getSystemService(Context.CONNECTIVITY_SERVICE);
		if(connMgr == null){
			return false;
		}
		NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
		if(networkInfo != null){
			return networkInfo.isAvailable();
		}
		return false;
	}
	
	public static boolean isWifiEnable(){
		MyApplication me = MyApplication.getMe();
		ConnectivityManager connMgr = (ConnectivityManager)me.getSystemService(Context.CONNECTIVITY_SERVICE);
		if(connMgr == null){
			return false;
		}
		NetworkInfo networkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		if(networkInfo != null){
			return networkInfo.isAvailable();
		}
		return false;
	}
	
	public static boolean isMobileEnable(){
		MyApplication me = MyApplication.getMe();
		ConnectivityManager connMgr = (ConnectivityManager)me.getSystemService(Context.CONNECTIVITY_SERVICE);
		if(connMgr == null){
			return false;
		}
		NetworkInfo networkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		if(networkInfo != null){
			return networkInfo.isAvailable();
		}
		return false;
	}
}
