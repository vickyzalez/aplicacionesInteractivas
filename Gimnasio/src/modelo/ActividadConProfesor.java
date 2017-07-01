package modelo;

import java.util.Vector;

public class ActividadConProfesor extends Actividad{
	
	private Integer idProfe;

	public ActividadConProfesor(Integer idDep, Integer id, String desc, Integer profesor){
		super.idActividad = id;
		super.idDeporte = idDep;
		super.descripcion = desc;
		this.idProfe= profesor;
		super.clases = new Vector<ClaseAct>();
	}

	public Integer getProfesor() {
		return idProfe;
	}

	public void setProfesor(Integer profesor) {
		this.idProfe = profesor;
	}

	

}
