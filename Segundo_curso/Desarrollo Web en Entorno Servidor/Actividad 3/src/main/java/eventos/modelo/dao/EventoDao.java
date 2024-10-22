package eventos.modelo.dao;

import java.util.List;

import eventos.modelo.entitis.Evento;
/*
 * Se crea un interface que es independiente de la localización de los datos.
 * Estos métodos serán posteriomente implementados.
 */
public interface EventoDao {
	Evento buscarEventoPorId (int idEvento);
	List<Evento> buscarTodos();
	List<Evento> findActivos();
	List<Evento> findDestacados();
	List <Evento> findActivosDestacados();
	List<Evento> buscarPorTipo(String tipo);
	
}
