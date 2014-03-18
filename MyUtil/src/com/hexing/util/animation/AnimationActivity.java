package com.hexing.util.animation;

import com.hexing.framwork.dialog.R;

import android.app.Activity;

public class AnimationActivity {

	public static void downOutAcitivty(Activity context) {
		context.overridePendingTransition(0, R.anim.slide_down_out);
	}

	public static void LeftOutRightIn(Activity context) {
		context.overridePendingTransition(R.anim.push_left_in,
				R.anim.push_left_out);
	}

	public static void upIn(Activity context) {
		context.overridePendingTransition(R.anim.slide_up_in,
				R.anim.push_up_out);

	}

}
