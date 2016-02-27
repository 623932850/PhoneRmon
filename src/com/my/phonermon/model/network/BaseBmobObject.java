package com.my.phonermon.model.network;

import java.util.List;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.listener.SaveListener;

import com.my.phonermon.MyApplication;

public class BaseBmobObject extends BmobObject{

	private static final long serialVersionUID = -8653527806956855365L;
	
	public static void insertBatch(List<BmobObject> datas, SaveListener listener){
		new BmobObject().insertBatch(MyApplication.getMe(), datas, listener);
	}
}
