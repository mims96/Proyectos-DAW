//En esta clase se sigue una lógica muy similar a la clase Videojuego, pero en este caso
//los atributos solo serán el usuario y su contraseña, ya que es lo que pide el login.
export class Usuario{
    user : string;
    contrasena : string;

    constructor(user: string, contrasena: string){
        this.user = user;
        this.contrasena = contrasena;
    }

    toString() : string{
        return `User: ${this.user}, contraseña: ${this.contrasena}`;
    }
}