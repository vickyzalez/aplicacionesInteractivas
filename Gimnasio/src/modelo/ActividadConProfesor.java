package modelo;


public class ActividadConProfesor extends Actividad{
	
	private Profesor profesor;

	public ActividadConProfesor(int id, String nombre, String dia, Integer horaInicio, Integer horaFin) {
		super(id, nombre, dia, horaInicio, horaFin);
		// TODO Auto-generated constructor stub
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	

}
