package com.starprox.univ_ghardaia_project_app;

public class Departement extends User {
	// * User: private String mID, mFullName, mEmailAddress, mPassword;
	// * Constructor: User (String _iD, String _fllName, String _emailAddress, String _password);

	// Attributes :
	private String mPost;

	// Constructors :
	public Departement (String _FullName, String _EmailAddress, String _Post) {
		super (_FullName, _EmailAddress);
		this.mPost = _Post;
	}

	public Departement () {
	}

	// Getters & Setters :
	public String getPost () {
		return mPost;
	}

	public void setPost (String _Post) {
		this.mPost = _Post;
	}

	// Methods :
	private void AnswerStudent () {
	}

	private void AddStudent () {
	}

	private void ModifyStudent () {
	}

	private void DeleteStudent () {
	}

	private void AddTeacher () {
	}

	private void ModifyTeacher () {
	}

	private void DeleteTeacher () {
	}
}
