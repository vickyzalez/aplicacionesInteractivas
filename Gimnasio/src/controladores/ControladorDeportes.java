package controladores;
import java.util.ArrayList;

import modelo.Actividad;
import modelo.Cronograma;
import modelo.Deporte;
import modelo.Inscripcion;
import modelo.Socio;

public class ControladorDeportes {
private ArrayList<Inscripcion> inscripciones;
private Cronograma cronograma;
private ArrayList<Deporte> deportes;

public ControladorDeportes(){
	inscripciones = new ArrayList<Inscripcion>(0);
	deportes      = new ArrayList<Deporte>(0);
}

public void RealizarInscripcion(Socio s, ArrayList<Actividad> a){
	Inscripcion i = null;
	i.setSocio(s);
	i.setActividades(a);
	
	inscripciones.add(i);
}

public boolean AgregarDeporte (Deporte d){
	return this.deportes.add(d);
}
public boolean EliminarDeporte(Deporte d){
	return this.deportes.remove(d);
}
public void GenerarCronograma(){
	
}
}
