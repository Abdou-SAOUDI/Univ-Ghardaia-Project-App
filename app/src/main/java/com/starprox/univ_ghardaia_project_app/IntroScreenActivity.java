package com.starprox.univ_ghardaia_project_app;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class IntroScreenActivity extends AppCompatActivity {
	Button splash_next_Btn, splash_skip_Btn;
	ArrayList<ImageView> circleImages_ArrayList;
	private int currentPage = 1;
	private FrameLayout frameLayout;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate (savedInstanceState);
		setContentView (R.layout.activity_intro_screen);

		splash_next_Btn = findViewById (R.id.splash_next_Btn);
		splash_skip_Btn = findViewById (R.id.splash_skip_Btn);
		frameLayout = findViewById (R.id.SplashFrameLayout);

		circleImages_ArrayList = new ArrayList<> ();
		circleImages_ArrayList.add (findViewById (R.id.splash_circle_1));
		circleImages_ArrayList.add (findViewById (R.id.splash_circle_2));
		circleImages_ArrayList.add (findViewById (R.id.splash_circle_3));
		circleImages_ArrayList.add (findViewById (R.id.splash_circle_4));

		getSupportFragmentManager ().beginTransaction ().replace (R.id.SplashFrameLayout, new SplashPage1Fragment ()).commit ();

		splash_next_Btn.setOnClickListener (view -> {
			Animation anim = AnimationUtils.loadAnimation (getApplicationContext (), R.anim.fadein);
			switch (++ currentPage) {
				case 2:
					getSupportFragmentManager ().beginTransaction ().replace (R.id.SplashFrameLayout, new SplashPage2Fragment ()).commit ();
					for (int i = 0; i < 4; i++)
						circleImages_ArrayList.get (i).setImageResource ((i == currentPage - 1) ? R.drawable.ic_filled_circle : R.drawable.ic_outline_circle);
					frameLayout.startAnimation (anim);
					break;
				case 3:
					getSupportFragmentManager ().beginTransaction ().replace (R.id.SplashFrameLayout, new SplashPage3Fragment ()).commit ();
					for (int i = 0; i < 4; i++)
						circleImages_ArrayList.get (i).setImageResource ((i == currentPage - 1) ? R.drawable.ic_filled_circle : R.drawable.ic_outline_circle);
					frameLayout.startAnimation (anim);
					break;
				case 4:
					getSupportFragmentManager ().beginTransaction ().replace (R.id.SplashFrameLayout, new SplashPage4Fragment ()).commit ();
					for (int i = 0; i < 4; i++)
						circleImages_ArrayList.get (i).setImageResource ((i == currentPage - 1) ? R.drawable.ic_filled_circle : R.drawable.ic_outline_circle);
					frameLayout.startAnimation (anim);
					splash_next_Btn.setText (R.string.continue_btn_text);
					splash_skip_Btn.setVisibility (View.GONE);
					break;
				default:
//					TODO: startActivity (new Intent (getApplicationContext (), HomeActivity.class));
					break;
			}
		});
//		TODO: splash_skip_Btn.setOnClickListener (view -> startActivity (new Intent (getApplicationContext (), HomeActivity.class)));
	}
}