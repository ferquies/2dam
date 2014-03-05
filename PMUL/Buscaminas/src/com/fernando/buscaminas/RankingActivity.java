package com.fernando.buscaminas;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class RankingActivity extends Activity {
	Context context;
	Handler_SQLite helper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ranking);
		context = getApplicationContext();
		helper = new Handler_SQLite(this);
		String lec[][]  = helper.leer();
		ListView lista = (ListView) findViewById(R.id.listView1);
		MyAdapter adaptador = new MyAdapter(context, R.layout.layoutmuestra, lec);
		lista.setAdapter(adaptador);
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ranking, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
		case R.id.reset:
			helper.reset();
			finish();
			break;
		default:
			return false;
		}
		return true;
	}

}
