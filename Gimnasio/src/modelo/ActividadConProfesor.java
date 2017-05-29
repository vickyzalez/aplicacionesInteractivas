package modelo;


public class ActividadConProfesor extends Actividad{
	
	private Profesor profesor;

	public ActividadConProfesor(Profesor profesor){
		super();
		this.profesor= profesor;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	

}
