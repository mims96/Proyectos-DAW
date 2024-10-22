package eventos.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import eventos.modelo.entitis.Evento;
import eventos.modelo.entitis.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Integer>{
	//Se van a sumar la cantidad de reservas de un evento concreto según su id.
	@Query("SELECT SUM(r.cantidad) FROM Reserva r WHERE r.evento.id = ?1")
	public Integer totalReservationsForEvent(int idEvento);
	
	//Se van a sumar la cantidad de reservas en función de un determinado evento y un usuario concreto,
	//según el id y el username, respectivamente.
	@Query("SELECT SUM(r.cantidad) FROM Reserva r WHERE r.evento.id = ?1 AND r.usuario.username = ?2")
	public Integer totalReservationsUserForEvent(int idEvento, String username);
	
	//Se buscan las reservas de un determinado usuario.
	@Query("SELECT r FROM Reserva r WHERE r.usuario.username = ?1")
    public List<Reserva> findReservasByUsername(String username);
	
	//Se buscan las reservas de un determinado usuario siempre que la fecha de inicio sea mayor que la fecha actual.
	@Query("SELECT r FROM Reserva r WHERE r.usuario.username = ?1 AND r.evento.fechaInicio > CURRENT_DATE")
	public List<Reserva> findReservasByUsernameAndFechaMayor(String username);


}
	
	
	

