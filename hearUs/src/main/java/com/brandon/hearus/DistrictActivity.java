package com.brandon.hearus;

import android.app.Fragment;

public class DistrictActivity extends SingleActivity {

	@Override
	protected Fragment createFragment() {

		String zipCode = (String) getIntent().getSerializableExtra(LocationFragment.EXTRA_ZIP_CODE);

		return LocationFragment.newInstance(zipCode);
	}

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_district);
//
//		FragmentManager fm = getFragmentManager();
//		Fragment fragment = fm.findFragmentById(R.id.container);
//
//		if (fragment == null) {
//			fragment = new LocationFragment();
//			fm.beginTransaction()
//					.add(R.id.container, fragment)
//					.commit();
//		}
//    }

}
