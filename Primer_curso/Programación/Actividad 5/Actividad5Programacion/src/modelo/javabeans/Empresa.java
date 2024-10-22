package modelo.javabeans;

import java.util.ArrayList;

import modelo.dao.IntGestionEmpresa;


public class Empresa {
	/*
	 * Tras crear el interface, se crea la clase Empresa, donde se incluyen los atributos privados.
	 * Se debe importar el ArrayList del java.util.
	 */
	private String nombre;
	private ArrayList<Empleado> plantilla;
	
	/*
	 * Generamos los constructores. En este caso, el constructor con todo lleva el atributo nombre y el new ArrayList.
	 */
	public Empresa() {
		super();
	}
	public Empresa(String nombre, ArrayList<Empleado> plantilla) {
		super();
		this.nombre = nombre;
		plantilla = new ArrayList<>();
	}
	
	
	/*
	 * Se crea el getter and setter, en esta ocasion solo de nombre.
	 */
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
