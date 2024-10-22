package eventos.modelo.dao;

import java.util.List;

import eventos.modelo.javabeans.Evento;
import eventos.modelo.javabeans.Tipo;

/*
 * Se crea un interface ahora para Tipo.
 * Se crean los métodos buscar por identificador y buscar todos, que serán posteriormente implementados:
 */
public interface TipoDao {
	//Se pasa el idTipo y se obtiene el tipo entero.
	Tipo findById (int idTipo);
	
	//Para obtener la lista completa de tipos:
	List<Tipo> findAll();
	
}
