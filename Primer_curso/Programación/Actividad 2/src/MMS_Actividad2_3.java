import java.util.Scanner;

public class MMS_Actividad2_3 {
	public static void main(String[] args) {
		/*
		 * En estas primeras lineas definimos las variables que se usaran 
		 * a lo largo del ejercicio
		 * Distinguimos un Scanner para caracteres y cadenas y otro para variables numericas
		 */
		Scanner leernombre =new Scanner(System.in);
		Scanner leernumero =new Scanner(System.in);
		char genero = 'h';
		char sGenero='h';
		String nombre="";
		int contadorNombre=0;
		double salario=0;
		double sSalario=0;
		double total=0;
		
		/*
		 * Se ha realizado un do while para que se ejecute al menos una vez el codigo
		 * En el momento que tecleen fin independientemente de los caracteres el bucle acaba
		 */
		
			do {
				
				System.out.println("Introduca su nombre");
				nombre=leernombre.nextLine();
				
				/*
				 * Se necesita un IgnoreCase para aceptar cualquier variante de fin
				 * Se cuentan las veces que se ha introducido un nombre distinto de fin
				 */
				if(!(nombre.equalsIgnoreCase("fin"))) {	
				contadorNombre++;
				
				/*
				 * Para coger el primer caracter se necesita el metodo charAt
				 */
				System.out.println("Introduzca la primera letra de su genero");
				genero= leernombre.nextLine().charAt(0);
				sGenero=seleccionGenero(genero);
				
				/*
				 * Leemos el salario que introducen y se lo pasamos a la funcion
				 */
				System.out.println("Introduzca su salario");
				salario=leernumero.nextDouble();
				sSalario=seleccionSalario(salario);
				total = total + sSalario;
				}
			}
				
			while(!(nombre.equalsIgnoreCase ("fin")));
			
			/*
			 * Una vez que han tecleado alguna variante de fin exponemos las estadisticas
			 */
				
			System.out.println("El numero de veces que ha introducido su nombre es : " + contadorNombre);
			System.out.println("La suma de los salarios introducidos es : " + total + " Euros");
			System.out.println("La media de los salarios es : "+ (total/contadorNombre) + " Euros");
			System.out.println("FIN DEL PROGRAMA");
	}
	
	/*
	 * A continuacion se van a crear las funciones invocadas anteriormente
	 * Se realiza fuera del main porque no necesariamente son usadas siempre
	 * 
	 * Se va a crear la funcion correspondiente a genero que ha sido invocada en el main
	 * Para ello se realiza un switch en el que dependiendo del caracter tecleado la funcion devuelve un valor u otro
	 */
		
	public static char seleccionGenero(char sexo) {
		switch (sexo) {
		case 'h', 'H':
		    System.out.println("Hombre");
		    break;
		case 'm', 'M':
			System.out.println("Mujer");
			break;
		default:
			System.out.println("Sexo erroneo");
			break;
		}return sexo;
	}
	
	/*
	 * Para realizar la funcion del salario usamos una estructura if else
	 * dependiendo de los tramos de salario que introduzcan
	 */
	public static double seleccionSalario( double salario) {
		
		if(salario<25000) {
			System.out.println("Salario Bajo");
		}else if(salario<40000){
		System.out.println("Salario Medio");
		}else{
			System.out.println("Salario Alto");
		}return salario;
	}
	
}

