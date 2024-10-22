package rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rest.modelo.dto.PedidoDto;
import rest.modelo.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
	/*
	 * Se crea un objeto DTO en el que se seleccionan los parámetros del constructor de dicho DTO,
	 * ordenados tal cual aparecen en esa clase que hace referencia a la tabla Pedidos.
	 * Se filtran los pedidos en función el idComercial del comercial que está en la tabla y llega 
	 * por PathVariable.
	 * Por tanto, el método devuelve una lista de Pedido con los parámetros del DTO según el comercial.
	 */
	@Query("select new rest.modelo.dto.PedidoDto(p.idPedido, p.total, p.fecha, p.cliente.idCliente, p.comercial.idComercial) from Pedido p where p.comercial.idComercial = ?1")
	public List<PedidoDto> findPedidosByCommercial(int idComercial);

}
