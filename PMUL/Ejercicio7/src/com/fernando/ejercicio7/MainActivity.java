package com.fernando.ejercicio7;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity {
	private View.OnClickListener gestor_salir = new View.OnClickListener() {
		public void onClick(View v) {
			finish();
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button btnSalir = (Button) findViewById(R.id.btnSalir);
		btnSalir.setOnClickListener(gestor_salir);
		Paises [] valores_paises = new Paises[3];
		valores_paises[0] = new Paises("España", 47654345);
		valores_paises[1] = new Paises("Francia", 63654345);
		valores_paises[2] = new Paises("Rusia", 80923856);
		ListView lista = (ListView) findViewById(R.id.listViewPaises);
		Adapter adaptador = new Adapter(this, R.layout.layoutmuestra, valores_paises);
		lista.setAdapter(adaptador);	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
