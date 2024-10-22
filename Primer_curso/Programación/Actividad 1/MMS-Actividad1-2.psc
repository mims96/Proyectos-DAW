Algoritmo calificaciones
	Definir nota Como Entero;
	nota=0;
	Escribir "Introduzca su calificacion redondeada del 0 al 10";
	leer nota;
	Segun nota Hacer
		0, 1, 2, 3, 4:
			Escribir "Insuficiente";
		5:
			Escribir "Suficiente";
		6:
			Escribir "Bien";
		7, 8:
			Escribir "Notable";
		9, 10:
			Escribir "Sobresaliente";
		De Otro Modo:
			Escribir "Calificacion incorrecta. Por favor, introduzca una nota del 0 al 10 sin decimales";
	Fin Segun
	
FinAlgoritmo
