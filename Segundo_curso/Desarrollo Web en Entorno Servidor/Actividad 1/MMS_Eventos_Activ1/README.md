# AD-1. Listado de eventos con opciones de alta, cancelar, ver detalle y eliminar
Enunciado

Una empresa se dedica a montar eventos. Cada evento es de un tipo distinto. Los tipos de evento son: concierto, despedida, cumpleaños, boda…, y nos interesa un código que identifique cada evento junto con su descripción. A un evento se inscriben clientes, de los que debemos guardar el esquema SQL. Recuerda que un cliente puede apuntarse a más de un evento. 

De aquí en adelante, podremos incorporar más tablas para completar la aplicación, pero, de momento, con estas tenemos bastantes.

El modelo de datos es el siguiente: 
![image](https://github.com/user-attachments/assets/3e5e11bc-b34e-4749-8497-e784fe05befe)

Desarrollo

La idea es que construyamos una aplicación con SpringBoot y Thymeleaf sin acceso a datos, es decir con listas,  y cuya página principal tenga esta imagen (index.html). 
![image](https://github.com/user-attachments/assets/bc932323-e4c2-4651-9491-54ed1a3cad37)

Vamos a implementar el controlador EventosController y HomeController.
Las páginas HTML (con thymeleaf) necesarias para las tareas definidas a continuación.
La clase de Bean 'Evento' y 'Tipo', a partir de las tablas que tienes en este enunciado.
Ojo, un Evento tiene una variable Tipo tipo, no un int idTipo.
El interface TipoDao con dos métodos, findAll() y findById(), y la clase que implementa este interface.
El interface llamado EventoDao de la clase 'Evento' con los métodos necesarios.
Una clase EventoDaoImpl, que contiene una lista de eventos con su tipo y la implementación de los métodos del interface.
 

Del controlador llamado HomeController tratamos las siguientes opciones:
“/” ->  Sacar el listado de la imagen superior.
Del controlador llamado EventoController tratamos las siguientes opciones:
“/eventos/alta: -> Mostrar un formulario con los datos del evento, poner el estado del evento como ‘ACTIVO’ y, si quieres destacarlo, poner una ‘s’ en su columna. Volver al listado de activos.
“/eventos/editar/{id} “ -> Mostrar en un HTML con los datos del evento.
“/eventos/eliminar/{id} “ ->  Borrarlo de la clase que contiene los eventos y volver al listado de activos.
“/eventos/cancelar/{id}“ ->  Poner el estado del evento como "CANCELADO", y volver al listado de activos. Comprobar con un "syso" por consola que este evento tiene el estado a "CANCELADO". 
De momento no nos preocupamos de quién entra en la aplicación. Vamos a suponer que entra a la aplicación un administrador que tiene permisos para probar todas las tareas que se proponen.

 

Entrega

La aplicación no es necesario que las páginas estén bonitas, primero que funcione todo y luego si te da tiempo adornas los HTML.
Proyecto comentado a nivel de métodos. 
La entrega es en formato "zip" y el proyecto le llamas con las siglas de tu nombre y apellidos, ejemplo:
TED_Eventos_Activ1
porque yo me llamo tomas escudero delgado. Cuando termines el proyecto lo comprimes en formato "zip" y lo entregas.
Después de la fecha indicada, y tras la corrección, se entregará la solución propuesta por el profesor, para que se pueda cotejar.
La actividad está declarada como individual, pero si algunos de vosotros lo hacéis en equipo, me lo decís en la entrega y quienes sois, para que no haya problemas de código exactamente igual.
Cada día tarde en la entrega se descontará 2 puntos a la nota.
Una vez publicada la solución del profesor ya no se podrá entregar.
 

Criterios de calificación

15% hacer los comentarios de cada método.

20% calidad de los elementos y componentes del programa.

15% que al montarla el profesor no tenga problemas en su equipo.

50% que la aplicación funcione bien.

