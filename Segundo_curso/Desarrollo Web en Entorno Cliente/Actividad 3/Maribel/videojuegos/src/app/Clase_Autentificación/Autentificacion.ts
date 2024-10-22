//Se debe importar Injectable para que esta clase sea un servicio inyectable; 
//y el usuario para poder crear la lista de usuarios.
import { Injectable } from '@angular/core';
import { Usuario } from '../Clase_Usuario/Usuario'

//Lo siguiente indica que esta clase será inyectable en todo el proyecto.
@Injectable({
  providedIn: 'root'
})

/*
A continuación se crea una lista privada de usuarios, que será usada para la autentificación de la sesión.
La propiedad usuarios se inicializa como un array de objetos de Usuario, creándose nuevas instancias
de dicha clase Usuario con sus propios valores cada una.

Seguidamente, el método verificar recibe los parámetros de user y contraseña. Mediante un bucle for
recorre toda la lista y verifica que si algún usuario tiene su nombre y contraseña igual que en la 
lista de usuarios, entonces guarda el nombre en localStorage y devuelve true. 
En caso de no encontrar coincidencias devuelve false.

Finalmente, el último método recupera el nombre del user actual que se ha almacenado en el localStorage.
Este método devuelve String si hay algún username almacenado, o null si no existe.
*/
export class Autentificacion {
  private usuarios: Usuario[] = [
    new Usuario('bowser', 'peaches'),
    new Usuario('mario', 'its a me'),
    new Usuario('pikachu', 'te elijo a ti'),
    new Usuario('tiny', 'kong'),
    new Usuario('game', 'over')
  ];

  verificar(user: string, contrasena: string): boolean {
    for (const utilisateur of this.usuarios) {
      if (utilisateur.user === user && utilisateur.contrasena === contrasena) {
        localStorage.setItem('utilisateurActuel', user); 
        return true; 
      }
    }
    return false; 
  }

  recuperarNombreUsuario(): string | null {
    return localStorage.getItem('utilisateurActuel');
  }

}
