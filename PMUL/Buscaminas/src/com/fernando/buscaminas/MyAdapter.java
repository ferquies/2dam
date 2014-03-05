package com.fernando.buscaminas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
	String[][] _jugador;
	protected int _layout_ref;
	protected Context _contexto;

	public MyAdapter(Context context, int layoutmuestra,
			String[][] valores_String) {
		super();
		this._jugador = valores_String;
		this._layout_ref = layoutmuestra;
		this._contexto = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return _jugador.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return _jugador[arg0];
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
		nombre.setText(_jugador[arg0][0]);
		TextView tiempo = (TextView) layoutView.findViewById(R.id.TextViewTiempo);
		tiempo.setText(_jugador[arg0][1]+"s");
		TextView minas = (TextView) layoutView.findViewById(R.id.textViewMinas);
		minas.setText("Minas: " + _jugador[arg0][2]);
		return layoutView;
	}
}
