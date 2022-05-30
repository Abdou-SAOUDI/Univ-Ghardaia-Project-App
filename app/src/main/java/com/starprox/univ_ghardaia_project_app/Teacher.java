package com.starprox.univ_ghardaia_project_app;

public class Teacher extends User {
	// * User: private String mID, mFullName, mEmailAddress, mPassword;
	// * Constructor: User (String _iD, String _fllName, String _emailAddress, String _password);

	// Attributes :
	private String mGrade;

	// Constructors :
	public Teacher (String _FullName, String _EmailAddress, String _Grade) {
		super (_FullName, _EmailAddress);
		this.mGrade = _Grade;
	}

	public Teacher () {
	}

	// Getters & Setters :
	public String getGrade () {
		return mGrade;
	}

	public void setGrade (String _Grade) {
		this.mGrade = _Grade;
	}

	// Methods :
	public void AnswerStudent () {

	}
}
