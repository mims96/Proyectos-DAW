package cajero.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import cajero.modelo.dao.CuentaDao;
import cajero.modelo.dao.MovimientoDao;
import jakarta.servlet.http.HttpSession;

@Controller
public class MenuController {
	//En este caso no hay que añadir ningún dato privado porque no se van a referenciar los métodos de los DAO.
	//Solo se van a mostrar rutas que muestran vistas.
	
	@GetMapping("/menu")
	public String menu() {
		return "menu";
	}
	
	/*
	 * El método de cerrar la sesión recibe la sesión actual en un objeto.
	 * De esa sesión se elimina el atributo cuenta, 
	 * para posteriormente terminar todo lo que tenga que ver con la sesión actual. Inclusive se borran los datos.
	 * Finalmente, se redirige al home para volver a iniciar sesión si lo desea.
	 */
	@GetMapping("/logout")
	public String logout (HttpSession sesion) {
		sesion.removeAttribute("cuenta");
		sesion.invalidate();
		return "forward:/home";
	}
}
