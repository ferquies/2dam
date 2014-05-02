package com.fernando.hungryeskimos;

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
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {
	protected Context context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		findViewById(R.id.sign_in_button).setOnClickListener(gestor);
		context = getApplicationContext();
	}
	
	private View.OnClickListener gestor = new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			URL params = null;
			try {
				params = new URL("http://comunikrte.es/android/prueba.php");
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}

			TextView tv = (TextView) findViewById(R.id.textView1);
			tv.setText("");
			TextView text = (TextView) findViewById(R.id.email);
			InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(text.getWindowToken(), 0);
			new MiClase().execute(params);
		}
	};
	
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
				TextView text = (TextView) findViewById(R.id.email);
				TextView p = (TextView) findViewById(R.id.password);
				String nombre = text.getText().toString();
				String pass = p.getText().toString();
				
				String POSTParam = "user=" + URLEncoder.encode(nombre, "UTF-8");
				String POSTParam2 = "pass=" + URLEncoder.encode(pass, "UTF-8");
				conexion.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
				PrintWriter out = new PrintWriter(conexion.getOutputStream());
				
				out.print(POSTParam+"&"+POSTParam2);
				out.close();

				String line = null;
			
				BufferedReader entrada = new BufferedReader(new InputStreamReader(conexion.getInputStream()));

				while((line = entrada.readLine()) != null) {
					result = result + line;
				}
				entrada.close();
				
			} catch(MalformedURLException mue) { mue.printStackTrace(); }
			catch(IOException ioe) { ioe.printStackTrace(); }
			return result;
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
