package com.fernando.adapterusuario;

import android.widget.ImageView;

public class Contacto {
	protected String nombre, telefono, email;
	protected int image;
	
	public Contacto(String nom, String tel, String mail, int img) {
		this.nombre = nom; this.telefono = tel; this.email = mail; this.image = img;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setImage(int img) {
		this.image = img;
	}
}
