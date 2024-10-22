package modelo.javabeans;

import java.util.Objects;

public class Empleado {
	/*
	 * Creamos los atributos privados de la clase Empleado
	 */
	private int idEmpleado;
	private String nombre, apellidos, email;
	private char genero;
	private double salario, comision;
	private Trabajo trabajo;
	private Departamento departamento;
	
	/*
	 * Generamos un constructor con todos los parametros y otro sin nada.
	 */
	public Empleado(int idEmpleado, String nombre, String apellidos, String email, char genero, double salario,
			double comision, Trabajo trabajo, Departamento departamento) {
		super();
		this.idEmpleado = idEmpleado;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.genero = genero;
		this.salario = salario;
		this.comision = comision;
		this.trabajo = trabajo;
		this.departamento = departamento;
	}
	public Empleado() {
		super();
	}
	
	/*
	 * Generamos los getter and setter de cada atributo privado.
	 */
	public int getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public char getGenero() {
		return genero;
	}
	public void setGenero(char genero) {
		this.genero = genero;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public double getComision() {
		return comision;
	}
	public void setComision(double comision) {
		this.comision = comision;
	}
	public Trabajo getTrabajo() {
		return trabajo;
	}
	public void setTrabajo(Trabajo trabajo) {
		this.trabajo = trabajo;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	/*
	 * Redefinimos toString().
	 */
	@Override
	public String toString() {
		return "Empleado [idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email="
				+ email + ", genero=" + genero + ", salario=" + salario + ", comision=" + comision + ", trabajo="
				+ trabajo + ", departamento=" + departamento + "]";
	}
	
	/*
	 * Redefinimos equals y hashCode. Dos empleados son iguales si su idEmpleado es el mismo.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(idEmpleado);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return idEmpleado == other.idEmpleado;
	}
	
	/*
	 * A partir de este momento se van a crear los metodos propios de la clase Empleado, a diferencia de las otras 
	 * clases que no cuentan con metodos propios.
	 * Para el metodo salarioBruto se suman tanto el salario como los complementos.
	 * Todos los valores tienen decimales (double).
	 * Suponemos que se trata del salario bruto anual.
	 */
	
	
	public double salarioBruto(){
		return salario+comision;
	}
	/*
	 * Para hallar el salario mensual se divide el salario bruto (salario + complementos)
	 * entre el numero de meses escogido (en TestEmpleado seran 12 meses).
	 */
	public double salarioMensual(int meses){
		return (salario+comision)/meses;
	}
	/*
	 * Para obtener el genero se ha hecho un switch segun el caracter 'H' o 'M' que tecleen.
	 * Para evitar errores en el momento de introducir caracteres se ha añadido el default.
	 */
	public String literalSexo() {
		switch (genero) {
		case 'H':
			return "Hombre";
		case 'M':
			return "Mujer";
		default:
			return "Sexo erroneo";
		}
	}
	/*
	 * En este caso del email hay que poner tanto el primer caracter del nombre como el primer apellido en minusculas.
	 * El metodo que se usa en ambos casos, por tanto, es toLowerCase.
	 * Para obtener el primer caracter del nombre se ha empleado un charAt del caracter 0 (o primera letra del nombre).
	 * Con respecto a los apellidos, para conseguir que se muestre por consola solo el primero se ha empleado un metodo split,
	 * de tal manera que deje de imprimir la cadena cuando encuentre un espacio en blanco.
	 */
	public String obtenerEmail() {
		return nombre.toLowerCase().charAt(0) + apellidos.split(" ")[0].toLowerCase() + "@gmail.com";
	}
	/*
	 * Finalmente para escribir el nombre completo se concatenan los atributos nombre y apellidos con un espacio en blanco.
	 */
	public String nombreCompleto() {
		return nombre + " " + apellidos;
	}
	
	
	
	
}
