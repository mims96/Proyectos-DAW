package modelo.javabeans;

import java.util.Objects;

public class Trabajo {
	/*
	 * Creamos los atributos privados de la clase Trabajo.
	 */
	private String idTrabajo, descripcion;
	private double minSalario, maxSalario;
	
	/*
	 * Generamos el constructor con todo y el constructor sin nada.
	 */
	public Trabajo(String idTrabajo, String descripcion, double minSalario, double maxSalario) {
		super();
		this.idTrabajo = idTrabajo;
		this.descripcion = descripcion;
		this.minSalario = minSalario;
		this.maxSalario = maxSalario;
	}
	public Trabajo() {
		super();
	}
	
	/*
	 * A continuacion añadimos los getters and setters de los atributos de la clase.
	 */
	public String getIdTrabajo() {
		return idTrabajo;
	}
	public void setIdTrabajo(String idTrabajo) {
		this.idTrabajo = idTrabajo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getMinSalario() {
		return minSalario;
	}
	public void setMinSalario(double minSalario) {
		this.minSalario = minSalario;
	}
	public double getMaxSalario() {
		return maxSalario;
	}
	public void setMaxSalario(double maxSalario) {
		this.maxSalario = maxSalario;
	}
	
	/*
	 * Generamos toString con todos los campos.
	 */
	@Override
	public String toString() {
		return "Trabajo [idTrabajo=" + idTrabajo + ", descripcion=" + descripcion + ", minSalario=" + minSalario
				+ ", maxSalario=" + maxSalario + "]";
	}
	
	/*
	 * Finalmente generamos el equals y el hashCode. Dos trabajos son iguales si el idTrabajo es el mismo.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(idTrabajo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trabajo other = (Trabajo) obj;
		return Objects.equals(idTrabajo, other.idTrabajo);
	}
	
	
	
}
