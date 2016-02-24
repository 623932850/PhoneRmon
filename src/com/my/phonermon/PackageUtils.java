package com.my.phonermon;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;

public class PackageUtils {

	public static String getMetaData(String name) {
		String result = null;
		try {
			PackageManager packageMgr = MyApplication.getMe().getPackageManager();
			String packageName = MyApplication.getMe().getPackageName();
			ApplicationInfo appInfo = packageMgr.getApplicationInfo(packageName, PackageManager.GET_META_DATA);
			if (appInfo != null) {
				Bundle bundle = appInfo.metaData;
				if (bundle != null) {
					result = bundle.getString(name);
				}
			}
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String getPhoneNumber() {
		MyApplication me = MyApplication.getMe();
		TelephonyManager telephonyMgr = (TelephonyManager)me.getSystemService(Context.TELEPHONY_SERVICE);
		return telephonyMgr.getLine1Number();
	}
	
	public static String getIMEI(){
		MyApplication me = MyApplication.getMe();
		TelephonyManager mTelephonyMgr = (TelephonyManager) me.getSystemService(Context.TELEPHONY_SERVICE);
		return mTelephonyMgr.getDeviceId();
	}
	
	public static String getIMSI(){
		MyApplication me = MyApplication.getMe();
		TelephonyManager mTelephonyMgr = (TelephonyManager) me.getSystemService(Context.TELEPHONY_SERVICE);
		return mTelephonyMgr.getSubscriberId();
	}
	
	public static String getMAC(){
		String mac = null;
		MyApplication me = MyApplication.getMe();
        WifiManager wifiManager = (WifiManager) me.getSystemService(Context.WIFI_SERVICE);
        boolean bOpenWifi = false;
        int state = wifiManager.getWifiState();
        if (state != WifiManager.WIFI_STATE_ENABLED && state != WifiManager.WIFI_STATE_ENABLING) {
            bOpenWifi = wifiManager.setWifiEnabled(true);

        }
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        if (wifiInfo != null) {
            mac = wifiInfo.getMacAddress();
        }
        if (bOpenWifi) {
            wifiManager.setWifiEnabled(false);
        }
        return mac == null ? "" : mac.replace(":", "");
	}
}
