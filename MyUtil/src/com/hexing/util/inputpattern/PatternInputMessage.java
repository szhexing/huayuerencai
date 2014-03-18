package com.hexing.util.inputpattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.widget.EditText;

public class PatternInputMessage {
	/**
	 * 汉字、字母、数字、下划线
	 * 
	 * @param view
	 * @return
	 */
	public static boolean patternAll(EditText view) {
		// 汉字、英文、下划线、数字正则表达式
		String HANZI_YINWEN_NUM = "[\u4e00-\u9fa5\\w]+";
		Pattern pattern = Pattern.compile(HANZI_YINWEN_NUM);
		String s = view.getText().toString().trim();
		Matcher matcher = pattern.matcher(s);
		if (!matcher.matches()) {
			view.setError("只能为汉字、字母、数字、下划线");
			return false;
		}
		return true;
	}

	/**
	 * 字母、数字、下划线
	 * 
	 * @param view
	 * @return
	 */
	public static boolean patternCharcterAndNum(EditText view) {
		// 字母、数字和下划线
		String YINWEN_AND_NUM = "[\\w]+";
		Pattern pattern = Pattern.compile(YINWEN_AND_NUM);
		String s = view.getText().toString().trim();
		Matcher matcher = pattern.matcher(s);
		if (!matcher.matches()) {
			view.setError("只能为字母、数字、下划线");
			return false;
		}
		return true;
	}

	/**
	 * 非空判断
	 * 
	 * @param view
	 * @return
	 */
	public static boolean emptyValite(EditText view) {
		String s = view.getText().toString().trim();
		if (s.length() == 0) {
			view.setError("不能为空");
			return false;
		}
		return true;
	}

	/**
	 * 手机号码判断
	 * 
	 * @param view
	 * @return
	 */
	public static boolean mobileValite(EditText view) {
		String s = view.getText().toString().trim();
		// 手机号验证
		// String mobileRegExp = "^((13[0-9])|(15[^4,\\D])|(18[0,1,5-9]))\\d{8}$";
		// 联通手机号验证
		String mobileRegExp = "^1(3[0-2]|5[56]|8[56])\\d{8}$";
		// 移动号码验证
		// String mobileRegExp = "^1(3[4-9]|5[012789]|8[78])\\d{8}$";
		// 电信号码
		// String mobileRegExp = "^(18[09]|1[35]3)\\d{8}$";
		Pattern p = Pattern.compile(mobileRegExp);
		Matcher m = p.matcher(s);
		if (m.matches() == false) {
			view.setError("手机号码有误");
			return false;
		}
		return true;
	}

	/**
	 * 密码两次是否相等验证
	 * 
	 * @param view1
	 * @param view2
	 * @return
	 */
	public static boolean passwordConfirm(EditText view1, EditText view2) {
		String s1 = view1.getText().toString().trim();
		String s2 = view2.getText().toString().trim();
		if (!s1.equals(s2)) {
			view2.setError("两次密码不一致");
			return false;
		}
		return true;
	}

	/**
	 * 邮箱验证
	 * 
	 * @param view1
	 * @return
	 */
	public static boolean emailValite(EditText view1) {
		// 邮箱
		String emailExp = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
		Pattern p = Pattern.compile(emailExp);
		Matcher m = p.matcher(view1.getText().toString().trim());
		if (m.matches() == false) {
			view1.setError("邮箱有误");
			return false;
		}
		return true;
	}

	public boolean urlValite(String url) {
		String regex = "^((https|http|ftp|rtsp|mms)?://)"
				+ "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" // ftp的user@
				+ "(([0-9]{1,3}\\.){3}[0-9]{1,3}" // IP形式的URL- 199.194.52.184
				+ "|" // 允许IP和DOMAIN（域名）
				+ "([0-9a-z_!~*'()-]+\\.)*" // 域名- www.
				+ "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\." // 二级域名
				+ "[a-z]{2,6})" // first level domain- .com or .museum
				+ "(:[0-9]{1,4})?" // 端口- :80
				+ "((/?)|" // a slash isn't required if there is no file name
				+ "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";

		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher(url);
		if (m.matches() == false) {
			return false;
		}
		return true;
	}
}
