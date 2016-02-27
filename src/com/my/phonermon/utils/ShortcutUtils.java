package com.my.phonermon.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

public class ShortcutUtils {

	public static void createIcon(Context context, int icon, String name, String className) {
		String ACTION_INSTALL_SHORTCUT = "com.android.launcher.action.INSTALL_SHORTCUT";
		String EXTRA_SHORTCUT_DUPLICATE = "duplicate";
		Intent shortCutIntent = new Intent(ACTION_INSTALL_SHORTCUT);
		shortCutIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, name);
		shortCutIntent.putExtra(EXTRA_SHORTCUT_DUPLICATE, false);
		Intent mainIntent = new Intent(Intent.ACTION_MAIN);
		mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
		mainIntent.setComponent(new ComponentName(context.getPackageName(), className));
		shortCutIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, mainIntent);
		shortCutIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE,Intent.ShortcutIconResource.fromContext(context, icon));
		context.sendBroadcast(shortCutIntent);
	}

	public static void deleteIcon(Context context, int icon, String name, String className) {
		String ACTION_UNINSTALL_SHORTCUT = "com.android.launcher.action.UNINSTALL_SHORTCUT";
		String EXTRA_SHORTCUT_DUPLICATE = "duplicate";
		Intent shortCutIntent = new Intent(ACTION_UNINSTALL_SHORTCUT);
		shortCutIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, name);
		shortCutIntent.putExtra(EXTRA_SHORTCUT_DUPLICATE, false);
		Intent mainIntent = new Intent(Intent.ACTION_MAIN);
		mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
		mainIntent.setComponent(new ComponentName(context.getPackageName(), className));
		shortCutIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, mainIntent);
		shortCutIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE,Intent.ShortcutIconResource.fromContext(context, icon));
		context.sendBroadcast(shortCutIntent);	}

}
