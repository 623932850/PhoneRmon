package com.my.phonermon.utils;

import java.util.ArrayList;
import java.util.List;

import com.my.phonermon.MyApplication;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;

public class TelephoneUtils {
	
	public static List<String> getTelephoneListByDisplayname(String displayName){
		List<String> result = new ArrayList<String>();
		Cursor phoneCursor = null;
		Cursor contactInfoCursor = null;
		try {
			MyApplication me = MyApplication.getMe();
			ContentResolver contentResolver = me.getContentResolver();
			String selection = ContactsContract.Contacts.DISPLAY_NAME + "=?";
			contactInfoCursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, selection, new String[]{displayName}, null);
			if(contactInfoCursor != null && contactInfoCursor.getCount() > 0){
				int contactsId = contactInfoCursor.getColumnIndex(ContactsContract.Contacts._ID);
				while(contactInfoCursor != null && contactInfoCursor.moveToNext()){
					String contactId = contactInfoCursor.getString(contactsId);
					selection = ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=?";
					phoneCursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, selection, new String[]{contactId}, null);
					if(phoneCursor != null && phoneCursor.getCount() > 0) {
						int phoneIndex = phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
						while(phoneCursor.moveToNext()) {
			                String phoneNumber = phoneCursor.getString(phoneIndex);
			                result.add(phoneNumber);
			            }
			        }
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(phoneCursor != null && !phoneCursor.isClosed()){
				phoneCursor.close();
			}
			if(contactInfoCursor != null && !contactInfoCursor.isClosed()){
				contactInfoCursor.close();
			}
		}
		return result;
	}

}
