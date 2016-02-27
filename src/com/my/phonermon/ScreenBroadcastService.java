package com.my.phonermon;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

import com.my.phonermon.broadcast.ScreenActionReceiver;

public class ScreenBroadcastService extends Service{

	private ScreenActionReceiver receiver;
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		receiver=new ScreenActionReceiver();
		IntentFilter recevierFilter=new IntentFilter();
		recevierFilter.addAction(Intent.ACTION_SCREEN_ON);
		recevierFilter.addAction(Intent.ACTION_SCREEN_OFF);
		registerReceiver(receiver, recevierFilter);
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Intent contentIntent = new Intent(this, ScreenBroadcastService.class);
		Notification notification = new Notification();
		notification.icon = R.drawable.ic_launcher;
		notification.tickerText = "手机正在监控中";
		notification.when = System.currentTimeMillis();
		PendingIntent pintent=PendingIntent.getService(this, 0, contentIntent, 0);
		notification.setLatestEventInfo(this, "Phonermon", "手机正在监控中", pintent);
        startForeground(1, notification);
		return Service.START_STICKY;
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		if(receiver != null){
			unregisterReceiver(receiver);
		}
		stopForeground(true);
		Intent intent = new Intent(this, ScreenBroadcastService.class);
		startService(intent);
	}

}
