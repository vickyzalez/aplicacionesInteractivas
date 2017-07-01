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
		Deporte dep = buscarDeporteBuffer(codigo);
		if (dep == null) {
			
			Deporte deporte =  new Deporte(codigo, titulo, descripcion);
			
			AdminPersistDeporte.getInstancia().insert(deporte);
			this.deportes.addElement(deporte);
			
		} else {
			System.out.println("El deporte ya est� dado de alta en el sistema");
		}
		
		
	}
	
	//TODO método
		public void modificarDeporte(Integer codigo, String titulo, String descripcion){
			Deporte dep = buscarDeporteBuffer(codigo);
			if (dep == null) {
				System.out.println("El deporte no se encuentra registrado en el sistema");
			} else {
				this.deportes.removeElement(dep);
				dep.setCodigo(codigo);
				dep.setTitulo(titulo);
				dep.setDescripcion(descripcion);
				
				AdminPersistDeporte.getInstancia().update(dep);
				this.deportes.addElement(dep);

				System.out.println("El deporte ha sido modificado");
			}
	}
		
	//TODO método
	public void bajaDeporte(){
		
	}
		
	//TODO método
	public void agregarActividad(){
		
	}
	
	//TODO método
	public void agregarClase
	(){
		
	}
	
	//TODO método, para poder generar notificaciones
	public void cancelarClaseDelDia(){

	}
	
	//TODO método
	public void generarCronograma(){
		
	}
}
