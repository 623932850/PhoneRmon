package com.my.phonermon.broadcast;

import com.my.phonermon.Constants;
import com.my.phonermon.SMSManager;
import com.my.phonermon.ScreenBroadcastService;
import com.my.phonermon.utils.LogUtils;
import com.my.phonermon.utils.NetworkUtils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ScreenActionReceiver extends BroadcastReceiver{
	@Override
	public void onReceive(Context context, Intent intent) {
		LogUtils.i(Constants.BROADCAST_TAG, "screen state changed");
		Intent intentService = new Intent(context, ScreenBroadcastService.class);
		context.startService(intentService);
		if (NetworkUtils.isNetworkAvailable()) {
			SMSManager.incrementalbackup();
		}
	}

}
