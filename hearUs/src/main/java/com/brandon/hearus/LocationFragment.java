package com.brandon.hearus;

import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 *
 */
public class LocationFragment extends Fragment implements ServiceHandler{

	private static String LOGGING_TAG = LocationFragment.class.getSimpleName();
	public static final String EXTRA_ZIP_CODE = "com.brandon.android.hearus.zip_code";

	private JSONArray districts;
	private Resources mResources;
	int mResourceId;
	private JSONArray legislators;
	private List<Bill> bills = new ArrayList<Bill>();

    public LocationFragment() {
        // Required empty public constructor
    }

	public static LocationFragment newInstance(String zipCode) {
		Bundle args = new Bundle();
		args.putSerializable(EXTRA_ZIP_CODE, zipCode);

		LocationFragment fragment = new LocationFragment();
		fragment.setArguments(args);

		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	  	CongressService congressService	= CongressService.getInstance();

		String zipCode = (String) getActivity().getIntent().getSerializableExtra(EXTRA_ZIP_CODE);
		Log.d(LOGGING_TAG, "the entered zip code is: "+ zipCode);

		districts = congressService.getDistrictsInZip();
		congressService.getBills(this);
		legislators = congressService.getLegislatorsInZip(zipCode);
//		 mResourceId = R.raw.zipcode_response;

//		InputStream inStream = mResources.openRawResource(mResourceId);
//		byte[] bytes = new byte[0];
//		try {
//
//			bytes = new byte[inStream.available()];
//			int offset = 0;
//			while (offset < bytes.length) {
//				int numRead = inStream.read(bytes, offset, bytes.length - offset);
//				if (numRead >= 0)
//					offset += numRead;
//				else
//					break;
//			}
//			inStream.close();
//			String template = new String(bytes);
//			Log.d(LOGGING_TAG, "LocationFragment congressmen response: \n" + template);
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}


	}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_location, container, false);
    }

	@Override
	public void onSuccess(Object data) {
		bills = (List<Bill>)data;
	}

//	private District findDistrictsInZipCode(String zipCode) {
//		District[] districts = District.getDistrictsForZipCode();
//	}

}
