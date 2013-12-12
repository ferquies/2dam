package com.fernando.ejercicio7;

public class Paises {
	protected String nombre;
	protected int num_hab;
	
	public Paises(String nom, int num_hab) {
		this.nombre = nom; this.num_hab = num_hab;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setNum_hab(int num_hab) {
		this.num_hab = num_hab;
	}
	
	public int getNum_hab() {
		return this.num_hab;
	}
}
