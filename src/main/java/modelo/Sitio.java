package modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Sitio {

	@Id
	@GeneratedValue
	@Column(name="sit_codigo")
	private int codigo;
	
	@Column(name="sit_ubicacion")
	private int lugares = 20;
	
	@Column(name="sit_lugar")
	private boolean lugar;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getUbicacion() {
		return lugares;
	}

	public void setUbicacion(int lugares) {
		this.lugares = lugares;
	}

	public boolean getLugar() {
		return lugar;
	}

	public void setLugar(boolean lugar) {
		this.lugar = lugar;
	}

	@Override
	public String toString() {
	return "Sitio [codigo=" + codigo + ", lugares=" + lugares+ ", lugar=" + lugar + "]";
	}	
}

