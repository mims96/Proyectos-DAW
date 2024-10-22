package testing;

import javabeans.Empleado;

public class TestEmpleados {
	/*
	 * Se crea la clase principal Empleado con main.
	 * Al tener que crear 2 objetos vamos a distinguir entre empleado1 y empleado2.
	 */
	public static void main(String[] args) {
		
		/*
		 * En este caso se asignan valores a los atributos.
		 */
		Empleado empleado1 = new Empleado (654, "Chloe", "Garcia Gonzalez", "chlogargon@gmail.com", 50_000.99, 200.99, 'M', 074);
		/*
		 * Se escriben por consola los resultados de aplicar los valores anteriores a los metodos propios creados en Empleado.java.
		 */
		System.out.println(empleado1.salarioBruto());
		System.out.println(empleado1.salarioMensual(12));
		System.out.println(empleado1.literalSexo());
		System.out.println(empleado1.obtenerEmail());
		System.out.println(empleado1.nombreCompleto());
		
		/*
		 * Ahora se crea empleado2. En un principio se crea vacio, de tal manera que se asignarian los valores por defecto.
		 */
		Empleado empleado2 = new Empleado ();
		/*
		 * Mediante el set se rellenan y sustituyen los datos que previamente aparecian por defecto.
		 */
		empleado2.setIdEmpleado(123);
		empleado2.setNombre("Maribel");
		empleado2.setApellidos("Martin Simal");
		empleado2.setEmail("marsi@gmail.com");
		empleado2.setSalario(30_000.99);
		empleado2.setComplemento(500.99);
		empleado2.setSexo('M');
		empleado2.setIdDepartamento(987);
		/*
		 * Se invoca a la variable empleado2 y se muestra por consola su nuevo contenido.
		 */
		System.out.println(empleado2);
	}
}
