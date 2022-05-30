package com.starprox.univ_ghardaia_project_app;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class User {
	protected FirebaseDatabase database;
	// Attributes :
	private String mID, mFullName, mEmailAddress;

	// Constructors :
	public User (String _FullName, String _EmailAddress) {
		this.mFullName = _FullName;
		this.mEmailAddress = _EmailAddress;
		database = FirebaseDatabase.getInstance ();
	}

	// Getters & Setters :
	public String getID () {
		return mID;
	}

	public String getFullName () {
		return mFullName;
	}

	public void setFullName (String _FullName) {
		this.mFullName = _FullName;
	}

	public String getEmailAddress () {
		return mEmailAddress;
	}

	public void setEmailAddress (String _EmailAddress) {
		this.mEmailAddress = _EmailAddress;
	}

	public User () {
	}

	// Methods :
	public boolean Login (String _Name, String _Password) {
		return false;
	}

	public void Logout (String _ID) {
		FirebaseAuth.getInstance().signOut();
	}

	public void ChangePassword () {

	}
}
