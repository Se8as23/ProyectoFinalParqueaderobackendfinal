package modelo;
import java.time.LocalTime;
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
	

	private LocalTime horaEntrada ;
	

	private LocalTime horaSalida ;
	
	@OneToOne
	@JoinColumn(name="cli_codigo")
	private Cliente cliente;

	@OneToOne
	@JoinColumn(name="vehi_codigo")
	private Vehiculo vehiculo;
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public LocalTime getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(LocalTime horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public LocalTime getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(LocalTime horaSalida) {
		this.horaSalida = horaSalida;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	@Override
	public String toString() {
		return "Vehiculo [codigo=" + codigo + ", horaEntrada=" + horaEntrada + ", horaSalida=" + horaSalida 
				+ ", cliente=" + cliente + ", vehiculo=" + vehiculo + "]";
	}	
}
