package controladores;

import java.util.ArrayList;
import java.util.Calendar;

import modelo.Abono;
import modelo.Empleado;
import modelo.Profesor;
import modelo.PuestoEmpleado;
import modelo.Socio;

public class Administrador {

/*
	 SISTEMA  - Esto pasa a ser la clase Sistema

	public ArrayList<Socio> socios = new ArrayList<Socio>();
	public ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	public ArrayList<Profesor> profesores = new ArrayList<Profesor>();	
	public ArrayList<Abono> abonos = new ArrayList<Abono>();



	 BUSCADORES 		



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



	 ABONO 	

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


	 PROFESOR 	

	//public void altaProfesor


	 EMPLEADO 	

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
	}*/
	
}
