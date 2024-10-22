package rest.modelo.dto;

import java.util.Date;

public class PedidoDto {
	/*
	 * Como al realizar la ruta de GetMapping "/pedidos/{id}" mostraba en el Postman
	 * demasiados datos para la lista de pedidos, se ha decidido crear un DTO para
	 * mostrar solo la información concerniente a los pedidos, por lo que no
	 * se muestra información ni del comercial ni del cliente más allá de sus
	 * identificadores.
	 */
	private int idPedido;
	private double total;
	private Date fecha;
	private int idCliente;
	private int idComercial;
	
	//Para poder aplicar correctamente la query se ha creado el constructor con todos los parámetros.
	public PedidoDto(int idPedido, double total, Date fecha, int idCliente, int idComercial) {
		super();
		this.idPedido = idPedido;
		this.total = total;
		this.fecha = fecha;
		this.idCliente = idCliente;
		this.idComercial = idComercial;
	}
	public PedidoDto() {
		super();
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
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdComercial() {
		return idComercial;
	}
	public void setIdComercial(int idComercial) {
		this.idComercial = idComercial;
	}
}
