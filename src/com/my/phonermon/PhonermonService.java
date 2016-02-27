package com.my.phonermon;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class PhonermonService extends Service{

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

}
