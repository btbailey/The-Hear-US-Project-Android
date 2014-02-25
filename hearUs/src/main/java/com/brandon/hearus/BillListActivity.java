package com.brandon.hearus;

import android.util.Log;

public class BillListActivity extends SingleActivity {
	private static final String LOGGING_TAG = BillListActivity.class.getSimpleName();
	public static final String ISSUE_SEARCH_TOPIC = "com.brandon.hearus.issue_search_topic";

	@Override
	protected LocationFragment createFragment() {
			Log.d(LOGGING_TAG, "BillListActivity createFragment reached");
		return new BillListFragment();
	}

}
