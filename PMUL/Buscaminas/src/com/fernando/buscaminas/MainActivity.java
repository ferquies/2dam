package com.fernando.buscaminas;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		int cols = 5;
		int rows = 5;
		int i, x;
		Button botones[][] = new Button[cols][rows];
		TableLayout layout = (TableLayout) findViewById(R.id.tableLayout);
		for(i = 0; i < cols; i++) {
			TableRow tr = new TableRow(this);
			for(x = 0; x < rows; x++) {
			    botones[i][x] = new Button(getApplicationContext());
			    tr.addView(botones[i][x]);
			}
			layout.addView(tr);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
