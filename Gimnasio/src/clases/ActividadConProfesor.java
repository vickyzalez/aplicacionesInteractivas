package clases;


public class ActividadConProfesor extends Actividad{
	
	private Profesor profesor;

	public ActividadConProfesor(String dia, Integer horaInicio,
			Integer horaFin, Profesor profesor) {
		super(dia, horaInicio, horaFin, profesor);
		// TODO Auto-generated constructor stub
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	

}
