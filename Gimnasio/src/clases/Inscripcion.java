package clases;

import java.util.ArrayList;

public abstract class Inscripcion {
	
	private Abono abono;
	private ArrayList<Actividad> actividades;
	
	
	public Abono getAbono() {
		return abono;
	}
	public void setAbono(Abono abono) {
		this.abono = abono;
	}
	public ArrayList<Actividad> getActividades() {
		return actividades;
	}
	public void setActividades(ArrayList<Actividad> actividades) {
		this.actividades = actividades;
	}
	
	

}
