package eventos.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import eventos.modelo.dao.EventoDao;
import eventos.modelo.dao.ReservaDao;
import eventos.modelo.dao.UsuarioDao;
import eventos.modelo.entitis.Evento;
import eventos.modelo.entitis.Reserva;
import eventos.modelo.entitis.Usuario;

//La lógica de las primeras líneas de los controlers es muy similar.
@Controller
public class EventosController {
	@Autowired
	EventoDao edao;
	@Autowired
	ReservaDao rdao;
	@Autowired
	UsuarioDao udao;
	
	/*
	 * Este es el GetMapping para visualizar los detalles de un evento concreto, siendo 'id' la parte variable
	 * de la ruta.
	 * El valor 'id' es asignado a idEvento, por lo que se verá dicho evento en específico. 
	 * Además se usa Model para transferir información a la vista.
	 * Posteriormente, se busca un evento en función de su identificador mediante los métodos definidos en el DAO,
	 * y su valor queda almacenado en la variable evento de tipo Evento.
	 * 
	 * Posteriormente, se extrae el objeto Authentication para verificar si el usuario está autenticado.
	 * Si el usuario está autenticado y no es anónimo se realiza lo siguiente:
	 * Si evento no es nulo (existe el evento), este es añadido a Model y se muestra en la vista.
	 * A continuación, se extrae el número de reservas totales para el evento específico, y esa información
	 * queda guardada en la variable totalReservas. Si ese total es null (no hay reservas), su valor será de 0.
	 * Posteriormente, la cantidad restante entre el aforo máximo y el número total de reservas para ese evento
	 * se almacena en la variable de aforoDisponible, que se añade a Model para que pueda ser visualizado.
	 * Finalmente, se devuelve la vista con los detalles para los usuarios autenticados.
	 * 
	 * Si no existe el evento entonces aparecerá en el index un mensaje.
	 * En caso de no estar autenticado la lógica es igual, 
	 * salvo que somos redirigidos a otra vista de detalles personalizada para usuarios no autenticados.
	 */

	@GetMapping("/eventos/verUno/{id}")
	public String verEvento(@PathVariable("id") int idEvento, Model model) {
	    Evento evento = edao.buscarEventoPorId(idEvento);
	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();	    
	    if (authentication != null && authentication.isAuthenticated() && !authentication.getPrincipal().equals("anonymousUser"))  {
		    if (evento != null) {
		        model.addAttribute("evento", evento);
		        Integer totalReservas = rdao.totalReservasPorEvento(idEvento);
		        if (totalReservas == null) {
		            totalReservas = 0;
		        }
		        int aforoDisponible = evento.getAforoMaximo() - totalReservas;
		        model.addAttribute("aforoDisponible", aforoDisponible);	
		        return "verDetalleAutenticado";
		    } else {
		        model.addAttribute("mensaje", "El evento no existe");
		        return "forward:/";
		    }
        }else {
        	if (evento != null) {
		        model.addAttribute("evento", evento);
		        Integer totalReservas = rdao.totalReservasPorEvento(idEvento);
		        if (totalReservas == null) {
		            totalReservas = 0;
		        }
		        int aforoDisponible = evento.getAforoMaximo() - totalReservas;
		        model.addAttribute("aforoDisponible", aforoDisponible);	
		        return "verDetalle";
		    } else {
		        model.addAttribute("mensaje", "El evento no existe");
		        return "forward:/";
		    }
        }
	}
	
