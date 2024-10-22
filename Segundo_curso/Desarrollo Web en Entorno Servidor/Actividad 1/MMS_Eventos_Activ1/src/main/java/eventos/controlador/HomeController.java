package eventos.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import eventos.modelo.dao.EventoDao;

//Como devuelve vistas se le añade la notación. Se especifica que es un controlador para que lo encuentre cuando lo llame (es un componente):
@Controller
public class HomeController {
	/*
	 * Para que pueda representar en el HTML los eventos, hay que crear un dato privado.
	 * Además, se pone la directiva autowired, buscando repositorios que tengan ese interface, creando un solo objeto.
	 * De esta manera, siempre funcionan los métodos del interface, independientemente de la clase que implementa ese dao.
	 */	
	@Autowired 
	private EventoDao edao;
	
	/*
	 * La página principal viene por la barra de búsqueda o navegación. Todo lo que se teclea por urls llega por el método "get",
	 * que es una de las cuatro funciones del protocolo http. Además, la unidad más pequeña a la que puede acceder es "/".
	 */	
	@GetMapping("/")
	
	//Ahora se debe crear un método público que devuelve String porque devuelve el nombre del HTML. Se busca una url con "/" y llama al método.
	public String mostrarHome (Model model) {
		/*
		 * Si quisiéramos obtener todos los eventos, con el buscar todos se devuelve la lista completa de eventos:
		 * model.addAttribute("eventos", edao.findAll());
		 * Sin embargo, según las instrucciones del ejercicio solo hay que sacar el listado de los eventos activos.
		 * El retorno de "home" debe ser creado en "templates" como HTML.
		 */
		model.addAttribute("eventos", edao.findActivos());
		return "index";
	}

}
