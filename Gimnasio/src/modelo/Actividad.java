package modelo;

import java.util.Vector;

public abstract class Actividad {
	protected Integer idActividad;
	protected String descripcion;
	protected Vector<Clase> clases;
	
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
	public Vector<Clase> getClases() {
		return clases;
	}
	public void setClases(Vector<Clase> clases) {
		this.clases = clases;
	}

	
	
	
}
