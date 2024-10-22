/*
En primer lugar se añade el siguiente manejador de eventos para que cuando se cargue la página se cargue también el código. 
Por eso se incluye load, seguido del código insertado en la función, que es lo que precisamente se va a cargar. 
*/
window.addEventListener("load", function(){
    /*
    Identificando elementos.
    Se declaran las variables que se van a usar en la validación. Para ello, se debe localizar el nodo al que referencian.
    */
    let inputNombre = document.getElementById("nombre");
    let inputDireccion = document.getElementById("direccion");
    let inputTelefono = document.getElementById("telefono");
    let inputEmail = document.getElementById("email");

    /*Con la siguiente variable extraída del botón, se añade un nuevo manejador de eventos para que cuando pulsen
     en el botón de enviar se pueda comprobar que todos los campos están correctamente rellenos. 
     La forma de validar las diferentes secciones se encuentra en la función validación.
    */
    let clicando=document.getElementById("enviar");
    clicando.addEventListener("click", validacion);

    function validacion(){
        /*
        Para los campos de texto, la forma de validar es la misma.
        Si a la variable que se ha declarado arriba (cuyo nodo tuvo que ser localizado),
        le quitamos los espacios en blanco de los extremos, si el resultado es vacío eso quiere decir que el usuario 
        no ha rellenado ese campo. Por tanto debe figurar una alerta para que complete el campo obligatorio.

        */
        if(inputNombre.value.trim()==""){
            alert("[ERROR] El nombre es obligatorio");
            return false;
        }

        if(inputDireccion.value.trim()==""){
            alert("[ERROR] La dirección es obligatoria");
            return false;
        }

        if(inputTelefono.value.trim()==""){
            alert("[ERROR] El teléfono es obligatorio");
            return false;
        }

        if(inputEmail.value.trim()==""){
            alert("[ERROR] El correo electrónico es obligatorio");
            return false;
        }

        /*
        Ahora se especifica cómo validar los elementos radio button.
        Se declara una variable, en este caso 'tamano', que hace referencia a los radio buttons cuyo name es 'size'.
        Seguidamente se declara otra variable que llamamos 'seleccionado'. Esta se inicializa a false para que si encuentra
        un checked se cambie a true y, por tanto, se salte el alert de error que se expone más adelante.
        Igualmente, se declara la variable 'total' que actúa como acumulador de los values, en este caso por el precio.
        Se inicializa a 0 porque todavía no se ha seleccionado un elemento que aumente dicha cantidad total.
        */
        let tamano=document.getElementsByName("size");
        let seleccionado=false;
        let total =0;
            /*Se realiza un bucle for para recorrer todos los radio buttons que constan en el HTML.
            Además, si el tamaño (tamano) está escogido (checked), entonces la variable 'seleccionado' pasa a ser true
            y se aumenta la variable total por el valor del tamaño seleccionado. Aparte, hay que realizar un parseInt al value
            ya que en el HTML entra como String. Así nos aseguramos de que se acumula un numero entero.
            Finalmente, se añade 'break' para que finalice el for en cuanto se valide un radio button, 
            ya que solo hay que seleccionar uno.
            */
            for(let i=0; i<tamano.length; i++){
                if(tamano[i].checked){
                    seleccionado=true;
                    total += parseInt(tamano[i].value);
                    break;
                } 
            }
        /*
        Si no se ha seleccionado ningún radio button, entonces debe saltar la alerta para que se escoja obligatoriamente uno.
        Además, se retorna false para que no se continúe con la validación del formulario hasta que no se corrija esto.
        */

        if(!seleccionado){
            alert("[ERROR] Debe escoger un tamaño de pizza");
            return false;
        }

        /*
        A continuación, se crea el código que valide los checkboxes. La filosofía es muy similar al caso anterior. 
        La gran diferencia radica en que en lugar de añadir 'break' se añade 'continue', 
        de tal manera que si el for encuentra un checkbox seleccionado se continúa recorriendo hasta que finaliza con todos.
        Esto se debe a que se debe seleccionar de uno a 'n' checkboxes. 
        */
        let cajitaFeliz = document.getElementsByName("ingredientes");
        let chosen = false;
        let total2 =0;
            
            for (let i = 0; i < cajitaFeliz.length; i++) {
                if (cajitaFeliz[i].checked) {
                    total2 += parseInt(cajitaFeliz[i].value);
                    chosen = true;    
                    continue;
                }
            }
            //Como en el caso anterior, si no se ha escogido ningún checkbox, salta la alerta y se evita mandar el formulario.
            if (!chosen){ 
                alert("[ERROR] Debe seleccionar al menos un ingrediente.");  
                return false;
            }
        /*
        Finalmente, si todos los elementos están correctos, le anunciamos al usuario que todo está correcto.
        Además, se especifica el precio total del pedido sumando los acumuladores de los dos for realizados.
        Por último se confirma el envío de los datos con return true.
        */
        if (!(inputNombre.value.trim()=="") && !(inputDireccion.value.trim()=="") && !(inputTelefono.value.trim()=="")
            && !(inputEmail.value.trim()=="") && (seleccionado=true) && (chosen=true)){
                alert("🤌🏼¡Preparando su pedido!🤌🏼");
                alert('El coste de su pedido es ' + (total+total2)+"💶");
                return true; 
            }    
         
    }   
})