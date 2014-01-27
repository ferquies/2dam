package com.fernando.json;

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
			Estudiante[] valores_estudiante) {
		super();
		this._estudiante = valores_estudiante;
		this._layout_ref = layoutmuestra;
		this._contexto = context;
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
