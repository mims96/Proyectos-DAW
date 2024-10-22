package eventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import eventos.modelo.dao.ReservaDao;
import eventos.modelo.dao.UsuarioDao;


@Controller
public class ReservaController {
	@Autowired
	ReservaDao rdao;
	@Autowired
	UsuarioDao udao;
	
	/*
	 * Para cancelar una reserva en concreto, la url es variable en cuanto al id, que llega por PathVariable.
	 * Si el resultado del método del DAO de cancelar es 1 (se ha cancelado) entonces aparece el mensaje 
	 * de éxito. De lo contrario, no se ha podido cancelar la reserva.
	 * En cualquier caso, nos redirige a la pestaña de 'mis reservas'.
	 */
	@GetMapping("/cancelar/{id}")
	public String cancelarReserva (@PathVariable ("id") int idReserva, RedirectAttributes ratt) {
		if (rdao.cancelar(idReserva) == 1) {
			ratt.addFlashAttribute("mensaje", "Reserva cancelada correctamente");
		}
		else
			ratt.addFlashAttribute("mensaje", "Reserva no se ha podido cancelar");
		return "redirect:/misReservas";
	}
	
	/*
	 * En esta ruta se muestran las reservas realizadas por el usuario autenticado siempre que la fecha de celebración
	 * del evento sea posterior a la fecha actual.
	 * Si el usuario está autenticado, se obtiene el nombre del usuario gracias a la información almacenada en authentication.
	 * A su vez, eso se almacena en la variable username de tipo String. 
	 * Se muestran las reservas de ese usuario si son posteriores en el tiempo, y se devuelve la vista pertinente.
	 * En caso de no estar autenticado, se redirecciona al login, ya que esa información solo se muestra a usuarios autenticados.
	 */
	@GetMapping("/misReservas")
	public String mostrarReservas(Model model) {
	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    if (authentication != null && authentication.isAuthenticated() && !authentication.getPrincipal().equals("anonymousUser"))  {
	        String username = authentication.getName(); 
	        model.addAttribute("reservas", rdao.listarReservasPorUsuarioYFecha(username));
	        return "reservas";
	    } else {
	        return "redirect:/login"; 
	    }
	}

	
}
