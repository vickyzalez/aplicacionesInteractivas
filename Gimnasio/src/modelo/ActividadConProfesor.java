package modelo;

import java.util.Vector;

public class ActividadConProfesor extends Actividad{
	
	private Integer idProfe;

	public ActividadConProfesor(Integer id, String desc, Integer profesor){
		super.idActividad = id;
		super.descripcion = desc;
		this.idProfe= profesor;
		super.clases = new Vector<Clase>();
	}

	public Integer getProfesor() {
		return idProfe;
	}

	public void setProfesor(Integer profesor) {
		this.idProfe = profesor;
	}

	

}
