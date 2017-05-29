package modelo;

import java.util.ArrayList;

public class Actividad {
	private Integer idActividad;
	private ArrayList<HorarioActividad> horarios;
	
	public Actividad(){
		this.horarios = new ArrayList<HorarioActividad>();
	}
	
	public boolean agregarHorario(HorarioActividad horario){
		return this.horarios.add(horario);
	}
	
	public boolean eliminarHorario(HorarioActividad horario){
		return this.horarios.remove(horario);
	}

	public Integer getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(Integer idActividad) {
		this.idActividad = idActividad;
	}

	public ArrayList<HorarioActividad> getHorarios() {
		return horarios;
	}

	public void setHorarios(ArrayList<HorarioActividad> horarios) {
		this.horarios = horarios;
	}
	
	
}
