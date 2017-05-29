package modelo;

public class ProfesorPorClase extends Profesor {
	
	private Float valorPorHora;

	public ProfesorPorClase(Integer dni, String nombre,String apellido, String domicilio, String mail, Float valor) {
		super(dni, nombre, apellido, domicilio, mail);
		this.valorPorHora = valor;
	}
	
	@Override
	public Float calcularSueldo(){
		//hacer el algoritmo
		return this.valorPorHora;
	}
    
	
}
