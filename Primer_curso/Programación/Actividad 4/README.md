# AD-4. Clase Empleado
Enunciado

Crear una clase Empleado con los siguientes atributos privados:

idEmpleado: int
nombre, apellidos, email : String
salario: double
complemento: double
sexo: char
idDepartamento: int
 

Crear un constructor por defecto, y otro con todos los parámetros.

Crear los getter and setter para cada atributo privado.

Redefinir el método toString()

 La clase Empleado, tendrá los siguientes métodos propios:

salarioBruto() : double. Devolver la suma del salario y el complemento
salarioMensual(int meses) : double
literalSexo() : String. H -> “Hombre”, M -> “Mujer”
obtenerEmail() : String. Devolver un String con la primera letra del nombre + primer apellido, en minúsculas.
nombreCompleto(): String. Devolver la concatenación del nombre + “ “ + apellidos
Crear una clase Principal con el método main y:

Crear un objeto de la clase Empleado llamando al constructor con todos los parámetros y asignándoles valor a cada atributo.
Escribir por consola(syso), los datos de esta empleado llamando a los métodos de la clase que hemos propuesto; un syso por cada método de la clase.
Crear un objeto vacío, y rellenar cada dato usando los métodos set. Invocar en el syso a la variable de este empleado.
Entrega:
El proyecto le nombras XXX-Actividad4, siendo XXX las siglas de tu nombre y dos apellidos.
Generas un fichero comprimido con extensión “.zip” o “.rar”, con el mismo nombre que el proyecto y lo entregas.
