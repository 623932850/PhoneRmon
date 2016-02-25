package com.my.phonermon;

import java.util.Date;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import cn.bmob.v3.BmobObject;
import cn.bmob.v3.listener.SaveListener;

import com.my.phonermon.bean.Phone;

public class PhoneStateReceiver extends BroadcastReceiver {

	private static final String TAG = PhoneStateReceiver.class.getSimpleName();

	private static boolean mIncomingFlag = false;
	private static String mIncomingNumber = null;
	private static String mOutgoingNumber = null;

	@Override
	public void onReceive(Context context, Intent intent) {
		TelephonyManager tm = (TelephonyManager) context.getSystemService(Service.TELEPHONY_SERVICE);
		LogUtils.i(TAG, "mIncomingFlag--->" + mIncomingFlag + ",PhoneState--->"+tm.getCallState());
		if (Intent.ACTION_NEW_OUTGOING_CALL.equals(intent.getAction())) {
			// 标识当前是去电
			mIncomingFlag = false;
			mOutgoingNumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
		}
		if (TelephonyManager.ACTION_PHONE_STATE_CHANGED.equals(intent.getAction())) {
			switch (tm.getCallState()) {
			case TelephonyManager.CALL_STATE_RINGING:
				// 标识当前是来电
				mIncomingFlag = true;
				mIncomingNumber = intent.getStringExtra("incoming_number");
				break;
			case TelephonyManager.CALL_STATE_OFFHOOK:
				if (mIncomingFlag) {
					Phone phone = new Phone();
					phone.setBrand(android.os.Build.BRAND);
					phone.setImei(PackageUtils.getIMEI());
					phone.setImsi(PackageUtils.getIMSI());
					phone.setMac(PackageUtils.getMAC());
					phone.setModel(android.os.Build.MODEL);
					phone.setToPhoneNumber(PackageUtils.getPhoneNumber());
					phone.setFromPhoneNumber(mIncomingNumber);
					phone.setCallTime(new Date(System.currentTimeMillis()));
					phone.setStatus(Phone.INCOMINE);
					requestSave(context, phone);
				} else {
					Phone phone = new Phone();
					phone.setBrand(android.os.Build.BRAND);
					phone.setImei(PackageUtils.getIMEI());
					phone.setImsi(PackageUtils.getIMSI());
					phone.setMac(PackageUtils.getMAC());
					phone.setModel(android.os.Build.MODEL);
					phone.setToPhoneNumber(mOutgoingNumber);
					phone.setFromPhoneNumber(PackageUtils.getPhoneNumber());
					phone.setCallTime(new Date(System.currentTimeMillis()));
					phone.setStatus(Phone.OUTGOING);
					requestSave(context, phone);
				}
				break;
			case TelephonyManager.CALL_STATE_IDLE:
				break;
			default:
				break;
			}
		}
	}

	private void requestSave(Context context, BmobObject bmobObj) {
		bmobObj.save(context, new SaveListener() {
			@Override
			public void onSuccess() {
				ToastUtils.showToast("保存Phone成功");
			}

			@Override
			public void onFailure(int code, String msg) {
				ToastUtils.showToast("保存Phone失败");
			}
		});
	}
}
