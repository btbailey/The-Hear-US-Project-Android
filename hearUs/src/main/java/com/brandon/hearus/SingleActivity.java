package com.brandon.hearus;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

public abstract class SingleActivity extends Activity {
	protected abstract LocationFragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		FragmentManager fm = getFragmentManager();
		Fragment fragment = fm.findFragmentById(R.id.container);

		if (fragment == null) {
			fragment = createFragment();
			fm.beginTransaction()
					.add(R.id.container, fragment)
					.commit();
		}
    }
}
