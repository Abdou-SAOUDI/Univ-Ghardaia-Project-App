package com.starprox.univ_ghardaia_project_app;

import com.google.firebase.database.FirebaseDatabase;

public class Problem {
	// Attributes :
	private String mID, mStudentID, mTitle, mText, mSendDate;
	private FirebaseDatabase database;

	// Constructors :

	public Problem (String _ID, String _StudentID, String _Title, String _Text, String _SendDate) {
		this.mID = _ID;
		this.mStudentID = _StudentID;
		this.mTitle = _Title;
		this.mText = _Text;
		this.mSendDate = _SendDate;
		database = FirebaseDatabase.getInstance ();
	}

	//Getters & Setters :
	public String getID () {
		return mID;
	}

	public void setID (String _ID) {
		this.mID = _ID;
	}

	public String getStudentID () {
		return mStudentID;
	}

	public void setStudentID (String _StudentID) {
		this.mStudentID = _StudentID;
	}

	public String getTitle () {
		return mTitle;
	}

	public void setTitle (String _Title) {
		this.mTitle = _Title;
	}

	public String getText () {
		return mText;
	}

	public void setText (String _Text) {
		this.mText = _Text;
	}

	public String getSendDate () {
		return mSendDate;
	}

	public void setSendDate (String _SendDate) {
		this.mSendDate = _SendDate;
	}
}
