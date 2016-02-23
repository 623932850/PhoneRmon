package com.my.phonermon;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;

public class PackageUtils {

	public static String getMetaData(String name){
		String result = null;
		try {
			PackageManager packageMgr = MyApplication.getMe().getPackageManager();
			String packageName = MyApplication.getMe().getPackageName();
			ApplicationInfo appInfo = packageMgr.getApplicationInfo(packageName, PackageManager.GET_META_DATA);
			if(appInfo != null){
				Bundle bundle = appInfo.metaData;
				if(bundle != null){
					result = bundle.getString("bomb_app_id");
				}
			}
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}
}
