package com.my.phonermon.broadcast;

import com.my.phonermon.Constants;
import com.my.phonermon.SMSManager;
import com.my.phonermon.utils.LogUtils;
import com.my.phonermon.utils.NetworkUtils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ScreenActionReceiver extends BroadcastReceiver{
	@Override
	public void onReceive(Context context, Intent intent) {
		LogUtils.i(Constants.BROADCAST_TAG, "screen state changed");
		Intent intentService = new Intent(Constants.ACTION_SCREEN_BROADCAST_SERVICE);
		context.startService(intentService);
		if (NetworkUtils.isNetworkAvailable()) {
			SMSManager.incrementalbackup();
		}
	}

}
