package com.brandon.hearus;

/**
 * Created by brandon.bailey on 2/24/14.
 */
public class CongressMember {

	private static String  LOGGING_TAG = CongressMember.class.getSimpleName();

	static String mFirstName;
	static String mLastName;
	static String mGender;
	static String mParty;
	static String mPhone;
	static String mState;
	static String mOfficeAddress;
	static String mStateRank;
	static String mTermStart;
	static String mTermEnd;
	static String mTitle;
	static String mChamber;
	static String mWebSite;
	static String mContactForm;
	static String mDistrict;

	private CongressMember() {

	}

	private void setFirstName(String firstName) {
		mFirstName = firstName;
	}

	private void setLastName(String lastName) {
		mLastName = lastName;
	}

	private void setGender(String gender) {
		mGender = gender;
	}

	private void setTitle(String title) {
		mTitle = title;
	}

	private void setPhone(String phone) {
		mPhone = phone;
	}

	private void setState(String state) {
		mState = state;
	}

	private void setOfficeAddress(String address) {
		mOfficeAddress = address;
	}

	private void setStateRank(String rank) {
		mStateRank = rank;
	}

	private void setTermStart(String termStart) {
		mTermStart = termStart;
	}

	private void setTermEnd(String termEnd) {
		mTermEnd = termEnd;
	}

	private void setChamber(String chamber) {
		mChamber = chamber;
	}

	private void setWebSite(String webSite) {
		mWebSite = webSite;
	}

	private void setContactForm(String contactForm) {
		mContactForm = contactForm;
	}

	private void setDistrict() {

	}

}
