package com.brandon.hearus;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.UUID;

/**
 * Created by brandon.bailey on 2/19/14.
 */
public class Bill {
	private final String LOGGING_TAG = Bill.class.getSimpleName();
	private UUID mId;
	private String mBillName;
	private String mBillDate;
	private String mBillDescription;

//	public Bill(String billName) {
//		mBillName = billName;
//		mBillDate = new Date();
//		mId = UUID.randomUUID();
//		mBillDescription  = "This is Bill #" + getId() + " like it";
//	}

	public UUID getId() {
		return mId;
	}

	public String getBillDate() {
		return mBillDate;
	}

	public String getBillName() {
		return mBillName;
	}
//
//	public CharSequence formatDate() {
//		CharSequence s = DateFormat.format("EEEE, MMM, dd, yyyy", getBillDate());
//		return s;
//	}

	public String getBillDescription() {
		return mBillDescription;
	}

	public static Bill fromJson(JSONObject jsonBill) throws JSONException {
		Bill b = new Bill();

		b.mBillName = jsonBill.optString("short_title");
		b.mBillDate = jsonBill.getJSONObject("last_action").optString("acted_at");
		b.mBillDescription = jsonBill.optString("summary_short");

		return b;
	}

}
