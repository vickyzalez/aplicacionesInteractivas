package modelo;
import java.util.ArrayList;

public class Cronograma {
private ArrayList<Actividad> actividades;

public Cronograma(){
	this.actividades = new ArrayList<Actividad>();
}

public boolean agregarActividad(Actividad actividad){
	return this.actividades.add(actividad);
}

public void limpiarCronograma(){
	this.actividades = new ArrayList<Actividad>();
}

public ArrayList<Actividad> getActividades() {
	return actividades;
}

public void setActividades(ArrayList<Actividad> actividades) {
	this.actividades = actividades;
}


}
