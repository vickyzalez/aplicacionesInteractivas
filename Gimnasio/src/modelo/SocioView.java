package modelo;

import java.util.Iterator;

import controladores.*;

public class SocioView {

	private Integer dni;
	private String nombre;
	private String apellido;
	private String domicilio;
	private int telefono;
	private String mail;
	private AptoMedico am;
	
	
	public SocioView (int dni, String nombre, String apellido, String domicilio, int telefono, String mail) {
	    this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.mail = mail;
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
