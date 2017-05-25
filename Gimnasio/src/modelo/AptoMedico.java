package modelo;

public class AptoMedico {
	private String fechaCertificado;
	private String nombreProfesional;
	private String observaciones;
	
	public AptoMedico(){
		this.fechaCertificado = null;
		this.nombreProfesional = null;
		this.observaciones = null;
	}	
	public AptoMedico(String fechaCertificado, String nombreProfesional, String observaciones) {
		super();
		this.fechaCertificado = fechaCertificado;
		this.nombreProfesional = nombreProfesional;
		this.observaciones = observaciones;
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
