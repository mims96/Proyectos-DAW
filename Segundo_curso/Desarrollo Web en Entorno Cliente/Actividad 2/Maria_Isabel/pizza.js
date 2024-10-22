window.addEventListener("load", function(){
    //--------------------------------------------------Requerimiento 1----------------------------------------------------------------
    
    //Se declaran las constantes  de la url y el json con los datos que serán llamadas en el xmlHttp.open.
    //La url destino final absoluta sería: http://127.0.0.1:5500/Maria_Isabel/pizza.json
    const URL_DESTINO = "http://127.0.0.1:5501/Actividades/Web_Entorno_Cliente_AE-2/Maria_Isabel/"
    const RECURSO = "pizza.json" 

    //Se crea la función de enviar la petición.
    function enviarPeticionAsincrona(){
        //Se crea el objeto JSON, que es el más importante.
        let xmlHttp = new XMLHttpRequest()

        /*
            Se realiza la función de callback, de tal manera que se ejecuta cuando la respuesta http ha finalizado (4) y todo
            está correcto.
        */
        xmlHttp.onreadystatechange = function (){
            if (this.readyState==4){
                if(this.status==200){
                    //El JSON se toma como texto normal
                    procesarRespuesta(this.responseText)
                }else{
                    alert("El status NO es 200 OK")
                }
            }
        }

        //El verbo HTTP que se va a usar es 'get'; se especifican la url y el recurso que se van a usar; true para asincronía.
        xmlHttp.open('GET', URL_DESTINO + RECURSO, true)
        //Como el método es 'get' no se manda nada:
        xmlHttp.send(null)
    }

    //Se crea la función para procesar la respuesta, que se llama en el segundo if  de la función 'onreadystatechange'.
    function procesarRespuesta(jsonDoc){
        //El texto se transforma a objeto JSON
        let objetoJson=JSON.parse(jsonDoc)
        console.log(objetoJson)

        //Se declara la variable de array que será usada en el for:
        let arrayTamaños = objetoJson.PIZZA.TAMAÑOS;
        let arrayIngredientes = objetoJson.PIZZA.INGREDIENTES;

        /*Se limpia el contenido previo del div con id 'field' para la función de refrescar.
        Una variable recoge el contenido del div 'field', y dicho contenido se elimina poniéndolo en vacío.*/
        let fields = document.getElementById("field");
        fields.innerHTML = '';


        //Ahora se crea la estructura del DOM dinámica.
        //Los elementos que no son ni radio button ni checkbox se crean fuera de los for ya que solo se hace una vez.
        //Se crea un fieldset, la legend y su texto, por lo que luego se hace el appendChild.
        let fieldsetDinamico=document.createElement("fieldset");
        let leyenda=document.createElement("legend");
        let contenidoLeyenda=document.createTextNode("Diseñe su propia pizza:")
        leyenda.appendChild(contenidoLeyenda);
        //Se crea el label que engloba a los radio button, un texto que explique qué hay que seleccionar, y este se añade al label.
        let etiqueta1 = document.createElement("label")
        //etiqueta1.for="size"
        let contenido1=document.createTextNode("Tamaño de la pizza:")
        etiqueta1.appendChild(contenido1)
        //Al fieldset se le añade el label.
        fieldsetDinamico.appendChild(etiqueta1)
        let br1 =document.createElement("br")
        fieldsetDinamico.appendChild(br1)

        //Se itera el array de los tamaños de las pizzas y se crean los radio button pertinentes en función de los datos del JSON.
        for (let tam of arrayTamaños){
            //Se crea la etiqueta label para almacenar el texto
            let eti = document.createElement("label")

            //Se crea la etiqueta input
            let inputi = document.createElement("input")

            //El type y el name es igual para todos los radio button.
            inputi.type="radio"
            inputi.name="size"
            //tam es la variable que hace referencia al arrayTamaños. A su vez, esta variable de array contiene el objeto JSON
            //que contiene la ruta PIZZA.TAMAÑOS, para, a partir de ahí, acceder al tamaño y precio correspondiente.
            inputi.value = tam.PRECIO
            inputi.id = tam.TAMAÑO

            //Al label se le añade el input
            eti.appendChild(inputi)

            //Una vez creada la estructura input, se crea y se añade el nodo texto al label de cada input.
            let nombreti = document.createTextNode(tam.TAMAÑO)
            //Al label se le añade el texto
            eti.appendChild(nombreti)

            //Se crea salto de línea
            let br2=document.createElement("br");

            //Se añaden los label y el br al fieldset.
            fieldsetDinamico.appendChild(eti)
            fieldsetDinamico.appendChild(br2)
        }

        let br3 =document.createElement("br")
        fieldsetDinamico.appendChild(br3)
        //Se crea el label para los checkboxes, con su texto al que posteriormente se hace un appendChild.
        let etiqueta2 = document.createElement("label")
        //etiqueta2.for="size"
        let contenido2=document.createTextNode("Escoja los ingredientes:")
        etiqueta2.appendChild(contenido2)
        //Al fieldset se le añade el label.
        fieldsetDinamico.appendChild(etiqueta2)
        let br4 =document.createElement("br")
        fieldsetDinamico.appendChild(br4)

        for (let ing of arrayIngredientes){
            //Se sigue la misma lógica que en el caso anterior pero adaptado a checkbox.
            //Se crea la etiqueta label para almacenar el texto
            let etii = document.createElement("label")

            //Se crea la etiqueta input
            let inputii = document.createElement("input")
 
            //El type y el name es igual para todos los checkbox.
            inputii.type="checkbox"
            inputii.name="ingredientes" 
            //ing es la variable que hace referencia al arrayIngredientes. A su vez, esta variable de array contiene el objeto JSON
            //que contiene la ruta PIZZA.INGREDIENTES, para, a partir de ahí, acceder al ingrediente y precio correspondiente.       
            inputii.value = ing.PRECIO
            inputii.id = ing.INGREDIENTE

            //Al label se le añade el input
            etii.appendChild(inputii)

            //Una vez creada la estructura input, se crea y se añade el nodo texto al label de cada input.
            let nombreti = document.createTextNode(ing.INGREDIENTE)
            //Al label se le añade el texto
            etii.appendChild(nombreti)

            //Se crea salto de línea
            let br5=document.createElement("br");

            //Se añaden los label y el br al fieldset.
            fieldsetDinamico.appendChild(etii)
            fieldsetDinamico.appendChild(br5)
        }

        //Al fieldset se le añade la legend.
        fieldsetDinamico.appendChild(leyenda)

       //Se crea una variable que haga referencia al div creado en el HTML, para añadir ahí todo el fielset.
       //let fields =document.getElementById("field")
       fields.appendChild(fieldsetDinamico)
    }

    enviarPeticionAsincrona()



    //-------------------REFRESCAR
    /* Se vuelve a realizar el proceso anterior sin necesidad de crear los elementos, ya que estos están dentro de la función
       procesarRespuesta, que ya ha sido declarada. Las líneas de código que cambien serán comentadas*/

    function refrescar(){
        alert("Dentro de función refrescar")
        let xmlHttp = new XMLHttpRequest()

        xmlHttp.onreadystatechange = function (){
            if (this.readyState==4){
                if(this.status==200){
                    // Antes de procesar la respuesta, limpiamos el contenido existente.
                    document.getElementById("field").innerHTML = '';
                    procesarRespuesta(this.responseText);
                }else{
                    alert("El status NO es 200 OK")
                }
            }
        }

        xmlHttp.open('GET', URL_DESTINO + RECURSO, true)
        xmlHttp.send(null)
    }

    let actualizar = document.getElementById("refrescar")
    actualizar.addEventListener("click", refrescar);

    /*
    //Se crea una variable en la cual se almacena el estado del formulario actual
    let formularioActual = null;

    function refrescar(){
        alert("Dentro de función refrescar")
        let xmlHttp = new XMLHttpRequest()

        xmlHttp.onreadystatechange = function (){
            if (this.readyState==4){
                if(this.status==200){
                    /*La respuesta del servidor tras estar todo ok, que llega como String debido al responseText, 
                    se almacena en una variable. this referencia a xmlHttp */
                    //let respuestaServidor=this.responseText
                    /*El String de dicha respuesta se parsea para convertirlo a js. La variable hace referencia al JSON que 
                    llega ahora*/
                    //let nuevoFormulario= JSON.parse(respuestaServidor)
                    /* Hay que comparar los datos del JSON para saber si ha habido cambios. 
                    Se realizan stringify para convertir los JSON en cadena y así compararlos más efectivamente*/
                    //if (JSON.stringify(nuevoFormulario) !== JSON.stringify(formularioActual)) {
                        /*Si el nuevo JSON que llega es distinto del JSON previo, 
                        solo entonces el formulario pasa a tener los nuevos valores y se actualiza la respuesta.*/
                   //     formularioActual=nuevoFormulario
                    //    procesarRespuesta(respuestaServidor)
                /*}else{
                    alert("El status NO es 200 OK")
                }
            }
        }

        xmlHttp.open('GET', URL_DESTINO + RECURSO, true)
        xmlHttp.send(null)
        }
    }

    /*Posteriormente, se recupera el elemento botón mediante su id  al pulsar dicho botón. No se recargará la página 
    al completo, sino solo lo que haya cambiado. */
    /*
    document.getElementById("refrescar").onclick = function (e) {
         e.preventDefault()
         refrescar()     
    }*/
/*
    let actualizar = document.getElementById("refrescar")
    actualizar.addEventListener("click", refrescar);
*/

    //--------------------------------------------------Requerimiento 2----------------------------------------------------------------
    //Se crea la función total, por la cual se obtiene el precio final del pedido.
    function total(){   
        //Se inicializan las variables acumuladoras.
        let resultatTaille = 0;
        let resultatIngredients = 0;
        
        // Recorrer todos los tamaños
        //Se declara una variable que contiene todos los elementos cuyo name asignado ha sido 'size', es decir, los radio button.
        let tamaños = document.getElementsByName('size');
        //Se recorre un for del tamaño de toda la colección de tamaños asignados a la variable tamaño.
        for(let i = 0; i < tamaños.length; i++){
            //Si un tamaño es seleccionado, el valor del mismo, obtenido mediante el atributo value, se acumula.
            //Como solamente se puede escoger un tamaño de pizza, en el momento que el for encuentre un checked para el recorrido.
            if(tamaños[i].checked){
                resultatTaille += parseInt(tamaños[i].value);
                break;
            }
        }
    
        // Recorrer todos los ingredientes; lógica muy similar al caso anterior
        //Se declara una variable que contiene todos los elementos cuyo name asignado ha sido 'ingredientes', es decir, los checkbox.
        let ingredientes = document.getElementsByName('ingredientes');
        //Se recorre un for del tamaño de toda la colección de ingredientes asignados a la variable ingredientes.
        for (let i = 0; i < ingredientes.length; i++){
            //Si un ingrediente es seleccionado, el valor del mismo, obtenido mediante el atributo value, se acumula.
            //Como se pueden escoger de 1 a n ingredientes, no hay que parar el recorrido del for y, por tanto, se omite el 'break'.
            if(ingredientes[i].checked){
                resultatIngredients += parseInt(ingredientes[i].value);
            }
        }
        
        //Se crea una variable que almacena la suma de los acumuladores de precios. Se recoge dicha suma.
        let resultatFinal = resultatTaille + resultatIngredients;
        return resultatFinal;
    }
    
    //Al elemento HTML, cuyo id es 'enviar', en este caso el botón, se le añade el evento onclick, de tal manera que al ser
    //pulsado, la función se ejecuta. Se previene el comportamiento por defecto del evento.
    document.getElementById("enviar").onclick = function (e) {
        e.preventDefault(); 
        //La nueva variable almacena el valor que retorna la función total()
        let precioTotal = total(); 
        //Finalmente, al elemento del HTML cuyo id es 'resultadoPrecio'(la caja de texto) se le incluye como valor el contenido
        //de la variable que almacena el retorno de la función total().
        document.getElementById("resultadoPrecio").value = precioTotal + " €"; 
    }   
})


