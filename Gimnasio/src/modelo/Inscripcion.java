package modelo;

import java.util.ArrayList;

public abstract class Inscripcion {
	protected Integer codigo;
	protected Integer dniSocio; 
	protected Integer codigoAbono;
	protected ArrayList<Actividad> actividades;
	//TODO Falta ver actividades

	
	public Integer getDniSocio() {
		return dniSocio;
	}

	public void setDniSocio(Integer dniSocio) {
		this.dniSocio = dniSocio;
	}

	public ArrayList<Actividad> getActividades() {
		return actividades;
	}

	public void setActividades(ArrayList<Actividad> actividades) {
		this.actividades = actividades;
	}

	public Integer getCodigoAbono() {
		return codigoAbono;
	}

	public void setCodigoAbono(Integer abono) {
		this.codigoAbono = abono;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

}
