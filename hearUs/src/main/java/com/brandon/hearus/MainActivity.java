package com.brandon.hearus;

public class MainActivity extends SingleActivity {

	@Override
	protected LocationFragment createFragment() {
		return new IssueSearchFragment();
	}
}
