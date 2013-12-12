package com.fernando.ejercicio7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Adapter extends BaseAdapter {
	Paises[] _pais;
	protected int _layout_ref;
	protected Context _contexto;

	public Adapter(Context context, int layoutmuestra,
			Paises[] valores_contacto) {
		super();
		this._pais = valores_contacto;
		this._layout_ref = layoutmuestra;
		this._contexto = context;
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return _pais.length;
	}

	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return _pais[arg0];
	}

	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	public View getView(int arg0, View layoutView, ViewGroup viewGroup) {
		// TODO Auto-generated method stub
		if(layoutView == null) {
			layoutView = LayoutInflater.from(_contexto).inflate(_layout_ref, null);
		}
		TextView nombre = (TextView) layoutView.findViewById(R.id.textViewNombre);
		nombre.setText(_pais[arg0].nombre);
		TextView habitantes = (TextView) layoutView.findViewById(R.id.textViewHabitantes);
		habitantes.setText(String.valueOf(_pais[arg0].num_hab));
		return layoutView;
	}
}
