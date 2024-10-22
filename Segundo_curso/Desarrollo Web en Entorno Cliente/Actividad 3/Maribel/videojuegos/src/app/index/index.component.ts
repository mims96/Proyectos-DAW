import { Component, OnInit } from '@angular/core';
import { Videojuego } from '../Clase_Videojuego/videojuego';
import { Autentificacion } from '../Clase_Autentificación/Autentificacion';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})

export class IndexComponent implements OnInit {
  //Se inicializan los atributos de la clase a los valores por defecto o cadena vacía para garantizar un contenido mínimo.
  id: number = 0;
  titulo: string = "";
  compania: string = "";
  valoracion: number = 0;
  hola: string | null = "";

  //A continuación se crea un listado de videojuegos en forma de array. Se inicializa a vacío,
  //pero está pensado para almacenar una colección de objetos de Videojuego.
  listado: Videojuego[] = [];

  //Ahora se declara que videojuego puede estar vacío o no, pero que en un principio ocurre lo primero.
  //Videojuego es la clase, mientras que videojuego es la variable que almacena info sobre el juego.
  videojuego: Videojuego | null = null;

  /*
  Seguidamente, se van a crear en el constructor una serie de nuevos videojuegos con sus parámetros propios.
  Para el primer objeto se debe declarar la variable que almacene su información concreta.
  En los objetos videojuegos posteriores no es necesario, pues ya ha sido declarada y su valor se modifica.
  
  Nótese que en el primer videojuego el 'Videojuego' que precede el = va en mayúscula, mientras 
  que en el resto de juegos va minúscula. Esto se debe a que en el primer caso se define 
  una variable 'videojuego' de tipo Videojuego, mientras que en el resto de casos ya se usa 
  esa variable para almacenar y actualizar información.

  Tras la creación individual, mediante la información guardada en la variable 'videojuego', 
  este videojuego se agrega a la colección o listado de videojuegos.
  */
  constructor(private Autentificacion: Autentificacion) { 
  let videojuego: Videojuego = new Videojuego(1, "Nintendogs", "Nintendo", 96);
  this.listado.push(videojuego); 
  
  videojuego = new Videojuego(2, "Animal Crossing: Wild World", "Nintendo", 95)
  this.listado.push(videojuego);

  videojuego = new Videojuego(3, "Grand Theft Auto: San Andreas", " Rockstar Games", 97)
  this.listado.push(videojuego);

  videojuego = new Videojuego(4, "Outlast", "Red Barrels", 95)
  this.listado.push(videojuego);

  videojuego = new Videojuego(5, "Rayman", "Ubisoft", 97)
  this.listado.push(videojuego);

  videojuego = new Videojuego(6, "Donkey Kong 64", "Nintendo", 95)
  this.listado.push(videojuego);

  videojuego = new Videojuego(7, "Diddy Kong Racing", "Rare", 95)
  this.listado.push(videojuego);

  videojuego = new Videojuego(8, "Super Mario Galaxy", "Nintendo", 97)
  this.listado.push(videojuego);

  videojuego = new Videojuego(9, "Pokémon Snap", "Nintendo", 91)
  this.listado.push(videojuego);

  videojuego = new Videojuego(10, "Tomb Raider II", "Eidos Interactive", 90)
  this.listado.push(videojuego);

  }

  ngOnInit(): void {
    this.hola = this.Autentificacion.recuperarNombreUsuario();
  }

}

