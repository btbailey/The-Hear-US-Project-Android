package com.brandon.hearus;


import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.UUID;

public class BillFragment extends Fragment {
	private static String LOGGING_TAG = BillFragment.class.getSimpleName();
	public static final String EXTRA_BILL_ID = "com.brandon.android.hearus.bill_id";

	private Bill mBill;

	private Button mButtonSupport;
	private Button mButtonOppose;
	private TextView mBillSponsor;

    public BillFragment() {
        // Required empty public constructor
    }

	public static BillFragment newInstace(UUID billID) {
		Bundle args = new Bundle();
		args.putSerializable(EXTRA_BILL_ID, billID);

		BillFragment fragment = new BillFragment();
		fragment.setArguments(args);

		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		UUID crimeId = (UUID) getActivity().getIntent().getSerializableExtra(EXTRA_BILL_ID);

		mBill = BillHelper.getInstance(getActivity()).getBill(crimeId);

		if (mBill == null) {
			Log.d(LOGGING_TAG, "Bill not found in BillHelper#getBill");
		} else {
			Log.d(LOGGING_TAG, "Bill has been foung in BillHelper#getBill");
		}

		Log.d(LOGGING_TAG, "Bill id is " + crimeId);

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
