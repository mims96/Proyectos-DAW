package rest.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rest.modelo.entities.Comercial;
import rest.service.ComercialService;

/*
 * Al tratarse de un servicio rest en el que se manejan datos se anota como RestController.
 * Además, se acepta cualquier tipo de origen.
 * Las rutas que figuran en este controlador tienen el principio común con RequestMapping.
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/comercial")
public class ComercialRestController {
	//Conectamos con el Service del comercial.
	@Autowired
	private ComercialService comercialService;
	
	//Esta ruta devuelve el listado completo de todos los comerciales.
	@GetMapping("")
	public List<Comercial> todos(){
		return comercialService.buscarTodosComerciales();
	}
	
	//Se inserta un comercial cuyos datos llegan por RequestBody, que es lo que introducen en el Postman.
	@PostMapping("/alta")
	public Comercial alta(@RequestBody Comercial comercial) {
		return comercialService.altaComercial(comercial);
	}
	
	/*
	 * Se va a eliminar un comercial en función de su id, que llega por PathVariable 
	 * y se especifica a qué parámetro (idComercial) hace referencia el id de la url.
	 * Si el método del service es true, por debajo se elimina y muestra por pantalla el mensaje de éxito.
	 * De lo contrario se enseña el mensaje de que no se ha podido eliminar.
	 */
	@DeleteMapping("/eliminar/{id}")
	public String eliminar(@PathVariable ("id") int idComercial){
		if (comercialService.eliminarComercial(idComercial))
			return "Comercial eliminado correctamente";
		else
			return "Comercial NOOO se ha podido eliminar";	
	}
	
	//Ahora se busca un comercial cuyo id llega por PathVariable, mostrándose sus datos.
	@GetMapping("/uno/{id}")
	public Comercial uno(@PathVariable ("id") int idComercial){
		return comercialService.buscarUnComercial(idComercial);	
	}
	
	//Se muestra un listado de comerciales que hayan atendido a un cliente específico.
	//Se necesita saber por PathVariable el idCliente.
	@GetMapping("/bycliente/{id}")
	public List<Comercial> listadoPedidosConCliente(@PathVariable ("id") int idCliente){
		return comercialService.buscarComercialesPorCliente(idCliente);
	}
	
	//Se muestra el listado de comerciales que hayan atendido al menos un pedido. No se necesita 
	//ningún parámetro extra.
	@GetMapping("/conpedidos")
	public List<Comercial> listarComercialesConPedidos(){
		return comercialService.buscarComercialesConPedidos();
	}
	
	
}
