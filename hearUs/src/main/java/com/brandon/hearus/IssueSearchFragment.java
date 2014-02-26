package com.brandon.hearus;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class IssueSearchFragment extends Fragment {
	private final String LOGGING_TAG = IssueSearchFragment.class.getSimpleName();

	private String mIssueSearchText;
	private String mZipCodeSearchText;
	private String mZipCode;
	EditText mSearchIssueText;
	private Button mSearchIssueButton;
	EditText mDistrictSearchText;
	private Button mDistrictSearchButton;

    public IssueSearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_issue_search, container, false);

		mSearchIssueText = (EditText) v.findViewById(R.id.issue_search_text);
		mSearchIssueText.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
//				create a helper function that stores the search text and uses it to build
//				and send the search query
				mIssueSearchText = s.toString();
			}

			@Override
			public void afterTextChanged(Editable s) {

			}
		});

		mSearchIssueButton = (Button) v.findViewById(R.id.issue_search_button);
		mSearchIssueButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getActivity(), BillListActivity.class);
				i.putExtra("Search_text", mIssueSearchText);
				i.addFlags(Intent.FLAG_DEBUG_LOG_RESOLUTION);
				Log.d(LOGGING_TAG, "issue search button has been clicked, the issue to be searched for: " + mIssueSearchText);
				startActivity(i);
			}
		});

		mDistrictSearchText = (EditText) v.findViewById(R.id.district_search_text);
		mDistrictSearchText.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				Pattern zipCodePattern = Pattern.compile("^\\d{5}");
				mZipCodeSearchText = s.toString();
				Matcher zipFound = zipCodePattern.matcher(mZipCodeSearchText);

				if (zipFound.find()) {
					mZipCode = s.toString();
					Log.d(LOGGING_TAG, "Legal zip continue to find the district");
				} else {
					Log.d(LOGGING_TAG, "Not a legal zip code");
				}
			}

			@Override
			public void afterTextChanged(Editable s) {

			}
		});

		mDistrictSearchButton = (Button) v.findViewById(R.id.district_search_button);
		mDistrictSearchButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getActivity(), DistrictActivity.class);
				i.putExtra("Zip_code", mZipCode);
				i.addFlags(Intent.FLAG_DEBUG_LOG_RESOLUTION);
				Log.d(LOGGING_TAG, "District Search button has been clicked starting DistrictActivity");
				startActivity(i);
			}
		});

		return v;
	}


}
