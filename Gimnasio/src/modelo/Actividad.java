package modelo;

import java.util.ArrayList;

public abstract class Actividad {
	private Integer idActividad;
	private ArrayList<Clase> clases;

	
	public boolean agregarHorario(Clase horario){
		return this.clases.add(horario);
	}
	
	public boolean eliminarHorario(Clase horario){
		return this.clases.remove(horario);
	}

	public Integer getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(Integer idActividad) {
		this.idActividad = idActividad;
	}

	public ArrayList<Clase> getClases() {
		return clases;
	}

	public void setHorarios(ArrayList<Clase> horarios) {
		this.clases = horarios;
	}
	
	
}
