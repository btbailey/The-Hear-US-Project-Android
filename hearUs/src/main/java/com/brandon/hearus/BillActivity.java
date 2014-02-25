package com.brandon.hearus;

import android.app.Fragment;
import android.util.Log;

public class BillActivity extends SingleActivity {
	protected final String LOGGING_TAG = BillActivity.class.getSimpleName();

	@Override
	protected Fragment createFragment() {
		Log.d(LOGGING_TAG, "BillActivity#createFragment has been reached");
		return new BillFragment();
	}
}
