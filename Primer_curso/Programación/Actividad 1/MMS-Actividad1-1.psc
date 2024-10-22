Algoritmo numeros_ordenados
	Definir numero1, numero2, numero3 Como Entero;
	numero1=0;
	numero2=0;
	numero3=0;
	Escribir "Escriba tres numeros enteros";
	leer numero1, numero2, numero3;
	
	Si numero1>numero2 Y numero2>numero3 Entonces
		Escribir "Los numeros ordenados son : ", numero1 " " "luego : ", numero2 " " " y finalmente : ", numero3;
	SiNo
		Si numero1>numero3 Y numero3>numero2 Entonces
			Escribir "Los numeros ordenados son : ", numero1 " " "luego : ", numero3 " " "y finalmente : ", numero2;
		Fin Si
	Fin Si
	
	Si numero2>numero1 Y numero1>numero3 Entonces
		Escribir "Los numeros ordenados son : ", numero2 " " "luego : ", numero1 " " "y finalmente : ", numero3;
	SiNo
		Si numero2>numero3 Y numero3>numero1 Entonces
			Escribir "Los numeros ordenados son : ", numero2 " " "luego : ", numero3 " " "y finalmente : ", numero1;
		Fin Si
	Fin Si
	
	Si numero3>numero1 Y numero1>numero2 Entonces
		Escribir "Los numeros ordenados son : ", numero3 " " "luego : ", numero1 " " "y finalmente : ", numero2;
	SiNo
		Si numero3>numero2 Y numero2>numero1 Entonces
			Escribir "Los numeros ordenados son : ", numero3 " " "luego : ", numero2 " " "y finalmente : ", numero1;
		Fin Si
	Fin Si

FinAlgoritmo
