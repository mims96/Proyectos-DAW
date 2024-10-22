//Misma lógica que en 'about'.
import { Component, OnInit } from '@angular/core';
import { Autentificacion } from '../Clase_Autentificación/Autentificacion';

@Component({
  selector: 'app-contacto',
  templateUrl: './contacto.component.html',
  styleUrls: ['./contacto.component.css']
})
export class ContactoComponent implements OnInit {

  hola: string | null = "";
  constructor(private Autentificacion: Autentificacion) { }

  ngOnInit(): void  {
    this.hola = this.Autentificacion.recuperarNombreUsuario();
  }

}
