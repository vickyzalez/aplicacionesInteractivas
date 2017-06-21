package modelo;

public class ProfesorConSueldo extends Profesor{

	private Float sueldo;
	
	public ProfesorConSueldo(Integer dni, String nombre,String apellido, String domicilio, String mail, Float sueldo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio = domicilio;
		this.mail = mail;
		this.dni = dni;
		this.sueldo = sueldo;
		//listado de clases
	}

	@Override
	public Float calcularSueldo(){
		return this.sueldo;
	}
	
	
}
