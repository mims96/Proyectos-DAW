//Se tienen que importar el Component y el OnInit para generar el componente y su ciclo de vida;
//el Router para la navegación entre páginas, y la clase creada para manejar la autetificación.
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Autentificacion } from '../Clase_Autentificación/Autentificacion';

//Esto se genera automáticamente, siendo los metadatos del componente, en concreto su selector y las rutas a su HTML y CSS.
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

/*
La clase del componente de iniciar sesión implementa la interfaz de ciclo de vida de dicho componenente.
Se inicializan a su cadena vacía el nombre de las propiedades del componente.

A continuación se inyectan las dependencias del componente en el constructor. Ambos son servicios:
el primero para verificar usuarios y contraseñas, y el segundo para la navegabilidad. Su inyección
permite emplear su funcionalidad.

Seguidamente, el método controla la lógica del login.
Si la verificación de la clase Autentificación (a la que se le pasa el user y la contraseña) es true,
entonces somos redirigidos al index gracias a la navegación del router.
En cambio, si devuelve nulo figurará el mensaje de error almacenado en this.incorrecto.
*/
export class LoginComponent implements OnInit{
  user: string ="";
  contrasena: string ="";
  incorrecto = '';

  constructor(private Autentificacion: Autentificacion, private router: Router) {}

  login() {
    if (this.Autentificacion.verificar(this.user, this.contrasena)) {
      this.router.navigate(['/index']);
    } else {
      this.incorrecto = '⚡️¡Vaya! Parece que el nombre estrella o la clave mágica no son los correctos.¡Anímate, aventurero del Mundo de los Sueños, e inténtalo de nuevo!'; 
    }
  }

  ngOnInit(): void {
  }
}
