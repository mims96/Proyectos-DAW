Algoritmo hasta_cero
	Definir numero, cuantos, acumulador, par, impar, acumulador_par, acumulador_impar Como Entero;
	numero=0;
	cuantos=0;
	acumulador=0;
	par=0;
	impar=0;
	acumulador_par=0;
	acumulador_impar=0;
	Escribir "Introduzca numeros sin decimales";
	leer numero;
	
	Mientras numero<>0 Hacer
		cuantos=cuantos + 1;
		acumulador=acumulador + numero;
		Si numero%2=0 Entonces
			Escribir "El numero es par";
			par=par + 1;
			acumulador_par=acumulador_par + numero;
		SiNo
			Escribir "El numero es impar";
			impar = impar + 1;
			acumulador_impar=acumulador_impar + numero;
		Fin Si
		leer numero;
	Fin Mientras
	
	Si cuantos=0 Entonces
		Escribir "No se ha podido procesar ninguno";
	SiNo
		Escribir "El numero de pares es : ", par;
		Escribir "El numero de impares es : ", impar;
		Escribir "La suma de los numeros de pares es : ", acumulador_par;
		Escribir "La suma de los numeros de impares es : ", acumulador_impar;
	Fin Si
	
FinAlgoritmo
