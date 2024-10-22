package rest.service;

import java.util.List;

import rest.modelo.dto.PedidoDto;

public interface PedidoService {
	//Se necesita este método del repository
	List<PedidoDto>buscarPedidosPorComercial(int idComercial);
}
