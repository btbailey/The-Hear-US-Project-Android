package com.brandon.hearus;


import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class BillListFragment extends ListFragment {
	private ArrayList<Bill> mBills;
	private static final String LOGGING_TAG = BillListFragment.class.getSimpleName();

    public BillListFragment() {
        // Required empty public constructor
    }

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActivity().setTitle();
		mBills = BillHelper.getInstance(getActivity()).getBills();
		BillAdapter adapter = new BillAdapter(mBills);
		setListAdapter(adapter);
	}

	@Override
	public void onListItemClick(ListView l, View v, int postition, long id) {
		Bill b = ((BillAdapter) getListAdapter()).getItem(postition);
		Log.d(LOGGING_TAG, b.getBillName() + "was clicked");
	}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bill_list, container, false);
    }

	private class BillAdapter extends ArrayAdapter<Bill> {

		public BillAdapter(ArrayList<Bill> bills) {
			super(getActivity(), 0, bills);
		}


		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// if a view wasnt given we inflate one
			if (convertView == null) {
				convertView = getActivity().getLayoutInflater()
						.inflate(R.layout.list_item_bill, null);
			}

			// configure the view for this bill
			Bill b = getItem(position);

			TextView titleTextView = (TextView) convertView.findViewById(R.id.bill_list_item_titleTextView);
			titleTextView.setText(b.getBillName());

			TextView dateTextView = (TextView) convertView.findViewById(R.id.bill_list_itemDateTextView);
			dateTextView.setText(b.formatDate());

			return convertView;
		}

	}

}
