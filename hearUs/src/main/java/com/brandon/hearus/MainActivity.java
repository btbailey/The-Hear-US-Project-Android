package com.brandon.hearus;

import android.app.Fragment;

public class MainActivity extends SingleActivity {

	@Override
	protected Fragment createFragment() {
		return new IssueSearchFragment();
	}
}
