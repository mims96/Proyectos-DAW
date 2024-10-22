import java.util.Scanner;

public class MMSActividad3 {
	/*
	 * Primero vamos a definir algunas variables que intervienen en el menu.
	 * Habra varios tipos, pues las opciones del menu piden variables distintas.
	 * Con la clase Scanner se lee lo que introducen por teclado.
	 */
	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		int opcion = 0, num1 = 0;
		double num2=0, num3=0;
		String palabra="";
		/*
		 * Invocamos al metodo que pinta el menu, que se encuentra al final del codigo.
		 * El menu debe aparecer como minimo una vez para poder seleccionar una opcion.
		 */
		opcion = pintarMenu();
		/*
		 * Mientras que no tecleen la opcion 4 de salir, 
		 * el menu muestra continuamente lo que hay que hacer en funcion de la opcion escogida.
		 * Cada case invoca a un metodo diferente creado mas abajo.
		 * Igualmente el mensaje de instrucciones que se muestra a continuacion del numero tecleado
		 * es diferente dependiendo del case.
		 */
		while (opcion != 4) {
			switch(opcion) {
			case 1:
				System.out.println("Introduce un numero decimal");
				num1= leer.nextInt();
				conversor(num1);
				break;
			case 2:
				System.out.println("Introduce el primer numero");
				num2=leer.nextDouble();
				System.out.println("Introduce el segundo numero");
				num3=leer.nextDouble();
				calcular(num2,num3);
				break;
			case 3:
				System.out.println("Introduce una palabra");
				palabra=leer.next();
				analizar(palabra);
				break;
			default:
				System.out.println("opcion erronea");
				break;
		}
			/*
			 * Fuera del switch se incluye:
			 */
			opcion = pintarMenu();
		}
		/*
		 * Cuando pulsan 4 se sale del bucle y el programa se acaba.
		 */
		System.out.println("Adios");
	}
	/*
	 * A continuacion se realizan los metodos que han sido invocados en el switch 
	 * dependiendo de la opcion escogida.
	 * Se definen los nombres de los metodos.
	 * 
	 * 
	 * Para la opcion del conversor se debe hallar el binario de un numero entero.
	 * Como el numero tecleado va alterando su valor, se crea una variable nueva
	 * que guarde su valor original, siendo llamada a la hora de mostrar por consola.
	 * Mientras que el cociente del numero tecleado dividido entre 2 sea distinto de 1
	 * se van acumulando los restos de ceros y unos convertidos en cadena,
	 * y se continua dividiendo los cocientes resultantes de la continua ejecucion de bucle. 
	 * Cuando el cociente es 1 se sale del bucle while 
	 * y se concatenan primero los restos y luego el cociente.
	 * Mediante valueOf se pasa de numeros enteros a cadena de carateres
	 * Para darle la vuelta se emplea un metodo .lenght()-1 dentro de un bucle for
	 * en el que se decrementa la variable, es decir, 
	 * se concatenan primero el cociente 1 y despues los restos en orden inverso.
	 * El metodo charAt analiza cada caracter de la cadena al reves.
	 */
	public static  void conversor(int num1) {
		String cadena ="", binario="";
		int numerito=num1;
		while (num1/2 !=1){
			cadena+=String.valueOf(num1%2);
			num1=num1/2;	
		} 
		cadena+=String.valueOf(num1%2);
		cadena+=String.valueOf(num1/2);
		
		for (int i=cadena.length()-1; i>=0; i--)
			binario += cadena.charAt(i);
		System.out.println("El numero " + numerito + " en binario es " + binario);
	}
	
	
	
	/*
	 * Para realizar la opcion de la calculadora, se necesitan 
	 * variables de tipo double para incluir decimales.
	 * En este caso, lo que diferencia el resultado, fundamentalmente, es el operador,
	 * por lo que dependiendo del operador pulsado se obtiene un resultado u otro.
	 * Se pide que se introduzca uno de ellos y se lee.
	 * La manera de exponer las posibilidades variadas es con un switch.
	 */
	public static void  calcular(double num2, double num3) {
		Scanner simbolo = new Scanner(System.in);
		double resultado=0;
		String operador="";
		System.out.println("Introduce un operador (+,-,*,/,%)");
		operador=simbolo.nextLine();
		switch (operador){
			case "+":
				resultado=num2+num3;
			    System.out.println(num2 + " + " + num3 + " = " + resultado);
			    break;
			case "-":
				resultado=num2-num3;
				System.out.println(num2 + " - " + num3 + " = " + resultado);
				break;
			case "*":
				resultado=num2*num3;
				System.out.println(num2 + " * " + num3 + " = " + resultado);
				break;
			case "/":
				resultado=num2/num3;
				System.out.println(num2 + " / " + num3 + " = " + resultado);
				break;
			case "%":
				resultado=num2%num3;
				System.out.println(num2 + " % " + num3 + " = " + resultado);
				break;
			default:
				System.out.println("Operador incorrecto");
				break;	
		}    
	}
	
	/*
	 * Finalmente, para la opcion de analizar la frase, 
	 * primero se definen los caracteres que se consideran vocales y consonantes.
	 * Posteriormente, se inicializan las variables que intervendran en el proceso.
	 * Para los supuestos CONSONANTES y VOCALES se necesita hacer un proceso extra.
	 * En un bucle for, que incluye tanto el caso de las vocales como las consonantes,
	 * se recorre la longitud de la palabra de manera incremental.
	 * Tanto para vocales como para consonantes, si el charAt encuentra un caracter de ellas 
	 * en cada bucle for correspondiente las acumula y las concatena,
	 * de manera que al llamar  a vocal y a consonante aparecen sus caracteres ya concatenados en orden.
	 * Para PALABRA y LONGITUD se invoca la variable palabra en el primer caso,
	 * y se emplea el metodo .lenght en el segundo para mostrar la longitud de la palabra tecleada.	
	 */
	public static void analizar(String palabra) {
		char [] vocales = {'a', 'e', 'i', 'o', 'u'};
		char [] consonantes = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'ñ', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};
		String vocal="";
		String consonante="";
		int acumv=0, acumc=0;
		for (int i=0; i<palabra.length(); i++) {
			for(int v=0; v<vocales.length; v++) {
				if (palabra.charAt(i)== vocales[v]) {
					acumv++;
					vocal+=palabra.charAt(i);
				}
			}
			for (int c=0; c<consonantes.length; c++) {
				if (palabra.charAt(i)==consonantes[c]) {
					acumc++;
					consonante+=palabra.charAt(i);
				}
			}
		}	
		System.out.println("PALABRA : " + palabra);
		System.out.println("CONSONANTES : " + consonante);
		System.out.println("VOCALES : " + vocal);
		System.out.println("LONGITUD : " + palabra.length());
	}
	
	/*
	 * Aqui finalizan los metodos para las opciones 1, 2 y 3.
	 * 
	 * Ahora se crea el metodo que pinta el menu y sus opciones
	 * que apareceran por consola.
	 */
	public static int pintarMenu() {
		/*
		 * Para leer la opcion:
		 */
		Scanner leer = new Scanner(System.in);
		int opcion = 0;
		System.out.println("1. Conversor decimal-binario");
		System.out.println("2. Calculadora");
		System.out.println("3. Analizador de clase");
		System.out.println("4. Salir");
		System.out.println("Introduce una opcion:");
		opcion = leer.nextInt();
		/*
		 * Cuando tecleen un numero que no esta contemplado en el menu
		 * hay que advertir que las opciones van del 1 al 4.
		 */
		while(opcion < 1 || opcion > 4) {
			System.out.println("Opciones del 1 al 4");
			opcion = leer.nextInt();	
		}
		/*
		 * Devolvemos la opcion para continuar el menu hasta que finalice el programa.
		 * Se pone fuera del bucle y antes de la llave que hace concluir el metodo.
		 */
		return opcion;
	}
}
