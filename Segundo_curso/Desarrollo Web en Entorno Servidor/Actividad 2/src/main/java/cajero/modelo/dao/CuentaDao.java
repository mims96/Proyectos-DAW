package cajero.modelo.dao;

import java.util.List;

import cajero.modelo.entity.Cuenta;

public interface CuentaDao {
	List<Cuenta> buscarTodas ();
	Cuenta buscarUna (int idCuenta);
	int modificarCuenta (Cuenta cuenta);
	Cuenta ingresar (Cuenta cuenta, double saldo);
	Cuenta extraer (Cuenta cuenta, double saldo);
	
}
