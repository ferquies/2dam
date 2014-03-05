package com.fernando.buscaminas;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Toast;

public class About extends Activity {
	protected Context context;
	protected int cont, i;
	int egg[] = new int[4];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		context = getApplicationContext();
		findViewById(R.id.imageView1).setOnClickListener(gestor);
		cont = 0;
		i = 0;
		egg[0] = R.string.egg0;
		egg[1] = R.string.egg1;
		egg[2] = R.string.egg2;
		egg[3] = R.string.egg3;
	}
	
	private View.OnClickListener gestor = new View.OnClickListener() {
		public void onClick(View v) {
			cont++;
			if(cont == 5) {
				if(i == 4) i = 0;
				Toast toast = Toast.makeText(context, egg[i], Toast.LENGTH_SHORT);
				toast.show();
				cont = 0;
				i++;
			}
		}
	};

}
