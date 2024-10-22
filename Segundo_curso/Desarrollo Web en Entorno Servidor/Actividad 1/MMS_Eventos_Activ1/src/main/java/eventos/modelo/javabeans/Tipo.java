package eventos.modelo.javabeans;

import java.io.Serializable;
import java.util.Objects;

/*
 * Se crean los atributos privados de la clase y se generan los 2 constructores, los getter and setter, el toString,
 * el equals y el hashCode.
 * Además, la clase tiene que implementar el Serializable. A continuación se introduce su dato privado y estático, 
 * aunque no interfiere en este ejercicio en ningún momento.
 */
public class Tipo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int idTipo;
	private String nombre;
	private String descripcion;
	
	public Tipo() {
		super();
	}
	
	public Tipo(int idTipo, String nombre, String descripcion) {
		super();
		this.idTipo = idTipo;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	public int getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return "Tipo [idTipo=" + idTipo + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(descripcion, idTipo, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tipo other = (Tipo) obj;
		return Objects.equals(descripcion, other.descripcion) && idTipo == other.idTipo
				&& Objects.equals(nombre, other.nombre);
	}
	
	
	
	
	

}
