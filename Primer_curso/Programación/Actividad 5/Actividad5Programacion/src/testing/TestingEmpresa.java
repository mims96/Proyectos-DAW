package testing;

import modelo.dao.EmpresaImplList;
import modelo.javabeans.Departamento;
import modelo.javabeans.Empleado;
import modelo.javabeans.Empresa;
import modelo.javabeans.Localidad;
import modelo.javabeans.Trabajo;

public class TestingEmpresa {

	public static void main(String[] args) {
		/*
		 * Primero creo una variable de tipo Empresa empres.
		 * Se importa la clase Empresa
		 */
		EmpresaImplList empres = new EmpresaImplList();
		
		/*
		 * Vamos a probar todos los metodos de EmpresaImplList.
		 * Vamos a buscar todos los empleados creados. Todos los empleados son ele, y el metodo devuelve los empleados.
		 */
		System.out.println("**Buscar todos**");
		for (Empleado ele: empres.buscarTodos()) {
			System.out.println(ele);
		}
		System.out.println(" ");
		
		System.out.println("**Dar de alta**");
		/*
		 * Creamos dos empleados e intento darlos de alta. 
		 * Luego demuestro que se han incluido en el listado de plantilla.
		 */
		Empleado empl10 = new Empleado(789, "Sandro", "Montes Ordoñez", "smord@emeesen.es", 'H', 2490, 424, new Trabajo("2598", "Director auxiliar en ausencias", 2090, 3058), new Departamento(9752, "Director adjunto", new Localidad(7290, "Calle de la primavera, 4", "Palma de Mallorca", "España")));
		Empleado empl20 = new Empleado(978, "Mia", "Gonzalez Martin", "migomar@jotmeil.com", 'M', 987, 50, new Trabajo("1314", "Trabajar en lo que demanden", 900, 1100), new Departamento(2459, "Becaria", new Localidad(29357, "Calle del otoño, 2", "Teruel", "España")));
		System.out.println("Dar de alta true : " +empres.alta(empl10));
		System.out.println("Dar de alta true : " +empres.alta(empl20));
		System.out.println("La nueva lista es:");
		for (Empleado ele: empres.buscarTodos()) {
			System.out.println(ele);
		}
		System.out.println(" ");
		
		System.out.println("**Eliminamos al empleado nuevo 789**");
		System.out.println("Eliminando a empl10 true : " + empres.eliminarUno(empl10));
		System.out.println("La nueva lista es:");
		for (Empleado ele: empres.buscarTodos()) {
			System.out.println(ele);
		}
		System.out.println(" ");
		
		/*
		 * Vamos a modificar el empl20 y le cambiamos los dos primeros atributos del constructor.
		 */
		System.out.println("**Modificamos un empleado**");
		Empleado empl30 = new Empleado(973, "Miami", "Gonzalez Martin", "migomar@jotmeil.com", 'M', 987, 50, new Trabajo("1314", "Trabajar en lo que demanden", 900, 1100), new Departamento(2459, "Becaria", new Localidad(29357, "Calle del otoño, 2", "Teruel", "España")));
		empl20 = empl30;
		System.out.println("Modificamos empl20 : " + empres.modificarUno(empl20));
		System.out.println("La lista es");
		for (Empleado ele: empres.buscarTodos()) {
			System.out.println(ele);
		}
		
		
		System.out.println(" ");
		
		/*
		 * Suponemos que buscamos a una mujer, por lo que deben aparecer Concha y Mia.
		 */
		System.out.println("**Buscando por sexo**");
		char sexo = 'M';
		for (Empleado ele: empres.buscarPorSexo(sexo))
			System.out.println(ele);
		
		System.out.println(" ");
		
		/*
		 * Primero vamos a buscar un empleado que no existe, lo que devuelve null, y luego buscamos a Antonio.
		 */
		System.out.println("**Buscamos uno**");
		System.out.println(empres.buscarUno(1207));
		System.out.println(empres.buscarUno(345));
		
		System.out.println(" ");
		
		/*
		 * Se suman los salarios de los 3 trabajadores
		 */
		System.out.println("**Obteniendo la masa salarial**");
		System.out.println(empres.masaSalarial());
		
		System.out.println(" ");
		
		/*
		 * Vamos a buscar, por ejemplo, al empleado cuyo idDepar es 9874, que es Concha.
		 */
		System.out.println("**Buscando por departamento**");
		int idDepar= 9874;
		for (Empleado ele: empres.buscarPorDepartamento(idDepar))
			System.out.println(ele);
		
		System.out.println(" ");
		
		/*
		 * Aqui tambien buscamos a Concha por su idTrabajo
		 */
		System.out.println("**Buscando por trabajo**");
		String idTrabajo = "9853";
		for (Empleado ele: empres.buscarPorTrabajo(idTrabajo))
			System.out.println(ele);
		
		System.out.println(" ");
		
		/*
		 * Buscamos a los empleados en funcion de su pais, por lo que muestra todos los resultados.
		 */
		System.out.println("**Buscando por pais**");
		String pais = "España";
		for (Empleado ele: empres.buscarPorPais(pais))
			System.out.println(ele);

	}

}
