package clases;

public class DeporteConProfesor extends Deporte{

	private Profesor profesor;
	
	public DeporteConProfesor(Integer codigo, String titulo, String descripcion, Profesor profesor) {
		super(codigo, titulo, descripcion);
		
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	

}
