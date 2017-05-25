package modelo;

import java.util.ArrayList;

import modelo.Abono;
import modelo.Actividad;
import modelo.InscripcionCorporativa;
import modelo.PagoMensual;
import modelo.Socio;

public abstract class Inscripcion {
	private String fecha;
	private Socio socio; 
	private ArrayList<Actividad> actividades;
	private Abono abono;
	private ArrayList<PagoMensual> pagos;
	private InscripcionCorporativa inscripCorp;

	public void Inscripcion(){
		this.fecha = "01.01.2000";
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public ArrayList<Actividad> getActividades() {
		return actividades;
	}

	public void setActividades(ArrayList<Actividad> actividades) {
		this.actividades = actividades;
	}

	public Abono getAbono() {
		return abono;
	}

	public void setAbono(Abono abono) {
		this.abono = abono;
	}

	public ArrayList<PagoMensual> getPagos() {
		return pagos;
	}

	public void setPagos(ArrayList<PagoMensual> pagos) {
		this.pagos = pagos;
	}

	public InscripcionCorporativa getInscripCorp() {
		return inscripCorp;
	}

	public void setInscripCorp(InscripcionCorporativa inscripCorp) {
		this.inscripCorp = inscripCorp;
	}

}
