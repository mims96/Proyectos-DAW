Funcion literal <- genero (sexo)
	Definir literal Como Caracter;
	Segun sexo Hacer
		"H", "h":
			Escribir "Hombre";
		"M", "m":
			Escribir "Mujer";
		De Otro Modo:
			Escribir "Sexo erroneo";
	Fin Segun
Fin Funcion

Funcion literal <- tipoSalario (salario)
	Definir literal Como Caracter;
	Si salario<25000 Entonces
		literal = "Salario bajo";
	SiNo
		Si salario>=25000 Y salario<=40000 Entonces
			literal = "Salario medio";
		SiNo
			Si salario>45000 Entonces
				literal = "Salario alto";
			Fin Si
		Fin Si
	Fin Si
Fin Funcion

Algoritmo resultado_consola
	Definir nombre, sexo Como Caracter;
	Definir salario Como Real;
	Escribir "Introduzca primero su nombre, despues su sexo y finalmente su salario anual";
	Leer nombre;
	Leer sexo;
	Leer salario;
	Escribir "A. : ", nombre;
	Escribir "B. : ", genero(sexo);
	Escribir "C. : ", tipoSalario(salario);
FinAlgoritmo