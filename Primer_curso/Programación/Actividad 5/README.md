# AD-5. Tarea en equipo. Interrelación entre clases
**Actividad en equipo realizada entre María Isabel Martín, Gerard Perujo y Noelia Villahermosa**

![image](https://github.com/user-attachments/assets/302353b4-1139-441b-9862-d4a23167fdf9)

Enunciado

Tomamos como base la actividad 4 de la Unidad Formativa 7. Pero hay que tener en cuenta que los atributos han cambiado un poco por la Asociación de Empleado con la clase Trabajo y con la clase Departamento, como ves en la figura del esquema de clases de la Actividad.

Los métodos de Empleado son los mismos que los de las actividades por lo que los puedes copiar.

La clase Empleado, tendrá los siguientes métodos propios:
salarioBruto() : double. Devolver la suma del salario y el complemento
salarioMensual(int meses) : double
literalSexo() : String. H -> “Hombre”, M -> “Mujer”
obtenerEmail() : String. Devolver un String con la primera letra del nombre + primer apellido, en minúsculas.
nombreCompleto(): String. Devolver la concatenación del nombre + “ “ + apellidos
Hay que crear de cada clase Localidad, Departamento y Empleado:
Los datos privados indicados en el esquema.
Un constructor sin parámetros y un constructor con todo.
Los getter and setter de cada atributo privado.
Redefinir toString en cada clase.
Redefinir equals y hashcode de cada clase:
Dos empleados son iguales si su idEmpleado es el mismo.
Dos departamentos son iguales si su idDepar es el mismo.
Dos localidades son iguales si su idLocalidad es la misma.
Antes de crear el Interface y la clase Empresa debemos probar que las clases creadas están operativas.

Para ello, crear una clase TestingEmpleado que muestre al menos:
Crear al menos, un objeto Localización, otro de departamento con esa Localización, un Trabajo, y un Empleado con su departamento y su Trabajo.
La información completa de un empleado SIN usar toString:
Nombre, apellidos, género, nombre del departamento, nombre de su trabajo, dirección , ciudad y país.
Extraer del empleado su trabajo y su departamento en variables de su tipo. Y pintarlas con syso.
Crear el Interface IntGestionEmpresa.
Crear la Clase Empresa, con los datos privados del diagrama, y en esta clase definir:
Un constructor con un parámetro tipo String con nombreEmpresa, y en él hacer el new ArrayList.
Hacer geter an settr SOLO de nombre.
Implementar los métodos del interface e implementar el contenido de cada uno de ellos.
Crear un método privado:
cargarDatos(): void. En donde creamos Empleados para probar, de distintos trabajos, departamentos con sus localidades.
Crear una clase Principal con main static, con una prueba en secuencia que muestre cada información que sale de la prueba de cada método de la gestión de la Empresa. Separar cada prueba con un syso que indique claramente qué se va a probar, y el resultado.
 

Entregar

El proyecto se llamará GRUPOXX_actividad5 (siendo XX el número de grupo que tienes). Y se entregará un zip del proyecto.

El código deberá ir comentado, cada clase, cada método de lo que se vaya haciendo.

La corrección será en la siguiente proporción:

40% : claridad del código y precisión de las clases realizadas.
30% : documentación del código.
30% : resultado correcto de los test de las clases propuestas.


