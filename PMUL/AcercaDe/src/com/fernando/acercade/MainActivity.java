package com.fernando.acercade;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		View v = (View) findViewById(R.layout.activity_main);
		SharedPreferences misprefs = PreferenceManager.getDefaultSharedPreferences(this);
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
		case R.id.acerca_de:
			Intent intent = new Intent(this, AcercaDe.class);
			startActivity(intent);
			break;
		case R.id.preferencias:
			Intent intent2 = new Intent(this, SettingsActivity.class);
			startActivity(intent2);
			break;
		default:
			return false;
		}
		return true;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
