package controladores;
import java.util.ArrayList;

import modelo.Actividad;
import modelo.Cronograma;
import modelo.Deporte;
import modelo.Inscripcion;
import modelo.Socio;

public class ControladorDeportes {
	private static ControladorDeportes instancia;
	private Cronograma cronograma;
	private ArrayList<Deporte> deportes;

	public ControladorDeportes(){
		deportes = new ArrayList<Deporte>(0);
	}

	//Singleton
	public static ControladorDeportes getInstancia(){
		if (instancia == null){
			instancia = new ControladorDeportes();
		}
		return instancia;
	}

	public boolean agregarDeporte (Deporte d){
		return this.deportes.add(d);
	}
	public boolean eliminarDeporte(Deporte d){
		return this.deportes.remove(d);
	}
	
	public Deporte altaDeporte(Integer codigo, String titulo, String descripcion){
		Deporte deporte = new Deporte(codigo, titulo, descripcion);
		agregarDeporte(deporte);
		return deporte;
		
	}
	
	//TODO método
		public void modificarDeporte(){
			
	}
		
	//TODO método
	public void agregarActividad(){
		
	}
	
	//TODO método, para poder generar notificaciones
	public void cancelarClaseDelDia(){

	}
	
	//TODO método
	public void generarCronograma(){
		
	}
}
