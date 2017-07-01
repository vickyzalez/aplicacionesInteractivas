package modelo;

import java.util.Vector;

public class ActividadSinProfesor extends Actividad{

	public ActividadSinProfesor(Integer idDep, Integer id, String desc){
		super.idActividad = id;
		super.descripcion = desc;
		super.idDeporte = idDep;
		super.clases = new Vector<ClaseAct>();
	}




}
