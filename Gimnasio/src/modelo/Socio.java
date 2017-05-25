package modelo;

import modelo.AptoMedico;

public class Socio {
	
	private Integer dni;
	private String nombre;
	private String apellido;
	private String domicilio;
	private int telefono;
	private String mail;
	private AptoMedico am;
	
	
	public Socio(int dni, String nombre, String apellido, String domicilio, int telefono, String mail) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.mail = mail;
		this.am = new AptoMedico();
	}
	public void AgregarAptoMedico(String fechaCertificado, String nombreProfesional, String observaciones){
		this.am.setFechaCertificado(fechaCertificado);
		this.am.setNombreProfesional(nombreProfesional);
		this.am.setObservaciones(observaciones);
	}
	public Integer getDni() {
		return this.dni;
	}
	public void setIdCredencial(int dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	


}
