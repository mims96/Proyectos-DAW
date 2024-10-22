package cajero.modelo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Se incorporan las anotaciones del Lombok para el constructor sin parámetros, el constructor con todos los parámetros y para englobar
//los getter y setter, el toString, el Equals y el hashCode.
@NoArgsConstructor
@AllArgsConstructor
@Data
//Como se trata de una entidad hay que anotarlo adecuadamente:
@Entity
//El equivalente de esta entidad en la tabla de la base de datos es:
@Table(name="cuentas")
public class Cuenta {
	//El siguiente parámetro es la clave principal, se autoincrementa, y hay que relacionar con el nombre de su columna en la BBDD.
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id_cuenta")
	private int idCuenta;
	
	private double saldo;
	
	@Column(name="tipo_cuenta")
	private String tipoCuenta;
}
