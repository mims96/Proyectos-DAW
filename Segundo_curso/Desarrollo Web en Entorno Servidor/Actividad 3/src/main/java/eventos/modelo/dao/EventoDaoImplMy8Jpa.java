package eventos.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import eventos.modelo.entitis.Evento;
import eventos.modelo.repository.EventoRepository;

//Se especifica que es un repositorio de datos para que el Autowired lo encuentre.
@Repository
public class EventoDaoImplMy8Jpa implements EventoDao{
	/*
	 * La fuente de datos es el repositorio, que establece la conexión con la BBDD
	 * para traer información. Se invoca un método privado del tipo EventoRepository.
	 */
	@Autowired
	private EventoRepository erepo;
	
	//Se implementan los métodos:

	//El findById devuelve un optional. Si el evento existe lo devuelve, y sino se devuelve un null, 
	//como se especifica en el orElse.
	@Override
	public Evento buscarEventoPorId(int idEvento) {
		return erepo.findById(idEvento).orElse(null);
	}

	//El método findAll del JpaRepository aporta una lista de Eventos.
	@Override
	public List<Evento> buscarTodos() {
		return erepo.findAll();
	}

	//Mediante la query escrita en el repository, se especifica que en la lista que saque
	//el estado debe ser 'activo' y que sí es destacado.
	@Override
	public List<Evento> findActivosDestacados() {
		return erepo.findByEstadoAndDestacado("ACTIVO", "S");
	}

	//Lógica similar, pero solamente con el estado activo.
	@Override
	public List<Evento> findActivos() {
		return erepo.findByEstado("ACTIVO");
	}

	//Lógica similar, pero solamente con los eventos destacados.
	@Override
	public List<Evento> findDestacados() {
		return erepo.findByDesta("S");
	}

	//Se devuelve un listado de eventos en función del tipo de evento.
	public List<Evento> buscarPorTipo(String tipo) {
        return erepo.findByTipo(tipo);
    }

	


				


}
