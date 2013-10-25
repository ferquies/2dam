package com.fernando.relojanalogico;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final MiReloj rel = (MiReloj) findViewById(R.id.miReloj1);
		TimerTask cambiaHora = new TimerTask() {
			public void run() {
				rel.setTime(rel.getMinute()+1);
				rel.postInvalidate();
			}
		};
		Timer tiempo = new Timer();
		tiempo.scheduleAtFixedRate(cambiaHora, 2000, 1000);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
