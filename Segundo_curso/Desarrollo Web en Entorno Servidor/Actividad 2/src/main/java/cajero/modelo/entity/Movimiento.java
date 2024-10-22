package cajero.modelo.entity;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//La lógica es la misma que en Cuenta.java
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="movimientos")
public class Movimiento {
	//El siguiente parámetro es la clave principal, se autoincrementa, y hay que relacionar con el nombre de su columna en la BBDD.
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id_movimiento")
	private int idMovimiento;
	
	//Como son muchos movimientos a una cuenta, entonces:
	@ManyToOne
	//Además, en la BBDD están unidas las tablas por la columna:
	@JoinColumn(name="id_cuenta")
	private Cuenta cuenta;
	
	//El date de MySQL almacena tanto fecha como hora, por lo tanto:
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	private double cantidad;
	private String operacion;
	
}
