package controladores;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import modelo.Abono;
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

	public Vector<Socio> getSocios() {
		return socios;
	}
	
	
	Socio buscarSocioBuffer (Integer dni){
		
		for (Socio socio : socios) {
			if (socio.getDni() == dni) {
				return socio;
			} else {
				Socio soc = AdminPersistSocio.getInstancia().buscarSocio(dni);
				if (soc == null){
					return null;
				} else {
					socios.addElement(soc);
					return soc;
				}
			}
			
		}
		return null;
	}
	
	Inscripcion buscarInscripBuffer (Integer codigo){
			
			for (Inscripcion inscripcion : inscripciones) {
				if (inscripcion.getCodigo() == codigo) {
					return inscripcion;
				} else {
					Inscripcion insc = AdminPersistInscrip.getInstancia().buscarInscrip(codigo);
					if (insc == null){
						return null;
					} else {
						inscripciones.addElement(insc);
						return insc;
					}
				}
				
			}
			return null;
		}
	
	//Primero, se da de alta al socio
	public Socio altaSocio(Integer dni, String nombre, String apellido, String domicilio, Integer telefono, String mail){
		
		Socio socio = buscarSocioBuffer(dni);
		if (socio == null) {
		
		Socio soc = new Socio(dni, nombre, apellido, domicilio, telefono, mail);
		
		AdminPersistSocio.getInstancia().insert(soc);
		this.socios.addElement(soc);
		
		return soc;
		
		} 
		
		return socio;
	
	}
	
	public void modificarSocio(Integer dni, String nombre, String apellido, String domicilio, Integer telefono, String mail){
		Socio socio = buscarSocioBuffer(dni);
		if (socio == null) {
			System.out.println("El socio no se encuentra registrado en el sistema");
		} else {
			this.socios.removeElement(socio);
			socio.setDomicilio(domicilio);
			socio.setMail(mail);
			socio.setNombre(nombre);
			socio.setApellido(apellido);
			socio.setTelefono(telefono);
			
			AdminPersistSocio.getInstancia().update(socio);
			this.socios.addElement(socio);

			System.out.println("El socio con credencial: "+ dni + " ha sido modificado");
		}
		
	}
	
	public void bajaSocio(Integer dni){
		Socio socio = buscarSocioBuffer(dni);
		if (socio == null) {
			System.out.println("El socio no se encuentra registrado en el sistema");
		} else {
			AdminPersistSocio.getInstancia().delete(socio);
			this.socios.removeElement(socio);
			System.out.println("El socio "+ dni + " ha sido eliminado");
		}
	}

	// Se puede presentar el apto medico del socio en cualquier momento
	public void presentarAptoMedico(Integer dniSocio, String fechaCertificado, String nombreProfesional, String observaciones){
		Socio socio = buscarSocioBuffer(dniSocio);
		if (socio == null) {
			System.out.println("El socio no se encuentra registrado en el sistema");
		} else {
			this.socios.removeElement(socio);
			
			socio.agregarAptoMedico(fechaCertificado, nombreProfesional, observaciones);
			AdminPersistSocio.getInstancia().update(socio);
			this.socios.addElement(socio);
			
			System.out.println("El apto medico del socio con credencial: "+ dniSocio + " ha sido actualizado");
		}
	}


	//Segundo, se elige el tipo de inscripción que va a tener	
	//NOTA: en el front tendra un checkbox que te permitirá hacer visible el campo que desplegara todas las empresas
	public void generarInscripcionCorporativa(Integer dniSocio, Integer codAbono, Integer codEmpresa, Date fecha){
		
		Integer codigo = this.inscripciones.size() + 1 ; //da la cantidad de inscripciones para generar el codigo
		InscripcionCorporativa insc = new InscripcionCorporativa(codigo, dniSocio, codAbono, codEmpresa, fecha);
		inscribirSocio(dniSocio, codigo);
		AdminPersistInscrip.getInstancia().insert(insc);
		this.inscripciones.addElement(insc);
		
	}
	
	public void generarInscripcionNormal(Integer dniSocio, Integer codAbono){
		Integer codigo = this.inscripciones.size() + 1 ; //da la cantidad de inscripciones para generar el codigo
		InscripcionNormal insc = new InscripcionNormal(codigo, dniSocio, codAbono);
		inscribirSocio(dniSocio, codigo);
		AdminPersistInscrip.getInstancia().insert(insc);
		this.inscripciones.addElement(insc);
		
	}
	
	private void inscribirSocio(Integer dniSocio, Integer inscripcion){
		Socio socio = buscarSocioBuffer(dniSocio);
		if (socio == null) {
			System.out.println("El socio no se encuentra registrado en el sistema");
		} else {
			this.socios.removeElement(socio);
			socio.inscribirSocio(inscripcion);
			AdminPersistSocio.getInstancia().update(socio);
			this.socios.addElement(socio);
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
	
	
	
	//metodos para la fachada
	
	public Date obtenerFechaFinAptoMed(Socio socio){
		
		SimpleDateFormat formatter = new SimpleDateFormat("DD-MM-yyyy");    
	    Date date;
		try {
			date = (Date) formatter.parse(socio.getAm().getFechaFin());
		} catch (ParseException e) {
			System.out.println("error de parseo");
			return null;
		}

		
	    return date;
	
	}	

	public Date obtenerFinAbono(Socio socio) {
		
		Inscripcion ins = buscarInscripBuffer(socio.getInscripcion());
		Abono abono = ControladorAdministrativo.getInstancia().buscarAbonoBuffer(ins.getCodigoAbono());
		
		return abono.getVigencia();
	}


}