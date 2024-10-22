package modelo.javabeans;

import java.util.Objects;

public class Departamento {
	/*
	 * Continuamos creando las clases. Comenzamos con los atributos privados de la clase Departamento.
	 */
	private int idDepar;
	private String descripcion;
	private Localidad localidad;
	
	/*
	 * Continuamos generando los dos constructores, uno con todos los parametros y otro sin nada.
	 */
	public Departamento(int idDepar, String descripcion, Localidad localidad) {
		super();
		this.idDepar = idDepar;
		this.descripcion = descripcion;
		this.localidad = localidad;
	}
	public Departamento() {
		super();
	}
	
	/*
	 * Volvemos a seleccionar todos los campos para generar los getters and setters.
	 */
	public int getIdDepar() {
		return idDepar;
	}
	public void setIdDepar(int idDepar) {
		this.idDepar = idDepar;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Localidad getLocalidad() {
		return localidad;
	}
	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
	
	/*
	 * Redefinimos los metodos de Object
	 */
	@Override
	public String toString() {
		return "Departamento [idDepar=" + idDepar + ", descripcion=" + descripcion + ", localidad=" + localidad + "]";
	}
	
	/*
	 * Añadimos equals y hashCode teniendo en cuenta que dos departamentos son iguales si su idDepar es el mismo.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(idDepar);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		return idDepar == other.idDepar;
	}
	
	
}
