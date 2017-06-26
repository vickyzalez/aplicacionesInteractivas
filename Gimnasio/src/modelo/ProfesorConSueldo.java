package modelo;

import java.util.Vector;

public class ProfesorConSueldo extends Profesor{

	private Float sueldo;
	private Float retencion;
	private Float impuesto; //porcentaje = 21%
	private Vector<Clase> clases;
	
	public ProfesorConSueldo(Integer dni, String nombre,String apellido, String domicilio, String mail, 
			Float sueldo, Float retencion, Float impuesto) {
		super.nombre = nombre;
		super.apellido = apellido;
		super.domicilio = domicilio;
		super.mail = mail;
		super.dni = dni;
		this.sueldo = sueldo;
		this.retencion = retencion;
		this.impuesto = impuesto;
		this.clases = new Vector<Clase>();
	}

	
	public void agregarClase(Clase clase){
		this.clases.add(clase);
	}
	
	
	@Override
	public Float calcularSueldo(){
			
			Float aPagar = (this.sueldo - this.retencion) * (this.impuesto/100);
			
			return aPagar;
		}


	public Float getSueldo() {
		return sueldo;
	}


	public void setSueldo(Float sueldo) {
		this.sueldo = sueldo;
	}


	public Float getRetencion() {
		return retencion;
	}


	public void setRetencion(Float retencion) {
		this.retencion = retencion;
	}


	public Float getImpuesto() {
		return impuesto;
	}


	public void setImpuesto(Float impuesto) {
		this.impuesto = impuesto;
	}


	public Vector<Clase> getClases() {
		return clases;
	}


	public void setClases(Vector<Clase> clases) {
		this.clases = clases;
	}
	
	
	
	
	
}
