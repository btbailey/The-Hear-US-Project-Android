package com.brandon.hearus;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

public class SunlightRestClient {
	private static final String LOGGING_TAG = SunlightRestClient.class.getSimpleName();
	//private static final String BASE_URL = "https://congress.api.sunlightfoundation.com/%API_CALL%?apikey=%API_KEY%";
	private static final String BASE_URL = "https://congress.api.sunlightfoundation.com/%API_CALL%&apikey=%API_KEY%";

	private static AsyncHttpClient client = new AsyncHttpClient();

	public static void get(String url, AsyncHttpResponseHandler responseHandler) {
		client.get(getAbsoluteUrl(url), responseHandler);
	}

	public static String getAbsoluteUrl(String relativeUrl) {
		String url = BASE_URL.replace("%API_CALL%", relativeUrl);
		url = url.replace("%API_KEY%", "d9836e25aa044e26bf6008212dab2514");
		Log.d(LOGGING_TAG, "attempting to access url: \n" + url);
		return url;
	}
}