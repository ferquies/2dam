package com.fernando.internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	protected Context context;
	
	private View.OnClickListener gestor = new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			URL params = null;
			try {
				params = new URL("http://comunikrte.es/shitdroid.php");
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar1);
			pb.setProgress(0);
			TextView tv = (TextView) findViewById(R.id.textView1);
			tv.setText("");
			TextView text = (TextView) findViewById(R.id.editText1);
			InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(text.getWindowToken(), 0);
			new MiClase().execute(params);
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.button1).setOnClickListener(gestor);
		context = getApplicationContext();
		// Desactivar el Strict mode [-No utilizar en produccion, solo depurar-]
		/* StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy); */
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	class MiClase extends AsyncTask<URL, Integer, String> {
		
		protected void onPreExecute() {
			Toast toast = Toast.makeText(context, "Enviando...", Toast.LENGTH_SHORT);
			toast.show();
		}

		protected String doInBackground(URL... arg0) {
			String result = "";
			try {
				URL url = arg0[0];
				HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
				conexion.setRequestMethod("POST");
				conexion.setDoOutput(true);
				conexion.setDoInput(true);
				TextView text = (TextView) findViewById(R.id.editText1);
				String nombre = text.getText().toString();
				String POSTParam = "name=" + URLEncoder.encode(nombre, "UTF-8");
				conexion.setFixedLengthStreamingMode(POSTParam.getBytes().length);
				conexion.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
				PrintWriter out = new PrintWriter(conexion.getOutputStream());
				out.print(POSTParam);
				out.close();
			
				String line = null;
			
				BufferedReader entrada = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
				ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar1);
				pb.setMax(1);
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
			TextView text = (TextView) findViewById(R.id.textView1);
			text.setText(s);
			Toast toast = Toast.makeText(context, "¡Terminado!", Toast.LENGTH_SHORT);
			toast.show();
		}
	}
}
