package modelo;

public class ProfesorConSueldo extends Profesor{

	private Float sueldo;
	
	public ProfesorConSueldo(Integer dni, String nombre, String apellido, String domicilio, String mail, Float sueldo) {
		super(dni, nombre, apellido, domicilio, mail);
		this.sueldo = sueldo;
	}

	@Override
	public Float calcularSueldo(){
		//hacer el algoritmo
		return this.sueldo;
	}
	
	
}
