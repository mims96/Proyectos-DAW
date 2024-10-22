package modelo.javabeans;

import java.util.Objects;

public class Localidad {
	/*
	 * Comenzamos la actividad creando la clase Localidad. 
	 * En primer lugar creamos sus atributos privados.
	 */
	private int idLocalidad;
	private String direccion, ciudad, pais;
	
	/*
	 * A continuacion se crean los constructores, uno con todos los campos y otro sin nada.
	 * Para ello hay que darle al boton derecho> source> Generate Constructors using Field>
	 * En el caso del constructor con todo se incluye a todos (select all)> generate.
	 * Para el constructor sin nada se especifica deselect all> generate.
	 */
	public Localidad(int idLocalidad, String direccion, String ciudad, String pais) {
		super();
		this.idLocalidad = idLocalidad;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.pais = pais;
	}
	public Localidad() {
		super();
	}
	
	/*
	 * Creamos los getter and setter de cada atributo. Para obtenerlos también hay que hacer click en el boton derecho>
	 * Source> Generate Getters and Setters> Select all> Generate.
	 */
	public int getIdLocalidad() {
		return idLocalidad;
	}
	public void setIdLocalidad(int idLocalidad) {
		this.idLocalidad = idLocalidad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	/*
	 * Redefinimos metodos de Object. Igualmente, hay que pulsar el boton derecho> Source> Generate toString()...>
	 * se seleccionan todos los campos> Generate.
	 */
	@Override
	public String toString() {
		return "Localidad [idLocalidad=" + idLocalidad + ", direccion=" + direccion + ", ciudad=" + ciudad + ", pais="
				+ pais + "]";
	}
	
	/*
	 * Continuamos con equals y hashCode. Segun el enunciado, dos localidades son iguales si el idLocalidad es el mismo. 
	 * Por tanto: boton derecho> Source> Generate hashCode() and equals()...> Deselect all> seleccionamos solo idLocalidad>
	 * Generate.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(idLocalidad);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Localidad other = (Localidad) obj;
		return idLocalidad == other.idLocalidad;
	}
	
	
	
	
	
	
	
	

}
