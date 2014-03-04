package com.brandon.hearus;

import android.app.Fragment;

public class LocationActivity extends SingleActivity {

	private String LOGGING_TAG = LocationActivity.class.getSimpleName();

	@Override
	protected Fragment createFragment() {
		return new LocationFragment();
	}
}
