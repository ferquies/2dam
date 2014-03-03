package com.fernando.jsonurl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity {
	Context context;
	
private View.OnClickListener gestor = new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			URL params = null;
			try {
				params = new URL("http://comunikrte.es/estudiantes.json");
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar1);
			pb.setProgress(0);
			new MiClase().execute(params);
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context = getApplicationContext();
		findViewById(R.id.button1).setOnClickListener(gestor);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

class MiClase extends AsyncTask<URL, Integer, String> {
		
		protected void onPreExecute() {
			Toast toast = Toast.makeText(context, "Descargando", Toast.LENGTH_SHORT);
			toast.show();
		}

		protected String doInBackground(URL... arg0) {
			String result = "";
			try {
				URL url = arg0[0];
				HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
				String line = null;
				ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar1);
				pb.setMax(19);
				BufferedReader entrada = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
				while((line = entrada.readLine()) != null) {
					result = result + line;
					onProgressUpdate(1);
				}
				entrada.close();
				
			} catch(MalformedURLException mue) { mue.printStackTrace(); }
			catch(IOException ioe) { ioe.printStackTrace(); }
			return result;
		}
		
		protected void onProgressUpdate(Integer progress) {
	        ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar1);
	        pb.setProgress(pb.getProgress() + progress);
	    }
		
		protected void onPostExecute(String s)
		{
			ListView lista = (ListView) findViewById(R.id.listView1);
			MyAdapter adaptador = new MyAdapter(context, R.layout.layoutmuestra, s);
			lista.setAdapter(adaptador);	
		}
	}
}
