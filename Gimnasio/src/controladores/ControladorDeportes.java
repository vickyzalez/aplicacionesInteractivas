package controladores;
import java.util.Vector;

import modelo.Cronograma;
import modelo.Deporte;
import persistencia.AdminPersistDeporte;

public class ControladorDeportes {
	private static ControladorDeportes instancia;
	private Cronograma cronograma;
	private Vector<Deporte> deportes;

	public ControladorDeportes(){
		deportes = AdminPersistDeporte.getInstancia().selectAll();
	}

	//Singleton
	public static ControladorDeportes getInstancia(){
		if (instancia == null){
			instancia = new ControladorDeportes();
		}
		return instancia;
	}

	Deporte buscarDeporteBuffer (Integer codigo){
		
		for (Deporte deporte : deportes) {
			if (deporte.getCodigo() == codigo) {
				return deporte;
			} else {
				Deporte dep = AdminPersistDeporte.getInstancia().buscarDeporte(codigo);
				if (dep == null){
					return null;
				} else {
					deportes.addElement(dep);
					return dep;
				}
			}
			
		}
		return null;
	}
	
	
	public void altaDeporte(Integer codigo, String titulo, String descripcion){
		Deporte deporte = new Deporte(codigo, titulo, descripcion);
		
		
	}
	
	//TODO método
		public void modificarDeporte(){
			
	}
		
	//TODO método
	public void bajaDeporte(){
		
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
