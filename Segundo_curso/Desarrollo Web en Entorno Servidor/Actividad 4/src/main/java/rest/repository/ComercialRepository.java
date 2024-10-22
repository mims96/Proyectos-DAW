package rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rest.modelo.entities.Comercial;

public interface ComercialRepository extends JpaRepository<Comercial, Integer>{
	//Se han necesitado realizar las siguientes consultas a BBDD que no figuran en JpaRepository:
	
	/*
	 * Para evitar alguna duplicidad de comerciales nos aseguramos con select distinct.
	 * Como la tabla pedidos es la única que cuenta con referecias o claves a las otras tablas,
	 * la consulta se realiza desde ahí. Por eso se seleccionan los comerciales únicos donde 
	 * el identificador del cliente es el que llega por parámetro.
	 * 
	 * El método devuelve una lista de comerciales en función del idCliente.
	 */
	@Query("select distinct p.comercial from Pedido p where p.cliente.idCliente = ?1")
	public List<Comercial>findCommercialByCustomer(int idCliente);
	
	/*
	 * Se seleccionan todos los comerciales en los que exista al menos 1 registro
	 * en la tabla pedido, donde el comercial asociado al pedido solo se anota en la lista 
	 * si contiene algún pedido.
	 */
	@Query("select c from Comercial c where exists (select 1 from Pedido p where p.comercial = c)")
	public List<Comercial>findCommercialsWithOrders();
	
}
