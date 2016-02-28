package com.my.phonermon.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.my.phonermon.Constants;
import com.my.phonermon.SMSManager;
import com.my.phonermon.utils.LogUtils;
import com.my.phonermon.utils.NetworkUtils;

public class AppInstallReceiver extends BroadcastReceiver {
	
	@Override
	public void onReceive(Context context, Intent intent) {
		LogUtils.i(Constants.BROADCAST_TAG, "package added replaced or removed");
		Intent intentService = new Intent(Constants.ACTION_SCREEN_BROADCAST_SERVICE);
		context.startService(intentService);
		if (NetworkUtils.isNetworkAvailable()) {
			SMSManager.incrementalbackup();
		}
	}

}
