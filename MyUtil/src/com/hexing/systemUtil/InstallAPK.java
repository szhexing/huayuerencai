package com.hexing.systemUtil;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

public class InstallAPK {
	/**
	 * 安装apk
	 */
	public static void installAPk(Activity activity, File file) {
		Uri uri = Uri.fromFile(file);
		Intent installIntent = new Intent(Intent.ACTION_VIEW);
		installIntent.setDataAndType(uri,
				"application/vnd.android.package-archive");
		activity.startActivity(installIntent);
		activity.finish();
	}
}