	/*
	 * Ahora se van a procesar las reservas de un determinado evento.
	 * Por PathVariable llega el id del evento a reservar.
	 * Por RequestParam la cantidad introducida en el desplegable de la vista.
	 * RedirectAttributes para redireccionar y mostrar mensajea; y Model para enviar información a la vista.
	 * 
	 * Posteriormente, se busca con los métodos del DAO un evento y la información se almacena en la variable evento.
	 * Luego se obtiene el nombre del usuario que se ha autenticado, a través del objeto Autenthication,
	 * siendo esto almacenado en la variable nombreUsuario.
	 * Mediante otro método del DAO se busca el username del usuario, y se recoge esa información en la variable usuario.
	 * Se obtiene el precio de venta del evento y esto se almacena en una variable.
	 * 
	 * Si el evento y el usuario no son nulos (existen ambos),se recoge en una variable la cantidad
	 * de reservas en total para un evento. Seguidamente, se obtiene el número total de reservas de un solo
	 * usuario para ese mismo evento, y dicha información se recoge en una variable. 
	 * Si el total de las reservas es nulo, entonces pasa a tener un valor de 0.
	 * 
	 * Luego se calculan las reservas totales de un usuario para un evento, que tienen su valor si es distinto de nulo,
	 * o cero si son nulas, realizado esto con un operador ternario.
	 * Seguidamente se calcula el aforo disponible para un evento concreto, lo cual se obtiene de la diferencia 
	 * entre el aforo máximo y las reservas totales entre los usuarios de ese mismo evento.
	 * 
	 * Si el aforo disponible es mayor o igual que la cantidad que se quiere reservar, y si la suma de la cantidad 
	 * que ahora quiere reservar más las reservas preexistentes de un usuario para ese evento es menor o igual que 10,
	 * entonces es que hay aforo disponible para reservar dicha cantidad y que no nos excedemos de la restricción de 10 cupos.
	 * Gracias a esto se realizan las siguientes operaciones:
	 * Se crea una nueva reserva, siendo su id autoincremental, y se añade la cantidad seleccionada,
	 * una descripción por defecto, el precio de venta obtenido del evento, y los valores de evento y usuario.
	 * Se da de alta esa reserva y se muestra en el index el mensaje exitoso.
	 * 
	 * En caso de que no se cumplan estrictamente estas condiciones, se muestra el evento y el aforo disponible,
	 * y además:
	 * si la cantidad que se desea reservar es mayor que el aforo disponible, se muestra el mensaje de aforo lleno.
	 * Sino eso quiere decir que ya se va a superar el número de reservas máximas por evento, por lo que sale el mensaje.
	 * En cualquiera de estos casos permanecemos en la vista para usuarios autenticados.
	 * 
	 * Si el evento hipotéticamente no existiera, se muestra dicho mensaje y volvemos al index.
	 */
	@PostMapping("/eventos/reservar/{id}")
	public String reservar(@PathVariable("id") int idEvento, @RequestParam("cantidad") int cantidad, RedirectAttributes ratt,
							Model model) {
	    Evento evento = edao.buscarEventoPorId(idEvento);
	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String nombreUsuario = authentication.getName();
	    Usuario usuario = udao.buscarPorUsername(nombreUsuario);
	    BigDecimal precioVenta = evento.getPrecio(); 

	    if (evento != null && usuario != null) {
	    	Integer totalReservas = rdao.totalReservasPorEvento(idEvento);
	    	Integer reservasUsuarioParaEvento = rdao.totalReservasUserPorEvento(idEvento, nombreUsuario);

	        if (totalReservas == null) {
	            totalReservas = 0;
	        }
	        int totalReservasUsuarioParaEvento = (reservasUsuarioParaEvento != null) ? reservasUsuarioParaEvento : 0;

	        int aforoDisponible = evento.getAforoMaximo() - totalReservas;

	        if (cantidad <= aforoDisponible && (cantidad + totalReservasUsuarioParaEvento) <= 10) {
	        	Reserva nuevaReserva = new Reserva(cantidad, "Reserva realizada", precioVenta, evento, usuario);
	        	rdao.altaReserva(nuevaReserva);
	            ratt.addFlashAttribute("mensaje", "Reserva realizada con éxito");
	            return "redirect:/";
	        } else {
	        	model.addAttribute("evento", evento);
	        	model.addAttribute("aforoDisponible", aforoDisponible);
	            if (cantidad > aforoDisponible) {
	            	model.addAttribute("mensaje", "Aforo completo");
	            } else {
	            	model.addAttribute("mensaje", "No puede reservar más de 10 cupos en total para este evento.");
	            }
	            return "verDetalleAutenticado"; 
	        }
	    } else {
	    	ratt.addFlashAttribute("mensaje", "El evento no existe");
	        return "redirect:/";
	    }
	}



	
	/*
	 * Esta ruta muestra gracias a model la vista con la lista de eventos destacados.
	 * Primero se recibe la información concerniente a la autenticación.
	 * Si el usuario está autenticado y no es anónimo, se muestra el listado de eventos destacados en la vista correspondiente.
	 * Si no está autenticado el usuario o si es anónimo, entonces se devuelve lo mismo pero en la vista para
	 * no autenticados.
	 */
	
	@GetMapping("/eventos/destacados")
	public String verSoloDestacados (Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    
	    if (authentication != null && authentication.isAuthenticated() && !authentication.getPrincipal().equals("anonymousUser")) {
        	model.addAttribute("eventos", edao.findDestacados());
            return "destacadosAutenticado";
        }else
		model.addAttribute("eventos", edao.findDestacados());
		return "destacados";
	}
	
	/*
	 * La lógica del siguiente mapping es muy similar al anterior, pero
	 * esta ruta muestra gracias a model la vista con la lista de eventos activos.
	 */
	@GetMapping("/eventos/activos")
	public String verSoloActivos (Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    
	    if (authentication != null && authentication.isAuthenticated() && !authentication.getPrincipal().equals("anonymousUser"))  {
        	model.addAttribute("eventos", edao.findActivos());
        	return "activosAutenticado";
        }else
		model.addAttribute("eventos", edao.findActivos());
		return "activos";
	}
	
	


}
