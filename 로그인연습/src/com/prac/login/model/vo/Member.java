package com.prac.login.model.vo;

public class Member {
	
	private int mNO;
	private String mId;
	private String mPwd;
	private String mGender;
	
	
	
	public Member() {
		super();
	}

	public Member(int mNO, String mId, String mPwd, String mGender) {
		super();
		this.mNO = mNO;
		this.mId = mId;
		this.mPwd = mPwd;
		this.mGender = mGender;
	}

	public int getmNO() {
		return mNO;
	}

	public void setmNO(int mNO) {
		this.mNO = mNO;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getmPwd() {
		return mPwd;
	}

	public void setmPwd(String mPwd) {
		this.mPwd = mPwd;
	}

	public String getmGender() {
		return mGender;
	}

	public void setmGender(String mGender) {
		this.mGender = mGender;
	}

	@Override
	public String toString() {
		return "Member [mNO=" + mNO + ", mId=" + mId + ", mPwd=" + mPwd + ", mGender=" + mGender + "]";
	}
	
	

}
