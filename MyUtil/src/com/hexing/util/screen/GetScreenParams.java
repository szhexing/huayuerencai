package com.hexing.util.screen;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

public class GetScreenParams {
	public static int getScreenParameter(Activity activity) {
		DisplayMetrics dm = new DisplayMetrics();

		activity.getWindowManager().getDefaultDisplay().getMetrics(dm);

		int height = dm.heightPixels;
		return height;
	}

	public static int getScreenWidth(Activity activity) {
		DisplayMetrics dm = new DisplayMetrics();

		activity.getWindowManager().getDefaultDisplay().getMetrics(dm);

		int width = dm.widthPixels;
		return width;
	}

	/**
	 * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
	 */
	public static int dip2px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}
}
