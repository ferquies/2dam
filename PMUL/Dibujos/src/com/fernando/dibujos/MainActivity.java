package com.fernando.dibujos;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends Activity {
	protected Context context = this;
	protected float r1;
	protected float r2;
	protected double w1;
	protected double w2;
	
	private View.OnClickListener gestor = new View.OnClickListener() {
		public void onClick(View v) {
			FrameLayout fl = (FrameLayout) findViewById(R.id.frameLayout);
			MiVista mv = new MiVista(context);
			fl.addView(mv);
		}
	};
	
	private View.OnClickListener borrar = new View.OnClickListener() {
		public void onClick(View v) {
			FrameLayout fl = (FrameLayout) findViewById(R.id.frameLayout);
			fl.removeAllViews();
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button btndibujar = (Button) findViewById(R.id.buttonDibujar);
		Button btnborrar = (Button) findViewById(R.id.buttonBorrar);
		btndibujar.setOnClickListener(gestor);
		btnborrar.setOnClickListener(borrar);
		SeekBar radio1 = (SeekBar) findViewById(R.id.SeekBarRadio1);
		SeekBar radio2 = (SeekBar) findViewById(R.id.seekBarRadio2);
		SeekBar veloc1 = (SeekBar) findViewById(R.id.SeekBarVeloc1);
		SeekBar veloc2 = (SeekBar) findViewById(R.id.SeekBarVeloc2);
		radio1.setOnSeekBarChangeListener(gestor_radio1);
		radio2.setOnSeekBarChangeListener(gestor_radio2);
		veloc1.setOnSeekBarChangeListener(gestor_veloc1);
		veloc2.setOnSeekBarChangeListener(gestor_veloc2);
	}
	
	private OnSeekBarChangeListener gestor_radio1 = new OnSeekBarChangeListener() {

		@Override
		public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
			// TODO Auto-generated method stub
			r1 = arg1;
		}

		@Override
		public void onStartTrackingTouch(SeekBar arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onStopTrackingTouch(SeekBar arg0) {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	private OnSeekBarChangeListener gestor_radio2 = new OnSeekBarChangeListener() {

		@Override
		public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
			// TODO Auto-generated method stub
			r2 = arg1;
		}

		@Override
		public void onStartTrackingTouch(SeekBar arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onStopTrackingTouch(SeekBar arg0) {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	private OnSeekBarChangeListener gestor_veloc1 = new OnSeekBarChangeListener() {

		@Override
		public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
			// TODO Auto-generated method stub
			w1 = arg1;
		}

		@Override
		public void onStartTrackingTouch(SeekBar arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onStopTrackingTouch(SeekBar arg0) {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	private OnSeekBarChangeListener gestor_veloc2 = new OnSeekBarChangeListener() {

		@Override
		public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
			// TODO Auto-generated method stub
			w2 = arg1;
		}

		@Override
		public void onStartTrackingTouch(SeekBar arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onStopTrackingTouch(SeekBar arg0) {
			// TODO Auto-generated method stub
			
		}
		
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public class MiVista extends View{

		public MiVista(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
		}
		
		
		
		@SuppressLint("DrawAllocation")
		protected void onDraw(Canvas canvas)
		{
			int t = 1000;
			float xc = getWidth()/2;
			float yc = getHeight()/2;
			float x = 0;
			float y = 0;
			
			Paint p = new Paint();
			p.setColor(Color.BLACK);
			p.setStrokeWidth(2);
			for(int i = 0; i < t; i++)
			{
				x = (float) (xc + r1*Math.cos(w1*i) + r2 * Math.cos(w2*i));
				y = (float) (yc + r1*Math.sin(w1*i) + r2 * Math.sin(w2*i));
				canvas.drawPoint(x, y, p);
			}
		}

	}

}

