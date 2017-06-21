package controladores;

import java.sql.Date;
import java.util.Vector;

import modelo.Inscripcion;
import modelo.InscripcionCorporativa;
import modelo.InscripcionNormal;
import modelo.Socio;
import persistencia.AdminPersistInscrip;
import persistencia.AdminPersistSocio;

public class ControladorSocios {
	private static ControladorSocios instancia;
	private Vector<Socio> socios;
	private Vector<Inscripcion> inscripciones;


	public ControladorSocios(){
		this.socios = AdminPersistSocio.getInstancia().selectAll();
		this.inscripciones = AdminPersistInscrip.getInstancia().selectAll();
	}

	// Singleton
	public static ControladorSocios getInstancia(){
		if (instancia == null){
			instancia = new ControladorSocios();
		}
		return instancia;
	}
	
	
	//Primero, se da de alta al socio
	public Socio altaSocio(Integer dni, String nombre, String apellido, String domicilio, Integer telefono, String mail){
		Socio socio = new Socio(dni, nombre, apellido, domicilio, telefono, mail);
		
		AdminPersistSocio.getInstancia().insert(socio);
		return socio;
	
	}
	
	public void modificarSocio(Integer dni, String nombre, String apellido, String domicilio, Integer telefono, String mail){
		Socio socio = AdminPersistSocio.getInstancia().buscarSocio(dni);
		if (socio == null) {
			System.out.println("El socio no se encuentra registrado en el sistema");
		} else {
			socio.setDomicilio(domicilio);
			socio.setMail(mail);
			socio.setNombre(nombre);
			socio.setApellido(apellido);
			socio.setTelefono(telefono);
			
			AdminPersistSocio.getInstancia().update(socio);
			System.out.println("El socio con credencial: "+ dni + " ha sido modificado");
		}
		
	}
	
	public void bajaSocio(Integer dni){
		Socio socio = AdminPersistSocio.getInstancia().buscarSocio(dni);
		if (socio == null) {
			System.out.println("El socio no se encuentra registrado en el sistema");
		} else {
			AdminPersistSocio.getInstancia().delete(socio);
			System.out.println("El socio "+ dni + " ha sido eliminado");
		}
	}

	// Se puede presentar el apto mÃ©dico del socio en cualquier momento
	public void presentarAptoMedico(Integer dniSocio, String fechaCertificado, String nombreProfesional, String observaciones){
		Socio socio = AdminPersistSocio.getInstancia().buscarSocio(dniSocio);
		if (socio == null) {
			System.out.println("El socio no se encuentra registrado en el sistema");
		} else {
			socio.agregarAptoMedico(fechaCertificado, nombreProfesional, observaciones);
			AdminPersistSocio.getInstancia().update(socio);
			System.out.println("El apto medico del socio con credencial: "+ dniSocio + " ha sido actualizado");
		}
	}


	//Segundo, se elige el tipo de inscripción que va a tener	
	//NOTA: en el front tendrá un checkbox que te permitirá hacer visible el campo que desplegará todas las empresas
	public void generarInscripciónCorporativa(Integer dniSocio, Integer codAbono, Integer codEmpresa, Date fecha){
		
		Integer codigo = this.inscripciones.size() + 1 ; //da la cantidad de inscripciones para generar el codigo
		InscripcionCorporativa insc = new InscripcionCorporativa(codigo, dniSocio, codAbono, codEmpresa, fecha);
		inscribirSocio(dniSocio, codigo);
		AdminPersistInscrip.getInstancia().insert(insc);
		
	}
	
	public void generarInscripciónNormal(Integer dniSocio, Integer codAbono){
		Integer codigo = this.inscripciones.size() + 1 ; //da la cantidad de inscripciones para generar el codigo
		InscripcionNormal insc = new InscripcionNormal(codigo, dniSocio, codAbono);
		inscribirSocio(dniSocio, codigo);
		AdminPersistInscrip.getInstancia().insert(insc);
		
	}
	
	private void inscribirSocio(Integer dniSocio, Integer inscripcion){
		Socio socio = AdminPersistSocio.getInstancia().buscarSocio(dniSocio);
		if (socio == null) {
			System.out.println("El socio no se encuentra registrado en el sistema");
		} else {
			socio.inscribirSocio(inscripcion);
			AdminPersistSocio.getInstancia().update(socio);
		}
	}
	
	//Tercero, se anotarÃ¡ a todas las actividades que desee
	//TODO iscribir actividades
//	public void inscribirAActividades(Integer dniSocio, ArrayList<Actividad> actividades){
//		Socio socio = buscarSocio(dniSocio);
//		if (socio == null) {
//			System.out.println("El socio no se encuentra registrado en el sistema");
//		} else {	
//		for (Actividad a: actividades){
//			socio.getInscripcion().agregarActividad(a);
//		}
//	}
//	}
	
	//TODO validar, es la fachada del socio
}