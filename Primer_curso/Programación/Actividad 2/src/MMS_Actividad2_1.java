import java.util.Scanner;

public class MMS_Actividad2_1 {
	
	public static void main(String[] args) {
	    /*
	     * Vamos a pedir por consola tres numeros para los lados del triangulo
	     * Esos numeros se leen 
	     */
		Scanner leer = new Scanner (System.in);
		int lado1=0,  lado2=0,  lado3=0;
		System.out.println("Escribe tres numeros enteros");
		lado1 = leer.nextInt();	
		lado2 = leer.nextInt();
		lado3 = leer.nextInt();
		/*
		 * Si la suma de dos lados es mayor que 
	     * la medida del lado restante entonces el triangulo es correcto
		 */
		if ((lado1 + lado2) > lado3 || (lado1 + lado3) > lado2 || (lado2 + lado3) > lado1){
			System.out.println("El triangulo es valido");
			/*
			 * Ademas vamos a distinguir si es equilatero, isosceles o escaleno
			 */
		    if ((lado1 == lado2) && (lado2==lado3) && (lado1==lado3)) 
		    	System.out.println("Es un triangulo equilatero")
		    ;
		    else
		    	if (lado1 == lado2 || lado2 == lado3 || lado1 == lado3)
		    		System.out.println("El triangulo es isosceles");
		    	else 
		    		if ((lado1 != lado2) && (lado2 != lado3) && (lado1!=lado3))
		    			System.out.println("El triangulo es escaleno");  
		} 
		/*
		 * Por el contrario si la suma de esos lados es inferior al otro
	     * el triangulo es incorrecto
		 */
		else 
			System.out.println("El triango no es valido");
		
		System.out.println("FIN DEL PROGRAMA");


		}

	}
