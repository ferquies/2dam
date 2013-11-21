package com.fernando.adapterusuario;

import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Contacto [] valores_contacto = new Contacto[4];
		valores_contacto[0] = new Contacto("Charko", "600351029", "chrko@correo.com", R.drawable.reinicio);
		valores_contacto[1] = new Contacto("Visente", "600351029", "visente@correo.com", R.drawable.ic_launcher);
		valores_contacto[2] = new Contacto("Albertico", "600351029", "bertico@correo.com", R.drawable.reinicio);
		valores_contacto[3] = new Contacto("Albertico one more time", "600351029", "bertico@correo.com", R.drawable.ic_launcher);
		ListView lista = (ListView) findViewById(R.id.listView1);
		MyAdapter adaptador = new MyAdapter(this, R.layout.layoutmuestra, valores_contacto);
		lista.setAdapter(adaptador);
		View layCabecera = LayoutInflater.from(this).inflate(R.layout.cabecera, null);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
