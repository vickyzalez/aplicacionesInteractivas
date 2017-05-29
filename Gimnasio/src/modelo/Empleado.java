package modelo;


public class Empleado extends Contratado {

	private Float sueldo; 
	
	public Empleado(Integer dni, String nombre,String apellido, String domicilio, String mail, Float sueldo){
		super(dni, nombre, apellido, domicilio, mail);
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
		//hacer el algoritmo
		return this.sueldo;
	}
    
}
