package modelo;
import java.util.Vector;

// El cronograma tendra en cuenta que el gimnasio abre a las 8 y cierra a las 21. 
// Los horarios de las clases son enteros, no hay "y media"

public class Cronograma {
private Vector<ClaseAct> lunes;
private Vector<ClaseAct> martes;
private Vector<ClaseAct> miercoles;
private Vector<ClaseAct> jueves;
private Vector<ClaseAct> viernes;
private Vector<ClaseAct> sabado;


public Cronograma(){
	this.lunes = new Vector<ClaseAct>();
	this.martes = new Vector<ClaseAct>();
	this.miercoles = new Vector<ClaseAct>();
	this.jueves = new Vector<ClaseAct>();
	this.viernes = new Vector<ClaseAct>();
	this.sabado = new Vector<ClaseAct>();

}


public Vector<ClaseAct> getLunes() {
	return lunes;
}


public Vector<ClaseAct> getMartes() {
	return martes;
}


public Vector<ClaseAct> getMiercoles() {
	return miercoles;
}


public Vector<ClaseAct> getJueves() {
	return jueves;
}


public Vector<ClaseAct> getViernes() {
	return viernes;
}


public Vector<ClaseAct> getSabado() {
	return sabado;
}




}
