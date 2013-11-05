package com.fernando.adapter1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		String [] values = new String[] {"Item1", "Hola mundo", "Item3", "Item cuatro" };
		ArrayAdapter<String> miadap = new ArrayAdapter<String>(this, R.layout.items, R.id.textView1, values);
		ListView list = (ListView) findViewById(R.id.listView1);
		list.setAdapter(miadap);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
