package com.fernando.json;

public class Estudiante {
	protected String nombre, apellido, curso;
	
	public Estudiante(String nom, String ape, String cur) {
		this.nombre = nom; this.apellido = ape; this.curso = cur;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String ape) {
		this.apellido = ape;
	}
	
	public String getCurso() {
		return curso;
	}
	
	public void setCurso(String cur) {
		this.curso = cur;
	}
}
