package clases;

import java.util.Calendar;

public class Certificado {

	private Calendar fecha;
	private String profesional;
	private String observaciones;
	
	public Certificado() {
		this.fecha = null;
		this.profesional = null;
		this.observaciones = null;
	}
	
	public Certificado(Calendar fecha, String profesional, String observaciones) {
		super();
		this.fecha = fecha;
		this.profesional = profesional;
		this.observaciones = observaciones;
	}
	public Calendar getFecha() {
		return fecha;
	}
	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	public String getProfesional() {
		return profesional;
	}
	public void setProfesional(String profesional) {
		this.profesional = profesional;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	


}
