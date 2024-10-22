//Se debe importar Autentificación, ya que es quien lleva la lógica de la verificación de usuario.
import { Component, OnInit } from '@angular/core';
import { Autentificacion } from '../Clase_Autentificación/Autentificacion';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})

/*
Dentro de la clase, se inicializa a cadena vacía la variable 'hola', que será la que almacene el nombre 
del usuario. Puede entonces ser una cadena o tomar un valor null.
Luego en el constructor se debe inyectar la dependencia privada 'Autentificación'.

Finalmente, en el ngOnInit (que lleva el ciclo de vida), a la variable 'hola' se le asigna el 
user que devuelve el método 'recuperarNombreUsuario' definido en Autentificación.
Dicha variable se usa en el HTML para mostrar el nombre del usuario actual.

Esta misma mecánica se va a usar en todas las páginas (salvo en el login porque ahí de desconoce
el usuario). Dependiendo de más funcionalidades, este código saldrá junto o mezclado con otro.
*/
export class AboutComponent implements OnInit {
  
  hola: string | null = "";
  constructor(private Autentificacion: Autentificacion) { }

  ngOnInit(): void  {
    this.hola = this.Autentificacion.recuperarNombreUsuario();
  }

}
