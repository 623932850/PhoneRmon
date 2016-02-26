package com.my.phonermon;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

public class DBUtils {
	
	public static <T> List<T> query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder, Class<T> clazz){
		List<T> result = new ArrayList<T>();
		MyApplication me = MyApplication.getMe();
		ContentResolver contentResolver = me.getContentResolver();
		Cursor cursor = contentResolver.query(uri, projection, selection, selectionArgs, sortOrder);
		try {
			while (cursor != null && cursor.moveToNext()) {
				T t = clazz.newInstance();
				int len = cursor.getColumnCount();
				for (int i = 0; i < len; i++) {
					try {
						String fieldName = cursor.getColumnName(i);
						Field field = clazz.getDeclaredField(fieldName);
						field.setAccessible(true);
						Class<?> declaringClazz = field.getType();
						if (declaringClazz == Integer.class){
							field.set(t, Integer.valueOf(cursor.getInt(i)));
						} else if(declaringClazz == Long.class){
							field.set(t, Long.valueOf(cursor.getLong(i)));
						} else if (declaringClazz == int.class) {
							field.setInt(t, cursor.getInt(i));
						} else if (declaringClazz == long.class) {
							field.setLong(t, cursor.getLong(i));
						} else if (declaringClazz == String.class) {
							field.set(t, cursor.getString(i));
						}
					} catch (NoSuchFieldException e) {
						e.printStackTrace();
					}catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
				result.add(t);
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally {
			if(cursor != null && !cursor.isClosed()){
				cursor.close();
			}
		}
		return result;
	}

}
