package modelo;

import java.util.ArrayList;

public abstract class Inscripcion {
	protected Socio socio; 
	protected ArrayList<Actividad> actividades;
	protected Abono abono;

	//TODO armar el composite con la inscripcion corporativa
//TODO ver este método
	public boolean agregarActividad(Actividad actividad){
		return this.actividades.add(actividad);
	}
	
	public boolean eliminarActividad(Actividad actividad){
		return this.actividades.remove(actividad);
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

}
