package cajero.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cajero.modelo.entity.Cuenta;

//Para este ejercicio se necesita la conexión a la BBDD, y eso lo aporta el repositorio:
public interface CuentaRepository extends JpaRepository<Cuenta, Integer>{

}
