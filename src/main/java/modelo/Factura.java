package modelo;

import java.util.Date;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Factura {
	
	@Id
	@Column(name ="fac_codigo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	
	@Column(name="fac_numero")
	private String numeroFactura;
	
	@Column(name="fac_fecha")
	private Date fechaFactura;
	
	@Column(name="fac_total")
	private float total;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="cli_cedula")
	private Cliente cliente;
	
	@ManyToOne(cascade = CascadeType.ALL ,  fetch = FetchType.EAGER)
	@JoinColumn(name="tick_codigo")
	private Ticket ticket;
	
	@ManyToOne(cascade = CascadeType.ALL ,  fetch = FetchType.EAGER)
	@JoinColumn(name="tar_codigo")
	private Tarifa tarifa;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public Date getFechaFactura() {
		return fechaFactura;
	}

	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}

	public float getTotal() {
		return total;
	}
	
	public void setTotal(float total) {
		this.total = total;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Tarifa getTarifa() {
		return tarifa;
	}

	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	

	@Override
	public String toString() {
		return "Factura [codigo=" + codigo + ", numeroFactura=" + numeroFactura + ", fechaFactura=" + fechaFactura + ", total=" + total +
				", cliente=" + cliente + ", cliente2=" + ", ticket=" + ticket + ", tarifa=" + tarifa + "]";
	}
}
