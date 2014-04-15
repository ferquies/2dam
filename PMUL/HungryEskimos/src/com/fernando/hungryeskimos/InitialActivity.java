package com.fernando.hungryeskimos;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class InitialActivity extends Activity {
	private String sound;
	private SharedPreferences settings = null;
	private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_initial);
		
		settings = getSharedPreferences("com.fernando.hungryskimos_preferences", Context.MODE_PRIVATE);
		context = getApplicationContext();
		
		sound = settings.getString("sound", "true");
		
		findViewById(R.id.button_sound).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				sound = settings.getString("sound", "true");
				ImageButton snd = (ImageButton) findViewById(v.getId());
				
				if(sound == "true") {
					snd.setBackgroundResource(R.drawable.sound);
					sound = "false";
				} else {
					snd.setBackgroundResource(R.drawable.mute);
					sound = "true";
				}
			}
		});
		
		findViewById(R.id.button_settings).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent_settings = new Intent(context, SettingsActivity.class);
				startActivity(intent_settings);
			}
		});
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
	}

}
