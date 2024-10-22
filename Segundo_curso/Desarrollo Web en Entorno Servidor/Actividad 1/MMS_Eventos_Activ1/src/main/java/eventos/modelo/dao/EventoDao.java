package eventos.modelo.dao;

import java.util.List;

import eventos.modelo.javabeans.Evento;

/*
 * Se crea un interface que es independiente de la localización de los datos.
 * Se crean los métodos del CRUD, el buscar todos y el buscar los eventos activos que serán posteriormente implementados:
 */
public interface EventoDao {
	//Se indica el idEvento y se obtiene el evento entero.
	Evento findById (int idEvento);
	
	//Para obtener la lista completa de eventos:
	List<Evento> findAll();
	
	//Para dar de alta, especifico el evento y cuando se obtenga el campo autonumérico devuelve un entero.
	int insert (Evento evento);
	
	//Para borrar un evento, se pasa el identificador de dicho evento y se devuelve un entero que indica si se ha borrado o no.
	int delete (int idEvento);

	//Para modificar el estado de un evento, se indica el id y se devuelve un entero en función de si se ha cancelado o no.
	int cancelar (int idEvento);
	
	//Este método devuelve una lista completa pero solo con los eventos activos.
	List<Evento> findActivos();
	
}
