package modelo;


public class Empleado extends Contratado {

	private Float sueldo; 
	
	public Empleado(Integer dni, String nombre,String apellido, String domicilio, String mail, Float sueldo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio = domicilio;
		this.mail = mail;
		this.dni = dni;
		this.sueldo = sueldo;
	}
	
	public Float getSueldo() {
		return sueldo;
	}

	public void setSueldo(Float sueldo) {
		this.sueldo = sueldo;
	}


	@Override
	public Float calcularSueldo(){
		return this.sueldo;
	}
    
}
