package com.my.phonermon;

import android.support.v4.app.FragmentActivity;

import com.umeng.analytics.MobclickAgent;

public class BaseActivity extends FragmentActivity {

	public void onResume() {
		super.onResume();
		MobclickAgent.onPageStart(this.getClass().getSimpleName());
		MobclickAgent.onResume(this);
	}

	public void onPause() {
		super.onPause();
		 MobclickAgent.onPageEnd(this.getClass().getSimpleName());
		MobclickAgent.onPause(this);
	}
}
