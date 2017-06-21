package modelo;

public class ProfesorPorClase extends Profesor {
	
	private Float valorPorHora;

	public ProfesorPorClase(Integer dni, String nombre,String apellido, String domicilio, String mail, Float valor) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio = domicilio;
		this.mail = mail;
		this.dni = dni;
		this.valorPorHora = valor;
		//listado clases
	}
	
	@Override
	public Float calcularSueldo(){
		//hacer el algoritmo
		return this.valorPorHora;
	}
    
	
}
