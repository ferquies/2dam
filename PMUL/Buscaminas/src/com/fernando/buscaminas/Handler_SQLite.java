package com.fernando.buscaminas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.provider.BaseColumns._ID;

public class Handler_SQLite extends SQLiteOpenHelper {

	public Handler_SQLite(Context context) {
		super(context, "Puntuaciones", null, 1);
	}
	
	@Override
	public void onCreate(SQLiteDatabase bd) {
		String query = "CREATE TABLE puntuacion (" + _ID + " INTEGER PRIMARY KEY, " +
				"nombre VARCHAR(20), tiempo INTEGER(32), minas INTEGER(32))";
		bd.execSQL(query);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase bd, int version_ant, int version_new) {
		bd.execSQL("DROP TABLE IF EXISTS puntuacion");
		onCreate(bd);
	}
	
	public void insertar(String nombre, double tiempo, int minas) {
		Cursor c = this.getReadableDatabase().rawQuery("SELECT * FROM puntuacion ORDER BY tiempo, minas ASC", null);
		int registros = c.getCount();
		if(registros != 0) {
			c.moveToLast();
		}
		if(registros < 20 || tiempo <= c.getInt(c.getColumnIndex("tiempo"))) {
			ContentValues valores = new ContentValues();
			valores.put("nombre", nombre);
			valores.put("tiempo", tiempo);
			valores.put("minas", minas);
			this.getWritableDatabase().insert("puntuacion", null, valores);
			if(c.getCount() > 19) {
				String consulta = "DELETE FROM puntuacion WHERE tiempo = (SELECT MAX(tiempo) FROM puntuacion)";
				this.getWritableDatabase().execSQL(consulta);
			}
		}
	}
	
	public String[][] leer() {
		Cursor c = this.getReadableDatabase().rawQuery("SELECT * FROM puntuacion ORDER BY tiempo, minas ASC", null);
		String result[][] = new String[c.getCount()][3];
		int inom, itie, imin;
		
		inom = c.getColumnIndex("nombre");
		itie = c.getColumnIndex("tiempo");
		imin = c.getColumnIndex("minas");
		
		c.moveToFirst();
		
		for(int i = 0; i < c.getCount(); i++) {
			result[i][0] = c.getString(inom);
			result[i][1] = String.valueOf(c.getInt(itie)/1000.00);
			result[i][2] = String.valueOf(c.getInt(imin));
			c.moveToNext();
		}

		return result;
	}
	
	public void reset() {
		String delete = "DROP TABLE IF EXISTS puntuacion";
		String create = "CREATE TABLE puntuacion (" + _ID + " INTEGER PRIMARY KEY, " +
				"nombre VARCHAR(20), tiempo INTEGER(32), minas INTEGER(32))";
		
		this.getWritableDatabase().execSQL(delete);
		this.getWritableDatabase().execSQL(create);
	}
	
}
