package com.brandon.hearus;

import android.util.Log;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by brandon.bailey on 2/26/14.
 */
public class CongressService {
	private final String LOGGING_TAG = CongressService.class.getSimpleName();

	private static CongressService instance = null;

	public static CongressService getInstance() {
		if (instance == null) {
			instance = new CongressService();
		}
		return instance;
	}

	public JSONArray getDistrictsInZip() {
		final JSONArray[] districts = new JSONArray[1];
		SunlightRestClient.get("districts/locate?zip=20744", new JsonHttpResponseHandler(){
			@Override
			public void onStart(){
				Log.d(LOGGING_TAG, "AsyncTask started for #getDistrictsInZip");
			}

			@Override
			public void onSuccess(JSONObject response){
				try {
//					districts[0] = (JSONArray) response.get("results");
					JSONArray dis;
					dis = (JSONArray) response.get("results");
					districts[0] = dis;
					Log.d(LOGGING_TAG, "successfully got districts \n" + dis);
				} catch (JSONException e) {
					Log.d(LOGGING_TAG, "catch block");
					e.printStackTrace();
				}

				Log.d(LOGGING_TAG, "");
			}
		});
		return districts[0];
	}

	public JSONArray getLegislatorsInZip() {
		final JSONArray[] legislators = {null};
		SunlightRestClient.get("legislators/locate?zip=20744", new JsonHttpResponseHandler(){
			@Override
			public void onStart(){

				Log.d(LOGGING_TAG, "AsyncTask started for #getLegislatorsInZip");
			}

			@Override
			public void onSuccess(JSONObject response){
				try {
//					legislators[0] = (JSONArray) response.get("results");
					JSONArray legs;
					legs = (JSONArray) response.get("results");
							Log.d(LOGGING_TAG, "successfully got legislators \n " + legs);
				} catch (JSONException e) {
					Log.d(LOGGING_TAG, "catch block");
					e.printStackTrace();
				}

				Log.d(LOGGING_TAG, "");
			}
		});
		return legislators[0];
	}

	public JSONArray getBills() {
		final JSONArray[] allBills = {null};
		SunlightRestClient.get(
				"bills/search?query=gun%20control&fields=bill_id,bill_type,chamber,popular_title,short_title,official_title,urls,history,last_action,sponsor_id,related_bill_ids,nicknames,keywords,summary,summary_short",
				new JsonHttpResponseHandler(){
			@Override
			public void onStart(){

				Log.d(LOGGING_TAG, "AsyncTask started for #getBills");
			}

			@Override
			public void onSuccess(JSONObject response){
				try {
//					legislators[0] = (JSONArray) response.get("results");
					JSONArray bills;
					bills = (JSONArray) response.get("results");
					Log.d(LOGGING_TAG, "successfully got bills \n " + bills);
				} catch (JSONException e) {
					Log.d(LOGGING_TAG, "catch block");
					e.printStackTrace();
				}

				Log.d(LOGGING_TAG, "");
			}
		});
		return allBills[0];
	}
}
