import { Component, OnInit } from '@angular/core';
//Se necesita incorporar ActivatedRoute para que la web pueda comprender las urls,
//obtener información con los parámetros y mostrar la información pertinente.
import { ActivatedRoute } from '@angular/router';
import { Autentificacion } from '../Clase_Autentificación/Autentificacion';


@Component({
  selector: 'app-videogame1',
  templateUrl: './videogame1.component.html',
  styleUrls: ['./videogame1.component.css']
})

/*Se necesita desarrollar la siguiente clase para mostrar los detalles de los videojuegos
como su título o la valoración.

En primer lugar se inicializan los parámetros que tienen información de los juegos.
Luego dentro del constructor, se accede a la información de la ruta actual con la clase ActivatedRoute;
se obtiene información del videojuego mediante los parámetros de la url.

En definitiva, se necesitan extraer esos parámetros para que la página sepa qué información debe mostrar.
Si no se pusiera el código de abajo, el componente desconocería el valor de las propiedades,
por lo que no podría acceder a la información exacta de dicha página a la que se desea llegar.
*/
export class Videogame1Component implements OnInit {
  id: number = 0;
  titulo: string = "";
  compania: string = "";
  valoracion: number = 0;
  hola: string | null = "";


  constructor(route: ActivatedRoute, private Autentificacion: Autentificacion) {
    this.id = route.snapshot.params["id"];
    this.titulo = route.snapshot.params["titulo"];
    this.compania = route.snapshot.params["compania"];
    this.valoracion = route.snapshot.params["valoracion"];
  }

  ngOnInit(): void { 
    this.hola = this.Autentificacion.recuperarNombreUsuario();
  }

}


