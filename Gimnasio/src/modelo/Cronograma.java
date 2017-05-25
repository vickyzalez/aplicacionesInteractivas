package modelo;
import java.util.ArrayList;

public class Cronograma {
private ArrayList<String> crono;
private ArrayList<Actividad> actividades;

public Cronograma(){
	crono.add("Cronograma");
}

public ArrayList<Actividad> getActividades() {
	return actividades;
}

public void setActividades(ArrayList<Actividad> actividades) {
	this.actividades = actividades;
}


}
