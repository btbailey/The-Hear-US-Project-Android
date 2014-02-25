package com.brandon.hearus;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by brandon.bailey on 2/19/14.
 */
public class BillHelper {
	private static String LOGGING_TAG = BillHelper.class.getSimpleName();
	private ArrayList<Bill> mBills;

	private static BillHelper sBillHelper;
	private Context mAppContext;

	private BillHelper(Context appContext) {
		mAppContext= appContext;
	}

	public static BillHelper getInstance(Context c) {
		if (sBillHelper == null) {
			sBillHelper = new BillHelper(c.getApplicationContext());
		}
		Log.d(LOGGING_TAG, "Inside #getInstance");
		return sBillHelper;
	}

	public ArrayList<Bill> getBills() {
		mBills = new ArrayList<Bill>();
		for (int i = 0; i < 30; i++) {
			Bill b = new Bill(String.format("Bill #%d", i));
			mBills.add(b);
		}
		Log.d(LOGGING_TAG, "Inside #getBills");
		return mBills;
	}

	public Bill getBill(UUID id) {
		for (Bill b : mBills) {
			if (b.getId().equals(id))
				return b;
		}
		return null;
	}

	public void searchForBills(String issue) {
		//will be used to implement the SunlightLabs API
//		Log.d(LOGGING_TAG, "Inside #searchForBills");
	}
}
