package modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

public class Socio {
	
	private Integer dni;
	private String nombre;
	private String apellido;
	private String domicilio;
	private Integer telefono;
	private String mail;
	private AptoMedico am;
	private Integer codigoIns;
	private Vector<String> mails;
	
	
	public Socio(Integer dni, String nombre, String apellido, String domicilio, Integer telefono, String mail) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.mail = mail;
		this.am = new AptoMedico();
		
	
	}
	
	public void agregarAptoMedico(String fechaCertificado, String nombreProfesional, String observaciones){
		this.am.setFechaCertificado(fechaCertificado);
		this.am.setNombreProfesional(nombreProfesional);
		this.am.setObservaciones(observaciones);
		Calendar fechaFin = Calendar.getInstance();
		fechaFin.add(Calendar.MONTH, 12);
		SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy"); 
		//String currentDate = formatter.format(fechaFin);
		//this.am.setFechaFin(currentDate);
		this.am.setFechaFin(fechaCertificado);
		
	}

	public void inscribirSocio(Integer codigoInscripcion){
		this.codigoIns = codigoInscripcion;

	}
	
	
	
	//Getters & Setters 
	
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
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public AptoMedico getAm() {
		return am;
	}
	public void setAm(AptoMedico am) {
		this.am = am;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public Integer getInscripcion() {
		return codigoIns;
	}

	public Integer getCodigoIns() {
		return codigoIns;
	}

	public void setCodigoIns(Integer codigoIns) {
		this.codigoIns = codigoIns;
	}

	public void recibirMail(String mail){
		this.mails.addElement(mail);
	}
}
