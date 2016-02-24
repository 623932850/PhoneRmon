package com.my.phonermon.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{

	public DatabaseHelper(Context context) {
		super(context, "phoneRmon", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("Create table tb_sms ( _id integer primary key autoincrement, USER_NAME TEXT);");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("drop table if exists tb_sms");
        onCreate(db);
	}

}
