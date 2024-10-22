package eventos.modelo.dao;

import java.util.List;

import org.springframework.data.repository.query.Param;

import eventos.modelo.entitis.Evento;
import eventos.modelo.entitis.Reserva;

public interface ReservaDao {
	Reserva buscarReservaPorId (int idReserva);
	int cancelar (int idReserva);
	List<Reserva> buscarTodos();
	Reserva altaReserva (Reserva reserva);
	List<Reserva> listarReservasPorUsuario(String username);
	List<Reserva> listarReservasPorUsuarioYFecha(String username);
	Integer totalReservasPorEvento(int idEvento);
	Integer totalReservasUserPorEvento (int idEvento, String username);
}
