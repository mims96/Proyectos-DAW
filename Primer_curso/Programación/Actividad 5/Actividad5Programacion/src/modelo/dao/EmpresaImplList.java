package modelo.dao;

import java.util.ArrayList;

import modelo.javabeans.Departamento;
import modelo.javabeans.Empleado;
import modelo.javabeans.Localidad;
import modelo.javabeans.Trabajo;

/*
 * Hay que implementar los metodos del interface, por lo que se añade implements y el nombre del interface.
 * Se importa el interface y ahora sobre esta clase EmpresaImplList se pulsa en 'add unimplemented methods'.
 */
public class EmpresaImplList implements IntGestionEmpresa {
	/*
	 * Creo la lista, a la que se llama plantilla en esta actividad
	 */
	private ArrayList<Empleado> plantilla;
	
	/*
	 * Arrancamos la plantilla aqui para que este vacia. Se crea el constructor.
	 */
	public EmpresaImplList() {
		plantilla = new ArrayList<>();
	
	/*
	 * Creamos el metodo privado cargarDatos para insertar filas nuevas
	 */
	
	cargarDatos();
}
	private void cargarDatos() {
	plantilla.add(new Empleado(023, "Concha", "Fernandes Garcia", "confergar@jotmeil.com", 'M', 1345, 94, new Trabajo("9853", "Creacion de campañas de publicidad", 1298, 3874), new Departamento(9874, "Publicidad", new Localidad(235987, "Calle del invierno, 1", "Burgos", "España"))));
	plantilla.add(new Empleado(345, "Antonio", "Gomez Sanchez", "angosan@jotmeil.com", 'H', 1468, 245, new Trabajo("4193", "Solucion de problemas informaticos", 1389, 10849), new Departamento(2832, "Informatica", new Localidad(487103, "Calle del verano, 3", "Tenerife", "España"))));
}
	
	/*
	 * Se han añadido los metodos que no estaban implementados y debemos modificarlos.
	 * Para el metodo alta, si la plantilla ya contiene al empleado no lo añade y devuelve false.
	 * En cambio, si el empleado no forma parte de la plantilla se añade.
	 */
	@Override
	public boolean alta(Empleado empleado) {
		if (plantilla.contains(empleado))
			return false;
		else
			return plantilla.add(empleado);
	}
	
	/*
	 * Se elimina el empleado escogido con el metodo remove y devuelve el empleado por si lo necesitaramos.
	 */
	@Override
	public boolean eliminarUno(Empleado empleado) {
		return plantilla.remove(empleado);
	}
	
	/*
	 * Modificar es cambiar un empleado por otro. 
	 * Si el empleado sigue igual no se ha modificado, por lo que devuelve false.
	 */
	@Override
	public boolean modificarUno(Empleado empleado) {
		if (plantilla.contains(empleado))
			return false;
		else
			return true;
			}
	
	/*
	 * No se puede devolver la plantilla porque saldrian todos los empleados. Hay que crear un ArrayList auxiliar vacio.
	 * Hay que ir preguntando uno a uno e imprimir los que contengan cierto sexo, por lo que se realiza un for.
	 */
	@Override
	public ArrayList<Empleado> buscarPorSexo(char sexo) {
		ArrayList<Empleado> aux = new ArrayList<>();
		for (Empleado empleado: plantilla) {
			if (empleado.getGenero()==sexo)
				aux.add(empleado);
		}
		return aux;
	}
	
	/*
	 * Creo un objeto con lo minimo que necesita, que es el idEmpleado.
	 * Creo un Empleado vacio al que incorporo el campo clave y se busca la posicion con indexOf, buscando un objeto con ese codigo.
	 */
	@Override
	public Empleado buscarUno(int idEmpleado) {
		Empleado empl = new Empleado();
		empl.setIdEmpleado(idEmpleado);
		int posicion = plantilla.indexOf(empl);
		if (posicion == -1)
			return null;
		return plantilla.get(posicion);
	}
	
	/*
	 * Devuelve el listado de toda la plantilla
	 */
	@Override
	public ArrayList<Empleado> buscarTodos() {
		return plantilla;
	}
	
	/*
	 * Para hallar la masa salarial total hay que sumar y acumular los salarios, por lo que se crea una variable revenues
	 * que acumule los salarios de la plantilla.
	 */
	@Override
	public double masaSalarial() {
		double revenues=0;
		for (Empleado empleado: plantilla) {
			revenues+=empleado.getSalario();
		}
		return revenues;
	}
	
	/*
	 * Los siguientes 3 metodos son similares a buscarPorSexo, por lo que hay que crear un ArrayList auxiliar vacio.
	 * Se realiza un for para imprimir todos los que contengan un determinado idDepar, idTrabajo y pais, respectivamente.
	 * En el caso de buscarPorDepartamento, al ser un int se compara con ==.
	 */
	@Override
	public ArrayList<Empleado> buscarPorDepartamento(int idDepar) {
		ArrayList<Empleado> aux = new ArrayList<>();
		for (Empleado empleado: plantilla) {
			if (empleado.getDepartamento().getIdDepar()== idDepar)
				aux.add(empleado);
		}
		return aux;
	}
	
	/*
	 * Para buscarPorTrabajo, al ser un String pero en el que se incluyen numeros, se compara solo con equals.
	 */
	@Override
	public ArrayList<Empleado> buscarPorTrabajo(String idTrabajo) {
		ArrayList<Empleado> aux = new ArrayList<>();
		for (Empleado empleado: plantilla) {
			if (empleado.getTrabajo().getIdTrabajo().equals(idTrabajo))
				aux.add(empleado);
		}
		return aux;
	}
	
	/*
	 * Finalmente, en buscarPorPais, al ser un String en el que se añaden palabras, 
	 * lo mas conveniente es comparar mediante equalsIgnoreCase para aceptar tanto mayusculas como minusculas.
	 */
	@Override
	public ArrayList<Empleado> buscarPorPais(String pais) {
		ArrayList<Empleado> aux = new ArrayList<>();
		for (Empleado empleado: plantilla) {
			if (empleado.getDepartamento().getLocalidad().getPais().equalsIgnoreCase(pais))
				aux.add(empleado);
		}
		return aux;
	}

}
