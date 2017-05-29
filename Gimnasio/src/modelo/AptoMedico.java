package modelo;

import java.util.Calendar;

public class AptoMedico {
	private String fechaCertificado;
	private String nombreProfesional;
	private String observaciones;
	private Calendar fechaFin; //una vez que se da de alta el apto médico, tiene una vigencia de un año
	
	public AptoMedico(){
		this.fechaCertificado = null;
		this.nombreProfesional = null;
		this.observaciones = null;
		this.fechaFin = Calendar.getInstance();
		fechaFin.add(Calendar.MONTH, 12);
	}	
	public AptoMedico(String fechaCertificado, String nombreProfesional, String observaciones) {
		super();
		this.fechaCertificado = fechaCertificado;
		this.nombreProfesional = nombreProfesional;
		this.observaciones = observaciones;
		this.fechaFin = Calendar.getInstance();
		fechaFin.add(Calendar.MONTH, 12);
	}

	public String getFechaCertificado() {
		return fechaCertificado;
	}

	public void setFechaCertificado(String fechaCertificado) {
		this.fechaCertificado = fechaCertificado;
	}

	public String getNombreProfesional() {
		return nombreProfesional;
	}

	public void setNombreProfesional(String nombreProfesional) {
		this.nombreProfesional = nombreProfesional;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
}
