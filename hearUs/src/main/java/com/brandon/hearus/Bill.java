package com.brandon.hearus;

import android.text.format.DateFormat;

import java.util.Date;
import java.util.UUID;

/**
 * Created by brandon.bailey on 2/19/14.
 */
public class Bill {
	private final String LOGGING_TAG = Bill.class.getSimpleName();
	private UUID mId;
	private String mBillName;
	private Date mBillDate;

	public Bill(String billName) {
		mBillName = billName;
		mBillDate = new Date();
		mId = UUID.randomUUID();
	}

	public UUID getId() {
		return mId;
	}

	public Date getBillDate() {
		return mBillDate;
	}

	public String getBillName() {
		return mBillName;
	}

	public CharSequence formatDate() {
		CharSequence s = DateFormat.format("EEEE, MMM, dd, yyyy", getBillDate());
		return s;
	}

}
