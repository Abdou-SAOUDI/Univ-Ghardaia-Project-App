package com.starprox.univ_ghardaia_project_app;

import com.google.firebase.database.FirebaseDatabase;

public class Response {
	// Attributes :
	private String mID, mProblemID, mTitle, mText, mAnswerDate;
	private FirebaseDatabase database;

	// Constructors :

	public Response (String _ID, String _ProblemID, String _Title, String _Text, String _AnswerDate) {
		this.mID = _ID;
		this.mProblemID = _ProblemID;
		this.mTitle = _Title;
		this.mText = _Text;
		this.mAnswerDate = _AnswerDate;
		database = FirebaseDatabase.getInstance ();
	}

	//Getters & Setters :
	public String getID () {
		return mID;
	}

	public void setID (String _ID) {
		this.mID = _ID;
	}

	public String getProblemID () {
		return mProblemID;
	}

	public void setProblemID (String _ProblemID) {
		this.mProblemID = _ProblemID;
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

	public String getAnswerDate () {
		return mAnswerDate;
	}

	public void setAnswerDate (String _AnswerDate) {
		this.mAnswerDate = _AnswerDate;
	}
}
