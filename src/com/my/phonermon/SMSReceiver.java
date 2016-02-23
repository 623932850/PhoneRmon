package com.my.phonermon;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

public class SMSReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Bundle bundle = intent.getExtras();
		Object messages[] = (Object[]) bundle.get("pdus");
		if (messages != null && messages.length > 0) {
			SmsMessage smsMessage[] = new SmsMessage[messages.length];
			for (int n = 0; n < smsMessage.length; n++) {
				smsMessage[n] = SmsMessage.createFromPdu((byte[]) messages[n]);
			}

			for (SmsMessage message : smsMessage) {
				String content = message.getMessageBody();// 得到短信内容
				String sender = message.getOriginatingAddress();// 得到发件人号码
			}

		}
	}

}
