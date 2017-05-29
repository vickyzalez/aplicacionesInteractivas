package modelo;


public abstract class Profesor extends Contratado{
	
	public Profesor(Integer dni, String nombre,String apellido, String domicilio, String mail){
		super(dni, nombre, apellido, domicilio, mail);
    }
	
	public abstract Float calcularSueldo();
}
