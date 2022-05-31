package com.starprox.univ_ghardaia_project_app;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
	private final FirebaseDatabase database = FirebaseDatabase.getInstance ();
	private final FirebaseAuth auth = FirebaseAuth.getInstance ();
	private DatabaseReference reference_student, reference_teacher, reference_admin;
	private TextInputLayout login_cardNumber_TextInputLayout, login_password_TextInputLayout;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate (savedInstanceState);
		setContentView (R.layout.activity_main);

		reference_student = database.getReference (getString (R.string.reference_student));
		reference_teacher = database.getReference (getString (R.string.reference_teacher));
		reference_admin = database.getReference (getString (R.string.reference_admin));

		MaterialButton login_MaterialButton = findViewById (R.id.login_MaterialButton);
		login_cardNumber_TextInputLayout = findViewById (R.id.login_CardNumber_TextInputLayout);
		login_password_TextInputLayout = findViewById (R.id.login_Password_TextInputLayout);

		login_MaterialButton.setOnClickListener (view -> {
			if (verifyLoginFrontend (login_cardNumber_TextInputLayout, login_password_TextInputLayout)) {
				boolean[] x = verifyLoginBackend (login_cardNumber_TextInputLayout.getEditText ().toString (), login_password_TextInputLayout.getEditText ().toString ());
				if (x[0] && x[1])
					Toast.makeText (MainActivity.this, "USERR: setOnClickListener: SUCCESS", Toast.LENGTH_SHORT).show ();
				else if (! x[0])
					Toast.makeText (MainActivity.this, "USERR: setOnClickListener: ID Incorrect", Toast.LENGTH_SHORT).show ();
				else if (! x[1])
					Toast.makeText (MainActivity.this, "USERR: setOnClickListener: Password Incorrect", Toast.LENGTH_SHORT).show ();

			} else
				Toast.makeText (MainActivity.this, "verifyLoginFrontend : Failed", Toast.LENGTH_SHORT).show ();
		});
	}

	private boolean verifyLoginFrontend (TextInputLayout _id, TextInputLayout _password) {
		if (_id.getEditText ().getText ().toString ().length () < 12) {
			_id.setError (getString (R.string.login_id_card_error));
			_id.setErrorEnabled (true);
			return false;
		} else
			_id.setErrorEnabled (false);

		if (_password.getEditText ().getText ().toString ().length () < 8) {
			_password.setError (getString (R.string.login_password_error));
			_password.setErrorEnabled (true);
			return false;
		} else
			_password.setErrorEnabled (false);

		return true;
	}

	// !return  0: Login Success.
	// !return -1: Card ID doesn't exist in database.
	// !return -2: password incorrect.
	private boolean[] verifyLoginBackend (String _id, String _password) {
		boolean[] id_password = new boolean[2];
		Query query = reference_student.orderByChild ("cardID").equalTo (_id);

		query.addValueEventListener (new ValueEventListener () {
			@Override
			public void onDataChange (@NonNull DataSnapshot snapshot) {
				for (DataSnapshot shot : snapshot.getChildren ()) {
					Student student = snapshot.getValue (Student.class);
					if (student.getCardID ().equals (_id)) {
						id_password[0] = true;
						return;
					} else id_password[0] = false;
				}
			}

			@Override
			public void onCancelled (@NonNull DatabaseError error) {

			}
		});


		return id_password;
	}
}