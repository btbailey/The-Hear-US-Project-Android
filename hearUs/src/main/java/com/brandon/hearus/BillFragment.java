package com.brandon.hearus;


import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class BillFragment extends Fragment {

	private static String LOGGING_TAG = BillFragment.class.getSimpleName();

	private Button mButtonSupport;
	private Button mButtonOppose;
	private TextView mBillSponsor;

    public BillFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
		View v = inflater.inflate(R.layout.fragment_bill, container, false);

		mButtonSupport = (Button) v.findViewById(R.id.vote_yay);
		mButtonSupport.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d(LOGGING_TAG, "Bills Support button has been clicked");
			}
		});

		mButtonOppose = (Button) v.findViewById(R.id.vote_nay);
		mButtonOppose.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d(LOGGING_TAG, "Bills Oppose button has been clicked");
			}
		});

		mBillSponsor = (TextView) v.findViewById(R.id.bill_sponsor);
		mBillSponsor.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d(LOGGING_TAG, "Bill Sponsors name has been clicked");
			}
		});

		return v;
	}



}
