package Testing;



import java.util.ArrayList;

import modelo.dao.InstitutoDaoImplList;
import modelo.javabeans.Administrativo;
import modelo.javabeans.Persona;
import modelo.javabeans.Profesor;
import modelo.javabeans.Alumno;

public class TestInstituto {

	public static void main(String[] args) {
		
		InstitutoDaoImplList instituto = new InstitutoDaoImplList();
		
		
		/*
		 * Este metodo devuelve una lista de todas las personas que hay en el instituto. 
		 * Todas estan incluidas, tanto los alumnos como los profesores y los administrativos.
		 */
		System.out.println("------------------------------");
	System.out.println("usamos el metodo buscarTodas");	
	System.out.println("------------------------------");
	for(Persona ele: instituto.buscarTodas()) {
		System.out.println(ele);
	}
	System.out.println("------------------------------");
		
	/*
	 * Se va a dar de alta a una nueva persona y a continuacion se muestra la lista completa con la nueva incorporacion.
	 */
	System.out.println("usamos el metodo altaPersona");	
	System.out.println("------------------------------");
	Persona prof2 = new Profesor("42569871", "Teresa", "c/ juan carlos nº3", "624897520", "BBDD");
	instituto.altaPersona(prof2);
	for(Persona ele: instituto.buscarTodas()) {
		System.out.println(ele);
	}
	System.out.println("------------------------------");
	
	/*
	 * Ahora se va a eliminar al prof2, que es el que se ha dado de alta en el paso anterior.
	 * Despues se vuelve a mostrar la lista completa ya sin el profesor.
	 */
	System.out.println("usamos el metodo eliminarPersona");	
	System.out.println("------------------------------");
	instituto.eliminarPersona(prof2);
	for(Persona ele: instituto.buscarTodas()) {
		System.out.println(ele);
	}
	System.out.println("------------------------------");

	
	/*
	 * En esta ocasion se pretende buscar a Diego pasando el nif al metodo. 
	 * Como Diego existe en la lista, se muestran todos sus datos y el tipo de persona que es.
	 */
	System.out.println("usamos el metodo buscarPersona para encontrar Diego:");	
	System.out.println("------------------------------");
	System.out.println(instituto.buscarPersona("05728723L"));

	
	System.out.println("------------------------------");
	
	/*
	 * En esta ocasion se va a pasar un nif que no esta en la lista para que nos devuelva null deliberadamente.
	 */
	System.out.println("usamos el metodo buscarPersona para comprobar que sale nulo");	
	System.out.println("------------------------------");
	System.out.println(instituto.buscarPersona("78236985F"));

	
	System.out.println("------------------------------");
	
	/*
	 * Aqui se van a buscar todas las personas que por su competencia son profesores 
	 * y se invoca el metodo de la clase Profesor.
	 */
	System.out.println("usamos el metodo buscarPersonaPorTipo: Profesor");	
	System.out.println("------------------------------");
	instituto.buscarPersonaPorTipo("Profesor");
	
	
System.out.println("------------------------------");
	
	/*
	 * Ahora se buscan todos los alumnos y se invoca el metodo de la clase Alumno.
	 */
	System.out.println("usamos el metodo buscarPersonaPorTipo: Alumno");	
	System.out.println("------------------------------");
	instituto.buscarPersonaPorTipo("Alumno");
	
	
System.out.println("------------------------------");
	
	/*
	 * Finalmente se buscan a todos los administrativos y se invoca a su metodo propio de la clase Administrativo. 
	 */
	System.out.println("usamos el metodo buscarPersonaPorTipo: Administrativo");
	System.out.println("------------------------------");
	instituto.buscarPersonaPorTipo("Administrativo");
}
	
}
