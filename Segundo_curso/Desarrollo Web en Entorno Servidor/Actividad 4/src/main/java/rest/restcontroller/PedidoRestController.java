package rest.restcontroller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rest.modelo.dto.PedidoDto;
import rest.service.PedidoService;

//Se deben especificar las siguientes anotaciones, así como hacer un Autowired con el Service.
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/comercial")
public class PedidoRestController {
	@Autowired
	private PedidoService pedidoService;

	/*
	 * En esta ruta se muestra un listado de los pedidos gestionados por un comercial
	 * concreto, por lo que su id llega por PathVariable.
	 * Como al acceder a los datos de los pedidos se muestra mucha información, ya que Pedidos
	 * tiene acceso tanto a Clientes como a Comerciales, se ha preferido hacer un DTO que muestre
	 * menos campos, por lo que, en verdad, se muestra el listado de PedidoDto.
	 */
	@GetMapping("/pedidos/{id}")
	public List<PedidoDto> listarPedidos(@PathVariable("id") int idComercial) {
	    return pedidoService.buscarPedidosPorComercial(idComercial);
	}

}
