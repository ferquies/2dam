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
				"nombre VARCHAR(20), tiempo INTEGER(32))";
		bd.execSQL(query);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase bd, int version_ant, int version_new) {
		bd.execSQL("DROP TABLE IF EXISTS puntuacion");
		onCreate(bd);
	}
	
	public void insertar(String nombre, double tiempo) {
		Cursor c = this.getReadableDatabase().rawQuery("SELECT * FROM puntuacion ORDER BY tiempo ASC", null);
		c.moveToLast();
		if(c.getCount() < 10 || tiempo <= c.getInt(c.getColumnIndex("tiempo"))) {
			ContentValues valores = new ContentValues();
			valores.put("nombre", nombre);
			valores.put("tiempo", tiempo);
			this.getWritableDatabase().insert("puntuacion", null, valores);
		}
	}
	
	public String[] leer() {
		Cursor c = this.getReadableDatabase().rawQuery("SELECT * FROM puntuacion ORDER BY tiempo ASC LIMIT 10", null);
		String result[] = new String[c.getCount()];
		int inom, itie;
		
		inom = c.getColumnIndex("nombre");
		itie = c.getColumnIndex("tiempo");
		
		c.moveToFirst();
		
		for(int i = 0; i < c.getCount(); i++) {
			result[i] = i+1 + "\t" + c.getString(inom) + "\t" + c.getInt(itie)/1000.00 + "\n";
			c.moveToNext();
		}

		return result;
	}
	
}
