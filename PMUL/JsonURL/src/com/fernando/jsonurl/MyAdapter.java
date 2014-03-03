package com.fernando.jsonurl;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
	Estudiante[] _estudiante;
	protected int _layout_ref;
	protected Context _contexto;

	public MyAdapter(Context context, int layoutmuestra,
			String json) {
		super();
		try {			
			JSONObject jsonobj = new JSONObject(json);
			JSONArray jsarr = jsonobj.getJSONArray("estudiantes");
			
			Estudiante [] valores_estudiante = new Estudiante[jsarr.length()];
			
			for(int i = 0; i < jsarr.length(); i++) {
				JSONObject elem = jsarr.getJSONObject(i);
				valores_estudiante[i] = new Estudiante(elem.getString("Nombre"), elem.getString("Apellido"), elem.getString("Curso"));
			}
			
			this._estudiante = valores_estudiante;
			this._layout_ref = layoutmuestra;
			this._contexto = context;
		} catch(JSONException e) { e.printStackTrace(); }
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return _estudiante.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return _estudiante[arg0];
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View layoutView, ViewGroup viewGroup) {
		// TODO Auto-generated method stub
		if(layoutView == null) {
			layoutView = LayoutInflater.from(_contexto).inflate(_layout_ref, null);
		}
		TextView nombre = (TextView) layoutView.findViewById(R.id.textViewNombre);
		nombre.setText(_estudiante[arg0].nombre);
		TextView apellido = (TextView) layoutView.findViewById(R.id.TextViewApe);
		apellido.setText(_estudiante[arg0].apellido);
		TextView curso = (TextView) layoutView.findViewById(R.id.textViewCurso);
		curso.setText(_estudiante[arg0].curso);
		return layoutView;
	}
}
