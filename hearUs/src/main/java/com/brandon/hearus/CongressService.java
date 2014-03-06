package com.brandon.hearus;

import android.util.Log;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brandon.bailey on 2/26/14.
 */
public class CongressService {
	private final String LOGGING_TAG = CongressService.class.getSimpleName();
	final List<Bill> mBillsList = new ArrayList<Bill>();

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

	public JSONArray getLegislatorsInZip(String zipCode) {
		final JSONArray[] legislators = {null};
		String leg_uri =   "legislators/locate?zip=";
		leg_uri = leg_uri + zipCode;
		Log.d(LOGGING_TAG, leg_uri);
		SunlightRestClient.get(leg_uri, new JsonHttpResponseHandler(){
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

	public JSONArray getLegislatorById() {
		final JSONArray[] legislator = {null};
		SunlightRestClient.get("legislators?bioguide_id=M000309", new JsonHttpResponseHandler(){
			@Override
			public void onStart(){

				Log.d(LOGGING_TAG, "AsyncTask started for #getLegislatorById");
			}

			@Override
			public void onSuccess(JSONObject response){
				try {
//					legislators[0] = (JSONArray) response.get("results");
					JSONArray legs;
					legs = (JSONArray) response.get("results");
					Log.d(LOGGING_TAG, "successfully got legislator \n " + legs);
				} catch (JSONException e) {
					Log.d(LOGGING_TAG, "catch block");
					e.printStackTrace();
				}

				Log.d(LOGGING_TAG, "");
			}
		});
		return legislator[0];
	}

	public void getBills(final ServiceHandler handler) {

		final JSONArray[] bills = {new JSONArray()};
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
//					bills = new JSONArray(response.get("results"));
					bills[0] = (JSONArray) response.get("results");
					Log.d(LOGGING_TAG, "successfully got bills \n " + bills[0]);
				} catch (JSONException e) {
					Log.d(LOGGING_TAG, "catch block");
					e.printStackTrace();
				}

				for (int x = 0; x < bills[0].length(); x++) {
					try {
						mBillsList.add(Bill.fromJson(bills[0].getJSONObject(x)));
						Log.d(LOGGING_TAG, "bill item "+ x +"\n" + mBillsList.get(x).getBillName());
//						publishProgress(Integer.toString(x));
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
				handler.onSuccess(mBillsList);
			}

		});
	}

//	public List<Bill> getBillsList() {
//		getBills();
//		return mBillsList;
//	}
}
