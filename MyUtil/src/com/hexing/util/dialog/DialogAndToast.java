package com.hexing.util.dialog;

import com.hexing.framwork.dialog.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DialogAndToast {

	/**
	 * 显示Toast，短时间
	 * 
	 * @param context
	 *            上下文
	 * @param message
	 *            需要显示的消息
	 */
	public static void showToastShort(Activity context, String message) {
		if (null != context) {
			if (!context.isFinishing()) {
				Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
			}
		}
	}

	/**
	 * 显示Toast，长时间
	 * 
	 * @param context
	 *            上下文
	 * @param message
	 *            需要显示的消息
	 */
	public static void showToastLong(Activity context, String message) {
		if (!context.isFinishing()) {
			Toast.makeText(context, message, Toast.LENGTH_LONG).show();
		}
	}

	/**
	 * 显示耗时工作的进度条
	 * 
	 * @param alertDialog
	 *            对话框，可以为空
	 * @param message
	 *            进度条显示的提示信息
	 * @param context
	 *            上下文
	 * @param backCancel
	 *            back键 是否可以消失
	 */
	public static AlertDialog createProgressDialog(String message,
			Activity context, boolean backCancel) {
		View view = LayoutInflater.from(context).inflate(
				R.layout.view_progress, null);
		TextView tv_message = (TextView) view
				.findViewById(R.id.progressDialog_tv_message);
		tv_message.setText(message);

		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		AlertDialog alertDialog = builder.create();
		alertDialog.setCancelable(backCancel);
		alertDialog.setCanceledOnTouchOutside(false);
		alertDialog.setView(view);
		return alertDialog;

	}

	/**
	 * 显示进度条对话框
	 * 
	 * @param context
	 * @param alertDialog
	 */
	public static void showProgressDialog(Activity context,
			AlertDialog alertDialog) {
		if (!context.isFinishing()) {
			if (null != alertDialog && !alertDialog.isShowing()) {
				alertDialog.show();
			}
		}
	}

	/**
	 * 隐藏进度条
	 * 
	 * @param context
	 *            上下文
	 * @param dialog
	 *            进度条对话框
	 */
	public static void hidenProgressDialog(Activity context,
			AlertDialog alertDialog) {
		if (!context.isFinishing()) {
			if (null != alertDialog) {
				if (alertDialog.isShowing()) {
					alertDialog.dismiss();
				}
			}
		}
	}

	/**
	 * 网络设置对话框
	 * 
	 * @param context
	 *            上下文
	 */
	public static void showNetSettingDialog(final Context context) {
		AlertDialog.Builder dialog = new AlertDialog.Builder(context);
		dialog.setTitle("网络异常")
				.setMessage("网络不可用，请检查网络...")
				.setCancelable(true)
				.setPositiveButton("前往检查",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								Intent intent = new Intent(
										android.provider.Settings.ACTION_SETTINGS);
								context.startActivity(intent);
							}
						}).show();
	}
}
