package modelo;

import java.util.Vector;

public abstract class Actividad {
	protected Integer idActividad;
	protected Integer idDeporte;
	protected String descripcion;
	protected Vector<ClaseAct> clases;
	
	public Integer getIdActividad() {
		return idActividad;
	}
	public void setIdActividad(Integer idActividad) {
		this.idActividad = idActividad;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Vector<ClaseAct> getClases() {
		return clases;
	}
	public void setClases(Vector<ClaseAct> clases) {
		this.clases = clases;
	}
	public Integer getIdDeporte() {
		return idDeporte;
	}
	public void setIdDeporte(Integer idDeporte) {
		this.idDeporte = idDeporte;
	}

	
	
	
}
