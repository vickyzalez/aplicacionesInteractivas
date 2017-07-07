package modelo;


public class Empleado extends Contratado {

	private Float sueldo;
	private Float retencion;
	private Float impuesto; //porcentaje = 21%
	
	public Empleado(Integer dni, String nombre,String apellido, String domicilio, String mail, 
			Float sueldo, Float retencion, Float impuesto) {
		super.nombre = nombre;
		super.apellido = apellido;
		super.domicilio = domicilio;
		super.mail = mail;
		super.dni = dni;
		this.sueldo = sueldo;
		this.retencion = retencion;
		this.impuesto = impuesto;
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

	@Override
	public Float calcularSueldo(){
		
		Float aPagar = (this.sueldo - this.retencion) * (1-(this.impuesto/100));
		
		return aPagar;
	}
    
}
