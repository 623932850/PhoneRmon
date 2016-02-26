package com.my.phonermon;

import java.util.List;

import cn.bmob.v3.listener.FindListener;

import com.my.phonermon.model.network.SMS;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;

public class NetworkChangedReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(final Context context, Intent intent) {
		
		if(NetworkUtils.isNetworkAvailable()){
			SMS.queryAll(new FindListener<SMS>() {
				
				@Override
				public void onSuccess(List<SMS> datas) {
					ContentResolver contentResolver = context.getContentResolver();
					Cursor cursor = contentResolver.query(Uri.parse("content://SMS"), null, null, null, null);
					cursor.close();
					
					Class<SMS> clazz = SMS.class;
					try {
						clazz.getDeclaredField("");
					} catch (NoSuchFieldException e) {
						e.printStackTrace();
					}
				}
				
				@Override
				public void onError(int code, String msg) {
					
				}
			});
		}
		
	}

}
