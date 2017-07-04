package modelo;

public class Recibo {
	private Integer dni;
	private Float sueldo;


	public Recibo(Integer dni, Float sueldo){
		this.dni = dni;
		this.sueldo = sueldo;
	}


	public Integer getDni() {
		return dni;
	}


	public void setDni(Integer dni) {
		this.dni = dni;
	}


	public Float getSueldo() {
		return sueldo;
	}


	public void setSueldo(Float sueldo) {
		this.sueldo = sueldo;
	}

	
	
}