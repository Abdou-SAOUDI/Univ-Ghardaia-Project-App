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
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
	private final FirebaseDatabase database = FirebaseDatabase.getInstance ();
	private final FirebaseAuth auth = FirebaseAuth.getInstance ();
	private final ArrayList<Student> studentArrayList = new ArrayList<> ();
	private final ArrayList<Teacher> teacherArrayList = new ArrayList<> ();
	private final ArrayList<Departement> departementArrayList = new ArrayList<> ();
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
//				TODO: User user = new User ("", )
//				boolean[] x = verifyLoginBackend (login_cardNumber_TextInputLayout.getEditText ().toString (), login_password_TextInputLayout.getEditText ().toString ());
//				if (x[0] && x[1])
//					Toast.makeText (MainActivity.this, "USERR: setOnClickListener: SUCCESS", Toast.LENGTH_SHORT).show ();
//				else if (! x[0])
//					Toast.makeText (MainActivity.this, "USERR: setOnClickListener: ID Incorrect", Toast.LENGTH_SHORT).show ();
//				else if (! x[1])
//					Toast.makeText (MainActivity.this, "USERR: setOnClickListener: Password Incorrect", Toast.LENGTH_SHORT).show ();
			} else
				Toast.makeText (MainActivity.this, "verifyLoginFrontend : Failed", Toast.LENGTH_SHORT).show ();
		});
	}

	@Override
	protected void onStart () {
		super.onStart ();

		reference_student.addValueEventListener (new ValueEventListener () {
			@Override
			public void onDataChange (@NonNull DataSnapshot snapshot) {
				studentArrayList.clear ();
				for (DataSnapshot shot : snapshot.getChildren ())
					if (shot.exists ())
						studentArrayList.add (snapshot.getValue (Student.class));
			}

			@Override
			public void onCancelled (@NonNull DatabaseError error) {

			}
		});

		reference_teacher.addValueEventListener (new ValueEventListener () {
			@Override
			public void onDataChange (@NonNull DataSnapshot snapshot) {
				teacherArrayList.clear ();
				for (DataSnapshot shot : snapshot.getChildren ())
					if (shot.exists ())
						teacherArrayList.add (snapshot.getValue (Teacher.class));
			}

			@Override
			public void onCancelled (@NonNull DatabaseError error) {

			}
		});

		reference_admin.addValueEventListener (new ValueEventListener () {
			@Override
			public void onDataChange (@NonNull DataSnapshot snapshot) {
				departementArrayList.clear ();
				for (DataSnapshot shot : snapshot.getChildren ())
					if (shot.exists ())
						departementArrayList.add (snapshot.getValue (Departement.class));
			}

			@Override
			public void onCancelled (@NonNull DatabaseError error) {

			}
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

	private boolean verifyLoginBackend (User _user, String _id, String _password) {

return false;
		/*boolean[] id_password = {false, false};

		for (Student student : studentArrayList)
			if (student.getCardID ().equals (_id)) {
				id_password[0] = true;
				return id_password;

			}

		for (Teacher teacher : teacherArrayList)
			if (teacher.getID ().equals (_id)) {
				id_password[0] = true;
				return id_password;
			}

		for (Departement departement : departementArrayList)
			if (departement.getID ().equals (_id)) {
				id_password[0] = true;
				return id_password;
			}

		return id_password;*/
	}
}