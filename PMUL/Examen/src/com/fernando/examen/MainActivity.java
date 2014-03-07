package com.fernando.examen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	protected Context context;
	
	private View.OnClickListener gestor = new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			String[] params = new String[3];
			params[0] = "10.0.2.2";
			TextView user = (TextView) findViewById(R.id.editTextUser);
			TextView pass = (TextView) findViewById(R.id.editTextPass);
			params[1] = user.getText().toString();
			params[2] = pass.getText().toString();
			new MiClase().execute(params);
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context = getApplicationContext();
		findViewById(R.id.buttonEnviar).setOnClickListener(gestor);
	}
	
	class MiClase extends AsyncTask<String, Integer, String[]> {
		
		protected void onPreExecute() {}
		
		protected String[] doInBackground(String... arg0) {
			String[] result = new String[2];
			try {
				URL url = new URL("http", arg0[0], "examen.php");
				HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
				conexion.setRequestMethod("POST");
				conexion.setDoOutput(true);
				conexion.setDoInput(true);
				String POSTUser = "username=" + URLEncoder.encode(arg0[1], "UTF-8");
				String POSTPass = "password=" + URLEncoder.encode(arg0[2], "UTF-8");
				conexion.setFixedLengthStreamingMode(POSTUser.getBytes().length);
				conexion.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
				PrintWriter out = new PrintWriter(conexion.getOutputStream());
				out.print(POSTUser);
				//out.print(POSTPass);
				out.close();
			
				String line = null;
				
				result[1] = arg0[1];
				result[0] = "";
			
				BufferedReader entrada = new BufferedReader(new InputStreamReader(conexion.getInputStream()));

				while((line = entrada.readLine()) != null) {
					result[0] = result[0] + line;
				}
				entrada.close();
				
			} catch(MalformedURLException mue) { mue.printStackTrace(); }
			catch(IOException ioe) {
				// Comentar la linea de abajo al probar con un servidor web
				//result[1] = "fernando"; result[0] = "10:30\n12:55";
			}
			return result;
		}
		
		protected void onPostExecute(String[] s)
		{
			if(s[0].contains("false")) {
				Toast toast = Toast.makeText(context, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT);
				toast.show();
			} else {
				Intent intent = new Intent(context, UserActivity.class);
				intent.putExtra("data", s);
				startActivity(intent);
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
