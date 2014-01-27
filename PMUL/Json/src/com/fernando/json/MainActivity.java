package com.fernando.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		try {
			StringBuffer sb = new StringBuffer();
			BufferedReader br = new BufferedReader(new InputStreamReader(getAssets().open("estudiantes.txt")));
			
			String tmp;
			while((tmp = br.readLine()) != null) {
				sb.append(tmp);
			}
			
			String JsonText = sb.toString();
			
			JSONObject jsonobj = new JSONObject(JsonText);
			JSONArray jsarr = jsonobj.getJSONArray("estudiantes");
			
			Estudiante [] valores_estudiante = new Estudiante[jsarr.length()];
			
			for(int i = 0; i < jsarr.length(); i++) {
				JSONObject elem = jsarr.getJSONObject(i);
				valores_estudiante[i] = new Estudiante(elem.getString("Nombre"), elem.getString("Apellido"), elem.getString("Curso"));
			}
			
			ListView lista = (ListView) findViewById(R.id.listView1);
			MyAdapter adaptador = new MyAdapter(this, R.layout.layoutmuestra, valores_estudiante);
			lista.setAdapter(adaptador);
			
		} catch(JSONException e) { e.printStackTrace();
		} catch (IOException e) { e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
