package com.brandon.hearus;

import android.app.Fragment;
import android.util.Log;

import java.util.UUID;

public class BillActivity extends SingleActivity {
	protected final String LOGGING_TAG = BillActivity.class.getSimpleName();

	@Override
	protected Fragment createFragment() {
		Log.d(LOGGING_TAG, "BillActivity#createFragment has been reached");

		UUID billId = (UUID) getIntent().getSerializableExtra(BillFragment.EXTRA_BILL_ID);

		return BillFragment.newInstace(billId);
	}
}
