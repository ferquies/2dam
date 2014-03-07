package com.fernando.examen;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class UserActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user);
		Intent intent = getIntent();
		Bundle bun = intent.getExtras();
		String[] s = bun.getStringArray("data");
		TextView user = (TextView) findViewById(R.id.textViewUser);
		user.setText(s[1]);
		TextView log = (TextView) findViewById(R.id.textViewLog);
		log.setText(s[0]);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user, menu);
		return true;
	}

}
