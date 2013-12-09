package com.fernando.sqlitea;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Handler_SQLite helper = new Handler_SQLite(this);
		helper.abrir();
		//helper.insertar(20, "RRHH", "BARCELONA");
		TextView t = (TextView) findViewById(R.id.textView1);
		t.setText(helper.leer()[1]);
		helper.cerrar();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
