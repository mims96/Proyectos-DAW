package eventos.controlador;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import eventos.modelo.dao.EventoDao;
import eventos.modelo.javabeans.Evento;


/*
 * Se añaden las siguientes anotaciones para indicar que se trata de un controlador
 * y que se saca factor común a la ruta "/eventos", respectivamente. 
 */
@Controller
@RequestMapping("/eventos")
public class EventosController {

	/*
	 * Se necesita el dao de eventos y así se busca en tiempos de ejecución una clase que implemente este interface
	 * y crea un objeto de new EventoDaoImplList
	 */
	
	@Autowired
	private EventoDao edao;
	
	//--------------------------------------------------------------------------------------------------------------------------------
	
	/* 
	 * Al llegar por get se pone @GetMapping y se asocia a la url que figura justo después.
	 * {id} es el atributo del path que le hemos metido, y ese identificador se recupera por @PathVariable.
	 * eliminarEvento es un método que devuelve una cadena. 
	 * Luego se parsea a entero que denomino idEvento. También se añade el model para sacar un mensaje por pantalla.
	 * Esto sirve para eliminar un evento perteneciente una lista.
	 */
	@GetMapping("/eliminar/{id}")
	public String eliminarEvento(@PathVariable("id") int idEvento, Model model){
		/* 
		 * Si el objeto al que pertenece el id del path se ha eliminado según el @override del impl, es decir, devuelve 1,
		 * se obtiene un mensaje de confirmación y se vuelve al listado de activos.
		 * Al forward se le informa de la url que tiene el método, y al tener un GetMapping "/" se invoca.
		 * Se busca por todos los controladores la ruta "/", creando el atributo con todos y llama al home, 
		 * que es el que pinta la página de inicio.
		 */
		if (edao.delete(idEvento)==1)
			model.addAttribute("mensaje", "Evento eliminado correctamente");
		else
			model.addAttribute("mensaje", "Evento no se ha podido eliminar");
		
		return "forward:/";		
	}	
	//--------------------------------------------------------------------------------------------------------------------------------
	//Para este ejercicio, editar cumple la función de ver los datos.
	@GetMapping("/editar/{id}")
	public String editarEvento(@PathVariable("id") int idEvento, Model model){
		/*
		 * Es necesario el evento y el id que viene por parámetro.
		 * Si hay contenido (es distinto de nulo) el evento existe, por lo que se muestra el HTML de editar.
		 * Sino aparece un mensaje debido a la presencia de Model y se regresa al home.
		 */
		Evento evento= edao.findById(idEvento);
		if(evento!=null) {
			/*
			 * Para saber cuál es el evento al que nos referimos, ponemos por model el atributo evento con el objeto evento.
			 * De lo contrario no se encontraría en editar.html y saldría todo vacío.
			 */
			model.addAttribute("evento", evento);
			//Así es como se llama el HTML que contiene la estructura de editar:
			return "editar";
		}
		else {
			model.addAttribute("mensaje", "El evento no existe");
			return "forward:/";
		}
	}
	//--------------------------------------------------------------------------------------------------------------------------------
	/*
	 * Para hacer la ruta de alta, en el método se pone String, porque es un forward o el nombre de un HTML. No hay parámetros,
	 * solo se devuelve el formulario de alta porque no se necesita nada y se pinta dicho formulario.
	 */
	@GetMapping("/alta")
	public String mostrarFormAlta() {
		return "formAlta";
	}
	//--------------------------------------------------------------------------------------------------------------------------------
	/*
	 * Si no se hace el PostMapping de alta no se va a procesar, ya que se llamaría por post a algo que es de get.
	 * Con los parámetros que llegan y coinciden con los atributros de la clase se genera el evento.
	 * Si el método de insertar del daoimpl devuelve 1 (lo ha insertado), devuelve el evento con todo. Se pone un mensaje,
	 * pero en este caso en lugar de model se pone ratt, porque con la parada de la tarea el model se pierde,
	 * por lo que al no ver el atributo mensaje no lo mostraría.
	 * El atributo mensaje no se ve por model sino que el HTML lo ve por ratt y muestra lo que hay.
	 * addFlashAttribute sería un objeto de sesión para esta tarea de crear y para la siguientede rematar.
	 * Para ver que el alta saca el evento con todo se hace un "syso".
	 * Posteriormente se manda el home al navegador.
	 * De un PostMapping no se puede pasar a un GetMapping por forward. Por eso se usa redirect.
	 */
	@PostMapping("/alta")	
	public String procFormAlta(Evento evento, RedirectAttributes ratt) {
		if (edao.insert(evento)==1) {
			ratt.addFlashAttribute("mensaje", "Evento añadido satisfactoriamente");
			System.out.println(evento);
		}else
			ratt.addFlashAttribute("mensaje", "No se ha podido añadir el evento");
		return "redirect:/";
	}
	//--------------------------------------------------------------------------------------------------------------------------------
	/*
	 * Por String llega una fecha pero tengo un date. Para hacer el parse de String a date se especifica una clase en la que 
	 * determina el formato deseado.
	 * La clase SimpleDateFormat crea un formato, y luego a la fecha se le hace un parse y se introduce el String correspondiente.
	 * La clase Date utiliza el formato de new SimpleDateFormat. Si se ve una clase de tipo Date y un String de tipo fecha
	 * hay que transformarlo.
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	//--------------------------------------------------------------------------------------------------------------------------------
	/*
	 * El significado de cancelar en este ejercicio es de modificar solo uno de los atributos, en este caso estado.
	 * Al igual que sucede con eliminar, no es necesario crear un HTML en templates ya que la funcionalidad
	 * tiene lugar al hacer clic en "cancelar" en la página de inicio. Es decir, no se necesita ningún formulario ni,
	 * por tanto, ningún PostMapping. 
	 * Si el evento seleccionado se ha cancelado (devuelve 1 según el método del impl) entonces se informa de su éxito,
	 * y al no figurar más en la lista de activos se hace un syso para comprobar el cambio de estado.
	 * En cualquier caso se vuelve a la página de inicio.
	 */
	@GetMapping("/cancelar/{id}")
	public String cancelarEvento(@PathVariable("id") int idEvento, Model model){
		Evento evento=edao.findById(idEvento);
		
		if (edao.cancelar(idEvento)==1) {
			model.addAttribute("mensaje", "Evento cancelado correctamente");
			System.out.println(evento);
		}
		else
			model.addAttribute("mensaje", "Evento no se ha podido cancelar");
		
		return "forward:/";
	
	}
	
	
}	


