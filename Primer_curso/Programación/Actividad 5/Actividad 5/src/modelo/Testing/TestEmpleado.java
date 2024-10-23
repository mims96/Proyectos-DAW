package modelo.Testing;

import modelo.javabeans.Departamento;
import modelo.javabeans.Empleado;
import modelo.javabeans.Localidad;
import modelo.javabeans.Trabajo;

public class TestEmpleado {

	public static void main(String[] args) {
		
		// Creamos un objeto de clase Localidad.
		
		Localidad local1 = new Localidad(1002, "Calle palamos nº 180", "Palafrugell", "España");
		
		//Creamos un objeto de la clase Departamento con una localidad asignada.
		
		Departamento depar1 = new Departamento(305, "Finanzada", local1);
		
		// Creamos un objeto de la clase Trabajo.
		
		Trabajo trab1 = new Trabajo("025", "Administrativo", 1200, 1900);
		
		//Creamos un objeto de la clase Empleado con un Trabajo asignado.
		
		Empleado empl1 = new Empleado(6051, "Gerard", "Perujo Buxeda", "ger@canvas.com",
				'H', 1300, 300, trab1, depar1);
		
		// Sacamos la informacion completa de un empleado sin usar el metodo toString.
		
	
		System.out.println("Sacmos los datos del empleado nombre, apellidos y genero : ");
		System.out.println("NOMBRE EMPLEADO :" + empl1.getNombre());
		System.out.println("APELLIDO EMPLEADO : " + empl1.getApellidos());
		System.out.println("GENERO DEL EMPLEADO : " + empl1.getGenero());
		
		//Como no tenemos el nombre del departamento sacamos la descripcion del departamento.
		
		System.out.println("------------------------");
		System.out.println("El departamento del que pertenece el empleado : ");
		System.out.println(empl1.getDepartamento().getDescripcion());
		
		// Sacamos el nombre del trabajo del empleado
		
		System.out.println("------------------------");
		System.out.println("La descripcion del trabajo del empleado : ");
		System.out.println(empl1.getTrabajo().getDescripcion());
		
		//Sacamos la direccion del empleado.
		
		System.out.println("------------------------");
		System.out.println("La direccion del empleado : ");
		System.out.println(empl1.getDepartamento().getLocalidad().getDireccion());
		
		//Sacamos la ciudad del empleado.
		
		System.out.println("------------------------");
		System.out.println("La ciudad del que pertenece el empleado : ");
		System.out.println(empl1.getDepartamento().getLocalidad().getCiudad());
		
		//Sacamos el pais del empleado.
		
		System.out.println("------------------------");
		System.out.println("El pais del que pertenece el empleado : ");
		System.out.println(empl1.getDepartamento().getLocalidad().getPais());
		
		
		

		
		

	}

}
