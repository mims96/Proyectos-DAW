/*Para cargar las funciones se añade el siguiente escuchador, es decir, cuando cargue la página se carga también lo que hay
dentro de la función inicio.*/

window.addEventListener("load",inicio);

    //Dentro de la función inicio se crea todo el DOM del ejercicio:
    function inicio() {
        //Se crea la primera estructura básica del DOM
        let divi= document.createElement("div");
        let formulario =document.createElement("form");
        let campo1=document.createElement("fieldset");
        let leyenda=document.createElement("legend");
        //Se añade contenido a leyenda
        let contenidoLeyenda=document.createTextNode("Por favor rellene los siguientes datos personales: ")
        //Se añade el contenido de la leyenda a la variable leyenda
        leyenda.appendChild(contenidoLeyenda);

    //--------------------------------------------DNI-------------------------------------------------------
        //Se crea la etiqueta/label del dni:
        let etiquetaDni=document.createElement("label")
        //Se crea el texto que precede a la caja de texto del dni
        let cajaDni=document.createTextNode("DNI: ");
        //A la variable etiqueta del dni se le añade este texto
        etiquetaDni.appendChild(cajaDni);
        //Se crea el elemento/campo input del dni
        let campoDni=document.createElement("input");
        //Dentro de ese input, recogido en la variable campoDni, se añaden los siguientes atributos:
        campoDni.type="text"
        campoDni.id="dni"
        campoDni.name="DNI"

        //Salto de línea para añadir nueva etiqueta/label
        let br1=document.createElement("br");

    //--------------------------------------------Nombre y apellidos------------------------------------------------
        //Se crea la etiqueta/label del nombre:
        let etiquetaNombre=document.createElement("label")
        //Se crea el texto que precede a la caja de texto del nombre y apellidos
        let cajaNombre=document.createTextNode("Nombre y apellidos: ");
        //A la variable etiqueta del nombre y apellidos se le añade este texto
        etiquetaNombre.appendChild(cajaNombre);
        //Se crea el elemento/campo input del nombre y los apellidos
        let campoNombre=document.createElement("input");
        //Dentro de ese input, recogido en la variable campoNombre, se añaden los siguientes atributos:
        campoNombre.type="text"
        campoNombre.id="nombre"
        campoNombre.name="nombre"

        //Salto de línea para añadir nueva etiqueta/label
        let br2=document.createElement("br"); 

    //--------------------------------------------Dirección------------------------------------------------
        //Se crea la etiqueta/label de la dirección:
        let etiquetaDireccion=document.createElement("label")
        //Se crea el texto que precede a la caja de texto de la dirección
        let cajaDirección=document.createTextNode("Dirección: ");
        //A la variable etiqueta de la dirección se le añade este texto
        etiquetaDireccion.appendChild(cajaDirección);
        //Se crea el elemento/campo input de la dirección
        let campoDireccion=document.createElement("input");
        //Dentro de ese input, recogido en la variable campoDireccion, se añaden los siguientes atributos:
        campoDireccion.type="text"
        campoDireccion.id="direccion"
        campoDireccion.name="direccion"

        //Salto de línea para añadir nueva etiqueta/label
        let br3=document.createElement("br");

    //--------------------------------------------Teléfono------------------------------------------------
        //Se crea la etiqueta/label del teléfono:
        let etiquetaTelefono=document.createElement("label")
        //Se crea el texto que precede a la caja de texto del teléfono
        let cajaTelefono=document.createTextNode("Teléfono: ");
        //A la variable etiqueta del teléfono se le añade este texto
        etiquetaTelefono.appendChild(cajaTelefono);
        //Se crea el elemento/campo input del teléfono
        let campoTelefono=document.createElement("input");
        //Dentro de ese input, recogido en la variable campoTeléfono, se añaden los siguientes atributos:
        campoTelefono.type="tel"
        campoTelefono.id="telefono"
        campoTelefono.name="telefono"

        //Salto de línea
        let br4=document.createElement("br"); 
    
    //-------------------------------------------------------------------------------------------------------
        //Al fieldset 1 se le añaden los elementos anteriores 
        campo1.appendChild(leyenda);

        campo1.appendChild(etiquetaDni);
        campo1.appendChild(campoDni);
        campo1.appendChild(br1);

        campo1.appendChild(etiquetaNombre);
        campo1.appendChild(campoNombre);
        campo1.appendChild(br2);

        campo1.appendChild(etiquetaDireccion);
        campo1.appendChild(campoDireccion);
        campo1.appendChild(br3);

        campo1.appendChild(etiquetaTelefono);
        campo1.appendChild(campoTelefono);
        campo1.appendChild(br4);
    
    //-------------------------------------------- Creación fielset 2 -------------------------------------------
        let campo2=document.createElement("fieldset");
        let leyenda2=document.createElement("legend");
        //Se añade contenido a leyenda
        let contenidoLeyenda2=document.createTextNode("¡Diseñe sus vacaciones!")
        //Se añade el contenido de la leyenda a la variable leyenda
        leyenda2.appendChild(contenidoLeyenda2);
    
    //--------------------------------------------Primer radio button-------------------------------------------------------
        //Se crea la etiqueta/label del radio button:
        let etiquetaRadio1=document.createElement("label")
        //Se crea el texto que indica qué es lo que hay que seleccionar entre los siguientes radio buttons
        let textoRadio1=document.createTextNode("Escoja un resort de parques fuera de Walt Disney World:");
        //A la variable etiqueta de la primera tanda de radio buttons se le añade este texto
        etiquetaRadio1.appendChild(textoRadio1);

        let br5=document.createElement("br");

        //-----Se crean los elementos/campos input seleccionables como radio button, incluyendo sus respectivos atributos-----
        //------------------------------------------Universal------------------------------------------------------
        let campoUniversal=document.createElement("input");
        let nombreUniversal=document.createTextNode("Universal Orlando Resort");
        campoUniversal.appendChild(nombreUniversal);
        //Se añaden los siguientes atributos:
        campoUniversal.type="radio"
        campoUniversal.id="universal"
        campoUniversal.name="alrededores"

        //Salto de línea para añadir nuevo radio button
        let br6=document.createElement("br");

        //------------------------------------------Sea World------------------------------------------------------
        let campoSea=document.createElement("input");
        let nombreSea=document.createTextNode("SeaWorld Orlando");
        campoSea.appendChild(nombreSea);
        //Se añaden los siguientes atributos:
        campoSea.type="radio"
        campoSea.id="sea"
        campoSea.name="alrededores"

        //Salto de línea para añadir nuevo radio button
        let br7=document.createElement("br");

        //------------------------------------------Busch Gardens------------------------------------------------------
        let campoBusch=document.createElement("input");
        let nombreBusch=document.createTextNode("Busch Gardens Tampa Bay");
        campoBusch.appendChild(nombreBusch);
        //Se añaden los siguientes atributos:
        campoBusch.type="radio"
        campoBusch.id="busch"
        campoBusch.name="alrededores"

        //Salto de línea para añadir nuevo radio button
        let br8=document.createElement("br");

        //------------------------------------------Gatorland------------------------------------------------------
        let campoGator=document.createElement("input");
        let nombreGator=document.createTextNode("Gatorland");
        campoGator.appendChild(nombreGator);
        //Se añaden los siguientes atributos:
        campoGator.type="radio"
        campoGator.id="gator"
        campoGator.name="alrededores"

        //Salto de línea para añadir nueva tanda de radio buttons
        let br9=document.createElement("br");
        let br10=document.createElement("br");

    //--------------------------------------------Segundo radio button-------------------------------------------------------
        //Se crea la etiqueta/label del radio button 2:
        let etiquetaRadio2=document.createElement("label")
        //Se crea el texto que indica qué es lo que hay que seleccionar entre los siguientes radio buttons
        let textoRadio2=document.createTextNode("Escoja una actividad fuera de los parques:");
        //A la variable etiqueta de la primera tanda de radio buttons se le añade este texto
        etiquetaRadio2.appendChild(textoRadio2);

        let br11=document.createElement("br");

        //-----Se crean los elementos/campos input seleccionables como radio button, incluyendo sus respectivos atributos-----
        //------------------------------------------Visita------------------------------------------------------
        let campoVisita=document.createElement("input");
        let nombreVisita=document.createTextNode("Visita al downtown Orlando");
        campoVisita.appendChild(nombreVisita);
        //Se añaden los siguientes atributos:
        campoVisita.type="radio"
        campoVisita.id="visita"
        campoVisita.name="actividad"

        //Salto de línea para añadir nuevo radio button
        let br12=document.createElement("br");

        //------------------------------------------Outlet------------------------------------------------------
        let campoOutlet=document.createElement("input");
        let nombreOutlet=document.createTextNode("Comprar en los outlets");
        campoOutlet.appendChild(nombreOutlet);
        //Se añaden los siguientes atributos:
        campoOutlet.type="radio"
        campoOutlet.id="outlet"
        campoOutlet.name="actividad"

        //Salto de línea para añadir nuevo radio button
        let br13=document.createElement("br"); 

        //------------------------------------------Tren------------------------------------------------------
        let campoTren=document.createElement("input");
        let nombreTren=document.createTextNode("Coger el nuevo tren hacia Miami");
        campoTren.appendChild(nombreTren);
        //Se añaden los siguientes atributos:
        campoTren.type="radio"
        campoTren.id="tren"
        campoTren.name="actividad"

        //Salto de línea para añadir nuevo radio button
        let br14=document.createElement("br");

        //------------------------------------------Nadar------------------------------------------------------
        let campoNadar=document.createElement("input");
        let nombreNadar=document.createTextNode("Nadar con manatíes en Crystal River");
        campoNadar.appendChild(nombreNadar);
        //Se añaden los siguientes atributos:
        campoNadar.type="radio"
        campoNadar.id="nadar"
        campoNadar.name="actividad"

        //Salto de línea para añadir nueva tanda de checkboxes
        let br15=document.createElement("br");
        let br16=document.createElement("br");

    //----------------------------------------------Checkboxes--------------------------------------------------
        //Se crea la etiqueta/label del párrafo de inicio de checboxes:
        let etiquetaCb=document.createElement("label")
        //Se crea el texto que indica qué opciones pueden ser marcadas (una o más de una)
        let textoCb=document.createTextNode("Escoja los parques Disney que desee visitar:");
        //A la variable etiqueta checkbox se le añade este texto
        etiquetaCb.appendChild(textoCb);

        let br17=document.createElement("br");

        //-----Se crean los elementos/campos input seleccionables como checkbox, incluyendo sus respectivos atributos-----
        //------------------------------------------Magic Kingdom------------------------------------------------------
        let campoMagic=document.createElement("input");
        let nombreMagic=document.createTextNode("Magic Kingdom");
        campoMagic.appendChild(nombreMagic);
        //Se añaden los siguientes atributos:
        campoMagic.type="checkbox"
        campoMagic.id="magic"
        campoMagic.name="parques"

        //Salto de línea para añadir nueva opción checkbox
        let br18=document.createElement("br");

        //------------------------------------------Animal Kingdom------------------------------------------------------
        let campoAnimal=document.createElement("input");
        let nombreAnimal=document.createTextNode("Animal Kingdom");
        campoAnimal.appendChild(nombreAnimal);
        //Se añaden los siguientes atributos:
        campoAnimal.type="checkbox"
        campoAnimal.id="animal"
        campoAnimal.name="parques"

        //Salto de línea para añadir nueva opción checkbox
        let br19=document.createElement("br"); 

        //------------------------------------------Epcot------------------------------------------------------
        let campoEpcot=document.createElement("input");
        let nombreEpcot=document.createTextNode("Epcot");
        campoEpcot.appendChild(nombreEpcot);
        //Se añaden los siguientes atributos:
        campoEpcot.type="checkbox"
        campoEpcot.id="epcot"
        campoEpcot.name="parques"

        //Salto de línea para añadir nueva opción checkbox
        let br20=document.createElement("br");

        //------------------------------------------Hollywood Studios------------------------------------------------------
        let campoHollywood=document.createElement("input");
        let nombreHollywood=document.createTextNode("Hollywood Studios");
        campoHollywood.appendChild(nombreHollywood);
        //Se añaden los siguientes atributos:
        campoHollywood.type="checkbox"
        campoHollywood.id="hollywood"
        campoHollywood.name="parques"

        //Salto de línea para añadir nueva opción checkbox
        let br21=document.createElement("br");

        //------------------------------------------Thypoon Lagoon------------------------------------------------------
        let campoThyphoon=document.createElement("input");
        let nombreThyphoon=document.createTextNode("Thyphoon Lagoon");
        campoThyphoon.appendChild(nombreThyphoon);
        //Se añaden los siguientes atributos:
        campoThyphoon.type="checkbox"
        campoThyphoon.id="thypoon"
        campoThyphoon.name="parques"

        //Salto de línea y se finaliza el fieldset 2
        let br22=document.createElement("br"); 

    //-------------------------------------------------------------------------------------------------------
        //Al fieldset 2 se le añaden los elementos anteriores 
        //Primera tanda radio button
        campo2.appendChild(leyenda2);
        campo2.appendChild(etiquetaRadio1);
        campo2.appendChild(br5);

        campo2.appendChild(campoUniversal);
        campo2.appendChild(nombreUniversal);
        campo2.appendChild(br6);
   
        campo2.appendChild(campoSea);
        campo2.appendChild(nombreSea);
        campo2.appendChild(br7);

        campo2.appendChild(campoBusch);
        campo2.appendChild(nombreBusch);
        campo2.appendChild(br8);

        campo2.appendChild(campoGator);
        campo2.appendChild(nombreGator);
        campo2.appendChild(br9);
        campo2.appendChild(br10);

        //Segunda tanda radio button
        campo2.appendChild(etiquetaRadio2);
        campo2.appendChild(br11);

        campo2.appendChild(campoVisita);
        campo2.appendChild(nombreVisita);
        campo2.appendChild(br12);

        campo2.appendChild(campoOutlet) ;
        campo2.appendChild(nombreOutlet);
        campo2.appendChild(br13); 

        campo2.appendChild(campoTren);
        campo2.appendChild(nombreTren);
        campo2.appendChild(br14);

        campo2.appendChild(campoNadar);
        campo2.appendChild(nombreNadar);
        campo2.appendChild(br15);
        campo2.appendChild(br16);

        //Tanda de checkbox
        campo2.appendChild(etiquetaCb);
        campo2.appendChild(textoCb);
        campo2.appendChild(br17);

        campo2.appendChild(campoMagic);
        campo2.appendChild(nombreMagic);
        campo2.appendChild(br18);

        campo2.appendChild(campoAnimal) ;
        campo2.appendChild(nombreAnimal);
        campo2.appendChild(br19);

        campo2.appendChild(campoEpcot);
        campo2.appendChild(nombreEpcot);
        campo2.appendChild(br20);

        campo2.appendChild(campoHollywood);
        campo2.appendChild(nombreHollywood);
        campo2.appendChild(br21);

        campo2.appendChild(campoThyphoon);
        campo2.appendChild(nombreThyphoon);
        campo2.appendChild(br22); 
    
    //-------------------------------------------Imágenes-------------------------------------------------
        //Se crea la etiqueta img de la primera imagen:
        let imagen1=document.createElement("img")

        //Se añaden los siguientes atributos:
        imagen1.id="castillo"
        imagen1.src="img/castillo.jpg"
        imagen1.alt="Castillo de Magic Kingdom"
        imagen1.title="El hermoso castillo de Cenicienta en MK"
        imagen1.width=360
        imagen1.height=640

        //Se crea la etiqueta img de la segunda imagen:
        let imagen2=document.createElement("img")

        //Se añaden los siguientes atributos:
        imagen2.id="flower"
        imagen2.src="img/flower.jpg"
        imagen2.alt="Topiary en Epcot"
        imagen2.title="Topiary de Goofy y Daisy en Epcot"
        imagen2.width=853
        imagen2.height=640 

    //------------------------------------------Campo select-----------------------------------------------------------
         //Se crea la etiqueta/label del select:
         let etiquetaSelect=document.createElement("label")
         //Se crea el texto que indica el contenido de las opciones a escoger
         let textoSelect=document.createTextNode("Escoja otro resort Disney que desee visitar:");
         //A la variable etiqueta general del select se le añade este texto
         etiquetaSelect.appendChild(textoSelect);
         etiquetaSelect.for="mundo"

         //Se crea la verdadera etiqueta/label del select:
         let etiquetaSeleccion=document.createElement("select")
         //Añadimos atributo name
         etiquetaSeleccion.name="mundo"

         let br23=document.createElement("br");

         //-----Se crean los elementos/campos opcion seleccionables, incluyendo su value-----
         //------------------------------------------California------------------------------------------------------
         let campoCalifornia=document.createElement("option");
         let nombreCalifornia=document.createTextNode("Disneyland Resort");
         campoCalifornia.appendChild(nombreCalifornia);
         //Se añade el atributo value:
         campoCalifornia.value="california"
 
         //Salto de línea para añadir nueva opción select
         let br24=document.createElement("br");

         //------------------------------------------París------------------------------------------------------
         let campoParis=document.createElement("option");
         let nombreParis=document.createTextNode("Disneyland París");
         campoParis.appendChild(nombreParis);
         //Se añade el atributo value:
         campoParis.value="paris"
 
         //Salto de línea para añadir nueva opción select
         let br25=document.createElement("br"); 

         //------------------------------------------Tokio------------------------------------------------------
         let campoTokyo=document.createElement("option");
         let nombreTokyo=document.createTextNode("Tokyo Disney Resort");
         campoTokyo.appendChild(nombreTokyo);
         //Se añade el atributo value:
         campoTokyo.value="tokyo"
         campoTokyo.selected=true;
 
         //Salto de línea para añadir nueva opción select
         let br26=document.createElement("br");

         //------------------------------------------Hong Kong------------------------------------------------------
         let campoHong=document.createElement("option");
         let nombreHong=document.createTextNode("Hong Kong Disney");
         campoHong.appendChild(nombreHong);
         //Se añade el atributo value:
         campoHong.value="hong"
 
         //Salto de línea para añadir nueva opción select
         let br27=document.createElement("br");

         //------------------------------------------Shanghái------------------------------------------------------
         let campoShan=document.createElement("option");
         let nombreShan=document.createTextNode("Shanghai Disney Resort");
         campoShan.appendChild(nombreShan);
         //Se añade el atributo value:
         campoShan.value="shan"
 
         //Salto de línea para separar elementos
         let br28=document.createElement("br");

    //------------------------------------------------------------------------------------------------- 
        //Añadimos elementos a la etiqueta
        etiquetaSelect.appendChild(etiquetaSeleccion);
        etiquetaSeleccion.appendChild(br23);

        etiquetaSeleccion.appendChild(campoCalifornia);
        etiquetaSeleccion.appendChild(br24); 

        etiquetaSeleccion.appendChild(campoParis);
        etiquetaSeleccion.appendChild(br25);

        etiquetaSeleccion.appendChild(campoTokyo);
        etiquetaSeleccion.appendChild(br26);

        etiquetaSeleccion.appendChild(campoHong);
        etiquetaSeleccion.appendChild(br27);

        etiquetaSeleccion.appendChild(campoShan);
        etiquetaSeleccion.appendChild(br28); 

    //---------------------------------------------Textarea-----------------------------------------------
        //Se crea la etiqueta/label introductoria del textarea:
        let etiquetaPeticiones=document.createElement("label")
        //Se crea el texto que indica qué escribir en ese textarea
        let textoPeticiones=document.createTextNode("Más peticiones:");
        //A la variable etiqueta del textarea se le añade este texto
        etiquetaPeticiones.appendChild(textoPeticiones);
        etiquetaPeticiones.for="mundo"
        let br29=document.createElement("br");

        //Se crea la etiqueta/label del textarea:
        let etiquetaTextarea=document.createElement("textarea")
        //Añadimos atributos
        etiquetaTextarea.style="resize: none"
        etiquetaTextarea.rows=5
        etiquetaTextarea.cols=80
        etiquetaTextarea.name="peticiones"
    //------------------------------------------------------------------------------------------------
        //Añadimos elementos a la etiqueta label
        etiquetaPeticiones.appendChild(br29);
        etiquetaPeticiones.appendChild(etiquetaTextarea);
 
    //-----------------------------------------Botón---------------------------------------------------
        //Se crea la etiqueta/label del botón
        let etiquetaBoton=document.createElement("input")
        //Añadimos atributos
        etiquetaBoton.class="button"
        etiquetaBoton.type="submit"
        etiquetaBoton.value="✨Reservar las vacaciones más mágicas de la Tierra✨"
        etiquetaBoton.id="enviar"

    //-------------------------------------------- Final -------------------------------------------
        //Al formulario se le añade el fieldset 1
        formulario.appendChild(campo1);

        //Separamos los fielset
        let br30=document.createElement("br");
        formulario.appendChild(br30);

        //Al formulario se le añade el fieldset 2
        formulario.appendChild(campo2);

        //Separamos las imágenes
        let br31=document.createElement("br");
        formulario.appendChild(br31);

        //Al formulario se le añade las imágenes
        formulario.appendChild(imagen1);
        formulario.appendChild(imagen2);
        let br32=document.createElement("br");
        formulario.appendChild(br32);

        //Al formulario se le añaden las opciones del select
        let br33=document.createElement("br");
        formulario.appendChild(br33);
        formulario.appendChild(etiquetaSelect);
        let br34=document.createElement("br");
        formulario.appendChild(br34); 
        let br35=document.createElement("br");
        formulario.appendChild(br35);

        //Al formulario se le añade el textarea
        formulario.appendChild(etiquetaPeticiones);
        
        //Al formulario se le añade el botón
        let br36=document.createElement("br");
        formulario.appendChild(br36);
        formulario.appendChild(etiquetaBoton);
        
        //Al div se le añade el formulario
        divi.appendChild(formulario);

        //Al body se le añade el div
        document.body.appendChild(divi);  
 
    }
    
