Funcion opcion <- menu (  )
	Definir opcion Como Entero;
	opcion=0;
	Escribir "1.- Nombre completo";
	Escribir "2.- Salario mensual (12 pagas)";
	Escribir "3.- Nombre en mayusculas";
	Escribir "4.- Cuantas letras tiene mi nombre";
	Escribir "5.- Salir";
	Escribir "Teclea una opcion y pulsa intro";
	Leer opcion;
Fin Funcion

Algoritmo menu_opciones
	Definir nombre, apellido Como Caracter;
	Definir opcion, salario Como Entero;
	opcion=0;
	opcion=menu();
	Mientras opcion<>5 Hacer
		Escribir "Escriba su nombre, su apellido y/o su salario, segun proceda";
		Segun opcion Hacer
			1:
				Leer nombre;
				Leer apellido;
				Escribir "Su nombre completo es : ", nombre +" " apellido;
			2:
				Leer salario;
				Escribir "Su salario en 12 pagas es : ", salario*12 " " "unidades monetarias";
			3:
				Leer nombre;
				Escribir "Su nombre en mayusculas es : ", Mayusculas(nombre);
			4:
				Leer nombre;
				Escribir "Su nombre tiene : ", Longitud(nombre) " " "letras";
			De Otro Modo:
				Escribir "Opcion erronea. Teclee del 1 al 5";
		Fin Segun
		opcion=menu();
	Fin Mientras
	Escribir "===FIN DE PROGRAMA===";
FinAlgoritmo
