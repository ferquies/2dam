package com.fernando.adapterusuario;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
	Contacto[] _contacto;
	protected int _layout_ref;
	protected Context _contexto;

	public MyAdapter(Context context, int layoutmuestra,
			Contacto[] valores_contacto) {
		super();
		this._contacto = valores_contacto;
		this._layout_ref = layoutmuestra;
		this._contexto = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return _contacto.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return _contacto[arg0];
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
		nombre.setText(_contacto[arg0].nombre);
		TextView telefono = (TextView) layoutView.findViewById(R.id.TextViewTel);
		telefono.setText(_contacto[arg0].telefono);
		TextView email = (TextView) layoutView.findViewById(R.id.textViewMail);
		email.setText(_contacto[arg0].email);
		ImageView image = (ImageView) layoutView.findViewById(R.id.imageView1);
		image.setImageResource(_contacto[arg0].image);
		return layoutView;
	}
}
