package cajero.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cajero.modelo.dao.CuentaDao;
import cajero.modelo.entity.Cuenta;
import jakarta.servlet.http.HttpSession;

//Se anota con @Controller porque va a devolver vistas.
@Controller
public class HomeController {
	//Se necesita el dato privado
	@Autowired
	private CuentaDao cdao;
	
	//La ruta que nos lleva al home:
	@GetMapping({"/home"})
	public String home() {
		return "home";
	}
	
	/*
	 * En el home hay un formulario. Por tanto se debe realizar un PostMapping.
	 * Se incluye RedirectAttributes para mostrar un mensaje. Como hay una redirección a otra vista no es Model.
	 * Se usa HttpSesion para guardar la sesión para que sea consultada en cualquier momento del programa.
	 * Se añade el parámetro idCuenta que identifica a dicha cuenta con la que se va a operar.
	 * Posteriormente se busca una cuenta según su identificador.
	 * Si esa cuenta existe, se almacena la sesión de la cuenta y redirige al menú con las diversas opciones.
	 * En caso contrario, se advierte por mensaje con addFlashAttribute (que se usa junto con RedirectAttributes)
	 * y se impide continuar. Este mensaje es instantáneo y solo se muestra una vez por cada ejecución.
	 */
	@PostMapping({"/home"})
	public String procHome (RedirectAttributes ratt, HttpSession sesion,@RequestParam int idCuenta) {
		Cuenta cuenta = cdao.buscarUna(idCuenta);
		if (cuenta !=null) {
			sesion.setAttribute("cuenta", cuenta);
			return "redirect:/menu";
		}
		ratt.addFlashAttribute("mensaje", "La cuenta introducida no existe");
		return "redirect:/home";
	}
	
	
}
