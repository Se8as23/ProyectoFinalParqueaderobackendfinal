package modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tarifa {
	
	@Id
	@Column(name ="tar_codigo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	
	@Column(name="tar_tarifaAuto", nullable = false)
	private double tarifaAuto;
	
	@Column(name="tar_tarifaMoto", nullable = false)
	private double tarifaMoto;
	

	
	@Column(name="tar_precio", nullable = false)
	private float precio;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getTarifaAuto() {
		return tarifaAuto;
	}

	public void setTarifaAuto(double tarifaAuto) {
		this.tarifaAuto = tarifaAuto;
	}

	public double getTarifaMoto() {
		return tarifaMoto;
	}

	public void setTarifaMoto(double tarifaMoto) {
		this.tarifaMoto = tarifaMoto;
	}


	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
	@Override
	public String toString() {
		return "Tarifa [codigo=" + codigo + ", tarifaAuto=" + tarifaAuto + ", tarifaMoto=" + tarifaMoto + ", totalAuto="  + ", totalMoto =" + ", precio=" + precio + "]";
	}

}
