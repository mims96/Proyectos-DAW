package cajero.modelo.dao;

import java.util.Date;
import java.util.List;

import cajero.modelo.entity.Cuenta;
import cajero.modelo.entity.Movimiento;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public interface MovimientoDao {
	List<Movimiento> mostrarTodosMovimientosCuenta(Cuenta cuenta);
	
	int apunteIngreso (Cuenta cuenta, Date fecha, double cantidad, String operacion);
	int apunteExtracción (Cuenta cuenta, Date fecha, double cantidad, String operacion);
	
	int meIngresanPorTransferencia (Cuenta cuenta, Date fecha, double cantidad, String operacion);
	int envioPorTransferencia (Cuenta cuenta, Date fecha, double cantidad, String operacion);
}