package Controladores;

import java.util.ArrayList;
import java.util.Calendar;

import clases.Abono;
import clases.Empleado;
import clases.Profesor;
import clases.PuestoEmpleado;
import clases.Socio;

public class Administrador {


/* SISTEMA */
	
	public ArrayList<Socio> socios = new ArrayList<Socio>();
	public ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	public ArrayList<Profesor> profesores = new ArrayList<Profesor>();	
	public ArrayList<Abono> abonos = new ArrayList<Abono>();
	
	
	public ArrayList<Abono> getAbonos() {
		return abonos;
	}
	public void setAbonos(ArrayList<Abono> abonos) {
		this.abonos = abonos;
	}
	public ArrayList<Socio> getSocios() {
		return socios;
	}
	public void setSocios(ArrayList<Socio> socios) {
		this.socios = socios;
	}
	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(ArrayList<Empleado> empleados) {
		this.empleados = empleados;
	}
	public ArrayList<Profesor> getProfesores() {
		return profesores;
	}
	public void setProfesores(ArrayList<Profesor> profesores) {
		this.profesores = profesores;
	}
	

/* BUSCADORES */		
	
	public Socio buscarSocio(Integer id){
		for (Socio socio : getSocios()) {
			if (socio.getIdCredencial() == id) {
				return socio;
			}
		} return null;
	}
	
	public Abono buscarAbono(Integer id){
		for (Abono abono : getAbonos()) {
			if (abono.getCodigo() == id) {
				return abono;
			}
		} return null;
	}
	
	public Profesor buscarProfesor(Integer dni){
		for (Profesor profesor : getProfesores()) {
			if (profesor.getDni() == dni) {
				return profesor;
			}
		} return null;
	}
	
	public Empleado buscarEmpleado(Integer dni){
		for (Empleado empleado : getEmpleados()) {
			if (empleado.getDni() == dni) {
				return empleado;
			}
		} return null;
	}
	
	//hacer buscador de empresa
	
	//hacer buscador de días
	
/* SOCIO */	
	
	public Socio altaSocio(String nombre, String domicilio, String telefono, String mail){
		Socio socio = new Socio(nombre, domicilio, telefono, mail);
		return socio;
		
	}
	
	public void inscribirSocio(String nombre, String domicilio, String telefono, String mail){
		Socio socio = altaSocio(nombre, domicilio, telefono, mail);
		//socio.setAbono(new Abono()); -- VER COMO!
		//socio.setIdCredencial(idCredencial); -- VER SI SE CREA UNA CREDENCIAL CON TODO; O ES UN NRO RANDOM
		//socio.setInscripcion(inscripcion);-- VER INSCRIPCIONES
		
		getSocios().add(socio);
		System.out.println("El socio ha sido creado");
	}
	
	public void modificarDatosPersonalesSocio(Integer id, String nombre, String domicilio, String telefono, String mail){
		Socio socio = buscarSocio(id);
		if (socio == null) {
			System.out.println("El socio no se encuentra registrado en el sistema");
		} else {
			socio.setDomicilio(domicilio);
			socio.setMail(mail);
			socio.setNombre(nombre);
			socio.setTelefono(telefono);
			System.out.println("El socio con credencial: "+ id + " ha sido modificado");
		}
		
	}
	
	public void eliminarSocio(Integer id){
		Socio socio = buscarSocio(id);
		getSocios().remove(socio);
		System.out.println("El socio "+ id + " ha sido eliminado");
	}
	
	/*
	 * presentarAptoMedico
	cambiarAbono
	anotarseAClase
	eliminarClase

	 */
	public void presentarAptoMedico(Integer idSocio, String detalle, String profesional){
		Socio socio = buscarSocio(idSocio);
		if (socio == null) {
			System.out.println("El socio no se encuentra registrado en el sistema");
		} else {
			socio.getCerticiado().setFecha(Calendar.getInstance());
			socio.getCerticiado().setObservaciones(detalle);
			socio.getCerticiado().setProfesional(profesional);
			System.out.println("El apto medico del socio con credencial: "+ idSocio + " ha sido actualizado");
		}
	}
	

/* ABONO */	
	
	public void altaAbono(Integer codigo, String nombre, Float precio, Calendar vigencia){
		Abono abono = new Abono(codigo, nombre, precio, vigencia);
		getAbonos().add(abono);
		
	}
	
	public void modificarAbono(Integer codigo, String nombre, Float precio, Calendar vigencia){
		Abono abono = buscarAbono(codigo);
		if (abono == null) {
			System.out.println("El abono no se encuentra registrado en el sistema");
		} else {
		abono.setNombre(nombre);
		abono.setPrecio(precio);
		abono.setVigencia(vigencia);
		System.out.println("El abono ha sido actualizado");
		}
		
	}
	
	public void eliminarAbono(Integer id){
		Abono abono = buscarAbono(id);
		getAbonos().remove(abono);
		System.out.println("El abono "+ id + " ha sido eliminado");
	}


/* PROFESOR */	
	
	//public void altaProfesor
	

/* EMPLEADO */	

	public void altaEmpleado(String nombre, String domicilio, String mail, 
			Integer dni, PuestoEmpleado puesto, Float sueldo){
		Empleado empleado = new Empleado(nombre, domicilio, mail, dni, puesto, sueldo);
		getEmpleados().add(empleado);
	}
	
	public void modificarEmpleado(String nombre,String domicilio, String mail,
			Integer dni, PuestoEmpleado puesto, Float sueldo){
		Empleado empleado = buscarEmpleado(dni);
		empleado.setDni(dni);
		empleado.setDomicilio(domicilio);
		empleado.setMail(mail);
		empleado.setNombre(nombre);
		empleado.setPuesto(puesto);
		empleado.setSueldo(sueldo);
	}
	
	public void eliminarEmpleado(Integer dni){
		Empleado empleado = buscarEmpleado(dni);
		getEmpleados().remove(empleado);
	}
	
}
