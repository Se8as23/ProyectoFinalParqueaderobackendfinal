package modelo;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Ticket {
	
	@Id
	@Column(name ="tick_codigo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	
	@Column(name="tick_horaE")
	private Date horaEntrada ;
	
	@Column(name="tick_horaS")
	private Date horaSalida ;
	
	@OneToOne
	@JoinColumn(name="cli_codigo")
	private Cliente cliente;

	@OneToOne
	@JoinColumn(name="sit_codigo")
	private Sitio sitio;
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(Date horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public Date getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(Date horaSalida) {
		this.horaSalida = horaSalida;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Sitio getSitio() {
		return sitio;
	}

	public void setSitio(Sitio sitio) {
		this.sitio = sitio;
	}

	@Override
	public String toString() {
		return "Vehiculo [codigo=" + codigo + ", horaEntrada=" + horaEntrada + ", horaSalida=" + horaSalida 
				+ ", cliente=" + cliente + ", vehiculo=" + "]";
	}	
}
