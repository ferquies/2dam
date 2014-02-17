package com.fernando.intents;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	
	private View.OnClickListener llamar = new View.OnClickListener() {
		public void onClick(View v) {
			Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel: 644403612"));
			startActivity(intent);
		}
	};
	
	private View.OnClickListener internet = new View.OnClickListener() {
		public void onClick(View v) {
			Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.es"));
			startActivity(intent);
		}
	};
	
	private View.OnClickListener gps = new View.OnClickListener() {
		public void onClick(View v) {
			Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo: 20.15, 10.32"));
			startActivity(intent);
		}
	};
	
	private View.OnClickListener email = new View.OnClickListener() {
		public void onClick(View v) {
			Intent intent = new Intent(Intent.ACTION_SEND);
			intent.setType("text/plain");
			intent.putExtra(Intent.EXTRA_SUBJECT, "asunto");
			intent.putExtra(Intent.EXTRA_TEXT, "Hola mundo!");
			intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "ferquies@gmail.com" });
			startActivity(intent);
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.button1).setOnClickListener(llamar);
		findViewById(R.id.button2).setOnClickListener(internet);
		findViewById(R.id.button3).setOnClickListener(gps);
		findViewById(R.id.button4).setOnClickListener(email);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
