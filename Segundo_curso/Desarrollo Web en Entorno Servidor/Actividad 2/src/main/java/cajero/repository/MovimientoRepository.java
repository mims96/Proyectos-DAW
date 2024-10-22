package cajero.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cajero.modelo.entity.Movimiento;

public interface MovimientoRepository extends JpaRepository<Movimiento, Integer>{
	/*
	 * Se va a usar este repositorio para crear un método personalizado que no incluye JPA.
	 * En este caso se realiza para que al mostrar el listado de movimientos solo se muestren los de 
	 * la cuenta actual, no todos los movimientos que figuren en la BBDD.
	 * Se especifica que el parámetro que se desea recibir es el idCuenta
	 */
	@Query("SELECT m FROM Movimiento m WHERE m.cuenta.id = :cuentaId")
    List<Movimiento> buscarCuentaPorId(int cuentaId);
	
}
