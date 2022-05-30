package com.starprox.univ_ghardaia_project_app;

public class Student extends User {
	// * User: private String mID, mFullName, mEmailAddress, mPassword;
	// * Constructor: User (String _iD, String _fllName, String _emailAddress, String _password);

	// Attributes :
	private String mSpec, mCardID, mLevel, mGroup;
	// Constructors :
	public Student (String _FullName, String _EmailAddress, String _CardID, String _Level, String _Spec, String _Group) {
		super (_FullName, _EmailAddress);
		this.mCardID = _CardID;
		this.mLevel = _Level;
		this.mSpec = _Spec;
		this.mGroup = _Group;
	}

	public Student () {
	}

	// Getters & Setters :
	public String getSpec () {
		return mSpec;
	}

	public void setSpec (String _Spec) {
		this.mSpec = _Spec;
	}

	public String getCardID () {
		return mCardID;
	}

	public void setCardID (String _CardID) {
		this.mCardID = _CardID;
	}

	public String getLevel () {
		return mLevel;
	}

	public void setLevel (String _Level) {
		this.mLevel = _Level;
	}

	public String getGroup () {
		return mGroup;
	}

	public void setGroup (String _Group) {
		this.mGroup = _Group;
	}

	// Methods :
	public void SendMessageTeacher () {

	}

	public void SendMessageAdmin () {

	}
}
