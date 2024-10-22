package eventos.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import eventos.modelo.entitis.Evento;
import eventos.modelo.entitis.Tipo;
//Para el ejercicio se necesita la conexión a la BBDD, y eso lo aporta el repositorio.
public interface EventoRepository extends JpaRepository<Evento, Integer>{
	/*
	 * Se va a usar el repositorio para crear métodos personalizados que no incluye JPA.
	 * En este caso, se van a buscar eventos que cumplan con una serie de condiciones concretas,
	 * devolviendo listas con los eventos que satisfagan dichas condiciones.
	 */
	@Query("SELECT e FROM Evento e WHERE e.estado=?1 AND e.destacado=?2")
	public List<Evento> findByEstadoAndDestacado(String estado, String destacado);
	
	@Query("SELECT e FROM Evento e WHERE e.estado=?1")
	public List<Evento> findByEstado(String estado);
	
	@Query("SELECT e FROM Evento e WHERE e.destacado=?1")
	public List<Evento> findByDesta(String destacado);
	
	@Query("SELECT e FROM Evento e WHERE e.tipo.nombre = ?1")
	public List<Evento> findByTipo(String nombre);

}
