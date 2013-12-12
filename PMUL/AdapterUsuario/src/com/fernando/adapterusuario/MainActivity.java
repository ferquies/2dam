package com.fernando.adapterusuario;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Paises [] valores_contacto = new Paises[4];
		valores_contacto[0] = new Paises("Charko", "600351029", "chrko@correo.com", R.drawable.reinicio);
		valores_contacto[1] = new Paises("Visente", "600351029", "visente@correo.com", R.drawable.ic_launcher);
		valores_contacto[2] = new Paises("Albertico", "600351029", "bertico@correo.com", R.drawable.reinicio);
		valores_contacto[3] = new Paises("Albertico one more time", "600351029", "bertico@correo.com", R.drawable.ic_launcher);
		ListView lista = (ListView) findViewById(R.id.listView1);
		MyAdapter adaptador = new MyAdapter(this, R.layout.layoutmuestra, valores_contacto);
		lista.setAdapter(adaptador);		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
