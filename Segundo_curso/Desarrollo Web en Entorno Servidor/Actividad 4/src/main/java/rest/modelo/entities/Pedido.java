package rest.modelo.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

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

@Entity
@Table(name="pedidos")
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pedido")
	private int idPedido;
	private double total;
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="id_comercial")
	private Comercial comercial;

	public Pedido() {
		super();
	}

	public Pedido(int idPedido, double total, Date fecha, Cliente cliente, Comercial comercial) {
		super();
		this.idPedido = idPedido;
		this.total = total;
		this.fecha = fecha;
		this.cliente = cliente;
		this.comercial = comercial;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Comercial getComercial() {
		return comercial;
	}

	public void setComercial(Comercial comercial) {
		this.comercial = comercial;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", total=" + total + ", fecha=" + fecha + ", cliente=" + cliente
				+ ", comercial=" + comercial + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPedido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return idPedido == other.idPedido;
	}
	
	
	

}
