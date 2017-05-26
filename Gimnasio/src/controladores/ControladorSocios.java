package controladores;

import java.util.ArrayList;

import modelo.Actividad;
import modelo.Inscripcion;
import modelo.Socio;

public class ControladorSocios {
	private static ControladorSocios instancia;
	private ArrayList<Socio> socios;


	public ControladorSocios(){

		this.socios = new ArrayList<Socio>(0);
	}

	// Singleton
	public static ControladorSocios getInstancia(){
		if (instancia == null){
			instancia = new ControladorSocios();
		}
		return instancia;
	}
public boolean AgregarSocio(Socio s){
	return this.socios.add(s);
}

public boolean EliminarSocio(Socio s){
return this.socios.remove(s);
}

public Socio buscarSocio(Integer id){
	for (Socio socio : this.socios) {
		if (socio.getDni() == id) {
			return socio;
		}
	} return null;
}

//Primero, se dará de alta al socio
public Socio altaSocio(int dni, String nombre, String apellido, String domicilio, int telefono, String mail){
	Socio socio = new Socio(dni, nombre, apellido, domicilio, telefono, mail);
	AgregarSocio(socio);
	return socio;

}

/*public void inscribirSocio(int dni, String nombre, String apellido, String domicilio, int telefono, String mail){
	Socio socio = altaSocio(nombre, domicilio, telefono, mail);
	//socio.setAbono(new Abono()); -- VER COMO!
	//socio.setIdCredencial(idCredencial); -- VER SI SE CREA UNA CREDENCIAL CON TODO; O ES UN NRO RANDOM
	//socio.setInscripcion(inscripcion);-- VER INSCRIPCIONES

	getSocios().add(socio);
	System.out.println("El socio ha sido creado");
}*/


//Segundo, se eligirá el tipo de inscripción que va a tener
public void inscribirSocio(Integer dniSocio, Inscripcion inscripcion){
	Socio socio = buscarSocio(dniSocio);
	if (socio == null) {
		System.out.println("El socio no se encuentra registrado en el sistema");
	} else {
		socio.setInscripcion(inscripcion);
	}
}

//Tercero, se anotará a todas las actividades que desee
public void inscribirAActividades(Integer dniSocio, ArrayList<Actividad> actividades){
	Socio socio = buscarSocio(dniSocio);
	if (socio == null) {
		System.out.println("El socio no se encuentra registrado en el sistema");
	} else {	
	for (Actividad a: actividades){
		socio.getInscripcion().agregarActividad(a);
	}
}
}

public void modificarSocio(Integer dni, String nombre, String apellido, String domicilio, Integer telefono, String mail){
	Socio socio = buscarSocio(dni);
	if (socio == null) {
		System.out.println("El socio no se encuentra registrado en el sistema");
	} else {
		socio.setDomicilio(domicilio);
		socio.setMail(mail);
		socio.setNombre(nombre);
		socio.setApellido(apellido);
		socio.setTelefono(telefono);
		System.out.println("El socio con credencial: "+ dni + " ha sido modificado");
	}
	
}

public void bajaSocio(Integer dniSocio){
	Socio socio = buscarSocio(dniSocio);
	if (socio == null) {
		System.out.println("El socio no se encuentra registrado en el sistema");
	} else {
		EliminarSocio(socio);
		System.out.println("El socio "+ dniSocio + " ha sido eliminado");
	}
}


// Se puede presentar el apto médico del socio en cualquier momento
public void presentarAptoMedico(Integer dniSocio, String fechaCertificado, String nombreProfesional, String observaciones){
	Socio socio = buscarSocio(dniSocio);
	if (socio == null) {
		System.out.println("El socio no se encuentra registrado en el sistema");
	} else {
		socio.agregarAptoMedico(fechaCertificado, nombreProfesional, observaciones);
		System.out.println("El apto medico del socio con credencial: "+ dniSocio + " ha sido actualizado");
	}
}

//FALTAN VER ESTOS TEMAS
/*cambiarAbono
anotarseAClase
eliminarClase*/
}