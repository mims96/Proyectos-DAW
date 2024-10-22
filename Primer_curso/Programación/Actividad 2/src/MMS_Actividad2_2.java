import java.util.Scanner;

public class MMS_Actividad2_2 {
	
	public static void main(String[] args) {
		/*
		 * Primero se necesita un numero aleatorio N entre 1 y 40
		 * teniendo en cuenta que N no se muestra por consola
		 * Inicializo las variables
		 * Creo una variable de tipo double para guardar lo que genera Math.random
		 * Luego con un casting lo convierto a entero
		 */
		int N=0, numero=0, contador=0;
		double d=0;
		Scanner leer = new Scanner (System.in);
		d= Math.random()*40+1;
		N=(int)d;
		/*
		 * Pido por consola que introduzcan numeros hasta que acierten
		 */
		System.out.println("Teclea un numero del 1 al 40 hasta acertar");
		numero=leer.nextInt();
		/*
		 * Posteriormente hago un bucle while con la condicion
		 * mientras que no tecleen el numero N 
		 * ya que cuando aciertan N el juego termina
		 */
		
		while (numero != N){
			contador++;
			/*
			 * Ademas le indicamos al jugador si el numero que ha introducido
		     * es mayor o si es menor que N
			 */
			if (numero < N)
			   System.out.println("menor");
			else
				if (numero > N)
				System.out.println("mayor");
			System.out.println("Teclea un numero del 1 al 40 hasta acertar");
			numero=leer.nextInt();
		}
		/*
		 * Finalmente cuando acierta se incluye la estadistica de intentos
		 */
		System.out.println("Intentos realizados : " + contador);
		
		System.out.println("FIN DEL PROGRAMA");

		}

	}
