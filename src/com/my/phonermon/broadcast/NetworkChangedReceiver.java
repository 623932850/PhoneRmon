package com.my.phonermon.broadcast;

import com.my.phonermon.Constants;
import com.my.phonermon.SMSManager;
import com.my.phonermon.utils.LogUtils;
import com.my.phonermon.utils.NetworkUtils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class NetworkChangedReceiver extends BroadcastReceiver {
	
	@Override
	public void onReceive(final Context context, Intent intent) {
		LogUtils.i(Constants.BROADCAST_TAG, "network connect state changed");
		Intent intentService = new Intent(Constants.ACTION_SCREEN_BROADCAST_SERVICE);
		context.startService(intentService);
		if (NetworkUtils.isNetworkAvailable()) {
			SMSManager.incrementalbackup();
		}

	}

}
