package com.brandon.hearus;

import android.os.Bundle;
import android.util.Log;

public class LocationActivity extends SingleActivity {

	private String LOGGING_TAG = LocationActivity.class.getSimpleName();

	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
    }

	protected LocationFragment createFragment() {
		Log.d(LOGGING_TAG, "BillListActivity createFragment reached");
		return new LocationFragment();
	}

}