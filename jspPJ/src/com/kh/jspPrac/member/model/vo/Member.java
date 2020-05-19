package com.kh.jspPrac.member.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Member implements Serializable {

	private static final long serialVersionUID = 2490722007359434034L;

	private String mId;
	private String mPassword;
	private Date mRentableDate;
	private int mGrade;
	private String mTell;

	public Member() {

	}

	public Member(String mId, String mPassword, Date mRentableDate, int mGrade, String mTell) {
		super();
		this.mId = mId;
		this.mPassword = mPassword;
		this.mRentableDate = mRentableDate;
		this.mGrade = mGrade;
		this.mTell = mTell;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getmPassword() {
		return mPassword;
	}

	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}

	public Date getmRentableDate() {
		return mRentableDate;
	}

	public void setmRentableDate(Date mRentableDate) {
		this.mRentableDate = mRentableDate;
	}

	public int getmGrade() {
		return mGrade;
	}

	public void setmGrade(int mGrade) {
		this.mGrade = mGrade;
	}

	public String getmTell() {
		return mTell;
	}

	public void setmTell(String mTell) {
		this.mTell = mTell;
	}

	@Override
	public String toString() {
		return "Member [mId=" + mId + ", mPassword=" + mPassword + ", mRentableDate=" + mRentableDate + ", mGrade="
				+ mGrade + ", mTell=" + mTell + "]";
	}

	
}
