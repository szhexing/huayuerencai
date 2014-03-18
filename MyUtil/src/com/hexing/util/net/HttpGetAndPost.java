package com.hexing.util.net;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class HttpGetAndPost {

	/**
	 * post方式
	 * 
	 * @param url
	 *            访问的url地址
	 * @param params
	 *            参数
	 * @param time_out
	 *            超时时间
	 * @return 如果失败，则返回为空
	 */
	public static String byPost(String url, List<NameValuePair> params,
			int time_out) {
		/* 建立HTTP Post连线 */
		HttpPost httpRequest = new HttpPost(url);

		String strResult = "";

		// 发出HTTP request
		try {
			httpRequest.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
			HttpClient client = new DefaultHttpClient();
			// 请求超时
			client.getParams().setParameter(
					CoreConnectionPNames.CONNECTION_TIMEOUT, time_out);
			// 读取超时
			client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,
					time_out);
			// 取得HTTP response
			HttpResponse httpResponse = client.execute(httpRequest);

			if (httpResponse.getStatusLine().getStatusCode() == 200) {
				// 取出回应字串
				strResult = EntityUtils.toString(httpResponse.getEntity());
			} else {
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return strResult;
	}

}
