package com.brandon.hearus;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;


/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 *
 */
public class LocationFragment extends Fragment {

	private static String LOGGING_TAG = LocationFragment.class.getSimpleName();
	private JSONArray districts;
	private JSONArray legislators;

    public LocationFragment() {
        // Required empty public constructor
    }

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	  	CongressService congressService	= CongressService.getInstance();
		districts = congressService.getDistrictsInZip();
		legislators = congressService.getLegislatorsInZip();

	}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_location, container, false);
    }

//	private District findDistrictsInZipCode(String zipCode) {
//		District[] districts = District.getDistrictsForZipCode();
//	}

}
