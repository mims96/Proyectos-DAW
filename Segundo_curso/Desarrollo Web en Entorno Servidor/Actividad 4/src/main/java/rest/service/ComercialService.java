package rest.service;

import java.util.List;

import rest.modelo.entities.Comercial;

public interface ComercialService {
	//Se crea el CRUD
	Comercial buscarUnComercial(int idComercial);
	List<Comercial> buscarTodosComerciales();
	Comercial altaComercial(Comercial comercial);
	Comercial modificarComercial(Comercial comercial);
	boolean eliminarComercial(int idComercial);
	//Se añaden los métodos del repository.
	List<Comercial> buscarComercialesPorCliente(int idCliente);
	List<Comercial> buscarComercialesConPedidos();
}
