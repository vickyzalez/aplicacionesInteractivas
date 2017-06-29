package modelo;

import java.util.Vector;

public class ActividadSinProfesor extends Actividad{

	public ActividadSinProfesor(Integer id, String desc){
		super.idActividad = id;
		super.descripcion = desc;
		super.clases = new Vector<Clase>();
	}




}
