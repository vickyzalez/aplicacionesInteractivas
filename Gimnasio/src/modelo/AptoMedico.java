package modelo;

public class AptoMedico {
	private String fechaCertificado;
	private String nombreProfesional;
	private String observaciones;
	private String fechaFin; //una vez que se da de alta el apto médico, tiene una vigencia de un año
	
	public AptoMedico(){
		this.fechaCertificado = "";
		this.nombreProfesional = "";
		this.observaciones = "";
		this.fechaFin = ""; 
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
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	
}
