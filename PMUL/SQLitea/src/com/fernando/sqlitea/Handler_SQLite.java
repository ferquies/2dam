package com.fernando.sqlitea;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.provider.BaseColumns._ID;

public class Handler_SQLite extends SQLiteOpenHelper {

	public Handler_SQLite(Context context) {
		super(context, "MiBD", null, 1);
	}
	
	@Override
	public void onCreate(SQLiteDatabase bd) {
		String query = "CREATE TABLE departamentos (" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
				"dept_no INT, dnombre VARCHAR(20), loc VARCHAR(20));";
		bd.execSQL(query);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase bd, int version_ant, int version_new) {
		bd.execSQL("DROP TABLE IF EXISTS departamentos");
		onCreate(bd);
	}
	
	public void abrir() {
		this.getWritableDatabase();
	}
	
	public void cerrar() {
		this.close();
	}
	
	public void insertar(int dept_no, String dnombre, String loc) {
		ContentValues valores = new ContentValues();
		valores.put("dept_no", dept_no);
		valores.put("dnombre", dnombre);
		valores.put("loc", loc);
		this.getWritableDatabase().insert("departamentos", null, valores);
	}
	
	public String[] leer() {
		String result[] = new String[10];
		String columns[] = { _ID, "dept_no", "dnombre", "loc" };
		Cursor c = this.getReadableDatabase().query("departamentos", columns, null, null, null, null, null);
		int id, idep, idnom, iloc;
		
		id = c.getColumnIndex(_ID);
		idep = c.getColumnIndex("dept_no");
		idnom = c.getColumnIndex("dnombre");
		iloc = c.getColumnIndex("loc");
		
		c.moveToFirst();
		
		for(int i = 0; !c.isAfterLast(); i++) {
			result[i] = c.getInt(id) + " " + c.getInt(idep) + " " + c.getString(idnom) + " " + c.getString(iloc);
			c.moveToNext();
		}

		return result;
	}
	
}
