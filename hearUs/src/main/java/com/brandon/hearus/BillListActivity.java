package com.brandon.hearus;

import android.app.Fragment;

public class BillListActivity extends SingleActivity {
	private static final String LOGGING_TAG = BillListActivity.class.getSimpleName();
	public static final String ISSUE_SEARCH_TOPIC = "com.brandon.hearus.issue_search_topic";
			
	protected Fragment createFragment() {
		return new BillListFragment();
	}

}
