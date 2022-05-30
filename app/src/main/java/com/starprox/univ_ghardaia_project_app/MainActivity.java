package com.starprox.univ_ghardaia_project_app;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
	private final FirebaseDatabase database = FirebaseDatabase.getInstance ();
	private final FirebaseAuth auth = FirebaseAuth.getInstance ();
	private DatabaseReference reference_student, reference_teacher, reference_admin;
	private Button login_MaterialButton;
	private TextInputLayout login_cardNumber_TextInputLayout, login_password_TextInputLayout;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate (savedInstanceState);
		setContentView (R.layout.activity_main);

		reference_student = database.getReference (getString (R.string.reference_student));

		login_MaterialButton = findViewById (R.id.login_MaterialButton);
		login_cardNumber_TextInputLayout = findViewById (R.id.login_CardNumber_TextInputLayout);
		login_password_TextInputLayout = findViewById (R.id.login_Password_TextInputLayout);

		login_cardNumber_TextInputLayout.setError (getString (R.string.login_id_card_error));
		login_password_TextInputLayout.setError (getString (R.string.login_password_error));

		login_MaterialButton.setOnClickListener (view -> {
			if (verifyLoginFrontend (login_cardNumber_TextInputLayout, login_password_TextInputLayout)) {

			}
		});
	}

	private boolean verifyLoginFrontend (TextInputLayout _id, TextInputLayout _password) {
		if (_id.getEditText ().getText ().toString ().length () < 12) {
			_id.setErrorEnabled (true);
			return false;
		} else
			_id.setErrorEnabled (false);

		if (_password.getEditText ().getText ().toString ().length () < 8) {
			_password.setErrorEnabled (true);
			return false;
		} else
			_password.setErrorEnabled (false);

		return true;
	}

	// !return  0: Login Success.
	// !return -1: Card ID doesn't exist in database.
	// !return -2: password incorrect.
	private int verifyLoginBackend (String _id, String _password) {
		ArrayList<Student> students = new ArrayList<> ();
		boolean id_correct = false;
		final boolean[] password_correct = { false };

		reference_student.addValueEventListener (new ValueEventListener () {
			@Override
			public void onDataChange (@NonNull DataSnapshot snapshot) {
				for (DataSnapshot shot : snapshot.getChildren ())
					students.add (shot.getValue (Student.class));
			}

			@Override
			public void onCancelled (@NonNull DatabaseError error) {

			}
		});

		for (Student item : students) {
			if (item.getCardID ().equals (_id)) {
				id_correct = item.getCardID ().equals (_id);
				auth.signInWithEmailAndPassword (item.getEmailAddress (), _password).addOnCompleteListener (new OnCompleteListener<AuthResult> () {
					@Override
					public void onComplete (@NonNull Task<AuthResult> task) {
						if (task.isSuccessful ()) password_correct[0] = true;
						else Log.w ("OnCompleteListener:ERROR", task.getException ().toString ());
					}
				});
			}
		}


		return (password_correct[0])? 0: -2;
	}
}