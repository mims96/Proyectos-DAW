package rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rest.modelo.dto.PedidoDto;
import rest.repository.PedidoRepository;

//Importante anotar:
@Service
public class PedidoServiceImplMy8Jpa implements PedidoService{
	//Se realiza la conexión con el repository.
	@Autowired
	private PedidoRepository pedidoRepository;

	//El método muestra los pedidos de un comercial en concreto.
	@Override
	public List<PedidoDto> buscarPedidosPorComercial(int idComercial) {
		return pedidoRepository.findPedidosByCommercial(idComercial);
	}

}
