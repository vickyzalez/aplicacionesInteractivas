package modelo;

import java.util.Vector;

public class ProfesorConSueldo extends Profesor{

	private Float sueldo;
	private Float retencion;
	private Float impuesto; //porcentaje = 21%
	private Vector<Clase> clases;
	
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
			
			Float aPagar = (this.sueldo - this.retencion) * (this.impuesto/100);
			
			return aPagar;
		}
	
	
}
