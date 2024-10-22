package eventos.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import eventos.modelo.dao.EventoDao;
import eventos.modelo.dao.PerfilDao;
import eventos.modelo.dao.UsuarioDao;
import eventos.modelo.entitis.Usuario;
import jakarta.servlet.http.HttpSession;

//Anotamos el controlador porque devuelve vistas
@Controller
public class HomeController {
	//Se necesitan los datos privados:
	@Autowired
	UsuarioDao udao;
	@Autowired
	PerfilDao pdao;
	@Autowired
	EventoDao edao;
	
//--------------------------------------------------------------------------------------------------	
	
	/*
	 * Acceso a la página principal en la que se muestra el listado de eventos activos y destacados.
	 * Siguiendo la lógica de otros mappings en cuanto a la autenticación, si lo está entonces se muestra el listado
	 * con los eventos destacados en el index para usuarios autenticados.
	 * Si eso no fuese así, se muestra la vista para usuarios no autenticados con los eventos activos y destacados.
	 */
	
	@GetMapping("/")
	public String menuPrincipal(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    
	    if (authentication != null && authentication.isAuthenticated() && !authentication.getPrincipal().equals("anonymousUser")) {
	    	model.addAttribute("eventos", edao.findDestacados());
	        return "indexClientes";
	    }else {
	    	model.addAttribute("eventos", edao.findActivosDestacados());
	    	return "index";
	    }
	}

//--------------------------------------------------------------------------------------------------
	
	//Acceso al formulario de registro para crear un nuevo usuario. Se añade el atributo 'usuario'
	//al modelo para lograr un vínculo con los campos del formulario.
	//De esta manera el usuario se crea vacío, listo para ser rellenado con los datos que introduzcan.
	@GetMapping("/registro")
	public String mostrarRegistro(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "formRegistro";
	}
	
	/*
	 * Como esta dirección lleva asociada un formulario, es necesario realizar un PostMapping
	 * para enviar los datos introducidos en dicho formulario a un servidor.
	 * Se recibe el parámetro usuario con los datos facilitados, y se necesita el RedirectAttributes
	 * para incluir mensajes al redirigir a la página pertinente.
	 * 
	 * El usuario debe estar activo.
	 * La fecha corriente se toma como fecha de registro.
	 * Se añade el perfil cuyo identificador es el 3, es decir, el rol cliente.
	 * Se crea una contraseña no codificada para el usuario.
	 * 
	 * Posteriormente, se registra el usuario en la base de datos.
	 * Si la operación es exitosa somos redirigidos al formulario de login y figura un mensaje.
	 * De lo contrario, permanecemos en el sitio y aparecerá el mensaje informativo.
	 */
	@PostMapping ("/registro")
	public String procregistrar(Usuario usuario, RedirectAttributes ratt) {
		usuario.setEnabled(1);
		usuario.setFechaRegistro(new Date());
		usuario.addPerfil(pdao.buscarPerfilPorId(3));
		usuario.setPassword("{noop}"+ usuario.getPassword());
		
		if (udao.registro(usuario)) {
			ratt.addFlashAttribute("mensaje", "Alta de usuario realizada");
			return "redirect:/login";
		}
		else {
			ratt.addFlashAttribute("mensaje", "El usuario introducido ya existe");
			return "redirect:/registro";
		}	
	}
	
//--------------------------------------------------------------------------------------------------
	
	//Esta ruta nos lleva al formulario de login. No es necesario hacer un PostMapping.
	@GetMapping("/login")
	public String verLogin() {
		return "formLogin";
	}
	
	/*
	 * Esta es la ruta que se sigue tras un login exitoso.
	 * El objeto authentication tiene información del usuario logueado.
	 * Con model se transfieren los datos necesarios a la vista.
	 * Httpsesion guarda la información del usuario.
	 * 
	 * Se imprime por consola el nombre el usuario autenticado.
	 * Se busca el id del usuario y se almacena en una variable llamada usuario de tipo usuario.
	 * Si la sesión no tiene el atributo usuario, entonces se guarda su información para que pueda navegar.
	 * 
	 * Con model se visualiza la lista de eventos destacados.
	 * El método devuelve la vista para clientes logueados.
	 */
	
	@GetMapping("/inicioSesion")
	public String procesarLogin (Authentication aut, Model model, HttpSession misesion) {
		System.out.println("usuario : " + aut.getName());
		Usuario usuario = udao.buscarUsuarioPorId(aut.getName());
		
		if (misesion.getAttribute("usuario") == null)
			misesion.setAttribute("usuario", usuario);

		model.addAttribute("eventos", edao.findDestacados());
		
		return "indexClientes";
	}
	
//--------------------------------------------------------------------------------------------------
	/*
	 * El método de cerrar la sesión recibe la sesión actual en un objeto.
	 * De esa sesión se elimina el atributo usuario, para posteriormente terminar todo
	 * lo que tenga que ver con la sesión actual. Inclusive se borran los datos.
	 * Finalmente, se redirige al home para volver a iniciar sesión si lo desea.
	 */
	@GetMapping("logout")
	public String logout (HttpSession sesion) {
		sesion.removeAttribute("usuario");
		sesion.invalidate();
		return "forward:/";
	}
	
//--------------------------------------------------------------------------------------------------
	/*
	 * Esta ruta sirve para filtrar en el listado de eventos principal. Por RequestParam llega el String del 
	 * tipo del evento. En cualquier caso se devuelve el listado de eventos filtrado, pero la vista es distinta
	 * dependiendo de si está o no autenticado.
	 */
	@GetMapping("/desplegable")
	public String filtrar(@RequestParam("tipoEvento") String tipoEvento, Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    
	    if (authentication != null && authentication.isAuthenticated() && !authentication.getPrincipal().equals("anonymousUser")) {
	    	model.addAttribute("eventos", edao.buscarPorTipo(tipoEvento));
	    	return "indexClientes";
	    }else {
	    	model.addAttribute("eventos", edao.buscarPorTipo(tipoEvento));
	    	return "index";
	    }
	}
	
}
