package eventos.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import eventos.modelo.entitis.Evento;
import eventos.modelo.entitis.Reserva;
import eventos.modelo.repository.EventoRepository;
import eventos.modelo.repository.ReservaRepository;

@Repository
public class ReservaDaoImplMy8Jpa implements ReservaDao{
	@Autowired
	private ReservaRepository rrepo;
	
	@Override
	public Reserva buscarReservaPorId(int idReserva) {
		return rrepo.findById(idReserva).orElse(null);
	}
	
	/*
	 * En el contexto de este ejercicio cancelar implica eliminar.
	 * Si al buscar una reserva por su id y esta existe, entonces se elimina y se devuelve 1.
	 * Si no existe entonces no se puede eliminar y se devuelve 0.
	 */
	@Override
	public int cancelar(int idReserva) {
		if (buscarReservaPorId(idReserva) != null) {
			rrepo.deleteById(idReserva);
			return 1;
		}else
			return 0;
	}

	//Este método es un findAll para devolver el listado completo de reservas.
	@Override
	public List<Reserva> buscarTodos() {
		return rrepo.findAll();
	}

	/*
	 * Se va a dar de alta una reserva. Para no levantar excepciones se realiza un try-catch.
	 * Si sale bien, entonces se guarda la reserva.
	 * De lo contrario se imprime por consola la traza del error y se devuelve null.
	 */
	@Override
	public Reserva altaReserva(Reserva reserva) {
		try {
			return rrepo.save(reserva);
		}catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	/*
	 * Los siguientes métodos serán usados para dar salida a las querys del repositorio en función de lo que
	 * deba recuperarse: las reservas de un usuario; las reservas de un usuario cuya fecha sea superior a la actual;
	 * las reservas totales para un evento; las reservas totales de un usuario para un evento determinado.
	 */
	@Override
	public List<Reserva> listarReservasPorUsuario(String username) {
		return rrepo.findReservasByUsername(username);
	}
	
	public List<Reserva> listarReservasPorUsuarioYFecha(String username) {
	    return rrepo.findReservasByUsernameAndFechaMayor(username);
	}

	@Override
	public Integer totalReservasPorEvento(int idEvento) {
		return rrepo.totalReservationsForEvent(idEvento);
	}

	@Override
	public Integer totalReservasUserPorEvento(int idEvento, String username) {
		return rrepo.totalReservationsUserForEvent(idEvento, username);
	}


	
}
