package com.starprox.univ_ghardaia_project_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
	private final FirebaseDatabase database = FirebaseDatabase.getInstance ();
	private final FirebaseAuth auth = FirebaseAuth.getInstance ();
	private DatabaseReference reference_student, reference_teacher, reference_admin;
	private Button login_MaterialButton;
	private TextInputLayout login_CardNumber_TextInputLayout, login_Password_TextInputLayout;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate (savedInstanceState);
		setContentView (R.layout.activity_main);

		reference_student = database.getReference (getString (R.string.reference_student));

		login_MaterialButton = findViewById (R.id.login_MaterialButton);
		login_CardNumber_TextInputLayout = findViewById (R.id.login_CardNumber_TextInputLayout);
		login_Password_TextInputLayout = findViewById (R.id.login_Password_TextInputLayout);

		Objects.requireNonNull (login_CardNumber_TextInputLayout.getEditText ()).addTextChangedListener (new TextWatcher () {
			@Override
			public void beforeTextChanged (CharSequence charSequence, int i, int i1, int i2) {

			}

			@Override
			public void onTextChanged (CharSequence charSequence, int i, int i1, int i2) {
				if (login_CardNumber_TextInputLayout.getEditText ().getText ().toString ().length () < 12) {
					login_CardNumber_TextInputLayout.setErrorEnabled (true);
					login_CardNumber_TextInputLayout.setError (getString (R.string.id_card_error));
				} else
					login_CardNumber_TextInputLayout.setErrorEnabled (false);
			}

			@Override
			public void afterTextChanged (Editable editable) {

			}
		});

		Objects.requireNonNull (login_Password_TextInputLayout.getEditText ()).addTextChangedListener (new TextWatcher () {
			@Override
			public void beforeTextChanged (CharSequence charSequence, int i, int i1, int i2) {

			}

			@Override
			public void onTextChanged (CharSequence charSequence, int i, int i1, int i2) {
				if (login_Password_TextInputLayout.getEditText ().getText ().toString ().length () < 8) {
					login_Password_TextInputLayout.setErrorEnabled (true);
					login_Password_TextInputLayout.setError (getString (R.string.password_error));
				} else
					login_Password_TextInputLayout.setErrorEnabled (false);
			}

			@Override
			public void afterTextChanged (Editable editable) {

			}
		});

		login_Password_TextInputLayout.setOnFocusChangeListener ((view, b) -> {
			if (login_Password_TextInputLayout.getEditText ().getText ().toString ().length () < 8) {
				login_Password_TextInputLayout.setErrorEnabled (true);
				login_Password_TextInputLayout.setError (getString (R.string.password_error));
			} else
				login_Password_TextInputLayout.setErrorEnabled (false);
		});

		login_MaterialButton.setOnClickListener (view -> {
			String cardNumber_Text = login_CardNumber_TextInputLayout.getEditText ().getText ().toString ().trim (),
					password_Text = login_Password_TextInputLayout.getEditText ().getText ().toString ().trim ();

			if (!login_CardNumber_TextInputLayout.isErrorEnabled () && !login_Password_TextInputLayout.isErrorEnabled ()) {

			}
		});
	}
}