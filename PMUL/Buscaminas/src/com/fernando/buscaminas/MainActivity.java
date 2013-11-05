package com.fernando.buscaminas;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends Activity {
	protected Button botones[][];
	protected int rows = 9, cols = 5;
	
	// Rellena la pantalla con los botones
	public void rellenarPantalla() {
		EditText nm = (EditText) findViewById(R.id.editText1);
		String n = String.valueOf(nm.getText());
		int i, x, z = 0, minas = 1;
		if(Integer.parseInt(n) > rows*cols) {
			minas = rows*cols;
		} else if(Integer.parseInt(n) < 1 || n.equals(null)) {
			minas = 1;
		} else {
			minas = Integer.parseInt(n);
		}
		Button btnReiniciar = (Button) findViewById(R.id.btnReiniciar);
		btnReiniciar.setBackgroundResource(R.drawable.inicio);
		TextView textMinas = (TextView) findViewById(R.id.textMinas);
		textMinas.setText("Minas: " + String.valueOf(minas));
		Random rand = new Random();
		botones = new Button[rows][cols];
		TableLayout layout = (TableLayout) findViewById(R.id.tableLayout);
		for(i = 0; i < rows; i++) {
			TableRow tr = new TableRow(this);
			for(x = 0; x < cols; x++) {
			    botones[i][x] = new Button(getApplicationContext());
//			    botones[i][x].setMaxWidth(layout.getWidth()/cols);
//			    botones[i][x].setMaxHeight(layout.getHeight()/rows);
			    botones[i][x].setId(z);
			    botones[i][x].setOnClickListener(gestor);
			    botones[i][x].setOnLongClickListener(mantener);
			    tr.addView(botones[i][x]);
			    z++;
			}
			layout.addView(tr);
		}
		while(minas > 0) {
			int f, c;
			f = rand.nextInt(rows);
			c = rand.nextInt(cols);
			if(compruebaMina(f, c) == true) {
				botones[f][c].setSelected(true);
				minas--;
			}
		}
	}
	
	// Comprueba si hay mina en la posicion indicada
	public boolean compruebaMina(int i, int x) {
		if(!botones[i][x].isSelected())
			return true;
		else
			return false;
	}
	
	// Comprueba el numero de minas alrededor de la posicion indicada
	public int numMinas(int f, int c) {
		int num = 0;
		if(f > 0 && f < rows-1 && c > 0 && c < cols-1) {
			if(botones[f-1][c].isSelected()) {
				num++;
			} if(botones[f-1][c-1].isSelected()) {
				num++;
			} if(botones[f-1][c+1].isSelected()) {
				num++;
			} if(botones[f+1][c].isSelected()) {
				num++;
			} if(botones[f+1][c-1].isSelected()) {
				num++;
			} if(botones[f+1][c+1].isSelected()) {
				num++;
			} if(botones[f][c-1].isSelected()) {
				num++;
			} if(botones[f][c+1].isSelected()) {
				num++;
			}
		} else if(f == 0 && c == 0) {
			if(botones[f][c+1].isSelected()) {
				num++;
			} if(botones[f+1][c+1].isSelected()) {
				num++;
			} if(botones[f+1][c].isSelected()) {
				num++;
			}
		} else if(f == rows-1 && c == 0) {
			if(botones[f-1][c].isSelected()) {
				num++;
			} if(botones[f-1][c+1].isSelected()) {
				num++;
			} if(botones[f][c+1].isSelected()) {
				num++;
			}
		} else if(f == 0 && c == cols-1) {
			if(botones[f+1][c].isSelected()) {
				num++;
			} if(botones[f+1][c-1].isSelected()) {
				num++;
			} if(botones[f][c-1].isSelected()) {
				num++;
			}
		} else if(f == rows-1 && c == cols-1) {
			if(botones[f-1][c].isSelected()) {
				num++;
			} if(botones[f-1][c-1].isSelected()) {
				num++;
			} if(botones[f][c-1].isSelected()) {
				num++;
			}
		} else if(c == 0) {
			if(botones[f-1][c].isSelected()) {
				num++;
			} if(botones[f+1][c].isSelected()) {
				num++;
			} if(botones[f-1][c+1].isSelected()) {
				num++;
			} if(botones[f+1][c+1].isSelected()) {
				num++;
			} if(botones[f][c+1].isSelected()) {
				num++;
			}
		} else if(c == cols-1) {
			if(botones[f-1][c].isSelected()) {
				num++;
			} if(botones[f+1][c].isSelected()) {
				num++;
			} if(botones[f-1][c-1].isSelected()) {
				num++;
			} if(botones[f+1][c-1].isSelected()) {
				num++;
			} if(botones[f][c-1].isSelected()) {
				num++;
			}
		} else if(f == 0) {
			if(botones[f][c+1].isSelected()) {
				num++;
			} if(botones[f][c-1].isSelected()) {
				num++;
			} if(botones[f+1][c-1].isSelected()) {
				num++;
			} if(botones[f+1][c+1].isSelected()) {
				num++;
			} if(botones[f+1][c].isSelected()) {
				num++;
			}
		} else if(f == rows-1) {
			if(botones[f][c+1].isSelected()) {
				num++;
			} if(botones[f][c-1].isSelected()) {
				num++;
			} if(botones[f-1][c-1].isSelected()) {
				num++;
			} if(botones[f-1][c+1].isSelected()) {
				num++;
			} if(botones[f-1][c].isSelected()) {
				num++;
			}
		}
		
		return num;
	}
	
	// Al pulsar sobre una mina muestra el contenido de cada posicion y cambia el
	// texto del boton de reinicio
	public void perder() {
		for(int i = 0; i <= rows*cols; i++) {
			int c = 0, f = 0, col = 0, fila = 0;
			for(c = 0; c < cols; c++) {
				for(f = 0; f < rows; f++) {
					if(botones[f][c].getId() == i) {
						col = c;
						fila = f;
					}
				}
			}
			if(botones[fila][col].isSelected()) {
//				botones[fila][col].setText("*");
				botones[fila][col].setBackgroundResource(R.drawable.bomba);
				botones[fila][col].setEnabled(false);
			}
			else {
				if(numMinas(fila, col) == 0 || numMinas(fila, col) == 1) {
					botones[fila][col].setText(String.valueOf(numMinas(fila, col)));
				} else if(numMinas(fila, col) == 2) {
					botones[fila][col].setText(String.valueOf(numMinas(fila, col)));
					botones[fila][col].setTextColor(Color.YELLOW);
				} else {
					botones[fila][col].setText(String.valueOf(numMinas(fila, col)));
					botones[fila][col].setTextColor(Color.RED);
				}
				botones[fila][col].setEnabled(false);
			}
			Button btnReiniciar = (Button) findViewById(R.id.btnReiniciar);
			btnReiniciar.setBackgroundResource(R.drawable.reinicio);
		}
	}
	
	// Comprueba si tiene mina o no y le asigna un valor
	public void comprobar(int id) {
		int c = 0, f = 0, col = 0, fila = 0;
		for(c = 0; c < cols; c++) {
			for(f = 0; f < rows; f++) {
				if(botones[f][c].getId() == id) {
					col = c;
					fila = f;
				}
			}
		}
		if(botones[fila][col].isSelected()) {
			perder();
		}
		else {
			int num = numMinas(fila, col);
			if(num == 0 || num == 1) {
				botones[fila][col].setText(String.valueOf(numMinas(fila, col)));
			} else if(num == 2) {
				botones[fila][col].setText(String.valueOf(numMinas(fila, col)));
				botones[fila][col].setTextColor(Color.YELLOW);
			} else {
				botones[fila][col].setText(String.valueOf(numMinas(fila, col)));
				botones[fila][col].setTextColor(Color.RED);
			}
			botones[fila][col].setEnabled(false);
		}
	}
	
	// Comprueba si se han pulsado todas las posiciones
	public boolean comprobar_acabar() {
		int pulsados = 0;
		for(int i = 0; i < cols*rows; i++) {
			Button btn = (Button) findViewById(i);
			if(btn.isActivated()) {
				pulsados++;
			}
		}
		if(pulsados == rows*cols)
			return true;
		else
			return false;
	}
	
	// Muestra todas las posiciones y cambia el texto del boton de reinicio
	public void ganar() {
		perder();
		Button btnReiniciar = (Button) findViewById(R.id.btnReiniciar);
		btnReiniciar.setBackgroundResource(R.drawable.ganar);
	}
	
	// Listener de cada boton
	private View.OnClickListener gestor = new View.OnClickListener() {
		public void onClick(View v) {
			comprobar(v.getId());
			v.setActivated(true);
			if(comprobar_acabar())
				ganar();
		}
	};
	
	// Listener de pulsacion larga para cada boton
	private View.OnLongClickListener mantener = new View.OnLongClickListener() {
		public boolean onLongClick(View v) {
			Button btn = (Button) findViewById(v.getId());
			v.setActivated(true);
			btn.setBackgroundResource(R.drawable.bandera);
			if(comprobar_acabar())
				ganar();
			
			return true;
		}
	};
	
	// Listener del boton de reinicio
	private View.OnClickListener gestor_reinicio = new View.OnClickListener() {
		public void onClick(View v) {
			TableLayout layout = (TableLayout) findViewById(R.id.tableLayout);
			layout.removeAllViews();
			rellenarPantalla();
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button btnReiniciar = (Button) findViewById(R.id.btnReiniciar);
		rellenarPantalla();
		btnReiniciar.setOnClickListener(gestor_reinicio);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
