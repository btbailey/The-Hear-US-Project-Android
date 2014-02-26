package com.brandon.hearus;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

public class DistrictActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_district);

		FragmentManager fm = getFragmentManager();
		Fragment fragment = fm.findFragmentById(R.id.container);

		if (fragment == null) {
			fragment = new LocationFragment();
			fm.beginTransaction()
					.add(R.id.container, fragment)
					.commit();
		}
    }

}
