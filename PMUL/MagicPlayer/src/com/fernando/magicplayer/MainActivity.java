package com.fernando.magicplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	
	protected MediaPlayer rep;
	
	private View.OnClickListener play = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			rep.start();
		}
	};
	
	private View.OnClickListener stop = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			rep.pause();
			rep.seekTo(0);
		}
	};
	
	private View.OnClickListener pausa = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			rep.pause();
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button btnPlay = (Button) findViewById(R.id.btnPlay);
		Button btnStop = (Button) findViewById(R.id.btnStop);
		Button btnPausa = (Button) findViewById(R.id.btnPausa);
		btnPlay.setOnClickListener(play);
		btnStop.setOnClickListener(stop);
		btnPausa.setOnClickListener(pausa);
		rep = MediaPlayer.create(this, R.raw.track1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
