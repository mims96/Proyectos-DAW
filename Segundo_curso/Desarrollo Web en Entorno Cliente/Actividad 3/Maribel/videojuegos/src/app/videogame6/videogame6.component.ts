import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Autentificacion } from '../Clase_Autentificación/Autentificacion';

@Component({
  selector: 'app-videogame6',
  templateUrl: './videogame6.component.html',
  styleUrls: ['./videogame6.component.css']
})
export class Videogame6Component implements OnInit {
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
