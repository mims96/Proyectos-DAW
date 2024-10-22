# AD-7. Tarea en equipo. Acceso a Bases de Datos
Enunciado

Realizar una Aplicación de gestión de proyectos, de acuerdo con la siguiente base de Datos:
![image](https://github.com/user-attachments/assets/ff4932cf-237a-4fde-86d1-b1c6138a96f1)

La estructura de paquetes del proyecto es:

javabeans
daos
conexion
testing
principales
 

CLIENTES
Consideraciones:

Hacer una clase con main estático GestionClientes con un  menú con las siguientes opciones:

Alta del Cliente
Buscar un Cliente
Mostrar Todos.
Eliminar un cliente
Salir
Definir el javabean de Cliente, el interface para CRUD de cliente incluido findAll(), y el Interface de ClienteDaoImpl, para implementar los métodos del Interface, accediendo a bases de datos.

 

RECURSOS HUMANOS
Crear los javabean Departamento , Perfil y Empleado, los interface y las clases que implementan el interface.

CONSIDERACIONES:

La clase Empleado, tendrá los siguientes métodos propios:
salarioBruto() : double
salarioMensual(int meses) : double
literalSexo() : String. H -> Hombre, M -> mujer
obtenerEmail() : String. Primera letra del nombre + primer apellido, en minúsculas
nombreCompleto(): String. Nombre + “ “ + apellidos
Métodos de EmpleadoDao, además de los CRUD, y findAll():
empleadosByDepartamento(int idDepar): List<Empleado>
empleadosBySexo(char sexo): List<Empleado>
empleadosByApellido(String subcadena): List<Empleado>
salarioTotal(): double
salarioTotal(int idDepar): double. Salario Total para un
 

PROYECTOS – Empleados en proyecto
Métodos propios de Proyecto:

margenPrevisto():double. Importe de venta – coste previsto
margenReal(): double Importe de venta – gastos reales
diferenciaGastos(): double. Gasto real – gasto previsto
diferenciaFinPrevistoReal(): int . Días entre fin previsto y fin real
 

Métodos ProyectoDao, además de CRUD y findAll(), implementados con acceso a Base de datos:

proyectosByEstado(String estado): List<Proyecto>
proyectosByCliente(String cif) : List<Proyecto>
proyectosByJefeProyectoAndByEstado(int jefeProyecto, String estado): List<Proyecto>
importesVentaProyectosTerminados(): double
margenBrutoProyectosTerminados():double Diferencia suma Importes venta y gastos reales.
diasATerminoProyectoActivo(String codigoProyecto): int. Cuantos días quedan para terminar el proyecto (diferencia entre fecha_fin_previsto y la fecha de hoy
 

Métodos EmpleadosEnProyecto:

costeHorasAsignadas(): double . Horas * precio/hora
 

Métodos EmpleadosEnProyectoDao, si quieres  CRUD y findAll() y obligatorio, implementado con acceso a bases de datos:

empleadosByProyecto(String codigoProyecto): List<EmpleadosEnProyecto>
asignarEmpleadosAProyecto(List<EmpleadosEnProyecto> empleados): int
horasAsignadasAProyecto(String codigoProyecto): int. Suma de las horas de los empleados asignados al proyecto.
costeActualDeProyecto(String codigoProyecto): double . horas*coste-hora de cada empleado asignado al proyecto.
margenActualProyecto(String codigoProyecto): double. Importe_venta del proyecto – costeActual del Proyecto
Hacer clases de prueba por cada Javabean-Interface-ImplMy8, para probar la funcionalidad.

Entregar

El proyecto se llamará GRUPOXX_actividad7 (siendo XX el número de grupo que tienes). Y se entregará un zip del proyecto.

El código deberá ir comentado, cada clase, cada método de lo que se vaya haciendo.

La corrección será en la siguiente proporción:

40% : claridad del código y precisión de las clases realizadas.
30% : documentación del código.
30% : resultado correcto de los test de las clases propuestas.

https://github.com/Gerard-Perujo/Grupo13_Actividad7
