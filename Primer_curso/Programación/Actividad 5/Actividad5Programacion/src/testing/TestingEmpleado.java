package testing;

import modelo.javabeans.Departamento;
import modelo.javabeans.Empleado;
import modelo.javabeans.Localidad;
import modelo.javabeans.Trabajo;

public class TestingEmpleado {

	/*
	 * Creamos la clase TestingEmpleado con main.
	 */
	public static void main(String[] args) {
		/*
		 * A continuacion se procedera a la creacion de varios objetos:
		 * un objeto Localización,
		 * un objeto Departamento incluyendo esa Localizacion,
		 * un objeto Trabajo y
		 * un objeto Empleado con su Departamento y su Trabajo.
		 * Es necesario importar para que no de errores. Usamos el constructor con todo.
		 */
		Localidad localizacion =new Localidad(1, "Calle de la Marmota, 2", "Madrid", "España");
		Departamento depto = new Departamento(34, "Recursos Humanos", localizacion);
		Trabajo trab = new Trabajo("89", "Contratacion de personal", 1050.5, 2000.9);
		Empleado empl = new Empleado(47, "Lorenzo", "Garcia Lopez", "logarlo@yaju.es", 'H', 1200.5, 230.3, trab, depto);
		
		/*
		 * La informacion completa de un empleado sin emplear el metodo toString.
		 * Se pide: nombre, apellidos, genero, nombre del departamento, nombre de su trabajo, direccion, ciudad y pais.
		 */
		System.out.println("Nombre: " + empl.getNombre() + ", apellidos : " + empl.getApellidos() + ", genero: " + empl.getGenero() + ", nombre del departamento: " + empl.getDepartamento().getDescripcion() + ", nombre del trabajo: " + empl.getTrabajo().getDescripcion() + ", direccion: " + empl.getDepartamento().getLocalidad().getDireccion() + ", ciudad: " + empl.getDepartamento().getLocalidad().getCiudad() + ", y pais: " + empl.getDepartamento().getLocalidad().getPais());
		
		/*
		 * Se muestra por consola el trabajo del empleado y su departamento
		 */
		System.out.println("El trabajo del empleado es : " + empl.getTrabajo() + " y su departamento es : " + empl.getDepartamento());
		
	}

}
