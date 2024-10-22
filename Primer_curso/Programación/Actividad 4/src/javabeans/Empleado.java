package javabeans;

public class Empleado {
	/*
	 * Una vez creada la clase incorporamos los siguientes atributos como privados:
	 */
	private int idEmpleado;
	private String nombre;
	private String apellidos;
	private String email;
	private double salario;
	private double complemento;
	private char sexo;
	private int idDepartamento;
	
	/*
	 * Para crear el constructor por defecto de manera no manual el proceso es:
	 * Boton derecho > Source > Generate Constructor using Fields > Deselect all > Generate
	 */
	public Empleado() {
		super();
	}
	
	/*
	 * El proceso para crear el constructor con todos los parametros es muy similar:
	 * Boton derecho > Source > Generate Constructor using Fields > Select all > Generate
	 */
	public Empleado(int idEmpleado, String nombre, String apellidos, String email, double salario,
			double complemento, char sexo, int idDepartamento) {
		super();
		this.idEmpleado = idEmpleado;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.salario = salario;
		this.complemento = complemento;
		this.sexo = sexo;
		this.idDepartamento = idDepartamento;
	}
	
	/*
	 * Ahora vamos a incluir los getter and setter para cada atributo privado.
	 * Boton derecho > Source > Generate Getters and Setters... > Select All > Generate
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

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public double getComplemento() {
		return complemento;
	}

	public void setComplemento(double complemento) {
		this.complemento = complemento;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public int getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	
	/*
	 * Para redefinir el metodo:
	 * Boton derecho > Source > Generate toString()... > Se seleccionan todos los atributos de Fields > Generate
	 */
	@Override
	public String toString() {
		return "Empleado [idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email="
				+ email + ", salario=" + salario + ", complemento=" + complemento + ", sexo=" + sexo
				+ ", idDepartamento=" + idDepartamento + "]";
	}
	
	/*
	 * A partir de este momento se van a crear los metodos propios del ejercicio.
	 * Para el metodo salarioBruto se suman tanto el salario como los complementos.
	 * Todos los valores tienen decimales (double).
	 * Suponemos que se trata del salario bruto anual.
	 */
	public double salarioBruto(){
		return salario+complemento;
	}
	/*
	 * Para hallar el salario mensual se divide el salario bruto (salario + complementos)
	 * entre el numero de meses escogido (en TestEmpleado seran 12 meses).
	 */
	public double salarioMensual(int meses){
		return (salario+complemento)/meses;
	}
	/*
	 * Para obtener el genero se ha hecho un switch segun el caracter 'H' o 'M' que tecleen.
	 * Para evitar errores en el momento de introducir caracteres se ha añadido el default.
	 */
	public String literalSexo() {
		switch (sexo) {
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
