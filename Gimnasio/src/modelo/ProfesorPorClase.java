package modelo;

import java.util.Vector;

public class ProfesorPorClase extends Profesor {
	
	private Float valorPorHora;
	private Float retencion;
	private Float impuesto; //porcentaje = 21%
	private Vector<ClaseAct> clases;
	
	public ProfesorPorClase(Integer dni, String nombre,String apellido, String domicilio, String mail, 
			Float valorPorHora, Float retencion, Float impuesto) {
		super.nombre = nombre;
		super.apellido = apellido;
		super.domicilio = domicilio;
		super.mail = mail;
		super.dni = dni;
		this.valorPorHora = valorPorHora;
		this.retencion = retencion;
		this.impuesto = impuesto;
		this.clases = new Vector<ClaseAct>();
	}
	
	public void agregarClase(ClaseAct clase){
		this.clases.add(clase);
	}
	
	@Override
	public Float calcularSueldo(){
		
		Float montoHoras = 0f;
		
		for (ClaseAct claseAct : clases) {
			montoHoras = montoHoras + ((claseAct.getHoraHasta() - claseAct.getHoraDesde()) * (this.valorPorHora));
		}
		Float aPagar = (montoHoras - this.retencion) * (1- (this.impuesto/100));
		return aPagar;
	}

	public Float getValorPorHora() {
		return valorPorHora;
	}

	public void setValorPorHora(Float valorPorHora) {
		this.valorPorHora = valorPorHora;
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

	public Vector<ClaseAct> getClases() {
		return clases;
	}

	public void setClases(Vector<ClaseAct> clases) {
		this.clases = clases;
	}
    
	
	
}
