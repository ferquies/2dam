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
		int cols = 10;
		int rows = 5;
		int i, x, z = 0;
		Button botones[][] = new Button[cols][rows];
		TableLayout layout = (TableLayout) findViewById(R.id.tableLayout);
		for(i = 0; i < cols; i++) {
			TableRow tr = new TableRow(this);
			for(x = 0; x < rows; x++) {
				z++;
			    botones[i][x] = new Button(getApplicationContext());
//			    botones[i][x].setMaxWidth(layout.getWidth()/cols);
//			    botones[i][x].setMaxHeight(layout.getHeight()/rows);
			    botones[i][x].setText(String.valueOf(z));
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
