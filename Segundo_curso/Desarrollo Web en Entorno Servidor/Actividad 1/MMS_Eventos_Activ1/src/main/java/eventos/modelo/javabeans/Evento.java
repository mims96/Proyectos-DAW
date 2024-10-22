package eventos.modelo.javabeans;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/*
 * Se crean los atributos privados de la clase y se generan los 2 constructores, los getter and setter, el toString,
 * el equals y el hashCode.
 * Hay que tener en cuenta que se crea un objeto entero de la clase Tipo.
 * Además, la clase tiene que implementar el Serializable. A continuación se introduce su dato privado y estático, 
 * aunque no interfiere en este ejercicio en ningún momento.
 */
public class Evento implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int idEvento;
	private String nombre;
	private String descripcion;
	private Date fechaInicio;
	private int duracion;
	private String direccion;
	private String estado;
	private String destacado;
	private int aforoMaximo;
	private int minimoAsistencia;
	private double precio;
	private Tipo tipo;
	
	public Evento() {
		super();
	}
	
	public Evento(int idEvento, String nombre, String descripcion, Date fechaInicio, int duracion, String direccion,
			String estado, String destacado, int aforoMaximo, int minimoAsistencia, double precio, Tipo tipo) {
		super();
		this.idEvento = idEvento;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.duracion = duracion;
		this.direccion = direccion;
		this.estado = estado;
		this.destacado = destacado;
		this.aforoMaximo = aforoMaximo;
		this.minimoAsistencia = minimoAsistencia;
		this.precio = precio;
		this.tipo = tipo;
	}
	
	public int getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
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
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getDestacado() {
		return destacado;
	}
	public void setDestacado(String destacado) {
		this.destacado = destacado;
	}
	public int getAforoMaximo() {
		return aforoMaximo;
	}
	public void setAforoMaximo(int aforoMaximo) {
		this.aforoMaximo = aforoMaximo;
	}
	public int getMinimoAsistencia() {
		return minimoAsistencia;
	}
	public void setMinimoAsistencia(int minimoAsistencia) {
		this.minimoAsistencia = minimoAsistencia;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return "Evento [idEvento=" + idEvento + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fechaInicio="
				+ fechaInicio + ", duracion=" + duracion + ", direccion=" + direccion + ", estado=" + estado
				+ ", destacado=" + destacado + ", aforoMaximo=" + aforoMaximo + ", minimoAsistencia=" + minimoAsistencia
				+ ", precio=" + precio + ", tipo=" + tipo + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(aforoMaximo, descripcion, destacado, direccion, duracion, estado, fechaInicio, idEvento,
				minimoAsistencia, nombre, precio, tipo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		return aforoMaximo == other.aforoMaximo && Objects.equals(descripcion, other.descripcion)
				&& Objects.equals(destacado, other.destacado) && Objects.equals(direccion, other.direccion)
				&& duracion == other.duracion && Objects.equals(estado, other.estado)
				&& Objects.equals(fechaInicio, other.fechaInicio) && idEvento == other.idEvento
				&& minimoAsistencia == other.minimoAsistencia && Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio)
				&& Objects.equals(tipo, other.tipo);
	}
	
	

	

}
